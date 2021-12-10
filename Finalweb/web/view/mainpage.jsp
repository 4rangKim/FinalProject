<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Sufee Admin - HTML5 Admin Template</title>
    <meta name="description" content="Sufee Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="apple-icon.png">
    <link rel="shortcut icon" href="favicon.ico">
    
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
	
	<!-- ##############################차트 라이브러리################################################# -->
	<script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.highcharts.com/modules/series-label.js"></script>
	<script src="https://code.highcharts.com/modules/exporting.js"></script>
	<script src="https://code.highcharts.com/modules/export-data.js"></script>
	<script src="https://code.highcharts.com/modules/accessibility.js"></script>
	<script src="https://code.highcharts.com/themes/high-contrast-light.js"></script>
	<!-- ##############################차트 라이브러리################################################# -->
	

    <link rel="stylesheet" href="bootstrap/vendors/bootstrap/dist/css/bootstrap.css">
    <link rel="stylesheet" href="bootstrap/vendors/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="bootstrap/vendors/themify-icons/css/themify-icons.css">
    <link rel="stylesheet" href="bootstrap/vendors/flag-icon-css/css/flag-icon.min.css">
    <!-- <link rel="stylesheet" href="vendors/selectFX/css/cs-skin-elastic.css"> -->
    <!-- <link rel="stylesheet" href="vendors/jqvmap/dist/jqvmap.min.css"> -->


   <link type='text/css' rel="stylesheet" href="bootstrap/assets/css/style.css">
   <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>
	<style type="text/css">
	.logoutBtn{
		border: none;
		background-color: #b7c1e8;
		border-radius: 20px;
		color: white;
		margin: 10px;
		width: 100px;
		height: 40px;
		cursor: pointer;
	}
	</style>    
	
	
    
</head>
<body>
    <aside id="left-panel" class="left-panel" >
        <nav class="navbar navbar-expand-sm navbar-default">

            <div class="navbar-header">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu" aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
               <a class="navbar-brand" href="/Finalweb/main.mc"><img src="img/logo1.png" alt="Logo"></a>
                <a class="navbar-brand hidden" href="/Finalweb/main.mc"><img src="img/logo2.png" alt="Logo"></a>
                <!-- <p class="navbar-brand" href="./"><h3 style="color: white;">Parking Admin</h3></p>
                <p class="navbar-brand hidden" href="./"><h3 style="color: white;">P</h3></p> -->
            </div>

            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="/Finalweb/main.mc"> <i class="menu-icon fa fa-dashboard"></i>Dashboard </a>
                    </li>
                    <h3 class="menu-title">주차장 관리</h3><!-- /.menu-title -->
                    <li>
                        <a href="#"> <i class="menu-icon fa fa-bar-chart"></i>주차장 실시간 현황</a>
                    </li>
                    <li>
                        <a href="/Finalweb/pkuser.mc"> <i class="menu-icon fa fa-th"></i>주차장 이용 고객 현황</a>
                    </li>


                    <h3 class="menu-title">APP 관리</h3><!-- /.menu-title -->
					<li>
                        <a href="/Finalweb/appuser.mc"> <i class="menu-icon fa fa-table"></i>사용자 조회</a>
                    </li>
                    
                    
                    <h3 class="menu-title">랜덤 데이터 생성</h3><!-- /.menu-title -->
                    <li>
                        <a href="#" id="MKrandom"><i class="menu-icon fa fa-table"></i>Random_On</a>
                    </li>
                    <li>
                        <a href="#" id="MKrandomLog"><i class="menu-icon fa fa-table"></i>Random_Log_On</a>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </nav>
    </aside>

        <div id="right-panel" class="right-panel" >

        <!-- Header-->
        <header id="header" class="header">

            <div class="header-menu" >

                 <div class="col-sm-7" >
                   <a id="menuToggle" class="menutoggle pull-left"><i class="fa fa fa-tasks"></i></a>
                    <div class="header-left">
                      
                    </div>
                </div> 
                
                

                <div class="col-sm-5">
                    <div class="user-area float-right">
                    	<form action="/Finalweb/logout.mc">
                       		<button class="logoutBtn">LOGOUT</button>
                       	</form>
                    </div>

          

                </div>
            </div>

        </header><!-- /header -->
        <!-- Header-->

    
	<section>
		<c:choose>
			<c:when test="${center == null }">
				<jsp:include page="maincontent.jsp" />
			</c:when>
			<c:otherwise>
				<jsp:include page="${center}.jsp" />
			</c:otherwise>
		</c:choose>
	</section>
	
	</div>
	
	
	    <!--///////////////////////vv 부트스트랩 스크립트 모음vv////////////////////////////////////////////////////////////  -->

    <script src="bootstrap/vendors/jquery/dist/jquery.min.js"></script>
    <script src="bootstrap/vendors/popper.js/dist/umd/popper.min.js"></script>
    <script src="bootstrap/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="bootstrap/assets/js/main.js"></script>


    <script src="bootstrap/vendors/chart.js/dist/Chart.bundle.min.js"></script>
    <script src="bootstrap/assets/js/dashboard.js"></script>
    <script src="bootstrap/assets/js/widgets.js"></script>
    <script src="bootstrap/vendors/jqvmap/dist/jquery.vmap.min.js"></script>
    <script src="bootstrap/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
    <script src="bootstrap/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
    <script>
        (function($) {
            "use strict";

            jQuery('#vmap').vectorMap({
                map: 'world_en',
                backgroundColor: null,
                color: '#ffffff',
                hoverOpacity: 0.7,
                selectedColor: '#1de9b6',
                enableZoom: true,
                showTooltip: true,
                values: sample_data,
                scaleColors: ['#1de9b6', '#03a9f5'],
                normalizeFunction: 'polynomial'
            });
        })(jQuery);
    </script>
	
</body>
</html>