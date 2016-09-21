package com.admin.jxc.controller;

import com.test.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-9-2
 * Time: 下午4:46
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/admin/jxc")
public class JxcController {

    @RequestMapping("/goods/list")
    public String list(){
        return "admin/jxc/goodsList";
    }

    @RequestMapping("/goods/addPage")
    public String addPage(){
        System.out.println("addPage");
        return "admin/jxc/goodsAdd";
    }

    @RequestMapping("/goods/add")
    public String add(){
        return "success";
    }


}
