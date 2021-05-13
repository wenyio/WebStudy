package com.example.shopping.servlet;

import com.example.shopping.dao.GoodsDao;
import com.example.shopping.dao.GoodsShopCartDao;
import com.example.shopping.dao.ShopCartDao;
import com.example.shopping.pojo.Goods;
import com.example.shopping.pojo.GoodsShopCart;
import com.example.shopping.pojo.ShopCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * xx
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/wenyio
 * @date: 2021/5/13
 * @see: com.example.shopping.servlet
 * @version: v1.0.0
 */
@WebServlet(value = "/move")
public class MoveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShopCart shopCart = ShopCartDao.getById(1);  // 默认1号购物车 TODO 按需求更改
        String action = req.getParameter("action");// 操作 移除还是 加入 clear
        if ("clear".equals(action)) {
            GoodsShopCartDao.clear(shopCart.getId());
            resp.sendRedirect(req.getHeader("Referer")); // 回到上一个页面
            return;
        }
        // TODO 这边有可能空指针
        Integer goodsId = Integer.valueOf(req.getParameter("goodsId"));// 商品ID
        Integer num = Integer.valueOf(req.getParameter("num"));// 数量
        if (goodsId == null || num == null || action == null) {
            resp.sendRedirect(req.getHeader("Referer")); // 回到上一个页面
        }
        Goods goods = GoodsDao.getById(goodsId);

        if (goods == null) {
            resp.sendRedirect(req.getHeader("Referer")); // 回到上一个页面
        }
        GoodsShopCart goodsShopCart = GoodsShopCartDao.getByShopCartIdAndGoodsId(shopCart.getId(), goodsId);
        if (goodsShopCart == null) {
            goodsShopCart = new GoodsShopCart();
            goodsShopCart.setGoods(goods);
            goodsShopCart.setPrice(goods.getPrice());
            goodsShopCart.setShopCart(shopCart);
        }
        switch (action) {
            case "out":
                GoodsShopCartDao.moveOutCart(goodsShopCart, num);
                break;
            case "in":
                GoodsShopCartDao.moveInCart(goodsShopCart, num);
                break;
            default:
        }
        resp.sendRedirect(req.getHeader("Referer")); // 回到上一个页面
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
