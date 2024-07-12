<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 페이지</title>
</head>
<body>
	<div id="container">
		<!-- 헤더 포함 -->
		<c:import url="/WEB-INF/views/admin/includes/header.jsp" />
	</div>
	<h1>상품 등록</h1>
	<form action="<c:url value='/admin/add' />" method="post">
		<label for="productName">상품명:</label> <input type="text"
			id="productName" name="productName" required> <br> <label
			for="genre">장르:</label> <input type="text" id="genre" name="genre"
			required> <br> <label for="releaseDate">출시일:</label> <input
			type="date" id="releaseDate" name="releaseDate" required> <br>

		<label for="content">내용:</label>
		<textarea id="content" name="content" required></textarea>
		<br> <label for="status">상태:</label> <input type="text"
			id="status" name="status" required> <br> <label
			for="img">이미지:</label> <input type="text" id="img" name="img"
			required> <br> <label for="video">비디오 이름:</label> <input
			type="text" id="video" name="video" required> <br>

		<button type="submit">등록</button>
		<a href="<c:url value='/admin/productlist'/>">취소</a>
	</form>
</body>
</html>
