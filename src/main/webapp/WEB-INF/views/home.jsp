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
		<c:import url="/WEB-INF/views/includes/header.jsp" />

	</div>

	<div id="content">
		<div class="list-container">
			<table border="1" width="100%">
				<tr>
					<th>상품번호</th>
					<th>상품이름</th>
					<th>장르</th>
					<th>출시일</th>
				</tr>
				<c:forEach var="product" items="${products}">
					<tr>
						<td>${product.productNo}</td>
						<td><a
							href="${pageContext.request.contextPath}/products/detail?productNo=${product.productNo}">${product.productName}</a></td>
						<td>${product.genre}</td>
						<td>${product.releaseDate}</td>
					</tr>
				</c:forEach>
				<tr>
					<c:if test="${authUser.role == 1}">
						<p>관리자 화면으로 가기</p>
					</c:if>



					<td colspan="6"><a href="<c:url value="products/add"/>">상품등록</a></td>


				</tr>
			</table>
		</div>
	</div>
	</div>
</body>
</html>