package com.example.testeffective.mymvc.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRequestMapping {
    String value() default "";
}
