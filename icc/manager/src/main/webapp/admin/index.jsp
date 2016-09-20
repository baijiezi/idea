<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<% request.setAttribute("urlPath",request.getContextPath()); %>
<spring:url var="resources" value="${urlPath}/resources" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>银联BOSS-综合管理平台</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="银联BOSS-综合管理平台">

    <link rel="stylesheet" type="text/css" href="${resources}/css/admin/yinlianbs.css">
    <script type="text/javascript" src="${resources}/js/admin/yinlianbs.js"></script>

    <link href="${resources}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="${resources}/lib/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

    <script type="text/javascript" src="${resources}/lib/jquery-1.8.3.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${resources}/lib/bootstrap/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${resources}/lib/bootstrap/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${resources}/lib/bootstrap/js/bootstrap-modal.js" charset="UTF-8"></script>

    <link rel="stylesheet" type="text/css" href="${resources}/css/theme.css">
    <link rel="stylesheet" href="${resources}/lib/font-awesome/css/font-awesome.css">
    <link rel="shortcut icon" href="${resources}/img/favicon.ico">


    <style type="text/css">
        .brand { font-family: georgia,serif}
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
    </style>

    <%--<script>--%>
    <%--function pasteperson(personMsg)--%>
    <%--{--%>
    <%--var json = eval('(' + personMsg + ')');--%>
    <%--window.frames["main-frame"].localPastePersonInfo(json);--%>
    <%--}--%>

    <%--function hospitalsign(){--%>
    <%--$("#main-frame").attr("src","${urlPath}/manage/sign/index");--%>
    <%--}--%>

    <%--function opcorder(){--%>
    <%--$("#main-frame").attr("src","${urlPath}/manage/orderBooking/index");--%>
    <%--}--%>
    <%--</script>--%>

    <frameset rows="82,*,45" framespacing="0" border="0">
        <frame src="${urlPath}/admin/header"  id="header-frame" name="header-frame" frameborder="no" scrolling="no">
        <frameset cols="200,*" framespacing="0" border="0" id="frame-body">
            <frame src="${urlPath}/admin/listMenu" id="menu-frame" name="menu-frame" frameborder="no" scrolling="yes">
            <frame src="${urlPath}/admin/showMain" id="main-frame" name="main-frame" frameborder="no" scrolling="yes">
        </frameset>
        <frame src="${urlPath}/admin/footer"  id="footer-frame" name="footer-frame" frameborder="no" scrolling="no">

    </frameset><noframes></noframes>


</head>

<body>

</body>


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

</script>

</html>
