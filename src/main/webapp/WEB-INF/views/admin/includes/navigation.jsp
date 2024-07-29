<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Admin Panel</title>
    <link href="<c:url value='/css/navigation.css' />" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
</head>
<body>
<!-- 사이드 네비게이션 바 -->
<nav class="sidebar">
    <ul class="sidebar-menu">
        <li><a href='<c:url value="/admin/users" />'>유저관리</a></li>
        <li><a href='<c:url value="/admin/productlist" />'>상품관리</a></li>
        <li><a href='<c:url value="/admin/ip-block" />'>IP 관리</a></li>
        <li><a href='<c:url value="/admin/acceptcash" />'>캐시요청화면</a></li>
        <li><a href='<c:url value="/admin/coupons" />'>쿠폰 관리</a></li>
        <li><a href='<c:url value="/admin/totalrank" />'>통계 관리</a></li>
        <li><a href='<c:url value="/admin/notice" />'>공지사항</a></li>
        <li><a href='<c:url value="/" />' class="user-page-link">유저 페이지</a></li>
    </ul>
</nav>


<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
</body>
</html>
