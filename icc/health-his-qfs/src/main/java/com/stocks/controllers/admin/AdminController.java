package com.stocks.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-16
 * Time: 上午11:08
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @RequestMapping
    public String admin(Model model, HttpServletRequest request) {
        System.out.println("admin");
        return "admin/login";
    }

    @RequestMapping("/index")
    public String adminIndex(Model model, HttpServletRequest request){
        System.out.println("adminIndex");
        return "admin/index";
    }


}
