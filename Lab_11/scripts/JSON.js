function Fill_JSON(req){
      let array = eval('('+req.responseText+')');
      let html = "";
       for (var i = 0; i < array.X.length; i++){
    	 html += array.X[i].randValue + " ";
         document.getElementById("div_json").innerHTML = "JSON: " + html;
       }
   };
   
   function OnClick_JSON(n, s){
        var patern = new RegExp(/^[1-9]+[0-9]*$/); 
        if (patern.test(n)){
        if (req){
          req.open("POST","http://localhost:8080/Lab_11/Sss_JSON", true);
          req.onreadystatechange = () => {
              if (req.readyState === 4) {
                  if (req.status === 200) {
                	  Fill_JSON(req);
                  } else alert("status = " + req.status + "\n" + req.statusText);
              }
          };      
          req.setRequestHeader("XRand-N",  n);
          req.send("null");
       };
      }else alert ("error");
   };


