<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/footer.css" rel="stylesheet">
<style>
    body {
        padding-top: 70px;
        background-color: #f8f9fa;
        display: flex;
        flex-direction: column;
        min-height: 100vh;
    }
    #container {
        flex: 1;
    }
    #content {
        margin-top: 20px;
    }
</style>
</head>
<body>
    <div id="container">
        <!-- 헤더 포함 -->
        <%@ include file="/WEB-INF/views/admin/includes/header.jsp" %>
        <!-- 네비게이션 포함 -->
        <%@ include file="/WEB-INF/views/admin/includes/navigation.jsp" %>
        <div id="content" class="container">
            <button onclick="location.href='<c:url value="/" />'" class="btn btn-primary">유저 페이지</button>
        </div>
    </div>
    <footer class="footer">
        <div class="container">
            <div class="footer-links">
                <a href="#">사이트 소개</a>
                <a href="#">team project</a>
            </div>
            <div class="footer-copy">
                &copy; 2024 Admin Panel. All rights reserved.
            </div>
        </div>
    </footer>
</body>
</html>
