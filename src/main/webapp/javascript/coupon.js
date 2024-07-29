// 쿠폰 유효성 검사 함수
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

// 쿠폰 유효성 검사 전 폼 제출 체크 함수
function checkCouponBeforeSubmit(event) {
	const couponCheck = document.getElementById('couponCheck').value;
	if (couponCheck === "n") {
		alert('먼저 쿠폰을 등록해 주세요.');
		event.preventDefault(); // 폼 제출 막기
	}
}

// 이벤트 리스너 추가
document.getElementById('validate-coupon').addEventListener('click', validateCoupon);
document.getElementById('couponForm').addEventListener('submit', checkCouponBeforeSubmit);