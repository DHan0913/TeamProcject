<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value='/css/acceptcash.css' />" rel="stylesheet">
    <meta charset="UTF-8">
    <title>캐시 충전 요청 목록</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css' />">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="<c:url value='/javascript/acceptcash.js' />" type="text/javascript"></script>
</head>
<body>
    <c:import url="/WEB-INF/views/admin/includes/header.jsp" />
    <c:import url="/WEB-INF/views/admin/includes/navigation.jsp" />
    <div id="content">
        <div class="list-container">
            <h2>캐시 충전 요청 목록</h2>
            <table border="1" width="100%">
                <tr>
                    <th>ID</th>
                    <th>요청ID</th>
                    <th>요청 금액</th>
                    <th>요청 일자</th>
                    <th>상태</th>
                    <th>관리</th>
                </tr>
                <c:set var="totalAmount" value="0" />
                <c:forEach var="cash" items="${requests}">
                <c:if test="${cash.status == '충전완료'}">
                    <c:set var="totalAmount" value="${totalAmount + cash.amount}" />
                </c:if>
                <tr>
                    <td>${cash.id}</td>
                    <td>${cash.requestId}</td>
                    <td>${cash.amount}</td>
                    <td>${cash.requestDate}</td>
                    <td class="status">${cash.status}</td>
                    <td>
                    <c:if test="${cash.status != '충전완료'}">
                        <form id="approve-form-${cash.id}" action="<c:url value='/admin/approve-request' />" method="post" style="display:inline;">
                            <input type="hidden" name="id" value="${cash.id}" />
                            <input type="hidden" name="amount" value="${cash.amount}" />
                            <button type="submit">승인</button>
                        </form>
                    
                        <form id="reject-form-${cash.id}" action="<c:url value='/admin/reject-request' />" method="post" style="display:inline;">
                            <input type="hidden" name="id" value="${cash.id}" />
                            <button type="submit">거절</button>
                        </form>
                        </c:if>
                    </td>
                </tr>
                </c:forEach>
            </table>
            <p>총 충전 완료 금액: ${totalAmount} 원</p>
            <a href="<c:url value="/admin/home"/>">홈</a>
        </div>
    </div>
    
</body>
</html>
