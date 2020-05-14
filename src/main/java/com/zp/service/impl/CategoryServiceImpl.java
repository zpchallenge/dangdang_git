package com.zp.service.impl;

import com.zp.dao.CategoryDao;
import com.zp.entity.Category;
import com.zp.service.CategoryService;
import com.zp.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> selectAll() {
        SqlSession sqlSession = MybatisUtil.openSession ();
        CategoryDao categoryDao = sqlSession.getMapper (CategoryDao.class);
        List<Category> categoryList = categoryDao.selectAll ();
        MybatisUtil.close (sqlSession);
        return categoryList;
    }

    @Override
    public List<Category> selectAllFront() {
        SqlSession sqlSession = MybatisUtil.openSession ();
        CategoryDao categoryDao = sqlSession.getMapper (CategoryDao.class);
        List<Category> categoryList = categoryDao.selectAllFront ();
        MybatisUtil.close (sqlSession);
        return categoryList;
    }

    @Override
    public List<Category> selectByOneLevel() {
        SqlSession sqlSession = MybatisUtil.openSession ();
        CategoryDao categoryDao = sqlSession.getMapper (CategoryDao.class);
        List<Category> categoryList = categoryDao.selectByOneLevel ();
        MybatisUtil.close (sqlSession);
        return categoryList;
    }

    @Override
    public List<Category> selectByTwoLevel() {
        SqlSession sqlSession = MybatisUtil.openSession ();
        CategoryDao categoryDao = sqlSession.getMapper (CategoryDao.class);
        List<Category> categoryList = categoryDao.selectByTwoLevel ();
        MybatisUtil.close (sqlSession);
        return categoryList;
    }

    @Override
    public List<Category> selectByParentId(String parentId) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        CategoryDao categoryDao = sqlSession.getMapper (CategoryDao.class);
        List<Category> categoryList = categoryDao.selectByParentId (parentId);
        MybatisUtil.close (sqlSession);
        return categoryList;
    }

    @Override
    public List<Category> selectBookCountById(String id) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        CategoryDao categoryDao = sqlSession.getMapper (CategoryDao.class);
        List<Category> categoryList = categoryDao.selectBookCountById (id);
        MybatisUtil.close (sqlSession);
        return categoryList;
    }

    @Override
    public Category selectById(String id) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        CategoryDao categoryDao = sqlSession.getMapper (CategoryDao.class);
        Category category = categoryDao.selectById (id);
        MybatisUtil.close (sqlSession);
        return category;
    }

    @Override
    public void add(Category category) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        try {
            CategoryDao categoryDao = sqlSession.getMapper (CategoryDao.class);
            categoryDao.insert (category);
            sqlSession.commit ();
        } catch (Exception e){
            sqlSession.rollback ();
            e.printStackTrace ();;
            throw new RuntimeException (e);
        } finally {
            MybatisUtil.close (sqlSession);
        }
    }

    @Override
    public void deleteById(String id) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        try {
            CategoryDao categoryDao = sqlSession.getMapper (CategoryDao.class);
            categoryDao.deleteById (id);
            sqlSession.commit ();
        } catch (Exception e){
            sqlSession.rollback ();
            e.printStackTrace ();;
            throw new RuntimeException (e);
        } finally {
            MybatisUtil.close (sqlSession);
        }
    }
}
