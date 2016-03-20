package com.stocks.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntegerelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-3
 * Time: 下午5:38
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "sic_stocks_price")
public class StocksPriceEntity implements Serializable {
    private static final Long serialVersionUID = 4056982271617961504L;

    @Id
    @GeneratedValue
    private Integer id;
    private String code;
    private String name;
    private Date date;
    private Integer shouPan;
    private Integer junJia;
    private Integer zhangFu;
    private Integer zhangDie;
    private Long chengJiaoLiang;
    private Long ChengJiaoE;
    private Integer huanShou;
    private Integer liangBi;
    private Integer zuiGao;
    private Integer zuiDi;
    private Integer zhenFu;
    private Integer jinKai;
    private Integer zuoShou;
    private Integer zhangTing;
    private Integer dieTing;
    private Integer waiPan;
    private Integer neiPan;
    private Integer panCha;
    private Integer panBi;
    private Long shiYing;
    private Long shiJing;
    private Long zongShiZhi;
    private Long liuTongShiZhi;
    private Integer weiBi;
    private Integer weiCha;
    private Integer buyOne1;
    private Integer buyOne2;
    private Integer buyTwo1;
    private Integer buyTwo2;
    private Integer buyThree1;
    private Integer buyThree2;
    private Integer buyFour1;
    private Integer buyFour2;
    private Integer buyFive1;
    private Integer buyFive2;
    private Integer saleOne1;
    private Integer saleOne2;
    private Integer saleTwo1;
    private Integer saleTwo2;
    private Integer saleThree1;
    private Integer saleThree2;
    private Integer saleFour1;
    private Integer saleFour2;
    private Integer saleFive1;
    private Integer saleFive2;
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

    public Integer getShouPan() {
        return shouPan;
    }

    public void setShouPan(Integer shouPan) {
        this.shouPan = shouPan;
    }

    public Integer getJunJia() {
        return junJia;
    }

    public void setJunJia(Integer junJia) {
        this.junJia = junJia;
    }

    public Integer getZhangFu() {
        return zhangFu;
    }

    public void setZhangFu(Integer zhangFu) {
        this.zhangFu = zhangFu;
    }

    public Integer getZhangDie() {
        return zhangDie;
    }

    public void setZhangDie(Integer zhangDie) {
        this.zhangDie = zhangDie;
    }

    public Long getChengJiaoLiang() {
        return chengJiaoLiang;
    }

    public void setChengJiaoLiang(Long chengJiaoLiang) {
        this.chengJiaoLiang = chengJiaoLiang;
    }

    public Long getChengJiaoE() {
        return ChengJiaoE;
    }

    public void setChengJiaoE(Long chengJiaoE) {
        ChengJiaoE = chengJiaoE;
    }

    public Integer getHuanShou() {
        return huanShou;
    }

    public void setHuanShou(Integer huanShou) {
        this.huanShou = huanShou;
    }

    public Integer getLiangBi() {
        return liangBi;
    }

    public void setLiangBi(Integer liangBi) {
        this.liangBi = liangBi;
    }

    public Integer getZuiGao() {
        return zuiGao;
    }

    public void setZuiGao(Integer zuiGao) {
        this.zuiGao = zuiGao;
    }

    public Integer getZuiDi() {
        return zuiDi;
    }

    public void setZuiDi(Integer zuiDi) {
        this.zuiDi = zuiDi;
    }

    public Integer getJinKai() {
        return jinKai;
    }

    public void setJinKai(Integer jinKai) {
        this.jinKai = jinKai;
    }

    public Integer getZuoShou() {
        return zuoShou;
    }

    public void setZuoShou(Integer zuoShou) {
        this.zuoShou = zuoShou;
    }

    public Integer getZhangTing() {
        return zhangTing;
    }

    public void setZhangTing(Integer zhangTing) {
        this.zhangTing = zhangTing;
    }

    public Integer getDieTing() {
        return dieTing;
    }

    public void setDieTing(Integer dieTing) {
        this.dieTing = dieTing;
    }

    public Integer getWaiPan() {
        return waiPan;
    }

    public void setWaiPan(Integer waiPan) {
        this.waiPan = waiPan;
    }

    public Integer getNeiPan() {
        return neiPan;
    }

    public void setNeiPan(Integer neiPan) {
        this.neiPan = neiPan;
    }

    public Long getShiYing() {
        return shiYing;
    }

    public void setShiYing(Long shiYing) {
        this.shiYing = shiYing;
    }

    public Long getShiJing() {
        return shiJing;
    }

    public void setShiJing(Long shiJing) {
        this.shiJing = shiJing;
    }

    public Long getZongShiZhi() {
        return zongShiZhi;
    }

    public void setZongShiZhi(Long zongShiZhi) {
        this.zongShiZhi = zongShiZhi;
    }

    public Long getLiuTongShiZhi() {
        return liuTongShiZhi;
    }

    public void setLiuTongShiZhi(Long liuTongShiZhi) {
        this.liuTongShiZhi = liuTongShiZhi;
    }

    public Integer getWeiBi() {
        return weiBi;
    }

    public void setWeiBi(Integer weiBi) {
        this.weiBi = weiBi;
    }

    public Integer getWeiCha() {
        return weiCha;
    }

    public void setWeiCha(Integer weiCha) {
        this.weiCha = weiCha;
    }

    public Integer getBuyOne1() {
        return buyOne1;
    }

    public void setBuyOne1(Integer buyOne1) {
        this.buyOne1 = buyOne1;
    }

    public Integer getBuyOne2() {
        return buyOne2;
    }

    public void setBuyOne2(Integer buyOne2) {
        this.buyOne2 = buyOne2;
    }

    public Integer getBuyTwo1() {
        return buyTwo1;
    }

    public void setBuyTwo1(Integer buyTwo1) {
        this.buyTwo1 = buyTwo1;
    }

    public Integer getBuyTwo2() {
        return buyTwo2;
    }

    public void setBuyTwo2(Integer buyTwo2) {
        this.buyTwo2 = buyTwo2;
    }

    public Integer getBuyThree1() {
        return buyThree1;
    }

    public void setBuyThree1(Integer buyThree1) {
        this.buyThree1 = buyThree1;
    }

    public Integer getBuyThree2() {
        return buyThree2;
    }

    public void setBuyThree2(Integer buyThree2) {
        this.buyThree2 = buyThree2;
    }

    public Integer getBuyFour1() {
        return buyFour1;
    }

    public void setBuyFour1(Integer buyFour1) {
        this.buyFour1 = buyFour1;
    }

    public Integer getBuyFour2() {
        return buyFour2;
    }

    public void setBuyFour2(Integer buyFour2) {
        this.buyFour2 = buyFour2;
    }

    public Integer getBuyFive1() {
        return buyFive1;
    }

    public void setBuyFive1(Integer buyFive1) {
        this.buyFive1 = buyFive1;
    }

    public Integer getBuyFive2() {
        return buyFive2;
    }

    public void setBuyFive2(Integer buyFive2) {
        this.buyFive2 = buyFive2;
    }

    public Integer getSaleOne1() {
        return saleOne1;
    }

    public void setSaleOne1(Integer saleOne1) {
        this.saleOne1 = saleOne1;
    }

    public Integer getSaleOne2() {
        return saleOne2;
    }

    public void setSaleOne2(Integer saleOne2) {
        this.saleOne2 = saleOne2;
    }

    public Integer getSaleTwo1() {
        return saleTwo1;
    }

    public void setSaleTwo1(Integer saleTwo1) {
        this.saleTwo1 = saleTwo1;
    }

    public Integer getSaleTwo2() {
        return saleTwo2;
    }

    public void setSaleTwo2(Integer saleTwo2) {
        this.saleTwo2 = saleTwo2;
    }

    public Integer getSaleThree1() {
        return saleThree1;
    }

    public void setSaleThree1(Integer saleThree1) {
        this.saleThree1 = saleThree1;
    }

    public Integer getSaleThree2() {
        return saleThree2;
    }

    public void setSaleThree2(Integer saleThree2) {
        this.saleThree2 = saleThree2;
    }

    public Integer getSaleFour1() {
        return saleFour1;
    }

    public void setSaleFour1(Integer saleFour1) {
        this.saleFour1 = saleFour1;
    }

    public Integer getSaleFour2() {
        return saleFour2;
    }

    public void setSaleFour2(Integer saleFour2) {
        this.saleFour2 = saleFour2;
    }

    public Integer getSaleFive1() {
        return saleFive1;
    }

    public void setSaleFive1(Integer saleFive1) {
        this.saleFive1 = saleFive1;
    }

    public Integer getSaleFive2() {
        return saleFive2;
    }

    public void setSaleFive2(Integer saleFive2) {
        this.saleFive2 = saleFive2;
    }

    public Integer getZhenFu() {
        return zhenFu;
    }

    public void setZhenFu(Integer zhenFu) {
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

    public Integer getPanCha() {
        return panCha;
    }

    public void setPanCha(Integer panCha) {
        this.panCha = panCha;
    }

    public Integer getPanBi() {
        return panBi;
    }

    public void setPanBi(Integer panBi) {
        this.panBi = panBi;
    }
}
