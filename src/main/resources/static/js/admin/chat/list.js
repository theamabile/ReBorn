window.addEventListener('load', (e)=>{
	let roomList = document.querySelector('.room-list');
	let dialogBox =  document.querySelector('.dialog-box');
	let chatBox = document.querySelector('.dialog-box ul');
	let chatInput = document.querySelector('.chat-input');
	let chatSendBtn = document.querySelector('.chat-send-btn');
	
	chatInput.addEventListener('keydown', (e)=>{	
		if (e.keyCode === 13) {
			e.preventDefault();
			console.log("엔터 침");
			
			let event = new MouseEvent('click', {
	        'view':window,
	        'bubbles': true,
	        'cancelable': true
		    });
		
		    chatSendBtn.dispatchEvent(event);

		}
		
		
		 

	})
	
	
	
	
	let userId ="2"; //임시지정
	let roomId;
	let localhost = "localhost:8080";
	let socket = new WebSocket(`ws://${localhost}/chatting/99999`);
	socket.addEventListener('open', function (e) {		
		console.log("소켓 연결됨!!!");
	});
	
	
	chatSendBtn.addEventListener('click', (e)=>{
		e.preventDefault();
		let message = {
			senderId:userId,
			chatData:chatInput.value,
			roomId : roomId
		}
		if(socket != undefined ){
			socket.send(JSON.stringify(message));
			chatData:chatInput.value="";
		}
		
	})
	
	
	roomList.addEventListener('click', (e)=>{
		e.preventDefault();
		if(e.target.tagName ="A"){
			let roomListNode = roomList.querySelectorAll('li> a');
			let roomListArr =Array.prototype.slice.call(roomListNode)

			for(let arr of roomListArr){
				console.log(arr)
				arr.classList.remove('active');
			}
	
	
			let target = e.target;
			
			target.classList.add('active');
			roomId = e.target.dataset.room;
			
			//처음 값받아오기
			fetch(`/api/chat/list?id=${roomId}`)
			.then(response =>response.json())
			.then(json => {
				chatBox.innerHTML ="";
				for(let n of json){
					let li;
					if( roomId != n.senderId){
						li = `							
		                  <li class="right">
		                      <span class="thumb">A</span>
		                      <p class="chat-con">${n.content}</p>
		                  </li>
							`
					}else {
						li = `
							 <li class="left">
		                      <span class="thumb">Q</span>
		                      <p class="chat-con">${n.content}</p>
		                  	</li>
						`
					}
					chatBox.insertAdjacentHTML('beforeend', li);
				
				}	
			})
			.then((aa)=>{
				
				chatScroll();
			});
			
			//chatScroll();
			
			
			
			
			
			//소켓시작==========================
			//소켓 연결 끊기
			console.log(socket)
			if(socket != undefined){
				console.log("소켓연결 끊음")
				socket.close(); 
			}
			
			
			//소캣 새로 연결
			socket = new WebSocket(`ws://${localhost}/chatting/${roomId}`);
			console.log(socket)
			
			socket.addEventListener('open', function (e) {		
				console.log("소켓 연결됨!!!");
				connect();
			});
		}	
	});
	
	
	
	
	console.log("socket" + socket)
	//메시지 받음
	function connect(){
		console.log("연결함수")
		socket.addEventListener('message', function (e) {
			console.log("aaa");
			console.log(e.data);
			let message = JSON.parse(e.data);
			let {senderId, chatData, roomId} = message;
			if( roomId != senderId){
					li = `							
	                  <li class="right">
	                      <span class="thumb">A</span>
	                      <p class="chat-con">${chatData}</p>
	                  </li>
						`
				}else {
					li = `
						 <li class="left">
	                      <span class="thumb">Q</span>
	                      <p class="chat-con">${chatData}</p>
	                  	</li>
					`
				}
			chatBox.insertAdjacentHTML('beforeend', li);
			chatScroll();
		});
	}	
			
			
	
	//스크롤 제일 아래로..
	function chatScroll (){
	    dialogBox.scrollTop = dialogBox.scrollHeight;
	}
	chatScroll();
});




