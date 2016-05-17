package com.stocks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
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
public class StocksEntity implements Serializable {

    private static final long serialVersionUID = -5402442811467731711L;

    @Id
    @GeneratedValue
    private Integer id;
    private String code;
    private String name;
    private String exchange;
    private String type;
    private String subType;
    private String hangYe;
    private String detailUrl;
    private Integer buyPrice;
    private Integer salePrice;
    private String priceTaskType;
    private Date priceUpdate;
    private String zjlsDfcfTaskType;
    private Date zjlsDfcfUpdate;
    private String zjlsHxTaskType;
    private Date zjlsHxUpdate;
    private String zjlsThsTaskType;
    private Date zjlsThsUpdate;
    private Integer status;
    private Date createAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getHangYe() {
        return hangYe;
    }

    public void setHangYe(String hangYe) {
        this.hangYe = hangYe;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    public String getPriceTaskType() {
        return priceTaskType;
    }

    public void setPriceTaskType(String priceTaskType) {
        this.priceTaskType = priceTaskType;
    }

    public Date getPriceUpdate() {
        return priceUpdate;
    }

    public void setPriceUpdate(Date priceUpdate) {
        this.priceUpdate = priceUpdate;
    }

    public String getZjlsDfcfTaskType() {
        return zjlsDfcfTaskType;
    }

    public void setZjlsDfcfTaskType(String zjlsDfcfTaskType) {
        this.zjlsDfcfTaskType = zjlsDfcfTaskType;
    }

    public Date getZjlsDfcfUpdate() {
        return zjlsDfcfUpdate;
    }

    public void setZjlsDfcfUpdate(Date zjlsDfcfUpdate) {
        this.zjlsDfcfUpdate = zjlsDfcfUpdate;
    }

    public String getZjlsHxTaskType() {
        return zjlsHxTaskType;
    }

    public void setZjlsHxTaskType(String zjlsHxTaskType) {
        this.zjlsHxTaskType = zjlsHxTaskType;
    }

    public Date getZjlsHxUpdate() {
        return zjlsHxUpdate;
    }

    public void setZjlsHxUpdate(Date zjlsHxUpdate) {
        this.zjlsHxUpdate = zjlsHxUpdate;
    }

    public String getZjlsThsTaskType() {
        return zjlsThsTaskType;
    }

    public void setZjlsThsTaskType(String zjlsThsTaskType) {
        this.zjlsThsTaskType = zjlsThsTaskType;
    }

    public Date getZjlsThsUpdate() {
        return zjlsThsUpdate;
    }

    public void setZjlsThsUpdate(Date zjlsThsUpdate) {
        this.zjlsThsUpdate = zjlsThsUpdate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String toSql(){
        StringBuffer sb = new StringBuffer("INSERT INTO `sic_stocks` VALUES (");
        sb.append(id==null ? "null," : "'"+id+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(name==null ? "null," : "'"+name+"',");
        sb.append(exchange==null ? "null," : "'"+exchange+"',");
        sb.append(type==null ? "null," : "'"+type+"',");
        sb.append(subType==null ? "null," : "'"+subType+"',");
        sb.append(hangYe==null ? "null," : "'"+hangYe+"',");
        sb.append(detailUrl==null ? "null," : "'"+detailUrl+"',");
        sb.append(buyPrice==null ? "null," : "'"+buyPrice+"',");
        sb.append(salePrice==null ? "null," : "'"+salePrice+"',");
        sb.append(priceTaskType==null ? "null," : "'"+priceTaskType+"',");
        sb.append(priceUpdate==null ? "null," : "'"+priceUpdate+"',");
        sb.append(zjlsDfcfTaskType==null ? "null," : "'"+zjlsDfcfTaskType+"',");
        sb.append(zjlsDfcfUpdate==null ? "null," : "'"+zjlsDfcfUpdate+"',");
        sb.append(zjlsHxTaskType==null ? "null," : "'"+zjlsHxTaskType+"',");
        sb.append(zjlsHxUpdate==null ? "null," : "'"+zjlsHxUpdate+"',");
        sb.append(zjlsThsTaskType==null ? "null," : "'"+zjlsThsTaskType+"',");
        sb.append(zjlsThsUpdate==null ? "null," : "'"+zjlsThsUpdate+"',");
        sb.append(status==null ? "null," : "'"+status+"',");
        sb.append(createAt==null ? "null," : "'"+createAt+"'");
        sb.append(");");
        return sb.toString();
    }
}
