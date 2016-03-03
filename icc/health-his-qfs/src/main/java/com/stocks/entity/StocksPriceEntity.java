package com.stocks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-3
 * Time: 下午5:38
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "sic_stocks_price")
public class StocksPriceEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String code;
    private String name;
    private Date date;
    private int shouPan;
    private int junJia;
    private int zhangFu;
    private int zhangDie;
    private long chengJiaoLiang;
    private long ChengJiaoE;
    private int huanShou;
    private int liangBi;
    private int zuiGao;
    private int zuiDi;
    private int jinKai;
    private int zuoShou;
    private int zhangTing;
    private int dieTing;
    private int waiPan;
    private int neiPan;
    private long shiYing;
    private long shiJing;
    private long zongShiZhi;
    private long liuTongShiZhi;

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

    public int getShouPan() {
        return shouPan;
    }

    public void setShouPan(int shouPan) {
        this.shouPan = shouPan;
    }

    public int getJunJia() {
        return junJia;
    }

    public void setJunJia(int junJia) {
        this.junJia = junJia;
    }

    public int getZhangFu() {
        return zhangFu;
    }

    public void setZhangFu(int zhangFu) {
        this.zhangFu = zhangFu;
    }

    public int getZhangDie() {
        return zhangDie;
    }

    public void setZhangDie(int zhangDie) {
        this.zhangDie = zhangDie;
    }

    public long getChengJiaoLiang() {
        return chengJiaoLiang;
    }

    public void setChengJiaoLiang(long chengJiaoLiang) {
        this.chengJiaoLiang = chengJiaoLiang;
    }

    public long getChengJiaoE() {
        return ChengJiaoE;
    }

    public void setChengJiaoE(long chengJiaoE) {
        ChengJiaoE = chengJiaoE;
    }

    public int getHuanShou() {
        return huanShou;
    }

    public void setHuanShou(int huanShou) {
        this.huanShou = huanShou;
    }

    public int getLiangBi() {
        return liangBi;
    }

    public void setLiangBi(int liangBi) {
        this.liangBi = liangBi;
    }

    public int getZuiGao() {
        return zuiGao;
    }

    public void setZuiGao(int zuiGao) {
        this.zuiGao = zuiGao;
    }

    public int getZuiDi() {
        return zuiDi;
    }

    public void setZuiDi(int zuiDi) {
        this.zuiDi = zuiDi;
    }

    public int getJinKai() {
        return jinKai;
    }

    public void setJinKai(int jinKai) {
        this.jinKai = jinKai;
    }

    public int getZuoShou() {
        return zuoShou;
    }

    public void setZuoShou(int zuoShou) {
        this.zuoShou = zuoShou;
    }

    public int getZhangTing() {
        return zhangTing;
    }

    public void setZhangTing(int zhangTing) {
        this.zhangTing = zhangTing;
    }

    public int getDieTing() {
        return dieTing;
    }

    public void setDieTing(int dieTing) {
        this.dieTing = dieTing;
    }

    public int getWaiPan() {
        return waiPan;
    }

    public void setWaiPan(int waiPan) {
        this.waiPan = waiPan;
    }

    public int getNeiPan() {
        return neiPan;
    }

    public void setNeiPan(int neiPan) {
        this.neiPan = neiPan;
    }

    public long getShiYing() {
        return shiYing;
    }

    public void setShiYing(long shiYing) {
        this.shiYing = shiYing;
    }

    public long getShiJing() {
        return shiJing;
    }

    public void setShiJing(long shiJing) {
        this.shiJing = shiJing;
    }

    public long getZongShiZhi() {
        return zongShiZhi;
    }

    public void setZongShiZhi(long zongShiZhi) {
        this.zongShiZhi = zongShiZhi;
    }

    public long getLiuTongShiZhi() {
        return liuTongShiZhi;
    }

    public void setLiuTongShiZhi(long liuTongShiZhi) {
        this.liuTongShiZhi = liuTongShiZhi;
    }
}
