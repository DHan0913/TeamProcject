<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>헤더</title>
    <link href="<c:url value='/css/userheader.css' />" rel="stylesheet">
</head>
<body>
    <header id="header">
        <div class="headerContainer">
            <c:if test="${not empty errorMsg}">
                <div class="error-message">${errorMsg}</div>
            </c:if>
            <h1 class="site-title"><a href="<c:url value='/' />">VOD</a></h1>
            <c:if test="${not empty latestNotice}">
                <div class="notice">
                    <p><strong>공지사항:</strong> 
                        <a href="<c:url value='/board/noticelist' />">${latestNotice.title}</a>
                    </p>
                </div>
            </c:if>
            <div class="header-actions">
                <c:choose>
                    <c:when test="${not empty authUser}">
                        <nav>
                            <ul class="nav-list">
							    <li class="nav-item">
							        <a href="<c:url value='/users/logout' />" class="nav-link">로그아웃</a>
							    </li>
							    <li class="nav-item">
							        <a href="<c:url value='/users/${authUser.email}/userinfo' />" class="nav-link user-welcome">${authUser.username}님 [마이페이지]</a>
							    </li>
							    <c:if test="${empty authAdmin}">
							        <li class="nav-item">
							            <a href="<c:url value='/users/requestcash' />" class="nav-link">캐시 충전</a>
							        </li>
							        <li class="nav-item cash-item">
							            <span class="cash-balance">잔액: </span>
							            <a href="<c:url value='/users/cashhistory' />" class="nav-link cash-amount">${sessionScope.approvedCashAmount}</a>
							        </li>
							    </c:if>
							</ul>
                        </nav>
                    </c:when>
                    <c:otherwise>
                        <div class="button-group">
                            <button onclick="location.href='<c:url value="/users/login" />'" class="btn btn-login" style="background-color:#121212;">로그인</button>
                            <button onclick="location.href='<c:url value="/users/join" />'" class="btn btn-signup" style="background-color:#121212;">회원가입</button>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </header>
</body>
</html>
