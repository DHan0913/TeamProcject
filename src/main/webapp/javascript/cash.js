document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('cashRequestForm').addEventListener('submit', function(event) {
        var requestId = document.getElementById('requestId').value;
        var email = document.getElementById('email').value;
        var amount = document.getElementById('amount').value;

        if (requestId !== email) {
            event.preventDefault(); // 폼 제출 막기
            document.getElementById('error-message').innerText = '요청 ID를 다시 입력해주세요';
            return;
        }

        if (amount <= 0) {
            event.preventDefault(); // 폼 제출 막기
            document.getElementById('error-message').innerText = '충전 금액은 0보다 커야 합니다';
            return;
        }
        
        if (!confirm('충전하시겠습니까?')) {
            event.preventDefault(); // 폼 제출 막기
        }
    });
});
