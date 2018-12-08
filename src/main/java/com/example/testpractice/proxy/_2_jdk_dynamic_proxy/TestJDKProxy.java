package com.example.testpractice.proxy._2_jdk_dynamic_proxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Slf4j
public class TestJDKProxy {

    @Test
    public void test(){
        UserService target = new UserServiceImpl();

        UserService userService = (UserService) Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            (proxy, method, args) -> {
                Object invoke = method.invoke(target, args);
                if (invoke != null){
                    return invoke.toString().toUpperCase();
                }
                return null;
            }
        );
        log.debug(userService.doFirst());
        userService.doSecond();
    }
}
