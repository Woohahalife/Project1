<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>카카오 책 검색</title>
    <style>
        table {
            border: 0px solid #9599a1;
            border-collapse: collapse;
        }
        tr {
            
        }
        th {
            background-color: #4a4e69;
            color: white;
            height: 50px;
        }
        td {
            padding: 8px;
            text-align: center;
        }
        
        img {
            padding: 5px;
        }
    </style>
</head>
<body>
    <h1>카카오 책 검색</h1>
    <form id="searchForm">
        <label for="query">책 제목 또는 키워드:</label>
        <input type="text" id="query" name="query" required>
        <br>
        <label for="result_size">검색 결과 개수:</label>
        <input type="number" id="result_size" name="result_size" required min="1" value="5">
        <br>
        <input type="submit" value="검색">
    </form>

    <div id="results"></div>
    

    <script type="text/javascript"
    src="https://code.jquery.com/jquery-3.7.0.js"
  integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
  crossorigin="anonymous"></script>
    <script>
        $(document).ready(function() {
            $("#searchForm").submit(function(event) {
                event.preventDefault();
                var searchQuery = $("#query").val();
                var resultSize = $("#result_size").val();

                // 카카오 책검색 API 호출
                $.ajax({
                    url: "https://dapi.kakao.com/v3/search/book",
                    headers: {
                        "Authorization": "KakaoAK 55d7be55f4cbd6f34808fececa677ecb",
                    },
                    data: {
                        query: searchQuery,
                        size: resultSize
                    },
                    success: function(data) {
                        var books = data.documents;
                        var resultsDiv = $("#results");
                        resultsDiv.empty();
                        resultsDiv.append("<h2>검색 결과 " + books.length + "</h2>");

                        if (books.length > 0) {
                            var table = $("<table border='1' id='eventTable'></table>");
                            var tr1 = $("<tr></tr>").html(
                            	"<th>제목</th>" +    		
                            	"<th>저자</th>" +    		
                            	"<th>출판사</th>" +    		
                            	"<th>ISBN</th>" +    		
                            	"<th>이미지</th>" +
                            	"<th>선택</th>"
                            );
                            table.append(tr1);
                            
                            for (var i = 0; i < books.length; i++) {
                                var book = books[i];
                                var tr2 = $("<tr></tr>").html(
                                		
                                    "<td> " + book.title + "</td>" +
                                    "<td> " + book.authors + "</td>" +
                                    "<td> " + book.publisher + "</td>" +
                                    "<td> " + book.isbn + "</td>" +
                                    "<td><img src='" + book.thumbnail + "' width='100px' height='100px' />" +
                                	"<td><form method='post' action='../controller/BookinfoController'>" +
                                	"<input name='bookname' type='hidden' value='" + book.title + "'/>" +
                                	"<input name='authors' type='hidden' value='" + book.authors + "'/>" +
                                	"<input name='publisher' type='hidden' value='" + book.publisher + "'/>" +
                                	"<input name='isbn' type='hidden' value='" + book.isbn + "'/>" +
                                	"<input name='thumbnail' type='hidden' value='" + book.thumbnail + "'/>" +
                                    "<input type='submit' value='선택'></form></td>"
                                    
                                );
                                table.append(tr2);
                            }
                            resultsDiv.append(table);
                        } else {
                            resultsDiv.append("<p>검색 결과가 없습니다.</p>");
                        }
                    },
                    error: function() {
                        var resultsDiv = $("#results");
                        resultsDiv.empty().append("<p>검색 중 오류가 발생했습니다.</p>");
                    }
                });
            });
        });
    </script>
    
</body>
</html>