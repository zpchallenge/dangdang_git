package com.zp.dao;

import com.zp.entity.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersDao {
    public List<Orders> selectAllByPage(@Param ("start") Integer start, @Param ("end") Integer end);
    public int count();

    public List<Orders> selectByUserId(String userId);

    public Orders selectById(String id);

    public Orders selectByOrderNo(String orderNo);

    public void insert(Orders order);

    public void deleteById(String id);

    public void updateStatus(@Param ("orderNo") String orderNo, @Param ("status") String status); //改变订单支付状态
}
