package com.zp.test;

import com.zp.dao.BookDao;
import com.zp.entity.Book;
import com.zp.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class BookDaoTest {

    @Test
    public void testSelectBookByEdition(){
        SqlSession sqlSession = MybatisUtil.openSession ();
        BookDao bookDao = sqlSession.getMapper (BookDao.class);
        List<Book> books = bookDao.selectBookByEdition ();
        for (Book book : books) {
            System.out.println (book);
        }
    }
}
