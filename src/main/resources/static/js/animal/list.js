
window.addEventListener("load", e=>{
	
	let container = document.querySelector(".main-container");
	let form = document.querySelector(".main-container > form");
	let upkindSelectBox = container.querySelector(".upkind");
	let kindSelectBox = container.querySelector(".kind");
		
	let animalList = container.querySelector(".animal-box");
	let pager = container.querySelector(".pager>ul");

	let list = [];		// 리스트 데이터가 담겨질 변수

	let page = 1;
	let upkind = "";
	let kind = "";
	/*
	@RequestParam(name="bgnde", required=false)	 Date startDate, 	//유기 시작 날짜
			@RequestParam(name="endde", required=false)	 Date endDate, 		//유기 종료 날짜
			@RequestParam(name="neuter", required=false) String neuter)
	
	 */
	
	
	let offset = (page-1)%5;
	let startNum = page - offset;
	
	load();
	
	pager.addEventListener("click", (e)=>{
		e.preventDefault();
		
		page = e.target.innerText;
		upkind = upkindSelectBox.value;
		kind = kindSelectBox.value;
		
		offset = (page-1)%5;
		startNum = page - offset;
		
		load();
				
	});
	
	upkindSelectBox.addEventListener("change", e=>{
		upkind = e.target.value;
		
		if(upkind == '') {		// 전체 선택			
			kindSelectBox.innerHTML = "";
			let optionHTML = `<option value="">선택 없음</option>`;
			kindSelectBox.insertAdjacentHTML('beforeend', optionHTML);	
			return;	
		}
		
		
		fetch(`/api/animal/kind?upkind=${upkind}`)
		.then(response=>{
			return response.json();
		}) 
		.then(json=>{
			console.log(json);
			
			let list = json;
			kindSelectBox.innerHTML = "";
			
			for(let k of list) {
				let optionHTML = `<option value="${k.code}">${k.name}</option>`;
				kindSelectBox.insertAdjacentHTML('beforeend', optionHTML);				
			}
			
		});
		
	});
	
	
	animalList.addEventListener("click", (e)=>{
		e.preventDefault();
	
	});
	
	function itemClickHandler(e) {
		e.preventDefault();
		e.stopPropagation();
		
		// 어떤 자식 엘리먼트가 선택 되든 매핑 된 버튼(currentTarget)을 사용할거임
		console.log("itemClickHandler");
		console.log("target : "+e.target);
		console.log("currentTarget : "+e.currentTarget);
		
		
		let button = e.currentTarget;
		let desertionNo = button.querySelector(".desertionNo");		

		location.href = `/animal/${desertionNo.value}`;
		
		
	/*	
		let idInput = button.querySelector(".id");  //클릭된 버튼의 id 찾기(hidden 태그 찾기)
		let dataInput = button.querySelector(".data");  //클릭된 버튼의 id 찾기(hidden 태그 찾기)
		let clickIndex = parseInt(idInput.value);
		
		let selectedInput = document.createElement("input");
		selectedInput.setAttribute("type", "hidden");
		selectedInput.setAttribute("name", "selectedIndex");
		selectedInput.setAttribute("value", clickIndex);
		
		form.insertAdjacentElement('beforeend', selectedInput);
		console.log("id : "+idInput.value);
		console.log(dataInput.value);
		
		
		
		form.submit();	*/
		
	}
		
	function load() {
		console.log(`url : /api/animal/list?p=${page}&upkind=${upkind}&kind=${kind}`);
		fetch(`/api/animal/list?p=${page}&upkind=${upkind}&kind=${kind}`)
		.then(response=>{
			return response.json();
		}) 
		.then(json=>{
			console.log(json);
			
			list = json.list;
			animalList.innerHTML = "";
			
			let index = 0;
			for(let a of list) {
				
				let sexCd = "미상";
				if(a.sexCd == 'M')
					sexCd = "수컷";
				else if(a.sexCd == 'F')
					sexCd = "암컷";
				
				// form data로 던지기
				let url = "/upload";
				
				// 온클릭 매핑때문에 생성 후 전송
				let itembox = document.createElement("button");
				itembox.classList.add("animal-item");
				itembox.addEventListener("click", itemClickHandler);
				
				
				let itemHTML = `<div>
									<img src="${a.popfile}" />
								</div>
								<div class="title-box">
									<span>${a.noticeNo}</span>
									<div></div>
								</div>
								<div class="main-info-box">
									<span>${a.happenPlace}</span>
									<span>${a.colorCd}</span>
								</div>
								<div class="sub-info-box">
									<span>${sexCd}</span>
									<span>${a.kindCd}</span>
									<span>${a.happenDt}</span>
								</div>
								
								<input type="hidden" class="desertionNo" name="desertionNo" value="${a.desertionNo}">`;
				//<input type="hidden" class="data" name="data" value='${JSON.stringify(a)}'> 
				
				
				itembox.insertAdjacentHTML('beforeend', itemHTML);
				animalList.insertAdjacentElement('beforeend', itembox);
				index++;
			}
			
			
			// 페이지 변경
			let offset = (page-1)%5;
			let newStartNum = page - offset;
			
			//if(newStartNum != startNum) {
				pager.innerHTML = "";
				startNum = newStartNum;
									
				for(let i=0; i<5 ; i++) {
					let pageHTML = `<li class="">
										<a class="bold " >${startNum+i}</a>
									</li>`;
								
					pager.insertAdjacentHTML('beforeend', pageHTML);
				}
			//}

		});
	}
	
	
	
	// 축종 값 변경 되면 로드하기	
	//upkindSelectBox.addEventListener("change", upkindChangeHandler);

	
});

function upkindChangeHandler(e) {
	
	let selectedOption = e.target.value;
	console.log("upkind changed : "+selectedOption.value);
}

