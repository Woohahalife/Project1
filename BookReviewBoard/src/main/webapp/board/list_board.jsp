<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
   <title>book board</title>
    <link rel="stylesheet" href="css.css">
</head>
<body>
    <div class="board_wrap">
        <div class="board_title">
            <strong>board</strong>
            <p>자유게시판 입니다.</p>
        </div>
        <div class="board_list_wrap">
            <div class="board_list">
                <div class="top">
                    <div class="num">번호</div>
                    <div class="title">제목</div>
                    <div class="writer">글쓴이</div>
                    <div class="date">작성일</div>
                    <div class="count">조회</div>
                </div>
                <div>
                    <div class="num">5</div>
                    <div class="title"><a href="view.html">글 제목이 들어갑니다.</a></div>
                    <div class="writer">김이름</div>
                    <div class="date">2021.1.15</div>
                    <div class="count">33</div>
                </div>
                <div>
                    <div class="num">4</div>
                    <div class="title"><a href="view.html">글 제목이 들어갑니다.</a></div>
                    <div class="writer">김이름</div>
                    <div class="date">2021.1.15</div>
                    <div class="count">33</div>
                </div>
                <div>
                    <div class="num">3</div>
                    <div class="title"><a href="view.html">글 제목이 들어갑니다.</a></div>
                    <div class="writer">김이름</div>
                    <div class="date">2021.1.15</div>
                    <div class="count">33</div>
                </div>
                <div>
                    <div class="num">2</div>
                    <div class="title"><a href="view.html">글 제목이 들어갑니다.</a></div>
                    <div class="writer">김이름</div>
                    <div class="date">2021.1.15</div>
                    <div class="count">33</div>
                </div>
                <div>
                    <div class="num">1</div>
                    <div class="title"><a href="view.html">글 제목이 들어갑니다.</a></div>
                    <div class="writer">김이름</div>
                    <div class="date">2021.1.15</div>
                    <div class="count">33</div>
                </div>
            </div>
            <div class="board_page">
                <a href="#" class="bt first"></a>
                <a href="#" class="bt prev"></a>
                <a href="#" class="num on">1</a>
                <a href="#" class="num">2</a>
                <a href="#" class="num">3</a>
                <a href="#" class="num">4</a>
                <a href="#" class="num">5</a>
                <a href="#" class="bt next">></a>
                <a href="#" class="bt last">>></a>
            </div>
            <div class="bt_wrap">
                <a href="write.html" class="on">등록</a>
                <!--<a href="#">수정</a>-->
            </div>
        </div>
    </div>
</body>
</html> 