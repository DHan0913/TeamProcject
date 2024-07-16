<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IP 관리</title>
</head>
<body>
    <div id="container">
        <!-- 헤더 포함 -->
        <c:import url="/WEB-INF/views/admin/includes/header.jsp" />

        <div id="content">
            <h1>IP 관리</h1>

            <!-- 부적절한 접근 시도 IP 목록 -->
            <h2>부적절한 접근 시도 IP 목록</h2>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>IP 주소</th>
                        <th>시도 횟수</th>
                        <th>마지막 시도 시간</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="attempt" items="${attempts}">
                        <tr>
                            <td>${attempt.id}</td>
                            <td>${attempt.ipAddress}</td>
                            <td>${attempt.attempts}</td>
                            <td>${attempt.lastAttempt}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <!-- 차단된 IP 목록 -->
            <h2>차단된 IP 목록</h2>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>IP 주소</th>
                        <th>차단 시간</th>
                        <th>차단한 관리자</th>
                        <th>관리</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="blockedIp" items="${blockedIps}">
                        <tr>
                            <td>${blockedIp.id}</td>
                            <td>${blockedIp.ipAddress}</td>
                            <td>${blockedIp.blockedAt}</td>
                            <td>${blockedIp.blockedBy}</td>
                            <td>
                                <form action="<c:url value='/admin/unblock-ip' />" method="post" style="display:inline;">
                                    <input type="hidden" name="ip" value="${blockedIp.ipAddress}" />
                                    <button type="submit">차단 해제</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <!-- IP 차단 폼 -->
            <h2>IP 차단</h2>
            <form action="<c:url value='/admin/block-ip' />" method="post">
                <label for="ip">IP 주소:</label>
                <input type="text" id="ip" name="ip" required />
                <label for="adminId">관리자 ID:</label>
                <input type="text" id="adminId" name="adminId" required />
                <button type="submit">차단</button>
            </form>
        </div>
    </div>
</body>
</html>
