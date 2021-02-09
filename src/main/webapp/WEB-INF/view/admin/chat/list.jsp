<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <link rel= "stylesheet" type="text/css" href="/css/admin/chat/list.css">
 <script src ="/js/admin/chat/list.js"></script>
<section class="container">
<h1 class="d-none">채팅관리</h1>

	<!-- container-item클래스가 꽉 채워진 박스 기준이라 min-width만 설정해주기 위해 member-container를 같이 넣어줌-->
	<section class="container-item member-container">
		<h1>채팅 관리</h1>
		
		<div class="chat-cover">

				<ul class="room-list">
				<c:forEach var="n" items="${roomList}">
					<li>
						<a href="#" data-room=${n}>
							${n}번방
						</a>
					</li>
				</c:forEach>	
				</ul>
				<div class="chat-room">
					<div class="dialog-box">
					<ul>
						 <li class="left">
		                      <span class="thumb">Q</span>
		                      <p class="chat-con">Hi~</p>
		                  </li>
		                  <li class="right">
		                      <span class="thumb">A</span>
		                      <p class="chat-con">Helldssddsadfellddsddsadelld<br>ssddsadelldssddsad~</p>
		                  </li>
					</ul>
					</div>
					<div class="chat-input-box">
			             <form class="chat-input-form" action="">
			                 <input type="text" class="chat-input">
			                 <a href="#" class="chat-send-btn">전송</a>
			             </form>
			        </div>
				</div>
		</div>
	</section>
</section>