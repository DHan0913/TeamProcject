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
    <div class="sidebar-header">
        <h3><i class="fas fa-crown"></i> Admin Panel</h3>
    </div>
    <ul class="sidebar-menu">
        <li><a href='<c:url value="/admin/users" />'><i class="fas fa-users"></i> 유저관리</a></li>
        <li><a href='<c:url value="/admin/productlist" />'><i class="fas fa-box-open"></i> 상품관리</a></li>
        <li><a href='<c:url value="/admin/ip-block" />'><i class="fas fa-ban"></i> IP 관리</a></li>
        <li><a href='<c:url value="/admin/acceptcash" />'><i class="fas fa-money-check-alt"></i> 캐시요청화면</a></li>
        <li><a href='<c:url value="/admin/coupons" />'><i class="fas fa-ticket-alt"></i> 쿠폰 관리</a></li>
        <li><a href='<c:url value="/admin/totalrank" />'><i class="fas fa-chart-bar"></i> 통계 관리</a></li>
        <li><a href='<c:url value="/admin/notice" />'><i class="fas fa-notice"></i> 공지사항</a></li>
    </ul>
</nav>

<!-- 콘텐츠 영역 -->
<div class="content">
    <h1>Admin Dashboard</h1>
    <!-- 관리자 대시보드 콘텐츠 -->
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
</body>
</html>
