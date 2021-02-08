//프로필 이미지 미리보기
function previewImg(f) {

	let file = f.files;

	if (!/\.(gif|jpg|jpeg|png)$/i.test(file[0].name)) {
		alert("이미지 파일을 등록해주세요");
		f.outerHTML = f.outerHTML;
	}
	else {

		let reader = new FileReader();
		reader.onload = function(e) {
			document.getElementsByTagName('img')[0].src = e.target.result;
		}
		reader.readAsDataURL(file[0]);

	}
}
window.addEventListener("load", () => {


	let section = document.querySelector(".img-update");
	let form = document.getElementsByTagName("form")[0];
	let fileBtn = section.querySelector(".file-btn");
	let submitBtn = section.querySelector(".submit-btn");
	let file = section.querySelector("input[type=file]");

	fileBtn.onclick = function() {
		let event = new MouseEvent("click", {
			'view': window,
			'bubbles': true,
			'cancelable': true
		})
		file.dispatchEvent(event);


	};
	console.log(form)

	submitBtn.onclick = function(e) {

		const formData = new FormData();
		let f = file.files[0];
		formData.append("file", f);
		console.log(f)

		let id = section.querySelector(".id");



		//이미지 변경 적용
		fetch("./img-update", {
			method: 'post',
			body: formData
		})
			.then(response => response.text())
			.then(result => {
				// info 페이지 이미지 변경
				let img = opener.document.querySelector(".profile-img img");
				img.src = "/upload/member/profile/" + id.value + "/" + f.name;

				//alert(img.src);
				self.close();
				console.log(result);
			});


	}

})