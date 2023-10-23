<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memLogin_ok.jsp</title>
</head>
<body>
	<h2>Model</h2>
	memId: ${memId }<br>
	memPw: ${memPw }<br>
	<br>
	mem객체 값 확인: ${mem.memId } 와 ${mem.memPw},${mem.name }<br>
	${mem }
</body>
</html>