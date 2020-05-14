package com.zp.entity;

import java.util.Date;

public class Orders {
    private String id;
    private String orderNo; //订单编号
    private Users user; //下单用户
    private Integer total; //订单价格
    private Date createDate; //创建时间
    private Address address; //下单地址
    private String status; //未支付 已支付

    public Orders() {
    }

    public Orders(String id, String orderNo, Users user, Integer total, Date createDate, Address address, String status) {
        this.id = id;
        this.orderNo = orderNo;
        this.user = user;
        this.total = total;
        this.createDate = createDate;
        this.address = address;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
