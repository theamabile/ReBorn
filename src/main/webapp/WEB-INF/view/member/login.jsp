<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <meta name="google-signin-scope" content="profile email">
   
 <meta name = "google-signin-client_id"content = "940821641812-lgdg43tp56op0j8umnf7qm3gl8kjneok.apps.googleusercontent.com">

<script src="https://apis.google.com/js/platform.js" async defer></script>
  <script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>

   <section class="login">
        <div class="logo"></div>
        <div class="container">
            <span class="title">Reborn에 오신 것을 환영합니다</span>
            <div class="users input-icon">
            <i class="fas fa-users"></i>
            </div>
            <input type="text" class="id input" placeholder="아이디"  pattern=" /^[A-za-z][A-za-z0-9]{5,13}$/">
            <div class="key input-icon">
                <i class="fas fa-key"></i>
            </div>
            <input type="text" class="password input"placeholder="패스워드">
            <div class="find-info">
                <a href="find-id">아이디 찾기</a>/
                <a href="find-pw">비밀번호 재설정</a>
            </div>
            <nav class="button-nav">
                <input class="sign-in button" type="button" value="sign in">
                <input id="kakao-login-btn" class="button" type="button">
            </nav>
            <div class="join-nav">
                <label for="">계정이 없으신가요?</label>
                <a href="info/join">회원가입</a>
            </div>
        </div>
    </section>
