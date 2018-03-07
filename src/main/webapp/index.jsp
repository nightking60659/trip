<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style type="text/css">
body{
background:rgb(101, 183, 238);
}
</style>
</head>
<body>
<c:set var="funcName" value="CT" scope="session"/>
<jsp:include page="/fragment/top.jsp"/>
<a href="login/login.jsp">login</a>
<a href="login/logout.jsp">logout</a>
</body>
</html>
