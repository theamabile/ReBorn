<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="/js/member/findPw.js" type="text/javascript"></script>

<section class="find-pw">
	<form action="dddd" method="post" class="form">
		<div class="logo"></div>
		<div class="container">
			<div class="checkboxs">
				<div class="checkbox">
					<input type="radio" name="type" checked> <span class="">회원
						정보에 등록된 휴대전화로 인증하기</span>
				</div>
				<div class="checkbox">
					<input type="radio" name="type"> <span class="">회원
						정보에 등록된 이메일로 인증하기</span>
				</div>
			</div>

			<div class="users input-icon">
				<i class="fas fa-users"></i>
			</div>
			<input type="text" class="id-input input" placeholder="아이디">
			<span class="result d-none">등록된 회원 정보가 없습니다.</span>
			<div class="name input-icon">
				<i class="fas fa-user-alt"></i>
			</div>
			<input type="text" class="name-input input" placeholder="이름">
			<div class="confirm-type ">
				<div class="phone input-icon">
					<i class="fas fa-mobile-alt"></i>
				</div>
				<input type="text" class="phone-input input"
					placeholder="01012341234">
			</div>
			<div class="confirm-type d-none">
				<div class="envelope input-icon">
					<i class="fas fa-envelope"></i>
				</div>
				<input type="text" class="email-input input"
					placeholder="example@reborn.com">
			</div>
			<div class="confirm">
				<input type="text" class="confirm-input " placeholder="인증번호 6자리">
				<input type="button" value="인증번호받기" class="confirm-btn">
			</div>
			<input type="submit" value="sign in" class="button sing-btn disabled">
		</div>
	</form>
</section>