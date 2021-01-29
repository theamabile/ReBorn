window.addEventListener("load", () => {
	let form = document.querySelector(".form-group");
	let subBtn = document.querySelector(".submit-button");

	let conf = [false, false, false];
	let [idConf, pwConf, phoneConf] = conf;

	//로그인 아이디 검사
	const idReg = /^[A-za-z][A-za-z0-9]{5,13}$/;
	let idInput = form.querySelector(".loginId");

	idInput.addEventListener("focusout", () => {
		let id = idInput.value;
		if (!idReg.test(id)) {
			idInput.style.border = '#ff9d9d 2px solid';
			alert("아이디는 영문자로 시작하는 6~14자 영문자 또는 숫자입니다.");
			return;
		}

		//아이디 중복확인
		let request = new XMLHttpRequest();
		request.onload = () => {
			let result = JSON.parse(request.responseText);
			if (result > 0) {
				idInput.style.border = '#ff9d9d 2px solid';
				idConf = false;
				alert("이미 사용중인 아이디 입니다.");
			}
			else {
				idConf = true;
				idInput.style.removeProperty("border");
			}
		}
		let url = "../check-id?id=" + id;
		request.open("Post", url, true);
		request.send();
	});

	//패스워드 확인 검사
	let pw = form.querySelector(".pw");
	let pwC = form.querySelector(".pw-conf ");
	subBtn.addEventListener("click", (e) => {
		if (pw.value != pwC.value || pw.value == "") {
			e.preventDefault();
			pwConf = false;
		}
		else
			pwConf = true;
	})


	//휴대폰 인증 구현
	let confBtn = form.querySelector(".confirm-btn");
	let phone = form.querySelector(".phone");
	let phoneConfirm = form.querySelector(".phoneConfirm");

	let confirmResult;
	confBtn.onclick = () => {

		let request = new XMLHttpRequest();
		request.onload = () => {
			confirmResult = JSON.parse(request.responseText);
			console.log(confirmResult);
		}
		let phoneNumber = phone.value;
		console.log(phone.value);
		let url = "../sendSMS?page=회원가입&phone=" + phoneNumber;

		request.open("Post", url, true);
		request.send();

	}

	//인증번호 확인
	phoneConfirm.addEventListener("focusout", () => {
		if (phoneConfirm.value != confirmResult || phoneConfirm.value == null) {
			console.log("dd");
			phoneConf = false;
		}
		else {
			phoneConf = true;
			subBtn.classList.remove("disabled");
			subBtn.classList.add("able");
		}
	})

	//버튼 비활성화
	subBtn.addEventListener('load', (e) => {
		if (!idConf || !pwConf || !phoneConf) {
			e.preventDefault();

			//경고창 띄우기
			let alertMS = "";
			if (!idConf) {
				alertMS = "아이디를 확인해주세요.";
			}
			else if (!pwConf) {
				alertMS = "동일한 비밀번호를 입력해주세요";
			}
			else if (!phoneConf) {
				alertMS = "인증번호를 확인해주세요.";
			}
			alert(alertMS);

		}
		else {
			subBtn.classList.remove("disabled");
			subBtn.classList.add("able");
		}
	})
})

//이메일 직접입력 
window.addEventListener("load", () => {
	let emailAddress = document.getElementsByName("emailAddress")[0];
	let customAddress = document.querySelector(".customAddress");

	emailAddress.addEventListener("change", () => {

		if (emailAddress.value == "none") {
			customAddress.removeAttribute("disabled");
			return;
		}
		customAddress.setAttribute("disabled", "disabled");
		customAddress.value = null;
	})
})