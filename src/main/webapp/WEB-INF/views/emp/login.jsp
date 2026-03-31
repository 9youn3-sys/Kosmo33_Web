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
	<form action="/emp/login" method = "post"> <!-- 로그인 폼 -->
        <div>
            <label for="employeeId">Employee ID:</label> <!-- 꾸밈 태그 -->
            <input type="text"  name="employeeId" >
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password"  name="password" >
        </div>
        <div>
            <button type="submit">Login</button>
        </div>
</body>
</html>