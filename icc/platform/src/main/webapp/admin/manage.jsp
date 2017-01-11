<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<% request.setAttribute("urlPath",request.getContextPath()); %>
<spring:url var="resources" value="/resources" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>银联BOSS-综合管理平台</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="银联BOSS-综合管理平台">

    <link href="${resources}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="${resources}/lib/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

    <script type="text/javascript" src="${resources}/js/jquery-1.8.3.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${resources}/lib/bootstrap/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${resources}/lib/bootstrap/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${resources}/lib/bootstrap/js/bootstrap-modal.js" charset="UTF-8"></script>

    <!-- 引入表单验证插件 -->
    <link rel="stylesheet" href="${resources}/js/validator/jquery.validator.css">
    <script type="text/javascript" src="${resources}/js/validator/jquery.validator.js"></script>
    <script type="text/javascript" src="${resources}/js/validator/local/zh_CN.js"></script>

    <script type="text/javascript" src="${resources}/js/manage/common.js"></script>

    <link rel="stylesheet" type="text/css" href="${resources}/css/theme.css">
    <link rel="stylesheet" type="text/css" href="${resources}/css/themenew.css">
    <link rel="stylesheet" href="${resources}/lib/font-awesome/css/font-awesome.css">
    <link rel="shortcut icon" href="${resources}/img/favicon.ico">
    <style type="text/css">
        .brand { font-family: georgia,serif}
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
    </style>

    <!--[if IE 7]>
    <link rel="stylesheet" type="text/css" href="${resources}/css/admin/ie7.css">
    <![endif]-->

    <!--[if lt IE 8]>
    <script src="${resources}/js/jr/html5/html5shiv.js"></script>
    <![endif]-->

</head>

<body>
<tiles:insertAttribute name="body"/>
</body>
<script type="text/javascript">
    $(function() {
        $('.demo-cancel-click').click(function(){return false;});
    });
</script>


<script type="text/javascript">
    $('.form_time').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0
    });

    $('.form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0,
        format:'yyyy-mm-dd'
    });

    $('.form_date_time').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 0,
        maxView: 1,
        forceParse: 0,
        format:'yyyy-mm-dd hh:ii'
    });
</script>
</html>
