package com.example.testeffective.mymvc.controller;

import com.example.testeffective.mymvc.annotation.MyController;
import com.example.testeffective.mymvc.annotation.MyQualifier;
import com.example.testeffective.mymvc.annotation.MyRequestMapping;
import com.example.testeffective.mymvc.service.UserService;

@MyController("userController")
@MyRequestMapping("/user")
public class UserController {
    @MyQualifier("userServiceImpl")
    private UserService userService;
    @MyRequestMapping("/insert")
    public void insert() {
        userService.insert();
    }
}
