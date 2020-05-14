package com.zp.service;

import com.zp.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    public List<Book> selectByCategoryId(String categoryId); //根据类别id查看类别下的所有图书

    public List<Book> selectBookByEdition();  //查询编辑推荐的图书

    public List<Book> selectBookByNew();  //查询最近上线的图书

    public List<Book> selectBookBySale(); //查询热销图书

    public List<Book> selectBookByNewAndSale();  //查询最近上线热销图书，新书热卖

    public List<Book> selectBookByOneLevel(String id, Integer pageNum, Integer pageSize);  //根据一级类别id分页查询图书（获取属于该一级类别的二级类别下的所有图书）
    public int countOne(String id);

    public List<Book> selectBookByTwoLevel(String id, Integer pageNum, Integer pageSize);   //根据二级类别id分页查询图书
    public int countTwo(String id);

    public Book selectById(Integer id);

    public List<Book> selectAllByPage(Integer pageNum, Integer pageSize, String name, String author, String press);
    public int count(String name, String author, String press);

    public void insert(Book book);

    public void deleteById(Integer id);

    public void update(Book book);
}
