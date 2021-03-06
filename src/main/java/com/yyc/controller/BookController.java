package com.yyc.controller;

import com.yyc.entity.Book;
import com.yyc.service.BookCategoryMetaService;
import com.yyc.service.BookService;
import com.yyc.vo.RespMsg;
import com.yyc.vo.request.BookCameraVo;
import com.yyc.vo.request.BookListVo;
import com.yyc.vo.request.SearchAndPageVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**************************************
 * @author 尹以操 E-mail:34782655@qq.com
 * @version 创建/修改时间：
 * 类说明: 图书管理
 ***************************************
 */
@RestController
@RequestMapping("/book")
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    private final BookService bookService;
    private final BookCategoryMetaService bookCategoryMetaService;
    @Autowired
    public BookController(BookService bookService, BookCategoryMetaService bookCategoryMetaService) {
        this.bookService = bookService;
        this.bookCategoryMetaService = bookCategoryMetaService;
    }


    /**
     * 导出图书数据
     * 文件下载并且失败的时候返回json（默认失败了会返回一个有部分数据的Excel）
     */
    @RequiresPermissions("book:get")
    @RequestMapping("/export")
    @ResponseBody
    public void exportAllBooksExcel(HttpServletResponse response) throws IOException{
        this.bookService.exportAllBooksExcel(response);
    }

    @RequiresPermissions("book:get")
    @RequestMapping("/getBookCategoryMetaValueAndLabel")
    @ResponseBody
    public RespMsg getSelectValueAndLabel(){
        return bookCategoryMetaService.getSelectValueAndLabel();
    }

    @RequiresPermissions("book:get")
    @RequestMapping("/getBookList")
    @ResponseBody
    public RespMsg getBookList(SearchAndPageVo searchAndPageVo){
        logger.info("getBookList...>>>>>>>>>"+searchAndPageVo);
        return  this.bookService.getBookList(searchAndPageVo);
    }

    @RequiresPermissions("book:add")
    @RequestMapping("/addBook")
    @ResponseBody
    public RespMsg addBook(Book book){
        logger.info("addBook...");
        return  this.bookService.addBook(book);
    }
    @RequiresPermissions("book:add")
    @RequestMapping("/addBookByCamera")
    @ResponseBody
    public RespMsg addBookByCamera(BookCameraVo book){
        logger.info("addBookByCamera...");
        return  this.bookService.addBookByCamera(book);
    }

    @RequiresPermissions("book:remove")
    @RequestMapping("/removeBook")
    @ResponseBody
    public RespMsg removeBook(Integer id){
        logger.info("removeBook...");
        return  this.bookService.removeBookByPrimaryKey(id);
    }

    @RequiresPermissions("book:modify")
    @RequestMapping("/modifyBook")
    @ResponseBody
    public RespMsg modifyBook(Book book){
        logger.info("modifyBook...");
        return  this.bookService.modifyBookByPrimaryKey(book);
    }

    @RequiresPermissions("bookPressData:get")
    @RequestMapping("/getBookPressData")
    @ResponseBody
    public RespMsg getBookPressData(){
        logger.info("getBookPressData...");
        return  this.bookService.getBookPressData();
    }

    @RequiresPermissions("bookCategoryData:get")
    @RequestMapping("/getBookCategoryData")
    @ResponseBody
    public RespMsg getBookCategoryData(){
        logger.info("getBookCategoryData...");
        return  this.bookService.getBookCategoryData();
    }


    @RequiresPermissions("book:add")
    @RequestMapping("/importBookListData")
    @ResponseBody
    public RespMsg importBookListData(BookListVo datas){
        logger.info("importBookListData--->"+datas.toString());
        return this.bookService.addBookes(datas);
    }
}
