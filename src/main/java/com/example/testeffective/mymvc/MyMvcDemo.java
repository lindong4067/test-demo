package com.example.testeffective.mymvc;

import com.example.testeffective.mymvc.servlet.MyDispatcherServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

public class MyMvcDemo {

    public static void main(String[] args) throws LifecycleException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        Tomcat tomcat = new Tomcat();
        tomcat.setHostname("localhost");
        tomcat.setPort(8080);
        tomcat.setBaseDir("C:\\Code");
        String contextPath = "";

        StandardContext context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());
        tomcat.getHost().addChild(context);

        MyDispatcherServlet servlet = new MyDispatcherServlet();
        tomcat.addServlet(contextPath, "myDispatcherServlet", servlet);
        context.addServletMappingDecoded("/*", "myDispatcherServlet");

        tomcat.start();
        tomcat.getServer().await();
    }
}
