package com.zp.entity;

import java.util.HashMap;
import java.util.Map;

//购物车类
public class Cart {
    private Map<Integer,CartItem> itemMap = new HashMap<> ();

    public Cart() {
    }

    public Cart(Map<Integer, CartItem> itemMap) {
        this.itemMap = itemMap;
    }

    public Map<Integer, CartItem> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<Integer, CartItem> itemMap) {
        this.itemMap = itemMap;
    }
}
