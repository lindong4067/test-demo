package com.example.testframe.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
public class CustomStringEventConfig {
    @Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster simple(){
        SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new
                SimpleApplicationEventMulticaster();
        simpleApplicationEventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return simpleApplicationEventMulticaster;
    }
}
