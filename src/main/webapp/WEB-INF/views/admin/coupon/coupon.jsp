<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰 관리</title>
</head>
<body>
	<h1>쿠폰 관리</h1>
	<a href="${pageContext.request.contextPath}/coupon/create">쿠폰 생성</a>
    <a href="${pageContext.request.contextPath}/coupon/issue">쿠폰 지급</a>
</body>
</html>