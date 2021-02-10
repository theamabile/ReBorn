<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- <link rel= "stylesheet" type="text/css" href="/css/admin/chat/list.css"> --> 
<script src="https://cdn.ckeditor.com/ckeditor5/25.0.0/classic/ckeditor.js"></script>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/Base64/1.1.0/base64.min.js" integrity="sha512-gysqkfMGKYvQSEPi68aIzL4ffmrQ0I6azOoPJ+ocle8k1bblsHJh7QVVoy4HHQG2iPzvFmRbs81d8kkVSyCkjA==" crossorigin="anonymous"></script>
 -->
<section class="container">
<h1 class="d-none">정보 관리</h1>

	<!-- container-item클래스가 꽉 채워진 박스 기준이라 min-width만 설정해주기 위해 member-container를 같이 넣어줌-->
	<section class="container-item member-container">
		<h1>동물 기본상식 쓰기</h1>
		
		
		<form class="form-box" method="post" action="/admin/data/write">
			<div class="form-each">
				<input type="text" name="title"  placeholder="제목을 입력해주세요."> 
			</div>
			<div class="form-each">
				<select name ="category">
					<option value ="1">강아지</option>	
					<option value ="2">고양이</option>	
					<option value ="3">기타</option>	
				</select>
			</div>
			
			
			<div class="edit-btn-box">
				<a class="edit-btn img-attach-btn">이미지 삽입</a>
				<input class="attch-btn" type="file" id="file">
			</div>	
			<input name="content" type="hide" class="hidden-value"></input>
			<div id="editor" contenteditable="true" ></div >
		</form>
		
		<div class="btn-box">
         	<a href="#" class="main-button-m form-btn">전송</a>
     	</div>
		
		
	</section>
</section>


 <script>
 	window.addEventListener('load', ()=>{
 		let editor = document.querySelector('#editor');
 		let attchBtn = document.querySelector('.attch-btn');
 		let hiddenValue = document.querySelector('.hidden-value');
 		let imgAttchBtn = document.querySelector('.img-attach-btn');
 		let formBtn = document.querySelector('.form-btn');
 		let formBox = document.querySelector('.form-box');
 		
 		formBtn.addEventListener('click', (e)=>{
 			e.preventDefault();
 			let content = editor.innerHTML;
 			hiddenValue.value = content;
 			hiddenValue.innerHTML = content;
 			console.log(hiddenValue.value);
 			formBox.method="POST";
			formBox.submit();
 		
 		})
 		
 		imgAttchBtn.addEventListener('click', (e)=>{
 			e.preventDefault();
 			
 			let event = new MouseEvent('click', {
		        'view':window,
		        'bubbles': true,
		        'cancelable': true
		    });
    		attchBtn.dispatchEvent(event);
 		});
 		
 		attchBtn.addEventListener("change",()=>{
 			let path;
 			let formData = new FormData();
 			let file = attchBtn.files;
 			formData.append('imageFile', attchBtn.files[0]);
 			console.log(file);
 			fetch(`/api/admin/data/upload`,{
				body: formData,
				headers: {
				//'Content-Type': 'multipart/form-data'
				},
				method:'POST',
			})
			.then((result)=>
				result.text()
			)
			.then((pathUrl)=>{
				path = pathUrl;
				console.log(path);
				insertImg(path);
			})
			
			
	
 		});
 	})
 	
 	
 	
 	function insertImg(path){
 		let editor = document.querySelector('#editor');
 		editor.focus();
 		
		let sel = window.getSelection();
		let range = sel.getRangeAt(0);			
		
		if(range.startContainer.parentElement == editor || sel.focusNode.parentElement){
			let startNode = range.startContainer;
			let startOffset = range.startOffset;
			console.log(range)
			
			//let insertNode = `<img scr=""></img>`; //document.createElement('img');	// img 객체 생성
			//range.insertAdjacentHTML('beforeend', insertNode)
			let insertNode = document.createElement('img');
			insertNode.setAttribute("src",path)
			range.insertNode(insertNode);
			console.log(range);
			range.setStartAfter(insertNode);
	    	editor.focus();
		}
		
}
  
</script>

<style>
.hidden-value{display:none;}
.form-each {display:flex;}
.form-each input {width:100%; padding:0 10px;}
.form-each {margin-bottom:10px;}
.form-each  select {width:100%; padding:0 10px;}
#editor {display:block; height:400px; border:1px solid #ddd; font-size:14px; padding:20px; overflow-y:auto;}
#editor img {display:block; width:350px; border:1px solid #ddd;}
#editor > * {margin-bottom:10px;}
.edit-btn-box {margin-bottom:5px;}
.edit-btn {display:block; text-align:center; color:#fff; border-radius:5px; height:34px; line-height:34px; background:var(--main); padding:0 14px; cursor:pointer;}
.attch-btn {display:none;}
.btn-box {margin-top:20px; display: flex; justify-content: flex-end;}
.form-btn {display:inline-block; line-height:40px; text-align:center }


/* .ck-rounded-corners .ck.ck-editor__main>.ck-editor__editable, .ck.ck-editor__main>.ck-editor__editable.ck-rounded-corners{ height:350px}
.ck-editor h2:after {content:none;}
.ck-editor h3:after {content:none;}
.ck-editor h4:after {content:none;}
.ck-editor strong {font-weight:bold;}

.ck-editor ol {
	list-style:decimal;
	box-sizing:border-box;
	padding-left:20px;
} 
.ck-editor ul {
	list-style:disc;
	padding-left:20px;
	box-sizing:border-box;
} */
</style>
