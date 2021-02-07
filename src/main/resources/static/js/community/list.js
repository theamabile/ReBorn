window.addEventListener("load", (e)=>{
	let pager = document.querySelector(".pager");
	let pageBtn = pager.querySelector(".btn-center");
	let listCommon = document.querySelector(".list-common");
	let listData = listCommon.querySelector(".list-data");
	let searchForm = document.querySelector(".search-form");
	
	let searchButton = searchForm.querySelector(".btn-search");
	let listLink = document.querySelector(".list-link");
	
	//검색(select)	
	let selectSearch = searchForm.querySelector(".search-select");
	//검색어
	let searchWindow = searchForm.querySelector(".search-window");	
	//카테고리(select)
	let selectCategory = document.querySelector(".select-category");
	//보기(select)	
	let selectView = document.querySelector(".select-view");

	let writeCommon = document.querySelector(".write-common");

    //페이지<이전|다음>
	let pagePrev = pager.querySelector(".btn-prev");
	let pageNext = pager.querySelector(".btn-next");
	let pageList = pager.querySelector(".btn-center");
	
	
	let page = 1;
	let pageCount = 1;
	let offSet = (page-1)%5;
	let startNum = page-offSet;
	let view = 10;
	let current = "";
		
	load();
	
	
	/*selectView.addEventListener("change", changeHandler);
	selectCategory.addEventListener("change", changeHandler);
	pagePrev.addEventListener("click", pageScopeHandler);
	pageNext.addEventListener("click", pageScopeHandler);*/
	
	
		
	
	/*function pageScopeHandler(e){
		e.preventDefault();
		e.stoPropagation();
		
		let pageMove = 1;
		
		if(e.target.classLis.contains('btn-prev')){
			if(startNum == 1){
				alert('이전 페이지가 없습니다.');
				return;
			}
			pageMove = startNum-5;
		} else {
			if(startNum+5 > pageCount){
				alert('다음 페이지가 없습니다.')
			}
			pageMove= startNum+5;			
		}
		page = movePage;
		load();		
	}*/
	
	
	
	pageList.addEventListener("click", (e)=>{
		e.preventDefault();
		if(e.target.innerText == page)
			return;
			
		page = e.target.innerText;
		//pageList.innerHTML == "";		
		load();	
		
		console.log("클릭한 페이지: "+e.target.innerText);	
	});
	
	
	function changeHandler(e){
		page = 1;
		load();
		console.log("변경됩니다.");
	}		
	
	searchButton.addEventListener("click", (e)=>{
		e.preventDefault();
		console.log("버튼 클릭");
		let searchField = selectSearch.value;
		let searchQuery = searchWindow.value;
		
		console.log("분류"+searchField+" 검색어:"+ searchQuery)
		load();
		
	});
	
	
	function load() {
		let searchField = selectSearch.value; //검색select
		let searchQuery = searchWindow.value; //검색어
		let category = selectCategory.value;  //카테고리select
		//let view = parse.int(selectView.value);		  //보기select	
		
		console.log(`url : /api/community/list?p=${page}&v=${view}&f=${searchField}
					&q=${searchQuery}&c=${category}`);
		
		fetch(`/api/community/list?p=${page}&v=${view}&f=${searchField}
				&q=${searchQuery}&&c=${category}`)  
		.then(response=>{
			return response.json();
		})
		.then(json=>{
			listData.innerHTML = "";
						
			let {pageCount, list, count} = json;
			
			console.log("페이지수:  "+pageCount);
			console.log("게시물의 수:  "+count);
			console.log("현재페이지:  "+page);
			console.log(list);			
			
			for(let n of list) {
				console.log(n.regDate);
										
				if((n.files == null) || (n.files == "")){		
					let boardList = `<li class="list-article mt20">
	                              <a class="list-link" href="${n.id}">
	                                <div class="post-content has-image">
	                                  <strong class="subject bold word-color1">${n.title}</strong>
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
		                             </a>
		                          </li>
							      `;				
						listData.insertAdjacentHTML("beforeEnd", boardList);						
					} 
					else{					
	   					let boardList = `<li class="list-article mt20">
	                              <a class="list-link" href="${n.id}">
	                                <div class="post-content has-image">
	                                  <strong class="subject bold word-color1">${n.title}</strong>
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
					                    <img src="/upload/community/2021/${n.id}/${n.files.replace(/\,/g,'')}" />
					                  </div>
		                             </a>
		                          </li>`;			
						listData.insertAdjacentHTML("beforeEnd", boardList);
					}
			}// for end
			writeCommon.innerHTML = "";
			pageCount = Math.ceil(count/view);			
			let itemLine = `
						<div><span class="text-red bold">${page}</span> / ${pageCount} pages</div>
	                    <form action="">
	                    	<a class="community-button bold" type="button" href="/community/reg" >글쓰기 </a>
	                    </form>`;		
			writeCommon.insertAdjacentHTML("beforeEnd", itemLine);
							
			offset = (page-1)%5;
			startNum = page - offset;	
			
			console.log("총 페이지수: "+pageCount+"  현재페이지:"+ page+"  startNum: "+startNum);
			pageList.innerHTML = "";
			for(let i=0;i<5; i++){				
				if(startNum+i == page){
				current = "current";
				}
				if(startNum+i > page){
				current = "";
				}
				if(startNum+i > pageCount){
					break;			
				}
				let itemPage = `
						<li class="${current}">
						  <a class="bold" href="?p=${i+startNum}&f=${searchField}&v=${view}&q=${searchQuery}&c=${category}">${i+startNum}</a>
						</li>`;
				pageList.insertAdjacentHTML("beforeend", itemPage);
				console.log("====="+ startNum+"  "+ page);
			}// for end
	  })//then end		
		
		
	}//load() end
	
	/*
	
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
			listData.innerHTML = "";			
			let {count, list} = json;
			console.log(count);
			console.log(list);
						
		for(let n of list){
				let file = n.files;
				let fileName = file.replace(/\,/g,'');
			let listArticle = `
							<li class="list-article mt20">
	                            <a class="list-link" href="${n.id}">
	                                <div class="post-content has-image">
	                                    <strong class="subject bold word-color1">${n.title}</strong>
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
	                                    <img src="/upload/community/2021/${n.id}/${fileName}" alt="">
	                                </div>
	                            </a>
	                        </li>
						`;
					listData.insertAdjacentHTML("beforeEnd", listArticle);
			}// for end
		}); //then end
	}); //search end	
	
	pageBtn.addEventListener("click", (e)=>{
		e.preventDefault();
		console.log(e.target.innerText);
		
		
	
		let page = e.target.innerText;
		let query = searchWindow.value;
		let field = "title";
		//let view = selectBox.value;
		
		fetch(`/api/community/list?p=${page}&f=${field}&q=${query}`)
		.then(response => response.json())
		.then((json) => {
			//console.log(json);
			listData.innerHTML = "";			
			let {count, list} = json;
			console.log(count);
			console.log(list);
						
			//console.log(json[1].title);
		for(let n of list){
				let file = n.files;
				let fileName = file.replace(/\,/g,'');
				console.log("파일명:"+f);
				//let f = file.substr(0, file.length -1);
			let listArticle = `
							<li class="list-article mt20">
	                            <a class="list-link" href="${n.id}">
	                                <div class="post-content has-image">
	                                    <strong class="subject bold word-color1">${n.title}</strong>
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
	                                    <img src="/upload/community/2021/${n.id}/${fileName}" alt="">
	                                </div>
	                            </a>
	                        </li>
						`;
					listData.insertAdjacentHTML("beforeEnd", listArticle);
			} //for end		
		}); // then end
	}); //pager end 
	
	*/
});// window end
