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
 * Date: 16-11-20
 * Time: 下午3:24
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "sic_stocks_price_time")
public class StocksPriceTimeEntity  implements Serializable {

    private static final long serialVersionUID = -8213767855140144207L;

    @Id
    @GeneratedValue
    private Integer id;
    private String code;
    private Integer price;
    private Date createTime;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
