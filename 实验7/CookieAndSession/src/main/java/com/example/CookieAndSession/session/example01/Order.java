package com.example.CookieAndSession.session.example01;

import com.example.CookieAndSession.session.example02.User;

/**
 * xx
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/wenyio
 * @date: 2021/3/29
 * @see: com.example.CookieAndSession.session.example01
 * @version: v1.0.0
 */
public class Order {

    private User user;

    private Book book;

    private Integer amount; // 购买数量

    public Order() {
    }

    public Order(User user, Book book, Integer amount) {
        this.user = user;
        this.book = book;
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
