<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    	
 <link rel= "stylesheet" type="text/css" href="/css/name/name.css">
 <link rel= "stylesheet" type="text/css" href="/css/name/detail.css">

<script src="/js/name/detail.js"></script>

 	<section>
   		<section class="img-section">
            <img src="${animal.popfile}"  class="background-img">
            <div class="flex-column flex-a-center">
	            <img src="${animal.popfile }" class="circle-img" />
	            <div class="summary">
	                <span>${animal.noticeNo}</span>
	                <span>색상:${animal.colorCd} / 성별:${animal.sexCd} / 나이:${animal.age} / 체중:${animal.weight}</span>
	                <span class="happenPlace">${animal.happenPlace}</span>
	            </div>
            </div>
        </section>
   	</section>
   		
   		
    <section class="main-container">
    	<section>
    		<h1>동물 정보</h1>
    		<div class="info-box">
    			<table>
		   			<tr>
		   				<th>유기번호</th>
		   				<td class="desertionNo">${animal.desertionNo }</td>
		   				<th>접수일</th>
		   				<td>${animal.happenDt }</td>
		   			</tr>
		   			<tr>
		   				<th>발견장소</th>
		   				<td>${animal.happenPlace }</td>
		   				<th>품종</th>
		   				<td>${animal.kindCd }</td>
		   			</tr>
		   			<tr>
		   				<th>색상</th>
		   				<td>${animal.colorCd }</td>
		   				<th>나이</th>
		   				<td>${animal.age }</td>
		   			</tr>
		   			<tr>
		   				<th>체중</th>
		   				<td>${animal.weight }</td>
		   				<th>성별</th>
		   				<td>${animal.sexCd }</td>
		   			</tr>
		   		</table>
    		</div>
    		<!-- <input type="button" value="MORE"> -->
    	</section>
    
    
   		 <section class="vote">
			<h1>투표하기</h1>
			<div class="vote-info">
				<span>이름 모집기간 : ${vote.recruitStartDate}~${vote.recruitEndDate}</span>	
				<a class="report-btn">신고하기</a>			
			</div>
			<form method="post" class="w-100">
				<div class="vote-box">
					<c:forEach var="n" items="${nameList}">
						<c:if test="${choice == null}">
							<div class="vote-item">
								<div class="vote-name">
									<span class="name">${n.name}</span>
									<div class="vote-name-info">
										<span>${n.reason}</span>
										<span>${n.writerNickname}</span>
									</div>
									<input type="radio" name="name" value="${n.name}" class="vote-radio">
								</div>
							</div>
						</c:if>
						
						<c:if test="${choice != null}">			<!-- 이미 투표 했으면 -->				
							<c:if test="${choice.name eq n.name}">										
								<c:set var="choiced" value="choiced"></c:set>
							</c:if>
							<c:if test="${choice.name ne n.name}">										
								<c:set var="choiced" value=""></c:set>
							</c:if>
							
							<div class="vote-item ${choiced}">									
								<div class="vote-name">	
									<c:if test="${choice.name eq n.name}">										
										<i class="fas fa-check"></i>
									</c:if>
									<span class="name">${n.name}</span>
									<div class="vote-name-info">
										<span>${n.reason}</span>
										<span>${n.writerNickname}</span>
									</div>
									
									<div>								
										<span class="bold fs-2 choiceCnt">${n.choiceCnt }</span>
									</div>
									
									<c:if test="${choice == null}">
										<input type="radio" name="name" value="${n.name}" class="vote-radio">
									</c:if>
								</div>							
								<div class="vote-progress">
									<c:set var="percent" value="${ (n.choiceCnt/choiceSum)*100 }"></c:set>
									<div class="vote-progress-bar" style="width: ${percent}%;"></div>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>
				
				<c:if test="${choice == null}">
					<input type="submit" value="투표하기" class="vote-btn main-button-wf">
				</c:if>	
				<c:if test="${choice != null}">
					<input type="button" value="다시 투표하기" class="revote-btn main-button-wf">
				</c:if>	
				
				<input type="button" value="목록으로" class="bg-button-wf mt-4" onclick="location.href='/name/list'">
				
				<input type="hidden" name="choiceSum" class="choiceSum" value="${choiceSum}">
			</form>			
		</section>
		
	</section>