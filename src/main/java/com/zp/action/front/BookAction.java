package com.zp.action.front;

import com.zp.entity.Book;
import com.zp.entity.Category;
import com.zp.service.BookService;
import com.zp.service.CategoryService;
import com.zp.service.impl.BookServiceImpl;
import com.zp.service.impl.CategoryServiceImpl;

import java.util.List;


public class BookAction {
    private BookService bookService = new BookServiceImpl ();
    private CategoryService categoryService = new CategoryServiceImpl ();

    private List<Category> categoryList;  //所有图书类别信息
    private List<Book> editorBooks; //编辑推荐图书
    private List<Book> newBooks;  //新上架的图书
    private List<Book> saleBooks;  //热销图书
    private List<Book> newAndSaleBooks;  //新书热卖图书

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Book> getEditorBooks() {
        return editorBooks;
    }

    public void setEditorBooks(List<Book> editorBooks) {
        this.editorBooks = editorBooks;
    }

    public List<Book> getNewBooks() {
        return newBooks;
    }

    public void setNewBooks(List<Book> newBooks) {
        this.newBooks = newBooks;
    }

    public List<Book> getSaleBooks() {
        return saleBooks;
    }

    public void setSaleBooks(List<Book> saleBooks) {
        this.saleBooks = saleBooks;
    }

    public List<Book> getNewAndSaleBooks() {
        return newAndSaleBooks;
    }

    public void setNewAndSaleBooks(List<Book> newAndSaleBooks) {
        this.newAndSaleBooks = newAndSaleBooks;
    }

    //展示主页
    public String showMainPage() {
        categoryList = categoryService.selectAllFront ();
        editorBooks = bookService.selectBookByEdition ();
        newBooks = bookService.selectBookByNew ();
        saleBooks = bookService.selectBookBySale ();
        newAndSaleBooks = bookService.selectBookByNewAndSale ();
        return "showMainPageSuccess";
    }

    private String id;
    private List<Book> books;
    private Integer levels;
    private Integer totalCount;  //该类别图书总数量
    private String oneName;  //一级类别名字
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Integer currentPage;  //当前页

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }


    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }


    public String getOneName() {
        return oneName;
    }

    public void setOneName(String oneName) {
        this.oneName = oneName;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    //根据类别查询图书
    public String showBookByCategory() {
        if (pageNum == null){
            pageNum = 1;
        }
        if (pageSize == null){
            pageSize = 4;
        }

        Category category = categoryService.selectById (id);
        List<Category> categoryList1 = null;
        List<Category> categories = null;
        if (category.getLevels () == 1) {
            oneName = category.getName ();
            categoryList1 = categoryService.selectByParentId (id); //获取该一级类别下的所有二级类别
            categories = categoryService.selectBookCountById (id);  //获取二级类别id 和其下面的图书数量 count
            books = bookService.selectBookByOneLevel (id, pageNum, pageSize);
            int total = bookService.countOne (id);
            totalPage = total%pageSize == 0 ? total/pageSize : total/pageSize + 1;
        } else {
            oneName = category.getCategory ().getName ();
            categoryList1 = categoryService.selectByParentId (category.getCategory ().getId ());
            categories = categoryService.selectBookCountById (category.getCategory ().getId ());
            books = bookService.selectBookByTwoLevel (id, pageNum, pageSize);
            int total = bookService.countTwo (id);
            totalPage = total%pageSize == 0 ? total/pageSize : total/pageSize + 1;
        }
        int sum = 0;
        for (Category category1 : categoryList1) {
            boolean flag = true;
            for (Category category2 : categories) {
                if (category1.getId ().equals (category2.getId ())) {
                    category1.setCount (category2.getCount ());
                    sum += category2.getCount ();
                    flag = false;
                    break;
                }
            }
            if (flag) {
                category1.setCount (0);
            }
        }
        currentPage = pageNum;
        categoryList = categoryList1;
        levels = category.getLevels ();
        id = id;
        totalCount = sum;
        return "showBookByCategorySuccess";
    }

    private Integer bookId;
    private Book book;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String showOneBookById(){
        book = bookService.selectById (bookId);
        return "showOneBookById";
    }
}
