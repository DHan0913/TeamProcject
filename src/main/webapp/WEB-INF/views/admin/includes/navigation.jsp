<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Admin Panel</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 70px; /* Padding for fixed navbar */
            background-color: #f8f9fa;
        }
        .navbar {
            background: linear-gradient(45deg, #343a40, #007bff);
        }
        .navbar-brand {
            font-weight: bold;
            font-size: 1.5em;
            color: #fff !important;
        }
        .nav-link {
            font-size: 1.1em;
            color: #fff !important;
        }
        .nav-link:hover {
            color: #007bff !important;
            background-color: #ffffff20;
            border-radius: 5px;
        }
        .nav-item.active .nav-link {
            color: #fff !important;
            background-color: #007bff !important;
            border-radius: 5px;
        }
        .container {
            margin-top: 30px;
        }
        h1 {
            margin-bottom: 20px;
            color: #343a40;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg fixed-top shadow">
    <a class="navbar-brand" href="#"><i class="fas fa-cogs"></i> Admin Panel</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href='<c:url value="/admin/users" />'><i class="fas fa-users"></i> 유저관리</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href='<c:url value="/admin/productlist" />'><i class="fas fa-box-open"></i> 상품관리</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href='<c:url value="/admin/ip-block" />'><i class="fas fa-ban"></i> IP 관리</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href='<c:url value="/admin/acceptcash" />'><i class="fas fa-money-check-alt"></i> 캐시요청화면</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href='<c:url value="/admin/membership" />'><i class="fas fa-id-card"></i> 멤버쉽 관리</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href='<c:url value="/admin/coupons" />'><i class="fas fa-ticket-alt"></i> 쿠폰 관리</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href='<c:url value="/admin/totalrank" />'><i class="fas fa-chart-bar"></i> 통계 관리</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <h1>Admin Dashboard</h1>
    <!-- Admin content goes here -->
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
