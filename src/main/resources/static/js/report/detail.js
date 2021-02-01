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
			                    </ol>
			                    <div class="comment-content">
			                       ${n.content}
			                    </div>
			                </li>
							`
							
							commentBox.insertAdjacentHTML('beforeend', li);
						}
					})
					
					//댓글 가져오가ㅣ
					})
					

				}else{
					alert("댓글창이 비어있습니다. 댓글을 입력해주세요.")
				}
			}else {
				//로그인 필요함
				alert('로그인 서비스가 필요합니다.')
			}
			
		})
		
		
		
		//수정하기
		let modifyBtn = document.querySelectorAll('.comment-modify');
		console.log(modifyBtn);
		
		
		modifyBtn.forEach(item=>{
			item.addEventListener('click', (e)=>{
				e.preventDefault();
				console.log(e.target.dataset.commentid);
				let modalBox = new ModalBox({
					content:`수정할 내용을 입력해주세요.`
				});
			})
		});
		
		
		
		//삭제하기
		let deleteBtn = document.querySelectorAll('.comment-delete');
		console.log(modifyBtn);
		deleteBtn.forEach(item =>{
			item.addEventListener('click', (e)=>{
				e.preventDefault();	
				console.log(e.target.dataset.commentid);
				let modalBox = new ModalBox({
					content:`정말로 삭제하시겠습니까?`
				});
				
				modalBox
				.then((resolve)=>{
					console.log(resolve)
					if(resolve.result == "ok"){
						console.log('취소')
					}else {
						
					}
				})
				

			});
		})
		
});		




function date_to_str(format)

{

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
