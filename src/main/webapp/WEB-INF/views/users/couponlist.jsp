<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MY COUPON LIST</title>
</head>
<body>
<h1>MY 쿠폰 리스트</h1>
	<form id="coupon-list" name="couponList" method="POST" action="/users/couponlist">
	<table border="1">
        <thead>
            <tr>
                <th>쿠폰 코드</th>
                <th>만료일</th>
				<th>사용여부</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="coupon" items="${coupons}">
                <tr>
	                    <td>${coupon.couponCode}</td>
	                    <td><fmt:formatDate value="${coupon.expiryDate}" pattern="yyyy-MM-dd"/></td>
				</tr>
            </c:forEach>
        </tbody>
    </table>
    </form><br>
    
	<button type="button" onclick="window.history.back();">뒤로가기</button>
</body>
</html>