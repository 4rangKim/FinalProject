<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.highcharts.com/modules/exporting.js"></script>
	<script src="https://code.highcharts.com/modules/export-data.js"></script>
	<script src="https://code.highcharts.com/modules/accessibility.js"></script>

    <script type="text/javascript">
    	function csstest(){
    		//$("#in_checkboxA").css("border","solid red 3px");
    		$("#in_checkboxA").css("animation","blink-effect 1s step-end infinite");

    	}
    	function displayCHART2(d){
    		Highcharts.chart('chart_container', {
    		    chart: {
    		        plotBackgroundColor: null,
    		        plotBorderWidth: null,
    		        plotShadow: false,
    		        type: 'pie'
    		    },
    		    title: {
    		        text: null
    		    },
    		    tooltip: {
    		        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    		    },
    		    accessibility: {
    		        point: {
    		            valueSuffix: '%'
    		        }
    		    },
    		    plotOptions: {
    		        pie: {
    		            allowPointSelect: true,
    		            cursor: 'pointer',
    		            dataLabels: {
    		                enabled: true,
    		                format: '<b>{point.name}</b>: {point.percentage:.1f} %'
    		            }
    		        }
    		    },
    		    /* series: [{
    		        name: 'Brands',
    		        colorByPoint: true,
    		        data: [{
    		            name: 'Chrome',
    		            y: 2,
    		            sliced: true,
    		            selected: true
    		        }, {
    		            name: 'Internet Explorer',
    		            y: 1
    		        }, {
    		            name: 'Firefox',
    		            y: 1
    		        }, {
    		            name: 'Edge',
    		            y: 1
    		        }, {
    		            name: 'Safari',
    		            y: 1
    		        }, {
    		            name: 'Sogou Explorer',
    		            y: 1
    		        }, {
    		            name: 'Opera',
    		            y: 1
    		        }, {
    		            name: 'QQ',
    		            y: 1
    		        }, {
    		            name: 'Other',
    		            y: 1
    		        }]
    		    }] */
    		    
    		    series:d
    		    
    		});
    	}
			
    	function getdataforpieCHART(){
    		$.ajax({
    			url:"piechart.mc",
    			success:function(d){
    				displayCHART2(d);
    			}
    		})
    	}
    	
    	function changeCamera(a,b){
    		$(a).empty();
    		$(a).append("<iframe src="+b+" allow='autoplay' frameborder='0' width='100%' height='250px' scrolling='no' style='margin: 0 auto;'></iframe>");
    	}
    	
    	
    	//****************스위치 버튼 ajax******
		function in_control(btn){
			
    		/* 웹 알림으로 생성된 css(border)를 버튼을 누르면 없어지게 하는 코드*/
    		camidforchange = '#'+btn.substring(8)+'box';
    		camname='#selectedP'+btn.substring(8);
    		$(camidforchange).css("animation","");
    		$(camname).css("color","black");
    		btn2='#in_'+btn
    		parkid = '#parkname'+btn.substring(8);
			$(btn2).css("animation","");
			$(parkid).css("color","black");
    		/*===================================================*/
    		
			position = $("#"+btn).val();
			if($("#checkbox"+position).is(':checked')){
				alert(position+" 입구차단기 on");
			}else{
				alert(position+" 입구차단기 off");
			}
			//alert(position);
			$.ajax({
				success:function(){
					//alert(position);
					$("#checkbox"+position).each(function(){
						$(".inBtnstate"+position).toggle();
					});
				}
			});
		};
		
		
		function out_control(btn){
			
			/* 웹 알림으로 생성된 css(border)를 버튼을 누르면 없어지게 하는 코드*/
			camidforchange = '#'+btn.substring(8)+'box';
    		camname='#selectedP'+btn.substring(8);
    		$(camidforchange).css("animation","");
    		$(camname).css("color","black");
			btn2='#out_'+btn
			parkid = '#parkname'+btn.substring(8);
			$(btn2).css("animation","");
			$(parkid).css("color","black");
			/*===================================================*/
			
			position = $("#"+btn).val();
			//alert(position);
			$.ajax({
				success:function(){
					//alert(position);
					$("#checkbox"+position).each(function(){
						$(".outBtnstate"+position).toggle();
					});
				}
			});
		};
		//***************************************************
    	
    	
    	
    	
	/*==================vv================도큐먼트 레디========================================  */
		$(document).ready(function(){
			
			getdataforpieCHART();
			
			
		});
	</script>
	
   	<style type="text/css">
   		.contenttitle{
			font-weight: bold;
		}
		
		.display-6{
			margin-bottom: 3%;
		}
		
		.camera_btn{
			border: solid #D2D2D2 2px;
			border-radius: 5px;
			color : black;
			cursor: pointer;
		}
		
		.camera_btn:focus{
			background-color: #8DC560;
			border : solid #5E8340 2px;
			color:white;
			font-weight: bold;
		}
		.cameraSection{
			border: solid #DFDFDF 1px;
		}
		.charttitle{
			text-align: center;
			margin-top: 20px;
			margin-bottom: 50px;
			font-size: 13pt;
			color: #434550;
			font-weight: bold;
			display:inline-block;
			border-bottom: solid 2px #9bafb7;
			border-top: solid 2px #9bafb7;
			padding: 10px;
		}
		.card-body{
			text-align: center;
		}
		
				/*--------스위치 css--------------*/
		/* The switch - the box around the slider */
		.switch {
		  position: relative;
		  display: inline-block;
		  width: 60px;
		  height: 34px;
		  vertical-align:middle;
		}
		
		/* Hide default HTML checkbox */
		.switch input {
			display:none;
		}
		
		/* The slider */
		.slider {
		  position: absolute;
		  cursor: pointer;
		  top: 0;
		  left: 0;
		  right: 0;
		  bottom: 0;
		  background-color: #ccc;
		  -webkit-transition: .4s;
		  transition: .4s;
		}
		
		.slider:before {
		  position: absolute;
		  content: "";
		  height: 26px;
		  width: 26px;
		  left: 4px;
		  bottom: 4px;
		  background-color: white;
		  -webkit-transition: .4s;
		  transition: .4s;
		}
		
		input:checked + .slider {
		  background-color: #2196F3;
		}
		
		input:focus + .slider {
		  box-shadow: 0 0 1px #2196F3;
		}
		
		input:checked + .slider:before {
		  -webkit-transform: translateX(26px);
		  -ms-transform: translateX(26px);
		  transform: translateX(26px);
		}
		
		/* Rounded sliders */
		.slider.round {
		  border-radius: 34px;
		}
		
		.slider.round:before {
		  border-radius: 50%;
		}
		
		p {
			margin:0px;
			display:inline-block;
			font-size:15px;
			font-weight:bold;
		}
		/*--------스위치 css--------------*/
		
		.controltb{
			margin:50px;
			text-align: center;
		}
		td{
			padding-bottom: 20px;
			padding-top: 20px;
			border-bottom: solid 1px #b5b3b4;
		}
		th{
			padding-top: 10px;
			padding-bottom: 10px;
			border-bottom: solid 2px #b5b3b4;
			border-top: solid 2px #b5b3b4;
			margin-bottom: 20px;
		}
		.gate{
			font-weight: bold;
			font-size: 20pt;
		}
		.in{
			color: #719ae6;
		}
		.out{
			color: #fa612e;
		}
		.parkname{
			font-weight: bold;
			font-size: 15pt;
		}
		
		@keyframes blink-effect {
			50% { border: solid #e16040 3px } 
		}
		@keyframes blink-effect2 {
			50% { border: solid #84b5f0 3px } 
		}
   	</style>
   	
   	
   	<%
   	HashMap<String,String> cameramap = new HashMap<>();
   	cameramap.put("A_InCamera","https://www.youtube.com/embed/5HcgHcU_4go?autoplay=1&mute=1&amp;playlist=5HcgHcU_4go&amp;loop=1");
   	cameramap.put("A_OutCamera","https://www.youtube.com/embed/NXt-YY3Xt8Q?autoplay=1&mute=1&amp;playlist=NXt-YY3Xt8Q&amp;loop=1");
   	cameramap.put("B_InCamera","https://www.youtube.com/embed/ke4v1v2h9yQ?autoplay=1&mute=1&amp;playlist=ke4v1v2h9yQ&amp;loop=1");
   	cameramap.put("B_OutCamera","https://www.youtube.com/embed/UZFm-kg3PaE?autoplay=1&mute=1&amp;playlist=UZFm-kg3PaE&amp;loop=1");
   	cameramap.put("C_InCamera","https://www.youtube.com/embed/uMZO2qXElgg?autoplay=1&mute=1&amp;playlist=uMZO2qXElgg&amp;loop=1");
   	cameramap.put("C_OutCamera","https://www.youtube.com/embed/NXt-YY3Xt8Q?autoplay=1&mute=1&amp;playlist=NXt-YY3Xt8Q&amp;loop=1");
   	cameramap.put("D_InCamera","https://www.youtube.com/embed/n1bqkBEZKMA?autoplay=1&mute=1&amp;playlist=n1bqkBEZKMA&amp;loop=1");
   	cameramap.put("D_OutCamera","https://www.youtube.com/embed/NXt-YY3Xt8Q?autoplay=1&mute=1&amp;playlist=NXt-YY3Xt8Q&amp;loop=1");
   	cameramap.put("E_InCamera","https://www.youtube.com/embed/IXCYY6CFoYw?autoplay=1&mute=1&amp;playlist=IXCYY6CFoYw&amp;loop=1");
   	cameramap.put("E_OutCamera","https://www.youtube.com/embed/NXt-YY3Xt8Q?autoplay=1&mute=1&amp;playlist=NXt-YY3Xt8Q&amp;loop=1");
   	cameramap.put("F_InCamera","https://www.youtube.com/embed/U7HRKjlXK-Y?autoplay=1&mute=1&amp;playlist=U7HRKjlXK-Y&amp;loop=1");
   	cameramap.put("F_OutCamera","https://www.youtube.com/embed/NXt-YY3Xt8Q?autoplay=1&mute=1&amp;playlist=NXt-YY3Xt8Q&amp;loop=1");
   	cameramap.put("G_InCamera","https://www.youtube.com/embed/ncYZktE7c1E?autoplay=1&mute=1&amp;playlist=ncYZktE7c1E&amp;loop=1");
   	cameramap.put("G_OutCamera","https://www.youtube.com/embed/NXt-YY3Xt8Q?autoplay=1&mute=1&amp;playlist=NXt-YY3Xt8Q&amp;loop=1");
   	cameramap.put("H_InCamera","https://www.youtube.com/embed/NW-rXqCl7us?autoplay=1&mute=1&amp;playlist=NW-rXqCl7us&amp;loop=1");
   	cameramap.put("H_OutCamera","https://www.youtube.com/embed/NXt-YY3Xt8Q?autoplay=1&mute=1&amp;playlist=NXt-YY3Xt8Q&amp;loop=1");
   	%>
    
</head>
<body>
        <div class="breadcrumbs" >
            <div class="col-sm-4">
                <div class="page-header float-left">
                    <div class="page-title">
                        <h1 class="contenttitle">관리 주차장 모니터링</h1>
                    </div>
                </div>
            </div>
        </div>
    
			<!-- ===========주차장 현황================================================================ -->
		<div>
			<div class="col-xl-12" >
                <div class="card">
					<div class="row" style="width : 100%; margin:0 auto;">
					
					
						<%
						for(char i ='A'; i<='H';i++){
						%>
							<div style="width: 25%; float: left; " >
				                <section class="cameraSection" id="<%=i%>box">
				                    <div id=<%=i%>>
				                    	
				                    	<iframe src=<%=cameramap.get(i+"_InCamera")%> allow='autoplay' frameborder='0' width='100%' height='250px' scrolling='no' style='margin: 0 auto;'>
				                    	</iframe>
				                    	
				                    </div>
				                    <div class="weather-category twt-category"style="height: 110px;">
				                        <ul>
				                            <div class="media" style="text-align: center;">
					                            <div class="media-body">
					                                <h3 class="display-6" id="selectedP<%=i%>" style="color: #343a40;"><%=i%> 주차장</h3>
					                                
					                                <button class="camera_btn" onclick="changeCamera('#<%=i%>','<%=cameramap.get(i+"_InCamera")%>')">입차 카메라</button>
					                               	<button class="camera_btn" onclick="changeCamera('#<%=i%>','<%=cameramap.get(i+"_OutCamera")%>')">출차 카메라</button>
					                               	<button class="camera_btn" onclick="csstest()">csstest</button>
					                               	
					                               	
					                            </div>
					                        </div>
				                        </ul>
				                    </div>
				                    
				                </section>
				            </div>
						<%	
						}
						%>
						
						<!-- ###########################카메라 생성 참고 코드############################################################### -->
						<!-- <div style="width: 25%; float: left; " >
			                <section>
			                    <div id="iframediv1">
			                    	
			                    	<iframe src='https://www.youtube.com/embed/5HcgHcU_4go?autoplay=1&mute=1&amp;playlist=5HcgHcU_4go&amp;loop=1' allow='autoplay' frameborder='0' width='100%' height='250px' scrolling='no' style='margin: 0 auto;'>
			                    	</iframe>
			                    	
			                    </div>
			                    <div class="weather-category twt-category"style="height: 90px;">
			                        <ul>
			                            <div class="media" style="text-align: center;">
				                            <div class="media-body">
				                                <h3 class="display-6" id="selectedP" style="color: #343a40;">A 주차장</h3>
				                                <button class="camera_btn" onclick="changeCamera('#iframediv1','https://www.youtube.com/embed/5HcgHcU_4go?autoplay=1&mute=1&amp;playlist=5HcgHcU_4go&amp;loop=1')">입차 카메라</button>
				                               	<button class="camera_btn" onclick="changeCamera('#iframediv1','https://www.youtube.com/embed/NXt-YY3Xt8Q?autoplay=1&mute=1&amp;playlist=NXt-YY3Xt8Q&amp;loop=1')">출차 카메라</button>
				                               	<p style="font-size: 14px">차량 번호 확인</p>
				                               	
				                            </div>
				                        </div>
			                        </ul>
			                    </div>
			                    
			                </section>
			            </div> -->
			            
					</div>
					
					
					
				</div>
			</div>
					
		
		</div>
        <!-- ^^===========주차장 현황================================================================ -->

		<!-- +++++++++++++++++++++차단기 제어+++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		 <div class="breadcrumbs" >
            <div class="col-sm-4">
                <div class="page-header float-left">
                    <div class="page-title">
                        <h1 class="contenttitle">차단기 제어시스템</h1>
                    </div>
                </div>
            </div>
        </div>
		
		
		<div class="col-xl-12" >
			<div class="card">
					<table class="controltb">
						<tr>
							<th></th>
							<% for(char i='A';i<='H';i++){ %>
								<th class="parkname" id="parkname<%=i%>"><%=i %>&nbsp;주차장</th>
							<%}%>
						</tr>
						<tr>
							<td class="in gate">IN</td>
							<% for(char i='A';i<='H';i++){ %>
								<td id="in_checkbox<%=i%>">
									<label class="switch">
										<input type="checkbox" id="checkbox<%=i%>" value="<%=i%>" onclick="in_control('checkbox<%=i%>')">
										<span class="slider round"></span>	
									</label>
									<p class="inBtnstate<%=i%>" >OFF</p>
									<p class="inBtnstate<%=i%>" style="display:none;">ON</p>
								</td>
							<%}%>
						</tr>
						<tr>
							<td class="out gate">OUT</td>
							<% for(char i='A';i<='H';i++){ %>
								<td id="out_checkbox<%=i%>">
									<label class="switch">
										<input type="checkbox" id="checkbox<%=i%>" value="<%=i%>" onclick="out_control('checkbox<%=i%>')">
										<span class="slider round"></span>	
									</label>
									<p class="outBtnstate<%=i%>" >OFF</p>
									<p class="outBtnstate<%=i%>" style="display:none;">ON</p>
								</td>
							<%}%>
						</tr>
					</table>
			</div>
		</div>
		<!-- +++++++++++++++++++++차단기 제어+++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

			<!-- ********************************그래프************************************************************************************************************** -->
		<div>
            <div class="col-xl-12" >
                <div class="card">
                    <div class="card-body">
                        <!-- <div class="row">
                            <div class="col-sm-4">
                                <h4 class="card-title mb-0">Traffic</h4>
                                <div class="small text-muted">ParkingPanda</div>
                            </div>
                            /.col
                            <div class="col-sm-8 hidden-sm-down">
                                
                                <div class="btn-toolbar float-right" role="toolbar" aria-label="Toolbar with button groups">
                                    <div class="btn-group mr-3" data-toggle="buttons" aria-label="First group">
                                    	<label class="btn btn-outline-secondary">
                                            <input type="radio" name="options" id="option5" onchange="getdataforAvgCHART()"> Avg Count
                                        </label>
                                    	<label class="btn btn-outline-secondary">
                                            <input type="radio" name="options" id="option0" onchange="getdataforHCHART()"> Hour
                                        </label>
                                        <label class="btn btn-outline-secondary">
                                            <input type="radio" name="options" id="option1" checked="" onchange="getdataforDCHART()"> Day
                                        </label>
                                        <label class="btn btn-outline-secondary active">
                                            <input type="radio" name="options" id="option2"  onchange="getdataforMCHART()"> Month
                                        </label>
                                        <label class="btn btn-outline-secondary">
                                            <input type="radio" name="options" id="option3" onchange="getdataforYCHART()"> Year
                                        </label>
                                    </div>
                                </div>
                            </div>
                            /.col
                        </div> -->
                        
                        
                        
                        <!--/.그래프 이거 교체해주면 될듯***********************************************************************************-->
                        <%-- <div class="chart-wrapper mt-4">
                            <canvas id="trafficChart" style="height:200px;" height="200"></canvas>
                        </div> --%>
                        <div class="charttitle">ParkingPanda 주차장별 이용률</div>
                        <div id="chart_container" style="height: 575px; margin-top: 0%;">
                        
                        </div>
                        <!--/.그래프 이거 교체해주면 될듯***********************************************************************************-->
                        
                        
                        

                    </div>
                    
                </div>
            </div>
            
		</div>
		<!-- ********************************그래프***************************************************************************************************************** -->
			
		
		
		<script>
			var ws;
			var messages = document.getElementById("message");
	
			function openSocket() {
				if (ws !== undefined && ws.readyState !== WebSocket.CLOSED) {
					writeResponse("WebSocket is already opend.");
					return;
				}
	
				//웹소켓 객체 만드는 코드
				var url = window.location.host;//웹브라우저의 주소창의 포트까지 가져옴
				var pathname = window.location.pathname; /* '/'부터 오른쪽에 있는 모든 경로*/
				var appCtx = pathname.substring(0, pathname.indexOf("/", 2));
				var root = url + appCtx;
				ws = new WebSocket("ws://"+root+"/ws"); /*/ws는 @ServerEndpoint(value = "/ws")를 말함*/
	
				ws.onopen = function(event) {
					if (event.data === undefined)
						return;
					writeResponse(event.data);
				};
				ws.onmessage = function(event) {
					writeResponse(event.data);
				};
				ws.onclose = function(event) {
					writeResponse("Connection closed");
				}
			}
			
			function writeResponse(text) {
				//message.innerHTML += "<br/>" + text;
				
				/* 요청이 들어온 주차장을 확인하고 해당 주차장의 카메라(iframe)와 요청이 들어온 버튼을 css를 통해서 표시해주는 코드 */
				for(y=65;y<=72;y++){
					a = String.fromCharCode(y);
					//alert(text.indexOf(a));
					if(text.indexOf(a) != -1){
						//camid='#'+a
						cambox='#'+a+'box'
						camname='#selectedP'+a
						//$(camid).css("border","solid red 5px");
						$(cambox).css("animation","blink-effect 1s step-end infinite");
						$(camname).css("color","#e16040");
						if(text.indexOf("in") != -1){
							checkinid = '#in_checkbox'+a
							parkid = '#parkname'+a
							$(checkinid).css("animation","blink-effect2 1s step-end infinite");
							$(parkid).css("color", "#84b5f0");
						}else if(text.indexOf("out") != -1){
							checkoutid = '#out_checkbox'+a
							parkid = '#parkname'+a
							$(checkoutid).css("animation","blink-effect2 1s step-end infinite");
							$(parkid).css("color", "#84b5f0");
						}
					}
				}
				/* ################################################################################### */
				
				alert(text);
			}
			
			/* document.addEventListener("DOMContentLoaded", function(){
				openSocket();
			}); */
			
			/*==================vv================도큐먼트 레디========================================  */
			$(document).ready(function(){
				
				openSocket();
				
			});


			
		</script>
			
			

       <!-- .content -->
</body>
</html>