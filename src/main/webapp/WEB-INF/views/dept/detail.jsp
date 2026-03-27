<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>DEPT Detail Page</h1>
	
	<h4>${dto.departmentId}</h4>
	<h4>${dto.departmentName}</h4>
	<h4>${dto.managerId}</h4>
	<h4>${dto.locationId}</h4>
	
	
	<a href= "./update?departmentId=${dto.departmentId}">수정</a>
	<a href= "./delete?departmentId=${dto.departmentId}">삭제</a>
	<!-- departmentid를 삭제 하기 위한 -->
	
	<form action="./delete" method = "get">
		<input type="hidden" name="departmentId" value = "${dto.departmentId}" >
		
		<button>DELETE</button>
	</form>
	<!-- form으로 하는 방법  -->
	
	<!-- 
	
	input속성의 value값은  
	
	-->
	
	<!-- 
	readonly, disabled 수정못하게 막아 둠 disabled는 파라미터로 안넘어감 
	readonly는 파라미터로 넘어감 
	-->
	
</body>
</html>