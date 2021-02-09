<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    

<link href="/css/report/edit.css" type="text/css" rel="stylesheet" />

<section class="main-container">
	<h1>반려동물 실종 신고 수정</h1>
      <div class="data-table-box">
        <form action="/report/${missingView.id}/edit" enctype="multipart/form-data" method="POST" class="data-table-form">
            <table class="data-table">
                <colgroup>
                    <col style="width:200px;">
                    <col style="width:auto;">
                </colgroup>
                <tbody>
                    <tr>
                        <th>제목</th>
                        <td>
                            <div class="data-table-form">
                                <input type="text" name="title" placeholder="제목을 입력해주세요." value="${missingView.title}">
                            </div>
                        </td>
                    </tr> 
                    <tr>
                        <th>실종 일자</th>
                        <td>
                            <div class="data-table-form">
                                <input name="missing-date" type="date" value="<fmt:formatDate value="${missingView.missingDate}" pattern="yyyy-MM-dd"/>">
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <th>실종 장소</th>
                        <td>
                            <div class="data-table-form">
                                <input type="text" name="location" placeholder="ex) 서울시 마포구 연남동 성산중학교 앞" value="${missingView.location}">
                            </div>
                        </td>
                    </tr>

                                    
                    <tr>
                        <th>품종</th>
                        <td>
                            <div class="data-table-form">
                                <input type="text" name="breed" placeholder="ex)믹스견입니다." value="${missingView.breed}">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>특징</th>
                        <td>
                            <div class="data-table-form">
                                <input type="text" name="feature" placeholder="ex) 털이 갈색이고 눈색이 갈색이입니다." value="${missingView.feature}">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>첨부파일</th>
                        <td>
                            <div class="attach-box-list">
                            	<c:if test="${not empty missingView.files}">
                            		<c:forEach items="${fn:split(missingView.files, ',') }" var="item">
		                                <div class="attach-box">
		                                	
		                                    <div class="attach-box-inner">
		                                    	<input class="attach-read" type="text" title="첨부파일명 보기" readonly name="at-name" value="${item}">
		                                        <button class="attach-cancel-btn" type="button" onclick="fileInputDel();">삭제</button>
		                                    </div>
			                                  
		                                </div>
		                            </c:forEach>
		                        </c:if>
                            </div>
                            <button class="file-form-add" href="#">추가</button>                           
                        </td>
                    </tr>
                    
                    <tr>
                        <th>내용</th>
                        <td>
                            <textarea  class="data-table-textarea" class="" name="content" id="">${missingView.content}</textarea>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </div>
    <div class="data-btn-box">
    	<a href="#" class="gray-button-m del-btn">삭제</a>
        <a href="#" class="main-button-m edit-btn">수정</a>
        <a href="/report/${missingView.id}" class="gray-button-m">취소</a>
    </div>
</section>

<script>
//첨부파일
function fileInputClick(){
    let e = this.event.target;
    let fileInput = e.parentElement.previousElementSibling;
    console.log(fileInput)
    const fileTrigger = new MouseEvent('click', {
        view: window,
        bubbles: true,
        cancelable: true
    });

    fileInput.dispatchEvent(fileTrigger);
    fileInput.addEventListener('change', (e)=>{
    let fileTxt = fileInput.value;
    let fileTxtIndex = fileTxt.lastIndexOf("\\")+1;
    fileTxt = fileTxt.slice(fileTxtIndex);
    let fileReadTxt =  e.target.nextElementSibling.querySelector('.attach-read');
    fileReadTxt.value=fileTxt;   
    console.log(fileInput.value)
    });
 }




//첨부파일 삭제
function fileInputDel(){
    let e = this.event.target;
    e.closest('.attach-box').remove();
}


//추가버튼
window.addEventListener('load', ()=>{
    //첨부 파일 템플릿 추가
    let fileFormAdd = document.querySelector('.file-form-add');
    let fileFormTemp = '<div class="attach-box">\
                            <input class="attach-input" type="file"  name="file" accept="image/*">\
                            <div class="attach-box-inner">\
                                <button class="attach-btn" type="button" onclick ="fileInputClick();">파일선택</button>\
                                <input class="attach-read" type="text" title="첨부파일명 보기" readonly value="">\
                                <button class="attach-cancel-btn" type="button" onclick="fileInputDel();">삭제</button>\
                            </div>\
                        </div>';
                         
                         
     fileFormAdd.addEventListener('click', (e)=>{
         e.preventDefault();
         //파일 폼 비었는지 확인
         let attachInput = document.querySelectorAll('.attach-input');
         let attachList = document.querySelector('.attach-box-list');
         let fileEmpty = false;
         attachInput.forEach((item) =>{
             console.log(item.value);
             if(item.value.length == 0){
           
                 let modelBox = new ModalBox({
             		content:`첨부파일이 비어있는 곳이 있습니다.<br/>비어 있는 곳을 먼저 채워주세요.`,
             		cancelBtnHide:true
             	 })
             	
                 fileEmpty = true;
                 return;
             }
         })
         //파일 폼 추가
         if(fileEmpty == false){
              attachList.insertAdjacentHTML('beforeend',fileFormTemp);
         }
     })      
     
     
     
     let editBtn = document.querySelector('.edit-btn');
     let dataForm = document.querySelector('.data-table-form');     
     editBtn.addEventListener('click', (e)=>{
     	 e.preventDefault();
     	 dataForm.method="POST";
		 dataForm.submit();
     });
     
     
     //삭제
     let delBtn = document.querySelector('.del-btn');
	 delBtn.addEventListener('click', (e)=>{
	 	console.log("a");
	 	 e.preventDefault();
	 	 
           let modelBox = new ModalBox({
       		content:`정말로 삭제하시겠습니까?<br/> 삭제하면 복구할 수 없습니다.`,
       	  })
       	  .then((resolve)=>{
			if(resolve.result == "ok"){
				window.location.href ="./delete";
			}else{
				
			}
		});
       	 
	 });     
 })
 </script>	