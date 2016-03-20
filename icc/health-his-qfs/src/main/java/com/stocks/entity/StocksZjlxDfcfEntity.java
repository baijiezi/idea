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
@Table(name = "sic_stocks_zjlx_dfcf")
public class StocksZjlxDfcfEntity implements java.io.Serializable {

    private static final Long serialVersionUID = -134055668722486042L;

    @Id
    @GeneratedValue
    private Integer id;
    private String code;
    private String name;
    private Date date;
    private Long zongLiuRu;
    private Long zongLiuChu;
    private Long zongJing;
    private Long zhuLiLiuRu;
    private Long zhuLiLiuChu;
    private Long zhuLiJingLiuRu;
    private Integer zhuLiJingBi;
    private Long chaoDaDanLiuRu;
    private Long chaoDaDanLiuChu;
    private Long chaoDaDanJingLiuRu;
    private Integer chaoDaDanJingBi;
    private Long daDanLiuRu;
    private Long daDanLiuChu;
    private Long daDanJingLiuRu;
    private Integer daDanJingBi;
    private Long zhongDanLiuRu;
    private Long zhongDanLiuChu;
    private Long zhongDanJingLiuRu;
    private Integer zhongDanJingBi;
    private Long xiaoDanLiuRu;
    private Long xiaoDanLiuChu;
    private Long xiaoDanJingLiuRu;
    private Integer xiaoDanJingBi;
    private Date createAt;

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

    public Long getZongLiuRu() {
        return zongLiuRu;
    }

    public void setZongLiuRu(Long zongLiuRu) {
        this.zongLiuRu = zongLiuRu;
    }

    public Long getZongLiuChu() {
        return zongLiuChu;
    }

    public void setZongLiuChu(Long zongLiuChu) {
        this.zongLiuChu = zongLiuChu;
    }

    public Long getZongJing() {
        return zongJing;
    }

    public void setZongJing(Long zongJing) {
        this.zongJing = zongJing;
    }

    public Long getZhuLiLiuRu() {
        return zhuLiLiuRu;
    }

    public void setZhuLiLiuRu(Long zhuLiLiuRu) {
        this.zhuLiLiuRu = zhuLiLiuRu;
    }

    public Long getZhuLiLiuChu() {
        return zhuLiLiuChu;
    }

    public void setZhuLiLiuChu(Long zhuLiLiuChu) {
        this.zhuLiLiuChu = zhuLiLiuChu;
    }

    public Long getZhuLiJingLiuRu() {
        return zhuLiJingLiuRu;
    }

    public void setZhuLiJingLiuRu(Long zhuLiJingLiuRu) {
        this.zhuLiJingLiuRu = zhuLiJingLiuRu;
    }

    public Integer getZhuLiJingBi() {
        return zhuLiJingBi;
    }

    public void setZhuLiJingBi(Integer zhuLiJingBi) {
        this.zhuLiJingBi = zhuLiJingBi;
    }

    public Long getChaoDaDanLiuRu() {
        return chaoDaDanLiuRu;
    }

    public void setChaoDaDanLiuRu(Long chaoDaDanLiuRu) {
        this.chaoDaDanLiuRu = chaoDaDanLiuRu;
    }

    public Long getChaoDaDanLiuChu() {
        return chaoDaDanLiuChu;
    }

    public void setChaoDaDanLiuChu(Long chaoDaDanLiuChu) {
        this.chaoDaDanLiuChu = chaoDaDanLiuChu;
    }

    public Long getChaoDaDanJingLiuRu() {
        return chaoDaDanJingLiuRu;
    }

    public void setChaoDaDanJingLiuRu(Long chaoDaDanJingLiuRu) {
        this.chaoDaDanJingLiuRu = chaoDaDanJingLiuRu;
    }

    public Integer getChaoDaDanJingBi() {
        return chaoDaDanJingBi;
    }

    public void setChaoDaDanJingBi(Integer chaoDaDanJingBi) {
        this.chaoDaDanJingBi = chaoDaDanJingBi;
    }

    public Long getDaDanLiuRu() {
        return daDanLiuRu;
    }

    public void setDaDanLiuRu(Long daDanLiuRu) {
        this.daDanLiuRu = daDanLiuRu;
    }

    public Long getDaDanLiuChu() {
        return daDanLiuChu;
    }

    public void setDaDanLiuChu(Long daDanLiuChu) {
        this.daDanLiuChu = daDanLiuChu;
    }

    public Long getDaDanJingLiuRu() {
        return daDanJingLiuRu;
    }

    public void setDaDanJingLiuRu(Long daDanJingLiuRu) {
        this.daDanJingLiuRu = daDanJingLiuRu;
    }

    public Integer getDaDanJingBi() {
        return daDanJingBi;
    }

    public void setDaDanJingBi(Integer daDanJingBi) {
        this.daDanJingBi = daDanJingBi;
    }

    public Long getZhongDanLiuRu() {
        return zhongDanLiuRu;
    }

    public void setZhongDanLiuRu(Long zhongDanLiuRu) {
        this.zhongDanLiuRu = zhongDanLiuRu;
    }

    public Long getZhongDanLiuChu() {
        return zhongDanLiuChu;
    }

    public void setZhongDanLiuChu(Long zhongDanLiuChu) {
        this.zhongDanLiuChu = zhongDanLiuChu;
    }

    public Long getZhongDanJingLiuRu() {
        return zhongDanJingLiuRu;
    }

    public void setZhongDanJingLiuRu(Long zhongDanJingLiuRu) {
        this.zhongDanJingLiuRu = zhongDanJingLiuRu;
    }

    public Integer getZhongDanJingBi() {
        return zhongDanJingBi;
    }

    public void setZhongDanJingBi(Integer zhongDanJingBi) {
        this.zhongDanJingBi = zhongDanJingBi;
    }

    public Long getXiaoDanLiuRu() {
        return xiaoDanLiuRu;
    }

    public void setXiaoDanLiuRu(Long xiaoDanLiuRu) {
        this.xiaoDanLiuRu = xiaoDanLiuRu;
    }

    public Long getXiaoDanLiuChu() {
        return xiaoDanLiuChu;
    }

    public void setXiaoDanLiuChu(Long xiaoDanLiuChu) {
        this.xiaoDanLiuChu = xiaoDanLiuChu;
    }

    public Long getXiaoDanJingLiuRu() {
        return xiaoDanJingLiuRu;
    }

    public void setXiaoDanJingLiuRu(Long xiaoDanJingLiuRu) {
        this.xiaoDanJingLiuRu = xiaoDanJingLiuRu;
    }

    public Integer getXiaoDanJingBi() {
        return xiaoDanJingBi;
    }

    public void setXiaoDanJingBi(Integer xiaoDanJingBi) {
        this.xiaoDanJingBi = xiaoDanJingBi;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
