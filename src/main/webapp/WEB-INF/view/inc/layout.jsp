<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>리본</title>
    <link href="/css/layout.css" type="text/css" rel="stylesheet" />
</head>
<body>

	<tiles:insertAttribute name="header" />
 

    <!-- --------------------------- <body> --------------------------------------- -->
	<main>	 <!-- footer가 main안에 있어야 하므로 메인태그로 감싸줌 -->
	
		<tiles:insertAttribute name="main" />
	
	    <!-- ------------------- <footer> --------------------------------------- -->
		<tiles:insertAttribute name="footer" />
		
	</main>

</body>
</html>