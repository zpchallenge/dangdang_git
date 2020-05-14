package com.zp.test;

import com.zp.dao.CategoryDao;
import com.zp.entity.Category;
import com.zp.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CategoryDaoTest {

    @Test
    public void testSelectAllFront(){
        SqlSession sqlSession = MybatisUtil.openSession ();
        CategoryDao categoryDao = sqlSession.getMapper (CategoryDao.class);
        List<Category> categoryList = categoryDao.selectAllFront ();
        for (Category category : categoryList) {
            System.out.println (category);
        }
    }

    @Test
    public void testSelectBookCountById(){
        SqlSession sqlSession = MybatisUtil.openSession ();
        CategoryDao categoryDao = sqlSession.getMapper (CategoryDao.class);
        List<Category> categoryList = categoryDao.selectBookCountById ("e3a61c36-ab29-4e92-aeeb-dd67a48d38d6");
        for (Category category : categoryList) {
            System.out.println (category);
        }
    }
}
