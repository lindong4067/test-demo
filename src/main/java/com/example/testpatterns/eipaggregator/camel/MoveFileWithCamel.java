/*
 *         File : MoveFileWithCamel.java
 *    Classname : MoveFileWithCamel
 *    Author(s) : eznlzhi
 *      Created : 2018-08-30
 *
 *
 */

package com.example.testpatterns.eipaggregator.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class MoveFileWithCamel {
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("FileNIO:///C:/Temp/out/?delay=30000").to("FileNIO:///C:/Temp/in/");
            }
        });
        context.start();
        boolean loop = true;
        while(loop){
            Thread.sleep(25000);
        }
        context.stop();
    }
}
