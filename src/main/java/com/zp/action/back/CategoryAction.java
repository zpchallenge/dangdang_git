package com.zp.action.back;

import com.zp.entity.Book;
import com.zp.entity.Category;
import com.zp.service.BookService;
import com.zp.service.CategoryService;
import com.zp.service.impl.BookServiceImpl;
import com.zp.service.impl.CategoryServiceImpl;
import com.zp.util.UUIDUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class CategoryAction {
    private CategoryService categoryService = new CategoryServiceImpl ();
    private BookService bookService = new BookServiceImpl ();

    private List<Category> categoryList;

    private String errorMsg;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public String showAll(){
        errorMsg = errorMsg;
        System.out.println (errorMsg);
        categoryList = categoryService.selectAll ();
        return "showSuccess";
    }

    public String toAddSecond(){
        categoryList = categoryService.selectByOneLevel ();
        return "toAddSecondSuccess";
    }

    private Category c;

    public Category getC() {
        return c;
    }

    public void setC(Category c) {
        this.c = c;
    }

    public String addCategory(){
        String id = UUIDUtil.getUUID ();
        c.setId (id);
        System.out.println (c);
        if (c.getCategory () == null){
            Category category = new Category ();
            category.setId ("");
            c.setCategory (category);
        }
        categoryService.add (c);
        return "success";
    }

    private String id;
    private Integer levels;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String deleteCategoryById() throws UnsupportedEncodingException {
        if (levels == 1){
            List<Category> categoryList = categoryService.selectByParentId (id);
            if (categoryList.size () > 0){
                errorMsg = URLEncoder.encode ("该一级类别下有二级类别，不能删除！","utf-8");
                return "deleteOneLevelsFail";
            }
        } else if (levels == 2){
            List<Book> books = bookService.selectByCategoryId (id);
            if (books.size () > 0){
                errorMsg = URLEncoder.encode ("该二级类别下有图书，不能删除！","utf-8");
                return "deleteTwoLevelsFail";
            }
        }
        categoryService.deleteById (id);
        return "success";
    }
}
