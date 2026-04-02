<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/comm/update" method="post">
		<input type="hidden" name="num" value="${dto.num}">

		제목: <input type="text" name="title" value="${dto.title}"><br>
		작성자: <input type="text" name="name" value="${dto.name}"><br>
		내용:
		<textarea name="contents">${dto.contents}</textarea>
		<br> 중요도: <input type="text" name="star"
			value="${dto.star}"><br>

		<button type="submit">수정완료</button>
	</form>
</body>
</html>