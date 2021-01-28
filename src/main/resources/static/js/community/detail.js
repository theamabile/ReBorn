window.addEventListener("load", (e)=>{
	const commentViewBox = document.querySelector(".comment-view-box");
	const commentEdit = commentViewBox.querySelector(".comment-edit");
	
	commentEdit.addEventListener("click", (e)=>{
		e.preventDefault();
		console.log("수정클릭");
		
	})
	
});