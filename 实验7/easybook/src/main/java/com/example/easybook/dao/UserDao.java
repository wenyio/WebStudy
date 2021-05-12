package com.example.easybook.dao;

import com.example.easybook.model.vo.User;
import com.example.easybook.util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * xx
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/wenyio
 * @date: 2021/4/25
 * @see: com.example.sms.dao
 * @version: v1.0.0
 */
public class UserDao {
    private String sql = "";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private ArrayList<User> users = new ArrayList<>();
    private User user;
    private Connection connection = null;

    private Connection getConn() {
        try {
            if ((connection == null) || connection.isClosed()) {
                DB db = new DB();
                connection = db.getConn();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public ArrayList<User> getByResultSet(ResultSet resultSet) {
        try {
            if (resultSet == null || !resultSet.next()) {
                return null;
            }
            users.clear();
            do {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setLockTime(new Date(resultSet.getTimestamp("lockTime").getTime() - 8 * 60 * 60 * 1000));
                user.setErrCount(resultSet.getInt("errCount"));
                users.add(user);
            } while(resultSet.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void close() {
        try {
            if (resultSet != null)
                resultSet.close();
            if (preparedStatement != null)
                preparedStatement.close();
            if (connection != null)
                connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            resultSet = null;
            preparedStatement = null;
            connection = null;
        }
    }

    public User getByUserName(String name) {
        getConn();
        if (name == null) {
            name = "";
        }
        sql = "select * from user where username=?";
        try {
            preparedStatement = getConn().prepareStatement(sql);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<User> res = getByResultSet(resultSet);
        return res != null && res.size() > 0 ? res.get(0) : null;
    }

    public Boolean saveUser(User save) {
        int result = 0;
        User check = getByUserName(save.getUsername());
        try {
            if (check != null) {
                sql = "update user set errCount=?,lockTime=? where username=?";
                preparedStatement = getConn().prepareStatement(sql);
                preparedStatement.setInt(1, save.getErrCount());
                preparedStatement.setTimestamp(2, new Timestamp(save.getLockTime().getTime() + 8 * 60 * 60 * 1000));
                preparedStatement.setString(3, save.getUsername());
            } else {
                sql = "insert into user(username,password,lockTime) values(?,?,?)";
                preparedStatement = getConn().prepareStatement(sql);
                preparedStatement.setString(1, save.getUsername());
                preparedStatement.setString(2, save.getPassword());
                preparedStatement.setTimestamp(3, new Timestamp(save.getLockTime().getTime() + 8 * 60 * 60 * 1000));
            }
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return result > 0;
    }

}
