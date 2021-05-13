package com.example.shopping.dao;

import com.example.shopping.pojo.Goods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
public class GoodsDao {
    private static Map<Integer, Goods> goodsDB = new HashMap<>();

    static {
        goodsDB.put(1, new Goods(1, "苹果", 99, 99, 10.5));
        goodsDB.put(2, new Goods(2, "香蕉", 99, 99, 11.5));
        goodsDB.put(3, new Goods(3, "梨", 99, 99, 2.5));
        goodsDB.put(4, new Goods(4, "西瓜", 99, 99, 15.5));
    }

    /**
     * 查看全部
     * @return
     */
    public static List<Goods> findAll() {
        return new ArrayList<>(goodsDB.values());
    }

    public static void update(Goods goods) {
        if (goods.getId() != null && getById(goods.getId()) != null) {
            goodsDB.put(goods.getId(), goods);
        }
    }

    public static Goods getById(Integer id) {
        return goodsDB.get(id);
    }
}
