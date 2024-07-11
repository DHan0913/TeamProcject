<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 상세페이지</title>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<h1>내 정보 페이지</h1>

	<form:form modelAttribute="userVo" id="Info" name="userInfoForm" method="POST" action="<c:url value='/users/Infoform' />">
	<div class="form-group">
		<label id="userNo" class="block-label" for="username">이름 ${authUser.username }</label>
		<br>

		<label id="userNo" class="block-label" for="email">이메일 ${authUser.email }</label>
		<br>

		<label id="userNo" class="block-label" for="birth">생년월일 ${authUser.birth }</label>
		<br>

		<button type="submit" onclick="window.location.href='<c:url value="/updateform" />'">정보수정</button>
		<button type="button" onclick="window.location.href='<c:url value="/deleteform" />'">삭제하기</button>
		<button type="button" onclick="window.location.href='<c:url value="/" />'">홈으로</button>
	</div>
	</form:form>

</body>
</html>
