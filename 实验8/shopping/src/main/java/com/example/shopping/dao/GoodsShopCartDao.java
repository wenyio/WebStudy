package com.example.shopping.dao;

import com.example.shopping.pojo.Goods;
import com.example.shopping.pojo.GoodsShopCart;
import com.example.shopping.pojo.ShopCart;

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
 * @date: 2021/5/13
 * @see: com.example.shopping.dao
 * @version: v1.0.0
 */
public class GoodsShopCartDao {
    private static Map<Integer, GoodsShopCart> goodsShopCartDB = new HashMap<>();
    private static Integer id = 0;

    public static List<GoodsShopCart> findByShopCart(Integer shopCartId) {
        List<GoodsShopCart> list = new ArrayList<>(goodsShopCartDB.values());
        List<GoodsShopCart> result = new ArrayList<>();
        for (GoodsShopCart goodsShopCart : list) {
            if (goodsShopCart.getShopCart().getId().equals(shopCartId)) {
                result.add(goodsShopCart);
            }
        }
        return result;
    }

    public static GoodsShopCart getByShopCartIdAndGoodsId(Integer shopCartId, Integer goodsId) {
        GoodsShopCart result = null;
        List<GoodsShopCart> goodsShopCartList = findByShopCart(shopCartId);
        for (GoodsShopCart goodsShopCart : goodsShopCartList) {
            if (goodsShopCart.getGoods().getId().equals(goodsId)) {
                result  = goodsShopCart;
            }
        }
        return result;
    }

    public static void update(GoodsShopCart goodsShopCart) {
        if (goodsShopCart.getId() == null) {
            id++;
            goodsShopCart.setId(id);
        }
        goodsShopCartDB.put(goodsShopCart.getId(), goodsShopCart);
    }

    public static GoodsShopCart getById(Integer id) {
        return goodsShopCartDB.get(id);
    }

    /**
     *  移出购物车
     * @param goodsShopCart
     * @param num
     */
    public static void moveOutCart(GoodsShopCart goodsShopCart, Integer num) {
        // 更新商品
        Goods goods = GoodsDao.getById(goodsShopCart.getGoods().getId());
        if (goods == null || num <= 0) {
            return;
        }
        if (goods.getMargin() + num > goods.getTotal()) {
            return;
        }
        // 如果小于等于总量，说明合理，超出总量，说明数据异常
        goods.setMargin(goods.getMargin() + num);

        // 更新GoodsShopCart
        if (goodsShopCart.getNum() - num < 0) {
            return;
        }
        goodsShopCart.setNum(goodsShopCart.getNum() - num);
        if (goodsShopCart.getNum() > 0) {
            GoodsShopCartDao.update(goodsShopCart);
        } else {
            // 小于等于0就移除去
            goodsShopCartDB.remove(goodsShopCart.getId());
        }

        GoodsDao.update(goods);
        // 刷新（更新）ShopCart
        ShopCartDao.refresh(goodsShopCart.getShopCart().getId());
    }

    /**
     * 移入购物车
     * @param goodsShopCart
     * @param num
     */
    public static void moveInCart(GoodsShopCart goodsShopCart, Integer num) {
        // 更新商品
        Goods goods = GoodsDao.getById(goodsShopCart.getGoods().getId());
        if (goods == null || num <= 0) {
            return;
        }
        // 如果 余量不够 返回
        if (goods.getMargin() - num < 0) {
            return;
        }
        goods.setMargin(goods.getMargin() - num);

        // 更新GoodsShopCart
        goodsShopCart.setNum(goodsShopCart.getNum() + num);
        GoodsShopCartDao.update(goodsShopCart);

        GoodsDao.update(goods);
        // 刷新（更新）ShopCart
        ShopCartDao.refresh(goodsShopCart.getShopCart().getId());
    }

    public static void clear(Integer shopCartId) {
        ShopCart shopCart = ShopCartDao.getById(shopCartId);
        shopCart.setTotalPrice(0d);
        ShopCartDao.update(shopCart);

        List<GoodsShopCart> list = findByShopCart(shopCartId);
        for (GoodsShopCart goodsShopCart : list) {
            goodsShopCartDB.remove(goodsShopCart.getId());
        }
    }
}
