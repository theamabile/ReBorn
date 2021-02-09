window.addEventListener('load', (e)=>{
	

	let linkList = document.querySelector('.link-list');
	
	
	//삭제 링크
	linkList.addEventListener('click', (e)=>{
		if(e.target.tagName =="I"){
			let delBtn = e.target.tagName;
			let id = e.target.closest('a').dataset.link;

			let result = confirm(`정말로 삭제하시겠습니까?`);
			if(result == true){
				fetch(`/api/admin/chat/link/delete/${id}`)
				.then(rep =>{
					linkLoad();
				});		
			}
		}
	});
	
	
	//글등록
	let linkAddBtn = document.querySelector('.link-add-btn');
	let inputTitle = document.querySelector('.link-tit');
	let inputAddr = document.querySelector('.link-addr');
	
	linkAddBtn.addEventListener('click', (e)=>{
		e.preventDefault();
		let inputTitleValue = inputTitle.value;
		let inputAddrValue = inputAddr.value;
		
		fetch(`/api/admin/chat/link/add`,{
			body: `title=${inputTitleValue}&link=${inputAddrValue}`,
			headers: {
				"Content-Type" : "application/x-www-form-urlencoded",
			},
			method:'POST'
		})
		.then(rep =>{
			
			linkLoad();
			inputTitle.value ="";
			inputAddr.value="";
		})
		
		
	})

	//링크 가져오기
	function linkLoad(){
		linkList.innerHTML =""; //html비위기
		
		fetch(`/api/admin/chat/link/list`)
		.then(response => response.json())
		.then(result =>{
			console.log(result)
			
			let li; 
			for(let n of result){
				li = `<li>
					<dl>
						<dt>${n.title}<dt>
						<dd>
							<a href="${n.address}">
							${n.address}
							</a>
						</dd>
					</dl>	
					<a href="#" class="del-btn" data-link="${n.id}"><i class="fas fa-minus-circle"></i></a>
				</li>				
				`
				linkList.insertAdjacentHTML('beforeend', li);
			}
		});
	}

		
});