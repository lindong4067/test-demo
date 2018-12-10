package com.example.testpractice.proxy._3_cglib_dynamic_proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class UserServiceInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object obj = methodProxy.invokeSuper(o, objects);
        if (obj != null) {
            return obj.toString().toUpperCase();
        }
        return obj;
    }

    public UserService myCglibCreater(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(this);
        return (UserService) enhancer.create();
    }
}
