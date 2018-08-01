<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<form action="/aboard2/board/write" method="post" id="writeForm" class="col s12" enctype="multipart/form-data">
		<input type="text" name="title" id="title">
		<textarea id="content" id="content" name="content"></textarea>
		<input type="file" name="files" id="files" multiple="multiple">
		<button type="submit" id="write">작성하기</button>
	</form>
</body>
</html>