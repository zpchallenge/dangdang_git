package com.zp.dao;

import com.zp.entity.Category;

import java.util.List;

public interface CategoryDao {
    public List<Category> selectAll();  //后台展示所有

    public List<Category> selectAllFront(); //前台展示所有

    public List<Category> selectByOneLevel();
    public List<Category> selectByTwoLevel();

    public List<Category> selectByParentId(String parentId);

    public Category selectById(String id);  //根据id查询类别信息

    public List<Category> selectBookCountById(String id);  //通过一级类别id获取下面二级类别得到图书数量

    public void deleteById(String id);

    public void insert(Category category);

    public void update(Category category);
}
