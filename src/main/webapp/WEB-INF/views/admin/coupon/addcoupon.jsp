<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰 생성</title>
</head>
<body>
	<h1>쿠폰 생성</h1>
	<form action="<c:url value='/admin/coupons/add' />" method="post">
        <label for="couponCode">쿠폰 코드:</label>
        <input type="text" id="couponCode" name="couponCode" required><br><br>
        
        <label for="expiryDate">만료일:</label>
        <input type="date" id="expiryDate" name="expiryDate" required><br><br>
        
        <button type="submit">쿠폰 생성</button>
    </form>
</body>
</html>
<script>

if("${successMessage}" != ''){
	alert("${successMessage}");
}

</script>

