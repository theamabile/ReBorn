window.addEventListener("load", () => {
	const section = document.querySelector(".reset-pw");
	const idInput = section.querySelector(".id");
	const pwInput = section.querySelector(".pw-input");
	const confirmInput = section.querySelector(".pw-confirm");
	const result = section.querySelector(".result");

	const btn = section.querySelector(".sing-btn");
	const pwReg = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{1,50}).{8,50}$/;
	let valid = false;
	
	//session값 꺼내오기
	idInput.value=sessionStorage.getItem("resetPwdId" );
	
	//패스워드 형식 검사
	pwInput.addEventListener("focusout", () => {
		if (!pwReg.test(pwInput.value)) {
			idInput.style["margin-bottom"] = "5px";
			result.classList.remove("d-none");
			valid = true;
		}
		else {
			idInput.style["margin-bottom"] = "22px";
			result.classList.add("d-none");
			valid = false;
		}
	})

	// 버튼 활성화
	confirmInput.addEventListener("input", () => {
		console.log(valid);
		if (valid || confirmInput.value == "") {
			btn.classList.remove("able");
			btn.classList.add("disabled");
		}
		else {
			btn.classList.remove("disabled");
			btn.classList.add("able");
		}
	})
	
	//버튼 이벤트 
	btn.addEventListener("click", (e) => {
		if (pwInput.value == confirmInput.value){
			//session값 지워주기
			sessionStorage.removeItem("resetPwdId" );
			return;
		}
		e.preventDefault();
		console.log(confirmInput);
		new ModalBox({content: "비밀번호를 확인해주세요.",	cancelBtnHide: true});
	})
})