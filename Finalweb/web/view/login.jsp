<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		<title>Insert title here</title>
		<style type="text/css">
			.container{
				text-align: center;
			}
			.loginbox{
				width: 500px;
				height: 240px;
				border: solid 2px #d0d0d0;
				padding: 30px;
				border-radius: 30px;
				box-shadow: 10px 10px 5px #d0d0d0;
				display: inline-block;    
				position: relative;
   				top: 300px;
			}
			.loginbtn{
				background-color: #afd6ed;
				width: 300px;
				height : 30px;
				border: none;
				border-radius: 30px;
				text-align: center;
				color: white;
				font-size: 15pt;
			}
			.row{
				margin: 10px;
			}
			button {
				margin: 20px;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<div class=loginbox>
			<form class="validation-form" action="/Finalweb/mainlogin.mc" method="post" novalidate>
				<div class="row">
					<div class="col-sm-4">
						<label for="id">아이디</label>
					</div>
					<div class="col-sm-8">
						<input type="text"  name="mgr_id"
							class="form-control"  placeholder="아이디를 입력해주세요."  value=""
							required>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4">
						<label for="pwd">비밀번호</label>
					</div>
					<div class="col-sm-8">
						<input type="password"  name="mgr_pwd"
							class="form-control"  placeholder="비밀번호를 입력해주세요."  value=""
							required>
					</div>
				</div>
					<button class="loginbtn" type="submit">로그인</button>
				</form>
			</div>
		</div>
	</body>
</html>