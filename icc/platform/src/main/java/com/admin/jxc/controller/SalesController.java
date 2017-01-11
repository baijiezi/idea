package com.admin.jxc.controller;

import com.admin.jxc.entity.JxcGoodsEntity;
import com.admin.jxc.service.IJxcService;
import com.admin.jxc.vo.JxcGoodsSaleVo;
import com.admin.jxc.vo.JxcGoodsVo;
import com.admin.utils.Json;
import com.admin.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-9-27
 * Time: 上午10:29
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/admin/jxc/sales")
public class SalesController {

    @Autowired
    private IJxcService jxcService;

    @RequestMapping("/list")
    public String list(Model model, HttpServletRequest request){
        System.out.println("list");
        try{
            Map map = new HashMap();
            PageUtil pageUtil = jxcService.findSales(1, map);
            Map pageMap = new HashMap();
            pageMap.put("firstPage",1);
            pageMap.put("lastPage",2);
            pageMap.put("prePage",pageUtil.getPrePage());
            pageMap.put("curPage",1);
            pageMap.put("pageSize",pageUtil.getPageSize());
            pageMap.put("nextPage",pageUtil.getNextPage());
            pageMap.put("totalCount",pageUtil.getTotalCount());

            model.addAttribute("pageUtil", pageMap);
            model.addAttribute("pageList", pageUtil.getPageList());
        } catch (Exception e){
            e.printStackTrace();
        }

        return "admin/jxc/salesList";
    }

    @RequestMapping("/addPage")
    public String addPage(){
        System.out.println("addPage");
        return "admin/jxc/salesAdd";
    }

    @RequestMapping("/add")
    public String add(JxcGoodsSaleVo salesVo, Model model, HttpServletRequest request){
        try{
            String name = request.getParameter("name");
            String encodeName = new String(name.getBytes("ISO-8859-1"), "utf-8");
            salesVo.setName(encodeName);

            String classes = request.getParameter("classes");
            String encodeClasses = new String(classes.getBytes("ISO-8859-1"), "utf-8");
            salesVo.setClasses(encodeClasses);

            String remark = request.getParameter("remark");
            String encodeRemark = new String(remark.getBytes("ISO-8859-1"), "utf-8");
            salesVo.setRemark(encodeRemark);

            jxcService.addSales(salesVo);
        } catch (Exception e){
            e.printStackTrace();
        }
        return list(model, request);
    }

    @RequestMapping("/findGoodsByCode")
    @ResponseBody
    public String findGoodsByCode(String code){
        System.out.println("findGoodsByCode");
        StringBuffer result = new StringBuffer("{");
        try {
            JxcGoodsVo goodsVo = jxcService.findGoodsByCode(code);
            result.append("\"code\":\"").append(goodsVo.getCode()).append("\",")
                    .append("\"name\":\"").append(goodsVo.getName()).append("\"");
            result.append("}");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    @RequestMapping("/delete")
    public String delete(Long[] ids){
        try{
            System.out.println(ids.length);

        } catch (Exception e){
            e.printStackTrace();
        }
        return "aa";
    }
}
