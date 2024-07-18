<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰 입력</title>
</head>
<body>
	<h1>쿠폰</h1>
	
	<form action="/coupon/validate" method="post">
	
        <label for="couponCode">쿠폰 코드:</label>
        <input type="text" id="couponCode" name="couponCode" required>
        <button type="submit">유효성 검사</button><br><br>
        
        <button type="submit">확인</button>
        
    </form>
	
</body>
</html>