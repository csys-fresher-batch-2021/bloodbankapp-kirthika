<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add Donor</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h3>Add Donor</h3>
	<form action="AddDonorServlet">
	<label for="donorName"></label>
	<input type="text" name="donorName" placeholder="Enter donor name" required autofocus/> 
	<br/>
	<br/>
	<label for="bloodGroup"></label>
	<select name="bloodGroup" required>
	<option>----Blood type----</option>
	<option value="A+">A+</option>
	<option value="A-">A-</option>
	<option value="B+">B+</option>
	<option value="B-">B-</option>
	<option value="O+">O+</option>
	<option value="O-">O-</option>
	<option value="A1B">A1B</option>
	</select>
	<br/>
	<br/>
	<label for="mobileNumber"></label>
	<input type="number" name="mobileNumber" placeholder="Enter mobile number" required autofocus/>
	<br/>
	<br/>
	<label for="age"></label>
	<input type="number" name="age" placeholder="Enter age" required autofocus/>
	<br/>
	<br/>
	<label for="place"></label>
	<input type="text" name="place" placeholder="Enter place" required autofocus/>
	<br/>
	<br/>
	<%
	       String message=request.getParameter("errorMessage");
			if(message==null)
			{
				out.print("");
			}
			else
			{
	          out.print("<font color='red'>"+message+"</font>");
			}
	%>
    <br/>
    <br/>
	
	<button type="submit" class="btn btn-primary">Add Donor</button>
	<br/>
	<br/>
	<a href="adminmanager.jsp">Back to homepage</a>
	
	</form>
	
</main>
</body>
</html>