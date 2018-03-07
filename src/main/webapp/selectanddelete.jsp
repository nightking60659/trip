<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<jsp:useBean id="tripBean" class="trip.TripDAO"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.body{
	width:1000px;
	margin: 10px auto;
	
	}
</style>
</head>
<body>
<c:set var="funcName" value="CT" scope="session"/>
<jsp:include page="/fragment/top.jsp"/>
<div class="body">
		<form action="select" method="post">
		<input type="text" name="tripno">
		<input type="submit" value=查詢>
		</form>

		<br>
		<form action="update" method="post">
		<input type="text"  name="tripno">
		<input type="submit" value=更新>
		</form>
		<br>
		<form action="delete" method="post">
		<input type="text"  name="tripno">
		<input type="submit" value=刪除>
		</form>
		</div>
		
		

</body>
</html>