<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>사용자 관리</title>
</head>
<body>
	<c:import url="/WEB-INF/views/admin/includes/header.jsp" />
	<c:import url="/WEB-INF/views/admin/includes/navigation.jsp" />
	<div id="content">
		<%-- 성공 또는 실패 메시지가 있을 경우 출력 --%>
		<c:if test="${not empty successMessage}">
			<div class="alert alert-success">${successMessage}</div>
		</c:if>
		<c:if test="${not empty errorMessage}">
			<div class="alert alert-danger">${errorMessage}</div>
		</c:if>
		<div class="list-container">
			<table border="1" width="100%">
				<tr>
					<th>유저번호</th>
					<th>유저이름</th>
					<th>생년월일</th>
					<th>이메일</th>
					<th>가입일</th>
					<th>역할</th>
					<th>관리</th>
					<th>상태</th>
				</tr>
				<c:forEach var="user" items="${users}">
					<tr>
						<td>${user.userNo}</td>
						<td>${user.username}</td>
						<td>${user.birth}</td>
						<td>${user.email}</td>
						<td>${user.regdate}</td>
						<td><c:choose>
								<c:when test="${user.role == 0}">
                                    일반유저
                                </c:when>
								<c:when test="${user.role == 1}">
                                    관리자
                                </c:when>
								<c:otherwise>
                                    알 수 없음
                                </c:otherwise>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${user.status == '로그인 가능'}">
                                    로그인 가능
                                </c:when>
								<c:when test="${user.status == '탈퇴 요청'}">
                                    <c:if test="${user.username == '삭제된 회원' }"> 
                                    	탈퇴
                                    </c:if>
                                     <c:if test="${user.username != '삭제된 회원' }"> 
                                    	탈퇴 요청
                                    </c:if>
                                </c:when>
								<c:otherwise>
                                    알 수 없음
                                </c:otherwise>
							</c:choose></td>




						<td><c:if test="${user.status == '로그인 가능' }">
								<a href="<c:url value='/admin/users/${user.userNo}/reset' />">암호초기화</a>
							</c:if> <c:if test="${user.birth != '삭제된 회원' }">
								<c:if test="${user.status == '탈퇴 요청' }">
									<a href="<c:url value='/admin/users/${user.userNo}/delete' />">탈퇴</a>
								</c:if>
							</c:if></td>

					</tr>
				</c:forEach>
				<tr>
					<c:if test="${authUser.role == 1 }">
						<li>
							<button onclick="location.href='<c:url value="/admin/home" />'">관리자
								화면</button>
						</li>
					</c:if>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
