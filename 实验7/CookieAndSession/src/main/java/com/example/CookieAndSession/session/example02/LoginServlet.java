package com.example.CookieAndSession.session.example02;
import java.io.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class LoginServlet extends HttpServlet {
	/**
	 * 未添加验证码
	 */
//	public void doGet(HttpServletRequest request,
//                          HttpServletResponse response)
//			throws ServletException, IOException {
//		response.setContentType("text/html;charset=utf-8");
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		PrintWriter pw = response.getWriter();
//          //假设正确的用户名 是itcast 密码是123
//		if (("itcast").equals(username) && ("123").equals(password)) {
//			User user = new User();
//			user.setUsername(username);
//			user.setPassword(password);
//			request.getSession().setAttribute("user", user);
//			response.sendRedirect("/IndexServlet");
//		} else {
//			pw.write("用户名或密码错误，登录失败");
//		}
//	}
	/**
	 * 添加了验证码
	 */
	public void doGet(HttpServletRequest request,HttpServletResponse response)
				throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String checkCode = request.getParameter("check_code");
			String savedCode = (String) request.getSession().getAttribute(
					"check_code");
			PrintWriter pw = response.getWriter();
			User user = (User) request.getSession().getAttribute("user");
			if (user == null) {
				user = new User();
			}
			if (user.getLockTime() == null || user.getLockTime().getTime() < new Date().getTime()) {
				if (("weny").equals(username) && ("123").equals(password) && checkCode.equals(savedCode)) {
					user.setUsername(username);
					user.setPassword(password);
					user.setErrCount(0);
					request.getSession().setAttribute("user", user);
					response.sendRedirect("/IndexServlet");
				} else if (checkCode.equals(savedCode)) {
					user.setErrCount(user.getErrCount() + 1);
					if (user.getErrCount() >= 5) {
						Date lockTime = new Date(new Date().getTime() + 60 * 1000 * 10);
						user.setLockTime(lockTime);
						pw.write("你已被锁定，" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lockTime) + "后可以重新登录");
					} else {
						pw.write("用户名或密码错误，登录失败，你还有" + (5 - user.getErrCount()) + "次机会");
					}
					request.getSession().setAttribute("user", user);
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
