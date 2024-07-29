<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 페이지</title>
<!-- CSS 링크 추가 -->
<link rel="stylesheet" type="text/css" href="<c:url value='/css/addproduct.css'/>">
</head>
<body>
    <div class="container">
        <h1>상품 등록</h1>
        
        <!-- 상품 등록 폼 -->
        <form action="<c:url value='/admin/add' />" method="post" enctype="multipart/form-data">
            <label for="productName">상품명:</label> 
            <input type="text" id="productName" name="productName" required> 
            
            <label for="genre">장르:</label> 
            <input type="text" id="genre" name="genre" required> 
            
            <label for="releaseDate">출시일:</label> 
            <input type="date" id="releaseDate" name="releaseDate" required> 
            
            <label for="content">내용:</label>
            <textarea id="content" name="content" required></textarea>
            
            <label for="status">상태:</label> 
            <input type="text" id="status" name="status" required> 
            
            <label for="imageFile">이미지:</label> 
            <input type="file" id="imageFile" name="imageFile" required> 
            
            <label for="video">비디오 이름:</label> 
            <input type="text" id="video" name="video" required> 
            
            <button type="submit">등록</button>
            <a href="<c:url value='/admin/productlist'/>">취소</a>
        </form>
    </div>
</body>
</html>
