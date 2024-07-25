<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
</head>
<body>
    <div id="container">
        <c:import url="/WEB-INF/views/includes/header.jsp" />
    </div>
    <h1>공지사항</h1>
    <table>
        <tr>
            <th>제목</th>
            <td>${notice.title}</td>
        </tr>
        <tr>
            <th>내용</th>
            <td>${notice.content}</td>
        </tr>
    </table>

    <h2>댓글</h2>
    <c:if test="${not empty authUser}">
        <form action="<c:url value='/board/noticelist/${notice.id}/addComment' />" method="post">
            <label for="comment">댓글:</label>
            <textarea id="comment" name="comment" required rows="1" cols="20"></textarea>
            <br>
            <label for="secret">비밀댓글:</label>
            <input type="checkbox" id="secret" name="secret" value="Y">
            <input type="hidden" name="_secret" value="N">
            <br>
            <button type="submit">댓글달기</button>
        </form>
    </c:if>
    <c:if test="${empty authUser}">
        <p>
            로그인된 사용자만 댓글을 달 수 있습니다. <a href="<c:url value='/users/login' />">로그인</a>
        </p>
    </c:if>

    <c:forEach var="comment" items="${comments}">
        <c:choose>
            <c:when test="${comment.secret == 'Y'}">
                <c:if test="${comment.userId == authUser.userNo || authUser.role == 1}">
                    <div>
                        <p>
                            <strong>${comment.username}</strong>: ${comment.content}
                        </p>
                    </div>
                </c:if>
                <c:if test="${comment.userId != authUser.userNo && authUser.role != 1}">
                    <div>
                        <p>
                            <strong>${comment.username}</strong>: 비밀댓글입니다
                        </p>
                    </div>
                </c:if>
            </c:when>
            <c:otherwise>
                <div>
                    <p>
                        <strong>${comment.username}</strong>: ${comment.content}
                    </p>
                </div>
            </c:otherwise>
        </c:choose>

        <!-- 대댓글 목록 -->
        <c:forEach var="reply" items="${comment.replies}">
            <c:choose>
                <c:when test="${reply.secret == 'Y'}">
                    <c:if test="${reply.userId == authUser.userNo || authUser.role == 1 || comment.userId == authUser.userNo}">
                        <div style="margin-left: 20px;">
                            <p>
                                <strong>${reply.username}</strong>: ${reply.content}
                            </p>
                        </div>
                    </c:if>
                    <c:if test="${reply.userId != authUser.userNo && authUser.role != 1 && comment.userId != authUser.userNo}">
                        <div style="margin-left: 20px;">
                            <p>
                                <strong>${reply.username}</strong>: 비밀댓글입니다
                            </p>
                        </div>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <div style="margin-left: 20px;">
                        <p>
                            <strong>${reply.username}</strong>: ${reply.content}
                        </p>
                    </div>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <!-- 대댓글 입력 폼 -->
        <c:if test="${not empty authUser}">
            <div style="margin-left: 20px;">
                <form action="<c:url value='/board/noticelist/${notice.id}/addReply' />" method="post">
                    <input type="hidden" name="commentId" value="${comment.id}">
                    <label for="reply">댓글:</label>
                    <textarea id="reply" name="reply" required rows="1" cols="20"></textarea>
                    <br>
                    <label for="secretReply">비밀댓글:</label>
                    <input type="checkbox" id="secretReply" name="secretReply" value="Y">
                    <input type="hidden" name="_secretReply" value="N">
                    <br>
                    <button type="submit">댓글달기</button>
                </form>
            </div>
        </c:if>
    </c:forEach>
    
    <a href="<c:url value='/board/noticelist' />">목록으로 돌아가기</a>

</body>
</html>
