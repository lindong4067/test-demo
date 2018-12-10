package com.example.testeffective.mymvc.dao.impl;

import com.example.testeffective.mymvc.annotation.MyRepository;
import com.example.testeffective.mymvc.dao.UserDao;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@MyRepository("userDaoImpl")
public class UserDaoImpl implements UserDao {
    @Override
    public void insert() {
        log.debug("Execute UserDaoImpl insert()");
    }
}
