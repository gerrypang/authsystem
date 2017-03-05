<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<title><sitemesh:write property="title"/></title>
	<sitemesh:write property="head"/>
	<%@include file="/WEB-INF/views/include/style.jsp" %>
</head>
<body>
	<sitemesh:write property="body"/>
	<%@include file="/WEB-INF/views/include/script.jsp" %>
</body>
</html>