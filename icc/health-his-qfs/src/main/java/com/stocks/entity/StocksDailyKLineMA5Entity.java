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
 * Date: 16-4-13
 * Time: 下午8:36
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "sic_stocks_daily_kline_ma5")
public class StocksDailyKLineMA5Entity implements Serializable {
    private static final Long serialVersionUID = 4056958771745964178L;

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
    private Integer waiPan;
    private Integer neiPan;
    private Integer panCha;
    private Integer panBi;
    private Integer weiBi;
    private Integer weiCha;
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

    public Integer getZhenFu() {
        return zhenFu;
    }

    public void setZhenFu(Integer zhenFu) {
        this.zhenFu = zhenFu;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
