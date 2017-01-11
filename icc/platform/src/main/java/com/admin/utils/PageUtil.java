package com.admin.utils;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sunshine
 * Date: 13-7-24
 * Time: 上午11:11
 * To change this template use File | Settings | File Templates.
 */
public  class PageUtil implements Serializable {

    private static final long serialVersionUID = 1735946728762639905L;

    private List<? extends Object> pageList  =  null;

    private Integer curPage = 1;
    private Integer pageSize  = 30;

    private Integer totalPage  = 1;

    private Integer totalCount = 0;


    public static Integer getBasicPageSize() {
         return 30;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<? extends Object> getPageList() {
        return pageList;
    }

    public void setPageList(List<? extends Object> pageList) {
        this.pageList = pageList;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {

        if(this.getTotalCount() > 0){
            totalPage =  this.totalCount%this.pageSize==0? this.totalCount/this.pageSize : this.totalCount/this.pageSize+1;
        } else {
            totalPage = 0;
        }
        return totalPage;
    }


    public Integer getPrePage(){
        if(this.curPage > 1){
            return this.curPage - 1;
        }
        return 1;
    }

    public Integer getNextPage() {
        if(this.curPage < this.getTotalPage()) {
            return this.curPage +1;
        }
        return this.getTotalPage();
    }




}
