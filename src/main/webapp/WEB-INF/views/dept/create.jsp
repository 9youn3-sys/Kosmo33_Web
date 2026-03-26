<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>부서 등록 페이지 </h3>
	
	<form action="/dept/create" method="post">
	<!-- 같은 주소지만 보낼수 있는 법
		메서드 형식을 다르게 보내면됨 get>post / post>get 이런형식 
		 -->
		
		<div>
	 	<lavel>부서명</lavel>
	 	<!-- DTO의 setter의 이름과 동일하게
	 	set빼고 ()빼고 나머지의 앞글자 소문자로  -->
	 	<input type="text" name="departmentName">
	 	<!-- name 쓰는 이유 : 메서드가 post 기 때문에 바디에 가져올 정보 적기 위해 -->
	 	</div>
	 	
	 	
	 	<div>
	 	<!-- 
	 	radio는 하나만 선택해야될때 사용하는 체크박스 -->
	 	<label>관리자코드</label>
	 	<input type="text" name="managerId">
	 	</div>
	 	
	 	<div>
	 	<label>지역코드</label>
	 	<input type="text" name="locationId"> 
	 	</div>
	 	
	 	
	 	<!-- 
	 	버튼 만드는 방법은 2가지 아래처럼 직관적이게 넣을 수도 있고 인풋을 통해 넣을수도 있음 
	 	전송하고 싶으면 타입을 서브밋으로 만들어야함 
	 	-->
	 	<button type="submit">button</button>
	 	</div>
	 	
	 	
	 	<input type="submit" value="create">
	 	<input type="button" value="등록">
	 	<!-- 위 상태의 버튼은 그냥 버튼 모양만 갖추고있음 아무일도안함 -->
	 	<!-- 마찬가지로 기능이 있어도 폼 바깥에 있으면 기능 작동안함 -->
	 	<input type="reset" value="reset">
	 	
	</form>

</body>
</html>