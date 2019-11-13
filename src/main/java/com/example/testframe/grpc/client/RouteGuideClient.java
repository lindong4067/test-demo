//package com.example.testframe.grpc.client;
//
//
//import com.example.testframe.grpc.util.RouteGuideUtil;
//import io.grpc.ManagedChannel;
//import io.grpc.ManagedChannelBuilder;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//public class RouteGuideClient {
//    private final ManagedChannel channel;
//    private final RouteGuideGrpc.RouteGuideBlockingStub blockingStub;
//    private final RouteGuideGrpc.RouteGuideStub asyncStub;
//
//    private Random random = new Random();
//
//    public RouteGuideClient(String host, int port) {
//        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
//    }
//
//    public RouteGuideClient(ManagedChannelBuilder<?> channelBuilder) {
//        channel = channelBuilder.build();
//        blockingStub = RouteGuideGrpc.newBlockingStub(channel);
//        asyncStub = RouteGuideGrpc.newStub(channel);
//    }
//
//    public void shutdown() throws InterruptedException {
//        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
//    }
//
//    public static void main(String[] args) {
//        List<Feature> features;
//        try {
//            features = RouteGuideUtil.parseFeatures(RouteGuideUtil.getDefaultFeaturesFile());
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            return;
//        }
//
//        RouteGuideClient client = new RouteGuideClient("localhost", 8980);
//
//        client.getFeature(407838351, -746143763);
//        client.getFeature(0, 0);
//    }
//
//    private void getFeature(int lat, int lon) {
//        System.out.printf("*** GetFeature: lat={%s} lon={%s}", lat, lon);
//
//        Point request = Point.newBuilder().setLatitude(lat).setLongitude(lon).build();
//
//        Feature feature = blockingStub.getFeature(request);;
//
//        System.out.println(feature.toString());
//    }
//}
