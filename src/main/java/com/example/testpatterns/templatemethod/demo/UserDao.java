package com.example.testpatterns.templatemethod.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends AbstractDao {
    public User findUser(int userId) {
        String sql = "select * from user where user_id = ?";
        Object[] params = new Object[]{ userId };
        Object user = find(sql, params);
        return (User) user;
    }

    @Override
    protected Object rowMapper(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("userId"));
        user.setName(rs.getString("name"));
        user.setAge(rs.getInt("age"));
        user.setSex(rs.getString("sex"));
        user.setAddress(rs.getString("address"));
        return user;
    }
}
