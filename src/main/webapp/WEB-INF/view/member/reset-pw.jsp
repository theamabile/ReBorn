<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="/js/member/resetPw.js" type="text/javascript"></script>

<section class="reset-pw">
	<form action="update-pw" method="post">
		<div class="logo"></div>
		<div class="container">
			<span class="title">패스워드 재설정</span>
			<div class="users input-icon">
				<i class="fas fa-users"></i>
			</div>
			<input type="text" name="loginId"class="id input"
				value="${session.resetPwdId}" readonly> <span class="result d-none">숫자,
				영문, 특수문자를 조합한 8자리 이상의 문자를 입력하세요.</span>
			<div class="key input-icon">
				<i class="fas fa-key"></i>
			</div>
			<input type="text" class="pw-input input" placeholder="패스워드">
			<div class="key2 input-icon">
				<i class="fas fa-key"></i>
			</div>
			<input type="text" name="password" class="pw-confirm input" placeholder="패스워드 확인">
			<input type="submit" value="확인" class="button sing-btn disabled">
		</div>
	</form>
</section>