<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
</head>
<body>
    <div id="container">
        <c:import url="/WEB-INF/views/admin/includes/header.jsp" />
        <c:import url="/WEB-INF/views/admin/includes/navigation.jsp" />
    </div>
    <h1>공지사항 목록</h1>
    <a href="<c:url value='/admin/notice/add' />">공지사항 추가</a>
    <table>
        <thead>
            <tr>
                <th>제목</th>
                <th>내용</th>
                <th>작성일</th>
                <th>삭제</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="notice" items="${notices}">
                <tr>
                    <td>${notice.title}</td>
                    <td>${notice.content}</td>
                    <td>${notice.createdDate}</td>
                    <td>
                        <form action="<c:url value='/admin/notice/${notice.id}/delete' />" method="post" onsubmit="return confirm('정말 삭제하시겠습니까?');">
                            <button type="submit">삭제</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
