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
	<h4>부서 리스트</h4>
	<h5>Locale A</h5>
	
	<div>
		<a href="/dept/create">부서등록</a>
	</div>
	
	<div>
		<table>
			<thead>
				<tr>
					<th>부서번호</th>
					<th>부서명</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="d">
					<tr>
						<td>${d.departmentId}</td>
						<td><a href="/dept/detail?departmentId=${d.departmentId}">${d.departmentName}</a></td>
						<!-- 
						./ 현재위치에서 가라  ../한단계 위로 가서 /dept/detail = 절대 경로 ./detail 로 쓰면 현재 위치의
						
						-->
						<!-- 부서명 클릭하면 디테일 화면으로 이동하게 끔 주소 넣어줌 -->
					</tr>
					<!-- 
						getter의 이름 : getter메서드에서
						get을 빼고 () 빼고
						첫글자를 소문자로 바꾼거
						ex) getName() => name
					-->
					
					
					
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>