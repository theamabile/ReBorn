<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="/css/report/list.css" type="text/css" rel="stylesheet" />
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
    </div>

    <c:set var="offset" value="${(page-1)%5}" />
	 <c:set var="startNum" value="${page-offset}" />
	 
    <div class="">
            <ul class="">
            
            	<!-- 이전 페이지 -->
                <c:if test ="${startNum > 1}">
                	<li><a href="?p=${startNum+5}&f=${param.f}&q=${param.q}">&lt;</a></li>
				</c:if>
				<c:if test ="${startNum == 1}">
					 <li onclick="alert('이전 페이지가 없습니다.');"><a href="#">&lt;</a></li>
				</c:if>
				<!-- //이전 페이지 -->
				
				<!-- 페이지 번호 -->
                <c:forEach var="i" begin="0" end="4" varStatus="st">
                	<c:if test ="${i+startNum <= pageCount}">
                		<li class="active"><a href="?p=${i+startNum}&f=${param.f}&q=${param.q}">${i+startNum}</a></li>
                	</c:if>
                </c:forEach>
                <!-- //페이지 번호 -->
                
                <!-- 다음 페이지 -->
                <c:if test ="${startNum + 5 <= pageCount}">
                	 <li><a href="?p=${startNum+5}&f=${param.f}&q=${param.q}">&gt;</a></li>
				</c:if>
				<c:if test ="${startNum + 5 > pageCount}">
					 <li onclick="alert('다음 페이지가 없습니다.');"><a href="#">&gt;</a></li>
				</c:if>
				<!-- //다음 페이지 -->
                
            </ul>
        </div>
</section>
