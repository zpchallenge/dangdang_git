package com.zp.service.impl;

import com.zp.dao.ItemDao;
import com.zp.entity.Item;
import com.zp.service.ItemService;
import com.zp.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ItemServiceImpl implements ItemService {
    @Override
    public List<Item> selectByOrderId(String orderId) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        ItemDao itemDao = sqlSession.getMapper (ItemDao.class);
        List<Item> items = itemDao.selectByOrderId (orderId);
        MybatisUtil.close (sqlSession);
        return items;
    }

    @Override
    public void insert(Item item) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        try {
            ItemDao itemDao = sqlSession.getMapper (ItemDao.class);
            itemDao.insert (item);
            sqlSession.commit ();
        } catch (Exception e){
            sqlSession.rollback ();
            e.printStackTrace ();
            throw new RuntimeException (e);
        } finally {
            MybatisUtil.close (sqlSession);
        }
    }
}
