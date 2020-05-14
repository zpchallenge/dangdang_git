package com.zp.entity;

//购物车条目类
public class CartItem {
    private Book book;
    private Integer count;  //数量

    public CartItem() {
    }

    public CartItem(Book book, Integer count) {
        this.book = book;
        this.count = count;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
