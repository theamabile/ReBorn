<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="/css/data/information.css" type="text/css" rel="stylesheet" />    


<c:set var="page" value ="${param.p}"/>
<c:set var="cate" value ="${param.categroy}"/>
<!-- null이거나 빈문자열일경우 -->
<c:if test ="${empty page}"> 
	<c:set var="page" value="1" />
</c:if>
<c:if test ="${empty cate}"> 
	<c:set var="cate" value="1" />
</c:if>


<section class="main-container">
	<h1>동물 기본 상식</h1>
	<div class="info-tab">

        <ul>
        	<li class="${cate==1?'active':''}"><a href="./information?p=1&categroy=1">공통</a></li>
            <li class="${cate==2?'active':''}"><a href="./information?p=1&categroy=2">강아지</a></li>
            <li class="${cate==3?'active':''}"><a href="./information?p=1&categroy=3">고양이</a></li>
            <li class="${cate==4?'active':''}"><a href="./information?p=1&categroy=4">기타</a></li>
        </ul>
    </div>
    <div class="info-board">
        <ul>

        	<c:forEach var="n" items="${list}">
             <li>
             	<c:out value="${imgUrlList[5]}"/>
            	 <c:set var="imgurl" value=""/>
            	 <c:forEach var="url" items="${imgUrlList}">
            		<c:if test="${url.key == n.id}">
            			<c:set var="imgurl" value="${url.value}"/>
            		</c:if>
                 </c:forEach>
            	 <div class="info-img-box" style="background-image:url('${imgurl}')"></div>
            		
                 <div class="info-txt-box">
                     <ul class="info-ex">
                         <li>#${n.cateName}</li>
                         <li><fmt:formatDate value="${n.regDate}" pattern="yyyy-MM-dd" /></li>
                         <li>조회수 ${n.hitCnt}</li>
                     </ul>
                     <a href ="${n.id}">
                         <h4 class="info-tit">${n.title}</h4>
                         <p class="info-txt">
                          ${n.content}
                         </p>
                     </a>
                 </div>
             </li>
            </c:forEach>
         </ul>
    </div>
    
    
    
     <c:set var="offset" value="${(page-1)%5}" />
	 <c:set var="startNum" value="${page-offset}" />
	 
    <div class="">
            <ul class="">
            
            	<!-- 이전 페이지 -->
                <c:if test ="${startNum > 1}">
                	 <li><a href="?p=${startNum+5}&categroy=${param.categroy}">&lt;</a></li>
					<a class="btn btn-next" href="?p=${startNum-5}&f=${param.f}&q=${param.q}">다음</a>
				</c:if>
				<c:if test ="${startNum == 1}">
					 <li onclick="alert('이전 페이지가 없습니다.');"><a href="#">&lt;</a></li>
				</c:if>
				<!-- //이전 페이지 -->
				
				<!-- 페이지 번호 -->
                <c:forEach var="i" begin="0" end="4" varStatus="st">
                	<c:if test ="${i+startNum <= pageCount}">
                		<li class="active"><a href="?p=${i+startNum}&categroy=${param.categroy}">${startNum + i}</a></li>
                	</c:if>
                </c:forEach>
                <!-- //페이지 번호 -->
                
                <!-- 다음 페이지 -->
                <c:if test ="${startNum + 5 <= pageCount}">
                	 <li><a href="?p=${startNum+5}&categroy=${param.categroy}">&gt;</a></li>
					<a class="btn btn-next" href="?p=${startNum+5}&f=${param.f}&q=${param.q}">다음</a>
				</c:if>
				<c:if test ="${startNum + 5 > pageCount}">
					 <li onclick="alert('다음 페이지가 없습니다.');"><a href="#">&gt;</a></li>
				</c:if>
				<!-- //다음 페이지 -->
               
            </ul>
        </div>
</section>
