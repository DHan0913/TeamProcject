<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <th>상품사진</th>
            <td><c:if test="${not empty product.img}">
                    <img src="<c:url value='/upload-images/${product.img}' />" />
                </c:if></td>
        </tr>
        <tr>
            <th>동영상</th>
            <td>
                <c:if test="${hasPermission}">
                    <iframe width="560" height="315"
                            src="https://www.youtube.com/embed/${product.video}"
                            frameborder="0"
                            allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                            allowfullscreen></iframe>
                </c:if>
                <c:if test="${not hasPermission}">
                    <p>동영상을 시청할 권한이 없습니다. 권한을 요청하시려면 관리자에게 문의하세요.</p>
                    <P><button onclick="location.href='<c:url value="/users/payment" />'">구매하기</button></P>
                </c:if>
            </td>
        </tr>
    </table>
</body>
</html>
