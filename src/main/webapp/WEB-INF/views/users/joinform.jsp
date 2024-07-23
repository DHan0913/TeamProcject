<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>VOD 회원 가입</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <link href="<c:url value='/css/joinform.css' />" rel="stylesheet">
    <script src="<c:url value='/javascript/user.js' />"></script>
</head>
<body>
    <div class="container form-container">
        <h1 class="form-title">회원 가입</h1>

        <form:form modelAttribute="userVo" id="join-form" name="registerForm"
            action="${pageContext.servletContext.contextPath}/users/join" method="POST">
            
            <div class="form-group">
                <label for="username">이름</label>
                <form:input path="username" class="form-control" placeholder="이름을 입력하십시오" />
                <form:errors path="username" cssClass="error" />
            </div>

            <div class="form-group">
                <label for="password">비밀번호</label>
                <form:input path="password" type="password" class="form-control" placeholder="비밀번호를 입력하십시오" />
                <form:errors path="password" cssClass="error" />
            </div>

            <div class="form-group">
                <label for="passwordConfirm">비밀번호 확인</label>
                <form:input path="passwordConfirm" type="password" class="form-control" placeholder="비밀번호를 다시 입력하세요" />
                <form:errors path="passwordConfirm" cssClass="error" />
            </div>

            <div class="form-group">
                <label for="email">이메일</label>
                <form:input path="email" type="email" class="form-control" placeholder="이메일을 입력하십시오" />
                <input type="button" id="check-email" class="btn btn-secondary mt-2"
                    data-target="<c:url value='/users/checkEmail' />" value="이메일 중복체크" />
                <input type="hidden" name="emailCheck" value="n" />
                <form:errors path="email" cssClass="error" />
            </div>

            <div class="form-group">
                <label for="birth">생년월일</label>
                <input name="birth" type="date" id="birthInput" class="form-control">
                <form:errors path="birth" cssClass="error" />
            </div>

            <div class="form-group form-check">
                <form:checkbox path="agree" id="agree" class="form-check-input" />
                <label class="form-check-label" for="agree">약관동의</label>
                <form:errors path="agree" cssClass="error" />
            </div>

            <button type="submit" class="btn btn-primary btn-custom btn-block">가입하기</button>
            <button type="reset" class="btn btn-warning btn-block">다시 작성</button>
        </form:form>
        <button onclick="location.href='<c:url value='/' />'" class="btn btn-secondary btn-block mt-2">Home</button>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
