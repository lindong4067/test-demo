//package com.example.testframe.grpc.util;
//
//import com.example.testframe.grpc.server.RouteGuideServer;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//
//public class RouteGuideUtil {
//
//    public static URL getDefaultFeaturesFile() {
//        return RouteGuideServer.class.getResource("route_guide_db.json");
//    }
//
//    public static List<Feature> parseFeatures(URL file) throws IOException {
//        List<Feature> features = new ArrayList<>();
//        features.add(Feature.newBuilder()
//                .setName("Patriots Path, Mendham, NJ 07945, USA")
//                .setLocation(Point.newBuilder()
//                        .setLatitude(407838351)
//                        .setLongitude(-746143763)
//                        .build())
//                .build());
//
//        features.add(Feature.newBuilder()
//                .setName("101 New Jersey 10, Whippany, NJ 07981, USA")
//                .setLocation(Point.newBuilder()
//                        .setLatitude(408122808)
//                        .setLongitude(-743999179)
//                        .build())
//                .build());
//
//        features.add(Feature.newBuilder()
//                .setName("5 Conners Road, Kingston, NY 12401, USA")
//                .setLocation(Point.newBuilder()
//                        .setLatitude(419999544)
//                        .setLongitude(-740371136)
//                        .build())
//                .build());
//        return features;
//    }
//}
