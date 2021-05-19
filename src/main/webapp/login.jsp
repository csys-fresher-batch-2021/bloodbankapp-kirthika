
<html>
<head>
<title>Blood Bank</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Blood Bank</h3>
		<h3>Admin Sign in</h3>
<form action="AdminLoginServlet">
<label for="UserName"></label>
	<input type="text" name="userName" placeholder="Enter User name" required autofocus/>
		
	<br/>
	<br/>
	<label for="Password"></label>
	<input type="password" name="password" placeholder="Enter password" required autofocus/> 
	<br/>
	<br/>
		<div class="row">
		 	<div class="col=1">
		     <button type="submit" class="btn btn-success">Login</button>
				</div>
		<div class="col=4">
		    <button type="reset" class="btn btn-danger">Reset</button>
		</div>
		<div class="col=4">
			<a href="register.jsp" class="btn btn-primary">New User</a>
	    </div>
	</div>
	<br/>
	
</form>
         <%
         
          String message=request.getParameter("message");
			if(message==null)
			{
				out.print("");
			}
			else
			{
				
				out.print("<font color='red'>"+message+"</font>");
			}
         %>
   
</main>

</body>
</html>
		