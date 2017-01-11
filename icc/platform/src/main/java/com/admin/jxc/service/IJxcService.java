package com.admin.jxc.service;

import com.admin.jxc.dao.JxcGoodsBuyDao;
import com.admin.jxc.dao.JxcGoodsSaleDao;
import com.admin.jxc.entity.JxcGoodsBuyEntity;
import com.admin.jxc.entity.JxcGoodsEntity;
import com.admin.jxc.entity.JxcGoodsSaleEntity;
import com.admin.jxc.vo.JxcGoodsBuyVo;
import com.admin.jxc.vo.JxcGoodsSaleVo;
import com.admin.jxc.vo.JxcGoodsVo;
import com.admin.utils.PageUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-9-22
 * Time: 上午11:29
 * To change this template use File | Settings | File Templates.
 */
public interface IJxcService {
    public PageUtil findGoods(Integer page, Map map) throws Exception;

    public void addGoods(JxcGoodsVo goodsVo) throws Exception;

    public PageUtil findSales(Integer page, Map map) throws Exception;

    public void addSales(JxcGoodsSaleVo saleVos) throws Exception;

    public PageUtil findBuys(Integer page, Map map) throws Exception;

    public void addBuys(JxcGoodsBuyVo buysVo) throws Exception;

    public JxcGoodsVo findGoodsByCode(String code) throws Exception;
}
