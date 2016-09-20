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
    <title>银联Boss-综合管理平台</title>
    <link rel="stylesheet" type="text/css" href="${resources}/css/admin/yinlianbs.css">
    <script type="text/javascript" src="${resources}/js/admin/yinlianbs.js"></script>

    <script type="text/javascript" src="${resources}/js/jquery-1.8.3.min.js" charset="UTF-8"></script>

    <link rel="shortcut icon" href="${resources}/img/favicon.ico">

    <!--[if lt IE 9]>
    <script src="${resources}/html5/html5shiv.js"></script>
    <script src="${resources}/js/jr/selectivizr.js"></script>
    <![endif]-->

</head>
<body>
<footer>
    <p>Copyright © 2015 广东天泽阳光康众医疗投资管理有限公司.粤ICP备09007530号-15</p>
</footer>
</body>

</html>