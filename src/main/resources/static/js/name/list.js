
window.addEventListener("load", function() {
		
	let container = document.querySelector(".main-container");
	let voteList = container.querySelector(".vote-list");  
	
	
	let pager = container.querySelector(".pager>ul");
	let pagerPrev = container.querySelector(".btn-prev");
	let pagerNext = container.querySelector(".btn-next");

	let page = 1; 
	let pageCount = 1;
	let offset = (page-1)%5;
	let startNum = page - offset;
	
	pagerPrev.addEventListener("click", pageScopeBtnHandler);
	pagerNext.addEventListener("click", pageScopeBtnHandler);
	
	
	load();
	loadKind();
	
	
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
		fetch('/api/name/list')
		.then(response => {
			return response.json();
		})
		.then(json=>{
			
			console.log(json);
			
			let {pageCount, list} = json;
					
			let btn = document.querySelector(".btn");
			let gage = document.querySelector(".gage");
			let rank = document.querySelector(".rank");
		
			// 기간 프로그래스바					
			let today = new Date();
			let startDate = new Date(json.list[0].voteStartDate);
			let endDate = new Date(json.list[0].voteEndDate);
			
			let period = endDate.getDate() - startDate.getDate();
			let rest = endDate.getDate() - today.getDate();		// Date가 일자, Day는 요일
			let percent = (rest/period).toFixed(2) * 100;
			console.log(`기간 : ${percent}`);		
			
			
			for(let v of list) {
				let itemHTML = `<div class="item">
							        <div class="percent">
							            <div class="gage"></div>
							        </div>
							        	
							        <button class="btn">
							        	<img>	        	
							            <div class="vote-info">
								        	<div class="regdate">
									        	<span class="font-xs">
									        		${v.voteStartDate}~
									        		${v.voteEndDate}
									        	</span>
									            <img>
								        	</div>
							            	<table class="rank font-l">
												<tbody>
												</tbody>
							            	</table>
							            	
							            	<div class="count">
							            		<div class="count-item">
							            			<span class="font-m">총 투표수</span>
							            			<span class="font-xl">${v.choiceSum }</span>
							            		</div>
							            		<div class="count-item">
							            			<span class="font-m">후보 수</span>
							            			<span class="font-xl">${v.nameCnt }</span>
							            		</div>
							            		<i class="fas fa-vote-yea font-xl"></i>
				
							            	</div>
							            </div>
							        </button>
							    </div>`;
				
				voteList.insertAdjacentHTML("beforeend", itemHTML);
				
				//let item = document.createElement(itemHTML);
				let item = document.createElement(itemHTML);
				let rank = item.querySelector("tbody");
				
				let index = 0;
				for(let n of v.rankNameList) {
					let rankHTML = `<tr>
			            			<th class="bold"><i class="fas fa-medal font-m"></i>${index+1}위</th>
			            			<td>${n.name}</td>
			            		</tr>`;
					rank.insertAdjacentHTML("beforeend", rankHTML);
				}
				
				voteList.insertAdjacentHTML("beforeend", itemHTML);
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
	


	
});





