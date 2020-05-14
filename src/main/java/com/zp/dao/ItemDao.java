package com.zp.dao;

import com.zp.entity.Item;

import java.util.List;

public interface ItemDao {
    public List<Item> selectByOrderId(String orderId);

    public void insert(Item item);
}
