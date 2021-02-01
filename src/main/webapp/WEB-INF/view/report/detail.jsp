<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="/css/report/detail.css" type="text/css" rel="stylesheet" />
<script src="/js/report/detail.js"></script>	
<section class="main-container">
	<h1>반려동물 실종 신고</h1>
	        <div class="data-table-box">
	        <span class="missing-id hide">${missingView.id}</span>	
            <form action="" class="data-table-form">
                <table class="data-table">
                    <colgroup>
                        <col style="width:200px;">
                        <col style="width:auto;">
                    </colgroup>
                    <tbody>
                        <tr>
                            <th>제목</th>
                            <td>
                                ${missingView.title}
                            </td>
                        </tr> 
                        <tr>
                            <th>작성자</th>
                            <td>
                              ${missingView.nickname}
                            </td>
                        </tr>
                        <tr>
                            <th>실종 일자</th>
                            <td>
                               <fmt:formatDate value="${missingView.missingDate}" pattern="yyyy-MM-dd"/>
                            </td>
                        </tr>

                        <tr>
                            <th>실종 장소</th>
                            <td>
                              ${missingView.location}
                            </td>
                        </tr>

                                        
                        <tr>
                            <th>품종</th>
                            <td>
                               ${missingView.breed}
                            </td>
                        </tr>
                        <tr>
                            <th>특징</th>
                            <td>
                                ${missingView.feature}
                            </td>
                        </tr>
                        
                        <tr>
                            <th>내용</th>
                            <td>
                                <div  class="detail-content">
                                     ${missingView.content}
                                </div>
                            </td>
                        </tr>
                        <c:if test="${not empty missingView.files}">
                         <tr>
                            <td colspan="2" class="detail-img-td">
                                <div class="detail-img-box">
                                    <ul>
                                    	
                                    	<c:forEach items="${fn:split(missingView.files, ',') }" var="item">
											 <li style="background-image:url('/upload/report/${missingView.id}/${item}')"></li>
										</c:forEach>
										
									</ul>
                                </div>
                            </td>
                        </tr>
                        </c:if> 
                    </tbody>
                </table>
            </form>
        </div>
        
        <div class="data-btn-box">
          	<a href="list" class="main-button-m">목록</a>
        	<a href="list" class="gray-button-m">수정</a>
        </div>


        <div class="comment-box">
            <ul>
            	<c:forEach var="cl" items="${commentList}">
                <li>
                    <ol class="comment-info">
                        <li>${cl.nickname}</li>
                        <li><fmt:formatDate value="${cl.regDate}" pattern="yyyy-MM-dd"/></li>
                        <li class="util-menu">
                        	<ol>
                        		<li><a href="#" class="comment-modify " data-commentid="${cl.id}">수정</a></li>
                        		<li><a href="#" class="comment-delete" data-commentid="${cl.id}">삭제</a></li>
                        		<li><a href="#" class="comment-declare" data-commentid="${cl.id}">신고</a></li>
                        	</ol>
                        </li>
                    </ol>
                    <div class="comment-content">
                       ${cl.content}
                    </div>
                </li>
                </c:forEach>
            </ul>
            <div>
                <form action="/api/report/${missingView.id}/comment/write" class="comment-form" method="POST">
                    <div class="comment-write-box">
                        <textarea class="comment-area" name="comment-content"></textarea>
                        <a href="#" class="comment-btn">작성</a>
                    </div>
                </form>
            </div>
        </div>
</section>