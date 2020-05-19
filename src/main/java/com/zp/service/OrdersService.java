package com.zp.service;

import com.zp.entity.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersService {
     public List<Orders> selectAllByPage(Integer pageNum, Integer pageSize);
     public int count();

     public Orders selectByOrderNo(String orderNo); //根据订单编号查询订单信息

     public Orders selectById(String id);

     public void add(Orders order); //添加订单

     public void updateStatus(String orderNo, String status); //改变订单支付状态
}
