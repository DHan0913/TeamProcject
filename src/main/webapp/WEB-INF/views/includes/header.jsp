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
			<div id="search-bar">
				<c:url var="searchUrl" value="/products/search" />
				<form action="${searchUrl}" method="GET">
					<input type="text" name="keyword" placeholder="검색">
					<button type="submit">검색</button>
				</form>
			</div>
			<ul>
				<li><a href='<c:url value="/users/logout" />'>로그아웃</a></li>
				<li>${authUser.username }님환영합니다</li>
			</ul>
		</c:when>
		<c:otherwise>
			<div id="search-bar">
				<c:url var="searchUrl" value="/products/search" />
				<form action="${searchUrl}" method="GET">
					<input type="text" name="keyword" placeholder="검색">
					<button type="submit">검색</button>
				</form>
			</div>
			<div class="button">
				<button onclick="location.href='<c:url value="/users/login" />'">로그인</button>
				<button onclick="location.href='<c:url value="/users/join" />'">회원가입</button>
			</div>
		</c:otherwise>
	</c:choose>
</div>
