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
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<h1>회원 가입</h1>

	<form:form modelAttribute="userVo" id="join-form" name="registerForm"
		action="${pageContext.servletContext.contextPath }/users/join"
		method="POST">

		<label for="username">이름</label>
		<form:input path="username" placeholder="이름을 입력하십시오" />
		<form:errors path="username" cssClass="error" />
		<br>


		<label for="password">비밀번호</label>
		<form:input path="password" type="password" placeholder="비밀번호를 입력하십시오" />
		<form:errors path="password" cssClass="error" />
		<br>

		<label for="passwordConfirm">비밀번호 확인</label>
		<form:input path="passwordConfirm" type="password"
			placeholder="비밀번호를 다시 입력하세요" />
		<form:errors path="passwordConfirm" cssClass="error" />
		<br>

		<label for="email">이메일</label>
		<form:input path="email" type="email" placeholder="이메일을 입력하십시오" />
		<input type="button" id="check-email"
			data-target="<c:url value="/users/checkEmail" />" value="이메일 중복체크" />
		<input type="hidden" name="emailCheck" value="n" />
		<form:errors path="email" cssClass="error" />
		<br>

		<label for="birth">생년월일</label>
		<input name="birth" type="date" id="birthInput">
		<form:errors path="birth" cssClass="error" />
		<br>


		<label for="agree">약관동의</label>
		<form:checkbox path="agree" id="agree" />
		<form:errors path="agree" cssClass="error" />
		<br>

		<input type="submit" value="가입하기" />
		<input type="reset" value="다시 작성" />

	</form:form>
	<button onclick="location.href='<c:url value="/" />'">home</button>
</body>
</html>