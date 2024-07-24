<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세조회</title>
</head>
<body>
    <div id="container">
        <c:import url="/WEB-INF/views/admin/includes/header.jsp" />
        <c:import url="/WEB-INF/views/admin/includes/navigation.jsp" />
    </div>
    <h1>공지사항 상세조회</h1>
    <table>
        <tr>
            <th>제목</th>
            <td>${notice.title}</td>
        </tr>
        <tr>
            <th>내용</th>
            <td>${notice.content}</td>
        </tr>
    </table>
    <a href="<c:url value='/admin/notice' />">목록으로 돌아가기</a>
</body>
</html>
