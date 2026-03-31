<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<style>
.btn {
    display: inline-block;
    padding: 12px 20px;
    margin: 5px;
    background-color: #4CAF50;
    color: white;
    text-decoration: none;
    border-radius: 8px;
}

.btn:hover {
    background-color: #45a049;
}
</style>
</head>
<body>
	<h1>마이페이지</h1>
	
	
	<c:if test="${empty dto}">
		<h3>로그인이 필요합니다.</h3>
		<a href="${pageContext.request.contextPath}/pp/login" class="btn">로그인 하러가기</a>
	</c:if>
	

	<c:if test="${not empty dto}">
		<div>
			<label>이름 : </label>
			<span>${dto.userName}</span>
		</div>

		<div>
			<label>아이디 : </label>
			<span>${dto.userId}</span>
		</div>

		<div>
			<label>비밀번호 : </label>
			<span>********</span>
		</div>

		<div>
			<label>이메일 : </label>
			<span>${dto.userEmail}</span>
		</div>

		<div>
			<a href="${pageContext.request.contextPath}/home" class="btn">메인으로 가기</a>
		</div>
	</c:if>
</body>
</html>