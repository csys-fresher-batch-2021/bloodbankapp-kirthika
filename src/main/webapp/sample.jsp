<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" 
        crossorigin="anonymous">
  
    <script src=
  "https://code.jquery.com/jquery.min.js">
    </script>
  
    <script src=
"https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js">
    </script>
  
    <link href=
"https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css"
         rel="stylesheet"/>
<title>Insert title here</title>
</head>
<body >

<input type="checkbox" id="toggle-one">
  
        <script>
        let value="false";
      if(!value){
			alert("true");
			document.querySelector('#toggle-one').checked=true;
			
			
		}else{
			alert("false");
			document.querySelector('#toggle-one').checked=false;
			
		}
  			 
          
        	
		
		</script>
		<script>
            $(function() {
                $('#toggle-one').bootstrapToggle({
                    on: 'Enabled',
                    off: 'Disabled'
                });
            })
        </script>
</body>
</html>