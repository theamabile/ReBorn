<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<link href="/css/community/detail.css" type="text/css" rel="stylesheet" />

	<section class="main-container">
           <!--  <div class="major-subject mt20">
                <h1 class="major-subject-text bold">커뮤니케이션</h1>
            </div> -->
            <div class="wrapper" >
                <section class="article-header mt60">
                    <span class="category">category: <span>${b.category}</span></span> 
                    <span class="title bold">${b.title}</span>
                    <div class="write-info">
                        <span class="writer-id bar mr10">by ${b.nickname }</span> 
                        <span class="regdate bar mr10"> 
                        	<fmt:formatDate value="${b.regDate}" pattern="yyyy-MM-dd[E] a hh:mm:ss"/>
                        </span>
                        <a class="edit-btn bar mr10" href="${b.id}/edit">수정</a>
                        <a class="delete-btn" href="${b.id}/del">삭제</a>
                    </div>
                </section>                

                <section class="article-content mt50">
                    ${b.content}
                                       
                </section>

                <div class="reaction-info mt50">
                    <span>댓글 <span class="comment-count bold">1</span></span> 
                    <button class="like-btn" type="button">좋아요 <span class="like-img"></span></button>
                </div>
                
                <!-- 댓글 작성 -->
                <c:forEach items="${comment}" var="c" >
	                <div class="comment-view-box padding10 mt5">
	                    <div class="comment-info mt10">
	                        <span class="comment-id dot" >${c.memberId}</span>
	                        <span class="comment-regdate dot">
	                        	<fmt:formatDate value="${c.regDate}" pattern="yyyy.MM.dd[E] a hh:mm:ss"/>
	                        </span>
	                        <span class="comment-report"><a href="">신고</a></span>
	                    </div>
	                    <div class="comment-content mt10">
	                        ${c.content}
	                    </div>
	                    <a class="comment-reply" href="">답글</a>
	                </div>
                </c:forEach>
                

                <form method="post" action="" >
                    <div class="comment-form mt20">                                                   
                        <textarea name="comment" cols="" rows="4" placeholder="여러분의 소중한 댓글을 입력해주세요."></textarea>
                        <div class="submit mt20">
                            <button class="button" type="submit" onclick="addComment(this, 90); return false;">등록</button>
                        </div>
                    </div>
                </form>
                

            </div> <!-- wraaper end-->
        </section>

