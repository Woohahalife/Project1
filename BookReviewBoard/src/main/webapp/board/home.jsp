<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="homeStyle.css" />
</head>
<body>
    <body>
        <div class="page">
            <jsp:include page="../board/header.jsp" />
                   
            <div class="container">            
                <div class="block">추천1</div>
                <div class="block">추천2</div>
                <div class="block">추천3</div>
                <hr>
            </div>     
            <div class="container2">    
	          <c:forEach items="${boardLists }" var="row" varStatus="loop">  
	            <a href="view_board.jsp">
	            <div class="block2">
	               <div class="block2-image"><img src="test.jpg" width="240px" height="300px"></div>
	               <div class="block2-title">제목</div>
	               <div class="block2-nickname">글쓴이</div>
	            </div>
	            </a>
	          </c:forEach>
            </div>
            <footer>
	            <div class="container3">
	                <p>Copyright Â© HELLO BOOK All Rights Reserved.</p>
	            </div>
            </footer>
            </div>
    </body>



</body>
</html>