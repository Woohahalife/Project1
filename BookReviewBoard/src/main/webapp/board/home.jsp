<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/board/homeStyle.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>
    <body>
            <jsp:include page="../board/header1.jsp" />
	            <div class="recommend">
	              BOOK RECOMMEND
	              <span class="material-symbols-outlined">
	              import_contacts
	              </span>
	            </div>
        <div class="page">
            
            <div class="container">            
                <c:forEach items="${BestPosts }" var="row" varStatus="loop">
                    <a href="../controller/ViewController?idx=${row.b_idx }">
	                    <div class="block">
	                       <div class="block-number">Best Review ${loop.count }</div>
	                       <div class="block-image"><img src="${row.thumnail }" width="190px" height="250px"></div>
                           <div class="block-title">${row.b_title }</div>
                           <div class="block-nickname">${row.b_name }</div>
	                    </div>
                    </a>
                </c:forEach>
                <hr>
            </div>
                 <div class=search>  
			        <form method="get">
			        <table>
			         <tr>
			            <td align="center">
			               <select name="searchField">
			                  <option value="b_title">제목</option>
			                  <option value="content">내용</option>
			               </select>
			               <input id="input1" type="text" name="searchWord">
			               <input id="input2" type="submit" value="검색하기">
			            </td>
			         </tr>
			      </table>
			      </form>
			      </div>
	            <div class="container2">    
	              <c:choose>
	                <c:when test="${empty boardLists }">
	                 <c:redirect url="../controller/ListController"/>
	                </c:when>
	                <c:otherwise>
			          <c:forEach items="${boardLists }" var="row" varStatus="loop">  
			             
			            <a href="../controller/ViewController?idx=${row.b_idx }">
			            <div class="block2">
			               <div class="block2-image"><img src="${row.thumnail }" width="150px" height="210px"></div>
			               <div class="block2-title">${row.b_title }</div>
			               <div class="block2-nickname">${row.b_name }</div>
			               <div class="block2-postdate">${row.b_postdate }</div>
			            </div>
			            </a>
			          </c:forEach>
			          </c:otherwise>
	              </c:choose>
	            </div>
            <div class="paging" style="text-align: center;">
            ${map.pagingImg }
            </div>
            <footer>
	            <div class="footer">
	                <p>Copyright HELLO BOOK All Rights Reserved.</p>
	            </div>
            </footer>
            </div>
    </body>



</body>
</html>