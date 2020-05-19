package com.zp.service.impl;

import com.zp.dao.OrdersDao;
import com.zp.entity.Orders;
import com.zp.service.OrdersService;
import com.zp.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class OrdersServiceImpl implements OrdersService {
    @Override
    public List<Orders> selectAllByPage(Integer pageNum, Integer pageSize) {
        int start = (pageNum - 1) * pageSize + 1;
        int end = pageNum * pageSize;

        SqlSession sqlSession = MybatisUtil.openSession ();
        OrdersDao ordersDao = sqlSession.getMapper (OrdersDao.class);
        List<Orders> ordersList = ordersDao.selectAllByPage (start, end);
        MybatisUtil.close (sqlSession);
        return ordersList;
    }

    @Override
    public int count() {
        SqlSession sqlSession = MybatisUtil.openSession ();
        OrdersDao ordersDao = sqlSession.getMapper (OrdersDao.class);
        int count = ordersDao.count ();
        MybatisUtil.close (sqlSession);
        return count;
    }

    @Override
    public Orders selectByOrderNo(String orderNo) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        OrdersDao ordersDao = sqlSession.getMapper (OrdersDao.class);
        Orders orders = ordersDao.selectByOrderNo (orderNo);
        MybatisUtil.close (sqlSession);
        return orders;
    }

    @Override
    public Orders selectById(String id) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        OrdersDao ordersDao = sqlSession.getMapper (OrdersDao.class);
        Orders orders = ordersDao.selectById (id);
        MybatisUtil.close (sqlSession);
        return orders;
    }

    @Override
    public void add(Orders order) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        try {
            OrdersDao ordersDao = sqlSession.getMapper (OrdersDao.class);
            ordersDao.insert (order);
            sqlSession.commit ();
        } catch (Exception e){
            sqlSession.rollback ();
            e.printStackTrace ();
            throw new RuntimeException (e);
        } finally{
            MybatisUtil.close (sqlSession);
        }
    }

    @Override
    public void updateStatus(String orderNo, String status) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        try {
            OrdersDao ordersDao = sqlSession.getMapper (OrdersDao.class);
            ordersDao.updateStatus (orderNo, status);
            sqlSession.commit ();
        } catch (Exception e){
            sqlSession.rollback ();
            e.printStackTrace ();
            throw new RuntimeException (e);
        } finally{
            MybatisUtil.close (sqlSession);
        }
    }
}
