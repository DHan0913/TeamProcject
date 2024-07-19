function validateCoupon(event) {
    event.preventDefault();
    const frm = document.getElementById("couponForm");
	
    const couponCode = frm.querySelector("[name='couponCode']").value.trim();
	const expiryYn = frm.querySelector("[name='expiryYn']").value.trim();

    if (couponCode.length === 0) {
        alert("쿠폰 코드를 입력하세요!");
        return;
    }

    const requestData = {
        couponCode: couponCode
    };

    const target = frm.getAttribute("action"); // Get action URL from form

    console.log(`${target}`, requestData);
    fetch(target, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(json => {
        console.log(json);
        if (json.errors) {
            alert('쿠폰 검증 중 오류가 발생했습니다.');
            console.error(json.errors);
        } else if (json.isValid) {
            alert('유효한 쿠폰입니다.');
        } else {
            alert('유효하지 않은 쿠폰입니다.');
        }
    })
    .catch(error => console.error(error));
}

window.addEventListener("load", event => {
    document.getElementById("validate-coupon")
    
        .addEventListener("click", validateCoupon);
});
