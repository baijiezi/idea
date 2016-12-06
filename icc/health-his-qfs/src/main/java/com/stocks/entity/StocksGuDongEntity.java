package com.stocks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-11-22
 * Time: 上午10:06
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "sic_stocks_gudong")
public class StocksGuDongEntity implements Serializable {

    private static final long serialVersionUID = -5363037030064417628L;

    @Id
    @GeneratedValue
    private Integer id;
    private String code;
    private Date date;
    private String name;
    private String gdName;
    private String gdXingZhi;
    private String guFenLeiXing;
    private Integer chiGuShu;
    private Integer biLv;
    private String zengJian;
    private Integer bianDongBiLv;
    private String title;
    private Date createTime;

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

    public String getGdName() {
        return gdName;
    }

    public void setGdName(String gdName) {
        this.gdName = gdName;
    }

    public String getGdXingZhi() {
        return gdXingZhi;
    }

    public void setGdXingZhi(String gdXingZhi) {
        this.gdXingZhi = gdXingZhi;
    }

    public String getGuFenLeiXing() {
        return guFenLeiXing;
    }

    public void setGuFenLeiXing(String guFenLeiXing) {
        this.guFenLeiXing = guFenLeiXing;
    }

    public Integer getChiGuShu() {
        return chiGuShu;
    }

    public void setChiGuShu(Integer chiGuShu) {
        this.chiGuShu = chiGuShu;
    }

    public Integer getBiLv() {
        return biLv;
    }

    public void setBiLv(Integer biLv) {
        this.biLv = biLv;
    }

    public String getZengJian() {
        return zengJian;
    }

    public void setZengJian(String zengJian) {
        this.zengJian = zengJian;
    }

    public Integer getBianDongBiLv() {
        return bianDongBiLv;
    }

    public void setBianDongBiLv(Integer bianDongBiLv) {
        this.bianDongBiLv = bianDongBiLv;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
