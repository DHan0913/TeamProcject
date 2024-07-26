<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 정보</title>
<link href="<c:url value='/css/product-detail.css' />" rel="stylesheet">
<script src="<c:url value='/javascript/product.js' />" type="text/javascript"></script>
</head>
<body>
	<c:import url="/WEB-INF/views/includes/header.jsp" />
	<div class="container">
		<h1>상품 상세 정보</h1>
		<div class="img-container">
			<c:if test="${not empty product.img}">
				<img src="<c:url value='/upload-images/${product.img}' />" alt="${product.productName}" />
			</c:if>
		</div>
		<table>
			<tr>
				<th>상품번호</th>
				<td>${product.productNo}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${product.productName}</td>
			</tr>
			<tr>
				<th>장르</th>
				<td>${product.genre}</td>
			</tr>
			<tr>
				<th>출시일</th>
				<td>${fn:substring(product.releaseDate, 0, 10)}</td>
			</tr>
			<tr>
				<th>줄거리</th>
				<td>${product.content}</td>
			</tr>
			<tr>
				<th>동영상</th>
				<td>
					<c:choose>
						<c:when test="${not empty authUser}">
							<c:if test="${hasPermission}">
								<iframe src="https://www.youtube.com/embed/${product.video}"
										allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
										allowfullscreen></iframe>
							</c:if>
							<c:if test="${not hasPermission}">
								<p>시청 권한이 없습니다. 구매 후에 이용해주세요.</p>
								<c:choose>
									<c:when test="${sessionScope.approvedCashAmount >= 3000}">
										<p>
											<button class="purchase-btn"
												onclick="confirmPurchase('<c:url value="/users/payment/${product.productNo}" />')">구매하기</button>
										</p>
									</c:when>
									<c:otherwise>
										<p>
											캐시 잔액이 부족합니다. <br />
											<button class="login-btn"
												onclick="location.href='<c:url value="/users/requestcash" />'">
												충전</button>
											후에 이용해주세요.
										</p>
									</c:otherwise>
								</c:choose>
							</c:if>
						</c:when>
						<c:otherwise>
							<p>로그인 후 이용해주세요.</p>
							<p>
								<button class="login-btn" onclick="location.href='<c:url value="/users/login" />'">로그인</button>
							</p>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</div>
	<div style="text-align: center; margin-bottom: 15px;">
		<button class="home-btn" type="button" onclick="window.location.href='<c:url value="/" />'">홈으로</button>
	</div>
</body>
</html>
