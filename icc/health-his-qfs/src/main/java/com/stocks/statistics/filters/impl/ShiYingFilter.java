package com.stocks.statistics.filters.impl;

import com.stocks.entity.StocksEntity;
import com.stocks.statistics.filters.api.IStockChooseFilter;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-25
 * Time: 上午10:53
 * To change this template use File | Settings | File Templates.
 */
public class ShiYingFilter implements IStockChooseFilter{


    @Override
    public boolean doFilt(StocksEntity stock) {
        return false;
    }
}
