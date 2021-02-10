<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    

<link rel= "stylesheet" type="text/css" href="/css/name/name.css">
<link rel= "stylesheet" type="text/css" href="/css/name/detail.css">


<!-- 제이쿼리 사용 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/js/name/add.js"></script>
		
	
 	<section>
   		<section class="img-section">
            <img src="${animal.popfile}"  class="background-img">
            <div class="flex-column flex-a-center">
	            <img src="${animal.popfile }" class="circle-img" />
	            
	            <div class="summary">
	            	<c:if  test="${state ne 'END' }">
						<div class="blank">							
							<i class="fas fa-quote-left"></i>
							<i class="fas fa-quote-right"></i>
						</div>
					</c:if >	
					<c:if  test="${state eq 'END' }">
						<span>${animal.name}</span>
					</c:if >
				
	                <span>${animal.noticeNo}</span>
	                <span>색상:${animal.colorCd} / 성별:${animal.sexCd} / 나이:${animal.age} / 체중:${animal.weight}</span>
	                <span>${animal.happenPlace}</span>
	            </div>
            </div>
        </section>
   	</section>
 	
    <section class="main-container">
    
		<section class="vote">
			<h1>이름 후보</h1>
			<c:if test="${nameList.size() != 0}">
				<div class="vote-info">
					<span>이름 모집기간 : ${vote.recruitStartDate}~${vote.recruitEndDate}</span>			
				</div>
			</c:if>
			<div class="w-100">
				<div class="vote-box">  <!--  flex-column flex-a-center -->
					<c:if test="${nameList.size() == 0}">
						<div class="m-auto fs-3 gray text-a-center"> 
							등록 된 이름이 없습니다.<br>
							첫번째로 이름을 지어주세요!
						</div>
					</c:if>
					<c:forEach var="n" items="${nameList}">
						<div class="vote-item">
							<div class="vote-name">
								<span class="name">${n.name}</span>
								<div class="vote-name-info">
									<span>${n.reason}</span>
									<span>${n.writerNickname}</span>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</section>
		
		<section class="add-name">
			<form method="post" action="/name/${animal.desertionNo}/add" class="w-100 flex-column flex-a-center">
				<h1>이름 지어주기</h1>
				<span class="m-auto fs-4 mt-2 mb-2 text-center">
					동물이 평생 간직할 소중한 이름입니다. 애정을 담아 예쁜 이름으로 지어주세요.<br>
				</span>
				<input type="text" name="name" class="nameInput input-wf mb-3" placeholder="이름">
				<textarea name="reason" class="reasonInput textarea-wf flex-grow-1 mb-3" cols="40" rows="5" placeholder="자신의 의견을 간단히 적어주세요."></textarea>
				
				<input type="button" value="이름 지어주기" class="add-btn main-button-wf">
				<input type="hidden" class="desertionNo" value="${animal.desertionNo}" />
			</form>
		</section>
		
	</section>	
		
		
		
		
		
		
		

		