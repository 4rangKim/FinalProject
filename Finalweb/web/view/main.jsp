<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
.mainbox{
	position: relative;
}
.mainimg{
	width: 100%;
	opacity: 0.5;
}
.maintext{
	position: absolute;
	top: 60%;
	left: 40%;
	font-size: 40pt;
	color: #7c6650;
	font-weight: bold;
}
</style>
</head>
<body>
	<header>
		<!-- top -->
		<div class="mainbox">
			<img class="mainimg" alt="" src="img/parking.png">
			<div class="maintext">
				<div>Parking</div>
				<div>Management</div>
			</div>
		</div> <!-- End top -->
		<!-- nav -->
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/Finalweb/main.mc">주자장 관리</a></li>
					<li class="nav-item"><a class="nav-link" href="/Finalweb/user.mc">사용자 관리</a></li>
					<li class="nav-item"><a class="nav-link" href="#"></a></li>
				</ul>
			</div>
		</nav> <!-- End nav -->
	</header>
	<section>
		<c:choose>
			<c:when test="${center == null }">
				<jsp:include page="center.jsp" />
			</c:when>
			<c:otherwise>
				<jsp:include page="${center}.jsp" />
			</c:otherwise>
		</c:choose>
	</section>
	<footer>
		<div class="jumbotron text-center footer">
		  <p>@Final Project - Gruop1</p>
		</div>
	</footer>
</body>
</html>




