package com.stocks.dto;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-21
 * Time: 上午10:48
 * To change this template use File | Settings | File Templates.
 */
public class StocksDto {

    private Integer id;
    private String name;
    private String code;
    private String exchange;
    private String type;
    private String subType;
    private String detailUrl1;
    private String detailUrl2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getDetailUrl1() {
        return detailUrl1;
    }

    public void setDetailUrl1(String detailUrl1) {
        this.detailUrl1 = detailUrl1;
    }

    public String getDetailUrl2() {
        return detailUrl2;
    }

    public void setDetailUrl2(String detailUrl2) {
        this.detailUrl2 = detailUrl2;
    }
}
