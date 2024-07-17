<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰 지급</title>
</head>
<body>
    <h1>쿠폰 지급</h1>
    <form action="<c:url value='/admin/coupons/issued' />" method="post">
        <label for="couponId">쿠폰 ID:</label>
        <input type="text" id="couponId" name="couponId"><br>
    
        <label for="userNo">사용자 번호:</label>
        <input type="text" id="userNo" name="userNo"><br>
    
        <input type="submit" value="쿠폰 발급">
    </form>
</body>
</html>
