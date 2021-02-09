<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>리본</title>
    <link href="/css/layout.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
    <script type="text/javascript" src="/js/common.js"></script>
</head>
<body>

	<tiles:insertAttribute name="header" />
 

    <!-- --------------------------- <body> --------------------------------------- -->
	<main>	 <!-- footer가 main안에 있어야 하므로 메인태그로 감싸줌 -->
	
		<tiles:insertAttribute name="main" />
		
		
		<tiles:insertAttribute name="chat" />
		
		
	    <!-- ------------------- <footer> --------------------------------------- -->
		<tiles:insertAttribute name="footer" />
		
	</main>

</body>
</html>