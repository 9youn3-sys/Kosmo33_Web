<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>People Create Page</h1>
	

		<form action="/pp/create" method="post">
		
			<div>
				<label for="name">NAME: </label>
				<input type="text" name="userName"> 
			</div>
			
			<div>
				<label for="id">User ID: </label>
				<input type="text" name="userId">
			</div>
			
			<div>
				<label for="password">User PW: </label>
				<input type="text" name="userPw">
			</div>
			
			<div>
				<label for="email">User Email: </label>
				<input type="text" name="userEmail">
				
			</div>
			
			<div>
				<button type="submit">Create</button>
			</div>	
		
		</form>
   
</body>
</html>