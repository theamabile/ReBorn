<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<header>
        <h1 class="d-none">상단 바</h1>
        <nav class="main-menu">
            <h1 class="d-none">메인 메뉴</h1>
            <div class="menu-container">
                <img src="/images/logo.svg">
                <ul class="menu-list">
                    <li>
                        <div class="menu-btn">
                            <a href="/main">HOME</a>
                        </div>
                        <div class="hover-line"></div>
                    </li>
                    <li>
                        <div class="menu-btn">
                            <span>유기동물</span>
                        </div>
                        <div class="hover-line"></div>
                        <div class="dropdown-menu">
                            <ul>
                                <li><a href="/animal/list">유기동물 조회</a></li>
                                <li><a href="/name/list">이름 투표</a></li>
                            </ul>
                        </div>
                    </li>
                    
                    <li>
                        <div class="menu-btn">
                            <a href="/care/list">보호소</a>
                        </div>
                        <div class="hover-line"></div>
                    </li>
                    <li class="drop">
                        <div class="menu-btn">
                            <span>커뮤니티</span>
                        </div>
                        <div class="hover-line"></div>
                        <div class="dropdown-menu">
                            <ul>
                                <li><a href="/community/list">게시판</a></li>
                                <li><a href="/report/list">실종신고</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <div class="menu-btn">
                            <span>정보</span>
                        </div>
                        <div class="hover-line"></div>
                        <div class="dropdown-menu">
                            <ul>
                                <li><a href="/data/introduce">리본 소개</a></li>
                                <li><a href="/data/information">동물 기본상식</a></li>
                            </ul>
                        </div>
                    </li>
                </ul> 
                <button>SIGN UP</button>
                <button>SIGN IN</button>
            </div>
        </nav>

    </header>