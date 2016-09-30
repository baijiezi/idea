<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>医院管理</title>
    <script type="text/javascript">
        jQuery(function($){
            $("#btnDel").click(function(){
                var ids = [];
                $("input[name='table_td_checkbox']:checked").each(function(){
                    ids.push($(this).val());
                });
                if(ids.length > 0){
                    if(window.confirm("是否删除当前选中的医院？")){
                        $.getJSON('/admin/hospital/delete',{
                            ids : ids.join(',')
                        }, function(result){
                            if(result.success){
                                opcAlert(result.msg);
                                window.location.href="/admin/hospital/list";
                            }else{
                                opcAlert(result.msg);
                            }
                        });
                    }
                }else{
                    opcAlert("没有选中任何医院进行删除！");
                }
            });

            $('#btnConfig').click(function(){
                var ids = [];
                $("input[name='table_td_checkbox']:checked").each(function(){
                    ids.push($(this).val());
                });
                if(ids.length == 1){
                    $(this).attr('href','${pageContext.request.contextPath}/admin/hospital/configPage?id='+ids[0]);
                }else if(ids.length > 1){
                    opcAlert("只能选择一项进行配置！");
                }else if(ids.length <= 0){
                    opcAlert("没有选中任何资料进行配置！");
                }
            });
        })


        function toPage(page){
            $("#page").val(page);
            $("#searchForm").submit();
        }
    </script>
</head>
<body>
<div class="header">
    <h5>基础信息管理 <span style="color:darkgrey">/ XS</span></h5>
</div>

<div id="from-manager" class="breadcrumb">
    <form id="searchForm" class="form-inline" style="text-align:left; margin-top: 10px; margin-bottom: 10px;" method="post">
        <label class="col-lunionpay-2 control-label">医院名称：</label>
        <input name="name" type="text" class="form-control" placeholder="医院名称" value="${paramQuery.hospitalName}">
        <span style="margin-left:30px;"></span>
        <input type="hidden" name="page" id="page">
        <button type="submit" class="btn btn-success">搜索</button>
    </form>
</div>

<div style="margin-left:10px; margin-right:10px;">
    <div class="btn-toolbar">
        <c:if test="${buttons.k101010 == null}"><a href="/admin/jxc/sales/addPage" class="btn"><i class="icon-plus"></i> 增加</a></c:if>
        <c:if test="${buttons.k101012 == null}"><a id="btnDel" class="btn"><i class="icon-trash "></i> 删除</a></c:if>
    </div>

    <div style="font-size: 13px;">
        <table class="table table-striped table-bordered table-hover" id="table-manager">
            <thead>
            <tr style="background-color:aliceblue" >
                <th style="width:2%;"><input type="checkbox" class="group-checkable" data-set="#table-manager .checkboxes" id="table_th_checkbox" /></th>
                <th style="width:15%;">商品名称</th>
                <th style="width:10%;">商品类别</th>
                <th style="width:8%;">销售对象</th>
                <th style="width:8%;">销售价格</th>
                <th style="width:8%;">售出数量</th>
                <th style="width:8%;">库存数</th>
                <th style="width:10%;">条码</th>
                <th style="width:5%;">状态</th>
                <th style="width:10%;">登记时间</th>
                <th style="width:10%;">备注</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${pageList}" >
                <tr id="${item.id}">
                    <td><input type="checkbox" name="table_td_checkbox" class="checkboxes" value="${item.id}" /></td>
                    <td>${item.name}</td>
                    <td>${item.classes}</td>
                    <td>${item.saleTo}</td>
                    <td>${item.salePrice}</td>
                    <td>${item.saleCount}</td>
                    <td>${item.stockCount}</td>
                    <td>${item.code}</td>
                    <td>${item.status}</td>
                    <td>${item.createTime}</td>
                    <td>${item.remark}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <jsp:include page="../pager.jsp"/>
</div>
</body>
</html>