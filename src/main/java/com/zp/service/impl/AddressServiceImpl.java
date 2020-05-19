package com.zp.service.impl;

import com.zp.dao.AddressDao;
import com.zp.entity.Address;
import com.zp.service.AddressService;
import com.zp.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    @Override
    public List<Address> selectAllByUserId(String userId) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        AddressDao addressDao = sqlSession.getMapper (AddressDao.class);
        List<Address> addressList = addressDao.selectAllByUserId (userId);
        MybatisUtil.close (sqlSession);
        return addressList;
    }

    @Override
    public void add(Address address) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        try {
            AddressDao addressDao = sqlSession.getMapper (AddressDao.class);
            addressDao.insert (address);
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
