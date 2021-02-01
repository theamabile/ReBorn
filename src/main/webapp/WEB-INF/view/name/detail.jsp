<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    	
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
   		 <section class="vote">
			<h1>후보 목록</h1>
			<div class="vote-info">
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