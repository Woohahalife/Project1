<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>book review</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/board/css.css">
</head>
<body>
    <div class="board_wrap">
        <div class="board_title">
            <strong>book review</strong>
            <p>북리뷰 게시판 입니다.</p>
        </div>
        <div class="board_view_wrap">
            <div class="board_view">
                <div class="title">
                    ${dto.b_title }
                </div>
                <div class="info">
                    <dl>
                        <dt>번호</dt>
                        <dd>${dto.b_idx }</dd>
                    </dl>
                    <dl>
                        <dt>글쓴이</dt>
                        <dd>${dto.b_name }</dd>
                    </dl>
                    <dl>
                        <dt>도서명</dt>
                        <dd>${dto.b_bookname }</dd>
                    </dl>
                    <dl>
                        <dt>작성일</dt>
                        <dd>${dto.b_postdate }</dd>
                    </dl>
                    <dl>
                        <dt>조회수</dt>
                        <dd>${dto.b_visitcount }</dd>
                    </dl>
                </div>
                <div class="cont">
                    ${dto.b_content }
                </div>
            </div>
            <div class="bt_wrap">
                <a href="../controller/ListController" class="on">목록</a>
                <c:if test="${sessionScope.m_id eq dto.b_id }">
	                <a href="../controller/EditBoardController?idx=${param.idx }">수정</a>
	                <a href="../controller/DelBoardController?idx=${param.idx }&${sessionScope.m_id }" class="on">삭제</a>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html>