package com.zp.action.back;

import com.zp.entity.Book;
import com.zp.entity.Category;
import com.zp.service.BookService;
import com.zp.service.CategoryService;
import com.zp.service.impl.BookServiceImpl;
import com.zp.service.impl.CategoryServiceImpl;
import com.zp.util.DateToStringUtil;
import com.zp.util.UUIDUtil;
import org.apache.struts2.ServletActionContext;

import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class BookAction {
    private BookService bookService = new BookServiceImpl ();
    private CategoryService categoryService = new CategoryServiceImpl ();

    private Integer pageNum;
    private Integer pageSize;
    private Integer total;
    private Integer totalPage;
    private List<Book> bookList;

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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    private String key;
    private String content;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String errorMsg;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String showAll() {
        String name = null;
        String author = null;
        String press = null;
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 6;
        }

        if (key != null) {
            if (key.equals ("name")) {
                name = "%" + content + "%";
            } else if (key.equals ("author")) {
                author = "%" + content + "%";
            } else if (key.equals ("press")) {
                press = "%" + content + "%";
            }
        }

        if (errorMsg != null){
            errorMsg = errorMsg;
        }
        bookList = bookService.selectAllByPage (pageNum, pageSize, name, author, press);
        total = bookService.count (name, author, press);
        totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        return "showSuccess";
    }

    private List<Category> categoryList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public String toAddBook() {
        categoryList = categoryService.selectByTwoLevel ();
        return "toAddBookSuccess";
    }

    private Book book;
    private File cover;
    private String coverFileName;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public File getCover() {
        return cover;
    }

    public void setCover(File cover) {
        this.cover = cover;
    }

    public String getCoverFileName() {
        return coverFileName;
    }

    public void setCoverFileName(String coverFileName) {
        this.coverFileName = coverFileName;
    }

    public String addBook() {
        //开始上传封面到服务器下的img目录下
        //获取img在服务器的真实路径
        String path = ServletActionContext.getRequest ().getServletContext ().getRealPath ("/back/img/");
        File target = new File (path + coverFileName);
        //定义输入输出流
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            InputStream is = new FileInputStream (cover);
            OutputStream os = new FileOutputStream (target);

            bis = new BufferedInputStream (is);
            bos = new BufferedOutputStream (os);

            byte[] buf = new byte[1024];
            int len = -1;
            while ((len = bis.read (buf)) != -1) {
                bos.write (buf, 0, len);
            }

            //上传成功
            book.setCover (coverFileName);
            book.setSale (0);
            book.setCreateDate (new Date ());
            //调用service方法
            bookService.insert (book);
        } catch (IOException e) {
            e.printStackTrace ();
        } finally {
            try {
                bis.close ();
                bos.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }


        return "success";
    }

    private Integer id;
    private String printDate;
    private String pressDate;

    public String getPrintDate() {
        return printDate;
    }

    public void setPrintDate(String printDate) {
        this.printDate = printDate;
    }

    public String getPressDate() {
        return pressDate;
    }

    public void setPressDate(String pressDate) {
        this.pressDate = pressDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String toUpdateBook() {
        categoryList = categoryService.selectByTwoLevel ();
        book = bookService.selectById (id);
        pressDate = DateToStringUtil.dateToString (book.getPressDate ());
        printDate = DateToStringUtil.dateToString (book.getPrintDate ());
        return "toUpdateBookSuccess";
    }

    public String updateBook() {
        if (cover == null) {
            bookService.update (book);
        } else {
            //开始上传封面到服务器下的img目录下
            //获取img在服务器的真实路径
            String path = ServletActionContext.getRequest ().getServletContext ().getRealPath ("/back/img/");
            File target = new File (path + coverFileName);
            //定义输入输出流
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            try {
                InputStream is = new FileInputStream (cover);
                OutputStream os = new FileOutputStream (target);

                bis = new BufferedInputStream (is);
                bos = new BufferedOutputStream (os);

                byte[] buf = new byte[1024];
                int len = -1;
                while ((len = bis.read (buf)) != -1) {
                    bos.write (buf, 0, len);
                }

                //上传成功
                book.setCover (coverFileName);
                //调用service方法
                bookService.update (book);
            } catch (IOException e) {
                e.printStackTrace ();
            } finally {
                try {
                    bis.close ();
                    bos.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        }
        return "success";
    }

    public String deleteBookById() throws UnsupportedEncodingException {
        Book book = bookService.selectById (id);
        Integer sale = book.getSale ();
        if (sale == 0){
            bookService.deleteById (id);
        } else {
            errorMsg = URLEncoder.encode ("该书籍已出售过，不能删除！","utf-8");
            return "deleteBookByIdFail";
        }
        return "success";
    }
}
