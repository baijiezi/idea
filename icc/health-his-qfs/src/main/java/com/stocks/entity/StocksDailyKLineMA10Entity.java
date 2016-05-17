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
 * Time: 下午11:02
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "sic_stocks_daily_kline_ma10")
public class StocksDailyKLineMA10Entity implements Serializable {
    private static final Long serialVersionUID = 4056159671745964756L;

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

    public String toSql(){
        StringBuffer sb = new StringBuffer("INSERT INTO `sic_stocks_daily_kline_ma10` VALUES (");
        sb.append(id==null ? "null," : "'"+id+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(name==null ? "null," : "'',");
        sb.append(date==null ? "null," : "'"+date+"',");
        sb.append(shouPan==null ? "null," : "'"+shouPan+"',");
        sb.append(junJia==null ? "null," : "'"+junJia+"',");
        sb.append(zhangFu==null ? "null," : "'"+zhangFu+"',");
        sb.append(zhangDie==null ? "null," : "'"+zhangDie+"',");
        sb.append(chengJiaoLiang==null ? "null," : "'"+chengJiaoLiang+"',");
        sb.append(ChengJiaoE==null ? "null," : "'"+ChengJiaoE+"',");
        sb.append(huanShou==null ? "null," : "'"+huanShou+"',");
        sb.append(liangBi==null ? "null," : "'"+liangBi+"',");
        sb.append(zuiGao==null ? "null," : "'"+zuiGao+"',");
        sb.append(zuiDi==null ? "null," : "'"+zuiDi+"',");
        sb.append(zhenFu==null ? "null," : "'"+zhenFu+"',");
        sb.append(waiPan==null ? "null," : "'"+waiPan+"',");
        sb.append(neiPan==null ? "null," : "'"+neiPan+"',");
        sb.append(panCha==null ? "null," : "'"+panCha+"',");
        sb.append(panBi==null ? "null," : "'"+panBi+"',");
        sb.append(weiBi==null ? "null," : "'"+weiBi+"',");
        sb.append(weiCha==null ? "null," : "'"+weiCha+"',");
        sb.append(createTime==null ? "null," : "'"+createTime+"'");
        sb.append(");");
        return sb.toString();
    }
}
