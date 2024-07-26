<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>공지사항 목록</title>
    <link href="<c:url value='/css/notice.css' />" rel="stylesheet">
</head>
<body>
    <div class="container">
        <c:import url="/WEB-INF/views/includes/header.jsp" />
        <h1>공지사항 목록</h1>
        <table>
            <thead>
                <tr>
                    <th>제목</th>
                    <th>내용</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="notice" items="${notices}">
                    <tr>
                        <td><a href="<c:url value='/board/noticelist/${notice.id}' />">${notice.title}</a></td>
                        <td>${notice.content}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
