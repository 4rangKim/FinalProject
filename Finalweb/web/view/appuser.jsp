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
				margin-top: 50px;
				margin-bottom:50px;
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
			.Search{
				margin-top: 30px;
				text-align: right;				
			}
			.searchText{
				margin-left: 10px;
				margin-right: 5px;
				border: solid 1px #dcdeeb;
			}
			.searchname{
				color: #737373;
				margin-left: 40px;
			}
			.search{
				border:none;
				background-color: #ffffff;
				cursor: pointer;
			}
			.searchimg{
				width: 30px;
				height: 30px;
			}
			#myoption{
				text-align: center;
				border: solid 1px #dcdeeb;
				padding: 3px;
				color: #737373;
			}
			select:focus {
				outline:none;
			}
			.allbtn{
				margin-top: 30px;
				margin-left: 20px;
				border: solid 1px #dcdeeb;
				border-radius: 15px;
				width: 50px;
				cursor: pointer;
				background-color: #ffffff;
			}
			.allbtn:focus{
				background-color: #dcdeeb;
				color:#ffffff;
			}
	</style>
	<script type="text/javascript">
		function allsearch(){
			$.ajax({
				url:"/Finalweb/app/allsearch.mc",
				type:"get",
				data:{"tag":tag,"search":search},
				success:function(data){
					mydata="<tr><th>ID</th><th>이름</th><th>전화 번호</th><th>차량1</th><th>차량2</th><th>포인트</th></tr>";
					if(data.length==0){
						mydata = mydata + "<tr><td colspan='6' style='padding:10px; color:gray;'>조회된 사용자가 없습니다.</td><tr>";
					}else{
						for(i=0;i<data.length;i++){
							 if(data[i].mem_car2==null){
								 mydata = mydata + "<tr>"+
									"<td>"+data[i].mem_id+"</td>"+
									"<td>"+data[i].mem_name+"</td>"+
									"<td>"+data[i].mem_tel+"</td>"+
									"<td>"+data[i].mem_car1+"</td>"+
									"<td>-</td>"+
									"<td>"+data[i].mem_money+"</td>"+
									"</tr>"
							}else{
								 mydata = mydata + "<tr>"+
									"<td>"+data[i].mem_id+"</td>"+
									"<td>"+data[i].mem_name+"</td>"+
									"<td>"+data[i].mem_tel+"</td>"+
									"<td>"+data[i].mem_car1+"</td>"+
									"<td>"+data[i].mem_car2+"</td>"+
									"<td>"+data[i].mem_money+"</td>"+
									"</tr>"
							}
						}
					}
					$(".usertable").empty();
					$(".usertable").append(mydata);
					$("#searchText").val("");
				}
			});//end ajax
			
		}
 		function listsearch(){
 			//alert("버튼눌림");
			tag = $("#myoption option:selected").val();
			search =$("#searchText").val();
			//alert(tag);
			//alert(search);
			$.ajax({
				url:"/Finalweb/app/search.mc",
				type:"get",
				data:{"tag":tag,"search":search},
				success:function(data){
					mydata="<tr><th>ID</th><th>이름</th><th>전화 번호</th><th>차량1</th><th>차량2</th><th>포인트</th></tr>";
					if(data.length==0){
						mydata = mydata + "<tr><td colspan='6' style='padding:10px; color:gray;'>조회된 사용자가 없습니다.</td><tr>";
					}else{
						for(i=0;i<data.length;i++){
							 if(data[i].mem_car2==null){
								 mydata = mydata + "<tr>"+
									"<td>"+data[i].mem_id+"</td>"+
									"<td>"+data[i].mem_name+"</td>"+
									"<td>"+data[i].mem_tel+"</td>"+
									"<td>"+data[i].mem_car1+"</td>"+
									"<td>-</td>"+
									"<td>"+data[i].mem_money+"</td>"+
									"</tr>"
							}else{
								 mydata = mydata + "<tr>"+
									"<td>"+data[i].mem_id+"</td>"+
									"<td>"+data[i].mem_name+"</td>"+
									"<td>"+data[i].mem_tel+"</td>"+
									"<td>"+data[i].mem_car1+"</td>"+
									"<td>"+data[i].mem_car2+"</td>"+
									"<td>"+data[i].mem_money+"</td>"+
									"</tr>"
							}
						}
					}
					$(".usertable").empty();
					$(".usertable").append(mydata);
				}
			});//end ajax
		};
		
		$(document).ready(function(){
			$("#searchText").keyup(function(e){if(e.keyCode == 13)  listsearch(); });
		});
		
	</script>
</head>
<body>
	 <%
		ArrayList<MemberVO> memberlist = (ArrayList<MemberVO>)request.getAttribute("memberlist"); 
		int size = memberlist.size();
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
		
		<div class="col-xl-12" >
			<div class="card" style="padding-bottom: 40px;">
				<div class="container">
						<div class="Search">
							<select id="myoption" name="tag">
								<option value="id">ID</option>
								<option value="name">이름</option>
								<option value="carnum">차량 번호</option>
							</select> 
							<input type="text" class="searchText" id="searchText" name="search" /> 
							<button type="button" class="search" id="listsearch" onclick="listsearch()"><img src="img/search.png" class="searchimg"/></button>
							<button class="allbtn" onclick="allsearch()">All</button>
						</div>
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
							MemberVO user = memberlist.get(i);
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
			</div>
		</div>
</body>
</html>