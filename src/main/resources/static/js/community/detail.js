window.addEventListener("load", (e)=>{
	/*const commentViewBox = document.querySelector(".comment-view-box");
	const commentEdit = commentViewBox.querySelector(".comment-edit");*/
	const likeBtn = document.querySelector(".like-btn");
	const boardId = document.querySelector(".board-id");
	const memberId = document.querySelector(".member-id");
	const likeCount = document.querySelector(".like-count");
	
	
		console.log(boardId);
	let boardValue = boardId.value;
	let memberValue = memberId.value;
	
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
				likeBtn.style.color = "red";
				likeCount.innerText = parseInt(likeCount.innerText) - 1;
			}
		})		
	});
	
	
	
	
	
	commentEdit.addEventListener("click", (e)=>{
		e.preventDefault();
		console.log("수정클릭");
		
	})
	
});