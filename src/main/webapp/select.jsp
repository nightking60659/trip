<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查詢</title>
</head>
<body>
<c:set var="funcName" value="CT" scope="session"/>
<jsp:include page="/fragment/top.jsp"/>

			<h1>第${tripbean.no}筆</h1>
			<h1>地區:${tripbean.place}</h1>
			<h1>分享日期:${tripbean.date}</h1>
			<h1>分類:${tripbean.type}</h1>
			<h1>標題:${tripbean.name}</h1>
			<h1>上傳時間:${tripbean.tdate}</h1>
			<h1>內容:${tripbean.main}</h1>
</body>
</html>