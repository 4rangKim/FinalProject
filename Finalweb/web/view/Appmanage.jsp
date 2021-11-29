<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		<style type="text/css">
			.usertable{
				width: 100%;
				margin: 50px;
				border-top: solid 3px gray;
				border-bottom: solid 3px gray;
				text-align: center;
			}
			tr{
				border-top: solid 1px gray;
				border-bottom: solid 1px gray;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<table class="usertable">
				<tr>
					<th>ID</th>
					<th>이름</th>
					<th>차량 번호</th>
					<th>입차 시간</th>
					<th>출차 시간</th>
				</tr>
				<tr>
					<td>lee</td>
					<td>이말순</td>
					<td>12가 3456</td>
					<td>2021-11-29 13:00:00</td>
					<td>2021-11-29 17:00:00</td>
				</tr>
			</table>
		</div>
	</body>
</html>

