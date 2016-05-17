package com.stocks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created with IntegerelliJ IDEA.
 * User: Administrator
 * Date: 16-3-14
 * Time: 下午9:55
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "sic_stocks_zjlx_hx")
public class StocksZjlxHXEntity  implements java.io.Serializable  {

    private static final Long serialVersionUID = -134014788722369842L;

    @Id
    @GeneratedValue
    private Integer id;
    private String code;
    private String name;
    private Date date;
    private Long heJiChengJiao;
    private Long jingLiuRu;
    private Integer jingLiuRuLv;
    private Long chaoDaDanLiuRu;
    private Integer chaoDaDanLiuRuZhanBi;
    private Integer chaoDaDanLiuRuZengZhangLv;
    private Long chaoDaDanLiuChu;
    private Integer chaoDaDanLiuChuZhanBi;
    private Integer chaoDaDanLiuChuZengZhangLv;
    private Long daDanLiuRu;
    private Integer daDanLiuRuZhanBi;
    private Integer daDanLiuRuZengZhangLv;
    private Long daDanLiuChu;
    private Integer daDanLiuChuZhanBi;
    private Integer daDanLiuChuZengZhangLv;
    private Long xiaoDanLiuRu;
    private Integer xiaoDanLiuRuZhanBi;
    private Integer xiaoDanLiuRuZengZhangLv;
    private Long xiaoDanLiuChu;
    private Integer xiaoDanLiuChuZhanBi;
    private Integer xiaoDanLiuChuZengZhangLv;
    private Long sanDanLiuRu;
    private Integer sanDanLiuRuZhanBi;
    private Integer sanDanLiuRuZengZhangLv;
    private Long sanDanLiuChu;
    private Integer sanDanLiuChuZhanBi;
    private Integer sanDanLiuChuZengZhangLv;
    private Long qiTaChengJiaoJinE;
    private Integer qiTaZhanBi;
    private Integer qiTaZengZhanLv;
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

    public Long getHeJiChengJiao() {
        return heJiChengJiao;
    }

    public void setHeJiChengJiao(Long heJiChengJiao) {
        this.heJiChengJiao = heJiChengJiao;
    }

    public Long getJingLiuRu() {
        return jingLiuRu;
    }

    public void setJingLiuRu(Long jingLiuRu) {
        this.jingLiuRu = jingLiuRu;
    }

    public Integer getJingLiuRuLv() {
        return jingLiuRuLv;
    }

    public void setJingLiuRuLv(Integer jingLiuRuLv) {
        this.jingLiuRuLv = jingLiuRuLv;
    }

    public Long getChaoDaDanLiuRu() {
        return chaoDaDanLiuRu;
    }

    public void setChaoDaDanLiuRu(Long chaoDaDanLiuRu) {
        this.chaoDaDanLiuRu = chaoDaDanLiuRu;
    }

    public Integer getChaoDaDanLiuRuZhanBi() {
        return chaoDaDanLiuRuZhanBi;
    }

    public void setChaoDaDanLiuRuZhanBi(Integer chaoDaDanLiuRuZhanBi) {
        this.chaoDaDanLiuRuZhanBi = chaoDaDanLiuRuZhanBi;
    }

    public Integer getChaoDaDanLiuRuZengZhangLv() {
        return chaoDaDanLiuRuZengZhangLv;
    }

    public void setChaoDaDanLiuRuZengZhangLv(Integer chaoDaDanLiuRuZengZhangLv) {
        this.chaoDaDanLiuRuZengZhangLv = chaoDaDanLiuRuZengZhangLv;
    }

    public Long getChaoDaDanLiuChu() {
        return chaoDaDanLiuChu;
    }

    public void setChaoDaDanLiuChu(Long chaoDaDanLiuChu) {
        this.chaoDaDanLiuChu = chaoDaDanLiuChu;
    }

    public Integer getChaoDaDanLiuChuZhanBi() {
        return chaoDaDanLiuChuZhanBi;
    }

    public void setChaoDaDanLiuChuZhanBi(Integer chaoDaDanLiuChuZhanBi) {
        this.chaoDaDanLiuChuZhanBi = chaoDaDanLiuChuZhanBi;
    }

    public Integer getChaoDaDanLiuChuZengZhangLv() {
        return chaoDaDanLiuChuZengZhangLv;
    }

    public void setChaoDaDanLiuChuZengZhangLv(Integer chaoDaDanLiuChuZengZhangLv) {
        this.chaoDaDanLiuChuZengZhangLv = chaoDaDanLiuChuZengZhangLv;
    }

    public Long getDaDanLiuRu() {
        return daDanLiuRu;
    }

    public void setDaDanLiuRu(Long daDanLiuRu) {
        this.daDanLiuRu = daDanLiuRu;
    }

    public Integer getDaDanLiuRuZhanBi() {
        return daDanLiuRuZhanBi;
    }

    public void setDaDanLiuRuZhanBi(Integer daDanLiuRuZhanBi) {
        this.daDanLiuRuZhanBi = daDanLiuRuZhanBi;
    }

    public Integer getDaDanLiuRuZengZhangLv() {
        return daDanLiuRuZengZhangLv;
    }

    public void setDaDanLiuRuZengZhangLv(Integer daDanLiuRuZengZhangLv) {
        this.daDanLiuRuZengZhangLv = daDanLiuRuZengZhangLv;
    }

    public Long getDaDanLiuChu() {
        return daDanLiuChu;
    }

    public void setDaDanLiuChu(Long daDanLiuChu) {
        this.daDanLiuChu = daDanLiuChu;
    }

    public Integer getDaDanLiuChuZhanBi() {
        return daDanLiuChuZhanBi;
    }

    public void setDaDanLiuChuZhanBi(Integer daDanLiuChuZhanBi) {
        this.daDanLiuChuZhanBi = daDanLiuChuZhanBi;
    }

    public Integer getDaDanLiuChuZengZhangLv() {
        return daDanLiuChuZengZhangLv;
    }

    public void setDaDanLiuChuZengZhangLv(Integer daDanLiuChuZengZhangLv) {
        this.daDanLiuChuZengZhangLv = daDanLiuChuZengZhangLv;
    }

    public Long getXiaoDanLiuRu() {
        return xiaoDanLiuRu;
    }

    public void setXiaoDanLiuRu(Long xiaoDanLiuRu) {
        this.xiaoDanLiuRu = xiaoDanLiuRu;
    }

    public Integer getXiaoDanLiuRuZhanBi() {
        return xiaoDanLiuRuZhanBi;
    }

    public void setXiaoDanLiuRuZhanBi(Integer xiaoDanLiuRuZhanBi) {
        this.xiaoDanLiuRuZhanBi = xiaoDanLiuRuZhanBi;
    }

    public Integer getXiaoDanLiuRuZengZhangLv() {
        return xiaoDanLiuRuZengZhangLv;
    }

    public void setXiaoDanLiuRuZengZhangLv(Integer xiaoDanLiuRuZengZhangLv) {
        this.xiaoDanLiuRuZengZhangLv = xiaoDanLiuRuZengZhangLv;
    }

    public Long getXiaoDanLiuChu() {
        return xiaoDanLiuChu;
    }

    public void setXiaoDanLiuChu(Long xiaoDanLiuChu) {
        this.xiaoDanLiuChu = xiaoDanLiuChu;
    }

    public Integer getXiaoDanLiuChuZhanBi() {
        return xiaoDanLiuChuZhanBi;
    }

    public void setXiaoDanLiuChuZhanBi(Integer xiaoDanLiuChuZhanBi) {
        this.xiaoDanLiuChuZhanBi = xiaoDanLiuChuZhanBi;
    }

    public Integer getXiaoDanLiuChuZengZhangLv() {
        return xiaoDanLiuChuZengZhangLv;
    }

    public void setXiaoDanLiuChuZengZhangLv(Integer xiaoDanLiuChuZengZhangLv) {
        this.xiaoDanLiuChuZengZhangLv = xiaoDanLiuChuZengZhangLv;
    }

    public Long getSanDanLiuRu() {
        return sanDanLiuRu;
    }

    public void setSanDanLiuRu(Long sanDanLiuRu) {
        this.sanDanLiuRu = sanDanLiuRu;
    }

    public Integer getSanDanLiuRuZhanBi() {
        return sanDanLiuRuZhanBi;
    }

    public void setSanDanLiuRuZhanBi(Integer sanDanLiuRuZhanBi) {
        this.sanDanLiuRuZhanBi = sanDanLiuRuZhanBi;
    }

    public Integer getSanDanLiuRuZengZhangLv() {
        return sanDanLiuRuZengZhangLv;
    }

    public void setSanDanLiuRuZengZhangLv(Integer sanDanLiuRuZengZhangLv) {
        this.sanDanLiuRuZengZhangLv = sanDanLiuRuZengZhangLv;
    }

    public Long getSanDanLiuChu() {
        return sanDanLiuChu;
    }

    public void setSanDanLiuChu(Long sanDanLiuChu) {
        this.sanDanLiuChu = sanDanLiuChu;
    }

    public Integer getSanDanLiuChuZhanBi() {
        return sanDanLiuChuZhanBi;
    }

    public void setSanDanLiuChuZhanBi(Integer sanDanLiuChuZhanBi) {
        this.sanDanLiuChuZhanBi = sanDanLiuChuZhanBi;
    }

    public Integer getSanDanLiuChuZengZhangLv() {
        return sanDanLiuChuZengZhangLv;
    }

    public void setSanDanLiuChuZengZhangLv(Integer sanDanLiuChuZengZhangLv) {
        this.sanDanLiuChuZengZhangLv = sanDanLiuChuZengZhangLv;
    }

    public Long getQiTaChengJiaoJinE() {
        return qiTaChengJiaoJinE;
    }

    public void setQiTaChengJiaoJinE(Long qiTaChengJiaoJinE) {
        this.qiTaChengJiaoJinE = qiTaChengJiaoJinE;
    }

    public Integer getQiTaZhanBi() {
        return qiTaZhanBi;
    }

    public void setQiTaZhanBi(Integer qiTaZhanBi) {
        this.qiTaZhanBi = qiTaZhanBi;
    }

    public Integer getQiTaZengZhanLv() {
        return qiTaZengZhanLv;
    }

    public void setQiTaZengZhanLv(Integer qiTaZengZhanLv) {
        this.qiTaZengZhanLv = qiTaZengZhanLv;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String toSql(){
        StringBuffer sb = new StringBuffer("INSERT INTO `sic_stocks_zjlx_hx` VALUES (");
        sb.append(id==null ? "null," : "'"+id+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(name==null ? "null," : "'',");
        sb.append(date==null ? "null," : "'"+date+"',");
        sb.append(heJiChengJiao==null ? "null," : "'"+heJiChengJiao+"',");
        sb.append(jingLiuRu==null ? "null," : "'"+jingLiuRu+"',");
        sb.append(jingLiuRuLv==null ? "null," : "'"+jingLiuRuLv+"',");
        sb.append(chaoDaDanLiuRu==null ? "null," : "'"+chaoDaDanLiuRu+"',");
        sb.append(chaoDaDanLiuRuZhanBi==null ? "null," : "'"+chaoDaDanLiuRuZhanBi+"',");
        sb.append(chaoDaDanLiuRuZengZhangLv==null ? "null," : "'"+chaoDaDanLiuRuZengZhangLv+"',");
        sb.append(chaoDaDanLiuChu==null ? "null," : "'"+chaoDaDanLiuChu+"',");
        sb.append(chaoDaDanLiuChuZhanBi==null ? "null," : "'"+chaoDaDanLiuChuZhanBi+"',");
        sb.append(chaoDaDanLiuChuZengZhangLv==null ? "null," : "'"+chaoDaDanLiuChuZengZhangLv+"',");
        sb.append(daDanLiuRu==null ? "null," : "'"+daDanLiuRu+"',");
        sb.append(daDanLiuRuZhanBi==null ? "null," : "'"+daDanLiuRuZhanBi+"',");
        sb.append(daDanLiuRuZengZhangLv==null ? "null," : "'"+daDanLiuRuZengZhangLv+"',");
        sb.append(daDanLiuChu==null ? "null," : "'"+daDanLiuChu+"',");
        sb.append(daDanLiuChuZhanBi==null ? "null," : "'"+daDanLiuChuZhanBi+"',");
        sb.append(daDanLiuChuZengZhangLv==null ? "null," : "'"+daDanLiuChuZengZhangLv+"',");
        sb.append(xiaoDanLiuRu==null ? "null," : "'"+xiaoDanLiuRu+"',");
        sb.append(xiaoDanLiuRuZhanBi==null ? "null," : "'"+xiaoDanLiuRuZhanBi+"',");
        sb.append(xiaoDanLiuRuZengZhangLv==null ? "null," : "'"+xiaoDanLiuRuZengZhangLv+"',");
        sb.append(xiaoDanLiuChu==null ? "null," : "'"+xiaoDanLiuChu+"',");
        sb.append(xiaoDanLiuChuZhanBi==null ? "null," : "'"+xiaoDanLiuChuZhanBi+"',");
        sb.append(xiaoDanLiuChuZengZhangLv==null ? "null," : "'"+xiaoDanLiuChuZengZhangLv+"',");
        sb.append(sanDanLiuRu==null ? "null," : "'"+sanDanLiuRu+"',");
        sb.append(sanDanLiuRuZhanBi==null ? "null," : "'"+sanDanLiuRuZhanBi+"',");
        sb.append(sanDanLiuRuZengZhangLv==null ? "null," : "'"+sanDanLiuRuZengZhangLv+"',");
        sb.append(sanDanLiuChu==null ? "null," : "'"+sanDanLiuChu+"',");
        sb.append(sanDanLiuChuZhanBi==null ? "null," : "'"+sanDanLiuChuZhanBi+"',");
        sb.append(sanDanLiuChuZengZhangLv==null ? "null," : "'"+sanDanLiuChuZengZhangLv+"',");
        sb.append(qiTaChengJiaoJinE==null ? "null," : "'"+qiTaChengJiaoJinE+"',");
        sb.append(qiTaZhanBi==null ? "null," : "'"+qiTaZhanBi+"',");
        sb.append(qiTaZengZhanLv==null ? "null," : "'"+qiTaZengZhanLv+"',");
        sb.append(createAt==null ? "null," : "'"+createAt+"'");
        sb.append(");");
        return sb.toString();
    }
}
