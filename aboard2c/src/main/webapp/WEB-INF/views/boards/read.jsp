<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(function(){

	})
</script>
</head>
<body>
	<div>
		<div id="upper">
			<div id="title"></div>
			<div id="writer"></div>
		</div>
		<div id="lower">
			<div id="left">글번호 : <span id="bno"></span><span id="writeDate"></span></div>
			<div id="right">추천<span id="recommendCnt"></span>조회<span id="readCnt"></span></div>
		</div>
		<div id="body">
			<textarea id="content">
			</textarea>
		</div>
		<div >
			<ul id="attach">
			</ul>
		</div>
		<div id="btnArea">
			<button type="button" id="btnRecommend">추천</button>
    		<button type="button" id="btnReport">신고</button>
		</div>
	</div>

</body>
</html>