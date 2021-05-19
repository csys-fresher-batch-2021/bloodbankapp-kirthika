<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Search Donor</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h3>Search Donor</h3>
	<form action="DonorSearchServlet">
	
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
	<label for="place"></label>
	<input type="text" name="place" placeholder="Enter place" required autofocus/>
	<br/>
	<br/>

	
	<button type="submit" class="btn btn-primary">Search Donor</button>
	<br/>
	<br/>
	<a href="adminmanager.jsp">Back to homepage</a>
	
	</form>
	
</main>
</body>
</html>