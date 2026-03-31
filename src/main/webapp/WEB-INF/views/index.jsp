<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
<style>
.menu-box a {
    display: block;
    padding: 15px;
    margin: 10px 0;
    background-color: #f5f5f5;
    text-decoration: none;
    color: black;
    border-radius: 10px;
}

.menu-box a:hover {
    background-color: #ddd;
}
</style>
	</head>
	<body>
	
		<h1>Index Page</h1>
		<div class="menu-box">
		<a href="/comm/list">전달 사항 리스트</a>
		</div>
		
		<div class="menu-box">
		<a href = "/pp/create">회원가입</a>
		</div>
	
		<div class="menu-box">
		<a href = "pp/mypage">My Page</a>
		</div>
	
		<div class="menu-box">
		<c:if test = "${empty dto}"> <!-- 널과 같다면 다시 로그인 창으로 -->
		<a href = "/pp/login">Login</a>
		</c:if>
		</div>
		
		<div class="menu-box">
		<c:if test = "${not empty dto}"> <!-- 널이 아니라면 로그아웃 창으로 -->
		<a href = "/pp/logout">Logout</a>
		</c:if>
		</div>
	</body>
</html>