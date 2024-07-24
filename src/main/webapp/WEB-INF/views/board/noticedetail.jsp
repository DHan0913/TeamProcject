<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <c:import url="/WEB-INF/views/includes/header.jsp" />
    </div>
    <h1>공지사항</h1>
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
    <a href="<c:url value='/board/noticelist' />">목록으로 돌아가기</a>

    <h2>댓글</h2>
    <c:if test="${not empty authUser}">
        <form action="<c:url value='/board/noticelist/${notice.id}/addComment' />" method="post">
            <label for="comment">댓글:</label>
            <textarea id="comment" name="comment" required></textarea>
            <button type="submit">댓글달기</button>
        </form>
    </c:if>
    <c:if test="${empty authUser}">
        <p>로그인된 사용자만 댓글을 달 수 있습니다. <a href="<c:url value='/users/login' />">로그인</a></p>
    </c:if>

    <h3>댓글 목록</h3>
    <c:forEach var="comment" items="${comments}">
        <div>
            <p><strong>${comment.username}</strong>: ${comment.content}</p>
        </div>
    </c:forEach>
</body>
</html>
