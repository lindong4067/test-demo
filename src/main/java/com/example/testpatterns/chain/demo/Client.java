package com.example.testpatterns.chain.demo;

public class Client {
    public static void main(String[] args) {
        Request request = new Request("Request:");
        Response response = new Response("Response:");

        FilterChain fc = new FilterChain();
        fc.addFilter(new HTMLFilter()).addFilter(new SensitiveFilter()).addFilter(new FaceFilter());

        fc.doFilter(request, response, fc);

        System.out.println(request.getMessage());
        System.out.println(response.getMessage());
    }
}
