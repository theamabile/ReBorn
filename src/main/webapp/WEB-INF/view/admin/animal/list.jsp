<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script crossorigin src="https://unpkg.com/react@17/umd/react.development.js"></script>
<script crossorigin src="https://unpkg.com/react-dom@17/umd/react-dom.development.js"></script>
<script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>
<script type="text/babel" src="/js/admin/animal/list.js"></script>

<section class="container">
	<h1 class="d-none">유기동물 관리</h1>

	<!-- container-item클래스가 꽉 채워진 박스 기준이라 min-width만 설정해주기 위해 member-container를 같이 넣어줌-->
	<%-- <section class="container-item">
		<h1>유기동물 목록</h1>

		<form method="post" action="delete">
			<div class="tools">
				<section class="filter">
					<h1 class="d-none">필터</h1>
					<select name="field" class="field">
						<option value="name"
							<c:if test="${field eq 'name'}">selected</c:if>>이름</option>
						<option value="login_id"
							<c:if test="${field eq 'login_id'}">selected</c:if>>아이디</option>
					</select> <input type="text" name="query" class="query" placeholder="검색어 입력"
						autocomplete="off"
						<c:if test="${query != null}">value="${query}"</c:if>> <input
						type="button" class="main-button-m searchButton" value="검색">
				</section>
			</div>
			<section>
				<h1 class="d-none">회원 목록</h1>
				<table>
					<thead>
						<tr>
							<th class="table-width-xs"><input type="checkbox"
								class="checkAll"></th>
							<th class="table-width-s">회원번호</th>
							<th class="table-width-m">아이디</th>
							<th class="table-width-m">이름</th>
							<th class="table-width-m">닉네임</th>
							<th class="table-width-s">권한</th>
							<th class="table-width-m">소속</th>
							<th class="table-width-m">이메일</th>
							<th class="table-width-m">가입날짜</th>
						</tr>
					</thead>
					<tbody class="table-body">
						<c:if test="${searchResult eq false}">
							<tr>
								<td colspan="9">'${query}'에 대한 검색 결과가 없습니다.</td>
							</tr>
						</c:if>
							<tr>
								<td><input type="checkbox" class="checkMember"
									name="checkMember" value="${m.id}"></td>
								<td>1</td>
								<td><a href="detail?id=${m.id}">혜진짱</a></td>
								<td>혜진</td>
								<td>야밍야밍</td>
								<td>관리자</td>
								<td>민슈찍</td>
								<td>aaaaa@gggg.com</td>
								<td>2020-01-29</td>
							</tr>
							<tr>
								<td><input type="checkbox" class="checkMember"
									name="checkMember" value="${m.id}"></td>
								<td>1</td>
								<td><a href="detail?id=${m.id}">혜진짱</a></td>
								<td>혜진</td>
								<td>야밍야밍</td>
								<td>관리자</td>
								<td>민슈찍</td>
								<td>aaaaa@gggg.com</td>
								<td>2020-01-29</td>
							</tr>
					</tbody>
				</table>

				<div class="pager">
					<input type="button" value="이전" class="prevScopeBtn" />
					<ul class="pageList">
						<c:forEach varStatus="i" begin="1" end="5">
							<c:choose>
								<c:when test="${field != null && query != null}">
									<li><a
										href="list?field=${field}&query=${query}&page=${i.index}"
										<c:if test="${currentPage == i.index}">class="current-page"</c:if>>
											${i.index}</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="list?page=${i.index}"
										<c:if test="${currentPage == i.index}">class="current-page"</c:if>>
											${i.index}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
					<input type="button" value="다음" class="nextScopeBtn" />
				</div>

			</section>
		</form>


	</section> --%>
</section>
