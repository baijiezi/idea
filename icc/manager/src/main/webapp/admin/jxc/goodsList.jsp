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
    <h5>基础信息管理 <span style="color:darkgrey">/ 医院管理</span></h5>
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
        <c:if test="${buttons.k101010 == null}"><a href="/admin/jxc/goods/addPage" class="btn"><i class="icon-plus"></i> 增加</a></c:if>
        <c:if test="${buttons.k101012 == null}"><a id="btnDel" class="btn"><i class="icon-trash "></i> 删除</a></c:if>
        <c:if test="${buttons.k101013 == null}"><a id="btnConfig" class="btn"><i class="icon-arrow-right"></i> 设置医院配置信息</a></c:if>
    </div>

    <div style="font-size: 13px;">
        <table class="table table-striped table-bordered table-hover" id="table-manager">
            <thead>
            <tr style="background-color:aliceblue" >
                <th style="width:2%;"><input type="checkbox" class="group-checkable" data-set="#table-manager .checkboxes" id="table_th_checkbox" /></th>
                <th style="width:15%;">医院名称</th>
                <th style="width:5%;">医院ID</th>
                <th style="width:10%;">简称</th>
                <th style="width:10%;">所在地区</th>
                <th style="width:15%;">详细地址</th>
                <th style="width:10%;">联系电话</th>
                <th style="width:5%;">医院级别</th>
                <th style="width:5%;">经营性质</th>
                <%--<th style="width:5%;">医院相片</th>--%>
                <th style="width:5%;">状态</th>
                <th style="width:10%;">更新时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${hospitalList}" >
                <tr id="${item.hospitalId}">
                    <td><input type="checkbox" name="table_td_checkbox" class="checkboxes" value="${item.hospitalId}" /></td>
                    <td>
                        <c:choose>
                            <c:when test="${buttons.k101011 == null}" >
                                <a href="/admin/hospital/editPage?id=${item.hospitalId}"> ${item.hospitalName}</a>
                            </c:when>
                            <c:otherwise>
                                ${item.hospitalName}
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${item.hospitalId}</td>
                    <td>${item.shortName}</td>
                        <%--<td>${item.area.province.province}${item.area.city.city}${item.area.area}</td>--%>
                    <td>${item.area}</td>
                    <td>${item.address}</td><td>${item.contact}</td><td>${item.grade}</td><td>${item.nature}</td>
                        <%--<td>${item.p ? '有相片':'尚无相片'}</td>--%>
                    <td><c:choose><c:when test="${item.served}">启用</c:when><c:otherwise>禁用</c:otherwise></c:choose></td>
                    <td><fmt:formatDate value="${item.updatedAt}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <jsp:include page="../pager.jsp"/>
</div>
</body>
</html>