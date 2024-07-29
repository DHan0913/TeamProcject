<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 정보 상세페이지</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/userinfo.css' />">
</head>
<body>
    <header id="header">
        <c:if test="${not empty errorMsg}">
            <h5 id="errorMsg">${errorMsg}</h5>
        </c:if>
        <h1>내 정보 페이지</h1>
    </header>
    <main id="main-content">
        <c:choose>
            <c:when test="${not empty authUser}">
                <form:form modelAttribute="userVo" id="info-form" name="userInfoForm" method="POST" action="<c:url value='/users/Infoform' />">
                    <div class="form-group">
                        <label class="block-label">이름: ${authUser.username}</label>
                        <label class="block-label">이메일: ${authUser.email}</label>
                        <label class="block-label">생년월일: ${authUser.birth}</label>

                        <div class="button-group">
                            <button type="button" onclick="location.href='<c:url value="/users/updateform" />'">수정하기</button>
                            <button type="button" onclick="location.href='<c:url value="/users/deleteconfirm" />'">탈퇴하기</button>
                            <button type="button" onclick="location.href='<c:url value="/users/coupon" />'">쿠폰충전</button>
                            <button type="button" onclick="location.href='<c:url value="/users/couponlist" />'">쿠폰관리</button>
                            <button type="button" onclick="location.href='<c:url value="/users/watchhistory?userNo=${authUser.userNo}" />'">구매내역</button>
                            <button type="button" onclick="location.href='<c:url value="/" />'">홈으로</button>
                        </div>
                    </div>
                </form:form>
            </c:when>
        </c:choose>
    </main>
</body>
</html>
