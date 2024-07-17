<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>쿠폰 관리</title>
</head>
<body>
    <c:import url="/WEB-INF/views/admin/includes/header.jsp" />
    <h1>쿠폰 관리</h1>
    
    <!-- 쿠폰 생성 링크 -->
    <a href="${pageContext.request.contextPath}/admin/coupons/add">쿠폰 생성</a>
    <br><br>
    
    <!-- 쿠폰 발급 링크 -->
    <a href="${pageContext.request.contextPath}/admin/coupons/issued">쿠폰 지급</a>
    
    <!-- 쿠폰 목록 테이블 -->
    <table border="1">
        <thead>
            <tr>
                <th>쿠폰 코드</th>
                <th>만료일</th>
                <th>발급일</th>
                <th>만료 처리</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="coupon" items="${coupons}">
                <tr>
                    <td>${coupon.couponCode}</td>
                    <td><fmt:formatDate value="${coupon.expiryDate}" pattern="yyyy-MM-dd"/></td>
                    <td><fmt:formatDate value="${coupon.issuedDate}" pattern="yyyy-MM-dd"/></td>
                    <td>
                        <!-- 쿠폰 만료 처리 폼 -->
                        <form action="${pageContext.request.contextPath}/admin/coupons/${coupon.couponId}/expiry" method="POST">
                            <input type="hidden" name="_method" value="POST">
                            <input type="submit" value="만료 처리">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <!-- 관리자 메뉴로 돌아가는 링크 -->
    <p><a href="${pageContext.request.contextPath}/admin/home">관리자 홈으로 돌아가기</a></p>
    
</body>
</html>
