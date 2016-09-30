package com.admin.jxc.service;

import com.admin.jxc.dao.JxcGoodsBuyDao;
import com.admin.jxc.dao.JxcGoodsDao;
import com.admin.jxc.dao.JxcGoodsSaleDao;
import com.admin.jxc.entity.JxcGoodsBuyEntity;
import com.admin.jxc.entity.JxcGoodsEntity;
import com.admin.jxc.entity.JxcGoodsSaleEntity;
import com.admin.jxc.vo.JxcGoodsBuyVo;
import com.admin.jxc.vo.JxcGoodsSaleVo;
import com.admin.jxc.vo.JxcGoodsVo;
import com.admin.utils.PageUtil;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-9-22
 * Time: 上午11:28
 * To change this template use File | Settings | File Templates.
 */
@Service
public class JxcServiceImpl extends AbstractService implements IJxcService{


    @Autowired
    protected MapperFacade mapper;

    @Override
     public PageUtil findGoods(Integer page, Map map) throws Exception {
        JxcGoodsDao dao = new JxcGoodsDao();
        List<JxcGoodsEntity> list = dao.getAll();
        List<JxcGoodsVo> goodsVos = new ArrayList<JxcGoodsVo>();
        for (JxcGoodsEntity entity : list){
            goodsVos.add(mapper.map(entity, JxcGoodsVo.class));
        }
        System.out.println("list.size:" + list.size());
        PageUtil pageUtil = new PageUtil();
        pageUtil.setCurPage(1);
        pageUtil.setPageList(goodsVos);
        pageUtil.setPageSize(10);
        pageUtil.setTotalCount(2);
        return pageUtil;
    }

    @Override
    public JxcGoodsVo findGoodsByCode(String code) throws Exception {
        JxcGoodsDao dao = new JxcGoodsDao();
        JxcGoodsEntity entity = dao.findByCode(code);
        if(entity == null){
            return null;
        }
        JxcGoodsVo goodsVo = mapper.map(entity, JxcGoodsVo.class);
        return goodsVo;
    }

    @Override
    public void addGoods(JxcGoodsVo goodsVo) throws Exception {
        JxcGoodsDao dao = new JxcGoodsDao();
        JxcGoodsEntity entity = mapper.map(goodsVo, JxcGoodsEntity.class);
        entity.setStatus(0);
        entity.setCreateTime(new Date());
        dao.save(entity);
    }


    @Override
    public PageUtil findSales(Integer page, Map map) throws Exception {
        JxcGoodsSaleDao dao = new JxcGoodsSaleDao();
        List<JxcGoodsSaleEntity> list = dao.getAll();
        List<JxcGoodsSaleVo> saleVos = new ArrayList<JxcGoodsSaleVo>();
        for (JxcGoodsSaleEntity entity : list){
            saleVos.add(mapper.map(entity, JxcGoodsSaleVo.class));
        }
        System.out.println("list.size:" + list.size());
        PageUtil pageUtil = new PageUtil();
        pageUtil.setCurPage(1);
        pageUtil.setPageList(saleVos);
        pageUtil.setPageSize(10);
        pageUtil.setTotalCount(2);
        return pageUtil;
    }


    @Override
    public void addSales(JxcGoodsSaleVo saleVos) throws Exception {
        JxcGoodsSaleDao dao = new JxcGoodsSaleDao();
        JxcGoodsSaleEntity entity = mapper.map(saleVos, JxcGoodsSaleEntity.class);
        entity.setStatus(0);
        entity.setCreateTime(new Date());
        dao.save(entity);
    }

    @Override
    public PageUtil findBuys(Integer page, Map map) throws Exception {
        JxcGoodsBuyDao dao = new JxcGoodsBuyDao();
        List<JxcGoodsBuyEntity> list = dao.getAll();
        List<JxcGoodsBuyVo> buyVos = new ArrayList<JxcGoodsBuyVo>();
        for (JxcGoodsBuyEntity entity : list){
            buyVos.add(mapper.map(entity, JxcGoodsBuyVo.class));
        }
        System.out.println("list.size:" + list.size());
        PageUtil pageUtil = new PageUtil();
        pageUtil.setCurPage(1);
        pageUtil.setPageList(buyVos);
        pageUtil.setPageSize(10);
        pageUtil.setTotalCount(2);
        return pageUtil;
    }


    @Override
    public void addBuys(JxcGoodsBuyVo buysVo) throws Exception {
        JxcGoodsBuyDao dao = new JxcGoodsBuyDao();
        JxcGoodsBuyEntity entity = mapper.map(buysVo, JxcGoodsBuyEntity.class);
        dao.save(entity);
    }
}
