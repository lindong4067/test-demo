package com.example.testpatterns.chain.demo;

public class FaceFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.setMessage(request.getMessage() + " ===FaceFilter===>> ");
        response.setMessage(response.getMessage() + "===FaceFilter===>> ");
    }
}
