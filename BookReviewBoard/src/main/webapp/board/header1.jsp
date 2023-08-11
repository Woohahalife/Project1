<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>home</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&family=Orbit&display=swap" rel="stylesheet">


    <link rel="stylesheet" href="../board/header1.css">
   
</head>
<body>
    <header id="headerType" class="header__wrap nexon">
        <div class="header__inner">
            <div class="header__logo">
                <a href="../controller/ListController">HELLO BOOK</a>
            </div>
            <nav class="header__menu">
                <ul>
                    <li><a href="${pageContext.request.contextPath}/board/write_review.jsp">북리뷰 작성</a></li>
                    <%if(session.getAttribute("m_id")==null) {%>
	                    <li><a href="../login/login.jsp" class="btn">login</a></li>  
	                    <li><a href="../login/join.jsp" class="btn">회원가입</a></li>
                    <%}else {%>
                        <li><a href="../controller/LogoutController" class="btn">logout</a></li>
                    <% }%>
                </ul>
            </nav>
            <div class="header__member"></div>
        </div>
    </header>
    

    
</body>
</html>
