<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버십 가격</title>
</head>
<body>
	<c:import url="/WEB-INF/views/admin/includes/header.jsp" />
    <h1>멤버십 가격 안내</h1>
    <table border="1" width="100%">
        <tr>
        	<th>번호</th>
            <th>이름</th>
            <th>가격</th>
        </tr>
        <c:forEach var="membership" items="${memberships}">
            <tr>
            	<td>${membership.id }</td>
                <td>${membership.name}</td>
                <td>${membership.price}원</td>
                <td>
                    <a href="<c:url value='/admin/membershipmodify/${membership.id}' />">수정</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
