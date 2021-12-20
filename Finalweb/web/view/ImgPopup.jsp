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
		if(img.equals("inImg")){			
	%>
	<img alt="" src="img/A/In/<%=img %>" style="width: 700px; height: 400px;">
	<%}else if(img.equals("outImg")){ %>
	<img alt="" src="img/A/Out/<%=img %>" style="width: 700px; height: 400px;">
	<%} %>
</body>
</html>