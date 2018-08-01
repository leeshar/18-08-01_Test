<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(function() {
	var msg = "${msg}";
	console.log(msg);
	if(msg!="")
		alert(msg);
})
</script>
</head>
<body>
	<a href="/aboard2/user/join">회원 가입</a><br>
	<a href="/aboard2/user/read?id=hasaway11">hasaway11 회원 정보 보기</a><br>
	<a href="/aboard2/board/write">글 쓰기</a><br>
	<a href="/aboard2/board/read?bno=280">글 보기</a>
</body>
</html>