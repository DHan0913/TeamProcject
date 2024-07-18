<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
<h1>회원 정보 수정</h1>
<form id="update-form" name="updateForm" method="POST" action="<c:url value='/users/updateform' />">
    <input type="hidden" id="userNo" name="userNo" value="${authUser.userNo}" />
    <div class="form-group">
        <label class="block-label" for="username">이름</label>
        <input type="text" id="username" name="username" value="${authUser.username}" readonly />
    </div>
    <div class="form-group">
        <label class="block-label">이메일</label>
        <input type="email" id="email" name="email" value="${authUser.email}" readonly />
    </div>
    <div class="form-group">
        <label class="block-label">비밀번호</label>
        <input name="password" type="password" placeholder="비밀번호 입력">
    </div>
    <button type="submit">수정</button>
    <button type="button" onclick="window.location.href='<c:url value="/" />'">취소</button>
</form>
</body>
</html>
