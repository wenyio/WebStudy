package com.example.shopping.dao;

import com.example.shopping.pojo.GoodsShopCart;
import com.example.shopping.pojo.ShopCart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * xx
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/wenyio
 * @date: 2021/5/13
 * @see: com.example.shopping.dao
 * @version: v1.0.0
 */
public class ShopCartDao {
    private static Map<Integer, ShopCart> shopCartDB = new HashMap<>();

    static {
        shopCartDB.put(1, new ShopCart(1, 0d));
    }

    public static void update(ShopCart shopCart) {
        if (shopCart.getId() != null && getById(shopCart.getId()) != null) {
            shopCartDB.put(shopCart.getId(), shopCart);
        }
    }

    public static ShopCart getById(Integer id) {
        return shopCartDB.get(id);
    }

    public static void refresh(Integer shopCartId) {
        ShopCart shopCart = ShopCartDao.getById(shopCartId);
        List<GoodsShopCart> goodsShopCarts = GoodsShopCartDao.findByShopCart(shopCartId);
        Double total = 0d;
        for (GoodsShopCart cart : goodsShopCarts) {
            total += cart.getPrice() * cart.getNum();
        }
        shopCart.setTotalPrice(total);
        ShopCartDao.update(shopCart);
    }
}
