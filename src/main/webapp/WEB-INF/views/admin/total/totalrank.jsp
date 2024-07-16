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

	</div>

	<div id="content">
		<div class="list-container" style="margin-bottom:20px;">
			<table border="1" width="25%">
				<tr>
					<th>총매출</th>
				</tr>
				<tr>
					<td>${totalAmt}</td>
				</tr>
			</table>
		</div>
		
		<div class="list-container">
			<table border="1" width="100%">
				<tr>
					<th>인기순위</th>
					<th>상품이름</th>
					<th>상품별 총 매출액</th>
				</tr>
				<c:forEach var="items" items="${total}" varStatus="status">
					<tr>
						<td>${status.count }</td>
						<td>${items.productname}</td>
						<td>${items.productamt}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	</div>
</body>
</html>