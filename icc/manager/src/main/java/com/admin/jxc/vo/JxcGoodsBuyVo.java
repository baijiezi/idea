package com.admin.jxc.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-9-21
 * Time: 下午4:00
 * To change this template use File | Settings | File Templates.
 */
public class JxcGoodsBuyVo implements Serializable {

    private static final long serialVersionUID = 7375909700364018334L;
    private String code;
    private String name;
    private String classes;
    private String buySource;
    private Integer buyPrice;
    private Integer buyCount;
    private Integer stockCount;
    private Integer status;
    private Date buyTime;
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getBuySource() {
        return buySource;
    }

    public void setBuySource(String buySource) {
        this.buySource = buySource;
    }

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
