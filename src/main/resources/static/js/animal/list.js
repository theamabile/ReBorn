
window.addEventListener("load", e=>{
	
	let container = document.querySelector(".main-container");
	let form = document.querySelector(".main-container > form");
	let upkindSelectBox = container.querySelector(".upkind");
	let kindSelectBox = container.querySelector(".kind");	
	let bgndeInput = container.querySelector(".bgnde");
	let enddeInput = container.querySelector(".endde");
	let neuterInput = container.querySelector(".neuterYn");
		
	let animalList = container.querySelector(".animal-box");
	let pager = container.querySelector(".pager>ul");
	let pagerPrev = container.querySelector(".btn-prev");
	let pagerNext = container.querySelector(".btn-next");

	let page = 1; 
	let pageCount = 1;
	let offset = (page-1)%5;
	let startNum = page - offset;
	
	
	pagerPrev.addEventListener("click", pageScopeBtnHandler);
	pagerNext.addEventListener("click", pageScopeBtnHandler);
	bgndeInput.addEventListener("change", fieldChangeHandler);
	enddeInput.addEventListener("change", fieldChangeHandler);
	neuterInput.addEventListener("change", fieldChangeHandler);
	kindSelectBox.addEventListener("change", fieldChangeHandler);
	
	
	
	load();
	loadKind();
	
	
	upkindSelectBox.addEventListener("change", e=>{
		loadKind()
		.then(
			result=>{
				page = 1;
				load();
			});
	});
		
	function fieldChangeHandler(e){
		page = 1;
		load();
	};

	function itemClickHandler(e) {
		e.preventDefault();
		e.stopPropagation();

		let button = e.currentTarget;
		let desertionNo = button.querySelector(".desertionNo");		

		location.href = `/animal/${desertionNo.value}`;		
	}
		
	pager.addEventListener("click", (e)=>{
		e.preventDefault();		
		if( e.target.innerText == page)
			return;
	
		page = e.target.innerText;
				
		load();
	});
	
		
	function pageScopeBtnHandler(e) {
		e.preventDefault();
		e.stopPropagation();
		
		let movePage = 1;
		
		if(true == e.target.classList.contains('btn-prev')) {
			if(startNum == 1) {
				alert(`이전 페이지가 없습니다.`);		// 모달로 바꾸기
				return;
			}	
			movePage = startNum-5;
		} else {
			if(startNum+5 > pageCount){
				alert(`다음 페이지가 없습니다.`);		// 모달로 바꾸기
				return;
			}
			movePage = startNum+5;
		}
		
		page = movePage;
		load();			
	}
	
	function load() {
		let bgnde = bgndeInput.value;
		let endde = enddeInput.value;
		let neuter = neuterInput.value;
		let upKind = upkindSelectBox.value;
		let kind = kindSelectBox.value;
		
		
		console.log(`url : /api/animal/list?p=${page}&upkind=${upKind}&kind=${kind}
		&bgnde=${bgnde}&endde=${endde}&neuter=${neuter}`);

		fetch(`/api/animal/list?p=${page}&upkind=${upKind}&kind=${kind}&bgnde=${bgnde}&endde=${endde}&neuter=${neuter}`)
		.then(response=>{
			return response.json();
		}) 
		.then(json=>{
			console.log(json);
			
			animalList.innerHTML = "";
			let count = json.count;
			let list = json.list;
			
			//window.scrollTo( 0, 0 );
			//console.log("scrollY : "+window.scrollY);
			
			if(json.count <= 0) {			
				animalList.insertAdjacentHTML('beforeend', `<span class="bold m-auto gray fs-1">항목이 존재하지 않습니다</span>`);
				pageCount = 1;
			} else {
				for(let a of list) {				
					let sexCd = "미상";
					if(a.sexCd == 'M')
						sexCd = "수컷";
					else if(a.sexCd == 'F')
						sexCd = "암컷";
					
					// 온클릭 매핑때문에 생성 후 전송
					let itembox = document.createElement("button");
					itembox.classList.add("animal-item");
					itembox.addEventListener("click", itemClickHandler);
					
					let nameHTML = `<div class="blank">
										<i class="fas fa-quote-left"></i>
										<i class="fas fa-quote-right"></i>
									</div>`;
					
					//let nameHTML = `<span>${a.noticeNo}</span>`;
					
					if(a.name != undefined) {
						nameHTML = `<span>${a.name}</span>`;
					} 
					
					/*
					${a.noticeNo}
					<i class="fas fa-quote-left"></i>*/
					let itemHTML = `<div>
										<img src="${a.popfile}" />
									</div>
									<div class="title-box">
										${nameHTML}
										<div></div>
									</div>
									<div class="main-info-box">
										<span>${a.noticeNo}</span>
										<span>${a.happenPlace}</span>
									</div>
									<div class="sub-info-box">
										<span>${sexCd}</span>
										<span>${a.colorCd}</span>
										<span>${a.happenDt}</span>
									</div>
									<input type="hidden" class="desertionNo"" value="${a.desertionNo}">
									`;
					
					
					itembox.insertAdjacentHTML('beforeend', itemHTML);
					animalList.insertAdjacentElement('beforeend', itembox);
				}		
				
				pageCount = Math.ceil(count/9);		
			}
			
			offset = (page-1)%5;
			startNum = page - offset;
				
			pager.innerHTML = "";
			console.log("pageCount : "+pageCount);
										
			for(let i=0; i<5 ; i++) {
				let current = "";
				if(startNum+i == page) {
					current = "current";
				} 
				if(startNum+i > pageCount ) {
					break;	
				}
				
				let pageHTML = `<li class="${current}">
									<a class="bold " >${startNum+i}</a>
								</li>`;						
				pager.insertAdjacentHTML('beforeend', pageHTML);
			}
			
		});
	}
	
	
	function loadKind() {
		
		// 프로미스 한번 써보기
		return new Promise( (resolve, reject)=>{
			
			let upKind = upkindSelectBox.value;
			
			if(upKind == '') {		// 전체 선택			
				kindSelectBox.innerHTML = "";
				let optionHTML = `<option value="">선택 없음</option>`;
				kindSelectBox.insertAdjacentHTML('beforeend', optionHTML);	
				resolve();		
				return;
			}
			
			
			fetch(`/api/animal/kind?upkind=${upKind}`)
			.then(response=>{
				return response.json();
			}) 
			.then(json=>{
				console.log(json);
				
				let list = json;
				kindSelectBox.innerHTML = "";				
				
				kind= "";		// 축종이 바뀌니까 품종은 일단 선택된 값 없음.
				kindSelectBox.insertAdjacentHTML('beforeend', `<option value="" selected>전체</option>`);
							
				for(let k of list) {
					let optionHTML = `<option value="${k.cd}">${k.name}</option>`;
					kindSelectBox.insertAdjacentHTML('beforeend', optionHTML);				
				}
				
				resolve();				
			});					
			
		});
		
	}
	
	
	// 축종 값 변경 되면 로드하기	
	//upkindSelectBox.addEventListener("change", upkindChangeHandler);

	
});

function upkindChangeHandler(e) {
	
	let selectedOption = e.target.value;
	console.log("upkind changed : "+selectedOption.value);
}

