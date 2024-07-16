<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰 목록</title>
</head>
<body>
    <h1>쿠폰 목록</h1>
    <table>
        <thead>
            <tr>
                <th>쿠폰 코드</th>
                <th>발급일</th>
                <th>만료일</th>
                <th>조작</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="coupon" items="${coupons}">
                <tr>
                    <td>${coupon.couponCode}</td>
                    <td>${coupon.issueDate}</td>
                    <td>${coupon.expiryDate}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/coupons/${coupon.couponId}/issue">발급</a> |
                        <a href="${pageContext.request.contextPath}/admin/coupons/${coupon.couponId}/expire">만료</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>