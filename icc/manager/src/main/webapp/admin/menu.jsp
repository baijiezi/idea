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
        <a href="#100000" class="nav-header" data-toggle="collapse"><i class="icon-star"></i>
            用户管理
            <i class="icon-chevron-up"></i>
        </a>
        <ul id="100000" class="nav nav-list collapse in">
            <li><a href="${urlPath}/admin/user/payCard/list" target="main-frame"><i class="icon-chevron-right"></i>支付卡管理</a></li>
            <li><a href="${urlPath}/admin/user/payCard/ybCardList" target="main-frame"><i class="icon-chevron-right"></i>医保卡管理</a></li>
            <li><a href="${urlPath}/admin/user/vote/list" target="main-frame"><i class="icon-chevron-right"></i>评价管理</a></li>
            <li><a href="${urlPath}/admin/user/vote/listWeight" target="main-frame"><i class="icon-chevron-right"></i>评价权重管理</a></li>
            <li><a href="${urlPath}/admin/user/vote/listLabel" target="main-frame"><i class="icon-chevron-right"></i>评价标签管理</a></li>
            <li><a href="${urlPath}/admin/user/vote/listBuss" target="main-frame"><i class="icon-chevron-right"></i>评价业务类型管理</a></li>
            <li><a href="${urlPath}/admin/user/vote/listHisOrder" target="main-frame"><i class="icon-chevron-right"></i>His挂号订单</a></li>
            <li><a href="${urlPath}/admin/user/list" target="main-frame"><i class="icon-chevron-right"></i>用户管理</a></li>
            <li><a href="${urlPath}/admin/user/patient" target="main-frame"><i class="icon-chevron-right"></i>就诊人管理</a></li>
        </ul>
</div>

<div class="sidebar-nav">
    <a href="#110000" class="nav-header" data-toggle="collapse">
        <i class="icon-tasks"></i>基础数据管理<i class="icon-chevron-up"></i>
    </a>
    <ul id="110000" class="nav nav-list collapse in">
        <li><a href="${urlPath}/admin/jxc/goods/list" target="main-frame"><i class="icon-chevron-right"></i>SP管理</a></li>
        <li><a href="${urlPath}/admin/jxc/buy/add" target="main-frame"><i class="icon-chevron-right"></i>JH管理</a></li>
        <li><a href="${urlPath}/admin/jxc/sale/sale" target="main-frame"><i class="icon-chevron-right"></i>XS医生管理</a></li>
    </ul>
</div>

<div class="sidebar-nav">
    <a href="#120000" class="nav-header" data-toggle="collapse">
        <i class="icon-tasks"></i>订单管理<i class="icon-chevron-up"></i>
    </a>
    <ul id="120000" class="nav nav-list collapse in">
        <li><a href="${urlPath}/admin/order/list" target="main-frame"><i class="icon-chevron-right"></i>预约挂号订单管理</a></li>
        <li><a href="${urlPath}/admin/clinic/list" target="main-frame"><i class="icon-chevron-right"></i>门诊缴费订单管理</a></li>
    </ul>
</div>


<div class="sidebar-nav">
    <a href="#130000" class="nav-header" data-toggle="collapse">
        <i class="icon-tasks"></i>文章管理<i class="icon-chevron-up"></i>
    </a>
    <ul id="130000" class="nav nav-list collapse in">
        <li><a href="${urlPath}/admin/helper/article/classList" target="main-frame"><i class="icon-chevron-right"></i>文章类别管理</a></li>
        <li><a href="${urlPath}/admin/helper/article/list" target="main-frame"><i class="icon-chevron-right"></i>文章管理</a></li>
    </ul>
</div>



<div class="sidebar-nav">
    <a href="#140000" class="nav-header" data-toggle="collapse">
        <i class="icon-tasks"></i>系统管理<i class="icon-chevron-up"></i>
    </a>
    <ul id="140000" class="nav nav-list collapse in">
        <li><a href="${urlPath}/admin/system/adminUser/list" target="main-frame"><i class="icon-chevron-right"></i>管理员管理</a></li>
        <li><a href="${urlPath}/admin/system/company/list" target="main-frame"><i class="icon-chevron-right"></i>公司管理</a></li>
        <li><a href="${urlPath}/admin/system/department/list" target="main-frame"><i class="icon-chevron-right"></i>公司部门管理</a></li>
        <li><a href="${urlPath}/admin/system/menu/list" target="main-frame"><i class="icon-chevron-right"></i>菜单管理</a></li>
        <li><a href="${urlPath}/admin/system/image/list" target="main-frame"><i class="icon-chevron-right"></i>图片管理</a></li>
        <li><a href="${urlPath}/admin/system/banner/list" target="main-frame"><i class="icon-chevron-right"></i>Banner图片管理</a></li>
        <li><a href="${urlPath}/admin/system/apiUser/list" target="main-frame"><i class="icon-chevron-right"></i>渠道管理</a></li>
        <li><a href="${urlPath}/admin/system/roles" target="main-frame"><i class="icon-chevron-right"></i>角色管理</a></li>
    </ul>
</div>



<div class="sidebar-nav">
    <a href="#150000" class="nav-header" data-toggle="collapse">
        <i class="icon-tasks"></i>商户管理<i class="icon-chevron-up"></i>
    </a>
    <ul id="150000" class="nav nav-list collapse in">
        <li><a href="${urlPath}/admin/commercial/unionPayConfig/list" target="main-frame"><i class="icon-chevron-right"></i>银联商户管理</a></li>
        <li><a href="${urlPath}/admin/commercial/unionPayCertHospital/list" target="main-frame"><i class="icon-chevron-right"></i>银联医院商户</a></li>

    </ul>
</div>



<div class="sidebar-nav">
    <a href="#160000" class="nav-header" data-toggle="collapse">
        <i class="icon-tasks"></i>设备管理<i class="icon-chevron-up"></i>
    </a>
    <ul id="160000" class="nav nav-list collapse in">
        <li><a href="${urlPath}/admin/device/item/list" target="main-frame"><i class="icon-chevron-right"></i>项管理</a></li>
        <li><a href="${urlPath}/admin/device/item/typeList" target="main-frame"><i class="icon-chevron-right"></i>设备项类型管理</a></li>
        <li><a href="${urlPath}/admin/device/item/deviceList" target="main-frame"><i class="icon-chevron-right"></i>设备项管理</a></li>
        <li><a href="${urlPath}/admin/device/ibeacon/list" target="main-frame"><i class="icon-chevron-right"></i>IBeacon设备管理</a></li>
    </ul>
</div>

<div class="sidebar-nav">
    <a href="#170000" class="nav-header" data-toggle="collapse">
        <i class="icon-tasks"></i>消息中心<i class="icon-chevron-up"></i>
    </a>
    <ul id="170000" class="nav nav-list collapse in">
        <li><a href="${urlPath}/admin/message/noteMessage/list" target="main-frame"><i class="icon-chevron-right"></i>提醒消息管理</a></li>
        <li><a href="${urlPath}/admin/message/template/list" target="main-frame"><i class="icon-chevron-right"></i>模板管理</a></li>
    </ul>
</div>


<div class="sidebar-nav">
    <a href="#180000" class="nav-header" data-toggle="collapse">
        <i class="icon-tasks"></i>支付管理<i class="icon-chevron-up"></i>
    </a>
    <ul id="180000" class="nav nav-list collapse in">
        <li><a href="${urlPath}/admin/pay/payWay/list" target="main-frame"><i class="icon-chevron-right"></i>支付方式管理</a></li>
        <li><a href="${urlPath}/admin/pay/payWay/listApiPayWay" target="main-frame"><i class="icon-chevron-right"></i>渠道支付方式</a></li>
        <li><a href="${urlPath}/admin/pay/payOrder/list" target="main-frame"><i class="icon-chevron-right"></i>支付订单管理</a></li>
        <li><a href="${urlPath}/admin/pay/payOrder/listItem" target="main-frame"><i class="icon-chevron-right"></i>支付订单业务管理</a></li>
        <li><a href="${urlPath}/admin/pay/payOrder/listPayment" target="main-frame"><i class="icon-chevron-right"></i>支付订单记录管理</a></li>
        <li><a href="${urlPath}/admin/pay/apiMerchantCallBackUrl/list" target="main-frame"><i class="icon-chevron-right"></i>渠道商户回调地址</a></li>
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