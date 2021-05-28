<!DOCTYPE html>
<html lang="en">
<head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<meta charset="ISO-8859-1">
<title>Add Donor</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	 <div class="d-flex justify-content-center">
	<h3>Add Donor</h3>
	</div>
	<form onsubmit="addDonor()">
	
	<div class="d-flex justify-content-center">
	<label for="donorName"></label>
	<input type="text" id="donorName" placeholder="Enter donor name" required autofocus/> 
    </div>
	
	<br/>
	<div class="d-flex justify-content-center">
	<label for="bloodGroup"></label>
	<select id="bloodGroup" required>
	<option>----Blood type----</option>
	<option value="A+">A+</option>
	<option value="A-">A-</option>
	<option value="B+">B+</option>
	<option value="B-">B-</option>
	<option value="O+">O+</option>
	<option value="O-">O-</option>
	<option value="A1B">A1B</option>
	</select>
	</div>
	
	<br/>
	 <div class="d-flex justify-content-center">
	<label for="mobileNumber"></label>
	<input type="number" id="mobileNumber" placeholder="Enter mobile number" required autofocus/>
	</div>
	
	<br/>
	 <div class="d-flex justify-content-center">
	<label for="age"></label>
	<input type="number" id="age" placeholder="Enter age" required autofocus/>
	</div>
	
	<br/>
	 <div class="d-flex justify-content-center">
	<label for="place"></label>
	<input type="text" id="place" placeholder="Enter place" required autofocus/>
	</div>
	
	<br/>
	
	<%
	       String message=request.getParameter("errorMessage");
			if(message==null)
			{
				out.print("");
			}
			else
			{
	          out.print("<font color='red'><center>"+message+"</font>");
			}
	%>
    <br/>
    <br/>
	<div class="d-flex justify-content-center">
	<button type="submit" class="btn btn-primary">Add Donor</button>
	</div>
	<br/>
	<br/>
	<a href="adminmanager.jsp">Back to homepage</a>
	
	</form>
	<script>
	function addDonor()
	{
	event.preventDefault();
	console.log("Fetching donor name");
	let donorName=document.querySelector("#donorName").value;
	let donorBlood=document.querySelector("#bloodGroup").value;
	let donorNum=document.querySelector("#mobileNumber").value;
	let donorAge=document.querySelector("#age").value;
	let donorPlace=document.querySelector("#place").value;
	let url="AddDonorServlet1?donorName="+donorName+"?donorBlood="+donorBlood+"?donorNum="+donorNum+"?donorAge="+donorAge+
			"?donorPlace="+donorPlace;
	fetch(url).then(res=>{
		
		let result=res.data;
		console.log(res);
		alert("hello");
	})
	}
	</script>
</main>
</body>
</html>