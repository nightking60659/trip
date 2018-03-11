<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--     <c:if test="${empty LoginOK}"> --%>
<%--     <c:set var="target" value="${pageContext.request.servletPath}" scope="session"/> --%>
<%--     <c:redirect url="../login/login.jsp" /> --%>
<%--     </c:if> --%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/trip/css/mycostum_crt.css">

</head>
<body>
<c:set var="funcName" value="CT" scope="session"/>
<jsp:include page="/fragment/top.jsp"/>
	
		<div class="container body" id="v1">
		
			<h1 style="text-align: center;">旅遊資訊</h1>
			<form action="TripDEMO" method="post" enctype='multipart/form-data'>
				<table class="crt-table">
					<thead>
					<tr>
						<th class="crt-th" colspan="2">新增旅遊景點</th>
					</tr>
					</thead>
					<tbody>
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
						<div class="er" style="color:#FF0000;font-size:x-small;display:inline;">${ErrorMsg.name}</div>
						</td>
					</tr>

					<tr>
						<td class="title crt-td">分享日期</td>
						<td class="main crt-td">
						<input type="date" name="tripdate" value="${param.tripdate}"/></td>
					</tr>
					<tr>
						<td class = "crt-td" colspan="2">
							<input type="radio" name="triptype"	value="landscape">風景 
							<input type="radio" name="triptype" value="museum">博物館
							<input type="radio" name="triptype" value="park">公園
							<input type="radio" name="triptype" value="night market">夜市
							<input type="radio" name="triptype" value="Monuments">古蹟 
							<input type="radio" name="triptype" value="sightsee">觀光</td> 
					</tr>




					<tr class=divmain>
						<td class = "crt-td" colspan="2">
							<span>內容:</span>
							<div class="er" style="color:#FF0000;font-size:x-small;display:inline;">${ErrorMsg.name}
							</div>
							
							<textarea  class="crt-textarea" name="tripmain" placeholder="分享文於此....."  cols="60" rows="20"></textarea>
							
						</td>
					</tr>
					<tr >
						<td class= "crt-td" colspan="2">
						
						<input type="file" name="tripimage" >
						<input type="hidden" name="tripno">
						</td>
					</tr>
					</tbody>
				</table>
				<br>
				<div class="er">
					<input type="submit" value="送出">
				</div>
			</form>

		</div>
	

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>