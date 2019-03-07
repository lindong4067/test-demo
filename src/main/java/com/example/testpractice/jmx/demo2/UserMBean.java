package com.example.testpractice.jmx.demo2;

import java.time.LocalTime;
import java.util.Date;

public interface UserMBean {
    void setId(Integer id);
    Integer getId();
    void setName(String name);
    String getName();
    void setBirthDate(Date date);
    Date getBirthDate();
    void setTime(LocalTime time);
    LocalTime getTime();
    void printUserInfo();
    Date currentDate();
    void setTest(Test test);
    Test getTest();
}
