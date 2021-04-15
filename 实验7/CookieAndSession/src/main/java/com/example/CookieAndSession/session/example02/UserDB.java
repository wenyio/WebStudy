package com.example.CookieAndSession.session.example02;

import com.example.CookieAndSession.session.example01.Order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * xx
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/wenyio
 * @date: 2021/3/29
 * @see: com.example.CookieAndSession.session.example01
 * @version: v1.0.0
 */
public class UserDB {
    // 存放用户的所有订单
    private static Map<String, User> users = new LinkedHashMap<>();
    static {
        users.put("user01", new User("user01", "123"));
        users.put("user02", new User("user02", "456"));
        users.put("user03", new User("user03", "789"));
    }

    // 获取用户的所有订单
    public static User getUserByName(String name) {
        return users.get(name);
    }

    public static void saveUser(User user) {
        User check = getUserByName(user.getUsername());
        if (check != null) {
            users.put(user.getUsername(), user);
        }
    }
}
