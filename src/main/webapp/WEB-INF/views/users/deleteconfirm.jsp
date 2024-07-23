<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
<h1>회원 탈퇴</h1>

<c:if test="${param.error == 'empty'}">
    <p style="color:red;">비밀번호를 입력해주세요.</p>
</c:if>

<c:if test="${param.error == 'fail'}">
    <p style="color:red;">비밀번호를 확인해주세요.</p>
</c:if>

<form action="<c:url value='/users/${authUser.email}/deleteconfirm' />" method="post">
    <label for="password">비밀번호:</label>
    <input type="password" id="password" name="password"><br>
    <input type="hidden" name="userNo" value="${userNo}">
    <button type="submit">확인</button>
    <button type="button" onclick="window.location.href='/dvd/'">취소</button>
    <button type="button" onclick="window.history.back();">뒤로가기</button>
</form>

</body>
</html>
