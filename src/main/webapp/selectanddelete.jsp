<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="tripBean" class="trip.TripDAO" />
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
<c:set var="funcName" value="CT" scope="session" />
<jsp:include page="/fragment/top.jsp" />
<div class="container body">
		<div class="btnsd">
			<div class="btn">
				<form action="select" method="post">
					<input type="text" name="tripno"> 
					<input type="submit" value=查詢>
					</form>
			</div>
			<div class="btn">
				<form action="delete" method="post">
					<input type="text" name="tripno"> 
					<input type="submit" value=刪除>
				</form>
			</div>
			<br>
			<br>
			<br>
			<div>
			<div class="card" style="width: 18rem;">
  			<img class="card-img-top" src="..." alt="Card image cap">
  			<div class="card-body">
  			<h2>${tripbean.name}</h2>
  			
    <p class="card-text">${tripbean.main}</p>
  </div>
</div>
			</div>
		</div>
	</div>

</body>
</html>