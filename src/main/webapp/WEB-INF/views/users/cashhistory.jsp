<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>충전 내역</title>
</head>
<body>
    <h1>충전 내역</h1>
    <table border="1">
        <tr>
            <th>승인 날짜</th>
            <th>금액</th>
            <th>상태</th>
        </tr>
        <c:forEach var="cash" items="${cashList}">
            <tr>
                <td>${cash.approveDate}</td>
                <td>${cash.amount}</td>
                <td>${cash.status}</td>
            </tr>
        </c:forEach>
    </table>
    <h3>총 충전금액: ${totalAmount}</h3>
    <button onclick="location.href='<c:url value="/" />'">홈으로</button>
</body>
</html>
