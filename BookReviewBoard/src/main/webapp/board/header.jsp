<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
ul {
    list-style: none;
  }
  
  a {
    text-decoration: none;
    outline: none;
  }
  
  .page {
    width: 1100px;
    margin: 0 auto;
  }
  
  header {
    width: 100;
    height: 80px;
    margin-bottom: 50px;
    display: flex;
    align-items: center;
    justify-content: space-between;
  }
  
  header > h2 {
  margin-left:20px;
  }
  
  header > nav {
  width:600px;
  height:100%;
  }
  
  header ul {
  width:100%;
  height: 100%;
  display: flex;
  justify-content: space-between;
  }
  
  header ul > li {
  font-size:20px;
  display: inline-flex;
  align-items: center;
  }
  .btn {
  display: inline-block;
    background-color: black;
    border: 1px white;
    border-radius: 5px;
    line-height: 1;
    padding: 10px;
    font: 14px 'Nanum Gothic';
    font-weight: 800;
    color:white;
    text-decoration: none;
  }  
  
</style>
</head>
<body>
            <header>
                <h2><a href="index.html">HELLO BOOK</a></h2>
                <nav>
                    <ul>
                        <li><a href="#">추천북</a></li>
                        <li><a href="${pageContext.request.contextPath}/board/write_review.jsp">북리뷰</a></li>
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
</body>
</html>