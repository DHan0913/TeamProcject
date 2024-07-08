<%@ page language="java" contentType="text/html; charset=UTF-8"	
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DVD 로그인</title>
</head>
<body>
	<h1>로그인</h1>
	
	
	
	<form id="login-form" 
		name="loginform" 
		method="POST" 
		action="<c:url value="/users/login" />">
		
		<label class="block-label" for="email">이메일</label> 
		<input id="email" name="email" type="text" value=""><br> 

		<label class="block-label">패스워드</label> 
		<input name="password" type="password" value=""><br>

		<input type="submit" value="로그인">
	</form>
    
</body>
</html>