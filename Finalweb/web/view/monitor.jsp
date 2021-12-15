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
		section{
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
				                <section>
				                    <div id=<%=i%>>
				                    	
				                    	<iframe src=<%=cameramap.get(i+"_InCamera")%> allow='autoplay' frameborder='0' width='100%' height='250px' scrolling='no' style='margin: 0 auto;'>
				                    	</iframe>
				                    	
				                    </div>
				                    <div class="weather-category twt-category"style="height: 90px;">
				                        <ul>
				                            <div class="media" style="text-align: center;">
					                            <div class="media-body">
					                                <h3 class="display-6" id="selectedP" style="color: #343a40;">A 주차장</h3>
					                                
					                                <button class="camera_btn" onclick="changeCamera('#<%=i%>','<%=cameramap.get(i+"_InCamera")%>')">입차 카메라</button>
					                               	<button class="camera_btn" onclick="changeCamera('#<%=i%>','<%=cameramap.get(i+"_OutCamera")%>')">출차 카메라</button>
					                               	
					                               	
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
			<!-- ********************************그래프***************************************************************************************************************** -->


			
			<!-- VV==========================카드4(미정/ 전세계 지도)========================================================== -->
           <!--  <div class="col-xl-6">
                <div class="card">
                    <div class="card-header">
                        <h4>World</h4>
                    </div>
                    <div class="Vector-map-js">
                        <div id="vmap" class="vmap" style="height: 265px;"></div>
                    </div>
                </div>
                /# card
            </div> -->
            <!-- ^^==========================카드4(미정/ 전세계 지도)========================================================== -->
            
		</div>
			
			
			

       <!-- .content -->
</body>
</html>
