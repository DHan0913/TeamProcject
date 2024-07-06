<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>DVD</title>
</head>
<body>
    <div id="container">
        <!-- 헤더 포함 -->
        <c:import url="/WEB-INF/views/includes/header.jsp" />

        <div id="search-bar">
            <c:url var="searchUrl" value="/products/search" />
            <form action="${searchUrl}" method="GET">
                <input type="text" name="keyword" placeholder="검색">
                <button type="submit">검색</button>
            </form>
        </div>

        <div id="content">
            <div class="list-container">
                <table border="1" width="100%">
                    <tr>
                        <th>상품번호</th>
                        <th>상품이름</th>
                        <th>장르</th>
                        <th>출시일</th>
                    </tr>
                    <c:forEach var="product" items="${products}">
                        <tr>
                            <td>${product.productNo}</td>
                            <td>${product.productName}</td>
                            <td>${product.genre}</td>
                            <td>${product.releaseDate}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
