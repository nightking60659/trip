<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="http://kendo.cdn.telerik.com/2018.1.221/styles/kendo.common.min.css" />
    <link rel="stylesheet" href="http://kendo.cdn.telerik.com/2018.1.221/styles/kendo.default.min.css" />
    <link rel="stylesheet" href="http://kendo.cdn.telerik.com/2018.1.221/styles/kendo.default.mobile.min.css" />
<style>
        *{
        margin:0;
        padding:0;
        }
        
       
        .triplist{
            width:100%;
            padding:10px auto;
            overflow: auto;
            height: 100%;
       
        }
        .tripnum{
            width:100px;	
            border:2px solid blue;
            border-radius: 50px;
            float:left; 
            margin:10px 5px;
            margin-bottom: 20px;
               
            
        }
        .tripcontext{
            margin:5px auto;
            height:15%;
            width:100%;
        }
        #arrow{
        width:50px;
        margin-bottom: 20px;
        
        }
        .timestyle{
        
        width:100px;
        margin:10px;
        float:left;
        
        }
        .tripli{
        width:200px;
       float: left;
         
            background: rgba(127, 193, 255, 0.918);
            padding:10px 5px;
            border-radius: 5px;
        }
        .tripTitle{
            
            width:90%;
           border-radius: 5px;
           background: rgba(96, 106, 165, 0.904);
           padding:5px;
           margin:0 auto;
            
        }
        .tripAction{
            margin:0 auto;
           width:90%;
        }
        .tripContext{
            overflow: auto;
            background-color: aqua;
            width:100%;
        }
        .time.contex{
            font-size: 5px;
        }
        .timestyle.col-5{
            margin:0px;
        }
        .timestyle{
           margin: 0;
           float: left;
           width: 50px;
        }
        .tripli{
            border:solid black 1px; 
            width:250px;
        }
        .foot{
            background-color: aqua;
            width:350px;
            height:15%;
            padding: auto;
            width:100%;
        }
        .foot .main{
            border:5px solid white;
            border-radius: 30px;
            width:30%;
            height: 30px;
            margin:30px auto;
          
        }
        .aside{
            width:20%;
            float:left;
            height:100%;
        }
        .listContext{
            width:320px;
            height:210px;
            }
        </style>
         <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height:100%;
        margin: 0;
        padding: 0;
      }
      
    </style>
</head>
<body>


    <div class="aside">
    	<div class="triplist">
		<div class="tripContext">
			<h3>tripname</h3> 
				<div class="timestyle col-5">
			        <span class="time contex">08:00</span>
			        <br>
			        <span style="margin:15px;">|</span>
			        <br>
			        <span class="time contex">10:00</span>
			    </div>
		</div>
	
        	<div class="tripnum"><center><h6 class="tripcontext">Day1</h6></center></div>
        	<img id="arrow" src="images/btn.png">

        	<div class="listContext">
	            <div class="timestyle">
	                <span class="time">08:00</span>
	                <br>
	                <span style="margin-left:15px;">|</span>
	                <br>
	                <span class="time">10:00</span>
	            </div>
	            <div class="tripli " >
	                <h3 class="tripTitle">(1)xxxxx</h3>
	                <div class="tripAction">xx 不停留</div>
	            </div>
        	</div>

       
	        <div class="foot">
	            <div class="foot main"><center><h6>+新增天數</h6></center></div>
	        </div>
    	</div>
    </div>

<div class="main">
<div class="search-container">
    <form action="/action_page.php">
      <input type="text" placeholder="Search.." name="search">
      <button type="submit"><i class="fa fa-search"></i></button>
    </form>
  </div>
 <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">新增行程</button>	
   <div id="map" ></div>
 
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                   <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" 
                            aria-hidden="true">×
                    </button>
                </div>

                <h2>建立行程</h2>

                <div id="example">
                    <div class="demo-section k-content">
        
                        <h4>Start date:</h4>
                        <form action="TripPlan" method="get" enctype='application/x-www-form-urlencoded'>
                        <input id="start" style="width: 100%;" value="2011-10-10" name="StartDate"/>
        
                        <h4 style="margin-top: 2em">End date:</h4>
                        <input id="end" style="width: 100%;" value="2012-10-10" name="EndDate"/>
                        <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                </div>
           </div>
            </div>
        </div>
        
</div>

        <script>

        var map;
        function initMap() {
          //設定中心點
            var center = {lat: 23.9266223, lng: 121.5407045};
            //建立map
          map = new google.maps.Map(document.getElementById('map'), {
            zoom: 10,
            center:center
          });
         
       //讀取geoJson
         map.data.loadGeoJson("json/Scenic_spot_C_f1.json")
          //建立標記
          var name;
        mark=new google.maps.Marker({
        	radious:2000,
            map:map
        });    
          var infowindow ;
       
        //觸發事件
         map.data.addListener('click',function(event){
           
            //資料視窗如果為true,則關閉資料視窗
             if(infowindow){
                 infowindow.close();
             }
            
            //取得地標的Name
             name= event.feature.getProperty("Name");

             infowindow = new google.maps.InfoWindow({
            //資料視窗加入訊息
            content:name
            })

            //標記放進地標
            mark.setPosition (event.latLng);
           //建立資料視窗
          
            
           infowindow.open(map,mark);
           
         });
         
        }

    
  
      </script>
    <script async defer
    
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDf6zB19vCK-owPk0xpD9thNJ9LJaE03eo&callback=initMap">
    </script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="http://kendo.cdn.telerik.com/2018.1.221/js/kendo.all.min.js"></script>
<script>
    $(document).ready(function() {
        function startChange() {
            var startDate = start.value(),
            endDate = end.value();

            if (startDate) {
                startDate = new Date(startDate);
                startDate.setDate(startDate.getDate());
                end.min(startDate);
            } else if (endDate) {
                start.max(new Date(endDate));
            } else {
                endDate = new Date();
                start.max(endDate);
                end.min(endDate);
            }
        }

        function endChange() {
            var endDate = end.value(),
            startDate = start.value();

            if (endDate) {
                endDate = new Date(endDate);
                endDate.setDate(endDate.getDate());
                start.max(endDate);
            } else if (startDate) {
                end.min(new Date(startDate));
            } else {
                endDate = new Date();
                start.max(endDate);
                end.min(endDate);
            }
        }

        var start = $("#start").kendoDatePicker({
            change: startChange,
            format:"yyyy-MM-dd"
        }
        ).data("kendoDatePicker");

        var end = $("#end").kendoDatePicker({
            change: endChange,
            format:"yyyy-MM-dd"
        }).data("kendoDatePicker");

        start.max(end.value());
        end.min(start.value());
    });
</script>
</body>
</html>