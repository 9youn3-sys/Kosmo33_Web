<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.nav {
    background-color: #fdede7;
    padding: 20px;
}

.nav a {
    color: white;
    margin-right: 20px;
    text-decoration: none;
}

.nav a:hover {
    text-decoration: underline;
}
</style>
</head>
<body>

	<h3>글 리스트</h3>
	
	<div class="nav">
		<a href="/comm/create">글 등록</a>
	</div>
	
	<div>
		<table>
			<thead>
				<tr>
					<th>글 번호</th>
					<th>글 제목</th>
					<th>작성자</th>
					<th>내용</th>
					<th>작성시간</th>
					<th>중요도</th>
				</tr>	
							
			</thead>
			
		</table>
	</div>
	
	
</body>
</html>