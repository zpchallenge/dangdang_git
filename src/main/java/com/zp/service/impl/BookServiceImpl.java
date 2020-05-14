package com.zp.service.impl;

import com.zp.dao.BookDao;
import com.zp.entity.Book;
import com.zp.service.BookService;
import com.zp.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public List<Book> selectByCategoryId(String categoryId) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        BookDao bookDao = sqlSession.getMapper (BookDao.class);
        List<Book> bookList = bookDao.selectByCategoryId (categoryId);
        MybatisUtil.close (sqlSession);
        return bookList;
    }

    @Override
    public List<Book> selectBookByEdition() {
        SqlSession sqlSession = MybatisUtil.openSession ();
        BookDao bookDao = sqlSession.getMapper (BookDao.class);
        List<Book> books = bookDao.selectBookByEdition ();
        MybatisUtil.close (sqlSession);
        return books;
    }

    @Override
    public List<Book> selectBookByNew() {
        SqlSession sqlSession = MybatisUtil.openSession ();
        BookDao bookDao = sqlSession.getMapper (BookDao.class);
        List<Book> books = bookDao.selectBookByNew ();
        MybatisUtil.close (sqlSession);
        return books;
    }

    @Override
    public List<Book> selectBookBySale() {
        SqlSession sqlSession = MybatisUtil.openSession ();
        BookDao bookDao = sqlSession.getMapper (BookDao.class);
        List<Book> books = bookDao.selectBookBySale ();
        MybatisUtil.close (sqlSession);
        return books;
    }

    @Override
    public List<Book> selectBookByNewAndSale() {
        SqlSession sqlSession = MybatisUtil.openSession ();
        BookDao bookDao = sqlSession.getMapper (BookDao.class);
        List<Book> books = bookDao.selectBookByNewAndSale ();
        MybatisUtil.close (sqlSession);
        return books;
    }

    @Override
    public List<Book> selectBookByOneLevel(String id, Integer pageNum, Integer pageSize) {
        int start = (pageNum - 1) * pageSize + 1;
        int end = pageNum * pageSize;
        SqlSession sqlSession = MybatisUtil.openSession ();
        BookDao bookDao = sqlSession.getMapper (BookDao.class);
        List<Book> books = bookDao.selectBookByOneLevel (id, start, end);
        MybatisUtil.close (sqlSession);
        return books;
    }

    @Override
    public int countOne(String id) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        BookDao bookDao = sqlSession.getMapper (BookDao.class);
        int countOne = bookDao.countOne (id);
        MybatisUtil.close (sqlSession);
        return countOne;
    }

    @Override
    public List<Book> selectBookByTwoLevel(String id, Integer pageNum, Integer pageSize) {
        int start = (pageNum - 1) * pageSize + 1;
        int end = pageNum * pageSize;
        SqlSession sqlSession = MybatisUtil.openSession ();
        BookDao bookDao = sqlSession.getMapper (BookDao.class);
        List<Book> books = bookDao.selectBookByTwoLevel (id, start, end);
        MybatisUtil.close (sqlSession);
        return books;
    }

    @Override
    public int countTwo(String id) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        BookDao bookDao = sqlSession.getMapper (BookDao.class);
        int countTwo = bookDao.countTwo (id);
        MybatisUtil.close (sqlSession);
        return countTwo;
    }


    @Override
    public Book selectById(Integer id) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        BookDao bookDao = sqlSession.getMapper (BookDao.class);
        Book book = bookDao.selectById (id);
        MybatisUtil.close (sqlSession);
        return book;
    }


    @Override
    public List<Book> selectAllByPage(Integer pageNum, Integer pageSize, String name, String author, String press) {
        int start = (pageNum - 1) * pageSize + 1;
        int end = pageNum * pageSize;
        SqlSession sqlSession = MybatisUtil.openSession ();
        BookDao bookDao = sqlSession.getMapper (BookDao.class);
        List<Book> bookList = bookDao.selectAllByPage (start, end, name, author, press);
        MybatisUtil.close (sqlSession);
        return bookList;
    }

    @Override
    public int count(String name, String author, String press) {
        SqlSession sqlSession = MybatisUtil.openSession ();
        BookDao bookDao = sqlSession.getMapper (BookDao.class);
        int count = bookDao.count (name, author, press);
        MybatisUtil.close (sqlSession);
        return count;
    }

    @Override
    public void insert(Book book) {
         SqlSession sqlSession = MybatisUtil.openSession ();
         try {
             BookDao bookDao = sqlSession.getMapper (BookDao.class);
             bookDao.insert (book);
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
    public void deleteById(Integer id) {
        SqlSession sqlSession = MybatisUtil.openSession ();
         try {
             BookDao bookDao = sqlSession.getMapper (BookDao.class);
             bookDao.deleteById (id);
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
    public void update(Book book) {
        SqlSession sqlSession = MybatisUtil.openSession ();
         try {
             BookDao bookDao = sqlSession.getMapper (BookDao.class);
             bookDao.update (book);
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
