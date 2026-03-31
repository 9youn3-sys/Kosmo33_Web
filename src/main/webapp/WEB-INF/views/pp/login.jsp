<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Form Page</h1>
	
	<c:if test="${not empty msg}">
    <div style="color:red;">
        ${msg}
    </div>
</c:if>

	<form action="/pp/login" method = "post"> <!-- 로그인 폼 -->
        <div>
            <label for="userId">ID: </label> <!-- 꾸밈 태그 -->
            <input type="text"  name="userId" >
        </div>
        <div>
            <label for="userPw">PW: </label>
            <input type="password"  name="userPw" >
        </div>
        <div>
            <button type="submit">Login</button>
        </div>
</body>
</html>