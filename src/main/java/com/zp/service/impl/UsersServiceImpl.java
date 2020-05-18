package com.zp.service.impl;

import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;
import com.zp.dao.UsersDao;
import com.zp.entity.Users;
import com.zp.service.UsersService;
import com.zp.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UsersServiceImpl implements UsersService {


    @Override
    public boolean login(String email, String password) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        boolean flag = false;
        try {
            UsersDao usersDao = sqlSession.getMapper (UsersDao.class);
            Users user = usersDao.selectUserByEmail (email);
            String salt = user.getSalt ();
            HMac md5 = new HMac (HmacAlgorithm.HmacMD5, salt.getBytes ());
            if (md5.digestHex (password).equals (user.getPassword ())) {
                flag = true;
            }
            sqlSession.commit ();
        } catch (Exception e) {
            sqlSession.rollback ();
            e.printStackTrace ();
            throw new RuntimeException (e);
        } finally {
            MybatisUtil.close (sqlSession);
        }
        return flag;
    }

    @Override
    public Users selectUserByEmail(String email) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        UsersDao usersDao = sqlSession.getMapper (UsersDao.class);
        Users users = usersDao.selectUserByEmail (email);
        MybatisUtil.close (sqlSession);
        return users;
    }

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
        int count = usersDao.count ();
        MybatisUtil.close (sqlSession);
        return count;
    }

    @Override
    public boolean register(Users user) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        boolean flag = false;
        try {
            UsersDao usersDao = sqlSession.getMapper (UsersDao.class);
            Users users = usersDao.selectUserByEmail (user.getEmail ());
            if (users == null) {
                usersDao.insert (user);
                flag = true;
            }
            sqlSession.commit ();
        } catch (Exception e) {
            sqlSession.rollback ();
            e.printStackTrace ();
            throw new RuntimeException (e);
        } finally {
            MybatisUtil.close (sqlSession);
        }
        return flag;
    }


    @Override
    public void updateStatus(String status, String id) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        try {
            UsersDao usersDao = sqlSession.getMapper (UsersDao.class);
            usersDao.updateStatus (status, id);
            sqlSession.commit ();
        } catch (Exception e) {
            sqlSession.rollback ();
            e.printStackTrace ();
            throw new RuntimeException (e);
        } finally {
            MybatisUtil.close (sqlSession);
        }
    }

}
