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
				<li><a hred='<c:url value="/updateuser/updateform" />'>MY PAGE</a>
				<li>${authUser.username }님환영합니다</li>
			</ul>
		</c:when>
	</c:choose>
</div>
