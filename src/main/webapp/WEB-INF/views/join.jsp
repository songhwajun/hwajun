<%@ page pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
	<a href="/">뒤로가기</a>
	<br>
	<form action="/join" method="post">
		<!-- name : 서버로 전송 할 때 변수이름의 역할 -->
	    이메일: <input type="text" name="memberEmail"> <br>
	    비밀번호: <input type="password" name="memberPassword"> <br>
	    이름: <input type="text" name="memberName"> <br>
	    <input type="submit" value="회원가입">
    </form>
</body>


