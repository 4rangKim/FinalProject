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
					<th>차량 번호</th>
					<th>포인트</th>
				</tr>
				<tr>
					<td>lee</td>
					<td>이말순</td>
					<td>010-1234-5678</td>
					<td>12가 3456</td>
					<td>100,000</td>
				</tr>
			</table>
		</div>
</body>
</html>