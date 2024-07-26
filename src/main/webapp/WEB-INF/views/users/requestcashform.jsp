<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page import="himedia.dvd.repositories.vo.UserVo" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>캐시 충전 요청</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/requestcash.css' />">
</head>
<body>
    <div class="container">
        <h2>캐시 충전 요청</h2>
        <c:if test="${not empty message}">
            <div class="message">${message}</div>
        </c:if>
        <c:if test="${not empty errorMessage}">
            <div class="error-message">${errorMessage}</div>
        </c:if>
        <form id="cashRequestForm" action="javascript:requestPay();" method="post">
            <div>
                <label for="requestId">요청 ID:</label>
                <input type="text" id="requestId" name="requestId" required>
            </div>
            <div>
                <label for="amount">충전 금액:</label>
                <input type="number" id="amount" name="amount" required>
            </div>
            <input type="hidden" id="userNo" name="userNo" value="<%= ((UserVo) session.getAttribute("authUser")).getUserNo() %>">
            <input type="hidden" id="email" name="email" value="<%= ((UserVo) session.getAttribute("authUser")).getEmail() %>">
            <br>
            <div>
                <button type="submit">충전 요청</button>
                
            </div>
        </form>
        <div id="error-message" style="color: red;"></div>
    </div>

    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
    <script type="text/javascript">
        function requestPay() {
            var IMP = window.IMP; // 생략가능
            IMP.init('imp01021557'); // "가맹점 식별코드"를 사용하세요.

            var requestId = $('#requestId').val();
            var amount = $('#amount').val();
            var userNo = $('#userNo').val();
            var email = $('#email').val();
            var contextPath = '${pageContext.request.contextPath}';

            // 디버그용 로그
            console.log('requestPay 실행됨');
            console.log('requestId:', requestId);
            console.log('amount:', amount);
            console.log('userNo:', userNo);
            console.log('email:', email);

            IMP.request_pay({
                pg: 'kakaopay',
                pay_method: 'card',
                merchant_uid: 'merchant_' + new Date().getTime(),
                name: '캐시 충전',
                amount: amount,
                buyer_email: email,
                buyer_name: userNo,
                buyer_tel: '010-1234-5678',
                buyer_addr: '서울특별시 강남구 삼성동',
                buyer_postcode: '123-456'
            }, function(rsp) {
                // 결제 성공 또는 실패 여부에 관계없이 서버에 요청을 보냅니다.
                $.ajax({
                    type: 'POST',
                    url: contextPath + '/users/requestcash',
                    data: {
                        requestId: requestId,
                        amount: amount
                    },
                    success: function(response) {
                        // 서버 처리 후 성공 시 홈으로 리디렉션
                        if (rsp.success) {
                            window.location.href = contextPath + "/";
                        } else {
                            alert('결제에 실패하였습니다. 에러 내용: ' + rsp.error_msg);
                            window.location.href = contextPath + "/";
                        }
                    },
                    error: function(xhr, status, error) {
                        // 요청 실패 시 에러 메시지 표시
                        alert('서버 요청에 실패하였습니다. 에러 내용: ' + error);
                        window.location.href = contextPath + "/";
                    }
                });
            });
        }
    </script>
</body>
</html>
