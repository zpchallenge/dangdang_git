package com.zp.entity;

public class Address {
    private String id;
    private String name; //收件人姓名
    private String local; //收件人地址
    private String zipCode; //邮编
    private String phone; //收件人手机号
    private String userId;

    public Address() {
    }

    public Address(String id, String name, String local, String zipCode, String phone, String userId) {
        this.id = id;
        this.name = name;
        this.local = local;
        this.zipCode = zipCode;
        this.phone = phone;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", local='" + local + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phone='" + phone + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
