<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sucess create</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	line-height: 2em;
	
}
.top{
	width:1000px;
	overflow:hidden;
	margin:auto;
}

body{
background:rgb(101, 183, 238);
}
.body {
	background-color:#ffd1a4;
	width: 1000px;
	height: 95%;
	margin:0px auto;
	padding: 0px 50px;
}

table {
	margin: 0 auto;
	
	
}

td {
	border:solid;
	
	
}

th {
	border:  solid;
}

.er{
	padding: 0px 40%;
}

.title {
	width: 100px;
}

.main {
	width: 700px;
}

.maintd {
	width: 99%;
	height: 100%;
	
}



textarea {
	
	width: 99%;
	margin:auto;
	resize: none;
	overflow-y: auto;
}

.divmain {
padding:1em;
	
}
</style>
</head>
<body>
<c:set var="funcName" value="CT" scope="session"/>
<jsp:include page="/fragment/top.jsp"/>
	<div class="body">
		<h1 style="text-align: center;">旅遊資訊</h1>
		
			<table>
				<thead>
					<tr>
						<th colspan="2">更新資料</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class=title>筆數</td>
						<td class=main>${tripBean.no}</td>
					</tr>
					<tr>

						<td class="title">地區</td>
						<td class="main">${tripBean.place}</td>
					</tr>
					<tr>
						<td class="title">景點名稱</td>
						<td class="main">${tripBean.name}
							
						</td>
					</tr>

					<tr>
						<td class="title">分享日期</td>
						<td class="main">${tripBean.date}</td>
					</tr>
					<tr>
						<td colspan="2">
						${tripBean.type}
						</td>
					</tr>




					<tr class=divmain>
						<td colspan="2"><span>內容:</span>
							 ${tripBean.main}</td>
					</tr>
					
				</tbody>
			</table>
			<br>
			
		

	</div>

</body>
</html>