<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>공지사항</title>
    <link href="<c:url value='/css/noticedetail.css' />" rel="stylesheet">
    <script>
        function showEditForm(commentId) {
            document.querySelector('#comment-' + commentId + ' .display-content').style.display = 'none';
            document.querySelector('#comment-' + commentId + ' .edit-content').style.display = 'block';
        }

        function hideEditForm(commentId) {
            document.querySelector('#comment-' + commentId + ' .display-content').style.display = 'block';
            document.querySelector('#comment-' + commentId + ' .edit-content').style.display = 'none';
        }

        function updateComment(commentId) {
            const form = document.querySelector('#comment-' + commentId + ' .edit-content');
            const content = form.querySelector('textarea[name="content"]').value;
            const secret = form.querySelector('input[name="secret"]').checked ? 'Y' : 'N';
            
            const formData = new FormData();
            formData.append('id', commentId);
            formData.append('content', content);
            formData.append('secret', secret);

            fetch('<c:url value="/board/noticelist/updateComment" />', {
                method: 'POST',
                body: formData
            })
            .then(response => {
                if (response.ok) {
                    window.location.reload();
                } else {
                    alert('댓글 수정에 실패했습니다.');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('댓글 수정 중 오류가 발생했습니다.');
            });
        }

        function deleteComment(commentId) {
            const formData = new FormData();
            formData.append('id', commentId);

            fetch('<c:url value="/board/noticelist/deleteComment" />', {
                method: 'POST',
                body: formData
            })
            .then(response => {
                if (response.ok) {
                    document.querySelector('#comment-' + commentId + ' .display-content p').innerText = '삭제된 댓글입니다';
                } else {
                    alert('댓글 삭제에 실패했습니다.');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('댓글 삭제 중 오류가 발생했습니다.');
            });
        }

        function showEditReplyForm(replyId) {
            document.querySelector('#reply-' + replyId + ' .display-content').style.display = 'none';
            document.querySelector('#reply-' + replyId + ' .edit-content').style.display = 'block';
        }

        function hideEditReplyForm(replyId) {
            document.querySelector('#reply-' + replyId + ' .display-content').style.display = 'block';
            document.querySelector('#reply-' + replyId + ' .edit-content').style.display = 'none';
        }

        function updateReply(replyId) {
            const form = document.querySelector('#reply-' + replyId + ' .edit-content');
            const content = form.querySelector('textarea[name="content"]').value;
            const secret = form.querySelector('input[name="secret"]').checked ? 'Y' : 'N';
            
            const formData = new FormData();
            formData.append('id', replyId);
            formData.append('content', content);
            formData.append('secret', secret);

            fetch('<c:url value="/board/noticelist/updateReply" />', {
                method: 'POST',
                body: formData
            })
            .then(response => {
                if (response.ok) {
                    window.location.reload();
                } else {
                    alert('댓글 수정에 실패했습니다.');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('댓글 수정 중 오류가 발생했습니다.');
            });
        }

        function deleteReply(replyId) {
            const formData = new FormData();
            formData.append('id', replyId);

            fetch('<c:url value="/board/noticelist/deleteReply" />', {
                method: 'POST',
                body: formData
            })
            .then(response => {
                if (response.ok) {
                    document.querySelector('#reply-' + replyId + ' .display-content p').innerText = '삭제된 댓글입니다';
                } else {
                    alert('댓글 삭제에 실패했습니다.');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('댓글 삭제 중 오류가 발생했습니다.');
            });
        }
    </script>
</head>
<body>
    <div class="container">
        <!-- Header는 CSS로 숨겼으므로 제거 -->
        <!-- <c:import url="/WEB-INF/views/includes/header.jsp" /> -->

        <h1>공지사항</h1>
        <div class="notice-detail">
            <div class="notice-title">
                <span>제목:</span> ${notice.title}
            </div>
            <div class="notice-content">
                <span>내용:</span> ${notice.content}
            </div>
        </div>

        <h2>댓글</h2>
        <c:if test="${not empty authUser}">
            <form action="<c:url value='/board/noticelist/${notice.id}/addComment' />" method="post" class="comment-form">
                <label for="comment">댓글:</label>
                <textarea id="comment" name="comment" required rows="3" cols="40"></textarea>
                <br>
                <label for="secret">비밀댓글:</label>
                <input type="checkbox" id="secret" name="secret" value="Y">
                <input type="hidden" name="_secret" value="N">
                <br>
                <button type="submit">댓글달기</button>
            </form>
        </c:if>
        <c:if test="${empty authUser}">
            <p class="login-message">
                로그인된 사용자만 댓글을 달 수 있습니다. <a href="<c:url value='/users/login' />">로그인</a>
            </p>
        </c:if>

        <div class="comments-container">
            <c:forEach var="comment" items="${comments}">
                <c:if test="${comment.secret != 'D'}">
                    <div id="comment-${comment.id}" class="comment">
                        <c:choose>
                            <c:when test="${comment.secret == 'Y'}">
                                <c:if test="${comment.userId == authUser.userNo || authUser.role == 1}">
                                    <div class="display-content">
                                        <p>
                                            <strong>${comment.username}</strong>: ${comment.content}
                                        </p>
                                        <c:if test="${comment.userId == authUser.userNo}">
                                            <button onclick="showEditForm(${comment.id})">수정</button>
                                            <button onclick="deleteComment(${comment.id})">삭제</button>
                                        </c:if>
                                    </div>
                                    <div class="edit-content" style="display:none;">
                                        <textarea name="content" required rows="3" cols="40">${comment.content}</textarea>
                                        <br>
                                        <label for="secret">비밀댓글:</label>
                                        <input type="checkbox" name="secret" value="Y" <c:if test="${comment.secret == 'Y'}">checked</c:if>>
                                        <input type="hidden" name="_secret" value="N">
                                        <br>
                                        <button onclick="updateComment(${comment.id})">수정하기</button>
                                        <button onclick="hideEditForm(${comment.id})">취소</button>
                                    </div>
                                </c:if>
                                <c:if test="${comment.userId != authUser.userNo && authUser.role != 1}">
                                    <div class="display-content">
                                        <p>
                                            <strong>${comment.username}</strong>: 비밀댓글입니다
                                        </p>
                                    </div>
                                </c:if>
                            </c:when>
                            <c:otherwise>
                                <div class="display-content">
                                    <p>
                                        <strong>${comment.username}</strong>: ${comment.content}
                                    </p>
                                    <c:if test="${comment.userId == authUser.userNo}">
                                        <button onclick="showEditForm(${comment.id})">수정</button>
                                        <button onclick="deleteComment(${comment.id})">삭제</button>
                                    </c:if>
                                </div>
                                <div class="edit-content" style="display:none;">
                                    <textarea name="content" required rows="3" cols="40">${comment.content}</textarea>
                                    <br>
                                    <label for="secret">비밀댓글:</label>
                                    <input type="checkbox" name="secret" value="Y" <c:if test="${comment.secret == 'Y'}">checked</c:if>>
                                    <input type="hidden" name="_secret" value="N">
                                    <br>
                                    <button onclick="updateComment(${comment.id})">수정하기</button>
                                    <button onclick="hideEditForm(${comment.id})">취소</button>
                                </div>
                            </c:otherwise>
                        </c:choose>

                        <!-- 대댓글 목록 -->
                        <c:forEach var="reply" items="${comment.replies}">
                            <c:if test="${reply.secret != 'D'}">
                                <div id="reply-${reply.id}" class="reply">
                                    <c:choose>
                                        <c:when test="${reply.secret == 'Y'}">
                                            <c:if test="${reply.userId == authUser.userNo || authUser.role == 1 || comment.userId == authUser.userNo}">
                                                <div class="display-content">
                                                    <p>
                                                        <strong>${reply.username}</strong>: ${reply.content}
                                                    </p>
                                                    <c:if test="${reply.userId == authUser.userNo}">
                                                        <button onclick="showEditReplyForm(${reply.id})">수정</button>
                                                        <button onclick="deleteReply(${reply.id})">삭제</button>
                                                    </c:if>
                                                </div>
                                                <div class="edit-content" style="display:none;">
                                                    <textarea name="content" required rows="3" cols="40">${reply.content}</textarea>
                                                    <br>
                                                    <label for="secret">비밀댓글:</label>
                                                    <input type="checkbox" name="secret" value="Y" <c:if test="${reply.secret == 'Y'}">checked</c:if>>
                                                    <input type="hidden" name="_secret" value="N">
                                                    <br>
                                                    <button onclick="updateReply(${reply.id})">수정하기</button>
                                                    <button onclick="hideEditReplyForm(${reply.id})">취소</button>
                                                </div>
                                            </c:if>
                                            <c:if test="${reply.userId != authUser.userNo && authUser.role != 1 && comment.userId != authUser.userNo}">
                                                <div class="display-content">
                                                    <p>
                                                        <strong>${reply.username}</strong>: 비밀댓글입니다
                                                    </p>
                                                </div>
                                            </c:if>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="display-content">
                                                <p>
                                                    <strong>${reply.username}</strong>: ${reply.content}
                                                </p>
                                                <c:if test="${reply.userId == authUser.userNo}">
                                                    <button onclick="showEditReplyForm(${reply.id})">수정</button>
                                                    <button onclick="deleteReply(${reply.id})">삭제</button>
                                                </c:if>
                                            </div>
                                            <div class="edit-content" style="display:none;">
                                                <textarea name="content" required rows="3" cols="40">${reply.content}</textarea>
                                                <br>
                                                <label for="secret">비밀댓글:</label>
                                                <input type="checkbox" name="secret" value="Y" <c:if test="${reply.secret == 'Y'}">checked</c:if>>
                                                <input type="hidden" name="_secret" value="N">
                                                <br>
                                                <button onclick="updateReply(${reply.id})">수정하기</button>
                                                <button onclick="hideEditReplyForm(${reply.id})">취소</button>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </c:if>
                            <c:if test="${reply.secret == 'D'}">
                                <div id="reply-${reply.id}" class="deleted">
                                    <p>삭제된 댓글입니다</p>
                                </div>
                            </c:if>
                        </c:forEach>

                        <!-- 대댓글 입력 폼 -->
                        <c:if test="${not empty authUser}">
                            <div class="reply-form">
                                <form action="<c:url value='/board/noticelist/${notice.id}/addReply' />" method="post">
                                    <input type="hidden" name="commentId" value="${comment.id}">
                                    <label for="reply">댓글:</label>
                                    <textarea id="reply" name="reply" required rows="3" cols="40"></textarea>
                                    <br>
                                    <label for="secretReply">비밀댓글:</label>
                                    <input type="checkbox" id="secretReply" name="secretReply" value="Y">
                                    <input type="hidden" name="_secretReply" value="N">
                                    <br>
                                    <button type="submit">댓글달기</button>
                                </form>
                            </div>
                        </c:if>
                    </div>
                </c:if>
                <c:if test="${comment.secret == 'D'}">
                    <div id="comment-${comment.id}" class="deleted">
                        <p>삭제된 댓글입니다</p>
                    </div>
                </c:if>
            </c:forEach>
        </div>
        <a href="<c:url value='/board/noticelist' />" class="back-to-list">목록으로 돌아가기</a>
    </div>
</body>
</html>
