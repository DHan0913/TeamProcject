<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DVD 회원 정보 수정</title>
</head>
<body>
	<h1>회원 정보 수정</h1>
	<form id="update-form" name="updateForm" method="POST" action="<c:url value='/updateuser/updateform' />">
		
		<label class="block-label" for="name">이름</label>
		<input id="name" name="username" type="text" readonly><br>

		<label class="block-label">이메일</label> 
		<input name="email" type="email" placeholder="이메일을 입력하십시오">
		<input type="button" id="check-email" data-target="<c:url value="/users/checkEmail" />"value="이메일 중복체크" /><br>	
		<input type="hidden" name="emailCheck" value="n" />

		<label class="block-label">생년월일</label>
	  	<input name="birth" type="date" id="birthInput"><br>

		<input type="submit" value="수정완료" />
		<a href="<c:url value="/home" />">취소</a>

	</form>
    <
</body>
</html>
