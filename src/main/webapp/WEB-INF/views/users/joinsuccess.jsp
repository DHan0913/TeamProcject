<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>가입 성공</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <link href="<c:url value='/css/joinsuccess.css' />" rel="stylesheet">
</head>
<body>
    <div class="container success-container">
        <div class="card mt-5">
            <div class="card-body text-center">
                <h1 class="card-title">회원 가입 성공</h1>
                <p class="card-text">회원 가입이 성공적으로 완료되었습니다.</p>
                <a href="login" class="btn btn-primary btn-custom"><i class="fas fa-sign-in-alt"></i> 로그인하기</a>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
