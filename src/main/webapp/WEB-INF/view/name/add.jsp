<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    

<link rel= "stylesheet" type="text/css" href="/css/name/name.css">
<link rel= "stylesheet" type="text/css" href="/css/name/detail.css">


				
				
 	<!-- <link rel= "stylesheet" type="text/css" href="/css/animal/list.css"> -->
    <section class="main-container">
    	
		<span>${nameList}</span>	
		<span>${animal}</span>		

		<section class="vote">
			<h1>이름 후보</h1>
			<div class="vote-info">
				<!-- <span>2021-01-01 ~ 2021-01-04</span> -->		
				<span>이름 모집기간 : ${vote.recruitStartDate}~${vote.recruitEndDate}</span>		
			</div>
			<div class="vote-box">  <!--  flex-column flex-a-center -->
				<c:if test="${nameList.size() == 0}">
					<div class="m-auto fs-3 gray text-a-center"> 
						등록 된 이름이 없습니다.<br>
						첫번째로 이름을 지어주세요!
					</div>
				</c:if>
				<c:forEach var="n" items="${nameList}">
					<div class="vote-item">
						<span class="name">${n.name}</span>
						<div class="vote-item-content">
							<span>${n.reason}</span>
							<span>${n.writerNickname}</span>
						</div>
					</div>
				</c:forEach>
			</div>
		</section>
		
		<section class="add-name flex-column flex-a-center">
			<form method="post" action="/name/${animal.desertionNo}/add">
				<h1>이름 지어주기</h1>
				<span class="m-auto fs-4 mt-2 mb-2">
					동물이 평생 간직할 소중한 이름입니다.<br>
					마음을 담아 예쁜 이름으로 지어주세요.
				</span>
				<input type="text" name="name" class="input-wf mb-3" placeholder="이름">
				<textarea name="reason" class="textarea-wf flex-grow-1 mb-3" cols="40" rows="5" placeholder="자신의 의견을 간단히 적어주세요."></textarea>
				
				<input type="submit" value="투표하기" class="vote-btn main-button-wf">
				<input type="button" value="신고하기" class="report-btn">
			</form>
		</section>
	</section>	
		
		