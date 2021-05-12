package com.example.mychapter10.util;

import com.example.mychapter10.domain.UserBean;

import java.util.HashMap;

public class DBUtil {
    private static DBUtil instance = new DBUtil();   //
    // 定义users集合，用于模拟数据库
    private HashMap<String, UserBean> users = new HashMap<String, UserBean>();

    private DBUtil() {
        // 向数据库(users)中存入两条数据
        UserBean user1 = new UserBean();
        user1.setName("zdd");
        user1.setPassword("123123");
        user1.setEmail("zdd@qq.com");
        users.put("zdd", user1);

        UserBean user2 = new UserBean();
        user2.setName("lbp");
        user2.setPassword("456789123!!");
        user2.setEmail("lbp@sina.com");
        users.put("lbp", user2);
        UserBean user3 = new UserBean();
        user2.setName("zs");
        user2.setPassword("123456");
        user2.setEmail("zs@sina.com");
        users.put("zs", user3);
        UserBean user4 = new UserBean();
        user2.setName("ls");
        user2.setPassword("654321");
        user2.setEmail("ls@sohu.com");
        users.put("ls", user4);
    }

    public static DBUtil getInstance() {
        return instance;
    }

    // 获取数据库(users)中的数据
    public UserBean getUser(String userName) {
        UserBean user = (UserBean) users.get(userName);
        return user;
    }

    // 向数据库(users)插入数据
    public boolean insertUser(UserBean user) {
        if (user == null) {
            return false;
        }
        String userName = user.getName();
        if (users.get(userName) != null) {
            return false;
        }
        users.put(userName, user);
        return true;
    }
}
