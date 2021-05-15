<!DOCTYPE>
<html lang="en" xml:lang="en">
<%@page import="java.util.List"%>
<%@page import="in.kirthika.service.DonorDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.kirthika.service.DonorManager"%>
<head>
<title>MyApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Donor Details</h3>
		<table class="table table-bordered">
		<caption>Donor Details</caption>
		<thead>
		<tr>
				<th scope="col">S.No</th>
				<th scope="col">Donor Name</th>
				<th scope="col">Mobile Number</th>
				<th scope="col">Blood Group</th>
				<th scope="col">Age</th>
		</tr>
				
		</thead>
	    <tbody>
	    <%
	      List<DonorDetail> taskList=DonorManager.displayDonor();
	      int i=0;
	      for(DonorDetail detail:taskList)
	      {
	      
	    	  i++;
	      
	    %>
			    <tr>
			    <td><%=i %></td>
			    <td><%=detail.getName() %></td>
			    <td><%=detail.getMobileNumber() %></td>
			    <td><%=detail.getBloodGroup()%></td>
			    <td><%=detail.getAge() %></td>

			    </tr>
	     <%}%>
	    
	   </tbody>
	   
		
		</table>

		<a href="adddonor.jsp">Add Donor</a>

</main>
</body>
</html>
