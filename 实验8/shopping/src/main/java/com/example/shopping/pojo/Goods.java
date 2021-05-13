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
public class Goods {
    private Integer id;
    private String name;
    private Integer total = 0; // 总量
    private Integer margin = 0; // 剩余数量
    private Double price = 0d; // 价格

    public Goods() {
    }

    public Goods(Integer id, String name, Integer total, Integer margin, Double price) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.margin = margin;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getMargin() {
        return margin;
    }

    public void setMargin(Integer margin) {
        this.margin = margin;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
