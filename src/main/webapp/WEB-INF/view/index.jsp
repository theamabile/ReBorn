<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reborn</title>
    <!-- <script type="module" src="./threejs-responsive.js"></script> -->
    <script type="module" src="./js/main.js"></script>
    <link rel="stylesheet" href="./css/main.css">
</head>
<body>
    <canvas id="animalIsland"></canvas>
    <div id="loading">
        <div>
        <div>...loading...</div>
        <div class="progress"><div id="progressbar"></div></div>
        </div>
    </div>
</body>
</html>