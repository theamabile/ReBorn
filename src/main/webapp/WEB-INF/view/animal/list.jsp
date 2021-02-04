<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<link rel= "stylesheet" type="text/css" href="/css/name/name.css">
<link rel= "stylesheet" type="text/css" href="/css/animal/list.css">

<!-- 리액트 -->
<!-- <script crossorigin src="https://unpkg.com/react@17/umd/react.development.js"></script>
<script crossorigin src="https://unpkg.com/react-dom@17/umd/react-dom.development.js"></script>
<script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>
<script type="text/babel" src="/js/animal/list-react.js"></script> -->

<script src="/js/animal/list.js"></script>

 	 
<c:set var="page" value="${param.p}"/>
<c:if test="${empty param.p}"> <!-- page 인자 없이 리스트에 왔을 때 -->
	<c:set var="page" value="1"/>
</c:if>

<c:set var="offset" value="${(page-1)%5 }"></c:set>
<c:set var="startNum" value="${page-offset}"></c:set> 
  
    <section class="main-container">
    	
		<h1>유기동물 목록 </h1>
		<section class="search-box">
				<div class="box-row">
					<lable>품종</lable>
					<div class="breed-box">
						<select name="upkind" class="upkind">	
							<option value="">전체</option>  
							<option value="417000">개</option>
							<option value="422400">고양이</option>
							<option value="429900">기타</option>
						</select>
						<select name="kind" class="kind">	
							<option value="">선택 없음</option>
						</select>
					</div>
				</div>		
				<div class="box-row">
					<lable>유기 날짜</lable>
					<div class="regdate">
						<input type="date" name="bgnde" class="bgnde">
						<span>~</span>
						<input type="date" name="endde" class="endde">
					</div>
					<lable>중성화 여부</lable>
					<div class="neuter">
						<select name="neuter" class="neuterYn">	
							<option value="">전체</option>  
							<option value="Y">예</option>
							<option value="N">아니오</option>
							<option value="U">미상</option>			
						</select>
					</div>	
				</div>
		</section>
		
		<!-- ---------------------- 목록 ------------------------ -->
		
		<form method="post" action="/animal/detail"> 
			<section class="animal-box">
				
		</section>
		</form>
			
	 	<div class="pager-common mt30">
        	<div class="pager">     
        		<div class="prev mr15">	
        			<a class="btn btn-prev">이전</a>  
            	</div>
                <ul class="btn-center">
                    <%-- <c:forEach var="i" begin="0" end="4" varStatus="st">
                    	<c:set var="current" value="" />
                       	<c:if test="${i+startNum == page}">
                        	<c:set var="current" value="current"></c:set>
                      	</c:if>
	                  	<c:if test="${i+startNum <= pageCount}">
	                           <li class="${current}"><a class="bold " href="?p=${i+startNum}&f=${param.f}&q=${param.q}&v=${param.v}">${i+startNum}</a></li>
	                  	</c:if>
                    </c:forEach>   --%>
                </ul>
                <div class="next">
                    <a class="btn btn-next">다음</a>
                </div>
        	</div>
        </div>
                
<%--                
 <c:if test="${startNum+5 <= pageCount}">
                    	<a class="btn btn-next" href="?p=${startNum+5}&f=${param.f}&q=${param.p}&v=${param.v}">다음</a>
                    </c:if>
                    <c:if test="${startNum+5 > pageCount}">
                        <span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음 </span>                           
                	</c:if> 
                	
  <c:if test="${startNum > 1}">                    
                        <a class="btn btn-prev" href="p=${startNum-5}&f=${param.f}&q=${param.q}&v=${param.v}">이전</a>
                    </c:if>
                    <c:if test="${startNum == 1}">                    
                        <span class="btn btn-prev" onclick="alert('이전 페이지가 없습니다.');">이전</a>
                    </c:if>                 	
                	
                	--%>
<%-- 		<div class="pager">
			 <div class="prev mr15">
                 <c:if test="${startNum > 1}">                    
                     <a class="btn btn-prev" href="p=${startNum-5}&of=${param.of}&oq=${param.oq}&f=${param.f}&q=${param.q}"></a>
                 </c:if>
                 <c:if test="${startNum == 1}">                    
                     <span class="btn btn-prev" onclick="alert('이전 페이지가 없습니다.');">이전</span>
                 </c:if>    
             </div>
                    
			<ul class="btn-center">				 
				
			</ul>
			
		 	<div class="next">
		 		<c:if test="${startNum+5 <= pageCount}">
                  	<a class="btn btn-next" href="?p=${startNum+5}&f=${param.f}&q=${param.p}&v=${param.v}"></a>다음</span>
                </c:if>
                <c:if test="${startNum+5 > pageCount}">
                  	<span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음 </span>                        	
                </c:if>
            </div>
		</div> --%>
		
    </section>

