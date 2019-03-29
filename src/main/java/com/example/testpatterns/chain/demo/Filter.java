package com.example.testpatterns.chain.demo;

public interface Filter {
    void doFilter(Request request, Response response, FilterChain chain);
}
