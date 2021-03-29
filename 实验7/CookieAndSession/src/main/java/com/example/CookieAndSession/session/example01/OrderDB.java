package com.example.CookieAndSession.session.example01;

import com.example.CookieAndSession.session.example02.User;
import com.sun.org.apache.xpath.internal.operations.Or;

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
public class OrderDB {
    // 存放用户的所有订单
    private static Map<User, List<Order>> orders = new LinkedHashMap<>();
    static {
//        orders.put(new User(), new ArrayList<Order>());
    }
    // 获得所有的订单
    public static Collection<List<Order>> getAll() {
        return orders.values();
    }

    // 获取用户的所有订单
    public static List<Order> getOrderByUser(User user) {
        return orders.get(user);
    }

    // 添加订单
    public static void addOrder(User user, List<Order> order) {
        orders.put(user, order);
    }
}
