<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>헤더</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/header.css' />">
</head>
<body>
    <header id="header">
        <div class="container">
            <c:if test="${not empty errorMsg}">
                <div class="error-message">${errorMsg}</div>
            </c:if>
            <h1 class="site-title"><a href="<c:url value='/' />">VOD</a></h1>
            <div class="header-actions">
                <c:choose>
                    <c:when test="${not empty authUser}">
                        <nav>
                            <ul class="nav-list">
                                <li><a href="<c:url value='/users/logout' />" class="nav-link">로그아웃</a></li>
                                <li><a href="<c:url value='/users/${authUser.email}/userinfo' />" class="nav-link">${authUser.username}님 환영합니다</a></li>
                                <c:if test="${empty authAdmin}">
                                    <li>
                                        <p><a href="<c:url value='/users/requestcash' />" class="nav-link">캐시 충전</a></p>
                                        <p>잔액: <a href="<c:url value='/users/cashhistory' />" class="nav-link">${sessionScope.approvedCashAmount}</a></p>
                                    </li>
                                </c:if>
                            </ul>
                        </nav>
                    </c:when>
                    <c:otherwise>
                        <div class="button-group">
                            <button onclick="location.href='<c:url value="/users/login" />'" class="btn btn-login">로그인</button>
                            <button onclick="location.href='<c:url value="/users/join" />'" class="btn btn-signup">회원가입</button>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <div class="notice">
            <c:if test="${not empty latestNotice}">
                <p><strong>공지사항:</strong> ${latestNotice.title}</p>
            </c:if>
        </div>
    </header>
</body>
</html>
