<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="/css/report/list.css" type="text/css" rel="stylesheet" />
<script src ="/js/report/list.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<c:set var="page" value ="${param.p}"/>

<c:if test ="${empty page}"> <!-- null이거나 빈문자열일경우 -->
	<c:set var="page" value="1" />
</c:if>


<section class="main-container">
	<h1>반려동물실종신고</h1>
    <div class="report-search-box">
        <form class="report-search-form">
            <select name="f">
                <option value="title">제목</option>
                <option value="nickname">작성자</option>
            </select>
            <div class="search-input-group">
                <input type="text" name="q" value="${param.q}">
                <input type="submit" class="seach-btn" value="검색">
            </div>
        </form>
    </div>
    <div class="report-box">
        <ul class="report-list">
        	<c:forEach var="n" items="${list}">
            <li>
                <a href="${n.id}">
                    <div class="img-box" style="background-image:url('/upload/report/${n.id}/${n.files}')">
                    </div>
                    <div class="report-txt-box">
                        <h4 class="report-tit">${n.title}</h4>

                        <span class="report-add">(${n.location})</span>
                        <ol class="report-info">
                            <li>${n.nickname}</li>
                            <li><fmt:formatDate value="${n.regDate}" pattern="yyyy.MM.dd"/></li>
                            <li>댓글수 : ${n.commentCnt}</li>
                        </ol>
                    </div>
                </a>
            </li>
            </c:forEach>     
        </ul>
    </div>

    <div class="report-btn-box">
    	<a href="write" class="main-button-m">실종 신고</a>
    	<%-- <c:if test="${empty sessionScope.id }"> 
			<a href="#" class="main-button-m no-session-write-btn">실종 신고</a>
		</c:if>
		
		<c:if test="${sessionScope.id > 0}"> 
			<a href="write" class="main-button-m">실종 신고</a>
		</c:if> --%>
        
    </div>

    <c:set var="offset" value="${(page-1)%5}" />
	 <c:set var="startNum" value="${page-offset}" />
	 
	  <div class="pager-common mt30">
         <div class="pager">  
            <div class="prev mr15">
              	<c:if test ="${startNum > 1}">
            		<a class="btn btn-prev" href="?p=${startNum-5}&f=${param.f}&q=${param.q}">이전</a>
            	</c:if>
            	<c:if test="${startNum == 1}">                    
                    <span class="btn btn-prev"  onclick="alert('이전 페이지가 없습니다.');">이전</a>
                </c:if>    
            </div>  
            
           <ul class="btn-center">
               <c:forEach var="i" begin="0" end="4" varStatus="st">
                  <c:set var="current" value="" />
                  <c:if test="${i+startNum == page}">
                  	<c:set var="current" value="current"></c:set>
                  </c:if>
                  <c:if test="${i+startNum <= pageCount}">
                       <li class="${current}"><a class="bold " href="?p=${i+startNum}&f=${param.f}&q=${param.q}">${i+startNum}</a></li>
                  </c:if>
           	</c:forEach>  
           </ul>
             
             
      		 <div class="next">
                <c:if test="${startNum+5 <= pageCount}">
                    <a class="btn btn-next" href="?p=${startNum+5}&f=${param.f}&q=${param.q}">다음</a></span>
                 </c:if>
                 <c:if test="${startNum+5 > pageCount}">
                    <span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음 </span>                           
                 </c:if>
             </div>
             
   		</div>
 	</div>
	 
</section>
