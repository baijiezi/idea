package com.stocks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-21
 * Time: 下午3:37
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "sic_stocks_fenhong")
public class StocksFenHongEntity {

    private static final Long serialVersionUID = 4025146963875664504L;

    @Id
    @GeneratedValue
    private Integer id;
    private String code;
    private String name;
    private Date date;
    private String fenHongFangAn;
    private Long paiXianJinE;
    private Integer meiGuShouYi;
    private String remark;
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

    public String getFenHongFangAn() {
        return fenHongFangAn;
    }

    public void setFenHongFangAn(String fenHongFangAn) {
        this.fenHongFangAn = fenHongFangAn;
    }

    public Long getPaiXianJinE() {
        return paiXianJinE;
    }

    public void setPaiXianJinE(Long paiXianJinE) {
        this.paiXianJinE = paiXianJinE;
    }

    public Integer getMeiGuShouYi() {
        return meiGuShouYi;
    }

    public void setMeiGuShouYi(Integer meiGuShouYi) {
        this.meiGuShouYi = meiGuShouYi;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
