<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page import="himedia.dvd.repositories.vo.UserVo" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>캐시 충전 요청</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css' />">
</head>
<body>
    <div class="container">
        <h2>캐시 충전 요청</h2>
        <c:if test="${not empty message}">
            <div class="message">${message}</div>
        </c:if>
        <c:if test="${not empty errorMessage}">
            <div class="error-message">${errorMessage}</div>
        </c:if>
        <form id="cashRequestForm" action="<c:url value='/users/requestcash' />" method="post">
            <div>
                <label for="requestId">요청 ID:</label>
                <input type="text" id="requestId" name="requestId" required>
            </div>
            <div>
                <label for="amount">충전 금액:</label>
                <input type="number" id="amount" name="amount" required>
            </div>
            <input type="hidden" id="userNo" name="userNo" value="<%= ((UserVo) session.getAttribute("authUser")).getUserNo() %>">
            <input type="hidden" id="email" name="email" value="<%= ((UserVo) session.getAttribute("authUser")).getEmail() %>">
            <br>
            <div>
                <button type="submit">충전 요청</button>
                <button type="button" onclick="window.history.back();">뒤로가기</button>
            </div>
        </form>
        <div id="error-message" style="color: red;"></div>
    </div>
    
    <script src="<c:url value='/javascript/cash.js' />"></script>
</body>
</html>
