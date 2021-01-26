<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
    
 	<link rel= "stylesheet" type="text/css" href="/css/name/name.css">
 	<link rel= "stylesheet" type="text/css" href="/css/name/list.css">
 	
 	<!-- 바닐라 - 작업중 -->
   <!--  <script type="text/javascript" src="/js/name/list.js"></script> -->

	<!-- 리액트 한번 해보기 => 태그 안에 태그 추가 -->
	<script crossorigin src="https://unpkg.com/react@17/umd/react.development.js"></script>
	<script crossorigin src="https://unpkg.com/react-dom@17/umd/react-dom.development.js"></script>
	<script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>	
	<script type="text/babel" src="/js/name/list-react.js"></script>
	 
	<c:set var="page" value="${param.p}"/>
	<c:if test="${empty param.p}"> <!-- page 인자 없이 리스트에 왔을 때 -->
 		<c:set var="page" value="1"/>
 	</c:if>
 	
 	<c:set var="offset" value="${(page-1)%5 }"></c:set>
 	<c:set var="startNum" value="${page-offset}"></c:set>

 	
    <section class="main-container">
    	<%-- <div class="vote">
    		<h1>투표 목록</h1>
			<form>
				<div class="filter">
					<select name="of" class="order-field" onchange="this.form.submit()">
						<option value="voteStartDate">투표날짜</option>
						<option value="choiceSum">참여 순</option>
					</select>
					<select name="oq" class="order-query" onchange="this.form.submit()">
						<option value="DESC">내림차순</option>
						<option value="ASC">오름차순</option>
					</select>
				</div>
				
				<div class="vote-list">
					 <c:forEach var="v" items="${list}">
						<div class="item">
					        <div class="percent">
					            <div class="gage"></div>
					        </div>
					        	
					        <button class="btn">
					        	<img>	        	
					            <div class="vote-info">
						        	<div class="regdate">
							        	<span class="font-xs">
							        		<fmt:formatDate value="${v.voteStartDate}" pattern="yyyy-MM-dd"/>~
							        		<fmt:formatDate value="${v.voteEndDate}" pattern="yyyy-MM-dd"/>
							        	</span>
							            <img>
						        	</div>
					            	<table class="rank font-l">
			            				<c:forEach var="n" items="${v.rankNameList}" varStatus="status">
						            		<tr>
						            			<th class="bold"><i class="fas fa-medal font-m"></i>${status.index+1}위</th>
						            			<td>${n.name}</td>
						            		</tr>
					            		</c:forEach>
					            	</table>
					            	
					            	<div class="count">
					            		<div class="count-item">
					            			<span class="font-m">총 투표수</span>
					            			<span class="font-xl">${v.choiceSum }</span>
					            		</div>
					            		<div class="count-item">
					            			<span class="font-m">후보 수</span>
					            			<span class="font-xl">${v.nameCnt }</span>
					            		</div>
					            		<i class="fas fa-vote-yea font-xl"></i>
		
					            	</div>
					            </div>
					        </button>
					    </div>
					</c:forEach>
				</div>
			</form>
			
			
			<div class="pager">
				 <div class="prev mr15">
	                 <c:if test="${startNum > 1}">                    
	                     <a class="btn btn-prev" href="p=${startNum-5}&of=${param.of}&oq=${param.oq}&f=${param.f}&q=${param.q}"></a>
	                 </c:if>
	                 <c:if test="${startNum == 1}">                    
	                     <span class="btn btn-prev" onclick="alert('이전 페이지가 없습니다.');">이전</span>
	                 </c:if>    
	             </div>
	                    
				<ul class="btn-center">				 
					<c:forEach var="i" begin="0" end="4" varStatus="st">
						<c:set var="current" value=""></c:set>
						<c:if test="${startNum+i == page }">
							<c:set var="current" value="current"></c:set>
						</c:if>
						<c:if test="${startNum+i <= pageCount}">
							<li class="${current}">
								<a class="bold " href="?p=${startNum+i}&of=${param.of}&oq=${param.oq}&f=${param.f}&q=${param.q}">${startNum+i}</a>
							</li>
						</c:if>
					</c:forEach>	
				</ul>
				
				<div class="next">
	               	<c:if test="${startNum+5 <= pageCount}">
	                   	<a class="btn btn-next" href="?p=${startNum+5}&f=${param.f}&q=${param.p}&v=${param.v}"></a>
	                   </c:if>
	                   <c:if test="${startNum+5 > pageCount}">
	                   	<span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음 </span>                        	
	                   </c:if>
	             </div>
				
			</div> --%>
    	</div>
		

	</section>
	
	
<%-- 	<div class="btn">
			        	<img>	        	
			            <div class="vote-info">
			            	<div class="rank">
			            		<c:forEach var="n" items="${v.rankNameList}" varStatus="status">
			            			<div class="info-item-m">
				            			<label>${status.index+1}위</label>
				            			<span>${n.name}</span>
				            		</div>
			            		</c:forEach>
			            	</div>
			            	
				        	<div class="regdate">
					        	<span>
					        		<fmt:formatDate value="${v.voteStartDate}" pattern="yyyy-MM-dd"/>~
					        		<fmt:formatDate value="${v.voteEndDate}" pattern="yyyy-MM-dd"/>
					        	</span>
					            <img>
				        	</div>
				        	
			            	<div>
			            		<div class="info-item-s">
			            			<label>총 투표수</label>
			            			<span>${v.choiceSum }</span>
			            		</div>
			            		<div class="info-item-s">
			            			<label>후보 수</label>
			            			<span>${v.nameCnt }</span>
			            		</div>
			            		<div class="state">
			            			<span>투표 완료</span>
			            		</div>
			            	</div>
			            </div>
			        </div>
			    </div> --%>
	
	