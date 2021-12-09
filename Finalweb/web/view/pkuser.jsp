<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.vo.CarVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<style type="text/css">
			.usertable{
				width: 100%;
				text-align: center;
				margin-top: 40px;
			}
			th{
				border-top: solid 2px gray;
				border-bottom: solid 2px gray;
			}
			tr{
				border-top: solid 1px gray;
				border-bottom: solid 1px gray;
			}
			.popup{
				display: none;
		        width: 500px;
		        height: 500px;
		        position: absolute;
		        top:50%;
		        left: 50%;
		        margin: -250px 0 0 -250px;
		        background:#eee;
		        z-index: 2;
			}
			.imgbtn{
				margin-left: 10px;
				margin-top: 5px;
				margin-bottom: 5px;
				border: solid 1px #9abfd1;
				border-radius: 20px;
				color: #9abfd1;
				font-size: 10pt;
				background-color: #f1f2f7;
				cursor: pointer;
			}
			.contenttitle{
				font-weight: bold;
			}
			.btnbox{
				text-align: center;
				margin-top: 30px;
			}
			.btnhead{
				font-size: 18pt;
				font-weight: bold;
				color: #4b88a5;
			}
			.parkname{
				text-align: center; 
				background-color:#f1f2f7; 
				height: 30px; 
				width: 100px; 
				border: solid 1px #4b88a5; 
				margin:10px; 
				border-radius: 5px; 
				display:inline;
				cursor: pointer;
			}
			.parkname:focus {
 				background-color: #4b88a5;
 				color:white;
			}
		</style>
		<script type="text/javascript">
	/* 	function inImg(btn){
			var img = $("#"+btn).val();
			window.open("/Finalweb/CarInImg.mc?inImg="+img, "", "width=600, height=400, left=500, top=200");
		}
		function outImg(btn){
			var img = $("#"+btn).val();
			window.open("/Finalweb/CarOutImg.mc?outImg="+img, "", "width=600, height=400, left=500, top=200");
		} */
		
		function parkbtn(btn){
			category = $("#"+btn).val();
			$.ajax({
				url:"/Finalweb/pkuser/ajax_list.mc",
				type:"get",
				data:{"category":category},
				success:function(data){
					mydata="<tr><th>순번</th><th>주차장 번호</th><th>ID</th><th>차량 번호</th><th>입차 시간</th><th>출차 시간</th></tr>";
					for(i=0;i<data.length;i++){
						 mydata = mydata + "<tr>"+
							"<td>"+data[i].car_seq+"</td>"+
							"<td>"+data[i].p_id+"</td>"+
							"<td>"+data[i].mem_id+"</td>"+
							"<td>"+data[i].car_num+"</td>"+
							"<td>"+data[i].in_time+"<button class='imgbtn' name ='inImg' id='inImg' value='"+data[i].in_photo+"'>조회</button></td>"+
							"<td>"+data[i].out_time+"<button class='imgbtn' name ='outImg' id='outImg' value='"+data[i].out_photo+"'>조회</button></td>"+
							"</tr>"	
					}
					
					$("#usertable").empty();
					$("#usertable").append(mydata);
					
					$(".imgbtn").each(function(){
						$(this).click(function(){
							img = $(this).val();
							window.open("/Finalweb/CarInImg.mc?inImg="+img, "", "width=600, height=400, left=500, top=200");
						});
					});
				}
			})//end ajax
		}
		
		
		</script> 
	</head>
	<body>
	 <% ArrayList<CarVO> pkuserList = (ArrayList<CarVO>)request.getAttribute("pkuserList"); 
		int size = pkuserList.size();

	%>
	
		<div class="breadcrumbs" >
            <div class="col-sm-4">
                <div class="page-header float-left">
                    <div class="page-title">
                        <h1 class="contenttitle">주차장 이용 고객 현황</h1>
                    </div>
                </div>
            </div>
        </div>

		<div class="container">
			<div class="btnbox" id="btnbox">
				<span class="btnhead">주차장&nbsp;&nbsp;&nbsp;</span>
				<% for(char i='A';i<='H';i++){ %>
					<button class="parkname" id="parkbtn<%=i%>" value="<%=i%>" onclick="parkbtn('parkbtn<%=i%>')">
						<%=i%>
					</button>
				<%}%>
			</div>
			<table class="usertable" id="usertable">
 				<tr>
					<th>순번</th>
					<th>주차장 번호</th>
					<th>ID</th>
					<th>차량 번호</th>
					<th>입차 시간</th>
					<th>출차 시간</th>
				</tr>
				<%for(int i=0;i<size;i++){ 
					CarVO mycar = pkuserList.get(i);
					Date in_time = mycar.getIn_time();
					Date out_time = mycar.getOut_time();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String outResult ="";
					if(out_time==null){
						outResult = "-";
					}else{
						outResult = format.format(out_time);
					}
					%>
				<tr id="userlist">
					<td id="car_seq"><%=mycar.getCar_seq() %></td>
					<td id="p_id"><%=mycar.getP_id() %></td>
					<td id="mem_id"><%=mycar.getMem_id()%></td>
					<td id="car_num"><%=mycar.getCar_num()%></td>
					<td id="in_time"><%=format.format(in_time)%><button class="imgbtn" name ="inImg" id="inImg<%=i %>" onclick="inImg('inImg<%=i%>')" value="<%=mycar.getIn_photo()%>">조회</button></td>
					<td id="out_time"><%=outResult %><button class="imgbtn" name ="outImg" id="outImg<%=i%>" onclick="outImg('outImg<%=i%>')" value="<%=mycar.getOut_photo()%>">조회</button></td>
				</tr>
				<%} %>
			</table>
		</div>
	</body>
</html>

