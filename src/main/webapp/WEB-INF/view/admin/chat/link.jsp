<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <link rel= "stylesheet" type="text/css" href="/css/admin/chat/link.css">
  <link rel= "stylesheet" type="text/css" href="/css/style.css">
 <!--  <script src="/js/common.js"></script>-->
 <script src ="/js/admin/chat/link.js"></script> 
<section class="container">
<h1 class="d-none">채팅 링크 관리</h1>

	<!-- container-item클래스가 꽉 채워진 박스 기준이라 min-width만 설정해주기 위해 member-container를 같이 넣어줌-->
	<section class="container-item member-container">
		<h1>채팅 링크 관리</h1>
		
		<div class="chat-cover">
			<ul class="link-list">
				<c:forEach var="n" items="${linkList}">
				<li>
					<dl>
						<dt>${n.title}<dt>
						<dd>
							<a href="${n.address}">
							${n.address}
							</a>
						</dd>
					</dl>	
					<a href="#" class="del-btn" data-link="${n.id}"><i class="fas fa-minus-circle"></i></a>
				</li>
				</c:forEach>

			</ul>
			<div class="link-add-box">
				<input class="link-tit" name="title" placeholder="링크 타이틀">
				<input class="link-addr" name="address" placeholder="링크 주소">
				<a href="" class="link-add-btn"><i class="fas fa-plus-circle"></i></a>
			</div>
		</div>
	</section>
</section>
