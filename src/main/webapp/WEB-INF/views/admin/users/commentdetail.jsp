<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value='/css/commentdetaill.css' />" rel="stylesheet">
<meta charset="UTF-8">
<title>댓글</title>
</head>
<body>
	<c:import url="/WEB-INF/views/admin/includes/header.jsp" />
	<c:import url="/WEB-INF/views/admin/includes/navigation.jsp" />
	<div class="container">
		<h1>댓글</h1>
		<table border="1" width="100%">
			<tr>
				<th>유저아이디</th>
				<th>댓글번호</th>
				<th>댓글작성일</th>
				<th>게시글번호</th>
				<th>댓글내용</th>

			</tr>
			<c:forEach var="comment" items="${comments}">
				<tr>
					<td>${comment.userId }</td>
					<td>${comment.id}</td>
					<td>${comment.createdDate}</td>
					<td><a href='<c:url value="/board/noticelist/${comment.noticeId}" />'>${comment.noticeId}</a></td>
					<td>${comment.content}</td>

				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>
