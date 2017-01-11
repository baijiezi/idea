package com.admin.utils;

import com.admin.jxc.entity.JxcGoodsEntity;
import com.admin.jxc.vo.JxcGoodsVo;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

/**
 * author: Leo Zhang
 */
public class HealthMapper extends ConfigurableMapper {

    @Override
    public void configure(MapperFactory mapperFactory) {

        mapperFactory.registerClassMap(mapperFactory.classMap(JxcGoodsEntity.class, JxcGoodsVo.class)
//                .field("id", "hospitalId")
                .byDefault().toClassMap());


    }
}

