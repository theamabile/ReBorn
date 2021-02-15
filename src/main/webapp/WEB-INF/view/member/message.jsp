<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="page" value="${param.p}" />
<c:if test="${empty param.p}">
	<c:set var="page" value="1" />
</c:if>
<c:set var="offset" value="${(page-1)%5}" />
<c:set var="startNum" value="${(page-offset)}" />


<link href="/css/member/message.css" type="text/css" rel="stylesheet" />

<section class="main-container">
	<div>
		<h1>쪽지</h1>
		<div class="ms-content">
			<select name="message-type" class="input type">
				<option value="받은쪽지함">받은쪽지함</option>
				<option value="보낸쪽지함">보낸쪽지함</option>
				<option value="보관쪽지함">보관쪽지함</option>
			</select> <a class="reg">쪽지쓰기</a> <a>내게쓰기</a>
			<div>
				<div class="btns">
					<input type="button" value="신고 " class="main-button-s" /> <input
						type="button" value="삭제" class="main-button-s" /> <input
						type="button" value="보관" class="main-button-s" />
				</div>
				<div class="selecter">
					<select name="message-type" class="input">
						<option value="아이디">아이디</option>
						<option value="제목">제목</option>
					</select> <input type="text" class="input" /> <input type="button"
						value="검색" class="main-button-s" />
				</div>
			</div>
			<table>
				<thead>
					<tr>
						<th><input type="checkbox" /></th>
						<th>보낸사람</th>
						<th>제목</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="m" items="${list}">
						<tr>
							<td><input type="checkbox" /></td>
							<td>${m.sender}</td>
							<td><a>${m.title}</a></td>
							<td><fmt:formatDate value="${m.regDate}"
									pattern="yyyy-MM-dd" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="margin-top align-center pager">

				<div>
					<c:if test="${startNum > 1 }">
						<a class="btn btn-next"
							href="?p=${startNum+5}&f=${param.f}&q=${param.q}">이전</a>
					</c:if>
					<c:if test="${startNum == 1 }">
						<span class="btn btn-prev" onclick="alert('이전 페이지가 없습니다.');">이전</span>
					</c:if>
				</div>

				<ul class="-list- center">
					<c:forEach var="i" begin="0" end="4" varStatus="st">
						<c:set var="current" value="" />
						<c:if test="${i+startNum ==page}">
							<c:set var="current" value="orange bold" />
						</c:if>
						<c:if test="${i+startNum<=pageCount }">
							<li><a class="-text- ${current }"
								href="?p=${startNum+i}&f=${param.f}&q=${param.q}">${startNum+i}</a></li>
						</c:if>
					</c:forEach>
				</ul>
				<div>
					<c:if test="${startNum+5<= pageCount }">
						<a class="btn btn-next"
							href="?p=${startNum+5}&f=${param.f}&q=${param.q}">다음</a>
					</c:if>
					<c:if test="${startNum+5 > pageCount }">
						<span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음</span>
					</c:if>
				</div>

			</div>


		</div>
	</div>
</section>