package com.zp.service;

import com.zp.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> selectAll();

    public List<Category> selectAllFront(); //前台展示所有

    public List<Category> selectByOneLevel();

    public List<Category> selectByTwoLevel();

    public List<Category> selectByParentId(String parentId);

    public List<Category> selectBookCountById(String id);  //通过一级类别id获取下面二级类别得到图书数量

    public Category selectById(String id);  //根据id查询类别信息

    public void add(Category category);

    public void deleteById(String id);
}
