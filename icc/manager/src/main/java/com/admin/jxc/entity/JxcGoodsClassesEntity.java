package com.admin.jxc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-9-21
 * Time: 下午2:54
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "jxc_goods_classes")
public class JxcGoodsClassesEntity  implements Serializable {
    private static final long serialVersionUID = -8779850653044324847L;

    @Id
    @GeneratedValue
    private Integer id;
    private String className;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
