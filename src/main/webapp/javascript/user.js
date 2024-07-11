function checkEmail(event) {
	//	이벤트 발생 객체 
	const obj = event.target;	//	button#check-email
	const target = obj.getAttribute("data-target");	//	API 호출 위치
	const frm = obj.form;	//	폼 

	const email = frm.email.value.trim();

	if (email.length === 0) {
		alert("이메일을 입력하세요!");
		return;
	}
   
	//	fetch
	console.log(`${target}?email=${email}`);
	fetch(`${target}?email=${email}`)
	.then(response => {;
		return response.json();
	})
	.then(json => {
		console.log(json);
		//	중복 여부
		if (json.exists) {
			alert('이미 사용중인 이메일입니다.')
			throw new Error('중복된 이메일입니다.');
		} else {
			alert('사용 가능한 이메일입니다.');
			frm.emailCheck.value = "y";
		}
	})
	.catch(error => console.error(error));
}


window.addEventListener("load", event => {
	document.getElementById("check-email")
		.addEventListener("click", checkEmail);
		
	});	
