package com.example.testeffective.myrpc.provider;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RpcInvokeHandler extends ChannelInboundHandlerAdapter {
    // 接口方法唯一标识对应的Method对象
    private Map<String, Method> interfaceMethods;

    // 接口对应的实现类
    private Map<Class, Object> interfaceToInstance;

    //线程池
    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            10,
            50,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(100),
            r -> {
                AtomicInteger i = new AtomicInteger(0);
                return new Thread(r, "IO-Thread-" + i.incrementAndGet());
            }
    );

    public RpcInvokeHandler(List<ServiceConfig> serverConfigs, Map<String, Method> interfaceMethods) {
        this.interfaceToInstance = new ConcurrentHashMap<>();
        this.interfaceMethods = interfaceMethods;
        for (ServiceConfig serverConfig : serverConfigs) {
            interfaceToInstance.put(serverConfig.getType(), serverConfig.getInstance());
        }
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            String message = (String)msg;
            System.out.println("Received message : " + message);
            RpcRequest request = RpcRequest.parse(message, ctx);
            threadPoolExecutor.execute(new RpcInvokeTask(request));
            super.channelRead(ctx, msg);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("Exception caught!");
        cause.printStackTrace();
        ctx.close();
    }

    public class RpcInvokeTask implements Runnable {
        private RpcRequest request;

        public RpcInvokeTask(RpcRequest request) {
            this.request = request;
        }

        @Override
        public void run() {
            try {
                String identity = request.getInterfaceIdentity();
                Method method = interfaceMethods.get(identity);
                Map<String, String> map = stringToMap(identity);
                String anInterface = map.get("interface");
            } catch (Exception e) {

            }
        }

        public  Map<String, String> stringToMap(String str) {
            String[] split = str.split("&");
            Map<String, String> map = new HashMap<>(16);
            for (String s : split) {
                String[] split1 = s.split("=");
                map.put(split1[0], split1[1]);
            }
            return map;
        }
    }
}
