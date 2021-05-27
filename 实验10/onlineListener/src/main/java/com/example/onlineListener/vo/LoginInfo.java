package com.example.onlineListener.vo;

import java.util.Date;

/**
 * xx
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/wenyio
 * @date: 2021/5/27
 * @see: com.example.onlineListener.vo
 * @version: v1.0.0
 */
public class LoginInfo {
    private User user;
    private String agent; // User-Agent 用户浏览器信息
    private String ip; // 用户ip信息
    private Date loginTime;

    public LoginInfo(User user, String agent, String ip, Date loginTime) {
        this.user = user;
        this.agent = agent;
        this.ip = ip;
        this.loginTime = loginTime;
    }

    public LoginInfo() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
