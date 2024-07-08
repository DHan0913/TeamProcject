<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DVD 회원 정보 수정</title>
</head>
<body>
	<h1>회원 정보 수정</h1>
	<form id="update-form" name="updateForm" method="POST" action="<c:url value='/updateuser/updateform' />">
		
		<label class="block-label" for="name">이름</label>
		<input id="name" name="username" type="text" readonly><br>

		<label class="block-label">이메일</label> 
		<input name="email" type="email" placeholder="이메일을 입력하십시오">
		<input type="button" id="check-email" data-target="<c:url value="/users/checkEmail" />"value="이메일 중복체크" /><br>	
		<input type="hidden" name="emailCheck" value="n" />

		<label class="block-label">생년월일</label>
		<div class="bir_yy">
			<span class="ps_box">
				<input type="text" class="form-control" id="yy" placeholder="ex)0000년" maxlength="4" name="mb_yy">
			</span>
		</div>
		<div class="bir_mm">
			<span class="ps_box focus">
				<select class="form-select" id="mm" name="mb_mm">
					<option>월</option>
					<option value="01">1</option>
					<option value="02">2</option>
					<option value="03">3</option>
					<option value="04">4</option>
					<option value="05">5</option>
					<option value="06">6</option>
					<option value="07">7</option>
					<option value="08">8</option>
					<option value="09">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
				</select>
			</span>
		</div>
		<div class="bir_dd">
			<span class="ps_box">
				<input type="text" class="form-control" id="dd" placeholder="일" maxlength="2" name="mb_dd">
			</span>
		</div>

		<input type="submit" value="수정완료" />
		<a href="<c:url value="/home" />">취소</a>

	</form>
    <
</body>
</html>
