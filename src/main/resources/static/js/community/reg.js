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
		
		request.open("POST", url);
		request.send(formData);   //전달할 것:파일
			
		
		
		console.log(e.dataTransfer.files.length);
		console.log(e.dataTransfer.files[0].name);
		for(let n of e.dataTransfer.files){
			console.log(n.name);
		}
		
		CSS.set(dropBox, {
			background: "#32a088",
			
		});
		dropBox.innerText = "파일을 업로드 합니다.";
		
		
	});
	
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