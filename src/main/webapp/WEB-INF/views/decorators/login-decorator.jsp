<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<title><sitemesh:write property="title"/></title>
	<%@include file="/WEB-INF/views/include/style.jsp" %>
	<link type="text/css" rel="stylesheet" href="${ctx}/static/common/css/form-elements.css"/>
	<link type="text/css" rel="stylesheet" href="${ctx}/static/common/css/login-style.css"/>
	<sitemesh:write property="head"/>
</head>
<body>
	<sitemesh:write property="body"/>
	<%@include file="/WEB-INF/views/include/script.jsp" %>
	<script type="text/javascript" src="${ctx}/static/jquery-backstretch/jquery.backstretch.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/common/js/login-script.js"></script>
</body>
</html>