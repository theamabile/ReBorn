<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bda1963015c3359c76adbb17d9d5e489&libraries=services"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript" src="/js/animal/detail.js"></script>
		
<link rel= "stylesheet" type="text/css" href="/css/name/name.css">
<link rel= "stylesheet" type="text/css" href="/css/name/detail.css">
 	 
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
						<%-- <span><i class="fas fa-heart mr-4 red-pink"></i>${animal.name}</span> --%>
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
    	<c:if  test="${state eq 'END' }">
	    	<section>
	    		<div class="reborn-name">
	    			<div>
	    				<i class="fas fa-heart mr-3 red-pink"></i><span class="bold">${name.name }</span>는(은) <span>${name.writerNickname}</span>님이 지어주신 이름입니다. 
	    			</div>
		        	<!-- <div><i class="fas fa-caret-down mt-3"></i></div> -->
		        </div>
	    	</section>
    	</c:if>
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
		   				<td class="happenPlace">${animal.happenPlace }</td>
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
		   				<td class="careAddr">${animal.careAddr }</td>
		   			</tr>
		   		</table>
    		</div>
    		
    		<div class="flex mt-1 mb-3">	    		
    			<input type="button" value="입양 문의" class="callBtn main-button-wf" >
				<c:if  test="${state eq null || state eq 'NONE' }">
					<c:set var="nameUrl" value="/add"></c:set>
				</c:if >
				<c:if  test="${state eq 'START' }">
					<c:set var="nameUrl" value=""></c:set>
				</c:if >
				<c:if  test="${state ne 'END' }">
					<input type="button" value="이름 지어주기" onclick="location.href='/name/${animal.desertionNo}${nameUrl}'" class="vote-btn main-button-wf ml-3" >
				</c:if >
    		</div>
			<input type="button" value="목록" class="vote-btn gray-button-wf">
    	</section>
    	
		<section class="flex-column flex-center">
			<h1>보호 장소</h1>
			<div class="flex mt-3 m-auto">
				<span class="bold fs-4 mr-4">위치.</span>
				<span class="fs-4">${animal.careAddr}</span>
			</div>
			<div id="care-map" class="mt-3" style="width:100%;height:400px;"></div>
		</section>
    	
		<section class="flex-column flex-center">
			<h1>발견 장소</h1>
			<div class="flex mt-3 m-auto">
				<span class="bold fs-4 mr-4">위치.</span>
				<span class="fs-4">${animal.happenPlace}</span>
			</div>
			<div id="happen-map" class="mt-3" style="width:100%;height:400px;"></div>
		</section>
		
		<section class="flex-column flex-center mb-1">
			<h1>공유하기</h1>
			<div  class="flex-column flex-center m-auto"> 
				<span class="text-a-center">소중한 생명의 가족을 되찾아주세요.</span>
				<span class="text-a-center mb-3">작은 관심이 큰 힘이 됩니다.</span>				
				<a id="create-kakao-link-btn" class="text-a-center">
					<img src="https://developers.kakao.com/assets/img/about/logos/kakaolink/kakaolink_btn_medium.png"/>
				</a>
			</div>
		</section>
		
    	
		
	</section>