<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버십 수정</title>
</head>
<body>
    <h1>멤버십 수정</h1>
    <form method="post" action="<c:url value="/admin/membershipmodify"/>">
        <label>멤버십 이름: </label>
        <input type="text" name="name" value="${membership.name}" /><br />
        <label>가격: </label>
        <input type="text" name="price" value="${membership.price}" /><br />
        <input type="submit" value="수정" />
    </form>
</body>
</html>
