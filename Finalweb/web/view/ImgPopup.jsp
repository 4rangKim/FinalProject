<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String img = (String)request.getAttribute("Img"); 
	%>
	<img alt="" src="img/<%=img %>" style="width: 700px; height: 400px;">
</body>
</html>