package com.example.shopping.pojo;

/**
 * xx
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/wenyio
 * @date: 2021/5/13
 * @see: com.example.shopping.pojo
 * @version: v1.0.0
 */
public class GoodsShopCart {

    private Integer id;
    private ShopCart shopCart; // 购物车
    private Goods goods; // 商品
    private Double price = 0d; // 单价
    private Integer num = 0; // 数量

    public GoodsShopCart() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ShopCart getShopCart() {
        return shopCart;
    }

    public void setShopCart(ShopCart shopCart) {
        this.shopCart = shopCart;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
