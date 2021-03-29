 package com.example.CookieAndSession.session.example01;
 import com.example.CookieAndSession.session.example02.User;

 import java.io.IOException;
 import java.util.*;
 import javax.servlet.ServletException;
 import javax.servlet.http.*;
 public class PurchaseServlet extends HttpServlet {
 	private static final long serialVersionUID = 1L;
 	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 创建或者获得用户的Session对象
		HttpSession session = req.getSession();
		// 获得用户购买的商品
		String id = req.getParameter("id");
		int amount = Integer.parseInt(req.getParameter("amount"));

		if (id == null) {
			// 如果id为null，重定向到ListBookServlet页面
			String url = "/ListBookServlet";
			resp.sendRedirect(url);
			return;
		}

		Book book = BookDB.getBook(id);
		User user = (User)session.getAttribute("user");
		Order order = new Order(user, book, amount);
		List<Order> cart = OrderDB.getOrderByUser(user);
		// 获得用户的购物车
		if (cart == null) {
			// 首次购买，为用户创建一个购物车(List集合模拟购物车)
			cart = new ArrayList<Order>();
		}

		// 购物车里是否已经有了
		boolean had = false;
		// 更新购物车内商品的数量
		for (Order or : cart) {
			if (or.getBook() == book) {
				or.setAmount(amount + or.getAmount());
				had = true;
				break;
			}
		}
		if (!had) {
			// 将商品放入购物车
			cart.add(order);
		}

		OrderDB.addOrder(user, cart); // 更新购物车
		// 将购物城存入Session对象
		session.setAttribute("cart", cart);
		// 创建Cookie存放Session的标识号
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(60 * 30);
		cookie.setPath("/");
		resp.addCookie(cookie);
		// 重定向到购物车页面
		String url = "/CartServlet";
		String newurl=resp.encodeRedirectURL(url);
		resp.sendRedirect(newurl);
	}
}
