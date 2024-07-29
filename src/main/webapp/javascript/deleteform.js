document.addEventListener('DOMContentLoaded', function() {
    document.querySelector('form').addEventListener('submit', function(event) {
        if (!confirm('탈퇴 하시겠습니까?')) {
            event.preventDefault(); // 폼 제출 막기
        }
    });
});
