<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DVD 회원 가입</title>
<script src="<c:url value="/javascript/user.js" />"></script>
</head>
<body>
	<h1>회원 가입</h1>
	<form id="join-form" name="registerForm" method="POST" action="<c:url value='/users/join' />">
		
		<label class="block-label" for="name">이름</label>
		<input id="name" name="username" type="text" placeholder="이름을 입력하십시오" value=""><br>

		<label class="block-label">비밀번호</label> 
		<input name="password" type="password" placeholder="비밀번호를 입력하십시오" value=""><br>

		<label class="block-label">비밀번호 확인</label> 
		<input name="password_confirm" type="password" placeholder="비밀번호를 입력하십시오" value=""><br>

		<label class="block-label">이메일</label> 
		<input name="email" type="email" placeholder="이메일을 입력하십시오">
		<input type="button" id="check-email"
			data-target="<c:url value="/users/checkEmail" />"
			value="이메일 중복체크" /><br>	
		<input type="hidden" name="emailCheck" value="n" />

		<label class="block-label">생년월일</label>
		<input name="birth" type="text" placeholder="8자리로 입력하십시오" value=""><br>

		<label for="agree">약관동의</label>
		<input type="checkbox" id="agree" name="agree" value="n" /><br>

		<input type="submit" value="가입하기" />
		<input type="reset" value="다시 작성" />

	</form>
    
</body>
</html>
