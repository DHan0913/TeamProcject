function validateCoupon(event) {
    const obj = event.target; // button#validate-coupon
    const target = obj.getAttribute("data-target"); // API 호출 위치
    const frm = obj.form; // 폼

    const couponCode = frm.couponCode.value.trim();

    if (couponCode.length === 0) {
        alert("쿠폰 코드를 입력하세요!");
        return;
    }

    fetch(`${target}?couponCode=${couponCode}`)
    .then(response => response.json())
    .then(json => {
        if (json.result === 'success') {
            if (json.exists) {
                alert('유효한 쿠폰 코드입니다.');
                frm.couponCheck.value = "y";
            } else {
                alert('유효하지 않은 쿠폰 코드입니다.');
                frm.couponCheck.value = "n";
            }
        } else {
            alert('쿠폰 코드 확인 중 오류가 발생했습니다.');
            throw new Error(json.message);
        }
    })
    .catch(error => console.error(error));
}

// 이벤트 리스너 추가
document.getElementById('validate-coupon').addEventListener('click', validateCoupon);