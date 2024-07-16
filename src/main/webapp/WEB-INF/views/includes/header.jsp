<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<link rel="stylesheet" type="text/css"
    href="<c:url value='/css/header.css' />">

<div id="header">
    <c:if test="${not empty errorMsg }">
        <h5>${errorMsg }</h5>
    </c:if>
    <h1>DVD</h1>
    <c:choose>
        <c:when test="${not empty authUser }">
            <ul>
                <li><a href='<c:url value="/users/logout" />'>로그아웃</a></li>
                <li><a href='<c:url value="/users/${authUser.email}/userinfo" />'>${authUser.username }님 환영합니다</a></li>
                <li>
            <button onclick="location.href='<c:url value='/users/requestcash' />'">캐시 충전</button>
		        </li>
            </ul>
        </c:when>
        <c:otherwise>
            <div class="button">
                <button onclick="location.href='<c:url value="/users/login" />'">로그인</button>
                <button onclick="location.href='<c:url value="/users/join" />'">회원가입</button>
            </div>
        </c:otherwise>
    </c:choose>
</div>