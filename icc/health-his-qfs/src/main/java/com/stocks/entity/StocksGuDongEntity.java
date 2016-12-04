package com.stocks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

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
    private String name;
    private String gdName;
    private String gdXingZhi;
    private String guFenLeiXing;
    private Integer chiGuShu;
    private Integer biLv;
    private Integer zengJian;
    private Integer bianDongBiLv;
    private String fenLei;

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

    public Integer getZengJian() {
        return zengJian;
    }

    public void setZengJian(Integer zengJian) {
        this.zengJian = zengJian;
    }

    public Integer getBianDongBiLv() {
        return bianDongBiLv;
    }

    public void setBianDongBiLv(Integer bianDongBiLv) {
        this.bianDongBiLv = bianDongBiLv;
    }

    public String getFenLei() {
        return fenLei;
    }

    public void setFenLei(String fenLei) {
        this.fenLei = fenLei;
    }
}
