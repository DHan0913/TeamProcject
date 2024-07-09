<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 페이지</title>
</head>
<body>

    <h1>상품 등록</h1>
    <form action="/products/add" method="post">
        <label for="productName">상품명:</label>
        <input type="text" id="productName" name="productName" required>
        <br>
        <label for="genre">장르:</label>
        <input type="text" id="genre" name="genre" required>
        <br>
        <label for="releaseDate">출시일:</label>
        <input type="date" id="releaseDate" name="releaseDate" required>
        <br>
        <label for="content">내용:</label>
        <textarea id="content" name="content" required></textarea>
        <br>
        <label for="status">상태:</label>
        <input type="text" id="status" name="status" required>
        <br>
        <label for="img">이미지:</label>
      	<input type="file" name="img">

        <br>
        <button type="submit">등록</button>
    </form>

</body>
</html>