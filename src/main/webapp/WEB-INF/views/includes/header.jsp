<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Header</title>
    <style>
        #header {
            margin-bottom: 20px;
            text-align: center;
        }

        #header h1 {
            display: inline;
            margin: 0;
        }

        .right {
            float: right;
        }

        button {
            margin-left: 5px;
        }
    </style>
</head>
<body>
    <header id="header">
        <h1>DVD</h1>
        <div class="right">
            <button onclick="location.href='<c:url value="/users/login" />'">로그인</button>
            <button onclick="location.href='<c:url value="/users/join" />'">회원가입</button>
        </div>
    </header>
</body>
</html>
