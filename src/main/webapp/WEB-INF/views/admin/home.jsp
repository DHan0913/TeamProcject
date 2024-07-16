<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DVD</title>
</head>
<body>
	<div id="container">
		<!-- 헤더 포함 -->
		<c:import url="/WEB-INF/views/admin/includes/header.jsp" />

		<div id="content">
			<ul>
				<li><a href='<c:url value="/admin/users" />'>유저관리</a></li>
				<li><a href='<c:url value="/admin/productlist" />'>상품관리</a></li>
				<li><a href='<c:url value="" />'>대여관리</a></li>
				<li><a href='<c:url value="/" />'>유저화면으로 가기</a></li>
				<li><a href='<c:url value="/admin/ip-block" />'>IP 관리</a></li> 
				<li><a href='<c:url value="/admin/acceptcash" />'>캐시요청화면</a></li>
				<li><a href='<c:url value="/admin/membership" />'>멤버쉽 관리</li>
			</ul>
		</div>
	</div>
</body>
</html>
