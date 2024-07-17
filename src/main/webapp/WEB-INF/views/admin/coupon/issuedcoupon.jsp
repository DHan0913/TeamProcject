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
	<form action="${pageContext.request.contextPath}/admin/coupon/issued" method="post">
	
        <label for="userNo">사용자 번호:</label>
        <input type="number" id="userNo" name="userNo" required><br><br>
        
        <label for="couponId">쿠폰 ID:</label>
        <input type="number" id="couponId" name="couponId" required><br><br>
        
        <button type="submit">쿠폰 지급</button>
        
    </form>
</body>
</html>