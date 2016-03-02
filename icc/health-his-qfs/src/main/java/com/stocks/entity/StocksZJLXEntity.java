package com.stocks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-2
 * Time: 下午11:21
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "sic_stocks_zjlx")
public class StocksZJLXEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String code;
    private String name;
    private Date date;
    private long zhuLiLiuRu;
    private long zhuLiLiuChu;
    private long zhuLiJingLiuRu;
    private long chaoDaLiuRu;
    private long chaoDaLiuChu;
    private long jingChaoDa;
    private long daDanLiuRu;
    private long daDanLiuChu;
    private long jingDaDan;
    private long zhongDanLiuRu;
    private long zhongDanLiuChu;
    private long jingZhongDan;
    private long xiaoDanLiuRu;
    private long xiaoDanLiuChu;
    private long jingXiaoDan;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getZhuLiLiuRu() {
        return zhuLiLiuRu;
    }

    public void setZhuLiLiuRu(long zhuLiLiuRu) {
        this.zhuLiLiuRu = zhuLiLiuRu;
    }

    public long getZhuLiLiuChu() {
        return zhuLiLiuChu;
    }

    public void setZhuLiLiuChu(long zhuLiLiuChu) {
        this.zhuLiLiuChu = zhuLiLiuChu;
    }

    public long getZhuLiJingLiuRu() {
        return zhuLiJingLiuRu;
    }

    public void setZhuLiJingLiuRu(long zhuLiJingLiuRu) {
        this.zhuLiJingLiuRu = zhuLiJingLiuRu;
    }

    public long getChaoDaLiuRu() {
        return chaoDaLiuRu;
    }

    public void setChaoDaLiuRu(long chaoDaLiuRu) {
        this.chaoDaLiuRu = chaoDaLiuRu;
    }

    public long getChaoDaLiuChu() {
        return chaoDaLiuChu;
    }

    public void setChaoDaLiuChu(long chaoDaLiuChu) {
        this.chaoDaLiuChu = chaoDaLiuChu;
    }

    public long getJingChaoDa() {
        return jingChaoDa;
    }

    public void setJingChaoDa(long jingChaoDa) {
        this.jingChaoDa = jingChaoDa;
    }

    public long getDaDanLiuRu() {
        return daDanLiuRu;
    }

    public void setDaDanLiuRu(long daDanLiuRu) {
        this.daDanLiuRu = daDanLiuRu;
    }

    public long getDaDanLiuChu() {
        return daDanLiuChu;
    }

    public void setDaDanLiuChu(long daDanLiuChu) {
        this.daDanLiuChu = daDanLiuChu;
    }

    public long getJingDaDan() {
        return jingDaDan;
    }

    public void setJingDaDan(long jingDaDan) {
        this.jingDaDan = jingDaDan;
    }

    public long getZhongDanLiuRu() {
        return zhongDanLiuRu;
    }

    public void setZhongDanLiuRu(long zhongDanLiuRu) {
        this.zhongDanLiuRu = zhongDanLiuRu;
    }

    public long getZhongDanLiuChu() {
        return zhongDanLiuChu;
    }

    public void setZhongDanLiuChu(long zhongDanLiuChu) {
        this.zhongDanLiuChu = zhongDanLiuChu;
    }

    public long getJingZhongDan() {
        return jingZhongDan;
    }

    public void setJingZhongDan(long jingZhongDan) {
        this.jingZhongDan = jingZhongDan;
    }

    public long getXiaoDanLiuRu() {
        return xiaoDanLiuRu;
    }

    public void setXiaoDanLiuRu(long xiaoDanLiuRu) {
        this.xiaoDanLiuRu = xiaoDanLiuRu;
    }

    public long getXiaoDanLiuChu() {
        return xiaoDanLiuChu;
    }

    public void setXiaoDanLiuChu(long xiaoDanLiuChu) {
        this.xiaoDanLiuChu = xiaoDanLiuChu;
    }

    public long getJingXiaoDan() {
        return jingXiaoDan;
    }

    public void setJingXiaoDan(long jingXiaoDan) {
        this.jingXiaoDan = jingXiaoDan;
    }
}
