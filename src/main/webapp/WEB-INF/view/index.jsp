<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reborn</title>
    <!-- <script type="module" src="./threejs-responsive.js"></script> -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
    <link href="/css/layout.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="./css/main.css">
    <script type="text/javascript" src="/js/common.js"></script>
    <script type="module" src="./js/main.js"></script>
</head>
<body>
	<tiles:insertAttribute name="header" />
    <canvas id="animalIsland"></canvas>
    <div id="loading" style="display: none">
        <div>...loading...</div>
        <div class="progress"><div id="progressbar"></div></div>
        </div>
    </div>
    <section id="animal">
        <div class="animal-box">
            <span>유기동물의 이름을 지어주세요</span>
            <a class="animal-btn" href="/animal/list">이름 지어 주러 가기</a>
        </div>
    </section>
</body>
</html>