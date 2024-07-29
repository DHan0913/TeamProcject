<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>가입 성공</title>
    <link href="<c:url value='/css/joinsuccess.css' />" rel="stylesheet">
</head>
<body>
    <div class="container success-container">
        <div class="card mt-5">
            <div class="card-body text-center">
                <h1 class="card-title">회원 가입 성공</h1>
                <p class="card-text">회원 가입이 성공적으로 완료되었습니다.</p>
                <a href="<c:url value='/users/login' />" class="btn btn-primary btn-custom"><i class="fas fa-sign-in-alt"></i> 로그인하기</a>
            </div>
        </div>
    </div>
</body>
</html>
