package com.example.testpatterns.chain.demo;

public class SensitiveFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.setMessage(request.getMessage() + " ===SensitiveFilter===>> ");
        response.setMessage(response.getMessage() + "===SensitiveFilter===>> ");
    }
}
