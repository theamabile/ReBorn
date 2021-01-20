<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="/css/care/common.css">
<link rel="stylesheet" href="/css/care/list.css">

	    <section class="search-box">
	        <div class="search-inner section-max-width">
	            <div class="search-bar backdrop-blur">
	                <div class="search-icon">
	                    <!-- <i class="fas fa-search"></i> -->
	                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" >
	                        <path d="M508.5 481.6l-129-129c-2.3-2.3-5.3-3.5-8.5-3.5h-10.3C395 312 416 262.5 416 208 416 93.1 322.9 0 208 0S0 93.1 0 208s93.1 208 208 208c54.5 0 104-21 141.1-55.2V371c0 3.2 1.3 6.2 3.5 8.5l129 129c4.7 4.7 12.3 4.7 17 0l9.9-9.9c4.7-4.7 4.7-12.3 0-17zM208 384c-97.3 0-176-78.7-176-176S110.7 32 208 32s176 78.7 176 176-78.7 176-176 176z"></path>
	                    </svg>
	                </div>
	                <div class="search-input"><input class="input-reset" name="adoption-center" placeholder="입양소 이름"></div>
	            </div>
	        </div>
	    </section>
	    <section class="adoption-center-list position-relative">
	        <div class="adoption-center-list-inner">
	            <ul>
	            <c:forEach var="care" items="${list}">
	            	<li>
	                    <div>
	                        <div class="thumb">
	                            <img src="/images/care/thumb/1d47dc4b58bd0023f49152347e221051_20160513111715_srgxlzpg.jpg">
	                        </div>
	                        <div class="name">
	                            <div class="bold"><c:if test="${care.auth}"><i class="fas fa-check"></i> </c:if>${care.name}</div>
	                            <div>${care.addr}</div>
	                            <div>${care.tel}</div>
	                        </div>
	                        <div class="current-animals-num">
	                            <div class="bold">보호중인 동물 수</div>
	                            <div></div>
	                        </div>
	                        <div class="interest">
	                            <div>
	                                <i class="far fa-heart"></i>
	                            </div>
	                            <div>${care.wishCnt}</div>
	                        </div>
	                    </div>
	                </li>
	            </c:forEach>
	            </ul>
	        </div>
	    </section>