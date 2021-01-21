<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- <link href="/css/community/community-style.css" type="text/css" rel="stylesheet" /> -->
<link href="/css/community/list.css" type="text/css" rel="stylesheet" />

<%-- <c:set var ="page" value="${param.p}" />
<c:if test = "${empty param.p}">
	<c:set var = "page" value="1" />
</c:if>	

<c:set var="offset" value="${(page-1)%5}"> </c:set>
<c:set var="startNum" value="${page-offset}"> </c:set>
<div>
	offset: ${offset} </br>
	startNum: ${startNum} </br>
	param.p: ${param.p}
</div> --%>

	<section class="main-container">
            <!-- <div class="major-subject mt20">
                <h1 class="major-subject-text bold">커뮤니케이션</h1>
            </div> -->
            <div class="wrapper">
                <div class="align-wrap">
                    <div class="align mt60">
                        <h2 class="hidden">게시판 정렬폼</h2>
                        <form class="category-align">
                            <fieldset>
                                <legend class="hidden">카테고리 정렬 필드</legend>
                                <select class="select-box" name="c">
                                    <option>카테고리</option>
                                    <option value="question">질문</option>
                                    <option value="post">입양후기</option>
                                    <option value="dog">우리집 멍이</option>
                                    <option value="cat">우리집 냥이</option>
                                </select>
                            </fieldset>
                        </form>
                        <form class="view-align">
                            <fieldset>
                                <legend class="hidden">View 정렬 필드</legend>
                                <select class="select-box" name="v">
                                    <option>보기</option>
                                    <option value="ten">10개씩</option>
                                    <option value="fifteen">15개씩</option>
                                    <option value="thirty">30개씩</option>                            
                                </select>
                            </fieldset>
                        </form>
                    </div>
                </div>    
                <div class="list-common mt30">
                    <h2 class="hidden">목록</h2>
                    <ul>
                    	<c:forEach var="n" items="${list}">
	                        <li class="list-article mt20">
	                            <a class="list-link" href="">
	                                <div class="post-content has-image">
	                                    <strong class="subject bold">${n.title}</strong>
	                                    <div class="content mt10">${n.content}
	                                    </div>    
	                                    <span class="meta pt15">
	                                        <span class="name-txt">댓글 </span>
	                                        <span class="num-txt dot bold">${n.comment} </span>
	                                        <span class="name-txt">좋아요 </span>
	                                        <span class="num-txt dot bold">${n.like}</span>
	                                        <span class="hit">조회수</span>
	                                        <span class="num-txt bold">${n.hitCnt}</span>
	                                        <span class="ico">by</span>
	                                        <span class="num-txt bold">${n.nickname}</span>
	                                    </span>
	                                </div>
	                                <div class="post-image">
	                                    <img src="/images/community/dog.png" alt="">
	                                </div>
	                            </a>
	                        </li>
                        </c:forEach>                       
                    </ul>
                </div>
                <div class="write-common pt15">                
                    <div><span class="text-red bold">1</span> / 1 pages</div>
                    <input class="button bold" type="button" value="글쓰기">
                </div>
            </div> <!-- wrapper -->
            <div class="pager-common mt30">
                <div class="pager">
                    <div class="prev mr15">
                        <span class="btn btn-prev">이전</span>
                    </div>
                    <ul class="btn-center">
                        <li class="current"><a class="bold " href="">1</a></li>
                        <li><a class="bold " href="">2</a></li>
                        <li><a class="bold " href="">3</a></li>
                        <li><a class="bold " href="">4</a></li>
                        <li><a class="bold " href="">5</a></li>
                      
                    </ul>
                    <div class="next">
                        <span class="btn btn-next">다음</span>
                    </div>
                </div>
                <div class="search-form mt20"> 
                    <h2 class="hidden">커뮤니케이션 검색폼</h2>    
                    <form action="">
                        <fieldset>
                            <legend class="hidden">검색필드</legend>
                            <label class="hidden">검색분류</label>
                            <select class="search-select" name="s">
                                <option value="title">제목</option>
                                <option value="writerId">작성자</option>
                            </select>
                            <label class="hidden">검색어</label>
                            <input class="input-text"  type="text" name="q" value="${param.q}"/>
                            <input class="btn btn-search" type="submit" value="검색" />
                        </fieldset>
                    </form>
                </div>
            </div>
        </section>
