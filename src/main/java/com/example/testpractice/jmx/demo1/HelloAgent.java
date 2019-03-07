package com.example.testpractice.jmx.demo1;

import javax.management.*;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloAgent {
    public static void main(String[] args) throws Exception {
        //create mbean server
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        //create object name
        ObjectName objectName = new ObjectName("jmxBean:name=hello");
        //create mbean and register mbean
        mBeanServer.registerMBean(new Hello(), objectName);

        Registry registry = LocateRegistry.createRegistry(1099);
        JMXServiceURL jmxServiceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
        JMXConnectorServer cs = JMXConnectorServerFactory.newJMXConnectorServer(jmxServiceURL, null, mBeanServer);
        cs.start();
    }
}
