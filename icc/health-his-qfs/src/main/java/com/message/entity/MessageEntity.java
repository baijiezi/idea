package com.message.entity;

import com.stocks.utils.DateUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-3-11
 * Time: 上午10:23
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "sic_message")
public class MessageEntity implements Serializable {

    private static final long serialVersionUID = -7257362207875883870L;

    @Id
    @GeneratedValue
    private Integer id;
    private String supplier;
    private String account;
    private String authkey;
    private String cgid;
    private String mobile;
    private String type;
    private String content;
    private Date toSendTime;
    private Date sendTime;
    private Integer status;
    private String remark;

    public MessageEntity(){
    }

    public MessageEntity(String mobile, String content, String type, String toSendTime){
        this.mobile = mobile;
        this.content = content;
        this.type = type;
        this.toSendTime = DateUtils.strToDate(toSendTime);
        this.status = 1;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAuthkey() {
        return authkey;
    }

    public void setAuthkey(String authkey) {
        this.authkey = authkey;
    }

    public String getCgid() {
        return cgid;
    }

    public void setCgid(String cgid) {
        this.cgid = cgid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getToSendTime() {
        return toSendTime;
    }

    public void setToSendTime(Date toSendTime) {
        this.toSendTime = toSendTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String toSql(){
        StringBuffer sb = new StringBuffer("INSERT INTO `sic_stocks` VALUES (");
        sb.append(id==null ? "null," : "'"+id+"',");
        sb.append(supplier==null ? "null," : "'"+supplier+"',");
        sb.append(account==null ? "null," : "'"+account+"',");
        sb.append(authkey==null ? "null," : "'"+authkey+"',");
        sb.append(cgid==null ? "null," : "'"+cgid+"',");
        sb.append(mobile==null ? "null," : "'"+mobile+"',");
        sb.append(type==null ? "null," : "'"+type+"',");
        sb.append(content==null ? "null," : "'"+content+"',");
        sb.append(toSendTime==null ? "null," : "'"+toSendTime+"',");
        sb.append(sendTime==null ? "null," : "'"+sendTime+"',");
        sb.append(status==null ? "null," : "'"+status+"',");
        sb.append(remark==null ? "null," : "'"+remark+"'");
        sb.append(");");
        return sb.toString();
    }
}
