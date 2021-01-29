<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="/css/data/information.css" type="text/css" rel="stylesheet" />    
<script src="/js/data/information.js"></script>	

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

        <ul class="info-tab-list">
        	<li class="${cate==1?'active':''}"><a href="#" data-category="1">공통</a></li>
            <li class="${cate==2?'active':''}"><a href="#" data-category="2"">강아지</a></li>
            <li class="${cate==3?'active':''}"><a href="#" data-category="3"">고양이</a></li>
            <li class="${cate==4?'active':''}"><a href="#" data-category="4">기타</a></li>
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
	 
	 
    <div class="pager-common mt30">
         <div class="pager">  
            <div class="prev mr15">
              	<c:if test ="${startNum > 1}">
            		<a class="btn btn-prev" href="?p=${startNum-5}&categroy=${param.categroy}">이전</a>
            	</c:if>
            	<c:if test="${startNum == 1}">                    
                    <span class="btn btn-prev">이전</a>
                </c:if>    
            </div>  
           <ul class="btn-center">
                  <c:forEach var="i" begin="0" end="4" varStatus="st">
                  <c:set var="current" value="" />
                  <c:if test="${i+startNum == page}">
                  <c:set var="current" value="current"></c:set>
                  </c:if>
                  <c:if test="${i+startNum <= pageCount}">
                       <li class="${current}"><a class="bold " href="#">${i+startNum}</a></li>
                  </c:if>
             	</c:forEach>  
             </ul>
      		 <div class="next">
                <c:if test="${startNum+5 <= pageCount}">
                    <a class="btn btn-next" href="?p=${startNum+5}&categroy=${param.categroy}"></a>다음</span>
                 </c:if>
                 <c:if test="${startNum+5 > pageCount}">
                    <span class="btn btn-next">다음 </span>                           
                 </c:if>
             </div>
   		</div>
 	</div>
    
    
    
    
    
    <br/>
        <br/>
            <br/>
                <br/>
                    <br/>
                        <br/>
    
     <c:set var="offset" value="${(page-1)%5}" />
	 <c:set var="startNum" value="${page-offset}" />
	 
    <div class="">
    	<!-- 이전 페이지 -->
                <c:if test ="${startNum > 1}">
                	 <a href="?p=${startNum-5}&categroy=${param.categroy}">&lt;</a>
				</c:if>
				<c:if test ="${startNum == 1}">
					<a href="#" onclick="alert('이전 페이지가 없습니다.');">&lt;</a>
				</c:if>
				<!-- //이전 페이지 -->
				
            <ul class="pager">
				<!-- 페이지 번호 -->
                <c:forEach var="i" begin="0" end="4" varStatus="st">
                	<c:if test ="${i+startNum <= pageCount}">
                		<li class="active"><a href="?p=${i+startNum}&categroy=${param.categroy}">${startNum + i}</a></li>
                	</c:if>
                </c:forEach>
                <!-- //페이지 번호 -->

            </ul>
            
            	  <!-- 다음 페이지 -->
                <c:if test ="${startNum + 5 <= pageCount}">
                	<a href="?p=${startNum+5}&categroy=${param.categroy}">&gt;</a>
				</c:if>
				<c:if test ="${startNum + 5 > pageCount}">
					<a href="#" onclick="alert('다음 페이지가 없습니다.');">&gt;</a>
				</c:if>
				<!-- //다음 페이지 -->
        </div>
        
</section>
