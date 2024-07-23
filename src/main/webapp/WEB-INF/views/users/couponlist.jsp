<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MY COUPON LIST</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/cpuponlist.css/.css' />">
</head>
<body>

<h1>MY 쿠폰 리스트</h1>
<form id="coupon-list" name="couponList" method="POST" action="/users/couponlist">
    <table>
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
                    <td>${coupon.used ? '사용됨' : '미사용'}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</form>

<button type="button" onclick="window.location.href='<c:url value="/" />'">홈으로</button>

</body>
</html>
