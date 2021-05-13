package com.example.shopping.pojo;

import java.util.Objects;

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
public class ShopCart {
    private Integer id;
    private Double totalPrice; // 总价

    public ShopCart() {
    }

    public ShopCart(Integer id, Double totalPrice) {
        this.id = id;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
