
window.addEventListener("load", function() {

    let btn = document.querySelector(".btn");
    let gage = document.querySelector(".gage");

    // 자바스트립트에서 초기화 하면 안되고
    // css에서 0%로 해야함. css가 링크되서 그런가 암튼 안먹음
    // let percent = 0;
    // gage.style.width = percent+"px";
    // console.log(gage.style.width);

    setTimeout(function(){
        let percent = 80;
        console.log(gage.style.width);
        gage.style.width = percent+"%";
    },500);

    // btn.addEventListener("click", function(){
    //     percent = 80;
    //     console.log(gage.style.width);
    //     gage.style.width = percent+"%";
    // });

});

window.addEventListener("load", function() {
		
	let container = document.querySelector(".main-container");
	let voteList = container.querySelector(".vote-list");  
	
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
			
			
			//voteList.insertAdjacentHTML("beforeend", itemHTML);
		}		
		
	});
	
});
