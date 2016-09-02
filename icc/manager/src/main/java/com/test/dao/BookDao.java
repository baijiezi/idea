package com.test.dao;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-9-1
 * Time: 下午7:16
 * To change this template use File | Settings | File Templates.
 */
import org.springframework.stereotype.Component;

import com.test.model.Book;
@Component
public class BookDao {

    //模拟数据库操作
    public void add(Book book){
        System.out.print("Add");
    }
    public void update(Book book){
        System.out.print("Update");
    }
}

