<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="/css/care/common.css">
<link rel="stylesheet" href="/css/care/detail.css">
<section class="intro-height position-relative" style="background: transparent; padding: 0">
	<section class="intro intro-height position-absolute position-top position-left">
		<div class="intro-blur-image position-absolute position-top position-left" style="background-image: url('/images/care/info/1/1d47dc4b58bd0023f49152347e221051_20160513111715_srgxlzpg.jpg')">
			<!-- <img src="/images/1d47dc4b58bd0023f49152347e221051_20160513111715_srgxlzpg.jpg"> -->
		</div>
		<div class="intro-image position-absolute position-center section-max-width" style="background-image: url('/images/care/info/1/1d47dc4b58bd0023f49152347e221051_20160513111715_srgxlzpg.jpg')">
			<!-- <img src="/images/1d47dc4b58bd0023f49152347e221051_20160513111715_srgxlzpg.jpg"> -->
		</div>
		<div class="intro-inner">
			<div class="intro-title box-center section-max-width">
				${care.name}
			</div>
		</div>
	</section>
	<div class="cloud position-absolute position-bottom position-left">
		<svg xmlns="http://www.w3.org/2000/svg" width="100%" height="50" viewBox="0 0 192.22 33.99" preserveAspectRatio="none">
			<path d="M0,8C33.65-10.84,50.37,29.77,68.88,29.77S117.26,0,149.26,0,200,25.55,200,25.55V45.68H0Z"/>
		</svg>
	</div>
</section>
<section class="greeting">
	<div class="greeting-inner box-center section-max-width">
		<div><img class="greeting-logo"src="/images/care/info/1/카라동물권교육로고.75a97ef1.png" alt=""></div>
		<h1>인권을 넘어 생명권으로!</h1>
		<div class="greeting-text">
			<br>
			2002년 4월 15일, “아름품”을 설립하였습니다.<br>
			2006년“KARA” (Korea Animal Rights Advocates)란 새 이름으로<br>
			비영리 시민단체로 등록하고, 2010년 3월에는 농림부에 사단법인으로 등록하여<br>
			보다 강력하고 효율적인 동물권 활동의 발판을 만들게 되었습니다.<br>
		</div>
	</div>
</section>
<section class="animal-list">
	<div class="animal-list-inner box-center section-max-width">
		<h1>보호중인 동물</h1>
		<div class="">
			<ul>
				<c:if test="${empty animalInfoList}"><li style="flex-grow: 1; font-size: 6vw;" class="search-empty">보호중인 동물 없습니다</tr></c:if>
				<c:forEach var="animal" items="${animalInfoList}">
					<li><div><img src="${animal.popfile}" alt="${animal.noticeNo}"></div><div>${animal.noticeNo}</div></li>
				</c:forEach>
				
				<!-- <li><div><img src="/images/care/info/1/download-2.jpg" alt=""></div><div>가나다라마바사 고양이</div></li>
				<li><div><img src="/images/care/info/1/download-3.jpg" alt=""></div><div>가나다라마바사 고양이</div></li>
				<li><div><img src="/images/care/info/1/download-4.jpg" alt=""></div><div>가나다라마바사 고양이</div></li>
				<li><div><img src="/images/care/info/1/download-5.jpg" alt=""></div><div>가나다라마바사 고양이</div></li>
				<li><div><img src="/images/care/info/1/download-6.jpg" alt=""></div><div>가나다라마바사 강아지</div></li>
				<li><div><img src="/images/care/info/1/download-7.jpg" alt=""></div><div>가나다라마바사 고양이</div></li>
				<li><div><img src="/images/care/info/1/download-8.jpg" alt=""></div><div>가나다라마바사 강아지</div></li>
				<li><div><img src="/images/care/info/1/download-9.jpg" alt=""></div><div>가나다라마바사 고양이</div></li> -->
			</ul>
		</div>
	</div>
</section>
<section id="kakao-map" class="map">
	<div class="map-inner box-center section-max-width">
		<div class="flex-center">
			<!-- * 카카오맵 - 지도퍼가기 -->
			<!-- 1. 지도 노드 -->
			<div id="daumRoughmapContainer1610114765235" class="root_daum_roughmap root_daum_roughmap_landing"></div>

			<!--
				2. 설치 스크립트
				* 지도 퍼가기 서비스를 2개 이상 넣을 경우, 설치 스크립트는 하나만 삽입합니다.
			-->
			<script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

			<!-- 3. 실행 스크립트 -->
			<script charset="UTF-8">
				new daum.roughmap.Lander({
					"timestamp" : "1610114765235",
					"key" : "23tgp",
					"mapWidth" : "640",
					"mapHeight" : "360"
				}).render();
			</script>
		</div>
		<div>
			<br><br>
			${care.addr}<br>
			<br><br>
			<span class="bold">Tel.</span> ${care.tel}<br>
			<br>
			<span class="bold">Email.</span> info@ekara.org<br>
			<br>
			<span class="bold">Page.</span> <a href="http://ekara.org/">http://ekara.org/</a><br>
		</div>
	</div>
</section>
<section class="evaluation">
	<div class="evaluation-inner box-center section-max-width">
		<h1>리뷰</h1>
		<ul>
			<li>
				<div class="icon"><i class="far fa-smile"></i></div>
				<div class="container">
					<div class="writer">Lorem ipsum</div>
					<div class="box">
						<form method="POST">
							<div class="score"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i></div>
							<div class="title"><input required type="text" name="title" placeholder="제목"/></div>
							<div class="content"><textarea required placeholder="내용" style="resize: none;"></textarea></div>
							<div class="submit-icon"><label for="evaluation-submit" class="send-icon pointer"><i class="fas fa-arrow-alt-circle-down"></i></label></div>
							<input id="evaluation-submit" class="d-none" type="submit" value="전송" />
						</form>
					</div>
				</div>
			</li>
			<li class="line"></li>
			<li>
				<div class="icon"><i class="far fa-smile"></i></div>
				<div class="container">
					<div class="writer">Lorem ipsum</div>
					<div class="box">
						<div class="title">Lorem ipsum dolor sit amet</div>
						<div class="score"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i></div>
						<div class="content">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa. Commodo odio aenean sed adipiscing diam donec adipiscing</div>
					</div>
				</div>
			</li>
			<li>
				<div class="icon"><i class="far fa-smile"></i></div>
				<div class="container">
					<div class="writer">Lorem ipsum</div>
					<div class="box">
						<div class="title">Lorem ipsum dolor sit amet</div>
						<div class="score"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i></div>
						<div class="content">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa. Commodo odio aenean sed adipiscing diam donec adipiscing</div>
					</div>
				</div>
			</li>
			<li>
				<div class="icon"><i class="far fa-meh"></i></div>
				<div class="container">
					<div class="writer">Lorem ipsum</div>
					<div class="box">
						<div class="title">Lorem ipsum dolor sit amet</div>
						<div class="score"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i></div>
						<div class="content">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa. Commodo odio aenean sed adipiscing diam donec adipiscing</div>
					</div>
				</div>
			</li>
			<li>
				<div class="icon"><i class="far fa-meh"></i></div>
				<div class="container">
					<div class="writer">Lorem ipsum</div>
					<div class="box">
						<div class="title">Lorem ipsum dolor sit amet</div>
						<div class="score"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i></div>
						<div class="content">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa. Commodo odio aenean sed adipiscing diam donec adipiscing</div>
					</div>
				</div>
			</li>
			<li>
				<div class="icon"><i class="far fa-frown"></i></div>
				<div class="container">
					<div class="writer">Lorem ipsum</div>
					<div class="box">
						<div class="title">Lorem ipsum dolor sit amet</div>
						<div class="score"><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i></div>
						<div class="content">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa. Commodo odio aenean sed adipiscing diam donec adipiscing</div>
					</div>
				</div>
			</li>
		</ul>
	</div>
</section>
<script>
window.addEventListener("load", ()=>{
	let section = document.querySelector(".evaluation");
	let form = section.querySelector("ul form");
	let faceIcon = section.querySelector("div.icon i");
	let scoreBox = form.querySelector(".score");
	let postBtn = form.querySelector(".send-icon");
	
	let score = 5;

	scoreBox.onclick = (e)=>{
		if(e.target.tagName != "I" || !e.target.classList.contains("fa-star"))
			return;
		
		score = 0;
		let finded = false;
		for(let i = 0; i < 5; i++){
			scoreBox.children[i].classList.remove("fas", "far");

			if( finded ){
				scoreBox.children[i].classList.add("far");
			} else {
				scoreBox.children[i].classList.add("fas");
				score++;
			}

			if( scoreBox.children[i] === e.target ){
				finded = true;
			}
		}
		switch(score){
			case 5:
			case 4:
				faceIcon.className = "far fa-smile";
				break;
			case 3:
			case 2:
				faceIcon.className = "far fa-meh";
				break;
			case 1:
				faceIcon.className = "far fa-frown";
				break;
		}
	}

	postBtn.onclick = (e)=>{
		
		e.preventDefault();
		console.log("click");
	}

})
</script>