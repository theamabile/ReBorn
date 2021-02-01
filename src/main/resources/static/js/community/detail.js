window.addEventListener("load", (e)=>{
	const likeBtn = document.querySelector(".like-btn");
	const boardId = document.querySelector(".board-id");
	const memberId = document.querySelector(".member-id");
	const likeCount = document.querySelector(".like-count");
	const commentEdit = document.querySelector(".comment-edit");
	const commentForm = document.querySelector(".comment-form");
	const commentContent = document.querySelector(".comment-content");
	const commentId = document.querySelector(".comment-id");
	
	const commentMemberId = document.querySelector(".comment-member-id");
	
	console.log(boardId);
	let boardValue = boardId.value;  //jsp에서 hidden으로 숨긴 boardId 값
	let memberValue = memberId.value;
	let commentValue = commentId.value;
	let commentMemberValue = commentMemberId.value;
	//let win;
	
	likeBtn.addEventListener("click", (e)=>{
				console.log("클릭");
		
		fetch(`/community/${boardValue}/like`, {
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
	
	
	//코멘트 수정.
	commentEdit.addEventListener("click", (e)=>{
		e.preventDefault();
				
		let message = prompt('message');
				
		fetch(`/api/community/${boardValue}/commentEdit`, {
			method : "post",
			headers: {                              //작성하지 않으면 formdata:multipart
            //'Content-Type': 'application/json'    //서버에서 어떻게 읽을 건지: 
            'Content-Type': 'application/x-www-form-urlencoded'  //text/html, text/stylesheet
         	},
			body: `content=${message}&commentId=${commentValue}`			
         })
		.then(function(response){				
				return response.json();						
		})
		.then(json => {
			
			/*console.log(input);
			console.log(boardValue);
			console.log("코멘트멤버ID "+commentMemberValue);
			console.log("commentId  "+ commentValue);*/
			
			commentContent.innerText = message;
		})
		//댓글이 여러개일 경우: 부모선택자, 자식선택자
		
		
		
		/*let message = `
					<div>
						<input type="text" />
					</div>
		`;
		commentForm.insertAdjacentHTML("beforebegin", message);*/
		
		
		//win = open(`/community/commentEdit`, "width=400px", "height=400px", "left=550px", "top=400px");
		
	});
	
	
});