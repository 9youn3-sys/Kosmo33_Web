<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>

	<h3>글 상세 보기</h3>
	<table>

		<tr>
			<th>글 번호</th>
			<td>${dto.num}</td>
		</tr>

		<tr>
			<th>제목</th>
			<td>${dto.title}</td>
		</tr>

		<tr>
			<th>작성자</th>
			<td>${dto.name}</td>
		</tr>

		<tr>
			<th>내용</th>
			<td>${dto.contents}</td>
		</tr>

		<tr>
			<th>작성시간</th>
			<td>${dto.createTime}</td>
		</tr>

		<tr>
			<th>중요도</th>
			<td>${dto.star}</td>
		</tr>

		<div class="btn-box">
			<a href="/comm/update?num=${dto.num}">수정</a> <a
				href="/comm/delete?num=${dto.num}">삭제</a> <a href="/comm/list">목록</a>
		</div>

	</table>
</body>
</html>