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
	<label for="bloodGroup"></label>
	<input type="text" name="bloodGroup" placeholder="Enter blood group" required autofocus/>
	<br/>
	<label for="mobileNumber"></label>
	<input type="number" name="mobileNumber" placeholder="Enter mobile number" required autofocus/>
	<br/>
	<label for="age"></label>
	<input type="number" name="age" placeholder="Enter age" required autofocus/>
	<br/>
	<button type="submit">Submit</button>
	
	</form>
	
</main>
</body>
</html>