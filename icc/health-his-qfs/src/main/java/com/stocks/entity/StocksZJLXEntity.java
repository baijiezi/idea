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
    private long zongLiuRu;
    private long zongLiuChu;
    private long zongJing;
    private long zhuLiLiuRu;
    private long zhuLiLiuChu;
    private long zhuLiJingLiuRu;
    private long zhuLiJingBi;
    private long chaoDaDanLiuRu;
    private long chaoDaDanLiuChu;
    private long chaoDaDanJingLiuRu;
    private long chaoDaDanJingBi;
    private long daDanLiuRu;
    private long daDanLiuChu;
    private long daDanJingLiuRu;
    private long daDanJingBi;
    private long zhongDanLiuRu;
    private long zhongDanLiuChu;
    private long zhongDanJingLiuRu;
    private long zhongDanJingBi;
    private long xiaoDanLiuRu;
    private long xiaoDanLiuChu;
    private long xiaoDanJingLiuRu;
    private long xiaoDanJingBi;

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

    public long getZongLiuRu() {
        return zongLiuRu;
    }

    public void setZongLiuRu(long zongLiuRu) {
        this.zongLiuRu = zongLiuRu;
    }

    public long getZongLiuChu() {
        return zongLiuChu;
    }

    public void setZongLiuChu(long zongLiuChu) {
        this.zongLiuChu = zongLiuChu;
    }

    public long getZongJing() {
        return zongJing;
    }

    public void setZongJing(long zongJing) {
        this.zongJing = zongJing;
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

    public long getChaoDaDanLiuRu() {
        return chaoDaDanLiuRu;
    }

    public void setChaoDaDanLiuRu(long chaoDaDanLiuRu) {
        this.chaoDaDanLiuRu = chaoDaDanLiuRu;
    }

    public long getChaoDaDanLiuChu() {
        return chaoDaDanLiuChu;
    }

    public void setChaoDaDanLiuChu(long chaoDaDanLiuChu) {
        this.chaoDaDanLiuChu = chaoDaDanLiuChu;
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

    public long getZhuLiJingBi() {
        return zhuLiJingBi;
    }

    public void setZhuLiJingBi(long zhuLiJingBi) {
        this.zhuLiJingBi = zhuLiJingBi;
    }

    public long getChaoDaDanJingLiuRu() {
        return chaoDaDanJingLiuRu;
    }

    public void setChaoDaDanJingLiuRu(long chaoDaDanJingLiuRu) {
        this.chaoDaDanJingLiuRu = chaoDaDanJingLiuRu;
    }

    public long getChaoDaDanJingBi() {
        return chaoDaDanJingBi;
    }

    public void setChaoDaDanJingBi(long chaoDaDanJingBi) {
        this.chaoDaDanJingBi = chaoDaDanJingBi;
    }

    public long getDaDanJingLiuRu() {
        return daDanJingLiuRu;
    }

    public void setDaDanJingLiuRu(long daDanJingLiuRu) {
        this.daDanJingLiuRu = daDanJingLiuRu;
    }

    public long getDaDanJingBi() {
        return daDanJingBi;
    }

    public void setDaDanJingBi(long daDanJingBi) {
        this.daDanJingBi = daDanJingBi;
    }

    public long getZhongDanJingLiuRu() {
        return zhongDanJingLiuRu;
    }

    public void setZhongDanJingLiuRu(long zhongDanJingLiuRu) {
        this.zhongDanJingLiuRu = zhongDanJingLiuRu;
    }

    public long getZhongDanJingBi() {
        return zhongDanJingBi;
    }

    public void setZhongDanJingBi(long zhongDanJingBi) {
        this.zhongDanJingBi = zhongDanJingBi;
    }

    public long getXiaoDanJingLiuRu() {
        return xiaoDanJingLiuRu;
    }

    public void setXiaoDanJingLiuRu(long xiaoDanJingLiuRu) {
        this.xiaoDanJingLiuRu = xiaoDanJingLiuRu;
    }

    public long getXiaoDanJingBi() {
        return xiaoDanJingBi;
    }

    public void setXiaoDanJingBi(long xiaoDanJingBi) {
        this.xiaoDanJingBi = xiaoDanJingBi;
    }
}
