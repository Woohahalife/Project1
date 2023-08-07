<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <header>
                <h2><a href="index.html">HELLO BOOK</a></h2>
                <nav>
                    <ul>
                        <li><a href="#">추천북</a></li>
                        <li><a href="">북리뷰</a></li>
                        <li><a href="">게시판</a></li>
                        <%if(session.getAttribute("m_id")==null) {%>
	                        <li><a href="../login/login.jsp" class="btn">login</a></li> 
	                        <li><a href="../login/join.jsp" class="btn">회원가입</a></li>  
                        <%}else {%>
                            <li><a href="../controller/LogoutController" class="btn">logout</a></li>
                        <% }%>                        
                    </ul>
                </nav>
                <div>
                    
                </div>  
            </header>
                   
            <div class="container">            
                <div class="block">추천1</div>
                <div class="block">추천2</div>
                <div class="block">추천3</div>
            </div>      
            <div class="container2">    
                <div class="block2"></div>
                <div class="block2"></div>
    
          
            <footer>
	            <div class="container3">
	                <p>Copyright Â© HELLO BOOK All Rights Reserved.</p>
	            </div>
            </footer>
        </div>
    </body>



</body>
</html>