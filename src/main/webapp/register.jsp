<!DOCTYPE html>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.HashMap"%>

<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Register </title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<h3>Register</h3>
<form action="RegisterEmployeeServlet" method="post">


	<%
	HttpSession session1 = request.getSession();
	String errorMessage = request.getParameter("errorMessage");
	String infoMessage = request.getParameter("infoMessage");
	String registeredEmployee = request.getParameter("registeredEmployeeId");
	
	if(errorMessage != null){
		out.println("<font color='red'>"+errorMessage+"</font>");
	}
	if(infoMessage != null){
		out.println("<font color='green'>"+infoMessage+"-"+registeredEmployee+"</font>");
		
	}
	%>
	

	<div class="row">
	  <div class="col">
			<label>First Name  </label><input type="text" name="firstName" class="form-control form-control-sm" id="firstName" placeholder="First Name" required autofocus>
	  </div>
	  <div class="col">
			<label>Last Name  </label><input type="text" name="lastName" id="lastName" class="form-control form-control-sm" placeholder="Employee's Father Name" required >
	  </div>
	</div>
	<div class="row">
		<div class="col">
			<label>Role </label>
			<select name = "Role" id = "Role" class="form-control form-control-sm" required >
				<option value="Technical Consultant" >Technical Consultant </option>
				<option value="HR" >HR </option>
				<option value="System Administration" >System Administration</option>
				<option value="PL SQL" >PL SQL </option>
				<option value="Software Developer" >Software Developer </option>
				<option value="UI-Designer" >Ui-Designer</option>
			</select>
		</div>
		<div class="col">
			<label>Date of Birth</label><input type="date" min='1985-01-01' max='2004-01-01' class="form-control form-control-sm" name="dob" id="dob"  placeholder="YYYY-MM-DD" required>
		</div>
	</div>
	
	<div class="row">
		<div class=" col">
			<label>Mobile Number</label><input type="number" name="Mobile-Number" min="0000000000" max="9999999999" id="Mobile-Number" class="form-control form-control-sm" placeholder="Mobile Number" required>
		</div>
		<div class="col">
			<label>Joined Date</label><input type="date" name="Joined-Date" class="form-control form-control-sm"  value="<%=LocalDate.now()%>" id="Joined-Date" placeholder="YYYY-MM-DD" required>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<label>Gender</label>
			<div class="form-check form-check-inline">
				<label>Male</label><input type="radio" id="Male" name="Gender"  value ="Male" required>
			</div>
			<div class="form-check form-check-inline">
				<label>Female</label><input type="radio" id="Female" name="Gender"   value ="Female" required>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="form-group col-md-2">
			<button class="btn btn-success">Register</button><br>
		</div>
		<div class="form-group col-md-2">
			<a href="registerEmployee.jsp" class="btn btn-danger">Reset</a>
		</div>

		<div class="col">	
			<a href="login.jsp" class="btn btn-primary">Back to Login</a>
		
		</div>
	</div>
	
	<br/>


</form>

</main>

</body>
</html>