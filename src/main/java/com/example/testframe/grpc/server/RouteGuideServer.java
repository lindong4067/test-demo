//package com.example.testframe.grpc.server;
//
//import com.example.testframe.grpc.util.RouteGuideUtil;
//import io.grpc.Server;
//import io.grpc.ServerBuilder;
//import io.grpc.stub.StreamObserver;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.Collection;
//
//public class RouteGuideServer {
//    private final int port;
//    private Server server;
//
//    public RouteGuideServer(int port) {
//        this.port = port;
//    }
//
//    public RouteGuideServer(ServerBuilder<?> serverBuilder, int port, Collection<Feature> features) {
//        this.port = port;
//        server = serverBuilder.addService(new RouteGuideService(features))
//                .build();
//    }
//
//    public RouteGuideServer(int port, URL featureFile) throws IOException {
//        this(ServerBuilder.forPort(port), port, RouteGuideUtil.parseFeatures(featureFile));
//    }
//
//    public void start() throws IOException {
//        server.start();
//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            System.err.println("*** shutting down gRPC server since JVM is shutting down");
//            RouteGuideServer.this.stop();
//            System.err.println("*** server shut down");
//        }));
//    }
//
//    public void stop() {
//        if (server != null) {
//            server.shutdown();
//        }
//    }
//
//    private void blockUntilShutdown() throws InterruptedException {
//        if (server != null) {
//            server.awaitTermination();
//        }
//    }
//
//    public static void main(String[] args) throws IOException, InterruptedException {
//        RouteGuideServer server = new RouteGuideServer(8980);
//        server.start();
//        server.blockUntilShutdown();
//    }
//
//    private static class RouteGuideService extends RouteGuideGrpc.RouteGuideImplBase {
//        private final Collection<Feature> features;
//
//        private RouteGuideService(Collection<Feature> features) {
//            this.features = features;
//        }
//
//        @Override
//        public void getFeature(Point request, StreamObserver<Feature> responseObserver) {
//            responseObserver.onNext(checkFeature(request));
//            responseObserver.onCompleted();
//        }
//
//        private Feature checkFeature(Point request) {
//            for (Feature feature : features) {
//                if (feature.getLocation().getLatitude() == request.getLatitude()
//                && feature.getLocation().getLongitude() == request.getLongitude()) {
//                    return feature;
//                }
//            }
//            return Feature.newBuilder().setName("").setLocation(request).build();
//        }
//    }
//
//}
