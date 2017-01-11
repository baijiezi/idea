package com.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-9-2
 * Time: 下午4:26
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("add")
    public String add(){
        return "success";
    }

    @RequestMapping("/index")
    public String adminIndex(){
        System.out.println("index");
        return "admin/index";
    }

    @RequestMapping("/listMenu")
    public String listMenu(Model model, HttpServletRequest request){
        System.out.println("listMenu");
        return "admin/menu";
    }

    @RequestMapping("/showMain")
    public String index(Model model, HttpServletRequest request){
        System.out.println("showMain");
        return "admin/main";
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("adminUser") != null ){
            session.setAttribute("adminUser",null);
        }
        return "redirect:/admin/auth/logout_admin";
    }


    @RequestMapping("/header")
    public String header(Model model, HttpServletRequest request){
        model.addAttribute("showHeaderMessage","阳光康众Boss系统-综合管理平台");
        model.addAttribute("showHeaderImage","resources/images/sun_03.png");
        return "admin/header";
    }

    @RequestMapping("/footer")
    public String footer(Model model, HttpServletRequest request){
        return "admin/footer";
    }





}
