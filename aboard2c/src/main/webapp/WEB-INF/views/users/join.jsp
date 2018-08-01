<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(function() {

	})
</script>
</head>
<body>
	아이디:<input type="text" id="id"><button id="idCheck">중복확인</button>
	<span id="id_helper"></span><br>
	이름:<input type="text" id="irum"><br>
	비밀번호:<input type="password" id="pwd"><br>
	비밀번호 확인:<input type="password" id="pwd2"><br>
	이메일:<input type="text" id="email1">@<input type="text" id="email2">
		<select id="selectEmail">
			<option selected="selected">직접 입력</option>
			<option>naver.com</option>
			<option>gmail.com</option>
			<option>daum.net</option>
		</select> 
		<br>
	연락처:	<input type="text" id="tel1" size="10" maxlength="3">-
			<input type="text" id="tel2" size="10" maxlength="4">-
			<input type="text" id="tel3" size="10" maxlength="4">
	<br>
	생년월일: <input type="date" id="birthDate">
	<br>
	<button id="join">가입하기</button>
</body>
</html>



