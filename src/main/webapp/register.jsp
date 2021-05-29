<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<div class="d-flex justify-content-center">
			<h3>User Sign up</h3>
		</div>
		<form action="UserRegistration">

			<div class="d-flex justify-content-center">
				<label for="userName"></label> <input type="text" name="userName"
					placeholder="Enter User name" required autofocus />
			</div>
			<br/>
			<div class="d-flex justify-content-center">
				<label for="password"></label> <input type="password"
					name="password" placeholder="Create password" required autofocus />
			</div>
			<br />
			<div class="d-flex justify-content-center">
				<label for="bloodGroup"></label> <select name="bloodGroup" required>
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

			<br />
			<div class="d-flex justify-content-center">
				<label for="mobileNumber"></label> <input type="number"
					name="mobileNumber" placeholder="Enter mobile number" required
					autofocus />
			</div>
			<br />

			<div class="d-flex justify-content-center">
				<label for="age"></label> <input type="number" name="age"
					placeholder="Enter age" required autofocus />
			</div>

			<br />
			<div class="d-flex justify-content-center">
				<label for="place"></label> <input type="text" name="place"
					placeholder="Enter place" required autofocus />
			</div>

			<br />
			<%
			String message = request.getParameter("message");
			if (message == null) {
				out.print("");
			} 
			else if(message.equals("Registration Successful"))
			{
				out.print("<font color='green'><center>" + message + "</font>");
			}
			else {
				out.print("<font color='red'><center>" + message + "</font>");
			}
			%>
			<br />
			<br/>

			<div class=" row =2 d-flex justify-content-center ">
				<div class="col-1">
					<button type="submit" class="btn btn-success">Register</button>
				</div>
				<div class="col-1">
					<button type="reset" class="btn btn-danger">Reset</button>
				</div>
			</div>

		</form>
	</main>