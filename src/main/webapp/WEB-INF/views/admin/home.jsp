<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VOD</title>
</head>
<body>
	
	<div id="container">
		<!-- 헤더 포함 -->
		<c:import url="/WEB-INF/views/admin/includes/header.jsp" />

		<c:import url="/WEB-INF/views/admin/includes/navigation.jsp" />
		<div id="content">
	
		</div>
		<button onclick="location.href='<c:url value="/" />'">유저 페이지</button>
	</div>
</body>
</html>
