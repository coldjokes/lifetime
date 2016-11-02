<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
		<sitemesh:write property='head' />
		<!-- 引入 css js -->
		<link href="${ctx}/static/common/bootstrap/3.3.5/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
		<header></header>
	</head>
	<body>
		<!-- 编写统一风格的header 或者 include -->
		<div class="head">
		
		</div>
		<div class="content">
			<sitemesh:write property='body' />
		
		</div>
		<div class="foot">
			<h1>FOOT</h1>
		
		</div>
		
		
		<script src="${ctx}/static/common/jquery/1.11.1/jquery-1.11.1.min.js" type="text/javascript"></script>
		<script src="${ctx}/static/common/bootstrap/3.3.5/js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>