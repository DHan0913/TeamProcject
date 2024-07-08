<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>사용자 관리</title>
</head>
<body>
    <c:import url="/WEB-INF/views/includes/header2.jsp"/>
    <c:import url="/WEB-INF/views/includes/navigation2.jsp"/>
    <main>
        <h2>사용자 목록</h2>
        <table border="1">
            <tr>
                <th>번호</th>
                <th>이름</th>
                <th>이메일</th>
                <th>생년월일</th>
                <th>역할</th>
                <th>가입일</th>
                <th>작업</th>
            </tr>
            <!-- 사용자 목록이 여기에 표시됩니다 -->
        </table>
    </main>
    <c:import url="/WEB-INF/views/includes/footer2.jsp"/>
</body>
</html>
