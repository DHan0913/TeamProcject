<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value='/css/tortalrank.css' />" rel="stylesheet">
<meta charset="UTF-8">
<title>DVD</title>
</head>
<body>
	<div id="container">
		<!-- 헤더 포함 -->
		<c:import url="/WEB-INF/views/admin/includes/header.jsp" />
		
		<c:import url="/WEB-INF/views/admin/includes/navigation.jsp" />
	</div>

	<div id="content">
		<div class="list-container" style="margin-bottom:20px; margin-left:10px;">
			<table border="1" width="25%">
				<tr>
					<th>총매출(캐시+쿠폰)</th>
				</tr>
				<tr>
					<td>${totalAmt}</td>
				</tr>
			</table>
		</div>
		
		<!-- 쿠폰 매출액  -->
        <div class="list-container" style="margin-bottom:20px; margin-left:10px;">
            <table border="1" width="25%">
                <tr>
                    <th>쿠폰 사용 금액</th>
                </tr>
                <tr>
                    <td>${calculatedCouponCount}</td>
                </tr>
            </table>
        </div>
        
              <div class="list-container" style="margin-bottom:20px; margin-left:10px;">
            <table border="1" width="25%">
                <tr>
                    <th>순매출</th>
                </tr>
                <tr>
                    <td>${totalAmt - calculatedCouponCount}</td>
                </tr>
            </table>
        </div>
		
		<div class="list-container">
			<table border="1" width="47%" style="float:left; margin-left:10px;">
				<tr>
					<th>인기 순위</th>
					<th>상품 이름</th>
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
			<table border="1" width="47%" style="float:left; margin-left:10px;">
				<tr>
					<th>회원 순위</th>
					<th>회원 이름</th>
					<th>회원별 총 매출액</th>
				</tr>
						</div>
				<c:forEach var="items" items="${usrList}" varStatus="status">
					<tr>
						<td>${status.count }</td>
						<td>${items.username}</td>
						<td>${items.useramt}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
	</div>
</body>
</html>