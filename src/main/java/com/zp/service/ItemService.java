package com.zp.service;

import com.zp.entity.Item;

import java.util.List;

public interface ItemService {
    public List<Item> selectByOrderId(String orderId);

    public void insert(Item item);
}
