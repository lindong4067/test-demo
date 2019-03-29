package com.example.testpatterns.chain.demo;

public class HTMLFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.setMessage(request.getMessage() + " ===HTMLFilter===>> ");
        response.setMessage(response.getMessage() + "===HTMLFilter===>> ");
    }
}
