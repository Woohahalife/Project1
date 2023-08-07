<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="loginStyle.css">
    
</head>
<body>
    <div class="login-page">
        <div class="login-wrapper">
            <h2>Login</h2>
            <form method="post" action="../controller/LoginController" id="login-form">
                <input type="text" name="m_id" placeholder="id">
                <input type="password" name="m_pass" placeholder="Password">
                <label for="remember-check">
                    <input type="checkbox" id="remember-check">아이디 저장하기
                </label>
                <input type="submit" value="Login">
                <input type="button" onclick="location.href='../login/join.jsp'" value="회원가입">
            </form>
        </div>
    </div>





</body>
</html>