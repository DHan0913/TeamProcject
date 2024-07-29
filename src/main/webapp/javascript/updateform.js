document.getElementById('update-form').addEventListener('submit', function(event) {
    if (!confirm('수정 하시겠습니까?')) {
        event.preventDefault(); // 폼 제출 막기
    }
});