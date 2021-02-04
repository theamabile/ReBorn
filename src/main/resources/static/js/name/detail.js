
window.addEventListener("load", (e)=>{
	
	let vote = document.querySelector(".vote");
	let form = vote.querySelector("form");
	let voteBtn = vote.querySelector(".vote-btn");
	let revoteBtn = vote.querySelector(".revote-btn");
	
	/*let choiceSumInput = vote.querySelector(".choiceSum");
	.vote-progress .vote-progress-bar
	let */
	
	
	if(voteBtn != null) {
		voteBtn.addEventListener("click", (e)=>{
			let radios = vote.querySelector("input[type='radio']:checked");
		
			if(radios == null) {
				let modalBox =  new ModalBox({
					content: "투표할 이름을 선택해주세요",
					contentPadding: false,
					okBtnText: " 확인",
					removeOnBackgroundClick: false
				});
				
				modalBox
				.then(
					resolve => {
						if(resolve.result != "ok")
							return;
						
						console.log("알가쓰~~");
						return;
					}
				);	
			}
			
			form.submit();
		});
	}


	if(revoteBtn != null) {
		revoteBtn.addEventListener("click", (e)=>{
			let radios = vote.querySelector("input[type='radio']:checked");
			let desertionNo = document.querySelector(".desertionNo");
			location.href = `/name/${desertionNo.innerText}/revote`;
			
		});
	}	

	
});