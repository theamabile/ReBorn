<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<section class="find-id-result">
	<div class="logo"></div>
	<div class="container">
		<span class="title">고객님의 정보와 일치하는 아이디입니다.</span>
		<div class="users input-icon">
			<i class="fas fa-users"></i>
		</div>
		<input type="text" class="loginId input" placeholder="아이디" value="${param.loginId}" readonly><a href="./login"> <input
			type="button" value="sign up" class="button able"></a>
	</div>
</section>