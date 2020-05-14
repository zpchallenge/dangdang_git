package com.zp.service;

import com.zp.entity.Orders;

import java.util.List;

public interface OrdersService {
     public List<Orders> selectAllByPage(Integer pageNum, Integer pageSize);
     public int count();

     public Orders selectById(String id);
}
