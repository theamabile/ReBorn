//import ModalBox from "./modules/ModalBox.js";

//let modalBox =  new ModalBox("test");

class ModalBox {
	
	content;
	targetNode;
	contentNode;
	position;
	screen;
	frame;
	footer;
	btnInner;
	cancelBtn;
	okBtn;
	autoClose;

		// 1. 기본기능만 쓰기 -> confirm 같은 역할
		// let modalBox = new ModalBox({
		// 	content: `리뷰를 삭제하겠습니까??`
		// });

		// 2. 버튼 하나만 -> alert 역할
		// let modalBox = new ModalBox({
		// 	content: `안녕하세요`,
		// 	cancelBtnHide: true
		// });

		// promise가 반환됨
		// modalBox
		// .then( 
		// 	resolve => {
		// 		// resolve.result로 사용자 결과 값 받아옴 ( ok, cancel )
		// 		console.log(resolve.result);

		// 		// modalBox. 하게되면 자신이 안나오고 promise여서
		// 		// resolve.instance로 this를 넘겨줌
		// 		// resolve.instance.close(); 이렇게 사용 가능
		// 		console.log(resolve.instance);

		// 		if(resolve.result == "ok"){
		// 			// 확인 버튼 눌렀을때 실행될 코드
		// 		} else if (resolve.result == "cancel"){
		// 			// 배경, 취소 버튼 눌렀을때 실행될 코드
		// 		}
		// 	}, 
		// 	reject => {
		// 		console.error(reject);
		// 	}
		// )

		//! content					내용: 필수로
		//? targetNode				어디에 넣을건지 : body
		//? position				insert 할때 포지션 : beforeend
		//? contentPadding			컨텐츠 안에 패딩 설정 : true
		//? footerHide				하단 버튼들 숨길지 : false
		//? okBtnText				ok		버튼에 텍스트 설정 : 확인
		//? okBtnTextColor					텍스트 컬러 : 하얀색
		//? okBtnBackgroundColor			배경 컬러 : 메인색
		//? okBtnHide						버튼 숨길지 : false
		//? cancelBtnText			cancel	버튼에 텍스트 설정 : 취소
		//? cancelBtnTextColor				텍스트 컬러 : 검은색
		//? cancelBtnBackgroundColor		배경 컬러 : 회색
		//? cancelBtnHide					취소 버튼 숨길지 : false
		//? btnPositionChange		확인, 취소 버튼 위치 서로 변경 : false
		//? removeOnBackgroundClick	검은색 부분 클릭했을때 지울지 : true
		//
		//? autoClose				배경이나 버튼들 클릭했을떄 자동으로 닫히게 할지 : true
		//?							autoClose 미사용시 resolve.instance.close();로 제거할 수 있음

	constructor({
		content = "",
		targetNode = document.body,
		position = "beforeend",
		contentPadding = true,
		footerHide = false,
		okBtnText = "확인",
		okBtnTextColor = "",
		okBtnBackgroundColor = "",
		okBtnHide = false,
		cancelBtnText = "취소",
		cancelBtnTextColor = "",
		cancelBtnBackgroundColor = "",
		cancelBtnHide = false,
		btnPositionChange = false,
		removeOnBackgroundClick = true,
		autoClose = true
	}){
		return new Promise((resolve, reject) => {
			
			if( content == ""){
				let message = "content를 설정해주세요";
				console.error(message);
				return reject(message);
			}

			// 세팅 ===================================================
			
			let screen = document.createElement("div");
			let frame = document.createElement("div");
			let contentNode = document.createElement("div");
			let footer = document.createElement("div");
			let btnInner = document.createElement("div");
			let cancelBtn = document.createElement("div");
			let okBtn = document.createElement("div");
			
			
			screen.classList.add("modal", "modal-box-container");
			frame.classList.add("modal-box-inner", "d-none");
			contentNode.classList.add("modal-content");
			if( contentPadding )
				contentNode.classList.add("modal-content-padding");
			footer.classList.add("modal-footer");
			btnInner.classList.add("btn-inner");
			cancelBtn.classList.add("modal-btn", "cancel-btn");
			okBtn.classList.add("modal-btn", "ok-btn");
			
			if(targetNode != document.body)
				screen.style.position = "absolute";
				
			okBtn.innerText = okBtnText;
			cancelBtn.innerText = cancelBtnText;
			okBtn.style.color = okBtnTextColor;
			cancelBtn.style.color = cancelBtnTextColor;
			okBtn.style.backgroundColor = okBtnBackgroundColor;
			cancelBtn.style.backgroundColor = cancelBtnBackgroundColor;
			cancelBtn.dataset.action = "cancel";
			okBtn.dataset.action = "ok";
			
			if( typeof content == "string" )
				contentNode.insertAdjacentHTML("beforeend", content);
			else
				contentNode.insertAdjacentElement("beforeend", content);
			
			// 이벤트 ==================================================
			
			screen.addEventListener("transitionend", (e)=>{
				
				// 등장하고 이벤트 추가
				screen.addEventListener("click", (e)=>{
					if( removeOnBackgroundClick && 
							e.target.classList.contains("modal-box-container")){
						//console.log(e.target);
						if( autoClose )
							this.close();
						return resolve(this.result("cancel"));
					}
					if( e.target.classList.contains("modal-btn")){
						if( autoClose )
							this.close();
						switch(e.target.dataset.action){
							case "cancel":{
								return resolve(this.result("cancel"));
							}
							case "ok":{
								return resolve(this.result("ok"));
							}
							default:{
								return resolve(this.result("cancel"));
							}
						}
					}
				});
			});
			frame.classList.remove("d-none");
			
			
			// 조립 ===================================================
			
			if(!btnPositionChange){
				if( !cancelBtnHide )
					btnInner.insertAdjacentElement("afterbegin", cancelBtn);
				if( !okBtnHide )
				btnInner.insertAdjacentElement("beforeend", okBtn);
			} else {
				if( !okBtnHide )
					btnInner.insertAdjacentElement("afterbegin", okBtn);
				if( !cancelBtnHide )
					btnInner.insertAdjacentElement("beforeend", cancelBtn);
			}
			
			if(!footerHide){
				frame.insertAdjacentElement("beforeend", footer);
				footer.insertAdjacentElement("beforeend", btnInner);
			}
			
			frame.insertAdjacentElement("afterbegin", contentNode);
			screen.insertAdjacentElement("beforeend", frame);
			
			// 보여주기 =================================================
			document.body.classList.add("scroll-none");
			targetNode.insertAdjacentElement(position, screen);
			
			setTimeout(()=>{
				screen.classList.add("active");	
			});

			this.content = content;
			this.targetNode = targetNode;
			this.contentNode = contentNode;
			this.position = position;
			this.screen = screen;
			this.frame = frame;
			this.footer = footer;
			this.btnInner = btnInner;
			this.cancelBtn = cancelBtn;
			this.okBtn = okBtn;
			this.autoClose = autoClose;
		});
	}
	
	close(){
		document.body.classList.remove("scroll-none");
		this.screen.remove();
	}
	
	result(action){
		return {
			result: action,
			instance: this
		}
	}
	
	setContent(content){
		this.contentNode.innerHTML = "";
		this.contentNode.insertAdjacentHTML("beforeend", content);
	}

	get contentNode(){
		return this.contentNode;
	}

}

//export default ModalBox;

function getParameter(name) {
	name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),results = regex.exec(location.search);

	return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

function getParameters() {
	name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),results = regex.exec(location.search);

	return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));

// "&size=10&key=nickname&searchOption=contain&rule=7&value=a"
}

function MMddHHmm(date){
	let month = "" + (date.getMonth() + 1),
	day = "" + date.getDate(),
	hours = "" + date.getHours(),
	minutes = "" + date.getMinutes();

	if (month.length < 2)
	month = "0" + month;
	if (day.length < 2)
	day = "0" + day;
	if (hours.length < 2)
	hours = "0" + hours;
	if (minutes.length < 2)
	minutes = "0" + minutes;

	return `${month}-${day} ${hours}:${minutes}`;
}