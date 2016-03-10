package com.stocks.entity;

import javax.persistence.*;
import java.io.Serializable;
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
public class StocksPriceEntity implements Serializable {
    private static final long serialVersionUID = 4056982271617961504L;

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
    private int zhenFu;
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
    private int weiBi;
    private int weiCha;
    private int buyOne1;
    private int buyOne2;
    private int buyTwo1;
    private int buyTwo2;
    private int buyThree1;
    private int buyThree2;
    private int buyFour1;
    private int buyFour2;
    private int buyFive1;
    private int buyFive2;
    private int saleOne1;
    private int saleOne2;
    private int saleTwo1;
    private int saleTwo2;
    private int saleThree1;
    private int saleThree2;
    private int saleFour1;
    private int saleFour2;
    private int saleFive1;
    private int saleFive2;
    private Date createTime;

    @ManyToOne(cascade = CascadeType.REFRESH, optional = false,fetch=FetchType.LAZY)
    @JoinColumn(name = "code", referencedColumnName="code", insertable = false, updatable = false)
    private StocksEntity stocksEntity;//上级科室


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

    public int getWeiBi() {
        return weiBi;
    }

    public void setWeiBi(int weiBi) {
        this.weiBi = weiBi;
    }

    public int getWeiCha() {
        return weiCha;
    }

    public void setWeiCha(int weiCha) {
        this.weiCha = weiCha;
    }

    public int getBuyOne1() {
        return buyOne1;
    }

    public void setBuyOne1(int buyOne1) {
        this.buyOne1 = buyOne1;
    }

    public int getBuyOne2() {
        return buyOne2;
    }

    public void setBuyOne2(int buyOne2) {
        this.buyOne2 = buyOne2;
    }

    public int getBuyTwo1() {
        return buyTwo1;
    }

    public void setBuyTwo1(int buyTwo1) {
        this.buyTwo1 = buyTwo1;
    }

    public int getBuyTwo2() {
        return buyTwo2;
    }

    public void setBuyTwo2(int buyTwo2) {
        this.buyTwo2 = buyTwo2;
    }

    public int getBuyThree1() {
        return buyThree1;
    }

    public void setBuyThree1(int buyThree1) {
        this.buyThree1 = buyThree1;
    }

    public int getBuyThree2() {
        return buyThree2;
    }

    public void setBuyThree2(int buyThree2) {
        this.buyThree2 = buyThree2;
    }

    public int getBuyFour1() {
        return buyFour1;
    }

    public void setBuyFour1(int buyFour1) {
        this.buyFour1 = buyFour1;
    }

    public int getBuyFour2() {
        return buyFour2;
    }

    public void setBuyFour2(int buyFour2) {
        this.buyFour2 = buyFour2;
    }

    public int getBuyFive1() {
        return buyFive1;
    }

    public void setBuyFive1(int buyFive1) {
        this.buyFive1 = buyFive1;
    }

    public int getBuyFive2() {
        return buyFive2;
    }

    public void setBuyFive2(int buyFive2) {
        this.buyFive2 = buyFive2;
    }

    public int getSaleOne1() {
        return saleOne1;
    }

    public void setSaleOne1(int saleOne1) {
        this.saleOne1 = saleOne1;
    }

    public int getSaleOne2() {
        return saleOne2;
    }

    public void setSaleOne2(int saleOne2) {
        this.saleOne2 = saleOne2;
    }

    public int getSaleTwo1() {
        return saleTwo1;
    }

    public void setSaleTwo1(int saleTwo1) {
        this.saleTwo1 = saleTwo1;
    }

    public int getSaleTwo2() {
        return saleTwo2;
    }

    public void setSaleTwo2(int saleTwo2) {
        this.saleTwo2 = saleTwo2;
    }

    public int getSaleThree1() {
        return saleThree1;
    }

    public void setSaleThree1(int saleThree1) {
        this.saleThree1 = saleThree1;
    }

    public int getSaleThree2() {
        return saleThree2;
    }

    public void setSaleThree2(int saleThree2) {
        this.saleThree2 = saleThree2;
    }

    public int getSaleFour1() {
        return saleFour1;
    }

    public void setSaleFour1(int saleFour1) {
        this.saleFour1 = saleFour1;
    }

    public int getSaleFour2() {
        return saleFour2;
    }

    public void setSaleFour2(int saleFour2) {
        this.saleFour2 = saleFour2;
    }

    public int getSaleFive1() {
        return saleFive1;
    }

    public void setSaleFive1(int saleFive1) {
        this.saleFive1 = saleFive1;
    }

    public int getSaleFive2() {
        return saleFive2;
    }

    public void setSaleFive2(int saleFive2) {
        this.saleFive2 = saleFive2;
    }

    public int getZhenFu() {
        return zhenFu;
    }

    public void setZhenFu(int zhenFu) {
        this.zhenFu = zhenFu;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public StocksEntity getStocksEntity() {
        return stocksEntity;
    }

    public void setStocksEntity(StocksEntity stocksEntity) {
        this.stocksEntity = stocksEntity;
    }
}
