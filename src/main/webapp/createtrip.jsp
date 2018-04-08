<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--     <c:if test="${empty LoginOK}"> --%>
<%--     <c:set var="target" value="${pageContext.request.servletPath}" scope="session"/> --%>
<%--     <c:redirect url="login/login.jsp" /> --%>
<%--     </c:if> --%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/trip/css/mycostum_crt.css">
<link rel="stylesheet" href="/trip/css/jquery-ui.DatePicker.min.css">
<link rel="stylesheet" href="/trip/css/jquery-ui.structure.DatePicker.min.css">
<link rel="stylesheet" href="/trip/css/jquery-ui.theme.DatePicker.min.css">
<style>

</style>
</head>
<body>



<c:set var="funcName" value="CT" scope="session"/>
<jsp:include page="/fragment/top.jsp"/>
	
<div class="container body" id="v1">
			
		<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">新增景點	</button>	
			<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModalUpdate">修改景點</button>	
			
			
<div class="form-group row">
				<label for="" class="col-sm-2 col-form-label">地區</label>
					<div class="col-sm-10">
						<select class="form-control" name="tripPlace" id="tripPlace" >
							<option value="">地區</option>
							<option value="北部">北部</option>
							<option value="中部">中部</option>
							<option value="南部">南部</option>
							<option value="東部">東部</option>
							<option value="外島">外島</option>
						</select>
					</div>
			</div>
			<div class="form-group row">
				<label for="" class="col-sm-2 col-form-label">區域</label>
					<div class="col-sm-10">
						<select class="form-control" name="tripArea" id="tripArea" >
								<option value="">請輸入區域</option>
						</select>
					</div>
			</div>


			<div class="form-group row">
					<label for="" class="col-sm-2 col-form-label">類別</label>
					  <div class="col-sm-10">
				    <div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="tripType" id="inlineRadio1" value="landscape">  <label class="form-check-label" for="inlineRadio1">風景</label>
					</div>
							<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="tripType" id="inlineRadio2" value="museum"> <label class="form-check-label" for="inlineRadio2">博物館</label>
							</div>
							<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="tripType" id="inlineRadio3" value="park"> <label class="form-check-label" for="inlineRadio3">公園</label>
							</div>
							<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="tripType" id="inlineRadio4" value="night market"> <label class="form-check-label" for="inlineRadio4">夜市</label>
							</div>
							<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="tripType" id="inlineRadio5" value="Monuments"> <label class="form-check-label" for="inlineRadio5">古蹟</label>
							</div>
							<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="tripType" id="inlineRadio6" value="sightsee"> <label class="form-check-label" for="inlineRadio6">觀光</label>
							</div>
				</div>


			</div>






















<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
       		<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" 
						aria-hidden="true">×
				</button>
			</div>
			
					<h2 style="text-align: center"><span class="badge badge-secondary">新增旅遊景點</span></h2>
					
			<form action="TripDEMO" method="post" enctype='multipart/form-data'>
 				 
			
			<div class="form-group row">
					 <label for="name" class="col-sm-2 col-form-label">景點名稱:</label>
					 <div class="col-sm-10">
				     <input type="text" class="form-control" id="name" name="ViewName" value="${param.tripname}" placeholder="名稱" aria-label="Username" aria-describedby="basic-addon1" />
					 <div class="er" style="color:#FF0000;font-size:x-small;display:inline;">${ErrorMsg.name}</div>
					</div>
			</div>
			<div class="form-group row">
					 <label for="name" class="col-sm-2 col-form-label">地址:</label>
					 <div class="col-sm-10">
				     <input type="text" class="form-control" id="address" name="ViewAddress" value="${param.tripname}" placeholder="地址" aria-label="Username" aria-describedby="basic-addon1" />
					 <div class="er" style="color:#FF0000;font-size:x-small;display:inline;">${ErrorMsg.name}</div>
					</div>
			</div>	
			<div class="form-group row">
					 <label for="name" class="col-sm-2 col-form-label">官方網址:</label>
					 <div class="col-sm-10">
				     <input type="text" class="form-control" id="web" name="ViewWeb" value="${param.tripname}" placeholder="官方網址" aria-label="Username" aria-describedby="basic-addon1" />
					 <div class="er" style="color:#FF0000;font-size:x-small;display:inline;">${ErrorMsg.name}</div>
					</div>
			</div>
			<div class="form-group row">
					 <label for="name" class="col-sm-2 col-form-label">電話</label>
					 <div class="col-sm-10">
				     <input type="text" class="form-control" id="phone" name="ViewPhone" value="${param.tripname}" placeholder="電話" aria-label="Username" aria-describedby="basic-addon1" />
					 <div class="er" style="color:#FF0000;font-size:x-small;display:inline;">${ErrorMsg.name}</div>
					</div>
			</div>	
			
				<div class="form-group row">
				<label for="main" class="col-sm-2 col-form-label">內容:</label>
				<div class="er" style="color:#FF0000;font-size:x-small;display:inline;">${ErrorMsg.name}
				 </div>
				   <div class="col-sm-10">
					<textarea  class="form-control crt-textarea" id="main" name="ViewMain" placeholder="分享文於此....."  cols="60" rows="20"></textarea>
				</div>
				</div>
				<div class="form-group row">
					 <label for="exampleFormControlInput1" class="col-sm-2 col-form-label">新增圖片</label>
					   <div class="col-sm-10">
					 <input type="file" class="form-control-file" id="exampleFormControlFile1" name="imageName">
				</div>
				</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			</form>
			 </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
		
		
		<div class="modal fade" id="myModalUpdate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
       		<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" 
						aria-hidden="true">×
				</button>
			</div>
			
					<h2 style="text-align: center"><span class="badge badge-secondary">更新旅遊景點</span></h2>
					
			<form action="TripDEMO" method="post" enctype='multipart/form-data'>
 				 
			
			<div class="form-group row">
					 <label for="name" class="col-sm-2 col-form-label">景點名稱:</label>
					 <div class="col-sm-10">
				     <input type="text" class="form-control" id="uname" name="ViewName" value="${param.viewname}" placeholder="名稱" aria-label="Username" aria-describedby="basic-addon1" />
					 <div class="er" style="color:#FF0000;font-size:x-small;display:inline;">${ErrorMsg.name}</div>
					</div>
			</div>
			<div class="form-group row">
					 <label for="name" class="col-sm-2 col-form-label">地址:</label>
					 <div class="col-sm-10">
				     <input type="text" class="form-control" id="uaddress" name="ViewAddress" value="${param.viewaddress}" placeholder="地址" aria-label="Username" aria-describedby="basic-addon1" />
					 <div class="er" style="color:#FF0000;font-size:x-small;display:inline;">${ErrorMsg.name}</div>
					</div>
			</div>	
			<div class="form-group row">
					 <label for="name" class="col-sm-2 col-form-label">官方網址:</label>
					 <div class="col-sm-10">
				     <input type="text" class="form-control" id="uweb" name="ViewWeb" value="${param.web}" placeholder="官方網址" aria-label="Username" aria-describedby="basic-addon1" />
					 <div class="er" style="color:#FF0000;font-size:x-small;display:inline;">${ErrorMsg.name}</div>
					</div>
			</div>
			<div class="form-group row">
					 <label for="name" class="col-sm-2 col-form-label">電話</label>
					 <div class="col-sm-10">
				     <input type="text" class="form-control" id="uphone" name="ViewPhone" value="${param.phone}" placeholder="電話" aria-label="Username" aria-describedby="basic-addon1" />
					 <div class="er" style="color:#FF0000;font-size:x-small;display:inline;">${ErrorMsg.name}</div>
					</div>
			</div>	
			
				<div class="form-group row">
				<label for="main" class="col-sm-2 col-form-label">內容:</label>
				<div class="er" style="color:#FF0000;font-size:x-small;display:inline;">${ErrorMsg.name}
				 </div>
				   <div class="col-sm-10">
					<textarea  class="form-control crt-textarea" id="umain" name="uViewMain" placeholder="分享文於此....."  cols="60" rows="20"></textarea>
				</div>
				</div>
				<div class="form-group row">
					 <label for="exampleFormControlInput1" class="col-sm-2 col-form-label">新增圖片</label>
					   <div class="col-sm-10">
					 <input type="file" class="form-control-file" id="exampleFormControlFile1" name="imageName">
				</div>
				</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			</form>
			 </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>

	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script> -->
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script> -->
<script src="https://cdn.ckeditor.com/4.7.3/standard-all/ckeditor.js"></script>
<script src="js/jquery-ui.DatePicker.min.js"></script>

<script>
$(document).ready(function(){
	CKEDITOR.plugins.addExternal("codesnippet", "https://cdnjs.cloudflare.com/ajax/libs/ckeditor/4.7.3/plugins/codesnippet/plugin.js", "");
	CKEDITOR.replace("ViewMain", {
		extraPlugins: "codesnippet",
		codeSnippet_theme: "solarized_dark",
		removeButtons: 'Replace,Scayt,Source,Anchor,Table,Maximize,Image',
		skin :'moono',
		resize_maxWidth : 100,
		resize_maxWidth : 900,
		resize_enabled : false
	});
	
	CKEDITOR.replace("uViewMain", {
		extraPlugins: "codesnippet",
		codeSnippet_theme: "solarized_dark",
		removeButtons: 'Replace,Scayt,Source,Anchor,Table,Maximize,Image',
		skin :'moono',
		resize_maxWidth : 100,
		resize_maxWidth : 900,
		resize_enabled : false
	});
	
	
});

$( "#datepicker" ).datepicker({
	      showOtherMonths: true,
	      selectOtherMonths: true
});

	

</script>
<script src="js/custom.js"></script>
</body>
</html>