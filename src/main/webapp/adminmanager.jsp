<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Blood Bank</title>
<%
String loggedInUsername=(String)session.getAttribute("LOGIN_USER");

%>


</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<div class="d-flex justify-content-center">
		<h3>Features</h3>
	</div>
		<br/>
		
		   <%
				if (!loggedInUsername.equals("admin")) {
				%>
	
		    <div class="d-flex justify-content-center">
		    <a href="donorsearchpage.jsp">Search Donor</a>
		    </div>
		  
		    
		     <div class="d-flex justify-content-center">
		    <a href="registrationform.jsp">Seeker registration form</a>
		    </div>
		     <div class="d-flex justify-content-center">
		    <a href="seekerstatus.jsp">Seeker status</a>
		    </div>
		    
		    
		    <%} else {%>
		    <div class="d-flex justify-content-center">
		  <a href="adddonor.jsp">Add donor</a>
		    </div>
		    
		     <div class="d-flex justify-content-center">
		    <a href="donorsearchpage.jsp">Search Donor</a>
		    </div>
		   
		     <div class="d-flex justify-content-center">
		    <a href="deletedonordetail.jsp">Delete donor</a>
	        </div>
	        
	         <div class="d-flex justify-content-center">
		    <a href="displaydonor.jsp">Display donor</a>
	        </div>
	        
	        <div class="d-flex justify-content-center">
		    <a href="seekerrequest.jsp">Seeker Request</a>
	        </div>
	        <%} %>
	        
		    
</main>
</body>
</html>