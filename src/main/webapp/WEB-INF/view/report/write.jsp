<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="/css/report/write.css" type="text/css" rel="stylesheet" />

<section class="main-container">
	<h1>반려동물실종신고</h1>
    <div class="data-table-box">
        <form action="" class="data-table-form">
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
                                <input type="text" placeholder="제목을 입력해주세요.">
                            </div>
                        </td>
                    </tr> 
                    <tr>
                        <th>실종 일자</th>
                        <td>
                            <div class="data-table-form">
                                <input type="date">
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <th>실종 장소</th>
                        <td>
                            <div class="data-table-form">
                                <input type="text" placeholder="ex) 서울시 마포구 연남동 성산중학교 앞">
                            </div>
                        </td>
                    </tr>

                                    
                    <tr>
                        <th>품종</th>
                        <td>
                            <div class="data-table-form">
                                <input type="text" placeholder="ex)믹스견입니다."">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>특징</th>
                        <td>
                            <div class="data-table-form">
                                <input type="text" placeholder="ex) 털이 갈색이고 눈색이 갈색이입니다.">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>첨부파일</th>
                        <td>
                            <div class="attach-box-list">
                                <div class="attach-box">
                                    <input class="attach-input" type="file" name="file" accept="image/*">
                                    <div class="attach-box-inner">
                                        <button class="attach-btn" type="button" onclick ="fileInputClick();">파일선택</button>
                                        <input class="attach-read" type="text" title="첨부파일명 보기" readonly value="파일명">
                                        <button class="attach-cancel-btn" type="button" onclick="fileInputDel();">삭제</button>
                                    </div>
                                </div>
                            </div>
                            <button class="file-form-add" href="#">추가</button>                           
                        </td>
                    </tr>
                    
                    <tr>
                        <th>내용</th>
                        <td>
                            <textarea  class="data-table-textarea" class="" name="" id=""></textarea>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </div>
   
    <div class="data-btn-box">
        <a href="#" class="main-button-m">작성</a>
        <a href="#" class="gray-button-m">취소</a>
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
         let fileEmpty = false;
         attachInput.forEach((item) =>{
             console.log(item.value);
             if(item.value.length == 0){
                 alert("첨부파일이 비어있는 곳이 있습니다. 비어 있는 곳을 먼저 채워주세요.");
                 fileEmpty = true;
                 return;
             }
         })
         //파일 폼 추가
         if(fileEmpty == false){
             fileFormAdd.insertAdjacentHTML('beforebegin',fileFormTemp);
         }
     })                    
 })
 
 
 
 </script>	