<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div id="container">
        <!-- Include header -->
        <c:import url="/WEB-INF/views/includes/header.jsp" />

        <h2>상품 등록</h2>
        <form action="<c:url value='/products/addproduct'/>" method="POST">
            <label for="productName">제품이름:</label><br>
            <input type="text" id="productName" name="productName" required><br>

            <label for="genre">장르:</label><br>
            <input type="text" id="genre" name="genre" required><br>

            <label for="content">줄거리:</label><br>
            <textarea id="content" name="content" rows="4" required></textarea><br>

            <label for="status">대여여부:</label><br>
            <input type="text" id="status" name="status" required><br>

            <!-- You can add more fields as needed -->

            <button type="submit">등록</button>
        </form>
    </div>
</body>
</html>