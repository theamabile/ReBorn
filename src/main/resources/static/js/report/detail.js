window.addEventListener('load', (e)=>{
		let commentBox = document.querySelector('.comment-box ul');
		let commentForm = document.querySelector('.comment-form');
		let commentArea = document.querySelector('.comment-area');
		let commentBtn = document.querySelector('.comment-btn');
		
		let missingId = document.querySelector('.missing-id ').innerHTML;
		let uid = 1;
		
		commentBtn.addEventListener('click', (e)=>{
			
			e.preventDefault();
			if(uid){
				if(commentArea.value != null && commentArea.value != ""){
					//commentForm.method = "POST"
					//commentForm.submit();
		
					//값 보내기
					let commentContent = commentArea.value;
					fetch(`/api/report/${missingId}/comment/write`,{
						body: `missingId=${missingId}&comment-content=${commentContent}`,
						headers: {
							"Content-Type" : "application/x-www-form-urlencoded",
						},
						method:'POST',
					})
					.then(()=>{
					commentArea.value = "";
					commentBox.innerHTML="";
					
					
					
					
					//댓글 가져오가
					commentLoad(missingId, commentBox);
					})
					

				}else{
					alert("댓글창이 비어있습니다. 댓글을 입력해주세요.")
				}
			}else {
				//로그인 필요함
				alert('로그인 서비스가 필요합니다.')
			}
			
		})
});		

function commentLoad(missingId, commentBox){
	fetch(`/api/report/comments/${missingId}`)
	.then(response =>response.json())
	.then(json =>{
		commentBox.innerHTML="";
		for(let n of json){
			let date = n.regDate.substr( 0, 10);
			let li = `
			<li>
                <ol class="comment-info">
                    <li>${n.nickname}</li>
                    <li>${date}</li>
					<li class="util-menu">
                    	<ol>
                    		<li><a href="#" class="comment-modify " data-commentid="${n.id}" onClick="modifyFn();">수정</a></li>
                    		<li><a href="#" class="comment-delete" data-commentid="${n.id}" onClick="deleteFn();">삭제</a></li>
                    		<li><a href="#" class="comment-declare" data-commentid="${n.id}" onClick="declareFn();">신고</a></li>
                    	</ol>
                    </li>	
                </ol>
                <div class="comment-content">
                   ${n.content}
                </div>
            </li>
			`
			
			commentBox.insertAdjacentHTML('beforeend', li);
		}
	})	
}


function date_to_str(format){

    var year = format.getFullYear();

    var month = format.getMonth() + 1;

    if(month<10) month = '0' + month;

    var date = format.getDate();

    if(date<10) date = '0' + date;

    var hour = format.getHours();

    if(hour<10) hour = '0' + hour;

    var min = format.getMinutes();

    if(min<10) min = '0' + min;

    var sec = format.getSeconds();

    if(sec10) sec = '0' + sec;

    return year + "-" + month + "-" + date;
}


function deleteFn(){
	let missingId = document.querySelector('.missing-id ').innerHTML;
	let commentBox = document.querySelector('.comment-box ul');
	let commentArea = document.querySelector('.comment-area');
	
	event.preventDefault();
	console.log(event.target);
	let modalBox = new ModalBox({
		content:`정말로 삭제하시겠습니까?`
	});
	let comId = event.target.dataset.commentid;
	
	modalBox
	.then((resolve)=>{
		if(resolve.result == "ok"){
			//삭제 값 보내기
			fetch(`/api/report/${missingId}/comment/delete/${comId}`)
			.then(()=>{
				commentArea.value = "";
				commentBox.innerHTML="";
			
			//댓글 가져오가
			commentLoad(missingId, commentBox);
				
			});
			
		}else {
			console.log('취소');
		}
	})
}


function declareFn(){
	event.preventDefault();
	let missingId = document.querySelector('.missing-id ').innerHTML;
	let commentBox = document.querySelector('.comment-box ul');
	let commentArea = document.querySelector('.comment-area');
	let comId = event.target.dataset.commentid;
	
	
	
	
	let reason = prompt("신고 사유를 적어주세요.");
	if(reason != null && reason !=""){
		fetch(`/api/report/${missingId}/comment/declare/${comId}`,{
			body: `reason=${reason}`,
			headers: {
				"Content-Type" : "application/x-www-form-urlencoded",
			},
			method:'POST',
		})
		.then(()=>{
			let modalBox = new ModalBox({
				content:`수정되었습니다..`,
				cancelBtnHide:true
			});
			
			
			//댓글 가져오가
			commentLoad(missingId, commentBox);
			
		});

	}
}

function modifyFn(){
	event.preventDefault();
	
	let missingId = document.querySelector('.missing-id ').innerHTML;
	let comId = event.target.dataset.commentid;
	let commentBox = document.querySelector('.comment-box ul');
	
	
	let content = prompt("댓글 수정 내용을 적어주세요.");
	if(content != null && content!=""){
		
		fetch(`/api/report/${missingId}/comment/modify/${comId}`,{
			body: `content=${content}`,
			headers: {
				"Content-Type" : "application/x-www-form-urlencoded",
			},
			method:'POST',
		})
		.then(()=>{
			let modalBox = new ModalBox({
				content:`수정되었습니다.`,
				cancelBtnHide:true
			});
			
			//댓글 가져오가
			commentLoad(missingId, commentBox);
			
		});	
	}
}
