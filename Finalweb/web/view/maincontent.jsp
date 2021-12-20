<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script type="text/javascript">
    
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
		alert(text);
	}
    
	
	
	/* 테서랙트로 추출한 번호판 문자를 웹소켓 통신으로 받는 코드------------------------------------ */
	var wsforplates;
	function openSocketForPlates() {
		if (wsforplates !== undefined && wsforplates.readyState !== WebSocket.CLOSED) {
			//writeResponse("WebSocket is already opend.");
			return;
		}

		//웹소켓 객체 만드는 코드
		var url = window.location.host;//웹브라우저의 주소창의 포트까지 가져옴
		var pathname = window.location.pathname; /* '/'부터 오른쪽에 있는 모든 경로*/
		var appCtx = pathname.substring(0, pathname.indexOf("/", 2));
		var root = url + appCtx;
		wsforplates = new WebSocket("ws://"+root+"/ws2"); /*/ws는 @ServerEndpoint(value = "/ws")를 말함*/

		wsforplates.onopen = function(event) {
			if (event.data === undefined)
				return;
			writeResponse2(event.data);
		};
		wsforplates.onmessage = function(event) {
			writeResponse2(event.data);
		};
		wsforplates.onclose = function(event) {
			writeResponse2("Connection closed");
		}
	}
	
	function writeResponse2(text) {
		//message.innerHTML += "<br/>" + text;
		for(q=65;q<=72;q++){
			t = String.fromCharCode(q);
			if(text.indexOf(t)!= -1){
				if(t==p_id){
					//newidForCarnum = '#carnumof_'+t;
					newpid='carnumof_'+p_id;
					$("#carnum_p").attr('id',newpid);
					newidForCarnum='#'+newpid;
					$(newidForCarnum).text(text.substring(1));
					$(newidForCarnum).css("color","red");
					$(newidForCarnum).attr('id','carnum_p');
				}				
			}
		}
	}
	/* ----------------------------------------------------------------------- */
    
	
			function InfoFromEachParkname2(){
				$("#carnum_p").text("");
				openSocketForPlates();
				$("#selectedP").text(p_id+'주차장');
				$("#imgdiv").empty();
				$("#imgdiv").append("<img alt='' src='img/parkinglot_IMG/"+p_id+".jpg' style='width: 100%; height: 420px;'>");
				$.ajax({
					url:'payAmountbyP_id.mc',
					type:"get",
					data:{"p_id":p_id},
					success:function(data){
						if(data.todayIncome==0){
							$("#T_income_div").empty();
							$("#T_income_div").append("<div style='font-size: 14px;'>정산된 요금이 없습니다.</div>");
						}else{
							$("#T_income_div").empty();
							$("#T_income_div").append("<div style='font-size: 30px; color:black;'><h5>"+data.todayIncome+"&nbsp;원</h5></div>");
						}
						if(data.todayCount==0){
							$("#T_count_div").empty();
							$("#T_count_div").append("<div style='font-size: 14px;'>주차한 차량이 없습니다.</div>");
						}else{
							$("#T_count_div").empty();
							$("#T_count_div").append("<div style='font-size: 30px; color:black;'><h5>"+data.todayCount+"&nbsp;대</hd></div>");
						}
						
						
					}
				})
				
				
				/*----------------------vv 카메라 추가할때마다 else if 추가 해야 하는 코드------------------------------------------------- */
				if(p_id=='A'){
					$("#imgdiv").empty();
					$("#imgdiv").append("<iframe src='http://192.168.0.16:81/stream' frameborder='0' width='100%' height='420px' scrolling='no' style='margin: 0 auto;'>");
				}/* else if(p_id=='B') */
				
				
			}    
    
			function AllParkinglotState(){
				bestRemaining=0;
				recommendP='';
				$.ajax({
					url:'parkingajax2.mc',
					type:"get",
					success:function(data){
						//alert(data[0].p_id);
						parkingsituation='';
						for(k=0;k<data.length;k++){
							if(data[k].Ecount>bestRemaining){
								bestRemaining=data[k].Ecount;
								recommendP=data[k].p_id;
							}
							
							if(0<data[k].Ecount && data[k].Ecount<=10){
								parkingsituation=
									parkingsituation+
										"<div class='col-sm-5 parkname2' style=' cursor:pointer; text-align: center; height: 30px; background: linear-gradient(yellow, #FDBC00); color:blue; margin: 5px; border-radius: 5px; display: flex;'><div class='parkname2_chi1' style='margin : 0 auto;'><div class='parkname2_chi2' style='float:left;'>"
												+data[k].p_id +"</div><div style='float:left'>&nbsp;보통</div></div></div>"
							}else if(10<data[k].Ecount){
								parkingsituation=
									parkingsituation+
										"<div class='col-sm-5 parkname2' style=' cursor:pointer; text-align: center; height: 30px;  background: linear-gradient(#0098D0, blue); color:white; margin: 5px; border-radius: 5px; display: flex;'><div class='parkname2_chi1' style='margin : 0 auto;'><div class='parkname2_chi2' style='float:left;'>"
											+data[k].p_id +"</div><div style='float:left'>&nbsp;여유</div></div></div>"
							}else if(data[k].Ecount<=0){
								parkingsituation=
									parkingsituation+
										"<div class='col-sm-5 parkname2' style=' cursor:pointer; text-align: center; height: 30px; background-color: red; color:white; margin: 5px; border-radius: 5px; display: flex;'><div class='parkname2_chi1' style='margin : 0 auto;'><div class='parkname2_chi2' style='float:left;'>"
											+data[k].p_id +"</div><div style='float:left'>&nbsp;만차</div></div></div>"
							}
						}
						$(".parkbox").empty();
						$(".parkbox").append(parkingsituation);
						
						$("#RecommendParkinglot").empty();
						$("#RecommendParkinglot").append("<span'>가장 여유 있는 주차장:&nbsp;</span><span style='font-weight: bold; background: linear-gradient(#0892C8,#3876A8); color:transparent; -webkit-background-clip:text;'>&nbsp;&nbsp;"+recommendP+" 주차장&nbsp;</span><span>(잔여 공간 : "+bestRemaining+")</span>")
						
						ViewP_areaState();
					}
				})
			}
			
			function ViewP_areaState(){
				$(".parkname2").each(function() {
					$(this).click(function() {
						
						p_id = $.trim($(this).children(".parkname2_chi1").children(".parkname2_chi2").text());

						InfoFromEachParkname2();
						
						setInterval(function(){
							$.ajax({
								url:'p_areaAjax.mc',
								type:"get",
								data:{"p_id":p_id},
								success:function(data){
									//alert(data[0].state);
									stateView="";
									statecount=0;
									for(i=0;i<data.length;i++){
										if(data[i].state==0){
											stateView=
												stateView+
													"<div class='each_p_area' style='cursor:pointer; width:9.5%; height: 30px; background: linear-gradient(#0098D0, blue); margin: 5px; text-align: center; color: white; font-size:14px;'>"
														+data[i].area_id+"</div>"
										}else if(data[i].state==1){
											stateView=
												stateView+
													"<div class='each_p_area' style='cursor:pointer; width:9.5%; height: 30px; background-color: red; margin: 5px; text-align: center; color: #EEEEEE; font-size:14px;'>"
														+data[i].area_id+"</div>"
											statecount=statecount+1
										}
									}
									for(j=0;j<(32-(data.length));j++){
										stateView=stateView+"<div style='width:9.5%; height: 30px; background-color: #DDDDDD; margin: 5px;'></div>"
									}
									
									
									//$("#RecommendParkinglot").empty();
									//$("#RecommendParkinglot").append("<h3 style='float: left'>선택된 주차장:&nbsp;"+p_id+'('+"</h3><h3 style='float: left; color: blue;'>"+(data.length-statecount)+"</h3><h3 style='float: left'>"+'/'+data.length+')'+"</h3>")
									
									
									$("#parkingTitle").empty();
									$("#parkingTitle").append("<span>"+p_id+'주차장 ('+"</span><span style='color: blue;'>"+(data.length-statecount)+"</span><span>"+'/'+data.length+')'+"</span>")
									
									
									
									$(".spacebox").empty();
						 			$(".spacebox").append(stateView);
						 			
					
						 			$("#usingspace").empty();
						 			$("#usingspace").append("<h1 style='color:red;'>&nbsp&nbsp"+statecount+"</h1>");
						 			$("#usablespace").empty();
						 			$("#usablespace").append("<h1 style='color:blue;'>&nbsp&nbsp"+(data.length-statecount)+"</h1>");
						 			
						 			$(".each_p_area").each(function(){
						 				$(this).click(function(){
						 					p_ar=$.trim($(this).text());
						 					alert(p_ar);
						 				});
						 			});
									
								}
							})
						}, 1500);
						
						//InfoFromEachParkname2();
						
						
					})
				})
			}
			
			
			function displaychart(d){
				var colors = Highcharts.getOptions().colors;
				Highcharts.chart('chart_container', {
				    chart: {
				        type: 'spline'
				    },

				    legend: {
				        symbolWidth: 40
				    },

				    title: {
				        text: d.Title+d.Xdate
				    },

				    /* subtitle: {
				        text: 'Source: WebAIM. Click on points to visit official screen reader website'
				    }, */

				    yAxis: {
				        title: {
				            text: '이용 차량수'
				        },
				        accessibility: {
				            description: 'Percentage usage'
				        }
				    },

				    xAxis: {
				        title: {
				            text: d.Xdate
				        },
				        accessibility: {
				            description: 'Time from December 2010 to September 2019'
				        },
				        categories: d.month
				    },

				    tooltip: {
				        valueSuffix: '대'
				    },

				    plotOptions: {
				        series: {
				            point: {
				                events: {
				                    click: function () {
				                        window.location.href = this.series.options.website;
				                    }
				                }
				            },
				            cursor: 'pointer'
				        }
				    },

				    series: [
				        {
				            name: 'A 주차장',
				            data: d.Ap,
				            website: 'https://www.nvaccess.org',
				            color: colors[2],
				            accessibility: {
				                description: 'This is the most used screen reader in 2019'
				            }
				        }, {
				            name: 'B 주차장',
				            data: d.Bp,
				            website: 'https://www.freedomscientific.com/Products/Blindness/JAWS',
				            dashStyle: 'ShortDashDot',
				            color: colors[0]
				        }, {
				            name: 'C 주차장',
				            data: d.Cp,
				            website: 'https://www.freedomscientific.com/Products/Blindness/JAWS',
				            dashStyle: 'ShortDashDot',
				            color: colors[4]
				        },{
				            name: 'D 주차장',
				            data: d.Dp,
				            website: 'https://www.freedomscientific.com/Products/Blindness/JAWS',
				            dashStyle: 'ShortDashDot',
				            color: colors[7]
				        },{
				            name: 'E 주차장',
				            data: d.Ep,
				            website: 'http://www.apple.com/accessibility/osx/voiceover',
				            dashStyle: 'ShortDot',
				            color: colors[1]
				        }, {
				            name: 'F 주차장',
				            data: d.Fp,
				            website: 'https://support.microsoft.com/en-us/help/22798/windows-10-complete-guide-to-narrator',
				            dashStyle: 'Dash',
				            color: colors[9]
				        }, {
				            name: 'G 주차장',
				            data: d.Gp,
				            website: 'http://www.zoomtext.com/products/zoomtext-magnifierreader',
				            dashStyle: 'ShortDot',
				            color: colors[5]
				        }, {
				            name: 'H 주차장',
				            data: d.Hp,
				            website: 'http://www.disabled-world.com/assistivedevices/computer/screen-readers.php',
				            dashStyle: 'ShortDash',
				            color: colors[3]
				        } 
				    ],

				    responsive: {
				        rules: [{
				            condition: {
				                maxWidth: 550
				            },
				            chartOptions: {
				                chart: {
				                    spacingLeft: 3,
				                    spacingRight: 3
				                },
				                legend: {
				                    itemWidth: 150
				                },
				                xAxis: {
				                    categories: ['Dec. 2010', 'May 2012', 'Jan. 2014', 'July 2015', 'Oct. 2017', 'Sep. 2019', 'Sep. 2020'],
				                    title: ''
				                },
				                yAxis: {
				                    visible: false
				                }
				            }
				        }]
				    }
				});
			}
				
			
			
			function getdataforMCHART(){
				$.ajax({
					url:'parkingChart.mc',
					type:"get",
					data:{"date":'month'},
					success:function(d){
						displaychart(d);
					}
				})
			}
			
			function getdataforYCHART(){
				$.ajax({
					url:'parkingChart.mc',
					type:"get",
					data:{"date":'year'},
					success:function(d){
						displaychart(d);
					}
				})
			}
			
			function getdataforDCHART(){
				$.ajax({
					url:'parkingChart.mc',
					type:"get",
					data:{"date":'day'},
					success:function(d){
						displaychart(d);
					}
				})
			}
			
			function getdataforHCHART(){
				$.ajax({
					url:'parkingChart.mc',
					type:"get",
					data:{"date":'hour'},
					success:function(d){
						displaychart(d);
					}
				})
			}
			
			function getdataforAvgCHART(){
				$.ajax({
					url:'parkingChart.mc',
					type:"get",
					data:{"date":'avgC'},
					success:function(d){
						displaychart(d);
					}
				})
			}
			
			function makingRandomUpdate(){
				//var obj=0;
				$("#MKrandom").click(function(){
					//obj=!obj
					obj2=$("#MKrandom").text();
					if(obj2=='Random_On'){
						alert('주차장 DB에 랜덤 업데이트를 시작합니다.');
						$("#MKrandom").empty();
			 			$("#MKrandom").append("<i class='menu-icon fa fa-table'></i>"+'Random_Off');
			 			timerId = setInterval(function(){
			 				$.ajax({
				 				url:'MakingRandomValue.mc',
				 				success:function(da){
				 					//alert('success');
				 				}
				 			});
			 			},2000);
			 			
					}else{
						alert('주차장 DB에 랜덤 업데이트를 종료합니다.');
						$("#MKrandom").empty();
			 			$("#MKrandom").append("<i class='menu-icon fa fa-table'></i>"+'Random_On');
			 			clearInterval(timerId);
					}
				});
			}
			
			
			function makingRandomLog(){
				$("#MKrandomLog").click(function(){
					obj2=$("#MKrandomLog").text();
					if(obj2=='Random_Log_On'){
						alert('랜덤 로그 생성을 시작합니다.');
						$("#MKrandomLog").empty();
			 			$("#MKrandomLog").append("<i class='menu-icon fa fa-table'></i>"+'Random_Log_Off');
		 				$.ajax({
			 				url:'randomLogTest1.mc',
			 				success:function(da){
			 					//alert('log1 success');
			 					logInterval=setInterval(function(){
			 						$.ajax({
			 							url:'randomLogTest2.mc',
			 							success:function(da2){
			 								//alert('log2 success');
			 								
			 							}
			 						})
			 					},5000);
			 				}
			 			});
			 			
			 			
					}else{
						alert('랜덤 로그 생성을 종료합니다.');
						$("#MKrandomLog").empty();
			 			$("#MKrandomLog").append("<i class='menu-icon fa fa-table'></i>"+'Random_Log_On');
			 			clearInterval(logInterval);
					}
				});
			}
			
			
		/*==================vv================도큐먼트 레디========================================  */
			$(document).ready(function(){
				
				openSocket();
				
				makingRandomUpdate();
				
				makingRandomLog();
				
				getdataforDCHART();
				
				setInterval(function() {
					AllParkinglotState();
			       },1500);
				
				
				
			});
		</script>
    	<style type="text/css">
    		.contenttitle{
				font-weight: bold;
			}
    	</style>
    
</head>
<body>
        <div class="breadcrumbs" >
            <div class="col-sm-4">
                <div class="page-header float-left">
                    <div class="page-title">
                        <h1 class="contenttitle">관리 주차장 현황</h1>
                    </div>
                </div>
            </div>
        </div>
    
			<!-- ===========주차장 현황================================================================ -->
		<div  style= "margin-bottom: 30px;">
			<div class="col-xl-6" >
                <div class="card">
					<div class="" style="width:100%; display: flex; padding-top: 50px; padding-bottom: 50px; background: linear-gradient(#0290C7, #A3CEDF);">
						<div class="allpark" style="height: 300px; background:#FFFFFF; border-radius: 3px; width: 70%; margin: auto; text-align: center;">
							<div class="title" >주차장 별 현황</div>
							<div class="row parkbox">
								<% for(char i='A';i<='H';i++){ %>
									<div class="col-sm-5 parkname" style="text-align: center;height: 30px;background-color: #0098D0;margin: 5px;border-radius: 5px; ">
										<%=i%>
									</div>
								<%}%>
							</div>
						</div>
					</div>
					<div  style="width:100%; background: #FFFFFF; height: 100px; display: flex;" >
						<!-- <div style="margin: auto;" id="SelectedParkinglot"><h3 style="float: left">선택된 주차장 (</h3><h3 style="float: left; color: blue;">뀨뀨</h3><h3 style="float: left">/꺄꺄)</h3></div> -->
						<div style="margin: auto;" class = "title2"; id="RecommendParkinglot"><span>추천 주차장<span></div>
					</div>
				</div>
			</div>
					
			<div class="col-xl-6" >
                <div class="card">
					<div class="" style="width:100%; display: flex; background: linear-gradient(#F3A64E, #F7C873); padding-top: 50px; padding-bottom: 50px;">
						<div class="eachpark" >
							<!-- <div style="width: 100%; height: 400px; border: solid red 2px; "> -->
								<p class="title" id="parkingTitle"><span>주차장을</span><span> 선택해주세요.</span></p>
								<div class="row spacebox">
									<% for(int i=0;i<32;i++){ %>
										<div class="parkspace">
										</div>
									<%}%>
								</div>
							<!-- </div> -->
							
						</div>
					</div>
					
					<div style="width:100%; background: #FFFFFF; height: 100px; display :flex; align-items: center;" >
						<div style="width: 100%">
							<div class="spacediv">
								<div class="p_area_notice">
									<div class="p_area_notice2 ">사용중 주차공간:</div>
									<div style="float:left;" id="usingspace"></div>
								</div>
								
							</div>
							
							<div class="spacediv">
								<div class="p_area_notice">
									<div class="p_area_notice2">잔여 주차공간:</div>
									<div style="float:left;" id="usablespace"></div>
								</div>
							</div>
						</div>
						
					</div>
				</div>
			</div>
		</div>
        <!-- ^^===========주차장 현황================================================================ -->



			<!-- ********************************그래프************************************************************************************************************** -->
		<div>
            <div class="col-xl-6" >
                <div class="card">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <h4 class="card-title mb-0">Traffic</h4>
                                <div class="small text-muted">ParkingPanda</div>
                            </div>
                            <!--/.col-->
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
                            <!--/.col-->


                        </div>
                        
                        
                        
                        <!--/.그래프 이거 교체해주면 될듯***********************************************************************************-->
                        <%-- <div class="chart-wrapper mt-4">
                            <canvas id="trafficChart" style="height:200px;" height="200"></canvas>
                        </div> --%>
                        
                        <div id="chart_container" style="height: 575px; margin-top: 7%;">
                        
                        </div>
                        <!--/.그래프 이거 교체해주면 될듯***********************************************************************************-->
                        
                        
                        

                    </div>
                    <!-- <div class="card-footer">
                        <ul>
                            <li>
                                <div class="text-muted">Visits</div>
                                <strong>29.703 Users (40%)</strong>
                                <div class="progress progress-xs mt-2" style="height: 5px;">
                                    <div class="progress-bar bg-success" role="progressbar" style="width: 40%;" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </li>
                            <li class="hidden-sm-down">
                                <div class="text-muted">Unique</div>
                                <strong>24.093 Users (20%)</strong>
                                <div class="progress progress-xs mt-2" style="height: 5px;">
                                    <div class="progress-bar bg-info" role="progressbar" style="width: 20%;" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </li>
                            <li>
                                <div class="text-muted">Pageviews</div>
                                <strong>78.706 Views (60%)</strong>
                                <div class="progress progress-xs mt-2" style="height: 5px;">
                                    <div class="progress-bar bg-warning" role="progressbar" style="width: 60%;" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </li>
                            <li class="hidden-sm-down">
                                <div class="text-muted">New Users</div>
                                <strong>22.123 Users (80%)</strong>
                                <div class="progress progress-xs mt-2" style="height: 5px;">
                                    <div class="progress-bar bg-danger" role="progressbar" style="width: 80%;" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </li>
                            <li class="hidden-sm-down">
                                <div class="text-muted">Bounce Rate</div>
                                <strong>40.15%</strong>
                                <div class="progress progress-xs mt-2" style="height: 5px;">
                                    <div class="progress-bar" role="progressbar" style="width: 40%;" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </li>
                        </ul>
                    </div> -->
                </div>
            </div>
			<!-- ********************************그래프***************************************************************************************************************** -->


			<!-- VV==========================주차장 사진 및 주차장 연결캠이 뜨는 섹션========================================================== -->
            <div class="col-lg-6" >
                <section class="card">
                    <!-- <div class="twt-feed blue-bg" style="border: solid red 2px;"> -->
                    <div id="imgdiv">
                    	<img alt="" src="img/parkinglot_IMG/default.jpg" style="width: 100%; height: 420px;">
                    	
                    	
                    	<!-- <iframe src="http://192.168.0.15:81/stream" frameborder="0" width="100%" height="420px" scrolling="no" style="margin: 0 auto;"></iframe> -->
						

                        <!-- <div class="media" style="text-align: center;">
                            <a href="#">
                                <img class="align-self-center rounded-circle mr-3" style="width:85px; height:85px;" alt="" src="images/admin.jpg">
                            </a>
                            <div class="media-body">
                                <h2 class="text-white display-6" id="selectedP">주차장</h2>
                                <p class="text-light" id="selectePsub">상세 현황 조회</p>
                            </div>
                        </div> -->
                    </div>
                    <div class="weather-category twt-category"style="height: 135px;">
                        <ul>
                            <div class="media" style="text-align: center;">
	                            <div class="media-body">
	                                <!-- <h2 class="text-white display-6" id="selectedP" style="color: black">주차장</h2>
	                                <p class="text-light" id="selectePsub"style="color: black">상세 현황 조회</p> -->
	                                <h2 class="display-6" id="selectedP" style="color: #343a40;">주차장</h2>
	                                <p  id="selectePsub"style="color: #343a40;">상세 현황 조회</p>
	                               	<p id="carnum_p" style="font-size: 20px">차량 번호 확인</p>
	                            </div>
	                        </div>
                        </ul>
                    </div>
                    <!-- <div class="twt-write col-sm-12" style="border: solid black 2px;">
                        <textarea placeholder="Write your Tweet and Enter" rows="1" class="form-control t-text-area"></textarea>
                    </div>
                    <footer class="twt-footer">
                        <a href="#"><i class="fa fa-camera"></i></a>
                        <a href="#"><i class="fa fa-map-marker"></i></a>
                        New Castle, UK
                        <span class="pull-right">
                            32
                        </span>
                    </footer> -->
                </section>
            </div>
			<!-- ^^==========================주차장 사진 및 주차장 연결캠이 뜨는 섹========================================================== -->

			<!-- VV==========================카드1(금일 결제 금액 현황)========================================================== -->
            <div class="col-xl-3 col-lg-6"  >
                <div class="card">
                    <div class="card-body">
                        <div class=" stat-widget-one">
                            <div style="float : left; width: 30%;">
                            	<!-- <i class="ti-money text-success border-success"></i> -->
                            	<img alt="dallar" src="img/dollar.png" style="width: 73%; height: 73%" >
                            </div>
                            <div style="float : left; width: 65%;">
                                <div class="stat-text">금일 총 매출</div>
                                <div class="stat-digit" style="margin-top: 10px" id="T_income_div"><h5 id = "T_income">0원</h5></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ^^==========================카드1(금일 결제 금액 현황)========================================================== -->

			<!-- VV==========================카드2(금일 방문 차량 수 현황)========================================================== -->
            <div class="col-xl-3 col-lg-6">
                <div class="card">
                    <div class="card-body">
                        <div class="stat-widget-one">
                            <div style="float : left; width: 30%;">
                            	<!-- <i class="ti-user text-primary border-primary"></i> -->
                            	<img alt="dallar" src="img/car_graph_icon.png" style="width: 73%; height: 73%" >
                            </div>
                            <div style="float : left; width: 65%;">
                                <div class="stat-text">금일 주차 차량수</div>
                                <div class="stat-digit" style="margin-top: 10px" id="T_count_div"><h5 id = "T_count">0대</h5></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ^^==========================카드2(금일 방문 차량 수 현황)========================================================== -->
            
			<!-- VV==========================카드3(미정)========================================================== -->
            <!-- <div class="col-xl-3 col-lg-6">
                <div class="card">
                    <div class="card-body">
                        <div class="stat-widget-one">
                            <div class="stat-icon dib"><i class="ti-layout-grid2 text-warning border-warning"></i></div>
                            <div class="stat-content dib">
                                <div class="stat-text">Active Projects</div>
                                <div class="stat-digit">770</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> -->
            <!-- ^^==========================카드3(미정)========================================================== -->
            
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
