package com.test.controller;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-9-1
 * Time: 下午6:24
 * To change this template use File | Settings | File Templates.
 */
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.model.Book;
import com.test.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

    private BookService bookService;
    @RequestMapping("add")
    public String add(Book book){
        System.out.println("bookname:"+book.getName());
        System.out.println("author:"+book.getAuthor());
        bookService.add(book);
        return "success";
    }
    @RequestMapping("update")
    public String update(Book book) {
        bookService.update(book);
        return "success";
    }
    public BookService getBookService() {
        return bookService;
    }
    @Resource
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

}
