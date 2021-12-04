<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script type="text/javascript">
    
			function AllParkinglotState(){
				$.ajax({
					url:'parkingajax2.mc',
					type:"get",
					success:function(data){
						//alert(data[0].p_id);
						parkingsituation='';
						for(k=0;k<data.length;k++){
							if(0<data[k].count && data[k].count<=10){
								parkingsituation=parkingsituation+"<div class='col-sm-5 parkname2' style='text-align: center; height: 30px; background-color: yellow; color:blue; margin: 5px; border-radius: 5px;'>"+data[k].p_id+"</div>"
							}else if(10<data[k].count){
								parkingsituation=parkingsituation+"<div class='col-sm-5 parkname2' style='text-align: center; height: 30px; background-color: blue; color:white; margin: 5px; border-radius: 5px;'>"+data[k].p_id+"</div>"
							}else if(data[k].count<=0){
								parkingsituation=parkingsituation+"<div class='col-sm-5 parkname2' style='text-align: center; height: 30px; background-color: red; color:white; margin: 5px; border-radius: 5px;'>"+data[k].p_id+"</div>"
							}
						}
						$(".parkbox").empty();
						$(".parkbox").append(parkingsituation);
						ViewP_areaState();
					}
				})
			}
			
			function ViewP_areaState(){
				$(".parkname2").each(function() {
					$(this).click(function() {
						p_id = $.trim($(this).text());
						
						/* $(this).attr("class","col-sm-4 active parkname"); */
						//$(".parkname2").css('color','');
						//$(this).css('color','purple');
						$("#parkingTitle").text(p_id+'주차장');
						//$("#SelectedParkinglot").text('선택된 주차장: '+p_id);
						//alert(p_id);
						
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
											stateView=stateView+"<div class='col-sm-1' style='width:20px; height: 30px; background-color: blue; margin: 5px; text-align: left; color: white; font-size:14px;'>"+data[i].area_id+"</div>"
										}else if(data[i].state==1){
											stateView=stateView+"<div class='col-sm-1' style='width:20px; height: 30px; background-color: red; margin: 5px; text-align: left; color: white; font-size:14px;'>"+data[i].area_id+"</div>"
											statecount=statecount+1
										}
									}
									for(j=0;j<(45-(data.length));j++){
										stateView=stateView+"<div class='col-sm-1' style='width:20px; height: 30px; background-color: #DDDDDD; margin: 5px;'></div>"
									}
									
									$("#SelectedParkinglot").text('선택된 주차장 : '+p_id+'('+(data.length-statecount)+'/'+data.length+')');
									
									$(".spacebox").empty();
						 			$(".spacebox").append(stateView);
						 			$("#usingspace").empty();
						 			/* $("#usingspace").append('사용중 주차공간:'+statecount); */
						 			$("#usingspace").append("<div style='margin-left:50px; float:left;'><div style='float:left; margin-top: 30px;'><h4>사용중 주차공간:</h4></div><div style='float:left;'><h1 style='margin-left: 30px; margin-top: 20px; color:red;'>"+statecount+"</h1></div></div></div>");
						 			$("#usablespace").empty();
						 			/* $("#usablespace").append('잔여 주차공간:'+(data.length-statecount)); */
						 			$("#usablespace").append("<div style='margin-left:50px; float:left;'><div style='float:left; margin-top: 30px;'><h4>잔여 주차공간:</h4></div><div style='float:left;'><h1 style='margin-left: 30px; margin-top: 20px; color:blue;'>"+(data.length-statecount)+"</h1></div></div></div>");
						 			
									
								}
							})
						}, 2000);
					})
				})
			}
			
			
			
			function displaychart(){
				
				var colors = Highcharts.getOptions().colors;

				Highcharts.chart('chart_container', {
				    chart: {
				        type: 'spline'
				    },

				    legend: {
				        symbolWidth: 40
				    },

				    title: {
				        text: '주차장별 이용 차량수(월)'
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
				            text: '월(month)'
				        },
				        accessibility: {
				            description: 'Time from December 2010 to September 2019'
				        },
				        categories: ['December 2010', 'May 2012', 'January 2014', 'July 2015', 'October 2017', 'September 2019']
				    },

				    tooltip: {
				        valueSuffix: '%'
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
				            name: 'NVDA',
				            data: [34.8, 43.0, 51.2, 41.4, 64.9, 72.4],
				            website: 'https://www.nvaccess.org',
				            color: colors[2],
				            accessibility: {
				                description: 'This is the most used screen reader in 2019'
				            }
				        }, {
				            name: 'JAWS',
				            data: [69.6, 63.7, 63.9, 43.7, 66.0, 61.7],
				            website: 'https://www.freedomscientific.com/Products/Blindness/JAWS',
				            dashStyle: 'ShortDashDot',
				            color: colors[0]
				        }, {
				            name: 'JAWS2',
				            data: [89.6, 93.7, 23.9, 73.7, 46.0, 91.7],
				            website: 'https://www.freedomscientific.com/Products/Blindness/JAWS',
				            dashStyle: 'ShortDashDot',
				            color: colors[4]
				        },{
				            name: 'JAWS3',
				            data: [19.6, 23.7, 93.9, 33.7, 26.0, 61.7],
				            website: 'https://www.freedomscientific.com/Products/Blindness/JAWS',
				            dashStyle: 'ShortDashDot',
				            color: colors[7]
				        },{
				            name: 'VoiceOver',
				            data: [20.2, 30.7, 36.8, 30.9, 39.6, 47.1],
				            website: 'http://www.apple.com/accessibility/osx/voiceover',
				            dashStyle: 'ShortDot',
				            color: colors[1]
				        }, {
				            name: 'Narrator',
				            data: [null, null, null, null, 21.4, 30.3],
				            website: 'https://support.microsoft.com/en-us/help/22798/windows-10-complete-guide-to-narrator',
				            dashStyle: 'Dash',
				            color: colors[9]
				        }, {
				            name: 'ZoomText/Fusion',
				            data: [6.1, 6.8, 5.3, 27.5, 6.0, 5.5],
				            website: 'http://www.zoomtext.com/products/zoomtext-magnifierreader',
				            dashStyle: 'ShortDot',
				            color: colors[5]
				        }, {
				            name: 'Other',
				            data: [42.6, 51.5, 54.2, 45.8, 20.2, 15.4],
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
				                    categories: ['Dec. 2010', 'May 2012', 'Jan. 2014', 'July 2015', 'Oct. 2017', 'Sep. 2019'],
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
			
			
			function getdataforCHART(){
				/* $.ajax({
					url:'trafficChart.mc',
					success:function(d){
						displaychart(d);
					}
				}) */
				
				displaychart();
			}
			
			
			$(document).ready(function(){
				
				getdataforCHART();
				
				setInterval(function() {
					AllParkinglotState();
			       },2000);
				
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
		<div class="content mt-3" style= "margin-bottom: 30px;">
			<div class="col-sm-6 ">
				<div class="bg-flat-color-1" style="width:100%; display: flex; padding-top: 50px; padding-bottom: 50px;">
					<div class="allpark" style="height: 300px; background:#FFFFFF; border-radius: 3px; width: 70%; margin: auto; text-align: center;">
						<div class="title" >주차장 별 현황</div>
						<div class="row parkbox">
							<% for(char i='A';i<='H';i++){ %>
								<div class="col-sm-5 parkname" style="text-align: center;height: 30px;background-color: #83AFE0;margin: 5px;border-radius: 5px; ">
									<%=i%>
								</div>
								<%-- <button class="btns"><%=i %></button> --%>
							<%}%>
						</div>
					</div>
				</div>
				<div  style="width:100%; background: #FFFFFF; height: 100px; display: flex;" >
					<div style="margin: auto;"><h3 id="SelectedParkinglot">선택된 주차장</h3></div><span>안녕!</span>
				</div>
			</div>
					
			<div class="col-sm-6">
				<div class="" style="width:100%; display: flex; background: #F7C873; padding-top: 50px; padding-bottom: 50px;">
					<div class="eachpark" >
						<p class="title" id="parkingTitle">주차장을 선택해주세요.</p>
						<div class="row spacebox">
							<% for(int i=0;i<45;i++){ %>
								<div class="col-sm-1 parkspace">
								</div>
							<%}%>
						</div>
						<div class="row" >
							
							<!-- vv----div 크기 확인용 보더 코드 -->
							<!-- style="text-align: center; border: solid; balck; 2px; " -->
						
							
							
						</div>
					</div>
				</div>
				<div style="width:100%; background: #FFFFFF; height: 100px;" >
					<div>
						<div class="row col-sm-6" id="usingspace">
							<div class="p_area_notice">
								<div style="float:left; margin-top: 30px;"><h4>사용중 주차공간:</h4></div>
								<div style="float:left;"><h1 class="spacevalue"></h1></div>
							</div>
							
						</div>
						
						<div class="row col-sm-6" id="usablespace">
							<div class="p_area_notice">
								<div style="float:left; margin-top: 30px;"><h4>잔여 주차공간:</h4></div>
								<div style="float:left;"><h1 class="spacevalue"></h1></div>
							</div>
						</div>
					</div>
					
				</div>
	
			</div>
		</div>
        <!-- ^^===========주차장 현황================================================================ -->



			<!-- ********************************그래프************************************************************************************************************** -->
            <div class="col-xl-6" >
                <div class="card">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-4">
                                <h4 class="card-title mb-0">Traffic</h4>
                                <div class="small text-muted">October 2017</div>
                            </div>
                            <!--/.col-->
                            <div class="col-sm-8 hidden-sm-down">
                                
                                <div class="btn-toolbar float-right" role="toolbar" aria-label="Toolbar with button groups">
                                    <div class="btn-group mr-3" data-toggle="buttons" aria-label="First group">
                                        <label class="btn btn-outline-secondary">
                                            <input type="radio" name="options" id="option1"> Day
                                        </label>
                                        <label class="btn btn-outline-secondary active">
                                            <input type="radio" name="options" id="option2" checked=""> Month
                                        </label>
                                        <label class="btn btn-outline-secondary">
                                            <input type="radio" name="options" id="option3"> Year
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
                        
                        <div id="chart_container" style="height: 500px;">
                        
                        </div>
                        <!--/.그래프 이거 교체해주면 될듯***********************************************************************************-->
                        
                        
                        

                    </div>
                    <div class="card-footer">
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
                    </div>
                </div>
            </div>
			<!-- ********************************그래프***************************************************************************************************************** -->


			<!-- VV==========================매니저 현황========================================================== -->
            <div class="col-xl-3 col-lg-6" >
                <section class="card">
                    <div class="twt-feed blue-bg">
                        <div class="corner-ribon black-ribon">
                            <i class="fa fa-twitter"></i>
                        </div>
                        <div class="fa fa-twitter wtt-mark"></div>

                        <div class="media">
                            <a href="#">
                                <img class="align-self-center rounded-circle mr-3" style="width:85px; height:85px;" alt="" src="images/admin.jpg">
                            </a>
                            <div class="media-body">
                                <h2 class="text-white display-6">Jim Doe</h2>
                                <p class="text-light">Project Manager</p>
                            </div>
                        </div>
                    </div>
                    <div class="weather-category twt-category">
                        <ul>
                            <li class="active">
                                <h5>750</h5>
                                Tweets
                            </li>
                            <li>
                                <h5>865</h5>
                                Following
                            </li>
                            <li>
                                <h5>3645</h5>
                                Followers
                            </li>
                        </ul>
                    </div>
                    <div class="twt-write col-sm-12">
                        <textarea placeholder="Write your Tweet and Enter" rows="1" class="form-control t-text-area"></textarea>
                    </div>
                    <footer class="twt-footer">
                        <a href="#"><i class="fa fa-camera"></i></a>
                        <a href="#"><i class="fa fa-map-marker"></i></a>
                        New Castle, UK
                        <span class="pull-right">
                            32
                        </span>
                    </footer>
                </section>
            </div>
			<!-- ^^==========================매니저 현황========================================================== -->

			<!-- VV==========================카드1(금일 결제 금액 현황)========================================================== -->
            <div class="col-xl-3 col-lg-6"  >
                <div class="card">
                    <div class="card-body">
                        <div class="stat-widget-one">
                            <div class="stat-icon dib"><i class="ti-money text-success border-success"></i></div>
                            <div class="stat-content dib">
                                <div class="stat-text">Total Profit</div>
                                <div class="stat-digit">1,012</div>
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
                            <div class="stat-icon dib"><i class="ti-user text-primary border-primary"></i></div>
                            <div class="stat-content dib">
                                <div class="stat-text">New Customer</div>
                                <div class="stat-digit">961</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ^^==========================카드2(금일 방문 차량 수 현황)========================================================== -->
            
			<!-- VV==========================카드3(미정)========================================================== -->
            <div class="col-xl-3 col-lg-6">
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
            </div>
            <!-- ^^==========================카드3(미정)========================================================== -->
            
			<!-- VV==========================카드4(미정/ 전세계 지도)========================================================== -->
            <div class="col-xl-6">
                <div class="card">
                    <div class="card-header">
                        <h4>World</h4>
                    </div>
                    <div class="Vector-map-js">
                        <div id="vmap" class="vmap" style="height: 265px;"></div>
                    </div>
                </div>
                <!-- /# card -->
            </div>
            <!-- ^^==========================카드4(미정/ 전세계 지도)========================================================== -->


       <!-- .content -->
</body>
</html>