package com.admin.jxc.service;

import com.admin.utils.PageUtil;

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
}
