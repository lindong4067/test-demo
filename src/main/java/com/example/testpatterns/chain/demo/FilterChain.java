package com.example.testpatterns.chain.demo;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {

    List<Filter> filterList = new ArrayList<>();

    public FilterChain addFilter(Filter filter) {
        if (filter != null && !filterList.contains(filter)) {
            filterList.add(filter);
        }
        return this;
    }

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        for (Filter filter : filterList) {
            filter.doFilter(request, response, chain);
        }
    }
}
