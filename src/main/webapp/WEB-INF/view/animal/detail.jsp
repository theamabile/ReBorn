<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bda1963015c3359c76adbb17d9d5e489&libraries=services"></script>
<script type="text/javascript" src="/js/animal/detail.js"></script>
		
<link rel= "stylesheet" type="text/css" href="/css/name/name.css">
<link rel= "stylesheet" type="text/css" href="/css/name/detail.css">
 	 
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
		   				<td>${animal.desertionNo }</td>
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
		   			<tr>
		   				<th>공고번호</th>
		   				<td>${animal.noticeNo }</td>
		   				<th>상태</th>
		   				<td>${animal.processState }</td>
		   			</tr>
		   			<tr>
		   				<th>공고 시작일</th>
		   				<td>${animal.noticeSdt }</td>
		   				<th>공고 종료일</th>
		   				<td>${animal.noticeEdt }</td>
		   			</tr>
		   			<tr>
		   				<th>중성화 여부</th>
		   				<td>${animal.neuterYn }</td>
		   				<th>담당자 연락처</th>
		   				<td class="officetel">${animal.officetel }</td>
		   			</tr>
		   			<tr>
		   				<th>관할기관</th>
		   				<td>${animal.orgNm }</td>
		   				<th>보호 장소</th>
		   				<td>${animal.careAddr }</td>
		   			</tr>
		   		</table>
    		</div>
    		
    		<div class="flex mt-1 mb-3">	    		
				<input type="button" value="입양 문의" class="callBtn vote-btn main-button-wf mr-3">
				<input type="button" value="이름 지어주기" class="vote-btn main-button-wf">
    		</div>
			<input type="button" value="목록" class="vote-btn gray-button-wf">
    	</section>
    	
		<section>
			<h1>발견 장소</h1>
			<div id="map" style="width:100%;height:350px;"></div>
		</section>
    	
   		<section class="vote">
			<h1>투표 하기</h1>
			<div class="vote-info">
				<span>00명 참여</span>
				<span>2021-01-01 ~ 2021-01-04</span>
			</div>
			<div class="vote-box">
				<div class="vote-item">
					<span class="name">
						예삐
					</span>
					<div class="vote-item-content">
						<span>예쁘고 귀여움</span>
						<span>야밍야밍</span>
					</div>
					<input type="radio" name="vote" value="이름이름" class="vote-radio">
				</div>
				<div class="vote-item">
					<span class="name">
						예삐
					</span>
					<div class="vote-item-content">
						<span>예쁘고 귀여움</span>
						<span>야밍야밍</span>
					</div>
					<input type="radio" name="vote" value="이름이름" class="vote-radio">
				</div>
				<div class="vote-item">
					<span class="name">
						예삐
					</span>
					<div class="vote-item-content">
						<span>예쁘고 귀여움</span>
						<span>야밍야밍</span>
					</div>
					<input type="radio" name="vote" value="이름이름" class="vote-radio">
				</div>
			</div>
			
			<input type="button" value="투표하기" class="vote-btn main-button-wf">
			<input type="button" value="신고하기" class="report-btn">
			
		</section>
		
	</section>