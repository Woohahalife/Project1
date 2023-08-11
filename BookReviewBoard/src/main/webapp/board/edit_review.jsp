<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>book review</title>
<%@ include file="/login/isLoggedIn.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/board/css.css">
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/controller/EditBoardController">
<input type="hidden" name="idx" value="${ dto.b_idx }"/>

    <div class="board_wrap">
        <div class="board_title">
            <strong>book review</strong>
            <p>북리뷰 게시판 입니다</p>
        </div>
        <div class="board_write_wrap">
            <div class="board_write">
                <div class="title">
                    <dl>
                        <dt>제목</dt>
                        <dd><input type="text" name="title" placeholder="제목 입력" value="${dto.b_title }"></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt>글쓴이</dt>
                        <dd><input type="text" name="name" placeholder="글쓴이" value="${dto.b_name }" readonly></dd>
                    </dl>
                    <dl>
                        <dt>도서명</dt>
                        <dd><input type="text" name="bookname" placeholder="도서명" value="${dto.b_bookname }" readonly></dd>
                    </dl>
                </div>
                <div class="cont">
                    <textarea name="content" placeholder="내용 입력"></textarea>
                </div>
            </div>
            <div class="bt_wrap">
                <button type="submit" class="regist-button"> 수정</button>
                <a href="../controller/ListController">돌아가기</a>
            </div>
        </div>
    </div>
</form>
</body>
</html>