<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>WATCH HISTORY</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/watchhistory.css' />">
</head>
<body>
    <div class="container">
        <header>
            <h1>구매 내역</h1>
            <button type="button" class="btn-back" onclick="window.history.back();">뒤로가기</button>
        </header>
        <main>
            <c:forEach var="history" items="${watchHistory}">
                <div class="product-card">
                    <div class="image-container">
                        <a href="<c:url value='/products/detail?productNo=${history.PRODUCTNO}' />">
                            <img class="product-image" src="<c:url value='/upload-images/${history.IMG}' />" alt="${history.PRODUCTNAME}" />
                        </a>
                    </div>
                    <a class="product-link" href="<c:url value='/products/detail?productNo=${history.PRODUCTNO}' />">${history.PRODUCTNAME}</a>
                </div>
            </c:forEach>
        </main>
    </div>
</body>
</html>
