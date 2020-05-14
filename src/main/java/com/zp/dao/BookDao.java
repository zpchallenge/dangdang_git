package com.zp.dao;

import com.zp.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {
    public List<Book> selectByCategoryId(String categoryId); //根据类别id查看类别下的所有图书

    public List<Book> selectBookByEdition();  //查询编辑推荐的图书

    public List<Book> selectBookByNew();  //查询最近上线的图书

    public List<Book> selectBookBySale(); //查询热销图书

    public List<Book> selectBookByNewAndSale();  //查询最近上线热销图书，新书热卖

    public List<Book> selectBookByOneLevel(@Param ("id") String id, @Param ("start") Integer start, @Param ("end") Integer end);  //根据一级类别id查询图书（获取属于该一级类别的二级类别下的所有图书）
    public int countOne(String id);

    public List<Book> selectBookByTwoLevel(@Param ("id") String id, @Param ("start") Integer start, @Param ("end") Integer end);   //根据二级类别id查询图书
    public int countTwo(String id);

    public Book selectById(Integer id);

    public List<Book> selectAllByPage(@Param ("start")Integer start, @Param ("end")Integer end, @Param ("name") String name, @Param ("author") String author, @Param ("press")String press);
    public int count(@Param ("name") String name, @Param ("author") String author, @Param ("press")String press);

    public void insert(Book book);

    public void deleteById(Integer id);

    public void update(Book book);

}
