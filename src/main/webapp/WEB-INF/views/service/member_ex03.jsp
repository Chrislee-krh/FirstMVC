<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		ID: <input type="text" name="id" size="10">
		PW: <input type="password" name="pw" size="10">
		<input type="submit" value="confirm">
		<input type="button" value="register" onclick="location.href='member_ex01'">
	</form>
	
	${msg }<br>
	
</body>
</html>