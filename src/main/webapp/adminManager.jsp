<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Blood Bank</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<style>
.switch {
	position: relative;
	display: inline-block;
	width: 60px;
	height: 34px;
}

/* Hide default HTML checkbox */
.switch input {
	opacity: 0;
	width: 0;
	height: 0;
}

/* The slider */
.slider {
	position: absolute;
	cursor: pointer;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	background-color: #ccc;
	-webkit-transition: .4s;
	transition: .4s;
}

.slider:before {
	position: absolute;
	content: "";
	height: 26px;
	width: 26px;
	left: 4px;
	bottom: 4px;
	background-color: white;
	-webkit-transition: .4s;
	transition: .4s;
}

input:checked+.slider {
	background-color: #2196F3;
}

input:focus+.slider {
	box-shadow: 0 0 1px #2196F3;
}

input:checked+.slider:before {
	-webkit-transform: translateX(26px);
	-ms-transform: translateX(26px);
	transform: translateX(26px);
}

/* Rounded sliders */
.slider.round {
	border-radius: 34px;
}

.slider.round:before {
	border-radius: 50%;
}
</style>
<%
String loggedInUsername = (String) session.getAttribute("LOGIN_USER");
%>
</head>
<body onload="getStatus()">
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<label for="donorName"></label> <input type="hidden" name="Name"
			value=<%=loggedInUsername%> id="Name" required autofocus />
		<div class="d-flex justify-content-center">
			<%
			if (!loggedInUsername.equals("admin")) {
			%>
			<h3><p style="color:red">
				Welcome
				<%=" " + loggedInUsername%>
				to the Blood Bank
			</p></h3>
			<%
			} else {
			%>
			<h3><p style="color:red">
				Welcome
				<%=" " + loggedInUsername%>
				to the Blood Bank
			</p></h3>
			<%
			}
			%>
		</div>
		<br />
		<%
		if (!loggedInUsername.equals("admin")) {
		%>
		<br/>
		<div class="d-flex justify-content-center">
			<h3>Sleep mode</h3>
		</div>
        <br/>
		<div class="d-flex justify-content-center">
			<div class="d-flex justify-content-left">
				<h5><p style="color:blue">OFF</p></h5>
			</div>
			<label class="switch"> <input type="checkbox"
				id="dndcheckbox" onchange="toggle()"> <span
				class="slider round"></span>
			</label>
			<div class="d-flex justify-content-right">
				<h5><p style="color:blue">ON</p></h5>
			</div>
		</div>
		<br />

		<%
		}
		%>
		<script>
	
		function getStatus(){
			
			let name=document.querySelector("#Name").value;
	        let queryParams="?userName="+name;			
			let url="SleepStatusServlet"+queryParams;
			let dndcheckbox= document.querySelector("#dndcheckbox");
			fetch(url).then(res=>res.json()).then(res=>{
			    let data=res;
			    if(data=="true"){
			  
			    dndcheckbox.checked = true;
			    
			    }
			    else{
			   
			    	dndcheckbox.checked = false;
				    
			    }
			    });
		}
		
		function toggle(){
			let name=document.querySelector("#Name").value;
			let dndcheckbox= document.querySelector("#dndcheckbox");
			let selected = dndcheckbox.checked;
			if(selected==true){
				alert("Sleep mode is activated");
			}
			else{
				alert("Sleep mode is deactivated");
			}
			let queryParams="?name="+name+"&clicked="+selected;
		    let url="SleepServlet"+queryParams;
			fetch(url).then(res=>res.json()).then(res=>{
		        let data=res;
		    });
			
		}
		
		</script>


	</main>
</body>
</html>