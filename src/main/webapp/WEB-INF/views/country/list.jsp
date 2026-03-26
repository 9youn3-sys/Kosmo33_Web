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
	<h4>Country Page</h4>
	<h5>Locale A</h5>
	
	<div>
		<a href="/country/create">국가 등록</a>
	</div>
	
	<div>
		<table>
			<thead>
				<tr>
					<th>국가 약자명</th>
					<th>국가 이름</th>
					<th>국가 번호</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="c">
					<tr>
						<td>${c.countryId}</td>
						<td><a href="/country/detail?countryId=${c.countryId}">${c.countryName}</a>></td>
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