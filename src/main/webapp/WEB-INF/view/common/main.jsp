<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>

    <link rel= "stylesheet" type="text/css" href="/css/common/main.css">
    
    <!-- 자바스크립트 로드 안하면 투명 스크롤 적용 안됨, 메인에서만 사용해야함!(흰배경X)-->
    <script type="module" src="/js/common/inc/header.js"></script> 
    <script type="module" src="/js/common/main.js"></script> 
</head>
<body>
	
	 <h1 class="d-none">메인</h1>
	    <section id="animal"> 
	        <h1 class="d-none">유기동물</h1>
	        <div class="background-img"></div>
	        <div class="animal-box">
	            <span>유기동물의 이름을 지어주세요</span>
	            <input type="button" class="animal-btn" value="이름 지어 주러 가기"/>
	        </div>
	    </section>
	
	    <section id="vote">  
	        <h1 class="d-none">투표 목록</h1>
	    </section>
	
	    <section id="center"> 
	        <h1 class="d-none">입양소 목록</h1>
	    </section>
	
	    <section id="lost"> 
	        <h1 class="d-none">실종 공고</h1>
	    </section>
	    
</body>
</html>