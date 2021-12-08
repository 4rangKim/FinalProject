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
		</style>
		<script type="text/javascript">
		function inImg(btn){
			var img = $("#"+btn).val();
			window.open("/Finalweb/CarInImg.mc?inImg="+img, "", "width=600, height=400, left=500, top=200");
		}
		function outImg(btn){
			var img = $("#"+btn).val();
			alert(img);
			window.open("/Finalweb/CarOutImg.mc?outImg="+img, "", "width=600, height=400, left=500, top=200");
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
				<tr>
					<td><%=mycar.getCar_seq() %></td>
					<td><%=mycar.getP_id() %></td>
					<td><%=mycar.getMem_id()%></td>
					<td><%=mycar.getCar_num()%></td>
					<td><%=format.format(in_time)%><button class="imgbtn" name ="inImg" id="inImg<%=i %>" onclick="inImg('inImg<%=i%>')" value="<%=mycar.getIn_photo()%>">조회</button></td>
					<td><%=outResult %><button class="imgbtn" name ="outImg" id="outImg<%=i%>" onclick="outImg('outImg<%=i%>')" value="<%=mycar.getOut_photo()%>">조회</button></td>
				</tr>
				<%} %>
			</table>
		</div>
	</body>
</html>

