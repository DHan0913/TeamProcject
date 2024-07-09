<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 상세 정보</title>
</head>
<body>
    <h1>상품 상세 정보</h1>
    <table border="1">
        <tr>
            <th>상품번호</th>
            <td>${product.productNo}</td>
        </tr>
        <tr>
            <th>상품이름</th>
            <td>${product.productName}</td>
        </tr>
        <tr>
            <th>장르</th>
            <td>${product.genre}</td>
        </tr>
        <tr>
            <th>출시일</th>
            <td>${product.releaseDate}</td>
        </tr>
        <tr>
            <th>대여가능여부</th>
            <td>${product.status}</td>
        </tr>
        
           <tr>
            <th>대여가능여부</th>
            <td><img src="<c:url value='/upload-images/123.jpg' />" /></td>
        </tr>
        
    </table>
</body>
</html>
