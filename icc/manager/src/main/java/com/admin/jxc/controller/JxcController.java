package com.admin.jxc.controller;

import com.admin.jxc.service.IJxcService;
import com.admin.jxc.vo.JxcGoodsVo;
import com.admin.jxc.vo.User;
import com.admin.utils.PageUtil;
import com.test.model.Book;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    private IJxcService jxcService;

    @RequestMapping("/goods/list")
    public String list(Model model, HttpServletRequest request){
        System.out.println("list");
        try{
            Map map = new HashMap();
            PageUtil pageUtil = jxcService.findGoods(1, map);
            Map pageMap = new HashMap();
            pageMap.put("firstPage",1);
            pageMap.put("lastPage",2);
            pageMap.put("prePage",pageUtil.getPrePage());
            pageMap.put("curPage",1);
            pageMap.put("pageSize",pageUtil.getPageSize());
            pageMap.put("nextPage",pageUtil.getNextPage());
            pageMap.put("totalCount",pageUtil.getTotalCount());

            model.addAttribute("pageUtil", pageMap);
            model.addAttribute("hospitalList", pageUtil.getPageList());
        } catch (Exception e){
            e.printStackTrace();
        }

        return "admin/jxc/goods";
    }

    @RequestMapping("/goods/addPage")
    public String addPage(){
        System.out.println("addPage");
        return "admin/jxc/goodsAdd";
    }

    @RequestMapping("/goods/add")
    public String add(JxcGoodsVo goodsVo, Model model, HttpServletRequest request){
        try{
            String name = request.getParameter("name");
            String encodeName = new String(name.getBytes("ISO-8859-1"), "utf-8");
            goodsVo.setName(encodeName);

            String classes = request.getParameter("classes");
            String encodeClasses = new String(classes.getBytes("ISO-8859-1"), "utf-8");
            goodsVo.setClasses(encodeClasses);

            String remark = request.getParameter("remark");
            String encodeRemark = new String(remark.getBytes("ISO-8859-1"), "utf-8");
            goodsVo.setRemark(encodeRemark);

            jxcService.addGoods(goodsVo);
        } catch (Exception e){
            e.printStackTrace();
        }
        return list(model, request);
    }


}
