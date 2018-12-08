package com.example.testeffective.mymvc.service.impl;

import com.example.testeffective.mymvc.annotation.MyQualifier;
import com.example.testeffective.mymvc.annotation.MyService;
import com.example.testeffective.mymvc.dao.UserDao;
import com.example.testeffective.mymvc.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@MyService("userServiceImpl")
public class UserServiceImpl implements UserService {
    @MyQualifier("userDaoImpl")
    private UserDao userDao;
    @Override
    public void insert() {
        log.debug("Before UserServiceImpl insert()");
        userDao.insert();
        log.debug("After UserServiceImpl insert()");
    }
}
