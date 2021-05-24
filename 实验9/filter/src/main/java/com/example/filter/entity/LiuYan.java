package com.example.filter.entity;

/**
 * xx
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/wenyio
 * @date: 2021/5/24
 * @see: com.example.filter.entity
 * @version: v1.0.0
 */
public class LiuYan {
    private String title;
    private String content;

    public LiuYan(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public LiuYan() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
