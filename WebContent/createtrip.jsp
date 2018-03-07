<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}



.body {
	width: 800px;
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

div {
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

	
		<div class="body">
			<h1 style="text-align: center;">旅遊資訊</h1>
			<form action="TripDEMO" method="post">
				<table>
					<thead>
					<tr>
						<th colspan="2">新增旅遊景點</th>
					</tr>
					</thead>
					<tbody>
					<tr>
						<td class="title">地區</td>
						<td class="main"><select name="tripno">
							<option value="01">北部</option>
							<option value="02">中部</option>
							<option value="03">南部</option>
							<option value="04">東部</option>
						</select>
							</td>
					</tr>
					<tr>
						<td class="title">景點名稱</td>
						<td class="main"><input type="text" name="tripname"
							class="maintd" /></td>
					</tr>

					<tr>
						<td class="title">分享日期</td>
						<td class="main"><input type="date" name="tripdate" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="checkbox" name="triptype"
							value=view>風景 <input type="checkbox" name="triptype">博物館
							<input type="checkbox" name="triptype">公園 <input
							type="checkbox" name="triptype">夜市 <input type="checkbox"
							name="triptype">古蹟 <input type="checkbox" name="triptype">觀光</td>
					</tr>




					<tr class=divmain>
						<td colspan="2">
							<p>內容:</p> <textarea name="tripmain" cols="70" rows="20">分享文於此.....</textarea>

						</td>
					</tr>
					<tr >
						<td colspan="2"><input type="file" name="trippic" multiple="multiple"></td>
					</tr>
					</tbody>
				</table>
				<br>
				<div>
					<input type="submit" value="送出">
				</div>
			</form>
		</div>
	


</body>
</html>