<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>글 등록</h3>

<form action="/comm/create" method ="post">

제목 : <input type="text" name="title"><br>
작성자 : <input type="text" name="name"><br>
내용 : <textarea name="contents"></textarea><br>
중요도 : <input type="text" name="star"><br>

<button type="submit">등록</button>


</form>
</body>
</html>