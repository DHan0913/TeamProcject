<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>공지사항 목록</title>
    <link href="<c:url value='/css/noticelist.css' />" rel="stylesheet">
</head>
<body>
    <div id="container">
        <c:import url="/WEB-INF/views/admin/includes/header.jsp" />
        <c:import url="/WEB-INF/views/admin/includes/navigation.jsp" />
    </div>
    <div id="content">
        <h1>공지사항 목록</h1>
        <a class="add-notice" href="<c:url value='/admin/notice/add' />">공지사항 추가</a>
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
                        <td><a href="<c:url value='/admin/notice/${notice.id}' />">${notice.title}</a></td>
                        <td>${notice.content}</td>
                        <td>${notice.createdDate}</td>
                        <td>
                            <form action="<c:url value='/admin/notice/${notice.id}/delete' />" method="post" onsubmit="return confirm('정말 삭제하시겠습니까?');">
                                <button type="submit" class="delete-button">삭제</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
