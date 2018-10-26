package com.example.testpatterns.promise.jpromise.container.spring;

import com.example.testpatterns.promise.jpromise.core.Promise;
import org.springframework.beans.factory.InitializingBean;

import java.util.concurrent.ExecutorService;

/**
 * 可以基于Spring容器来配置Promise使用的线程池服务
 * @author float.lu
 */
public class PromiseConfigure implements InitializingBean {
    /**
     * 使用Spring容器的时候可以自定义线程池服务
     */
    ExecutorService executorService;

    @Override
    public void afterPropertiesSet() throws Exception {
        Promise.setExecutorService(executorService);
    }

    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }
}
