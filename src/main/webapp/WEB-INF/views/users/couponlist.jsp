<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>MY COUPON LIST</title>
    <link href="<c:url value='/css/couponlist.css' />" rel="stylesheet">
</head>
<body>
    <div class="container">
        <header>
            <h1>MY 쿠폰 리스트</h1>
        </header>
        <main>
            <form id="coupon-list" name="couponList" method="POST" action="/users/couponlist">
                <table class="coupon-table">
                    <thead>
                        <tr>
                            <th>쿠폰 코드</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="coupon" items="${coupons}">
                            <tr>
                                <td>${coupon.couponCode}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </form>
            <div class="button-container">
                <button type="button" onclick="window.history.back();">뒤로가기</button>
            </div>
        </main>
    </div>
</body>
</html>
