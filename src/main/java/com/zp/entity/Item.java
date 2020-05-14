package com.zp.entity;

import java.util.Date;

//订单详情类
public class Item {
    private String id;
    private Book book; //购买的图书
    private Integer count; //购买的图书数量
    private Date createDate; //创建时间
    private Orders order; //所属订单

    public Item() {
    }

    public Item(String id, Book book, Integer count, Date createDate, Orders order) {
        this.id = id;
        this.book = book;
        this.count = count;
        this.createDate = createDate;
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", book=" + book +
                ", count=" + count +
                ", createDate=" + createDate +
                ", order=" + order +
                '}';
    }
}
