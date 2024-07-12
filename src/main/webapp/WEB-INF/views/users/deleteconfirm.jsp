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
	<form id="delete-confirm" name="deleteForm" method="POST" action="<c:url value='/users/deleteconfirm' />">
        
	  	<div class="form-group">
			<label for="password">비밀번호</label>
			<form:password path="password" id="password" />
			<form:errors path="password" cssClass="error" />
		</div>
	
		<div class="form-group">
			<label for="passwordConfirm">비밀번호 확인</label>
	        <form:password path="passwordConfirm" id="passwordConfirm" />
	        <form:errors path="passwordConfirm" cssClass="error" />
	    </div>
	       
	    <button type="submit">확인</button>
	    <button type="button" onclick="window.location.href='<c:url value="/" />'">취소</button>
	</form>
</body>
</html>
