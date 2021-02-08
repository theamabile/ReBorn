# ReBorn

작성자 email: badagogi@gmail.com


##  목차
### 1. 들어가며
1) 소개
2) 주요기능
3) 기간
4) 개발환경
5) 맡은 역할 및 기능
6) 기능구현 영상(추후촬영하여 첨부예정)



### 2. 개발후기

### 3. 데이터베이스 설계
1) 개념적 설계
2) 물리적 설계

### 4. Front-End(JavaScript ES6) 코드구성

### 5. Back-End(Spring Boot 4.9.0) 코드구성
---

## 1. 들어가며</br>
#### 1. 소개</br>
   이번 프로젝트의 주제는 Reborn 이라는 이름으로 시작되었습니다.
   작년 한 해동안 전국의 보호소에 입소된 유기 동물의 수는 약 13만 5791마리 라고 합니다. 그 가운데 재입양률은 26.4% 이며, 반대로 자연사 및 안락사되는 
   동물들은 전체의 46.4% 로 거의 절반에 가까운 숫자입니다. 그래서 이번 프로젝트에서는 사용자들이 보호소에 입소된 유기동물들에게 이름을 짓는 '행동'을
   통해서 좀더 많은 관심을 갖게 하여, 그 결과로 유기동물들의 재입양률을 높이기 위한 목적으로 시작되었습니다.
 </br>
</br>

#### 2. 기간
 + 2021년 1월 11일 - 2월 10일(오전~낮 시간까지는 수업, 주로 오후부터 밤 사이에 프로젝트를 진행)
 </br>
</br>

#### 3. 주요기능 </br>
   로그인 & 로그아웃, 사용자들이 투표를 통해 동물들에게 이름을 지어주기 </br>
   전국의 보호소 검색, 실종신고, 사용자 게시판</br>
   </br>
</br>

#### 4. 개발환경
   + 프론트 엔드 - HTML/CSS, JAVASCRIPT ES6
   + 백엔드 - JAVA, SPRING BOOT, Maven, MyBatis
   + DBMS - MySQL
   </br>
</br>

#### 5. 맡은 역할 및 기능</br>
  프로젝트에서는 5명의 팀원으로 구성되었으며 각 구성원은 프론트 or 백엔드가 아니라, 페이지 및 기능 단위로 역할을 나누었습니다. </br>
  그 가운데에서 제가 맡은 기능은  가장 기본적인 기능이라고 할 수 있는 사용자 게시판의 CRUD 즉, Create, Read, Update, Delete 를 구현한 게시판입니다. </br>
</br>

-  조회 페이지</br>
  글을 조회 및 조건(제목, 작성자)에 따른 검색이 가능합니다.</br>
  글을 10개씩, 15개씩, 30개씩 정렬하여 볼 수 있습니다.</br>
  글을 카테고리별로 조건검색 할 수 있습니다.</br>
  글에 사진이 있다면 리스트에서 썸네일이 전시됩니다.</br>
  작성자, 작성일, 조회수, 좋아요, 댓글 수를 확인할 수 있습니다.</br>
  
-  상세 페이지</br>
  1개의 글을 클릭하여 상세 페이지로 이동하면 조회수가 증가 됩니다.</br>
  자신이 게시한 글일 경우 수정, 삭제가 가능합니다.</br>
  댓글 작성, 수정, 삭제가 가능합니다.</br>
  
-  수정 페이지</br>
  글을 수정합니다.
- 등록 페이지</br>
  글을 등록합니다.  </br>
  
- 추가적으로 구현된 기능 </br>
  게시판의 List 페이지를 JS Es6의 Fetch API를 사용하여 비동기 방식으로 구현하였고, </br>
  또한 '좋아요', 댓글 수정, 삭제를 비동기 방식으로 구현하였습니다.</br>
---

### 2. 개발후기</br>
</br>

1달이라는 시간이 길다면 긴 시간이지만, 수업과 프로젝트를 병행하며 진행하기에는 그리 여유롭지 않았습니다.
더군다나 입문자인 저에게는 모든 것이 새로웠기 때문에, 작성된 코드를 한 줄 한 줄 이해하는 것이 쉽지는 않았습니다.</br>
많은 에러와 벽을 마주할 때마다 학습했던 예제를 찾아보면서 내용을 곱씹었고, 공식문서와 구글, 유튜브 등을 통해 답을 찾아나갔습니다. 또한 이 프로젝트를 함께 했던
팀원들도 많은 도움을 주었습니다.</br>
프로젝트에서 가장 어려웠던 부분은 CRUD를 완성해 놓은 후에 데이터를 비동기로 처리하는 방식이었습니다.
저의 짧은 식견으로는 현업에서 가장 많이 사용되는 방식이라고 알고 있습니다. 그렇기 때문에 제가 자주 헤쳐본 길은 아니었지만,
손을 놓을 수 없었기 때문에 내가 만든 것들을 다시한번 업그레이드 시켜 보자는 생각으로 비동기 처리를 진행하였습니다.
list 페이지의 모든 작업들 로드, 페이지 이동, 검색, 정렬 그리고 상세 페이지에서 댓글 수정과 삭제, 좋아요 등등의 기능을 비동기 방식으로 구현하게 되었습니다.
쉽지 않았지만, 제 프로젝트에 직접 적용해 보았기 때문에 재미도 있었고, 뿌듯함도 있었습니다.
코드에 미숙한 점이 많지만, 격려해 주시면 감사하겠습니다.
</br></br></br>

---
### 3. 데이터베이스 설계
1) 개념적 설계(파일 이미지로 첨부합니다.)


2) 물리적 설계(파일 이미지로 첨부합니다.)

</br>
</br>
---
이하의 코드는 제가 담당하고, 구현한 내용만 게시하였습니다.
### 4. Front-End  
  1) JavaScript
  + list.js
  
  ```
  window.addEventListener("load", (e)=>{
	let pager = document.querySelector(".pager");
	let listCommon = document.querySelector(".list-common");
	let listData = listCommon.querySelector(".list-data");
	let searchForm = document.querySelector(".search-form");
	
	let searchButton = searchForm.querySelector(".btn-search");
		
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
	let category = "";
	let searchField = "";
	let searchQuery = "";
	let current = "";		
	load();	
	
	/*selectView.addEventListener("change", changeHandler);
	selectCategory.addEventListener("change", changeHandler);*/
	pagePrev.addEventListener("click", pageScopeHandler);
	pageNext.addEventListener("click", pageScopeHandler);
	
	selectCategory.addEventListener("change", changeSelectHandler);	
	selectView.addEventListener("change", changeSelectHandler);
	
	function changeSelectHandler(e){
		page = 1;
		load();
		console.log("변경됩니다.");
	}
	
	
	function pageScopeHandler(e){
		e.preventDefault();
		e.stopPropagation();
		
		let pageMove = 1;
		//console.log("이전다음: page "+ page +"  pageCount "+pageCount+"  startNum "+startNum)
		if(e.target.classList.contains('btn-prev')){
			if(startNum == 1){
				alert('이전 페이지가 없습니다.');
				return;
			}
			pageMove = startNum-5;
		} else {
			if(startNum+5 > pageCount){
				alert('다음 페이지가 없습니다.')
				return;
			}
			pageMove= startNum+5;			
		}
		page = pageMove;		
		load();
		console.log("[이전|다음] 총 페이지수(pageCount): "+pageCount+"  현재페이지(page):"+ page+"  startNum: "+startNum);		
	}
		
	//페이지 번호를 클릭할 때
	pageList.addEventListener("click", (e)=>{
		e.preventDefault();
		if(e.target.innerText == page)
			return;
			
		page = e.target.innerText;
		//pageList.innerHTML == "";		
		load();	
		
		console.log("클릭한 페이지: "+e.target.innerText);	
	});	
	
	//제목|작성자 검색할 때
	searchButton.addEventListener("click", (e)=>{
		e.preventDefault();
		console.log("=====검색시작====");
		searchField = selectSearch.value;
		searchQuery = searchWindow.value;
		
		load();
		console.log("분류:"+searchField+" 검색어:"+ searchQuery);
		console.log("총 페이지수(pageCount): "+pageCount+"  현재페이지(page):"+ page+"  startNum: "+startNum+"    게시물의수(count): "+count);
		
	});
	
	
	function load() {
		searchField = selectSearch.value; //검색select
		searchQuery = searchWindow.value; //검색어
		category = selectCategory.value;  //카테고리select
		view = selectView.value;		  //보기select	
		
		console.log(`url : /api/community/list?p=${page}&v=${view}&f=${searchField}
					&q=${searchQuery}&c=${category}`);
		
		fetch(`/api/community/list?p=${page}&v=${view}&f=${searchField}
				&q=${searchQuery}&c=${category}`)  
		.then(response=>{
			return response.json();
		})
		.then(json=>{
			listData.innerHTML = "";
			
			pageCount = json.pageCount;
			count = json.count;
			let list = json.list;	
			console.log("=============================");
			console.log(json);					
				
			/*console.log("페이지수:  "+pageCount);
			console.log("게시물의 수:  "+count);
			console.log("현재페이지:  "+page);
			console.log(list);			*/
			
			for(let n of list) {
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
	                                    <span class="ico">작성자</span>
	                                    <span class="num-txt bold dot">${n.nickname}</span>
	                                    <span class="regdate">작성일</span>
	                                    <span class="num-txt bold" >
	                                      	${MMddHHmm(new Date(n.regDate.slice(0,19)))}							
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
	                                    <span class="ico">작성자</span>
	                                    <span class="num-txt bold dot">${n.nickname}</span>
	                                    <span class="hit">작성일</span>
	                                    <span class="num-txt bold" >
	                                      	${MMddHHmm(new Date(n.regDate.slice(0,19)))}
	                                    </span>
                                       </span>
		                              </div>
		  							  <div class="post-image">
					                    <img src="/upload/community/2021/${n.id}/${n.files.replace(/\,/g,'')}" />
					                  </div>
		                             </a>
		                          </li>`;			
						listData.insertAdjacentHTML("beforeEnd", boardList);
				}//if end
			}// for end
			
			writeCommon.innerHTML = "";
			pageCount = Math.ceil(count/parseInt(view));			
			let itemLine = `
						<div><span class="text-red bold">${page}</span> / ${pageCount} pages</div>
	                    <form action="">
	                    	<a class="community-button bold" type="button" href="/community/reg" >글쓰기 </a>
	                    </form>`;		
			writeCommon.insertAdjacentHTML("beforeEnd", itemLine);
							
			offset = (page-1)%5;
			startNum = page - offset;	
			
			pageList.innerHTML = "";
			for(let i=0;i<5; i++){				
				if(startNum+i == page){
					current = "current";
				} else{
					current = "";
				}
				
				/*if(startNum+i != page){
					current = "";
				}*/
				if(startNum+i > pageCount){
					break;			
				}
				/*if(pageCount <= 0){
					pageCount = 1;
				}*/
				let itemPage = `
						<li class="${current}">
						  <a class="bold" href="?p=${i+startNum}&f=${searchField}&v=${view}&q=${searchQuery}&c=${category}">${i+startNum}</a>
						</li>`;
				pageList.insertAdjacentHTML("beforeend", itemPage);
				console.log("총 페이지수(pageCount): "+pageCount+"  현재페이지(page):"+ page+"  startNum: "+startNum+"    게시물의수(count): "+count);	
			}// for end
			
	  });//then end		
		
	}//load() end
});// window end
```

+ reg.js
```
import CSS from "../modules/CSS.js";

window.addEventListener("load", (e)=>{

	const fileBox = document.querySelector(".file-box");
	const uploadButton = fileBox.querySelector(".upload-button");
	const uploadFile = fileBox.querySelector(".upload-file"); 
	const addButton = document.querySelector(".add-button");
	
	const dropBox = document.querySelector(".drop-box");
	const fileName = document.querySelector(".file-name");
	
	/*파일첨부버튼*/
	uploadButton.addEventListener("click", (e)=>{
		console.log("클");
		let event = new MouseEvent("click", {
			'view': window,
			'bubbles':true,
			'cancelable':true
		});
		uploadFile.dispatchEvent(event);
	});
	uploadFile.addEventListener("change", (e)=>{
		
		console.log(uploadFile.value);
		fileName.innerText = uploadFile.value;
		
	})
		
	/*파일첨부추가버튼*/
	addButton.addEventListener("click", (e) =>{
		console.log("더하기")
		let item = `
						<span class="upload-button">업로드</span>
			            <input type="file" class="upload-file" name="file" />
					`;
		fileBox.insertAdjacentHTML("beforeEnd", item);			
		
	});
	
	
	/* 파일 드래그 앤 드롭 */
	dropBox.addEventListener("drop", (e)=>{
		//파일 이름을 jsp에 출력
		let dropFileName = document.querySelector(".drop-file-name");
		
		e.preventDefault();
		e.stopPropagation();
		let valid = e.dataTransfer 
					 && e.dataTransfer.types
					 && e.dataTransfer.types.indexOf("Files") >= 0;
		
		if(!valid){
			alert("파일형식이 아닙니다.");		
			return ;
		}
		
		let url = "/community/upload";
		
		let formData = new FormData();
		/*for(let n of e.dataTransfer.files)
			formData.append("file", n)*/
		formData.append("file", e.dataTransfer.files[0]);	
		
		let request = new XMLHttpRequest();
		
		
		//전송과정에 대한 처리
		request.upload.addEventListener("progress", (e)=>{
			console.log(`total is: ${e.total}, loaded: ${e.loaded} `);			
			
			if(e.lengthComputable){			
				dropBox.innerText = "진행도: "+ Math.round(e.loaded*100/e.total)+"%";
				dropBox.style.background = "blue";			
				dropBox.style.width = Math.round(e.loaded*100/e.total)+ "%";
			} else
				dropBox.innerText = "전송크기를 계산할 수 없습니다.";			
		});
		
		//전송완료시
		request.addEventListener("load", (e)=>{
			console.log(e.target.responseText);
			CSS.set(dropBox, {
				background : "#f1f1f1",				
			})
			dropBox.innerText = "업로드할 파일을 드롭하세요.";
			
			
		});
		
		//에러발생시
		request.addEventListener("error", (reason)=>{
			console.log(reason);
				
		});
		
		
	
			
				
		console.log(e.dataTransfer.files.length);
		console.log(e.dataTransfer.files[0].name);
		dropFileName.innerText = e.dataTransfer.files[0].name+ "이 업로드 되었습니다.";
		
		for(let n of e.dataTransfer.files){
			console.log("for of문 파일이름출력"+ n.name);
		}
		
		CSS.set(dropBox, {
			background: "#32a088",
			
		});
		dropBox.innerText = "파일을 업로드 합니다.";
		
		
		request.open("POST", url);
		request.send(formData);   //전달할 것:파일
		
	});// drag&drop 완료
	
	//droptBox에 드래그오버 될 경우.
	dropBox.addEventListener("dragover", (e)=>{
		e.preventDefault();
		e.stopPropagation();
		
		let valid = e.dataTransfer 
					 && e.dataTransfer.types
					 && e.dataTransfer.types.indexOf("Files") >= 0;
		
		let message = valid ? "드롭하세요":"유효한 파일이 아닙니다.";
		
		if(message == "드롭하세요"){
				CSS.set(dropBox, {
				background : "#32a088"
			});
		} else {
				CSS.set(dropBox, {
				background : "red"
			});
		}
		
							
		dropBox.innerText = message;						
				
		/*console.log("오버"+e.dataTransfer.type);*/
	});
	
	
	dropBox.addEventListener("dragenter", (e)=>{
		e.preventDefault();
		e.stopPropagation();
		
		/*CSS.set(dropBox, {
			background : "pink"
		});*/
		/*console.log("endter:"+ e.dataTransfer);*/
		
	});
	
	
	
	dropBox.addEventListener("dragleave", (e)=>{
		e.preventDefault();
		e.stopPropagation();
		console.log("아웃");
		CSS.set(dropBox, {
			background : "#f1f1f1",
			
		})
		dropBox.innerText = "업로드 할 파일을 드롭하세요.";
		
	})
	
});
```

+ detail.js
```
window.addEventListener("load", (e)=>{
	const likeBtn = document.querySelector(".like-btn");
	const boardId = document.querySelector(".board-id");
	const likeCount = document.querySelector(".like-count");		
	const commentList = document.querySelector(".comment-list");//댓글수정버튼을 감싼 부모.
	
	

	
	
	console.log(boardId);
	let boardNumber = boardId.value;  //jsp에서 hidden으로 숨긴 boardId 값
	
	
	//let win;
	//좋아요 버튼
	likeBtn.addEventListener("click", (e)=>{
						
		fetch(`/community/${boardNumber}/like`, {
			method : "post"
		})
		.then(function(response){

			return response.json();	
		})		
		.then(json => {
			console.log(json);
			if(json.likes == "insert"){
				likeBtn.style.color = "green";
				likeCount.innerText = parseInt(likeCount.innerText) + 1;
			}
			else{
				likeBtn.style.color = "black";
				likeCount.innerText = parseInt(likeCount.innerText) - 1;
			}
		})		
	});
		//e.target          //이벤트발생
		//e.currentTarget   //이벤트를 달아준 객체를 반환
	//댓글 수정
	commentList.addEventListener("click", (e)=>{
		
		
		if(!e.target.classList.contains('comment-edit'))
			return;
		console.log(e.target.innerText);
		console.log(e.currentTarget);
		
		let commentViewBox = e.target.closest('div.comment-view-box'); // (1)	
	    
	    if (!commentViewBox) return; // (2)
		
		if (!commentList.contains(commentViewBox)) return; 
		    
		let cId = commentViewBox.querySelector("input.comment-id");	
		    console.log("댓글 번호" + cId.value);
		    console.log("게시글 번호" + boardNumber);
		let cContent = commentViewBox.querySelector("div.comment-content");
		let message = prompt('message');
			
			fetch(`/api/community/${boardNumber}/commentEdit`, {
				method: 'post',
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded'
				},
				body: `content=${message}&commentId=${cId.value}`
			})
			.then(function(response){
				
				return response.json();
			})
			.then(json => {
				console.log(cContent.innerText = message);
				cContent.innerText = message;
			})	
	});
	
});	
```

### 5. Back-End

#### 1) Spring 설정파일
- application.properties
```
spring.mvc.view.prefix=/WEB-INF/view/
spring.mvc.view.suffix=.jsp

# MySQL Setting
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://hi.namoolab.com:9898/reborn?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC
spring.datasource.username=reborn
spring.datasource.password=11111

# MyBatis Mapper
# mybatis.mapper-locations=classpath:com/reborn/web/dao/mybatis/mapper/*.xml
mybatis.mapper-locations=classpath:com/reborn/web/dao/mybatis/mapper/*/*.xml

# Upload limit
spring.servlet.multipart.max-file-size=512MB
spring.servlet.multipart.max-request-size=1024MB
```

- tiles.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE tiles-definitions PUBLIC
       "-//Apache Software Foundation//DTD Tiles Configuration 3.0//EN"
       "http://tiles.apache.org/dtds/tiles-config_3_0.dtd">

<tiles-definitions>          

	<!--  profile Img -->
	<definition name="home.mypage.imgInput" template="/WEB-INF/view/inc/empty.jsp">
		    <put-attribute name="title" value="Tiles tutorial homepage" />
        <put-attribute name="main" value="/WEB-INF/view/mypage/imgInput.jsp"/>  
    </definition>
    
 	<!-- 사용자 화면 레이아웃 -->
	<definition name="home.*.*" template="/WEB-INF/view/inc/layout.jsp">
	    <put-attribute name="title" value="Tiles tutorial homepage" />
	    <put-attribute name="header" value="/WEB-INF/view/inc/header.jsp" />
	    <put-attribute name="main" value="/WEB-INF/view/{1}/{2}.jsp" />
	    <put-attribute name="footer" value="/WEB-INF/view/inc/footer.jsp" />
	  </definition>
	  
	  <!-- 메인페이지 , 등 -->
	  <definition name="home.*" template="/WEB-INF/view/inc/layout.jsp">
	    <put-attribute name="title" value="Tiles tutorial homepage" />
	    <put-attribute name="header" value="/WEB-INF/view/inc/header.jsp" />
	    <put-attribute name="main" value="/WEB-INF/view/{1}.jsp" />
	    <put-attribute name="footer" value="/WEB-INF/view/inc/footer.jsp" />
	  </definition>
```

- TilesConfig.java
```
package com.reborn.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.SimpleSpringPreparerFactory;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration      /* 설정 자동 인식 */
public class TilesConfig {
	// @bean : 스프링이 관리하는 객체를 관리하는 방이 있음 tiles를 반환
	// 이 큰 방을 ioc container라고 부름. 여기에 @Bean이 붙은 아이들이 반환하는 애들을 다 큰 방에 담아둠.
	// 스프링 부팅 될 때 @Bean이라고 표기된걸 다 호출해서 방에 담음.
	// ioc 컨테이너에 담기면 스프링이 사라지지 않게 관리해줌
   @Bean               
   public TilesConfigurer tilesConfigurer() {
      TilesConfigurer tilesConfigurer = new TilesConfigurer();
      tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/tiles.xml"}); // tiles를 어디다가 두었니
      tilesConfigurer.setCheckRefresh(true);
      //ViewPreparer에서 Autowired가 가능하게 하는 설정
      tilesConfigurer.setPreparerFactoryClass(SimpleSpringPreparerFactory.class);
      return tilesConfigurer;
   }
   
   
   // TilesViewResolver : 실질적으로 tiles 일을함
   // 얘가 TilesConfigurer를 읽어서 사용함
   @Bean
   public TilesViewResolver tilesViewResolver() {
      TilesViewResolver viewResolver = new TilesViewResolver();  // 뷰를 찾아준다
      viewResolver.setViewClass(TilesView.class);
      viewResolver.setOrder(1);
      
      return viewResolver;
   }
   
}
```

+ pom.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
   <modelVersion>4.0.0</modelVersion>
   <parent>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-parent</artifactId>
      <version>2.4.1</version>
      <relativePath/> <!-- lookup parent from repository -->
   </parent>
   <groupId>com.reborn</groupId>
   <artifactId>web</artifactId>
   <version>1.0</version>
   <name>ReBornProject</name>
   <description>Newlecture-web2 Project</description>

   <properties>
      <java.version>1.8</java.version>
   </properties>

   <dependencies>
      <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-web</artifactId>
      </dependency>
      
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
		</dependency>
		<dependency>
			<groupId>org.apache.tiles</groupId>
			<artifactId>tiles-jsp</artifactId>
			<version>3.0.8</version>
		</dependency>
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
		</dependency>
		<dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>2.1.4</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jdbc</artifactId>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
		</dependency>
		<dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-websocket</artifactId>
		</dependency>
		
		<dependency>
		    <groupId>com.googlecode.json-simple</groupId>
		    <artifactId>json-simple</artifactId>
		    <version>1.1.1</version>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-mail</artifactId>
		</dependency>
		<dependency>
        	<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>

		<dependency>
		    <groupId>org.json</groupId>
		    <artifactId>json</artifactId>
		    <version>20201115</version>
		</dependency>
	</dependencies>
	
   <build>
      <plugins>
         <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
         </plugin>
      </plugins>
   </build>

</project>
```



#### 2) View - Jsp
타일즈로 인한 layout, Header, Fotter는 게시하지 않았습니다.
- list.jsp
```
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="/js/community/list.js"></script>
<link href="/css/community/list.css" type="text/css" rel="stylesheet" />
<link href="/css/community/reset.css" type="text/css" rel="stylesheet" />


<c:set var ="page" value="${param.p}" />
<c:if test = "${empty param.p}">
	<c:set var = "page" value="1" />
</c:if>	

<c:set var="offset" value="${(page-1)%5}"> </c:set>
<c:set var="startNum" value="${page-offset}"> </c:set>
	<section class="main-container">
            <!-- <div class="major-subject mt20">
                <h1 class="major-subject-text bold">커뮤니케이션</h1>
            </div> -->
            <div class="wrapper">
                <div class="align-wrap">
                    <div class="align mt60">
                        <h2 class="hidden">게시판 정렬폼</h2>
                        <form class="category-align">
                            <fieldset>
                                <legend class="hidden">카테고리 정렬 필드</legend>
                                <select class="select-category select-box" name="c" >
                                    <option value="">카테고리</option>
                                    <option value="question">질문</option>
                                    <option value="post">입양후기</option>
                                    <option value="dog">우리집 멍이</option>
                                    <option value="cat">우리집 냥이</option>
                                </select>
                            </fieldset>
                        </form>
                        <form class="view-align">
                            <fieldset>
                                <legend class="hidden">View 정렬 필드</legend>
                                <select class="select-view select-box" name="v" >  
                                    <option value="10">10개씩</option>
                                    <option value="15">15개씩</option>
                                    <option value="30">30개씩</option>                            
                                </select>
                            </fieldset>
                        </form>
                    </div>
                </div>    
                <div class="list-common mt30">
                    <h2 class="hidden">목록</h2>
                    <ul class="list-data">
                    
                    </ul>
                </div>
                <div class="write-common pt15">                
                  
                </div>
            </div> <!-- wrapper -->
            <div class="pager-common mt30">
                <div class="pager">                
                    <div class="prev ">
                    	<a class="btn btn-prev">이전</a>
	                    
                    </div>
                    
                    <ul class="btn-center">
	                   </ul>
                    
                    <div class="next">
                    	<a class="btn btn-next">다음</a>
                    	
                    </div>
                    
                </div>
                <div class="search-form mt20"> 
                    <h2 class="hidden">커뮤니케이션 검색폼</h2>    
                    <form action="">
                        <fieldset>
                            <legend class="hidden">검색필드</legend>
                            <label class="hidden">검색분류</label>
                            <select class="search-select" name="f">
                                <option value="title">제목</option>
                                <option value="nickname">작성자</option>
                            </select>
                            <label class="hidden">검색어</label>
                            <input class="search-window"  type="text" name="q" value="${param.q}"/>
                            <input class="btn btn-search" type="submit" value="검색" />
                        </fieldset>
                    </form>
                </div>
            </div>
        </section>
  ```
  
  
  - detail.jsp
  ```
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<link href="/css/community/detail.css" type="text/css" rel="stylesheet" />
<link href="/css/community/community-style.css" type="text/css" rel="stylesheet" />
	<section class="main-container">
             <div class="wrapper" >
                <section class="article-header mt60">
                    <span class="category">category: <span>${b.category}</span></span> 
                    <span class="title bold word-color1 mt10">${b.title}</span>
                    <div class="write-info mt10">
                        <span class="writer-id bar mr10">by ${b.nickname }</span> 
                        <span class="regdate bar mr10"> 
                        	<fmt:formatDate value="${b.regDate}" pattern="yyyy.MM.dd[E] a hh:mm:ss"/>                        	
                        </span>
                        <c:if test="${b.memberId == sessionScope.id}">
                        	<a class="edit-btn bar mr10" href="${b.id}/edit">수정</a>
                        	<a class="delete-btn" href="${b.id}/del">삭제</a>
                        </c:if>      
                        
                    </div>
                    게시글의 멤버: ${b.memberId} </br>
                    게시글의  id: ${b.id}
                </section>
                <!-- 파일업로드 -->
                <c:if test="${not empty b.files}">
	      			<c:forEach var="imageItems" items="${fn:split(b.files, ',')}" varStatus="status" >
	                <div class="file-image">
	                 	<img class="mr10" src="/upload/community/2021/${b.id}/${imageItems}" alt="상품이미지" />
	                </div>                
	                </c:forEach>
                </c:if>

                <section class="article-content mt50">
                    ${b.content}
                                       
                </section>

                <div class="reaction-info mt50">
                    <span>댓글 <span class="comment-count bold">${commentCount}</span></span> 
                    <span>
	                    <input class="like-btn" type="button" value="좋아요" /> 
	                    <span class="like-img"></span>
	                    <span class="like-count bold">${likeCount}</span>
                    </span>
                </div>
                				
                <!-- 댓글 리스트 -->
                <div class="comment-list">
	                <c:forEach items="${comment}" var="c" >
		                <div class="comment-view-box padding10 mt5">
		                    <div class="comment-info mt10">
		                        <span class="comment-nickname word-color1 dot" >${c.nickname}</span>
		                        <span class="comment-regdate dot">
		                        	<fmt:formatDate value="${c.regDate}" pattern="yyyy.MM.dd[E] a hh:mm:ss"/>
		                        </span>
		                        
		                        <!-- memberId 조건에 따라 수정버튼 show -->
		                        <c:if test="${sessionScope.id == c.memberId}">
			                        <form method="post" action="${b.id}/comment/edit">
			                        	<span class="comment-edit dot">수정</span>
			                        </form>
		                        	<span class="comment-delete"><a href="${b.id}/comment/${c.id}/del">삭제</a></span>
		                        </c:if>		                        
		                        <!-- <span class="comment-report"><a href="">신고</a></span> -->
		                    </div>
		                    <div class="comment-content mt10"> 
		                        ${c.content}
		                    <input class="comment-id" type="hidden" name="commentId" value="${c.id}" />
		                    <input class="comment-member-id" type="hidden" name="commentMemberId" value="${c.memberId}" />	                    
		                    </div>
		                   
		                </div>
	                </c:forEach>
                </div>
                
				<!-- 댓글 작성 -->
                <form method="post" action="${b.id}/comment/write" >
                    <div class="comment-form mt20">                                                   
                        <textarea name="comment" cols="" rows="4" placeholder="여러분의 소중한 댓글을 입력해주세요."></textarea>
                        <div class="comment-button-box mt20">
			               	<a class="a-button" href="../community/list">목록</a>
                            <button class="button" type="submit" >댓글</button>
                        </div>
                        	<input class="member-id" type="hidden" name="memberId" value="${b.memberId}" />
                        	<input class="board-id" type="hidden" name="boardId" value="${b.id}" />
                    	</div>
                </form>
                

            </div> <!-- wraaper end-->
        </section>

		<script src="/js/community/detail.js"></script>
  ```
  
  + reg.jsp
  ```
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/css/community/reg.css" type="text/css" rel="stylesheet" />
<link href="/css/community/reset.css" type="text/css" rel="stylesheet" />
<link href="/css/community/community-style.css" type="text/css" rel="stylesheet" />
<script type="module" src="/js/community/reg.js"></script>

<section class="main-container">
            <section class="wrapper">
                <form method="post" enctype="multipart/form-data">
	                <div class="category-option mt60">
	                    <select name="category" id="">
	                        <option value="1">질문</option>
	                        <option value="2">입양후기</option>
	                        <option value="3">강아지와함께</option>
	                        <option value="4">고양이와함께</option>
	                    </select>
	                </div>
	                <!-- 제목 입력부분 -->
	                    <div class="article-title mt30">
	                        <input type="text" name="title" placeholder="제목을 입력해주세요." />	                        
	                    </div><!-- contenteditable="true" -->
	                  
					<!-- 드래그 앤 드랍 방식 -->
	                 	<div class="drop-box mt10">
	                 		업로드 할 파일을 드롭하세요.
	                 		<input type="file" />
	                 	</div>
	                 	<div class="drop-file-name mt5">	                 	
	                 	</div>             	
	              
	                 <!-- 파일 첨부 방식 -->
	                    <div class="file-box mt10">		                    
		                    <span class="upload-button">업로드</span>
		                    <input class="upload-file" type="file" name="file" />
		                    <span class="file-name"></span>		                    
	                    </div>
	                    	                    
	                    <div>
	                    	<input class="mt10 add-button" type="button" value="add" />
	                    </div>
	                    
	                 <!-- 내용입력부분 -->   
	                    <div class="article-content mt30">
	                        <textarea class="content-place" name="content"  >
	
	                        </textarea>
	                    </div>
	                    <div class="article-confirm mt20">
	                        <div>
	                            <input class="community-button" type="submit" value="등록" />
	                           <!--  <a class="reg-button" href="list">취소</a> -->
	                        </div>
	                    </div>
                </form>
            </section>
        </section>      
  ```
  
+ edit.jsp
```
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<link href="/css/community/reset.css" type="text/css" rel="stylesheet" />
<link href="/css/community/community-style.css" type="text/css" rel="stylesheet" />
<link href="/css/community/edit.css" type="text/css" rel="stylesheet" />

	<section class="main-container">
           <!--  <div class="major-subject mt20">
                <h1 class="major-subject-text bold">커뮤니케이션</h1>
            </div> -->
            <div class="wrapper" >
	             <form method="post" enctype="multipart/form-data">
	            	<div class="category-option mt30">
	                    <select name="category" id="">
	                        <option value="1">질문</option>
	                        <option value="2">입양후기</option>
	                        <option value="3">강아지와함께</option>
	                        <option value="4">고양이와함께</option>
	                    </select>
	                </div>
	                
	                <section class="article-header mt30">
	                    <%-- <span class="category">category: <span>${b.category}</span></span> --%> 
	                    <span class="article-title bold">
	                    	<input type="text" name="title" value="${b.title}"/>
	                    </span>
	                    <div class="write-info">
	                        <span class="writer-id bar mr10">by ${b.nickname }</span> 
	                        <span class="regdate bar mr10"> 
	                        	<fmt:formatDate value="${b.regDate}" pattern="yyyy.MM.dd[E] a hh:mm:ss"/>
	                        </span>                        
	                    </div>
	                </section>
	                <div class="file-add-box mt10">
               			<input type="file" name="file" value=""/>
          			</div>                
					
	                <section class="article-content mt50">
	                    <textarea class="content-place" name="content"  >
							${b.content}
		                </textarea>	                                       
	                </section>
	                <div class="file-box mt10">
		                 	<img src="/upload/community/2021/${b.id}/${b.files}" alt="">		
               		</div> 
	
	            <div class="transfer-button-box mt60">
	            	<input type="hidden" name="id" value="${b.id}"/>
	            	<input class="edit-save-button" type="submit" value="저장"/>
	            	<a class="a-button ml1" href="../list">취소</a>
	            </div>	
	            </form>
            </div> <!-- wraaper end-->            
        </section>
  ```
 
 #### 3) Controller</br>
 
 + BoardController.java
 일반적으로 뷰를 반환하기 위한 Controller 이지만, 필요한 경우 @ResponseBody 어노테이션을 사용하여 데이터를 반환하였습니다.
 
 ```
package com.reborn.web.controller.community;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.reborn.web.entity.community.Board;
import com.reborn.web.entity.community.BoardView;
import com.reborn.web.entity.community.Comment;
import com.reborn.web.entity.community.CommentView;
import com.reborn.web.entity.community.Like;
import com.reborn.web.service.community.BoardService;

@Controller
@RequestMapping("/community/")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	//글 리스트
	@RequestMapping("list")
	public String list(
		@RequestParam(name="p", defaultValue ="1") int page,
		@RequestParam(name="v", defaultValue = "10") int view,		
		@RequestParam(name="f", defaultValue ="title") String field,
		@RequestParam(name="q", required = false) String query, 
		@RequestParam(name="c", required = false) String option,
		Model model) {
		
		List<BoardView> list = service.getViewList(page, view, field, query, option);
		System.out.println(page + ","+ view +","+field+","+query+","+option);
		int count = service.getCount(field, query, option); //전체 게시물의 수.
			
		//int size = view;
		int pageCount = (int)Math.ceil(count/(float)view);
		model.addAttribute("list", list);
		model.addAttribute("pageCount", pageCount);
		
		return "home.community.list";
	}
	
	//글 상세페이지
	@GetMapping("{id}")
	public String detail(Model model, @PathVariable("id") int id,
			HttpServletRequest request, HttpSession session) {
//		int memberId = ((Member) httpRequest.getSession().getAttribute("login")).
		session = request.getSession();
		int memberId = (Integer) session.getAttribute("id");
		
		BoardView board = service.get(id);		
		model.addAttribute("b", board);
		
		System.out.println("memberId"+ memberId);
		System.out.println("보드Id" + board.getId());
		
		List<CommentView> comment = service.getCommentViewList(id);
		model.addAttribute("comment", comment);
		
		int commentCount = service.getCommentCount(id);
		model.addAttribute("commentCount", commentCount);
		
		
		int likeCount = service.getLikeCount(id);
		model.addAttribute("likeCount", likeCount);
				
		service.hitUp(id);
		
		return "home.community.detail";		
	}
	
	//좋아요 토글 방식 +- 
	@PostMapping("{boardId}/like" )
	@ResponseBody
	public Map<String, Object> like(Model model, @PathVariable("boardId") int boardId,						
			HttpServletRequest httpRequest, HttpSession session) {
		String toggleLike;		
		
		session = httpRequest.getSession();
		int memberId = (Integer) session.getAttribute("id");
		System.out.println(memberId);
		
		Like like = new Like();
		like.setBoardId(boardId);
		like.setMemberId(memberId);
		
		int result = service.getCount(boardId, memberId);
		
		if(result == 0) { 		
		  service.insert(like);
		  toggleLike = "insert";
		} else {
			service.delete(boardId, memberId);
			toggleLike = "delete";
		}		
		int likeCount = service.getLikeCount(boardId);		
		Map<String, Object> dto = new HashMap<>();
		dto.put("likes", toggleLike);
		dto.put("likeCount", likeCount);
		
		return dto;		
	}
	
	
	//글 수정 Get
	@GetMapping("{id}/edit")
	public String edit(Model model, @PathVariable("id") int id) {
		
		BoardView board = service.get(id);
		model.addAttribute("b", board);
		
		return "home.community.edit";
	}
	
	//글 수정 Post
	@PostMapping("{id}/edit")
	public String edit(Board board, @RequestParam(name="category", defaultValue ="1") int category,
			@RequestParam(name="file", defaultValue = "", required = false) Part filePart,
			HttpServletRequest request) throws IOException {
		int id = board.getId();
		String title = board.getTitle();
		String content = board.getContent();
		String fileName = ""; 
		
		if(filePart != null) {
			fileName = filePart.getSubmittedFileName();
			board.setFiles(fileName);
		
			String pathTemp = request.getServletContext().getRealPath("/upload/community/2021/"+id);
			System.out.println(pathTemp);
			
			File path = new File(pathTemp);
			if(!path.exists())	
				path.mkdirs();
			
			String filePath = pathTemp + File.separator + fileName;
			
			InputStream fis = filePart.getInputStream();
			FileOutputStream fos = new FileOutputStream(filePath);
			
			byte[] buf = new byte[1024];
			int size = 0;
			while((size = fis.read(buf)) != -1)
					fos.write(buf, 0, size);
			
			fos.close();
			fis.close();
		}//end if
		
		
		Board origin = service.get(board.getId());
		origin.setTitle(title);
		origin.setContent(content);
		origin.setBoardCategoryId(category);
		origin.setFiles(fileName);
		System.out.println(content + "/" + category);
		System.out.println(board.getId());
		
		service.update(origin);
		
		return "redirect:../"+board.getId();
	} 
	
	
	
	//글 삭제
	@RequestMapping("{id}/del")
	public String delete(@PathVariable("id") int id) {
		System.out.println("========="+id);
		service.delete(id);
		
		return "redirect:../list";
	}
	
	//글 등록Get
	@GetMapping("reg")
	public String reg() {
		return "home.community.reg";
	}
	
	//글 등록Post
	@PostMapping("reg")
	public String reg(@RequestParam(name="title", required=false) String title,
			@RequestParam(name="content" ,required=false) String content,
			@RequestParam(name="category", required=false) int category,
			//@RequestParam(name="memberId", required=false ) int member,
			@RequestParam(name="file", defaultValue = "", required = false) Part filePart,
			HttpServletRequest request,
			HttpSession session) throws IOException, ServletException {
		
		session = request.getSession();
		int memberId = (Integer) session.getAttribute("id");
		System.out.println(memberId);
		
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setBoardCategoryId(category);
		Board lastId = service.getLastId();
		int newBoardId = lastId.getId()+1;
		board.setId(newBoardId);
		//멤버ID는 멤버가 주는 값으로 수정해야 함.		
		board.setMemberId(memberId);		
		Collection<Part> fileParts = request.getParts();
		String fileName = "";
		String fileNames = "";
		for(Part p : fileParts) {
			if(p.getName().equals("file") && p.getSize()>0 ) {
				filePart = p;
				fileName = filePart.getSubmittedFileName();
				fileNames += fileName;
				fileNames += ",";
				
				String url = "/upload/community/2021/"+newBoardId;
				String pathTemp = request.getServletContext().getRealPath(url);
				System.out.println("pathTemp"+pathTemp);
				
				File path = new File(pathTemp);
				if(!path.exists())
						path.mkdirs();
				
				String filePath = pathTemp + File.separator + fileName;
				System.out.println(filePath);
				
				InputStream fis = filePart.getInputStream();
				FileOutputStream fos = new FileOutputStream(filePath);
				
				byte[] buf = new byte[1024];
				int size = 0;
				while((size = fis.read(buf)) != -1)
						fos.write(buf, 0, size);
				
				fos.close();
				fis.close();
			}
		}
			
		board.setFiles(fileNames);
				
		service.insert(board);
		
		return "redirect:list";
	}
	
	//댓글 작성
	@PostMapping("{id}/comment/write")
	public String commentWrite(
			@PathVariable("id") int id,
			@RequestParam(name="comment") String commentContent,			
			HttpServletRequest request, HttpSession session) {
		session = request.getSession();
		int memberId =  (Integer) session.getAttribute("id");
		System.out.println("댓글 memberIdId"+ memberId);
		
		Comment comment = new Comment();
		comment.setContent(commentContent);
		comment.setMemberId(memberId);
		comment.setBoardId(id);
		
		service.commentInsert(comment);
		return "redirect:../../"+id;
	
	}
	
	//댓글 삭제
	@RequestMapping("{id}/comment/{commentId}/del")
	public String commentDelete(@PathVariable("id") int id,
			@PathVariable("commentId") int commentId) {
		
		System.out.println(id);
		service.commentDelete(commentId);
		
		return "redirect:../../../"+id;
	}
	

	//드래그 파일 업로드
	@PostMapping("upload")
	@ResponseBody
	public String upload(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {		

		Board lastId = service.getLastId();
		int newBoardId = lastId.getId()+1;
		
		String url = "/upload/community/2021/";
		
		String realPath = request.getServletContext().getRealPath(url);
		
		File realPathFile = new File(realPath);
		if(!realPathFile.exists())
			realPathFile.mkdirs();
		
		String uploadedFilePath = realPath + File.separator+file.getOriginalFilename();
		File uploadedFile = new File(uploadedFilePath);
		file.transferTo(uploadedFile);
		
		System.out.println("file upload ok");
		System.out.println("파일이름"+file.getOriginalFilename());
		System.out.println("파일경로"+realPath);
		//여기에서 파일이름을 어떻게 받지? => file.getOriginalFilename() 으로 받음
		return "ok";
	}
}
 ```
 
 

+ BoardController("apiBoardController")
비동기 처리를 위해 제이슨 형태로 객체를 반환하기 위한 컨트롤러
```
package com.reborn.web.controller.api.community;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.reborn.web.entity.community.BoardView;
import com.reborn.web.entity.community.Comment;
import com.reborn.web.entity.community.CommentView;
import com.reborn.web.service.community.BoardService;

@RestController("apiBoardController")
@RequestMapping("/api/community/")
public class BoardController {

	@Autowired
	private BoardService service;
	//
	@RequestMapping("list")
	public String list(
			@RequestParam(name="p", defaultValue ="1") int page,
			@RequestParam(name="v", defaultValue = "10") int view,		
			@RequestParam(name="f", defaultValue ="title") String field,
			@RequestParam(name="q", required = false) String query, 
			@RequestParam(name="c", required = false) String option
			) {
		
		List<BoardView> list = service.getViewList(page, view, field, query, option);
		int count = service.getCount(field, query, option); //전체 게시물의 수.
		int pageCount = (int) Math.ceil(count/(float)view);
		System.out.println(page+ "   "+view+ "   "+field+"  "+query+"  "+option);
		System.out.println("count  "+ count+ "pageCount  "+ pageCount);
		
		Map<String, Object> dto = new HashMap<>();
		dto.put("list", list);
		dto.put("pageCount", pageCount);
		dto.put("count", count);
		dto.put("view", view);
		dto.put("category", option);
		
		Gson gson = new Gson();
		
		return gson.toJson(dto);				
		
	}
	
//	@RequestMapping("{id}")	
//	public Map<String, Object> detail(@PathVariable("id") int id){
//		
//		/* BoardView board = service.get(id); */
//		/* dto.put("b", board); */
//		List<CommentView> comment = service.getCommentViewList(id);
//		int commentCount = service.getCommentCount(id);
//						
//		Map<String, Object> dto = new HashMap<>();
//		dto.put("comment", comment);
//		dto.put("commentCount", commentCount);
//		
//		return dto;
//		
//	}	
	
	//댓글 수정	
	@RequestMapping("{id}/commentEdit")				//boardId
	public  List<CommentView> comment(Model model, @PathVariable("id") int id,
			@RequestParam(name="commentId") int commentId, 
			@RequestParam(name="content") String content) {
		
		System.out.println(id);
		System.out.println(commentId);
		System.out.println(content);
		
		Comment origin = service.commentGet(commentId);
		origin.setContent(content);
		service.update(origin);
		
//		Map<String, Object> dto = new HashMap<>();
//		dto.put("comment", comment);
		
		List<CommentView> commentView = service.getCommentViewList(id);
		System.out.println(commentView);
		
		
		return  commentView;
	}
	
	
}

```
 
 #### 4) Service
 + BoardService
 ```
 package com.reborn.web.service.community;

import java.util.List;

import com.reborn.web.entity.community.Board;
import com.reborn.web.entity.community.BoardCategory;
import com.reborn.web.entity.community.BoardView;
import com.reborn.web.entity.community.Comment;
import com.reborn.web.entity.community.CommentView;
import com.reborn.web.entity.community.Like;

public interface BoardService {
	
	BoardView get(int id);
	int insert(Board board);
	int insert(BoardCategory category);
	
	int update(Board board);
	int delete(int id);
	Board getLastId(); 
//	int getLastId();
	//조회수 증가
	BoardView hitUp(int id);
	
	
	int getCount(String field, String query);
	Board getPrev(int id);
	Board getNext(int id);
	List<Board> getList(int page, int size, String field, String query);
	List<BoardView> getViewList(int page, int size, String field, String query);
	List<BoardView> getViewList(int page, int size);
	List<BoardView> getViewList(int page, int view, String field, String query, String option);
	
	public int commentInsert(Comment comment);
	public int commentDelete(int id);
	int getCommentCount(int id);
	List<CommentView> getCommentViewList(int id);
	int update(Comment comment);
	int getLikeCount(int id);
	void insert(Like like);
	int getCount(int id, int memberId);
	void delete(int id, int memberId);
	
	Comment commentGet(int id);
	int getCount(String field, String query, String option);
}
 ```
 
 + BoardServiceImp
 ```
 package com.reborn.web.service.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.reborn.web.dao.community.BoardDao;
import com.reborn.web.dao.community.CommentDao;
import com.reborn.web.dao.community.LikeDao;
import com.reborn.web.entity.community.Board;
import com.reborn.web.entity.community.BoardCategory;
import com.reborn.web.entity.community.BoardView;
import com.reborn.web.entity.community.Comment;
import com.reborn.web.entity.community.CommentView;
import com.reborn.web.entity.community.Like;

@Service
public class BoardServiceImp implements BoardService{
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private LikeDao likeDao;
	
	@Override
	public List<Board> getList(int page, int size, String field, String query) {
		int startIndex = 1+(page-1)*size;
		int endIndex = page*10;
		int offset = (page-1)*10;
		
		return boardDao.getList(startIndex, endIndex, field, query);
	}
	@Override
	public List<BoardView> getViewList(int page, int size) {
		int offset = (page-1)*10;
		return boardDao.getViewList(offset, size);
	}
	
	@Override
	public List<BoardView> getViewList(int page, int size, String field, String query) {
		
		int offset = (page-1)*10;
		
		return boardDao.getViewList(offset, size, field, query);
	}
	
	@Override
	public List<BoardView> getViewList(int page, int view, String field, String query, String option) {
		
		int offset = (page-1)*10;
		
		return boardDao.getViewList(offset, view, field, query, option);
	}
	
	
	//트랜잭션 처리
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public BoardView hitUp(int id) {
//		Board board = boardDao.get(id);
//		board.setHitCnt(board.getHitCnt()+1);
//		int result = boardDao.update(board);
		boardDao.hitUp(id);
		
		return boardDao.get(id);
	}

	@Override
	public BoardView get(int id) {
		return boardDao.get(id);
	}

	@Override
	public int insert(Board board) {
		return boardDao.insert(board);
	}
	
	@Override
	public int insert(BoardCategory category) {
		return boardDao.insert(category);
	}
	
	@Override
	public int update(Board board) {
		int result = 0;
		result = boardDao.update(board);
		return result;
	}

	@Override
	public int delete(int id) {
		int result = 0;
		result = boardDao.delete(id);
		return result;
	}

//	@Override
//	public int getLastId() {
//		Board b = boardDao.getLast();
//		
//		return b.getId();
//	}
	//board의 마지막 Id값구하기
	@Override
	public Board getLastId() {
		
		return boardDao.getLast();
	}
	

	@Override
	public int getCount(String field, String query) {
		// TODO Auto-generated method stub
		return boardDao.getCount(field, query);
	}
	
	@Override
	public int getCount(String field, String query, String option) {
		
		return boardDao.getCount(field, query, option);
	}

	@Override
	public Board getPrev(int id) {
		
		return boardDao.getPrev(id);
	}

	@Override
	public Board getNext(int id) {
		return boardDao.getnext(id);
	}
//	댓글 조회
	@Override
	public List<CommentView> getCommentViewList(int id) {
	
		return commentDao.getViewList(id);
	}
	
	//댓글 등록
	@Override
	public int commentInsert(Comment comment) {
		
		return commentDao.insert(comment);
		
	}
	@Override
	public int commentDelete(int id) {

		return commentDao.delete(id);
	}
		
	
	@Override
	public int getCommentCount(int id) {
		
		return commentDao.getCount(id);
	}
	
	@Override
	public int update(Comment comment) {
		int result = 0;
		commentDao.update(comment);
		return result;
	}
	
	
	@Override
	public int getLikeCount(int id) {
		// TODO Auto-generated method stub
		return likeDao.getLikeCount(id);
	}
	@Override
	public void insert(Like like) {	
		
		likeDao.insert(like);
	}
	
	@Override
	public int getCount(int id, int memberId) {
		
		return likeDao.getCount(id, memberId);
	}
	
	@Override
	public void delete(int id, int memberId) {
			likeDao.delete(id, memberId);
		
	}
	
	
	@Override
	public Comment commentGet(int id) {
		// TODO Auto-generated method stub
		return commentDao.commentGet(id);
	}
	
}
 ```
 
 #### 5) Model
 
 ##### 1) Entity
 
 + Board
 ```
 package com.reborn.web.entity.community;

import java.util.Date;

public class Board {
	
	private int id; 
	private String title; 
	private String content; 
	private Date regDate; 
	private String files;
	private int hitCnt;
	private int boardCategoryId;
	private int memberId;
	
	public Board() {
	
	}
	public Board(int id, String title, String content, Date regDate, String files, int hitCnt) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.files = files;
		this.hitCnt = hitCnt;
	}
	
	public Board(int id, String title, String content, Date regDate, String files, int hitCnt, 
			int boardCategoryId,
			int memberId) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.files = files;
		this.hitCnt = hitCnt;
		this.boardCategoryId = boardCategoryId;
		this.memberId = memberId;
	}
	//insert를 위한 생성자
	public Board(String title, String content) {
		this.title = title;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", title=" + title + ", content=" + content + ", regDate=" + regDate + ", files="
				+ files + ", hitCnt=" + hitCnt + ", boardCategoryId=" + boardCategoryId + ", memberId=" + memberId
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public int getHitCnt() {
		return hitCnt;
	}

	public void setHitCnt(int hitCnt) {
		this.hitCnt = hitCnt;
	}

	public int getBoardCategoryId() {
		return boardCategoryId;
	}

	public void setBoardCategoryId(int boardCategoryId) {
		this.boardCategoryId = boardCategoryId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	

	
}

 ```
 
 + BoardCategory.java
 ```
 package com.reborn.web.entity.community;

public class BoardCategory {

	private int id;
	private String name;
	
	public BoardCategory() {
		
	}

	public BoardCategory(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		
	}

	@Override
	public String toString() {
		return "BoardCategory [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	
}

 ```
 
 + BoardView.java
 ```
 package com.reborn.web.entity.community;

import java.util.Date;

public class BoardView extends Board {

	private String category;
	private String nickname;
	private int like;
	private int comment;
	
	public BoardView() {
		// TODO Auto-generated constructor stub
	}

	public BoardView(int id, String title, String content, Date regDate, String files, int hitCnt, String category, String nickname, int like, int comment) {
		super(id, title, content, regDate, files, hitCnt);
		this.category = category;
		this.nickname = nickname;
		this.like = like;
		this.comment = comment;
	}
	//insert를 위한 생성자.
	public BoardView(String title, String content, String category) {
		super(title, content);
		this.category = category;
	}

	@Override
	public String toString() {
		return "BoardView [category=" + category + ", nickname=" + nickname + ", like=" + like + ", comment=" + comment
				+ "]";
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getComment() {
		return comment;
	}

	public void setComment(int comment) {
		this.comment = comment;
	}
	
	
	
	
	
	
}

 ```
 
 + Comment.java
```
package com.reborn.web.entity.community;

import java.util.Date;

public class Comment {
	private int id;
	private int memberId;
	private int boardId;
	private String content;
	private Date regDate;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(int id, int memberId, int boardId, String content, Date regDate) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.boardId = boardId;
		this.content = content;
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", memberId=" + memberId + ", boardId=" + boardId + ", content=" + content
				+ ", regDate=" + regDate + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
	
}

```
+  CommentView.java
```
package com.reborn.web.entity.community;

import java.util.Date;

public class CommentView extends Comment{

	private String nickname;
	
	public CommentView() {
		// TODO Auto-generated constructor stub
	}
	
	public CommentView(int id, int memberId, int boardId, String content, Date regDate, String nickname) {
		super(id, memberId, boardId, content, regDate);
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "CommentView [nickname=" + nickname + ", toString()=" + super.toString() + "]";
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	

	
	
	
	
}

```
+ Like.java
```
package com.reborn.web.entity.community;

public class Like {
	private int id;
	private int memberId;
	private int boardId;
	
	public Like() {
		// TODO Auto-generated constructor stub
	}

	public Like(int id, int memberId, int boardId) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.boardId = boardId;
	}

	@Override
	public String toString() {
		return "Like [id=" + id + ", memberId=" + memberId + ", boardId=" + boardId + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
}

```
 ##### 2) DAO
 + BoardDao.java
 ```
 package com.reborn.web.dao.community;

import java.util.List;

import com.reborn.web.entity.community.Board;
import com.reborn.web.entity.community.BoardCategory;
import com.reborn.web.entity.community.BoardView;

public interface BoardDao {
	int insert(Board board);
	int update(Board board);
	int delete(int id);
	
	BoardView get(int id);
	
	Board getLast();
	
	//검색후 갯수를 반환: 인수는 getViewList와 동일하게.
	int getCount(String field, String query);
	
	//상세 페이지에서 이전/다음글을 구하기 위한 함수
	Board getPrev(int id);
	Board getnext(int id);
	
	List<Board> getList();	
	List<Board> getList(int offset);
	List<Board> getList(int offset, int size, String field, String query);
	List<BoardView> getViewList(int offset, int size);
	List<BoardView> getViewList(int offset, int size, String field, String query);
	List<BoardView> getViewList(int offset, int view, String field, String query, String option);
	int insert(BoardCategory category);
	int hitUp(int id);
	int getCount(String field, String query, String option);
	
	
}

 ```

+ Comment.java
```
package com.reborn.web.dao.community;

import java.util.List;
import com.reborn.web.entity.community.Comment;
import com.reborn.web.entity.community.CommentView;

public interface CommentDao {
	// 댓글 조회
	List<CommentView> getViewList(int boardId);
	
	// 댓글 작성
	int insert(Comment commemt);
	
	// 댓글 수정
	int update(Comment commemt);
	
	// 댓글 삭제
	int delete(int id);

	int getCount(int id);

	Comment commentGet(int id);

	
	
}

```

+ Like.java
```
package com.reborn.web.dao.community;

import com.reborn.web.entity.community.Like;

public interface LikeDao {

	int getLikeCount(int id);

	int getCount(int id, int memberId);

	void delete(int id, int memberId);

	void insert(Like like);

}

```
+ MyBatisBoardDao.java
```
package com.reborn.web.dao.mybatis.community;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.reborn.web.dao.community.BoardDao;
import com.reborn.web.entity.community.Board;
import com.reborn.web.entity.community.BoardCategory;
import com.reborn.web.entity.community.BoardView;
@Repository
public class MyBatisBoardDao implements BoardDao{
	
	private SqlSession session;
	
	private BoardDao mapper;
	
	@Autowired
	public MyBatisBoardDao(SqlSession session) {
		this.session = session;
		mapper = session.getMapper(BoardDao.class);
	}
	
	@Override
	public int insert(Board board) {
		return mapper.insert(board);
	}
	
	@Override
	public int insert(BoardCategory category) {
	
		return mapper.insert(category);
	}

	@Override
	public int update(Board board) {
		return mapper.update(board);
	}
	
	//글 조회수 업데이트
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public int hitUp(int id) {
		
		return mapper.hitUp(id);
	}
	
	@Override
	public int delete(int id) {
		return mapper.delete(id);
	}

	@Override
	public BoardView get(int id) {
		return mapper.get(id);
	}


	@Override
	public Board getLast() {

		return mapper.getLast();
	}

	@Override
	public int getCount(String field, String query) {
	
		return mapper.getCount(field, query);
	}
	
	@Override
	public int getCount(String field, String query, String option) {
		
		return mapper.getCount(field, query, option);
	}

	@Override
	public Board getPrev(int id) {
		// TODO Auto-generated method stub
		return mapper.getPrev(id);
	}

	@Override
	public Board getnext(int id) {
		return mapper.getnext(id);
	}
	@Override
	public List<Board> getList() {
		return mapper.getList();
	}
	
	@Override
	public List<Board> getList(int offset) {
		return mapper.getList(1);
	}
	
	@Override
	public List<Board> getList(int offset, int size, String field, String query) {
		return mapper.getList(offset, size, field, query);
	}
	@Override
	public List<BoardView> getViewList(int offset, int size) {
		
		return mapper.getViewList(offset, size);
	}

	@Override
	public List<BoardView> getViewList(int offset, int size, String field, String query) {

		return mapper.getViewList(offset, size, field, query);
	}

	@Override
	public List<BoardView> getViewList(int offset, int view, String field, String query, String option) {

		return mapper.getViewList(offset, view, field, query, option);
	}
	
	
	
	
	
}

```
+ MyBatisCommentDao.java
```
package com.reborn.web.dao.mybatis.community;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reborn.web.dao.community.CommentDao;
import com.reborn.web.entity.community.Comment;
import com.reborn.web.entity.community.CommentView;

@Repository
public class MyBatisCommentDao implements CommentDao{

	private SqlSession session;
	
	private CommentDao mapper;
	
	@Autowired
	public MyBatisCommentDao(SqlSession session) {
		this.session = session;
		mapper = session.getMapper(CommentDao.class);
	}
	
	
	@Override
	public List<CommentView> getViewList(int boardId) {
		return mapper.getViewList(boardId);
	}

	@Override
	public int insert(Comment commemt) {
	
		return mapper.insert(commemt);
	}

	@Override
	public int update(Comment commemt) {
	
		return mapper.update(commemt);
	}

	@Override
	public int delete(int id) {
			
		return mapper.delete(id);
	}


	@Override
	public int getCount(int id) {

		return mapper.getCount(id);
	}

	@Override
	public Comment commentGet(int id) {
	
		return mapper.commentGet(id);
	}
	
	
}

```
+ MyBatisLikeDao.java
```
package com.reborn.web.dao.mybatis.community;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reborn.web.dao.community.LikeDao;
import com.reborn.web.entity.community.Like;
@Repository
public class MyBatisLikeDao implements LikeDao {

	private SqlSession session;
	
	private LikeDao mapper;
	@Autowired
	public MyBatisLikeDao(SqlSession session) {
		this.session = session;
		mapper = session.getMapper(LikeDao.class);
	}
	
	@Override
	public int getLikeCount(int id) {
		// TODO Auto-generated method stub
		return mapper.getLikeCount(id);
	}
	
	@Override
	public int getCount(int id, int memberId) {
		// TODO Auto-generated method stub
		return mapper.getCount(id, memberId);
	}
	
	@Override
	public void delete(int id, int memberId) {
		
		mapper.delete(id, memberId);
		
	}
	
	@Override
	public void insert(Like like) {
		mapper.insert(like);
		
	}
	
}

```
##### Mapper
+ BoardDaoMapper.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    
<mapper namespace="com.reborn.web.dao.community.BoardDao">
     
	<select id="getViewList" resultType="com.reborn.web.entity.community.BoardView">
	  SELECT * FROM BoardView
	  <where>
	      <if test="param3 != null and param3 != ''">
	         BINARY ${param3} like '%${param4}%'
	      </if>      
	      <if test="param5 != null and param5 != ''">
	      	 AND category = '${param5}' 
	      </if>
	  </where>
      order by regdate desc
      limit #{param2} offset #{param1}
	</select>
	
 <select id="getList">
 	SELECT * FROM Board
	<if test="param3 != null and param3 != ''">
       where BINARY '${param3}' like '%${param4}%'
    </if>
    order by regdate desc
    limit #{param2} offset #{param1}
   </select>
 
<!-- 전체 게시물의 수--> 
 <select id="getCount" resultType="int">
    SELECT count(id) FROM BoardView
    <where>
	    <if test="param1 != null and param1 != ''">
	       BINARY ${param1} like '%${param2}%'
	    </if>
	    <if test= "param3 != null and param3 != ''">
	    	AND category = '${param3}'
	    </if>
    </where>
 </select> 
  <!-- detail 에서 사용할 쿼리: id 값 가져오기 -->
  <select id="get" resultType="com.reborn.web.entity.community.BoardView">
  		SELECT * FROM BoardView
  		where id=${id}
  </select>   
   
   <!-- 글 삭제 -->
   <delete id="delete">
   		DELETE FROM Board WHERE id=#{id}   
   </delete>
   
   <!-- 글 등록 -->
   <insert id="insert" parameterType="com.reborn.web.entity.community.Board" >
   		INSERT INTO Board(title, content, boardCategoryId, memberId, files) 
   		values(#{title}, #{content}, #{boardCategoryId}, #{memberId}, #{files})
   </insert>
<!--    <insert id="insert" parameterType="com.reborn.web.entity.community.BoardCategory" >
   		INSERT INTO BoardCategory(name) values(#{name})
   </insert> -->
   
   <!-- 글 수정 -->
   <update id="update">
   	UPDATE Board
   	SET
   		title = #{title},
   		content = #{content},
   		boardCategoryId = #{boardCategoryId},
   		files = #{files}
   	WHERE id = #{id}   		
   </update> 
   
   <select id="getLast" resultType="com.reborn.web.entity.community.Board">
   		SELECT * FROM Board 
			WHERE id = (SELECT MAX(id) FROM Board);
   </select>
   
   <update id="hitUp" parameterType="int">
   	UPDATE Board SET
   		hitCnt = hitCnt+1
   		WHERE id = #{id}
   </update>
   
   
</mapper> 
```

+  CommentDao.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    
<mapper namespace="com.reborn.web.dao.community.CommentDao">

	<!-- 댓글조회 -->
	<select id="getViewList" parameterType="int" resultType="com.reborn.web.entity.community.CommentView">
		SELECT * 
			FROM CommentView
				WHERE boardId = #{boardId}			
	</select>
	
	<!-- 댓글작성 -->
	<insert id="insert" parameterType="com.reborn.web.entity.community.Comment">
		INSERT INTO Comment(memberId, boardId, content)
			values(#{memberId}, #{boardId}, #{content})
	</insert>
	
	<!-- 댓글수정 -->
	<update id="update" parameterType="com.reborn.web.entity.community.Comment">
		UPDATE Comment 
			SET content = #{content}		
				WHERE id = #{id}
			<!-- AND boardId = #{boardId} -->	
	</update>
	
	<!-- 댓글삭제 -->
	<delete id="delete" parameterType="com.reborn.web.entity.community.Comment">
		DELETE FROM Comment 
			WHERE id = #{id}
			 	
	</delete>
	
	<!-- 댓글 수 조회 -->
	<select id="getCount" resultType="int">
		select count(id) as count from Comment
		where boardId = #{boardId};
	</select>

	<select id="commentGet" resultType="com.reborn.web.entity.community.Comment">
		SELECT * FROM Comment
  		where id=${id}
	
	</select>
	


</mapper>    
```

+ LikeDaoMapper.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    
<mapper namespace="com.reborn.web.dao.community.LikeDao">
     

<!-- 해당 글의 '좋아요' 수를 반환  --> 
 <select id="getLikeCount" resultType="int">
	select count(id) from `Like`
		where boardId = #{boardId};	
</select>

<!-- 좋아요를 눌렀는지 아닌지 반환 -->
<select id="getCount" resultType="int">
	select count(id) from `Like` 
		  where boardId = #{param1}
			AND memberId = #{param2}
</select>
 
   
   <!-- 좋아요 추가 -->
   <insert id="insert" parameterType="com.reborn.web.entity.community.Like" >
	   	insert into `Like`(memberId, boardId) 
	   	values(#{memberId}, #{boardId});
   </insert>
   
   <!-- 좋아요 삭제 -->
   <delete id="delete">
   	DELETE from `Like`
	where boardId = #{param1}
    AND memberId = #{param2}
   </delete> 
   
</mapper> 

```



 


