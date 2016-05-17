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
    private Long chengJiaoE;
    private Long zongLiuRu;
    private Long zongLiuChu;
    private Long jingLiuRu;
    private Integer jingLiuRuZhanBi;
    private Long daDanLiuRu;
    private Integer daDanLiuRuZhanBi;
    private Long daDanLiuChu;
    private Integer daDanLiuChuZhanBi;
    private Long zhongDanLiuRu;
    private Integer zhongDanLiuRuZhanBi;
    private Long zhongDanLiuChu;
    private Integer zhongDanLiuChuZhanBi;
    private Long xiaoDanLiuRu;
    private Integer xiaoDanLiuRuZhanBi;
    private Long xiaoDanLiuChu;
    private Integer xiaoDanLiuChuZhanBi;
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

    public String toSql(){
        StringBuffer sb = new StringBuffer("INSERT INTO `sic_stocks_zjlx_ths` VALUES (");
        sb.append(id==null ? "null," : "'"+id+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(name==null ? "null," : "'',");
        sb.append(date==null ? "null," : "'"+date+"',");
        sb.append(chengJiaoE==null ? "null," : "'"+chengJiaoE+"',");
        sb.append(zongLiuRu==null ? "null," : "'"+zongLiuRu+"',");
        sb.append(zongLiuChu==null ? "null," : "'"+zongLiuChu+"',");
        sb.append(jingLiuRu==null ? "null," : "'"+jingLiuRu+"',");
        sb.append(jingLiuRuZhanBi==null ? "null," : "'"+jingLiuRuZhanBi+"',");
        sb.append(daDanLiuRu==null ? "null," : "'"+daDanLiuRu+"',");
        sb.append(daDanLiuRuZhanBi==null ? "null," : "'"+daDanLiuRuZhanBi+"',");
        sb.append(daDanLiuChu==null ? "null," : "'"+daDanLiuChu+"',");
        sb.append(daDanLiuChuZhanBi==null ? "null," : "'"+daDanLiuChuZhanBi+"',");
        sb.append(zhongDanLiuRu==null ? "null," : "'"+zhongDanLiuRu+"',");
        sb.append(zhongDanLiuRuZhanBi==null ? "null," : "'"+zhongDanLiuRuZhanBi+"',");
        sb.append(zhongDanLiuChu==null ? "null," : "'"+zhongDanLiuChu+"',");
        sb.append(zhongDanLiuChuZhanBi==null ? "null," : "'"+zhongDanLiuChuZhanBi+"',");
        sb.append(xiaoDanLiuRu==null ? "null," : "'"+xiaoDanLiuRu+"',");
        sb.append(xiaoDanLiuRuZhanBi==null ? "null," : "'"+xiaoDanLiuRuZhanBi+"',");
        sb.append(xiaoDanLiuChu==null ? "null," : "'"+xiaoDanLiuChu+"',");
        sb.append(xiaoDanLiuChuZhanBi==null ? "null," : "'"+xiaoDanLiuChuZhanBi+"',");
        sb.append(createAt==null ? "null," : "'"+createAt+"'");
        sb.append(");");
        return sb.toString();
    }
}
