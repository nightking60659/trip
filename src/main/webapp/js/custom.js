var place = $("#tripPlace");
place.change(function(){
 var frag = $(document.createDocumentFragment());
 
 var area =$(document.getElementById("tripArea"));
 var all = $(document.createElement("option"));
 var areaArray = new Array("基隆市","台北市","新北市","桃園市","新竹市(縣)","宜蘭縣","苗栗縣","台中市","彰化縣","雲林縣","南投縣","嘉義市(縣)","台南市","高雄市","屏東縣","花蓮縣","台東縣","金門縣","連江縣(馬祖)","澎湖縣","蘭嶼","小琉球","綠島","全部");
 all.text("全部");
 if(place.val()=="北部"){
     area.empty();
     frag.append(all);
     for(i=0;i<6;i++){
     var option = $(document.createElement("option"));
     option.text(areaArray[i]).val(areaArray[i]);
     frag.append(option)
     }
     area.append(frag);
 }else if(place.val()=="中部"){
     area.empty();
     frag.append(all);
     for(i=6;i<11;i++){
     var option = $(document.createElement("option"));
     option.text(areaArray[i]).val(areaArray[i]);
     frag.append(option)
     }
     area.append(frag);
 }else if(place.val()=="南部"){
     area.empty();
     frag.append(all);
     for(i=11;i<15;i++){
     var option = $(document.createElement("option"));
     option.text(areaArray[i]).val(areaArray[i]);
     frag.append(option)
     }
     area.append(frag);
 }else if(place.val()=="東部"){
     area.empty();
     frag.append(all);
     for(i=15;i<17;i++){
     var option = $(document.createElement("option"));
     option.text(areaArray[i]).val(areaArray[i]);
     frag.append(option)
     }
     area.append(frag);
 }else if(place.val()=="外島"){
     area.empty();
     all.text("全部");
     frag.append(all);
     for(i=17;i<23;i++){
     var option = $(document.createElement("option"));
     option.text(areaArray[i]).val(areaArray[i]);
     frag.append(option)
     }
     area.append(frag);
 }

})    
 