package com.zp.entity;

import java.util.List;

public class Category {
    private String id;
    private String name;
    private Category category;
    private List<Category> categoryList;
    private Integer levels;
    private Integer count;

    public Category() {
    }

    public Category(String id, String name, Category category, Integer levels) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.levels = levels;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", categoryList=" + categoryList +
                ", levels=" + levels +
                ", count=" + count +
                '}';
    }
}
