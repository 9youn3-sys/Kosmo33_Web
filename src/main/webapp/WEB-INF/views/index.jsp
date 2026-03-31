<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Index Page</h1>
		<a href="/dept/list">부서관리</a>
		<a href="/country/list">국가 관리</a>
		
		
		
		<c:if test = "${empty dto}"> <!-- 널과 같다면 다시 로그인 창으로 -->
		<a href = "/emp/login">Login</a>
		</c:if>
	
	
		<c:if test = "${not empty dto}"> <!-- 널이 아니라면 로그아웃 창으로 -->
		<a href = "/emp/logout">Logout</a>
		</c:if>
	</body>
</html>