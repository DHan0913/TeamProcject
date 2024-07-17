<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="navigation">
	<ul>
		<li><a href='<c:url value="/admin/users" />'>유저관리</a></li>
		<li><a href='<c:url value="/admin/productlist" />'>상품관리</a></li>
		<li><a href='<c:url value="/admin/ip-block" />'>IP 관리</a></li>
		<li><a href='<c:url value="/admin/acceptcash" />'>캐시요청화면</a></li>
		<li><a href='<c:url value="/admin/membership" />'>멤버쉽 관리</a></li>
		<li><a href='<c:url value="/admin/coupons" />'>쿠폰 관리</a></li>
		<li><a href='<c:url value="/admin/totalrank" />'>통계 관리</a></li>
	</ul>
</div>
