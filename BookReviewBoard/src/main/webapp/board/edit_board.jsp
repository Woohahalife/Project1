<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>book board</title>
    <link rel="stylesheet" href="css.css">
</head>
<body>
    <div class="board_wrap">
        <div class="board_title">
        <jsp:include page="../board/header.jsp" />
            <strong>board</strong>
            <p>자유게시판 입니다.</p>
        </div>
        <div class="board_write_wrap">
            <div class="board_write">
                <div class="title">
                    <dl>
                        <dt>제목</dt>
                        <dd><input type="text" placeholder="제목 입력" value=""></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt>글쓴이</dt>
                        <dd><input type="text" placeholder="글쓴이 입력" value=""></dd>
                    </dl>
                    
                </div>
                <div class="cont">
                    <textarea placeholder="내용 입력">
글 내용이 들어갑니다.
글 내용이 들어갑니다.
글 내용이 들어갑니다.
글 내용이 들어갑니다.
글 내용이 들어갑니다.
글 내용이 들어갑니다.
글 내용이 들어갑니다.
글 내용이 들어갑니다.</textarea>
                </div>
            </div>
            <div class="bt_wrap">
                <a href="view.html" class="on">수정</a>
                <a href="view.html">취소</a>
            </div>
        </div>
    </div>
</body>
</html>