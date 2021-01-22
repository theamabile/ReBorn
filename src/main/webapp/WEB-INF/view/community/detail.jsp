<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<link href="/css/community/list.css" type="text/css" rel="stylesheet" />

	<section class="main-container">
           <!--  <div class="major-subject mt20">
                <h1 class="major-subject-text bold">커뮤니케이션</h1>
            </div> -->
            <div class="wrapper" >
                <section class="article-header mt60">
                    <span class="category">category: <span>입양후기</span></span> 
                    <span class="title bold">아닌 것</span>
                    <div class="write-info">
                        <span class="writer-id bar mr10">by 워니</span> 
                        <span class="regdate bar mr10"> 2020.01.01 13:12</span>
                        <a class="edit-btn bar mr10" href="">수정</a>
                        <a class="delete-btn" href="">삭제</a>
                    </div>
                </section>                

                <section class="article-content mt50">
                    아닌 것 <br><br>
                    당신의 나이는 당신이 아니다.<br>
                    당신이 입는 옷의 크기도,        <br>            
                    몸무게나, 머리 색깔도 당신이 아니다.                 <br>
                    당신의 이름도, <br>
                    두 뺨의 보조개도 당신이 아니다.<br>
                    당신은 당신이 읽은 모든책이고,<br>
                    당신이 하는 모든 말이다.<br>
                    당신은 아침의 잠긴 목소리이고,<br>
                    당신이 미처 감추지 못한 미소이다.<br>
                    당신은 당신 웃음 속의 사랑스러움이고,<br>
                    당신이 흘린 모든 눈물이다.<br>
                    당신이 철저히 혼자라는 걸 알 때,<br>
                    당신이 목청껏 부르는 노래,<br>
                    당신이 여행한 장소들,<br>
                    당신이 안식처라고 부르는 곳이 당신이다.<br>
                    당신은 당신이 믿는 것들이고,<br>
                    당신이 사랑하는 사람들이며,<br>
                    당신 방에 걸린 사진들이고,<br>
                    당신이 꿈꾸는 미래이다.<br>
                    당신은 많은 아름다운 것들로 이루어져 있지만<br>
                    당신은 잊은 것 같다.<br>
                    당신 아닌 그 모든 것들로<br>
                    자신을 정의하기로 결정하는 순간에는...<br> - 에릭핸슨 -<br>
                   
                </section>

                <div class="reaction-info mt50">
                    <span>댓글 <span class="comment-count bold">1</span></span> 
                    <button class="like-btn" type="button">좋아요 <span class="like-img"></span></button>
                </div>
                
                <div class="comment-view-box padding10 mt5">
                    <div class="comment-info mt10">
                        <span class="comment-id dot" >꼬맹이</span>
                        <span class="comment-regdate dot">20.01.01 09:05</span>
                        <span class="comment-report"><a href="">신고</a></span>
                    </div>
                    <div class="comment-content mt10">
                        정말 귀여워요~!
                    </div>
                    <a class="comment-reply" href="">답글</a>
                </div>
                

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

