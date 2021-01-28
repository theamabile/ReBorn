window.addEventListener("load", () => {
	const container = document.querySelector(".container");
	const btnNav = container.querySelector(".button-nav");
	const loginBtn = btnNav.querySelector(".sign-in");

	let id = container.querySelector(".id");
	let password = container.querySelector(".password");
	const idReg = /^[A-za-z][A-za-z0-9]{5,13}$/;
	const pwReg = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{1,50}).{8,50}$/;

	id.oninput = () => {
		// 아이디 검사
		let span = `<span class ="alert">아이디는 영문자로 시작하는 6~14자 영문자 또는 숫자입니다.</span>`;
		if (!idReg.test(id.value) && id.nextElementSibling.tagName != "SPAN") {

			id.insertAdjacentHTML("afterend", span);
			// console.log(id.style["margin-bottom"])
			id.style["margin-bottom"] = "4px";
			return;
		}
		else if (idReg.test(id.value) && id.nextElementSibling.tagName == "SPAN") {
	
			id.nextElementSibling.remove();
			id.style["margin-bottom"] = "20px";
		}
	};
	
	// 비밀번호 검사
	password.oninput = () => {
		if (!pwReg.test(password.value) && password.nextElementSibling.tagName != "SPAN") {
			console.log()
			let span = `<span class ="alert">숫자, 영문, 특수문자를 조합한 8자리 이상의 문자를 입력하세요.</span>`;
			password.insertAdjacentHTML("afterend", span);
			password.style["margin-bottom"] = "4px";
			return;
		}
		else if (pwReg.test(password.value) && password.nextElementSibling.tagName == "SPAN") {
			console.log(password.nextElementSibling)
			password.nextElementSibling.remove();
			password.style["margin-bottom"] = "20px";
		}
	}

	//로그인버튼
	loginBtn.addEventListener("click", (e) => {
		if (!idReg.test(id.value) || !pwReg.test(password.value)) {
			e.preventDefault();
			alert("아이디와 비밀번호를 확인해주세요.");
			return;
		}
	});
});

//카카오 로그인
window.addEventListener("load", () => {
	Kakao.init('bda1963015c3359c76adbb17d9d5e489');

	// 카카오 로그인 버튼 생성
	Kakao.Auth.createLoginButton({
		container: '#kakao-login-btn',
		success: function(authObj) {
			alert(JSON.stringify(authObj));
		},
		fail: function(err) {
			alert(JSON.stringify(err));
		}
	});
})
