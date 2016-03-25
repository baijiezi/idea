package com.stocks.statistics.filters.api;

import com.stocks.entity.StocksEntity;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-25
 * Time: 下午2:00
 * To change this template use File | Settings | File Templates.
 */
public interface IStockChooseFilter {
    public boolean doFilt(StocksEntity stock);
}
