package com.zp.service.impl;

import com.zp.dao.UsersDao;
import com.zp.entity.Users;
import com.zp.service.UsersService;
import com.zp.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UsersServiceImpl implements UsersService {
    @Override
    public List<Users> selectAllByPage(Integer pageNum, Integer pageSize) {
        int start = (pageNum - 1) * pageSize + 1;
        int end = pageNum * pageSize;
        SqlSession sqlSession = MybatisUtil.openSession ();
        UsersDao usersDao = sqlSession.getMapper (UsersDao.class);
        List<Users> usersList = usersDao.selectAllByPage (start, end);
        MybatisUtil.close (sqlSession);
        return usersList;
    }

    @Override
    public int count() {
        SqlSession sqlSession = MybatisUtil.openSession ();
        UsersDao usersDao = sqlSession.getMapper (UsersDao.class);
        int count = usersDao.count();
        MybatisUtil.close (sqlSession);
        return count;
    }

    @Override
    public void insert(Users user) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        try {
            UsersDao usersDao = sqlSession.getMapper (UsersDao.class);
            usersDao.insert (user);
            sqlSession.commit ();
        } catch (Exception e){
            sqlSession.rollback ();
            e.printStackTrace ();
            throw new RuntimeException (e);
        } finally {
            MybatisUtil.close (sqlSession);
        }
    }

    @Override
    public void updateStatus(String status, String id) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        try {
            UsersDao usersDao = sqlSession.getMapper (UsersDao.class);
            usersDao.updateStatus (status,id);
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
