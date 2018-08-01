<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.2/angular.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
<div id="wrap">
	<div ng-app="myApp" ng-controller="myCtrl">
		<table class="table table-dark">	
		
			<tr><th scope="col">글번호</th><th scope="col">제목</th><th scope="col">글쓴이</th><th scope="col">날짜</th><th scope="col">조회수</th></tr>
			<tr ng-repeat="x in resp"><td>{{x.bno}}</td><td>{{x.title}}</td><td>{{x.writer}}</td><td>{{x.writeDate}}</td><td>{{x.readCnt}}</td>
		</table>

	</div>
	<div>
		<ul id="pagination">
		</ul>
		
		<button type="button" id="write" class="btn btn-dark">글쓰기</button>
	</div>
</div>	
<script>
var app = angular.module("myApp",[]);
app.controller("myCtrl", function($scope,$http){
	$http.get("/aboard2/boards2").then(function(response){
		$scope.resp = JSON.parse(response.data.records);
		
	});
})
</script>
</body>
</html>