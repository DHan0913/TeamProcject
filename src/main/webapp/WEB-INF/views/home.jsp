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
					<c:if test="${authUser.role == 1 }">
                    <li>
                        <button onclick="location.href='<c:url value="/admin/home" />'">관리자 화면</button>
                    </li>
                </c:if>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>