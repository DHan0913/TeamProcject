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
	
	<!-- 에러 메시지 출력 -->
    <c:if test="${param.error == 'empty'}">
            <p style="color:red;">이메일 또는 비밀번호를 입력해주세요.</p>
    </c:if>
	
	<c:if test="${param.error == 'fail'}">
            <p style="color:red;">로그인에 실패했습니다.</p>
    </c:if>
    
	<form action="${pageContext.request.contextPath}/users/login" method="post">
        <label for="email">이메일:</label>
        <input type="text" id="email" name="email"><br>
        
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password"><br>
        
        <button type="submit">로그인</button>
    </form>
    
</body>
</html>