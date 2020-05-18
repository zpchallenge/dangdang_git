package com.zp.entity;

import java.util.HashMap;
import java.util.Map;

//购物车类
public class Cart {
    private Map<Integer,CartItem> itemMap = new HashMap<> ();
    private Double priceSave; //节省价格
    private Double totalPrice; //总价格

    public Cart() {
    }

    public Cart(Map<Integer, CartItem> itemMap) {
        this.itemMap = itemMap;
    }

    public Cart(Map<Integer, CartItem> itemMap, Double priceSave, Double totalPrice) {
        this.itemMap = itemMap;
        this.priceSave = priceSave;
        this.totalPrice = totalPrice;
    }

    public Double getPriceSave() {
        return priceSave;
    }

    public void setPriceSave(Double priceSave) {
        this.priceSave = priceSave;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Map<Integer, CartItem> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<Integer, CartItem> itemMap) {
        this.itemMap = itemMap;
    }
}
