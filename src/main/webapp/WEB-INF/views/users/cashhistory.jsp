<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>충전 내역</title>
<link href="<c:url value='/css/cashhistory.css' />" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1>충전 내역</h1>
        <table>
            <tr>
                <th>승인 날짜</th>
                <th>금액</th>
                <th>상태</th>
            </tr>
            <c:forEach var="cash" items="${cashList}">
                <c:if test="${cash.amount > 0}">
                    <tr>
                        <td>${cash.approveDate}</td>
                        <td>${cash.amount}</td>
                        <td>${cash.status}</td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
        <button onclick="location.href='<c:url value="/" />'">홈으로</button>
    </div>
</body>
</html>
