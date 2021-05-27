package com.example.onlineListener.dao;

import com.example.onlineListener.vo.LoginInfo;
import com.example.onlineListener.vo.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * xx
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/wenyio
 * @date: 2021/5/27
 * @see: com.example.onlineListener.dao
 * @version: v1.0.0
 */
public class LoginInfoDao {
    // 只允许同时在线一个 数据库 key：用户名，LoginInfo：登录信息
    private static Map<String, LoginInfo> loginInfoDB = new HashMap<>();

    /**
     * 获取所有的登录信息
     * @return
     */
    public static List<LoginInfo> listAll() {
        List<LoginInfo> loginInfoList = new ArrayList<>();
        loginInfoDB.forEach((name, loginInfo) -> {
            loginInfoList.add(loginInfo);
        });
        return loginInfoList;
    }

    /**
     * 保存登录信息
     * @param loginInfo
     */
    public static void save(LoginInfo loginInfo) {
        User user = loginInfo.getUser();
        if (null != user) {
            loginInfoDB.put(user.getUsername(), loginInfo);
        }
    }

    /**
     * 删除用户登录状态信息
     * @param user
     */
    public static void delete(User user) {
        LoginInfo loginInfo = loginInfoDB.get(user.getUsername());
        if (null != loginInfo) {
            loginInfoDB.remove(user.getUsername());
        }
    }

    /**
     * 判断是否登录
     * @param user
     * @return
     */
    public static Boolean isLogin(User user) {
        return null != loginInfoDB.get(user.getUsername());
    }
}
