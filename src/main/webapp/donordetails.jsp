<!DOCTYPE>
<%@page import="java.util.List"%>
<%@page import="in.kirthika.service.DonorDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.kirthika.service.DonorManager"%>
<html>
<head>
<title>MyApp</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Blood Group</h3>
		<table class="table table-bordered">
		<thead>
		<tr>
				<th>S.No</th>
				<th>Donor Name</th>
				<th>Mobile Number</th>
				<th>Blood Group</th>
				<th>Age</th>
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
</main>
</body>
</html>
