<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Notice</title>
</head>
<body>
    <h1>공지사항 추가</h1>
    <form action="<c:url value='/admin/notice/add' />" method="post">
        <label for="title">제목</label>
        <input type="text" id="title" name="title" required>
        <label for="content">내용</label>
        <textarea id="content" name="content" required></textarea>
        <button type="submit">등록</button>
    </form>
</body>
</html>

