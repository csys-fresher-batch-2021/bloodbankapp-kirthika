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
			<div class="d-flex justify-content-center">
				<div class="col-4">
					<label for="bloodGroup"></label> <select name="bloodGroup" required
						class="form-control form-control-sm">
						<option>----Blood type----</option>
						<option value="A+">A+</option>
						<option value="A-">A-</option>
						<option value="B+">B+</option>
						<option value="B-">B-</option>
						<option value="O+">O+</option>
						<option value="O-">O-</option>

					</select>
				</div>
			</div>
			<br /> <br />
			<div class="d-flex justify-content-center">
				<div class="col-4">
					<select name="place" class="form-control form-control-sm" required>
						<option>Select a District</option>
						<option value="ariyalur">Ariyalur</option>
						<option value="chennai">Chennai</option>
						<option value="coimbatore">Coimbatore</option>
						<option value="erode">Erode</option>
						<option value="salem">Salem</option>
						<option value="thanjavur">Thanjavur</option>
						<option value="trichy">Trichy</option>
						<option value="vellore">Vellore</option>
						<option value="villupuram">Villupuram</option>
						<option value="virudhunagar">Virudhunagar</option>
					</select>
				</div>
			</div>
			<br />
			<%
			String message = request.getParameter("errorMessage");
			if (message == null) {
				out.print("");
			} else {
				out.print("<font color='red'><center>" + message + "</font>");
			}
			%>
             <br />
			<div class="d-flex justify-content-center">
				<button type="submit" class="btn btn-primary">Search Donor</button>
			</div>
			<br /> <br /> <a href="adminmanager.jsp">Back to homepage</a>

		</form>

	</main>
</body>
</html>