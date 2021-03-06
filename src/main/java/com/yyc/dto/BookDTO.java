package com.yyc.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;

/**************************************
 * @author 尹以操 E-mail:34782655@qq.com
 * @version 创建/修改时间：
 * 类说明: 图书信息对应的DTO
 ***************************************
 */
@ContentRowHeight(15)
@HeadRowHeight(15)
@ColumnWidth(12)
public class BookDTO {

    @ExcelProperty("编号")
    private Integer id;
    @ExcelProperty("ISBN")
    private String bookIsbn;
    @ExcelProperty("书名")
    private String bookName;
    @ExcelProperty("价格")
    private Double bookPrice;
    @ExcelProperty("作者")
    private String bookAuthor;
    @ExcelProperty("库存")
    private Integer bookRepertorySize;
    @ExcelProperty("出版社")
    private String pubName;
    @ExcelProperty("图书类别")
    private String categoryName;
    @ExcelIgnore
    private Integer bookPub;
    @ExcelIgnore
    private Integer bookCategory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Integer getBookRepertorySize() {
        return bookRepertorySize;
    }

    public void setBookRepertorySize(Integer bookRepertorySize) {
        this.bookRepertorySize = bookRepertorySize;
    }

    public String getPubName() {
        return pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getBookPub() {
        return bookPub;
    }

    public void setBookPub(Integer bookPub) {
        this.bookPub = bookPub;
    }

    public Integer getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(Integer bookCategory) {
        this.bookCategory = bookCategory;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", bookIsbn='" + bookIsbn + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookRepertorySize=" + bookRepertorySize +
                ", pubName='" + pubName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", bookPub=" + bookPub +
                ", bookCategory=" + bookCategory +
                '}';
    }
}
