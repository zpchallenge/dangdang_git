package com.zp.service.impl;

import com.zp.dao.AdminDao;
import com.zp.entity.Admin;
import com.zp.service.AdminService;
import com.zp.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class AdminServiceImpl implements AdminService {
    @Override
    public boolean login(String username, String password) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        AdminDao adminDao = sqlSession.getMapper (AdminDao.class);
        boolean flag = false;

        Admin admin = adminDao.selectAdminByUsername (username);
        if (admin != null && admin.getPassword ().equals (password)){
            flag = true;
        }
        MybatisUtil.close (sqlSession);
        return flag;
    }
}
