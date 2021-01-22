<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section class="find-pw">
        <div class="logo"></div>
        <div class="container">
            <div class="checkboxs">
                <div class="checkbox">
                    <input type="checkbox" checked>
                    <span class="">회원 정보에 등록된 휴대전화로 인증하기</span>
                </div>
                <div class="checkbox">
                    <input type="checkbox" >
                    <span class="">회원 정보에 등록된 이메일로 인증하기</span>
                </div>
            </div>

            <div class="users input-icon">
            <i class="fas fa-users"></i>
            </div>
            <input type="text" class="id input" placeholder="아이디">
            <div class="name input-icon">
                <i class="fas fa-user-alt"></i>
            </div>
            <input type="text" class="password input"placeholder="이름">
            <div class="phone input-icon">
                <i class="fas fa-mobile-alt"></i>
            </div>
            <input type="text" class="password input"placeholder="123-1234-1234">
            <div class="confirm"> 
            <input type="text" class="confirm-input "placeholder="인증번호 6자리">
                <input type="button" value="인증번호받기" class="confirm-btn">
            </div>
            <input type="button" value="sign in" class="button sing-btn">
        </div>
    </section>