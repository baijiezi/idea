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
 * Date: 16-11-30
 * Time: 下午6:19
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "sic_stocks_quanzhong")
public class StocksQuanZhongEntity implements Serializable {

    private static final long serialVersionUID = 4739787455440646633L;

    @Id
    @GeneratedValue
    private Integer id;
    private String type;
    private String keyName;
    private Integer value;
    private Integer count;
    private Date createTime;
    private String mark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
