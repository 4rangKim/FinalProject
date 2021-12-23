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
		String inimg = (String)request.getAttribute("inImg");
		String outimg = (String)request.getAttribute("outImg");
		if(inimg==null){
	%>
		<img alt="" src="img/A/Out/<%=outimg%>" style="width: 700px; height: 400px;">
	<%}else {%>
		<img alt="" src="img/A/In/<%=inimg%>" style="width: 700px; height: 400px;">
	<%} %>
</body>
</html>