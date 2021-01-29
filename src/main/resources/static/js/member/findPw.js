window.addEventListener("load", () => {
	let section = document.querySelector(".find-pw");
	let form = section.querySelector(".form");

	let conf = [false, false];
	let [idConf, phoneConf] = conf;

	// radio버튼  변경
	let phoneType = document.getElementsByName("type")[0];
	let emailType = document.getElementsByName("type")[1];

	let phoneConfDiv = section.querySelectorAll(".confirm-type")[0];
	let emailConfDiv = section.querySelectorAll(".confirm-type")[1];

	phoneType.addEventListener("input", () => {
		phoneConfDiv.classList.remove("d-none");
		emailConfDiv.classList.add("d-none");
		console.log("phon")
	})

	emailType.addEventListener("input", () => {
		emailConfDiv.classList.remove("d-none");
		phoneConfDiv.classList.add("d-none");
		console.log("email")
	})


	//아이디 확인
	let idInput = section.querySelector(".id-input");
	let id;
	idInput.addEventListener("focusout", () => {

		console.log(idInput);
		id = idInput.value;
		let result = section.querySelector(".result");

		//데이터 확인
		fetch("./check-id?id=" + id, {
			method: 'post'
		})
			.then(response => response.json())
			.then(json => {
				console.log(json);
				if (json < 1) {
					idInput.style["margin-bottom"] = "5px";
					result.classList.remove("d-none");
					idConf = true;
				}
				else {
					idInput.style["margin-bottom"] = "22px";
					result.classList.add("d-none");
					idConf = false;
					console.log(json);
					form.action = "./reset-pw?loginId=" + id;
				}
			});
	})

	let singBtn = section.querySelector(".sing-btn");
	let confirmBtn = section.querySelector(".confirm-btn");

	// 이름, 휴대전화 인증
	let nameInput = section.querySelector(".name-input");
	let phoneInput = section.querySelector(".phone-input");
	let emailInput = section.querySelector(".email-input");
	let confirmInput = section.querySelector(".confirm-input");


	let confirmNum;
	let isValid = false;
	phoneInput.addEventListener("focusout", () => {

		//회원 정보확인
		fetch("./check-member/phone?loginId=" + id + "&name=" + nameInput.value + "&phone=" + phoneInput.value, {
			method: 'post'
		})
			.then(response => response.json())
			.then(json => {
				if (json > 0) {
					isValid = true;
					console.log("result  : " + isValid);
				}
				else {
					isValid = false;
				}
			})
	});

	// 휴대폰 인증
	confirmBtn.addEventListener("click", (e) => {
				e.stopPropagation();
		if (!isValid) {
			alert("등록된 회원정보가 아닙니다.");
			return;
		}
		else {
			fetch("./sendSMS?page=패스워드찾기&phone=" + phoneInput.value, {
				method: 'post'
			})
				.then(response => response.text())
				.then(text => {
					confirmNum = text;
					console.log(confirmNum);
				})
		}
	});

	
		//인증번호 확인
		confirmInput.addEventListener("input", () => {
			if (confirmInput.value != confirmNum || confirmInput.value == null) {
				phoneConf = false;
				singBtn.classList.remove("able");
				singBtn.classList.add("disabled");
				console.log("인증번호가 다릅");
			}
			else {
				phoneConf = true;
				singBtn.classList.remove("disabled");
				singBtn.classList.add("able");
			}
		})

	//버튼 비활성화
	singBtn.addEventListener('load', (e) => {
		if (phoneConf)
			return;
		e.preventDefault();
		alert("인증번호를 확인해주세요.");
	})
});
