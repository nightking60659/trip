<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/trip/css/mycostum_crt.css">

</head>
<body>
<c:set var="funcName" value="CT" scope="session"/>
<jsp:include page="/fragment/top.jsp"/>
	
		<div class="container crt-body" id="v3">
			<h1 style="text-align: center;">旅遊資訊</h1>
			<form action="update" method="post" >
				<table class="crt-table">
					<thead>
					<tr>
						<th class="crt-th" colspan="2">更新資料</th>
					</tr>
					</thead>
					<tbody>
					<tr>
					<td class=title>筆數</td>
					<td class=main>
					<input type="text" name= "tripno">
					</td>
					</tr>
					<tr>
					
						<td class="title crt-td">地區</td>
						<td class="main crt-td">
						<select name="tripplace" >
							<option value="">地區</option>
							<option value="基隆市">基隆市</option>
							<option value="台北市">台北市</option>
							<option value="新北市">新北市</option>
							<option value="桃園市">桃園市</option>
							<option value="新竹市">新竹市</option>
							<option value="新竹縣">新竹縣</option>
							<option value="宜蘭縣">宜蘭縣</option>
							<option value="臺中市">臺中市</option>
							<option value="苗栗縣">苗栗縣</option>
							<option value="彰化縣">彰化縣</option>
							<option value="南投縣">南投縣</option>
							<option value="雲林縣">雲林縣</option>
							<option value="臺南市">臺南市</option>
							<option value="高雄市">高雄市</option>
							<option value="嘉義市">嘉義市</option>
							<option value="嘉義縣">嘉義縣</option>
							<option value="屏東縣">屏東縣</option>
							<option value="澎湖縣">澎湖縣</option>
							<option value="臺東縣">臺東縣</option>
							<option value="花蓮縣">花蓮縣 </option>
						</select>

						
						
						
							</td>
					</tr>
					<tr>
						<td class="title crt-td">景點名稱</td>
						<td class="main crt-td">
						<input type="text" name="tripname" value="${param.tripname}" class="maintd" />
						<div style="color:#FF0000;font-size:x-small;display:inline;">${ErrorMsg.name}</div>
						</td>
					</tr>

					<tr>
						<td class="title crt-td">分享日期</td>
						<td class="main crt-td">
						<input type="date" name="tripdate" value="${param.tripdate}"/></td>
					</tr>
					<tr>
						<td class="crt-td" colspan="2">
							<input type="radio" name="triptype"	value=landscape>風景 
							<input type="radio" name="triptype" value="museum">博物館
							<input type="radio" name="triptype" value="park">公園
							<input type="radio" name="triptype" value="night market">夜市
							<input type="radio" name="triptype" value="Monuments">古蹟 
							<input type="radio" name="triptype" value="sightsee">觀光</td>
					</tr>




					<tr class=divmain>
						<td class="crt-td" colspan="2">
							<span>內容:</span>
							<div style="color:#FF0000;font-size:x-small;display:inline;">${ErrorMsg.name}
							</div>
							
							<textarea name="tripmain" placeholder="分享文於此....."  cols="70" rows="20"></textarea>
							
						</td>
					</tr>
					<tr >
						<td class="crt-td" colspan="2">
						
						<input type="file" name="trippic" >
						
						</td>
					</tr>
					</tbody>
				</table>
				<br>
				<div>
					<input type="submit" value="更新">
				</div>
			</form>

		</div>
	


</body>
</html>