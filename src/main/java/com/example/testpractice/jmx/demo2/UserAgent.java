package com.example.testpractice.jmx.demo2;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.time.LocalTime;
import java.util.Date;

public class UserAgent implements NotificationListener {

    public UserAgent() {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        MBeanServer mBeanServer1 = MBeanServerFactory.createMBeanServer("Hello");
        try {
            ObjectName name = new ObjectName("UserAgent:type=User1");
            User user = new User();
            user.setName("test");
            user.setId(1);
            user.setBirthDate(new Date());
            user.setTime(LocalTime.now());
            Test test = new Test();
            test.setName("mytest");
            test.setAge(11);
            user.setTest(test);
            mBeanServer.registerMBean(user, name);
            mBeanServer1.registerMBean(user, new ObjectName("Hello:type=user"));
            Thread.sleep(Long.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleNotification(Notification notification, Object handback) {

    }
}
