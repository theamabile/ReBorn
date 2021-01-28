window.addEventListener("load", () => {
	let section = document.querySelector(".find-id");
	let form = document.getElementsByTagName("form")[0];
	let email = section.querySelector(".email");
	let name = section.querySelector(".name-input");
	let result = section.querySelector(".result");
	let btn = section.querySelector(".button");

	console.log(form);
	name.addEventListener("input", () => {

		fetch("./check-member?email=" + email.value + "&name=" + name.value, {
			method: 'post'
		})
			.then(response => response.json())
			.then(json => {
				//		console.log(json);
				if (json.loginId == null) {
					name.style["margin-bottom"] = "5px";
					result.classList.remove("d-none");
					btn.classList.remove("able");
					btn.classList.add("disabled");
				}
				else {
					name.style["margin-bottom"] = "22px";
					result.classList.add("d-none");
					btn.classList.remove("disabled");
					btn.classList.add("able");
					console.log(json.loginId);
					form.action = "./find-id-result?loginId=" + json.loginId;
				}

			});
	});

	btn.addEventListener("click", (e) => {
		if (btn.classList.contains("disabled")) {
			e.preventDefault();
		}
	});

});
