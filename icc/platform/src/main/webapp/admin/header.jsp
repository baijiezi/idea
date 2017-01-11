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
    <title>${showHeaderMessage}</title>
    <link href="${resources}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="${resources}/lib/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

    <!-- 银联boss后台样式 start -->
    <link rel="stylesheet" type="text/css" href="${resources}/css/admin/yinlianbs.css">
    <script type="text/javascript" src="${resources}/js/admin/yinlianbs.js"></script>
    <!-- end -->

    <script type="text/javascript" src="${resources}/js/jquery-1.8.3.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${resources}/lib/bootstrap/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${resources}/lib/bootstrap/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${resources}/lib/bootstrap/js/bootstrap-modal.js" charset="UTF-8"></script>
    <script src="/resources/lib/bootstrap/js/bootstrap.js"></script>

    <link rel="stylesheet" type="text/css" href="${resources}/css/theme.css">
    <link rel="stylesheet" type="text/css" href="${resources}/css/head.css">
    <link rel="stylesheet" href="${resources}/lib/font-awesome/css/font-awesome.css">
    <link rel="shortcut icon" href="${resources}/img/favicon.ico">
    <style type="text/css">
        .brand { font-family: georgia,serif}
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
    </style>

    <script type="text/javascript">
        $(function(){
            $("#logout").click(function(){
                window.top.location = "/admin/logout";
            });

        });
    </script>


    <!--[if lt IE 9]>
    <script src="${resources}/html5/html5shiv.js"></script>
    <script src="${resources}/js/jr/selectivizr.js"></script>
    <![endif]-->

</head>
<body>
<header>
    <img src="${resources}/images/admin/tittle.png">
    <ul class="useroff">
        <li>
            <a href="/admin/showAdminUserInfo"  target="main-frame" title="用户信息/密码修改">
                <i class="icon-user"></i>用户名
            </a>
        </li>
        <li>
            <a href="javascript:;" id="logout"  title="退出系统">
                <i class="icon-off"></i>注销
            </a>
        </li>
    </ul>

</header>
<div class="line"></div>
</body>
</html>