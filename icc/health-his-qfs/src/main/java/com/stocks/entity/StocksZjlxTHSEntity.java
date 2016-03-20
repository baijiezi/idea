package com.stocks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 16-3-14
 * Time: 下午9:55
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "sic_stocks_zjlx_ths")
public class StocksZjlxTHSEntity  implements java.io.Serializable  {

    private static final long serialVersionUID = -134098768522357926L;

    @Id
    @GeneratedValue
    private Integer id;
    private String code;
    private String name;
    private Date date;
    private long chengJiaoE;
    private long zongLiuRu;
    private long zongLiuChu;
    private long jingLiuRu;
    private int jingLiuRuZhanBi;
    private long daDanLiuRu;
    private int daDanLiuRuZhanBi;
    private long daDanLiuChu;
    private int daDanLiuChuZhanBi;
    private long zhongDanLiuRu;
    private int zhongDanLiuRuZhanBi;
    private long zhongDanLiuChu;
    private int zhongDanLiuChuZhanBi;
    private long xiaoDanLiuRu;
    private int xiaoDanLiuRuZhanBi;
    private long xiaoDanLiuChu;
    private int xiaoDanLiuChuZhanBi;
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

    public long getChengJiaoE() {
        return chengJiaoE;
    }

    public void setChengJiaoE(long chengJiaoE) {
        this.chengJiaoE = chengJiaoE;
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

    public long getJingLiuRu() {
        return jingLiuRu;
    }

    public void setJingLiuRu(long jingLiuRu) {
        this.jingLiuRu = jingLiuRu;
    }

    public int getJingLiuRuZhanBi() {
        return jingLiuRuZhanBi;
    }

    public void setJingLiuRuZhanBi(int jingLiuRuZhanBi) {
        this.jingLiuRuZhanBi = jingLiuRuZhanBi;
    }

    public long getDaDanLiuRu() {
        return daDanLiuRu;
    }

    public void setDaDanLiuRu(long daDanLiuRu) {
        this.daDanLiuRu = daDanLiuRu;
    }

    public int getDaDanLiuRuZhanBi() {
        return daDanLiuRuZhanBi;
    }

    public void setDaDanLiuRuZhanBi(int daDanLiuRuZhanBi) {
        this.daDanLiuRuZhanBi = daDanLiuRuZhanBi;
    }

    public long getDaDanLiuChu() {
        return daDanLiuChu;
    }

    public void setDaDanLiuChu(long daDanLiuChu) {
        this.daDanLiuChu = daDanLiuChu;
    }

    public int getDaDanLiuChuZhanBi() {
        return daDanLiuChuZhanBi;
    }

    public void setDaDanLiuChuZhanBi(int daDanLiuChuZhanBi) {
        this.daDanLiuChuZhanBi = daDanLiuChuZhanBi;
    }

    public long getZhongDanLiuRu() {
        return zhongDanLiuRu;
    }

    public void setZhongDanLiuRu(long zhongDanLiuRu) {
        this.zhongDanLiuRu = zhongDanLiuRu;
    }

    public int getZhongDanLiuRuZhanBi() {
        return zhongDanLiuRuZhanBi;
    }

    public void setZhongDanLiuRuZhanBi(int zhongDanLiuRuZhanBi) {
        this.zhongDanLiuRuZhanBi = zhongDanLiuRuZhanBi;
    }

    public long getZhongDanLiuChu() {
        return zhongDanLiuChu;
    }

    public void setZhongDanLiuChu(long zhongDanLiuChu) {
        this.zhongDanLiuChu = zhongDanLiuChu;
    }

    public int getZhongDanLiuChuZhanBi() {
        return zhongDanLiuChuZhanBi;
    }

    public void setZhongDanLiuChuZhanBi(int zhongDanLiuChuZhanBi) {
        this.zhongDanLiuChuZhanBi = zhongDanLiuChuZhanBi;
    }

    public long getXiaoDanLiuRu() {
        return xiaoDanLiuRu;
    }

    public void setXiaoDanLiuRu(long xiaoDanLiuRu) {
        this.xiaoDanLiuRu = xiaoDanLiuRu;
    }

    public int getXiaoDanLiuRuZhanBi() {
        return xiaoDanLiuRuZhanBi;
    }

    public void setXiaoDanLiuRuZhanBi(int xiaoDanLiuRuZhanBi) {
        this.xiaoDanLiuRuZhanBi = xiaoDanLiuRuZhanBi;
    }

    public long getXiaoDanLiuChu() {
        return xiaoDanLiuChu;
    }

    public void setXiaoDanLiuChu(long xiaoDanLiuChu) {
        this.xiaoDanLiuChu = xiaoDanLiuChu;
    }

    public int getXiaoDanLiuChuZhanBi() {
        return xiaoDanLiuChuZhanBi;
    }

    public void setXiaoDanLiuChuZhanBi(int xiaoDanLiuChuZhanBi) {
        this.xiaoDanLiuChuZhanBi = xiaoDanLiuChuZhanBi;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
