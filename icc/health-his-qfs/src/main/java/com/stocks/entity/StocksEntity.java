package com.stocks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-2-21
 * Time: 上午10:37
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "sic_stocks")
public class StocksEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String code;
    private String name;
    private String exchange;
    private String type;
    private String subType;
    private String detailUrl1;
    private String detailUrl2;
    private Integer url2Type;
    private String detailUrl3;
    private Integer url3Type;
    private String detailUrl4;
    private Integer url4Type;
    private String detailUrl5;
    private Integer url5Type;
    private Date createAt;

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

    public Integer getUrl2Type() {
        return url2Type;
    }

    public void setUrl2Type(Integer url2Type) {
        this.url2Type = url2Type;
    }

    public String getDetailUrl3() {
        return detailUrl3;
    }

    public void setDetailUrl3(String detailUrl3) {
        this.detailUrl3 = detailUrl3;
    }

    public Integer getUrl3Type() {
        return url3Type;
    }

    public void setUrl3Type(Integer url3Type) {
        this.url3Type = url3Type;
    }

    public String getDetailUrl4() {
        return detailUrl4;
    }

    public void setDetailUrl4(String detailUrl4) {
        this.detailUrl4 = detailUrl4;
    }

    public Integer getUrl4Type() {
        return url4Type;
    }

    public void setUrl4Type(Integer url4Type) {
        this.url4Type = url4Type;
    }

    public String getDetailUrl5() {
        return detailUrl5;
    }

    public void setDetailUrl5(String detailUrl5) {
        this.detailUrl5 = detailUrl5;
    }

    public Integer getUrl5Type() {
        return url5Type;
    }

    public void setUrl5Type(Integer url5Type) {
        this.url5Type = url5Type;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
