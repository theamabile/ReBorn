<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="/js/member/findId.js" type="text/javascript"></script>

<section class="find-id">
	<form action="dddd" method="post">
		<div class="logo"></div>
		<div class="container">
			<span class="title">등록된 이메일로 아이디 찾기</span>
			<div class="envelope input-icon">
				<i class="fas fa-envelope"></i>
			</div>
			<input type="text" class="email input" placeholder="이메일">
			<div class="name input-icon">
				<i class="fas fa-user-alt"></i>
			</div>
			<input type="text" class="name-input input" placeholder="이름">

			<span class="result d-none">등록된 회원 정보가 없습니다.</span> <input
				type="submit" value="확인" class="button disabled">
			<div class="join-nav">
				<label for="">계정이 없으신가요?</label> <a href="info/join">회원가입</a>
			</div>
		</div>
	</form>
</section>