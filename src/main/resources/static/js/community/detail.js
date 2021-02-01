window.addEventListener("load", (e)=>{
	const likeBtn = document.querySelector(".like-btn");
	const boardId = document.querySelector(".board-id");
	const memberId = document.querySelector(".member-id");
	const likeCount = document.querySelector(".like-count");
	const commentEdit = document.querySelector(".comment-edit");
	
	console.log(boardId);
	let boardValue = boardId.value;  //jsp에서 hidden으로 숨긴 boardId 값
	let memberValue = memberId.value;
	let win;
	
	
	
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
	
	/*commentEdit.addEventListener("click", (e)=>{
		e.preventDefault();
		console.log("수정 클릭")
		
		win = open("./commentEdit.jsp", "width=400px", "height=400px", "left=550px", "top=400px");
		
	});*/
	

	
	

	
});