package com.stocks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-3
 * Time: 下午6:50
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "sic_stocks_zjlx_detail")
public class StocksZJLXDetailEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String code;
    private String name;
    private Date date;
    private int chengJiaoJia;
    private int chengJiaoLiang;
    private long chengJiaoE;
    private int shift;

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

    public int getChengJiaoJia() {
        return chengJiaoJia;
    }

    public void setChengJiaoJia(int chengJiaoJia) {
        this.chengJiaoJia = chengJiaoJia;
    }

    public int getChengJiaoLiang() {
        return chengJiaoLiang;
    }

    public void setChengJiaoLiang(int chengJiaoLiang) {
        this.chengJiaoLiang = chengJiaoLiang;
    }

    public long getChengJiaoE() {
        return chengJiaoE;
    }

    public void setChengJiaoE(long chengJiaoE) {
        this.chengJiaoE = chengJiaoE;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }
}
