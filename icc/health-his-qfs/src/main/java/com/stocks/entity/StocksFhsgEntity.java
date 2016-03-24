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
 * Date: 16-3-24
 * Time: 下午2:34
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "sic_stocks_fhsg")
public class StocksFhsgEntity  implements Serializable {

    private static final Long serialVersionUID = 4025472254857964504L;

    @Id
    @GeneratedValue
    private Integer id;
    private String code;
    private String name;
    private Date gongGaoRi;
    private Integer fenHong;
    private Integer songGu;
    private Integer zhuanZeng;
    private Date dengJiRi;
    private Date chuQuanRi;
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

    public Date getGongGaoRi() {
        return gongGaoRi;
    }

    public void setGongGaoRi(Date gongGaoRi) {
        this.gongGaoRi = gongGaoRi;
    }

    public Integer getFenHong() {
        return fenHong;
    }

    public void setFenHong(Integer fenHong) {
        this.fenHong = fenHong;
    }

    public Integer getSongGu() {
        return songGu;
    }

    public void setSongGu(Integer songGu) {
        this.songGu = songGu;
    }

    public Integer getZhuanZeng() {
        return zhuanZeng;
    }

    public void setZhuanZeng(Integer zhuanZeng) {
        this.zhuanZeng = zhuanZeng;
    }

    public Date getDengJiRi() {
        return dengJiRi;
    }

    public void setDengJiRi(Date dengJiRi) {
        this.dengJiRi = dengJiRi;
    }

    public Date getChuQuanRi() {
        return chuQuanRi;
    }

    public void setChuQuanRi(Date chuQuanRi) {
        this.chuQuanRi = chuQuanRi;
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
