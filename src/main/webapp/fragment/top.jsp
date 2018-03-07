<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
         *{ 
                 padding: 0px; 
         margin: 0px; 
       
         } 
        .tmain{
            width: 1100px !important;
            margin: auto !important;
          
            overflow: hidden !important;
            background:rgb(101, 183, 238) !important;
            
        }
        .topimg{
            width:1100px !important;
            height: 200px !important;
            opacity: 0.8 !important;
        }
        .top{
            width:1100px !important;
        }
    .topli{
      text-align: center  !important; 
        float: left  !important;
        width:15% !important;
        border-right:  black solid 2px !important;
        
        /* border:  black solid 2px; */
        
        border-left: black solid 2px !important;
        padding:10px 5% !important;
        background-color:rgb(101, 183, 238) !important;
        margin-right:-5px;
    }
    .topli:hover{
        background-color: aquamarine;
        
    }
    </style>
</head>
<body>
    <div class="tmain">
    <img class="topimg" src="/trip/images/topbg.jpg">
    <div class="top">
            <a href="/trip/index.jsp"><div class="topli">景點首頁</div></a>
            <a href="/trip/createtrip.jsp"><div class="topli">新增景點</div></a>
            <a href="/trip/update.jsp"><div class="topli">修改景點</div></a>
            <a href="/trip/selectanddelete.jsp"><div class="topli">查詢及刪除</div></a>
    </div>
</div>
</body>
</html>