package com.example.testframe.netty.getstart._8_http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.cookie.Cookie;
import io.netty.handler.codec.http.cookie.ServerCookieDecoder;
import io.netty.handler.codec.http.cookie.ServerCookieEncoder;
import io.netty.util.CharsetUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.netty.handler.codec.http.HttpResponseStatus.*;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

public class HttpSnoopServerHandler extends SimpleChannelInboundHandler<Object> {
    private HttpRequest request;
    private final StringBuilder buf = new StringBuilder();

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
//        System.err.println(msg);
        if (msg instanceof HttpRequest) {
            this.request = (HttpRequest) msg;

            if (HttpUtil.is100ContinueExpected(request)){
                send100Continue(ctx);
            }

            buf.setLength(0);
            buf.append("WELCOME TO THE WILD WILD WEB SERVER\r\n");
            buf.append("===================================\r\n");
            buf.append("VERSION: ").append(request.protocolVersion()).append("\r\n");
            buf.append("HOSTNAME: ").append(request.headers().get(HttpHeaderNames.HOST, "unknown")).append("\r\n");
            buf.append("REQUEST_URI: ").append(request.uri()).append("\r\n\r\n");

            HttpHeaders headers = request.headers();
            if (!headers.isEmpty()){
                for (Map.Entry<String, String> header : headers) {
                    String key = header.getKey();
                    String value = header.getValue();
                    buf.append("HEADER: ").append(key).append(" = ").append(value).append("\r\n");
                }
                buf.append("\r\n");
            }

            QueryStringDecoder decoder = new QueryStringDecoder(request.uri());
            Map<String, List<String>> parameters = decoder.parameters();
            if (!parameters.isEmpty()) {
                for (Map.Entry<String, List<String>> p : parameters.entrySet()) {
                    String key = p.getKey();
                    List<String> values = p.getValue();
                    for (String value : values) {
                        buf.append("PARAM: ").append(key).append(" = ").append(value).append("\r\n");
                    }
                }
                buf.append("\r\n");
            }
            appendDecoderResult(buf, request);
        }

        if (msg instanceof HttpContent) {
            HttpContent httpContent = (HttpContent) msg;
            ByteBuf content = httpContent.content();
            if (content.isReadable()) {
                buf.append("CONTENT: ");
                buf.append(content.toString(CharsetUtil.UTF_8));
                buf.append("\r\n");
                appendDecoderResult(buf, request);
            }

            if (msg instanceof LastHttpContent) {
                buf.append("END OF CONTENT\r\n");
                LastHttpContent trailer = (LastHttpContent) msg;

                HttpHeaders headers = trailer.trailingHeaders();
                if (!headers.isEmpty()) {
                    buf.append("\r\n");
                    Set<String> names = headers.names();
                    for (String name : names) {
                        List<String> values = headers.getAll(name);
                        for (String value : values) {
                            buf.append("TRAILING HEADER: ");
                            buf.append(name).append(" = ").append(value).append("\r\n");
                        }
                    }
                    buf.append("\r\n");
                }

                if (!writeResponse(trailer, ctx)) {
                    ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
                }
            }
        }
    }

    private boolean writeResponse(LastHttpContent trailer, ChannelHandlerContext ctx) {
        boolean keepAlive = HttpUtil.isKeepAlive(request);
        FullHttpResponse response = new DefaultFullHttpResponse(
        HTTP_1_1, trailer.decoderResult().isSuccess()? OK : BAD_REQUEST,
        Unpooled.copiedBuffer(buf.toString(), CharsetUtil.UTF_8));

        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain; charset=UTF-8");

        if (keepAlive) {
            response.headers().setInt(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
            response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
        }

        String cookieString = request.headers().get(HttpHeaderNames.COOKIE);
        if (cookieString != null) {
            Set<Cookie> cookies = ServerCookieDecoder.STRICT.decode(cookieString);
            if (!cookies.isEmpty()) {
                for (Cookie cookie : cookies) {
                    String cookieEncode = ServerCookieEncoder.STRICT.encode(cookie);
                    response.headers().add(HttpHeaderNames.SET_COOKIE, cookieEncode);
                }
            }
        } else {
            response.headers().add(HttpHeaderNames.SET_COOKIE, ServerCookieEncoder.STRICT.encode("key1", "value1"));
            response.headers().add(HttpHeaderNames.SET_COOKIE, ServerCookieEncoder.STRICT.encode("key2", "value2"));
        }

        ctx.write(response);
        return keepAlive;
    }

    private void appendDecoderResult(StringBuilder buf, HttpRequest request) {
        DecoderResult result = request.decoderResult();
        if (result.isSuccess()) {
            return;
        }
        buf.append(".. WITH DECODER FAILURE: ");
        buf.append(result.cause());
        buf.append("\r\n");
    }

    private void send100Continue(ChannelHandlerContext ctx) {
        FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, CONTINUE);
        ctx.write(response);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
