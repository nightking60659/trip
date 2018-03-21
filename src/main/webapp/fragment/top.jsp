<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.4.0/animate.min.css">
<link rel="stylesheet" href="/trip/css/mycostum_frag.css">
</head>
<body  class="top-frag">


<div class="top-main">

		
		
<ul class="nav nav-fill" >
  <li class="nav-item">
    <a class="nav-link active" href="index.jsp"><strong>首頁</strong></a>
  </li>
  <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"><strong>會員</strong></a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">1</a>
      <a class="dropdown-item" href="#">2</a>
      <a class="dropdown-item" href="#">3</a>
    </div>
  </li>
   <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle"    data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false" data-dropdown-in="bounceinDown" data-dropdown-out="bounceinOutDown"><strong>景點</strong></a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="/trip/createtrip.jsp">新增景點</a>
      <a class="dropdown-item" href="/trip/selectanddelete.jsp">查詢景點</a>
      <a class="dropdown-item" href="/trip/update.jsp">更新景點</a>
    </div>
  </li>
   <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"><strong>飯店</strong></a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">1</a>
      <a class="dropdown-item" href="#">2</a>
      <a class="dropdown-item" href="#">3</a>
    </div>
  </li>
   <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"><strong>餐廳</strong></a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">1</a>
      <a class="dropdown-item" href="#">2</a>
      <a class="dropdown-item" href="#">3</a>
    </div>
  </li>
  <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"><strong>討論區</strong></a>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">1</a>
      <a class="dropdown-item" href="#">2</a>
      <a class="dropdown-item" href="#">3</a>
    </div>
    
  </li>
    <li class="breadcrumb-item"><a href="../login/register.jsp"><strong>註冊</strong></a></li>
    <li class="breadcrumb-item"><a href="../login/login.jsp"><strong>登入</strong></a></li>
  
</ul>



<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100" src="/trip/images/topbg.jpg" alt="First slide">
    <div class="carousel-caption d-none d-md-block">
    <h5>asd</h5>
    <p>asd</p>
  </div>
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="/trip/images/topbg2.jpg" alt="Second slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="/trip/images/topbg3.jpg" alt="Third slide">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
  
</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="../js/floatTop.js"></script>
<script type='text/javascript'>
$(function(){
　$(window).load(function(){
　　$(window).bind('scroll resize', function(){
　　var $this = $(this);
　　var $this_Top=$this.scrollTop();
　　//當高度小於100時，關閉區塊 
　　if($this_Top < 100){
　　　$('#top-bar').stop().animate({top:"-65px"});
　　　}
　　　　if($this_Top > 100){
　　　　$('#top-bar').stop().animate({top:"0px"});
　　　 }
　　}).scroll();
　});
});
</script>




</body>
</html>