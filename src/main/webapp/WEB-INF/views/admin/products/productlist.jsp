<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DVD</title>
<link href="<c:url value='/css/productlist.css' />" rel="stylesheet">
</head>
<body>
	<div id="container">
		<!-- 헤더 포함 -->
		<c:import url="/WEB-INF/views/admin/includes/header.jsp" />
		
		<c:import url="/WEB-INF/views/admin/includes/navigation.jsp" />
	</div>

	<div id="content">
		<div class="list-container">
			<table>
				<tr>
					<th>상품번호</th>
					<th>상품이름</th>
					<th>장르</th>
					<th>출시일</th>
					<th>액션</th>
				</tr>
				<c:forEach var="product" items="${products}">
					<tr>
						<td>${product.productNo}</td>
						<td><a href="${pageContext.request.contextPath}/products/detail?productNo=${product.productNo}">${product.productName}</a></td>
						<td>${product.genre}</td>
						<td>${product.releaseDate}</td>
						<td>
							<a href="<c:url value='/admin/${product.productNo}/modify' />">수정</a>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5">
						<a href="<c:url value='/admin/add'/>">상품등록</a>
						<a href="<c:url value='/admin/users'/>">홈</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
