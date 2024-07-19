<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>WATCH HISTORY</title>
    <style>
        .product-item {
            margin-bottom: 20px;
        }
        .product-image {
            max-width: 150px;
            display: block;
        }
        .product-link {
            font-size: 18px;
            text-decoration: none;
            color: #333;
        }
        .product-link:hover {
            text-decoration: underline;
        }
        .image-container {
            display: flex;
            align-items: center;
        }
    </style>
</head>
<body>
    <h1>구매 내역</h1>
    <div>
        <c:forEach var="history" items="${watchHistory}">
            <div class="product-item">
                <div class="image-container">
                    <img class="product-image" src="<c:url value='/upload-images/${history.IMG}' />" />
                </div>
                <a class="product-link" href="<c:url value='/products/detail?productNo=${history.PRODUCTNO}' />">${history.PRODUCTNAME}</a>
            </div>
        </c:forEach>
    </div>
</body>
</html>
