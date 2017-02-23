package com.stocks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-2-21
 * Time: 下午3:10
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "sic_stocks_price_simple")
public class StocksPriceSimpleEntity implements Serializable {
    private static final long serialVersionUID = -5636353604025216778L;

    @Id
    @GeneratedValue
    private Integer id;
    private String code;
    private String name;
    private Date date;
    private Integer shouPan;
    private Integer zhangFu;
    private Integer zhangDie;
    private Integer shouPanMa5;
    private Integer shouPanMa10;
    private Integer shouPanMa20;
    private Integer shouPanMa30;
    private Integer shouPanMa60;
    private Integer JunXianPaiLie;
    private Integer junXianZouXiang;
    private Integer junXianPaiLieCJL;

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

    public Integer getZhangFu() {
        return zhangFu;
    }

    public void setZhangFu(Integer zhangFu) {
        this.zhangFu = zhangFu;
    }

    public Integer getShouPanMa5() {
        return shouPanMa5;
    }

    public void setShouPanMa5(Integer shouPanMa5) {
        this.shouPanMa5 = shouPanMa5;
    }

    public Integer getShouPanMa10() {
        return shouPanMa10;
    }

    public void setShouPanMa10(Integer shouPanMa10) {
        this.shouPanMa10 = shouPanMa10;
    }

    public Integer getShouPanMa20() {
        return shouPanMa20;
    }

    public void setShouPanMa20(Integer shouPanMa20) {
        this.shouPanMa20 = shouPanMa20;
    }

    public Integer getShouPanMa30() {
        return shouPanMa30;
    }

    public void setShouPanMa30(Integer shouPanMa30) {
        this.shouPanMa30 = shouPanMa30;
    }

    public Integer getShouPanMa60() {
        return shouPanMa60;
    }

    public void setShouPanMa60(Integer shouPanMa60) {
        this.shouPanMa60 = shouPanMa60;
    }

    public Integer getJunXianPaiLie() {
        return JunXianPaiLie;
    }

    public void setJunXianPaiLie(Integer junXianPaiLie) {
        JunXianPaiLie = junXianPaiLie;
    }

    public Integer getJunXianZouXiang() {
        return junXianZouXiang;
    }

    public void setJunXianZouXiang(Integer junXianZouXiang) {
        this.junXianZouXiang = junXianZouXiang;
    }

    public Integer getJunXianPaiLieCJL() {
        return junXianPaiLieCJL;
    }

    public void setJunXianPaiLieCJL(Integer junXianPaiLieCJL) {
        this.junXianPaiLieCJL = junXianPaiLieCJL;
    }

    public Integer getZhangDie() {
        return zhangDie;
    }

    public void setZhangDie(Integer zhangDie) {
        this.zhangDie = zhangDie;
    }
}
