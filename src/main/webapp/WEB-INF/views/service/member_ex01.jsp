<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>member_ex01.jsp</title>
	</head>
	<body>
		<h2>회원 가입(화면 url요청: ContextPath/service/member_ex01
			-서비스 영역으로 연결 위해서. 원래는 컨트롤러로 간다.))</h2>
		<!-- 
		1. join mapping 처리할 수 있는 메서드 생성
		2. command 패키지에 parameter값을 처리할 수 있는 command객체를 joinVO를 생성해서 값을 받음.
		3. service 패키지 생성, JoinService 인터페이스를 생성, JoinService에서 구현할 JoinServiceImpl
			클래스를 생성
		4. JoinServiceImpl을 annotation을 통해 자동객체 생성
		5. Controller 멤버 변수로 해당 객체를 자동 주입 시켜서 동작
		 -->
		 <form action="join" method="post">
		 	ID: <input type="text" name="id" size="10">
		 	PW: <input type="password" name="pw" size="10"><br>
		 	<input type="submit" value="register">
		 
		 </form>
	</body>
</html>