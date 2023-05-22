<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.*"%>
<%@page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">


<style>
	
*{
	text-align: center;
	align: center;
}

body
{
	color: #fff;
	background: linear-gradient(rgba(0, 0, 0, 0.527),rgba(0, 0, 0, 0.7)),url(./IMAGES/blood_drop.jpg);
	background-size: cover;
	background-blend-mode: darken;
	background-repeat: no-repeat;
	height: 100vh;
}


th{
	width: 33%;
	background-color: #B799FF;
	text-align: center !important;
    padding: 5px !important;
}

h1{
	font-weight: 700;
	color:  #B799FF;
	margin-top: 1.5rem;
	padding: 2px;
	box-shadow: 0px 5px 5px;
}
.blood-info{
	padding: 10px;
	text-align: left !important;
}
button{
	background-color: #B799FF;
}

tr:nth-child(even) {
color: black;
background-color: #f2f2f2;}

</style>

</head>
<body>

	

	<% ArrayList<String> obj1= (ArrayList<String>)request.getAttribute("bank_data");%>
	
	<div>
		<h1><%=obj1.get(0)%></h1>
		<div class="blood-info">
				<div>Phone Number: <%=obj1.get(1)%></div>
				<div>Email Id: <%=obj1.get(2)%></div>
				<div>Place: <%=obj1.get(3)%></div>
				<div>Pincode: <%=obj1.get(4)%></div>
		</div>
	</div>
	

<!--  	<div class="col-md-10 col-sm-4 col-xs-12"> -->
	<table border='1' width='100%' align='center'>
	
				<thead>
				<tr>
				    <th>Blood Group</th>
				    <th>Quantity</th>
				    <th>BOOK</th>
				</tr>
				</thead>
				
				<tbody>
				<%
				String[] a={"A+","B+","O+","AB+","A-","B-","O-","AB-"};
				ArrayList<String> obj2= (ArrayList<String>)request.getAttribute("blood_data");
				for(int i=0;i<obj2.size();i++){%>
				<tr>
				<td><%=a[i] %></td>
				<td><%=obj2.get(i) %></td>

				<td>
					
					
					<div class="container" style="display: inline; color:black">  
  
  						<!-- Trigger the modal with a button -->  
  						<button type="button" class="btn btn-sm" data-toggle="modal" data-target="#myModal">BOOK</button>  
  
 						<!-- Modal -->  
 						<div class="modal fade" id="myModal" role="dialog">  
    						<div class="modal-dialog">  
      
      							<!-- Modal content-->  
      							<div class="modal-content">  
        							<div class="modal-header">    
          								<h4 class="modal-title"><label>BOOKING DETAILS</label></h4>  
        							</div>  
        						
        						<div class="modal-body">  
          							<form>
  										<div class="mb-3">
  											
    										<label for="exampleInputEmail1" class="form-label">NAME</label>
    										<input type="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  										</div>
  										<div class="mb-3">
    										<label for="exampleInputPassword1" class="form-label">QUANTITY</label>
    										<input type="number" step = "1" class="form-control" id="exampleInputPassword1" >
  										</div>
									</form>
        						</div>  
        						<div class="modal-footer">  
          							<button type="button" class="btn btn-primary" data-dismiss="modal">Submit</button> 
          							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button> 
        						</div>  
        
     			 				</div>  
        
    						</div>  
  						</div>  
    
					</div>  
					
					
					
					
					
				</td>
				</tr>
				<%} %>
				
				</tbody>
	</table>

	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>