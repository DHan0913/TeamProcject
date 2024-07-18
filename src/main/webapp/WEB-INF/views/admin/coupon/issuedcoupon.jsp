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
    <h1>쿠폰 지급</h1>	  <!-- 240718 예성 수정 완전 함 -->
    <form method="post">
        <!-- <label for="couponId">쿠폰 ID:</label>
        <input type="text" id="couponId" name="couponId"><br>
    
        <label for="userNo">사용자 번호:</label>
        <input type="text" id="userNo" name="userNo"><br> -->
        
        <label for="email">사용자 이메일:</label>
        <input type="text" id="email" name="email"><br>
    
    	<input type="hidden" id="couponId" name="couponId" value="${couponId }">
    	<input type="hidden" id="userNo" name="userNo" value="${userNo }">
    	
    	<button type="button" onclick="location.href='<c:url value="/users/userinfo" />'">쿠폰지급</button>
    </form>
</body>

<script>

if("${successMessage}" != ''){
	alert("${successMessage}");
}

</script>

</html>
