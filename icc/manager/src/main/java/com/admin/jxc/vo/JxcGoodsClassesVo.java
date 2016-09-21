package com.admin.jxc.vo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-9-21
 * Time: 下午4:00
 * To change this template use File | Settings | File Templates.
 */
public class JxcGoodsClassesVo implements Serializable {

    private static final long serialVersionUID = 4602302249474072809L;
    private String className;
    private String remark;

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
