function requestPay() {
    var IMP = window.IMP; // 생략가능
    IMP.init('imp01021557'); // "가맹점 식별코드"를 사용하세요.
    
    var requestId = $('#requestId').val();
    var amount = $('#amount').val();
    var userNo = $('#userNo').val();
    var email = $('#email').val();
    
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
    }, function (rsp) {
        if (rsp.success) {
            // 결제 성공 시 백엔드로 결제 정보 전송
            $.post('/users/requestcash', {
                requestId: requestId,
                amount: amount
            }).done(function(response) {
                alert('결제가 완료되었습니다. 메인 페이지로 이동합니다.');
                window.location.href = "/";
            }).fail(function() {
                alert('결제 처리 중 오류가 발생했습니다. 다시 시도해 주세요.');
            });
        } else {
            // 결제 실패 시 로직
            var msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;
            alert(msg);
        }
    });
}
