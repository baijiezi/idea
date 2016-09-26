<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<% request.setAttribute("urlPath",request.getContextPath()); %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<spring:url var="resources" value="${urlPath}/resources" />
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>银联BOSS-综合管理平台</title>
    <link href="${resources}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="${resources}/lib/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

    <script type="text/javascript" src="${resources}/js/jquery-1.8.3.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${resources}/lib/bootstrap/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${resources}/lib/bootstrap/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${resources}/lib/bootstrap/js/bootstrap-modal.js" charset="UTF-8"></script>
    <link rel="stylesheet" type="text/css" href="${resources}/css/theme.css">
    <link rel="stylesheet" type="text/css" href="${resources}/css/menu.css">
    <link rel="stylesheet" href="${resources}/lib/font-awesome/css/font-awesome.css">
    <link rel="shortcut icon" href="${resources}/img/favicon.ico">
    <style type="text/css">
        .brand { font-family: georgia,serif}
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
    </style>
    <!--[if lt IE 9]>
    <script src="${resources}/html5/html5shiv.js"></script>
    <script src="${resources}/js/jr/selectivizr.js"></script>
    <![endif]-->

    <!--[if IE 7]>
    <link href="${resources}/css/admin/ie7.css" rel="stylesheet" media="screen">
    <![endif]-->

</head>
<body>

<div class="sidebar-nav">
    <a href="#110000" class="nav-header" data-toggle="collapse">
        <i class="icon-tasks"></i>基础数据<i class="icon-chevron-up"></i>
    </a>
    <ul id="110000" class="nav nav-list collapse in">
        <li><a href="${urlPath}/admin/jxc/goods/list" target="main-frame"><i class="icon-chevron-right"></i>SP管理</a></li>
        <li><a href="${urlPath}/admin/jxc/buy/add" target="main-frame"><i class="icon-chevron-right"></i>JH管理</a></li>
        <li><a href="${urlPath}/admin/jxc/sale/sale" target="main-frame"><i class="icon-chevron-right"></i>XS医生管理</a></li>
    </ul>
</div>


</body>

<script src="/resources/lib/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
    function changeUrl(main_url){
        $("#mainFrame").attr("src",main_url);
    }

    $("[rel=tooltip]").tooltip();

    $(function() {
        $('.demo-cancel-click').click(function(){return false;});
    });

    $('.nav-list li').click(function(){
        $('.nav-list li a').removeClass("on");
        $(this).children(0).addClass("on");
    });
</script>
</html>