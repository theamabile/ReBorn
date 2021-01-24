window.addEventListener("load", () => {
	let form = document.querySelector(".form-group");

	//로그인 아이디 검사
	let id = form.querySelector(".loginId");
	const idReg = /^[A-za-z][A-za-z0-9]{5,13}$/;
	id.oninput = () => {

	}

	let pw = form.querySelector(".pw");
	let pwC = form.querySelector(".pw-conf ");
})