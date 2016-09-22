package com.admin.jxc.service;

import com.admin.jxc.dao.JxcGoodsDao;
import com.admin.jxc.entity.JxcGoodsEntity;
import com.admin.jxc.vo.JxcGoodsVo;
import com.admin.utils.PageUtil;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
}
