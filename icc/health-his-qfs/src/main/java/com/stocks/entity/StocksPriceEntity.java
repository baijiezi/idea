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
    private String priceTrends;
    private Integer weiBi;
    private Integer weiCha;
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

    public Integer getZhenFu() {
        return zhenFu;
    }

    public void setZhenFu(Integer zhenFu) {
        this.zhenFu = zhenFu;
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

    public String getPriceTrends() {
        return priceTrends;
    }

    public void setPriceTrends(String priceTrends) {
        this.priceTrends = priceTrends;
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

    public StocksEntity getStocksEntity() {
        return stocksEntity;
    }

    public void setStocksEntity(StocksEntity stocksEntity) {
        this.stocksEntity = stocksEntity;
    }

    public String toSql(){
        StringBuffer sb = new StringBuffer("INSERT INTO `sic_stocks_price` VALUES (");
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
        sb.append(jinKai==null ? "null," : "'"+jinKai+"',");
        sb.append(zuoShou==null ? "null," : "'"+zuoShou+"',");
        sb.append(zhangTing==null ? "null," : "'"+zhangTing+"',");
        sb.append(dieTing==null ? "null," : "'"+dieTing+"',");
        sb.append(waiPan==null ? "null," : "'"+waiPan+"',");
        sb.append(neiPan==null ? "null," : "'"+neiPan+"',");
        sb.append(panCha==null ? "null," : "'"+panCha+"',");
        sb.append(panBi==null ? "null," : "'"+panBi+"',");
        sb.append(shiYing==null ? "null," : "'"+shiYing+"',");
        sb.append(shiJing==null ? "null," : "'"+shiJing+"',");
        sb.append(zongShiZhi==null ? "null," : "'"+zongShiZhi+"',");
        sb.append(liuTongShiZhi==null ? "null," : "'"+liuTongShiZhi+"',");
        sb.append(priceTrends==null ? "null," : "'"+priceTrends+"',");
        sb.append(weiBi==null ? "null," : "'"+weiBi+"',");
        sb.append(weiCha==null ? "null," : "'"+weiCha+"',");
        sb.append(createTime==null ? "null," : "'"+createTime+"'");
        sb.append(");");
        return sb.toString();
    }
}
