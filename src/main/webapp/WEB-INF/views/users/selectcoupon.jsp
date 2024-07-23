<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>쿠폰 입력</title>
</head>
<body>
    <h1>쿠폰</h1>

    <form id="couponForm" action="<c:url value='/users/useCoupon' />" method="post">
        <label for="couponCode">쿠폰 코드:</label>
        <input type="text" id="couponCode" name="couponCode" required>
        <button type="button" id="validate-coupon" data-target="<c:url value='/users/validateCoupon' />">유효성 검사</button>
        <br><br>
        <input type="hidden" name="couponCheck" id="couponCheck" value="n">   
             
        <div class="button-container">
            <button type="submit" id="submit-coupon">확인</button>
            <button type="button" onclick="window.history.back();">뒤로가기</button>
        </div>
    </form>

    <!-- JavaScript 코드 포함 -->
    <script src="<c:url value='/javascript/coupon.js' />"></script>
</body>
</html>