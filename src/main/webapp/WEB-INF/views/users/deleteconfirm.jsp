<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
<h1>회원 탈퇴</h1>
	<form id="delete-confirm" name="deleteForm" method="POST" action="<c:url value='/users/deleteconfirm' />">
        
	  	<div class="form-group">
            <label class="block-label">비밀번호</label> 
            <input name="password" type="password" placeholder="비밀번호">
        </div>
	
		<div class="form-group">
            <label class="block-label">비밀번호 확인</label> 
            <input name="password" type="password" placeholder="비밀번호 확인">
        </div>
	       
	    <button type="submit">확인</button>  <!-- 자바스크립트 추가하기! -->
	    <button type="button" onclick="location.href='<c:url value="/" />'">취소</button>
	</form>
</body>
</html>
