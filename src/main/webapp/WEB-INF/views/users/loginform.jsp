<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VoD 로그인</title>
    <link href="<c:url value='/css/loginform.css' />" rel="stylesheet"> <!-- 사용자 정의 CSS -->
</head>
<body>
    <div class="container">
        <h1 class="text-center">로그인</h1>

        <!-- 에러 메시지 출력 -->
        <c:if test="${param.error == 'empty'}">
            <p class="error-message">이메일 또는 비밀번호를 입력해주세요.</p>
        </c:if>

        <c:if test="${param.error == 'fail'}">
            <p class="error-message">로그인에 실패했습니다.</p>
        </c:if>

        <form action="${pageContext.request.contextPath}/users/login" method="post" class="login-form">
            <div class="form-group">
                <label for="email">이메일</label>
                <input type="text" id="email" name="email" class="form-control">
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password" class="form-control">
            </div>
            <button type="submit" class="btn btn-primary">로그인</button>
        </form>

        <div class="text-center mt-3">
            <button class="btn btn-secondary" onclick="location.href='<c:url value="/users/join" />'">회원가입</button>
            <button class="btn btn-secondary" onclick="window.history.back();">뒤로가기</button>
        </div>
    </div>
</body>
</html>
