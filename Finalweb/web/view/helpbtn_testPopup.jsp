<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
body{
	background: #434343;
}

#btnimg{
	width: 100px;
	height: 30%;
	margin-top: 30px;
}

button{
background: inherit ; border:none; box-shadow:none; border-radius:0; padding:0; overflow:visible; cursor:pointer
}

#btn{
	margin-top: 10px;
}

</style>


<body>
	<div style="text-align: center; color: white;"><h4>관리자에게 도움 요청하기</h4></div>
	<div style="text-align: center">
		<form action="/Finalweb/webNotification.mc" metoh="post" target="iframe1">
			<select name="P_id">
				<option value="selected">주차장을 선택해주세요</option>
				<option value="A">A주차장</option>
				<option value="B">B주차장</option>
				<option value="C">C주차장</option>
				<option value="D">D주차장</option>
				<option value="E">E주차장</option>
				<option value="F">F주차장</option>
				<option value="G">G주차장</option>
				<option value="H">H주차장</option>
			</select>
			<select name="askHelp">
				<option value="selected">요청 내용을 선택해주세요</option>
				<option value="open_in">입구 차단기 열어주세요</option>
				<option value="open_out">출구 차단기 열어주세요</option>
			</select>
			<button type="submit" id="btn"><img src="img/help_forTest.png" id="btnimg"></button>
		</form>
		<iframe id="iframe1" name="iframe1" style="display:none"></iframe>
	</div>
	

</body>
</html>