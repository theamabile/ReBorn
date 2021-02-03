<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>리본</title>
    <link href="/css/admin/layout.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
    <script type="text/javascript" src="/js/common.js"></script>
</head>
<body>

	<!------------------------------------------- 헤더 -------------------------------------------------->
    <tiles:insertAttribute name="header" />
 
	<div id="body" class="body" >  
	 <!------------------------------------------- 메뉴  -------------------------------------------------->
        <tiles:insertAttribute name="menu" />
	
	    <!-- --------------------------- 메인 --------------------------------------- -->
		<main class="main">	 <!-- footer가 main안에 있어야 하므로 메인태그로 감싸줌 -->
		
			<tiles:insertAttribute name="main" />
			
			
			<!-- --------------------------- 풋터 --------------------------------------- -->
			<tiles:insertAttribute name="footer" />
			
		</main>
	</div>
       

</body>
</html>