package com.example.testdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ThreadLocalTest {
    private static ThreadLocal<Connection> connectionHolder = ThreadLocal.withInitial(() -> {
        try {
            return DriverManager.getConnection("http://127.0.0.1:3306/mysql");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    });

    public static Connection getConnection() {
        return connectionHolder.get();
    }
}
