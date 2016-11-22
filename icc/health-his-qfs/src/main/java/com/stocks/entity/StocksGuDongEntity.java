package com.stocks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-11-22
 * Time: 上午10:06
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "sic_stocks_gudong")
public class StocksGuDongEntity implements Serializable {

    private static final long serialVersionUID = -5363037030064417628L;

    @Id
    @GeneratedValue
    private Integer id;
    private String code;
    private String name;
    private String gdName;

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

    public String getGdName() {
        return gdName;
    }

    public void setGdName(String gdName) {
        this.gdName = gdName;
    }
}
