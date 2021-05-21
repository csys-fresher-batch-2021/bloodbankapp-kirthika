<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Search Donor</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<div class="d-flex justify-content-center">
	<h3>Search Donor</h3>
	</div>
	<form action="DonorSearchServlet">
   <div class="d-flex justify-content-center" >
	<div class="col-4">
	<label for="bloodGroup"></label>
	<select name="bloodGroup" required class="form-control form-control-sm">
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
	</div>
	<br/>
	<br/>
	<div class="d-flex justify-content-center">
	<div class="col-4">
	<label for="place"></label>
	<input type="text" name="place" placeholder="Enter place" required autofocus class="form-control form-control-sm"/>
	</div>
	</div>
	<br/>
	<br/>

	<div class="d-flex justify-content-center">
	<button type="submit" class="btn btn-primary">Search Donor</button>
	</div>
	<br/>
	<br/>
	<a href="adminmanager.jsp">Back to homepage</a>
	
	</form>
	
</main>
</body>
</html>