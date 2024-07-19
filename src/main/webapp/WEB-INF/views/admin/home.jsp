<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div id="container">
        <!-- 헤더 포함 -->
        <%@ include file="/WEB-INF/views/admin/includes/header.jsp" %>
        <!-- 네비게이션 포함 -->
        <%@ include file="/WEB-INF/views/admin/includes/navigation.jsp" %>
        <div id="content" class="container">
            <button onclick="location.href='<c:url value="/" />'" class="btn btn-primary">관리자 페이지</button>
        </div>

		<%@ include file="/WEB-INF/views/admin/includes/footer.jsp" %>
		 </div>
</body>
</html>
