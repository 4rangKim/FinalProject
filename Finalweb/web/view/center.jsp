<%@page import="com.vo.ParkingVO"%>
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
		 .direcimg{
		 	width: 50px;
		 	height: 50px;
		 	display: inline-block;
		 	margin-top: 200px;
		 }
		 .direc{
		 	text-align: center;
		 }
		 .allpark{
		 	height: 300px;
		 	margin-top: 100px;
		 	border: solid 3px #3e3e33;
		 	border-radius: 20px;
		 }
		 .eachpark{
		 	height: 300px;
		 	margin-top: 100px;
		 	border: solid 3px #3e3e33;
		 	border-radius: 20px;
		 }
		 .parkchart{
		 	width:100%;
		 	height: 500px;
		 	margin-top: 50px;
		 	margin-bottom: 100px;
		 	border: solid 3px #3e3e33;
		 	border-radius: 20px;
		 }
		 .parkname{
		 	text-align: center;
		 	height: 30px;
		 	background-color: #83afe0;
		 	margin: 10px;
		 	border-radius: 10px;
		 }
		 .parkbox{
		 	margin-top: 20px;
		 	margin-bottom: 20px;
		 	padding-left: 70px;
		 }
		 .title{
		 	font-size: 15pt;
		 	font-weight: bold;
		 	margin: 5px;
		 	padding-bottom: 5px;
		 	color: #3e3e33;
		 	border-bottom: solid 1px #cfd3d6;
		 }
		 .parkspace{
		 	width:20px;
		 	height: 30px;
		 	background-color: #b1d284;
		 	margin: 5px;
		 }
		 .spacebox{
		 	padding: 30px;
		 }
		</style>
		<script type="text/javascript">
			$(".parkname").each(function() {
				$(this).click(function() {
					category = $(this).text();
					$(this).attr("class","col-sm-4 active parkname");
					$.ajax({
						url:'/parkajax.mc',
						success:function(data){
							$(data).each(function(idx,item){
								$('#parkname').html(item.parkname);
								$('#E_num').html(item.parkE_num);
							});
						}
					});
				});
			});
		</script>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-sm-5 allpark">
					<p class="title">전체 주차장 현황</p>
					<div class="row parkbox">
						<% for(char i='A';i<8;i++){ %>
							<div class="col-sm-4 parkname">
								주차장<span id="parkname"></span>(<span id="E_num"></span>)
							</div>
						<%}%>
					</div>
				</div>
				<div class="col-sm-2 direc">
					<img class="direcimg" alt="" src="img/direc.png">
				</div>
				<div class="col-sm-5 eachpark">
					<p class="title">주차장1 현황</p>
					<div class="row spacebox">
						<% for(int i=0;i<45;i++){ %>
							<div class="col-sm-1 parkspace">
							</div>
						<%}%>
					</div>
				</div>
			</div>
			<div class="parkchart">
				<p class="title">월별 이용자 현황</p>
			</div>
		</div>
	</body>
</html>


