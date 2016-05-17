package com.stocks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created with IntegerelliJ IDEA.
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
    private Integer chengJiaoJia;
    private Integer chengJiaoLiang;
    private Long chengJiaoE;
    private Integer shift;

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

    public Integer getChengJiaoJia() {
        return chengJiaoJia;
    }

    public void setChengJiaoJia(Integer chengJiaoJia) {
        this.chengJiaoJia = chengJiaoJia;
    }

    public Integer getChengJiaoLiang() {
        return chengJiaoLiang;
    }

    public void setChengJiaoLiang(Integer chengJiaoLiang) {
        this.chengJiaoLiang = chengJiaoLiang;
    }

    public Long getChengJiaoE() {
        return chengJiaoE;
    }

    public void setChengJiaoE(Long chengJiaoE) {
        this.chengJiaoE = chengJiaoE;
    }

    public Integer getShift() {
        return shift;
    }

    public void setShift(Integer shift) {
        this.shift = shift;
    }

    public String toSql(){
        StringBuffer sb = new StringBuffer("INSERT INTO `sic_stocks_zjlx_detail` VALUES (");
        sb.append(id==null ? "null," : "'"+id+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(code==null ? "null," : "'"+code+"',");
        sb.append(");");
        return sb.toString();
    }
}
