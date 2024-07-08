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
		<c:import url="/WEB-INF/views/includes/header2.jsp" />


		<div id="content">
			<ul>
				<!-- 로그인 안한 사용자 -->
				<!-- 가입링크, 로그인 폼 링크 -->
				<li><a href='<c:url value="" />'>유저관리</a></li>
				<li><a href='<c:url value="" />'>상품관리</a></li>
				<li><a href='<c:url value="" />'>대여관리</a></li>
			</ul>

		</div>
	</div>
</body>
</html>
