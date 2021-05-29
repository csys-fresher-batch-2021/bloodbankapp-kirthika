<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add Donor</title>
<%
String loggedInUsername=(String)session.getAttribute("LOGIN_USER");

%>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	 <div class="d-flex justify-content-center">
	<h3>Add Donor</h3>
	</div>
	<form action="AddDonorServlet">
	
	<div class="d-flex justify-content-center">
	<label for="donorName"></label>
	<input type="text" name="donorName" placeholder="Enter donor name" required autofocus/> 
    </div>
	
	<br/>
	<div class="d-flex justify-content-center">
	<label for="bloodGroup"></label>
	<select name="bloodGroup" required>
	<option>----Blood type----</option>
	<option value="A+">A+</option>
	<option value="A-">A-</option>
	<option value="B+">B+</option>
	<option value="B-">B-</option>
	<option value="O+">O+</option>
	<option value="O-">O-</option>
	
	</select>
	</div>
	
	<br/>
	 <div class="d-flex justify-content-center">
	<label for="mobileNumber"></label>
	<input type="number" name="mobileNumber" placeholder="Enter mobile number" required autofocus/>
	</div>
	
	<br/>
	 <div class="d-flex justify-content-center">
	<label for="age"></label>
	<input type="number" name="age" placeholder="Enter age" required autofocus/>
	</div>
	
	<br/>
	 <div class="d-flex justify-content-center">
	<label for="place"></label>
	<input type="text" name="place" placeholder="Enter place" required autofocus/>
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
	
</main>
</body>
</html>