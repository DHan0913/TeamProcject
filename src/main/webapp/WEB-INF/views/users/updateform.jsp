<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<script src="<c:url value="/javascript/update.js" />"></script>
</head>
<body>
    <h1>회원 정보 수정</h1>
    <form id="update-form" name="updateForm" method="POST" action="<c:url value='/users/updateform' />">
        
        <input type="hidden" id="userNo" name="userNo" value="${authUser.userNo }" />
        <div class="form-group">
            <label class="block-label" for="username" readonly>이름 ${authUser.username }</label>
        </div>
        <div class="form-group">
            <label class="block-label">이메일</label> 
            <input name="email" type="email" value="${authUser.email}" placeholder="이메일을 입력하십시오">
            <input type="button" id="check-email" data-target="<c:url value="/users/checkEmail" />" value="이메일 중복체크" /><br>    
            <input type="hidden" name="emailCheck" value="n" />
        </div>
       <div class="form-group">
            <label class="block-label">비밀번호</label> 
            <input name="password" type="password" value="${authUser.password}" placeholder="비밀번호 입력">
        </div>
       
        <input type="button" id="editButton" data-target="<c:url value="/users/updateComplete" />" value="수정"/>
        <button type="button" onclick="window.location.href='<c:url value="/" />'">취소</button>

    </form>
    
</body>
</html>
