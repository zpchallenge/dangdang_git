package com.zp.test;

import com.zp.dao.AdminDao;
import com.zp.entity.Admin;
import com.zp.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class AdminTest {

    @Test
    public void testSelectAdminByUsername(){
        SqlSession sqlSession = MybatisUtil.openSession ();
        AdminDao adminDao = sqlSession.getMapper (AdminDao.class);
        Admin admin = adminDao.selectAdminByUsername ("admin");
        System.out.println (admin);
    }
}
