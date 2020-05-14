package com.zp.entity;

import java.util.Date;

public class Book {
    private Integer id;
    private String name;
    private String author;
    private String cover; //封面
    private String press; //出版社
    private Date pressDate; //出版时间
    private String edition; //版次
    private Date printDate;  //印刷时间
    private String impression; //印次
    private String isbn; //国际标准书号
    private Integer wordNum; //字数
    private Integer pageNum; //页数
    private String sizes; //开本
    private String paper; //纸张
    private String pack; //包装
    private Double price; //原价
    private Double dprice; //当当价
    private Date createDate; //添加时间
    private String editorRecommend; //编辑推荐
    private String contentAbstract; //内容简介
    private String authorAbstract; //作者简介
    private String director; //目录
    private String mediaCommentary; //媒体评论
    private Category category;  //图书所属类别
    private Integer sale; //销量
    private Integer stock; //库存

    public Book() {
    }

    public Book(Integer id, String name, String author, String cover, String press, Date pressDate, String edition, Date printDate, String impression, String isbn, Integer wordNum, Integer pageNum, String sizes, String paper, String pack, Double price, Double dprice, Date createDate, String editorRecommend, String contentAbstract, String authorAbstract, String director, String mediaCommentary, Category category, Integer sale, Integer stock) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.cover = cover;
        this.press = press;
        this.pressDate = pressDate;
        this.edition = edition;
        this.printDate = printDate;
        this.impression = impression;
        this.isbn = isbn;
        this.wordNum = wordNum;
        this.pageNum = pageNum;
        this.sizes = sizes;
        this.paper = paper;
        this.pack = pack;
        this.price = price;
        this.dprice = dprice;
        this.createDate = createDate;
        this.editorRecommend = editorRecommend;
        this.contentAbstract = contentAbstract;
        this.authorAbstract = authorAbstract;
        this.director = director;
        this.mediaCommentary = mediaCommentary;
        this.category = category;
        this.sale = sale;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Date getPressDate() {
        return pressDate;
    }

    public void setPressDate(Date pressDate) {
        this.pressDate = pressDate;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Date getPrintDate() {
        return printDate;
    }

    public void setPrintDate(Date printDate) {
        this.printDate = printDate;
    }

    public String getImpression() {
        return impression;
    }

    public void setImpression(String impression) {
        this.impression = impression;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getWordNum() {
        return wordNum;
    }

    public void setWordNum(Integer wordNum) {
        this.wordNum = wordNum;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDprice() {
        return dprice;
    }

    public void setDprice(Double dprice) {
        this.dprice = dprice;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getEditorRecommend() {
        return editorRecommend;
    }

    public void setEditorRecommend(String editorRecommend) {
        this.editorRecommend = editorRecommend;
    }

    public String getContentAbstract() {
        return contentAbstract;
    }

    public void setContentAbstract(String contentAbstract) {
        this.contentAbstract = contentAbstract;
    }

    public String getAuthorAbstract() {
        return authorAbstract;
    }

    public void setAuthorAbstract(String authorAbstract) {
        this.authorAbstract = authorAbstract;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMediaCommentary() {
        return mediaCommentary;
    }

    public void setMediaCommentary(String mediaCommentary) {
        this.mediaCommentary = mediaCommentary;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", cover='" + cover + '\'' +
                ", press='" + press + '\'' +
                ", pressDate=" + pressDate +
                ", edition='" + edition + '\'' +
                ", printDate=" + printDate +
                ", impression='" + impression + '\'' +
                ", isbn='" + isbn + '\'' +
                ", wordNum=" + wordNum +
                ", pageNum=" + pageNum +
                ", sizes='" + sizes + '\'' +
                ", paper='" + paper + '\'' +
                ", pack='" + pack + '\'' +
                ", price=" + price +
                ", dprice=" + dprice +
                ", createDate=" + createDate +
                ", editorRecommend='" + editorRecommend + '\'' +
                ", contentAbstract='" + contentAbstract + '\'' +
                ", authorAbstract='" + authorAbstract + '\'' +
                ", director='" + director + '\'' +
                ", mediaCommentary='" + mediaCommentary + '\'' +
                ", category=" + category +
                ", sale=" + sale +
                ", stock=" + stock +
                '}';
    }
}
