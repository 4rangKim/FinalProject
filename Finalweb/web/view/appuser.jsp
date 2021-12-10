<%@page import="com.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
			.usertable{
				width: 100%;
				margin: 50px;
				text-align: center;
			}
			th{
				border-top: solid 2px gray;
				border-bottom: solid 2px gray;
			}
			tr{
				border-top: solid 1px gray;
				border-bottom: solid 1px gray;
			}
			.contenttitle{
				font-weight: bold;
			}
</style>
</head>
<body>
	 <% ArrayList<MemberVO> appuserList = (ArrayList<MemberVO>)request.getAttribute("appuserList"); 
		int size = appuserList.size();
	%>
	
		<div class="breadcrumbs" >
            <div class="col-sm-4">
                <div class="page-header float-left">
                    <div class="page-title">
                        <h1 class="contenttitle">APP 이용자 조회</h1>
                    </div>
                </div>
            </div>
        </div>

		<div class="container">
			<table class="usertable">
				<tr>
					<th>ID</th>
					<th>이름</th>
					<th>전화 번호</th>
					<th>차량1</th>
					<th>차량2</th>
					<th>포인트</th>
				</tr>
				<tr>
				<%for(int i=0;i<size;i++){ 
					MemberVO user = appuserList.get(i);
					String car2 ="";
					if(user.getMem_car2()==null){
						car2 = "-";
					}else {
						car2 = user.getMem_car2();
					}
				%>
				<tr>
					<td><%=user.getMem_id() %></td>
					<td><%=user.getMem_name() %></td>
					<td><%=user.getMem_tel() %></td>
					<td><%=user.getMem_car1() %></td>
					<td><%=car2 %></td>
					<td><%=user.getMem_money() %></td>
				</tr>
				<%} %>
			</table>
		</div>
</body>
</html>