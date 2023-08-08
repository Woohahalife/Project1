<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>book review</title>
 <%@ include file="/login/isLoggedIn.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/board/css.css">
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/controller/WriteController">

<input name="b_id" type="hidden" value="${sessionScope.m_id }">
    <div class="board_wrap">
        <div class="board_title">
            <strong>book review</strong>
            <p>북리뷰 게시판 입니다.</p>
        </div>
        <div class="board_write_wrap">
            <div class="board_write">
                <div class="title">
                    <dl>
                        <dt>제목</dt>
                        <dd><input name="b_title" type="text" placeholder="제목 입력"></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt>글쓴이</dt>
                        <dd><input name="b_name" type="text" value="${sessionScope.m_nickname }"></dd>
                    </dl>
                    <dl>
                        <dt>도서명</dt>
                        <dd><input name="b_bookname" class="titlebar" type="text" placeholder="${requestScope.title }" readonly></dd>
                        <dd><button type="button" class="book-button" onclick="location.href='bookSearch.jsp'">선택</button><dd>
                    </dl>
                </div>
                <div class="cont">
                    <textarea name="b_content" placeholder="내용 입력"></textarea>
                </div>
            </div>
            <div class="bt_wrap">
                <button type="submit" class="regist-button"> 등록</button>
                <a href="${pageContext.request.contextPath}/board/home.jsp">돌아가기</a>
            </div>
        </div>
    </div>
</form>
</body>
</html>