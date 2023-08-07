<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="joinStyle.css" />
</head>
<body>

    <div class="join-page">
        <div class="join-wrapper">
            <h2>회원가입</h2>
            <form method="post" action="../controller/JoinController" id="join-form">
                <input type="text" name="m_id" placeholder="id">
                <input type="text" name="m_pass" placeholder="pass">
                <input type="text" name="m_name" placeholder="name">
                <input type="text" name="m_email" placeholder="email">
                <input type="text" name="m_nickname" placeholder="nickname">
              
                <input type="submit" value="회원가입">
            </form>
        </div>
    </div>


</body>
</html>