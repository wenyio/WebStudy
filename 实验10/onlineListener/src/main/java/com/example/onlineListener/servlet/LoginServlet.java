package com.example.onlineListener.servlet;

import com.example.onlineListener.constant.ContentType;
import com.example.onlineListener.dao.LoginInfoDao;
import com.example.onlineListener.dao.UserDao;
import com.example.onlineListener.util.IpUtil;
import com.example.onlineListener.vo.LoginInfo;
import com.example.onlineListener.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

	private UserDao userDao;

	/**
	 * 添加了验证码
	 */
	public void doGet(HttpServletRequest request,HttpServletResponse response)
				throws ServletException, IOException {
		userDao = new UserDao();
		response.setContentType(ContentType.HTML_UTF8);

		if (request.getSession().getAttribute("user") != null) {
			response.sendRedirect("/main");
		}

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkCode = request.getParameter("check_code");
		String savedCode = (String) request.getSession().getAttribute(
				"check_code");
		PrintWriter pw = response.getWriter();
		User user = userDao.getByUserName(username);
		if (user == null) {
			pw.write("无此用户");
			return;
		}
		if (user.getLockTime() == null || user.getLockTime().getTime() < new Date().getTime()) {
			if (user.getPassword().equals(password) && checkCode.equals(savedCode)) {
				if (LoginInfoDao.isLogin(user)) {
					pw.write("已经在其他设备登录");
					return;
				}
				user.setErrCount(0);
				userDao.saveUser(user);
				request.getSession().setAttribute("user", user);

				// 记录登录状态
				LoginInfoDao.save(new LoginInfo(user, request.getHeader("User-Agent"), IpUtil.getIp(request), new Date()));
				response.sendRedirect("/main");
			} else if (checkCode.equals(savedCode)) {
				user.setErrCount(user.getErrCount() + 1);
				if (user.getErrCount() >= 3) {
					Date lockTime = new Date(new Date().getTime() + 60 * 1000 * 2);
					user.setLockTime(lockTime);
					pw.write("你已被锁定，" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lockTime) + "后可以重新登录");
				} else {
					pw.write("用户名或密码错误，登录失败，你还有" + (3 - user.getErrCount()) + "次机会");
				}
				userDao.saveUser(user);
			} else {
				pw.write("验证码错误");
			}
		} else {
			pw.write("你已被锁定，" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(user.getLockTime()) + "后可以重新登录");
		}

	}
	public void doPost(HttpServletRequest request,
                           HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
