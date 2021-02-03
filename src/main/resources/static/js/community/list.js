window.addEventListener("load", (e)=>{
	const pager = document.querySelector(".pager");
	const listCommon = document.querySelector(".list-common");
	const listData = listCommon.querySelector(".list-data");
	const searchForm = document.querySelector(".search-form");
	const searchButton = searchForm.querySelector(".btn-search");
	const searchWindow = searchForm.querySelector(".search-window");
	const searchSelect = searchForm.querySelector(".search-select");
	//const selectBox = document.querySelector(".select-view");

	
	

	
	searchButton.addEventListener("click", (e)=>{
		e.preventDefault();
		console.log(e.target.innerText);
	
		let page = e.target.innerText;
		let query = searchWindow.value;
		let field = searchSelect.value;
		//let view = selectBox.value;
		
		
		fetch(`/api/community/list?p=${page}&f=${field}&q=${query}`)
		.then(response => response.json())
		.then((json) => {
			console.log(json);
			listData.innerHTML = "";
			
			//console.log(json[1].title);
		for(let n of json){
			let listArticle = `
							<li class="list-article mt20">
	                            <a class="list-link" href="${n.id}">
	                                <div class="post-content has-image">
	                                    <strong class="subject bold">${n.title}</strong>
	                                    <div class="content mt10">${n.content}
	                                    </div>    
	                                    <span class="meta pt15">
	                                        <span class="name-txt">댓글 </span>
	                                        <span class="num-txt dot bold">${n.comment} </span>
	                                        <span class="name-txt">좋아요 </span>
	                                        <span class="num-txt dot bold">${n.like}</span>
	                                        <span class="hit">조회수</span>
	                                        <span class="num-txt bold dot">${n.hitCnt}</span>
	                                        <span class="ico">by</span>
	                                        <span class="num-txt bold dot">${n.nickname}</span>
	                                        <span class="hit">작성일</span>
	                                        <span class="num-txt bold" >
	                                        	<fmt:formatDate value="${n.regDate}" pattern="yyyy-MM-dd" />
	                                        </span>
	                                    </span>
	                                </div>
	                                <div class="post-image">
	                                    <img src="/uploadFiles/board/2021/${n.id}/${n.files}" alt="">
	                                </div>
	                            </a>
	                        </li>
						`;
					listData.insertAdjacentHTML("beforeEnd", listArticle);
			}// for end
		}); //then end
	}); //search end	
	
	pager.addEventListener("click", (e)=>{
		e.preventDefault();
		console.log(e.target.innerText);
	
		let page = e.target.innerText;
		let query = searchWindow.value;
		let field = "title";
		//let view = selectBox.value;
		
		
		fetch(`/api/community/list?p=${page}&f=${field}&q=${query}`)
		.then(response => response.json())
		.then((json) => {
			listData.innerHTML = "";
			
			//console.log(json[1].title);
		for(let n of json){
			let listArticle = `
							<li class="list-article mt20">
	                            <a class="list-link" href="${n.id}">
	                                <div class="post-content has-image">
	                                    <strong class="subject bold">${n.title}</strong>
	                                    <div class="content mt10">${n.content}
	                                    </div>    
	                                    <span class="meta pt15">
	                                        <span class="name-txt">댓글 </span>
	                                        <span class="num-txt dot bold">${n.comment} </span>
	                                        <span class="name-txt">좋아요 </span>
	                                        <span class="num-txt dot bold">${n.like}</span>
	                                        <span class="hit">조회수</span>
	                                        <span class="num-txt bold dot">${n.hitCnt}</span>
	                                        <span class="ico">by</span>
	                                        <span class="num-txt bold dot">${n.nickname}</span>
	                                        <span class="hit">작성일</span>
	                                        <span class="num-txt bold" >
	                                        	<fmt:formatDate value="${n.regDate}" pattern="yyyy-MM-dd" />
	                                        </span>
	                                    </span>
	                                </div>
	                                <div class="post-image">
	                                    <img src="/images/community/dog.png" alt="">
	                                </div>
	                            </a>
	                        </li>
						`;
					listData.insertAdjacentHTML("beforeEnd", listArticle);
			} //for end		
		}); // then end
	}); //pager end 
});// window end
