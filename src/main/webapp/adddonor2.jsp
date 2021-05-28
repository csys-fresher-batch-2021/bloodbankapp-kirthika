<!DOCTYPE>
<%@page import="in.kirthika.dao.DonorManagerDao"%>
<%@page import="in.kirthika.model.DonorDetail"%>
<html lang="en" xml:lang="en">
<%@page import="java.util.List"%>
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
				<th scope="col">Place</th>
				<th scope="col">Delete</th>
		</tr>
				
		</thead>
	
	    <tbody id="donor-tbl">

	   </tbody>
	  </table>
	  <script>
	  function getDonorDetail()
	  { console.log("donorDetail");
	  let url="AddDonorServlet1";
	  fetch(url).then(res=>res.json()).then(res=>{
	  	   let details=res;
	       console.log(details);
	       let content="";
	       
	       for(let detail of details){
	    	   content +=
	    		   <tr><td>${detail.bloodGroup}</td><td>${detail.name}</td><td>${detail.mobileNumber}
	    	   <td></td>${detail.age}<td></td>${detail.place}</td></tr>;
	       }
	       console.log(content);
	       document.querySelector("#donor-tbl").innerHTML=content;

	  });
	  }
	  getDonorDetail();
	  </script>
		
		<a href="adddonor.jsp">Add Donor</a>
		<br/>
		<br/>
		<a href="adminmanager.jsp">Back to homepage</a>

</main>
</body>
</html>