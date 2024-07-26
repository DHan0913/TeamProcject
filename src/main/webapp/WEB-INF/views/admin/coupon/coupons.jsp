<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value='/css/coupons.css' />" rel="stylesheet">
<meta charset="UTF-8">
<title>쿠폰 관리</title>
</head>
<body>

    <header>
        <c:import url="/WEB-INF/views/admin/includes/header.jsp" />
    </header>
    
    <nav>
        <c:import url="/WEB-INF/views/admin/includes/navigation.jsp" />
    </nav>

    <main>
        <h1>쿠폰 관리</h1>
        
        <!-- 쿠폰 생성 링크 -->
        <a href="${pageContext.request.contextPath}/admin/coupons/add" class="create-coupon">쿠폰 생성</a>
        
        <!-- 쿠폰 목록 테이블 -->
        <table>
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
                            <c:choose>
                                <c:when test="${coupon.expiryYn eq 'N'}">
                                    <!-- 쿠폰 만료 처리 폼 -->
                                    <form action="${pageContext.request.contextPath}/admin/coupons/${coupon.couponId}/expiry" method="POST">
                                        <input type="hidden" name="_method" value="POST">
                                        <input type="hidden" name="couponId" value="${coupon.couponId}">
                                        <input type="submit" value="만료 처리">
                                    </form>
                                </c:when>
                                <c:otherwise>
                                    만료됨
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </main>

    <script>
        if ("${successMessage}" != '') {
            document.body.insertAdjacentHTML('beforeend', '<div class="alert">' + "${successMessage}" + '</div>');
        }

        if ("${errorMessage}" != '') {
            document.body.insertAdjacentHTML('beforeend', '<div class="alert">' + "${errorMessage}" + '</div>');
        }
    </script>

</body>
</html>
