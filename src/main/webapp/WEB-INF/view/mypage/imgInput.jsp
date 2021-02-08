<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/css/member/info.css" type="text/css" rel="stylesheet" />
<script src="/js/mypage/imgInput.js" type="text/javascript"></script>

<section class="img-update">
	<form action="img-update" method="post" enctype="multipart/form-data">

		<h3>[${m.nickname}]님의 프로필 이미지 변경</h3>

		<div class="profile-img">
			<c:choose>
				<c:when test="${!empty m.profileImg}">
					<img class=""
						src="/upload/member/profile/${m.id }/${m.profileImg }"
						alt="프로필이미지" />
				</c:when>
				<c:otherwise>
					<img class="" src="/upload/member/profile/default/logo_Re.svg"
						alt="프로필이미지" />
				</c:otherwise>
			</c:choose>
		</div>
		<input class="id d-none" value="${m.id }"> <br /> <input
			name="file" class="file d-none " type="file"
			onchange="previewImg(this)" /> <input class="file-btn btn-s able"
			type="button" value="이미지 선택" /> <input class="submit-btn  btn-s able"
			type="button" value="이미지 적용" />
	</form>
</section>