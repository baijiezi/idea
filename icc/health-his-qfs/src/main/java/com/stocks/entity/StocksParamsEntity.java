package com.stocks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-1-30
 * Time: 上午11:57
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "sic_stocks_params")
public class StocksParamsEntity implements Serializable {

    private static final long serialVersionUID = -8763345475662767369L;
    @Id
    @GeneratedValue
    private Integer id;
    private String param;
    private String value;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


}
