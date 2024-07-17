<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>만료된 쿠폰 목록</title>
</head>
<body>
    <c:import url="/WEB-INF/views/admin/includes/header.jsp" />
    <h1>만료된 쿠폰 목록</h1>

    <!-- 쿠폰 목록 테이블 -->
    <table border="1">
        <thead>
            <tr>
                <th>쿠폰 코드</th>
                <th>만료일</th>
                <th>발급일</th>
                <th>상태</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="coupon" items="${expiredCoupons}">
                <tr>
                    <td>${coupon.couponCode}</td>
                    <td><fmt:formatDate value="${coupon.expiryDate}" pattern="yyyy-MM-dd"/></td>
                    <td><fmt:formatDate value="${coupon.issuedDate}" pattern="yyyy-MM-dd"/></td>
                    <td>
                        <c:choose>
                            <c:when test="${coupon.used}">
                                <span style="color: red;">사용됨</span>
                            </c:when>
                            <c:otherwise>
                                <a href="#">사용 불가</a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- 관리자 메뉴로 돌아가는 링크 -->
    <p><a href="${pageContext.request.contextPath}/admin/home">관리자 홈으로 돌아가기</a></p>

</body>
</html>
