<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="/css/data/detail.css" type="text/css" rel="stylesheet" />
<section class="main-container">
	<h1>동물 기본 상식</h1>
	  
     <div class="detail-box">
         <div class="detail-box-header">
             <h4 class="detail-tit">${n.title}</h4>
             <ul class="detail-list">
              	<li>#${n.cateName}</li>
                <li><fmt:formatDate value="${n.regDate}" pattern="yyyy-MM-dd" /></li>
                <li>조회수 ${n.hitCnt}</li>
             </ul>
         </div>   
         <div class="detail-box-body">
             ${n.content}
         </div> 
     </div>

    
     <div class="data-btn-box">
         <a href="information" class="main-button-m">목록</a>
     </div>
</section>
