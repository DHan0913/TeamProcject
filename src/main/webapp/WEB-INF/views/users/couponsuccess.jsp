<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰 등록</title>
<link href="<c:url value='/css/couponsuccess.css' />" rel="stylesheet">
</head>
<body>
    <div class="container success-container">
        <div class="card mt-5">
            <div class="card-body text-center">
				<h1 class="card-title">쿠폰 등록 성공</h1>
				
				<p class="card-text">
					<a href='${authUser.email}/userinfo' class="btn-custom">내 정보로 이동</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>