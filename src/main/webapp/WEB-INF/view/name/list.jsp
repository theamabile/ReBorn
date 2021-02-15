<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
    
 	<link rel= "stylesheet" type="text/css" href="/css/name/name.css">
 	<link rel= "stylesheet" type="text/css" href="/css/name/list.css">
 	
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
    	
	</section>
	