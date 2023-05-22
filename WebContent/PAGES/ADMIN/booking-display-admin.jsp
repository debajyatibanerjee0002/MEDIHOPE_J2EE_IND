<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" import="java.util.ArrayList" import="com.cart.*" import="com.connection.*"%>
<%
	String admin="admin";
%>

 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../../STYLE/css_boot/bootstrap.min.css" rel="stylesheet">
<!--  <script type="text/javascript" href="${pageContext.request.contextPath}/js_boot/bootstrap.bundle.min.js"></script> -->

<script type="text/javascript" href="../STYLE/js_boot/bootstrap.bundle.min.js"></script>

<style>
*
{
	color: #fff;
	font-weight: bold;
}
body
{
	background: linear-gradient(rgba(0, 0, 0, 0.527),rgba(0, 0, 0, 0.7)),url(../IMAGES/background.png);
	background-size: cover;
	background-blend-mode: darken;
	background-repeat: no-repeat;
	height: 100vh;
}
.logo
{
	margin-top: 100px;
    margin-left: 100px !important;
    display: flex;
}
@keyframes cf3FadeInOut
{
	0%{
		opacity:1;
	}
	45%{
		opactiy:1;
	}
	55%{
		opacity:0;
	}
	100%{
		opacity:0;
	}
}
@keyframes cf3FadeOutIn
{
	0%{
		opacity:0;
	}
	45%{
		opactiy:0;
	}
	55%{
		opacity:1;
	}
	100%{
		opacity:1;
	}
}


#fade_out {
  position:relative;
  height:75%;
  width:auto;
}

#fade_out img.top {
  position:absolute;
  -webkit-transition: opacity 2s linear;
  -moz-transition: opacity 2s linear;
  transition: opacity 2s linear;
  
	animation-name: cf3FadeInOut;
	animation-timing-function: ease-in-out;
	animation-iteration-count: infinite;
	animation-duration: 5s;
	animation-direction: alternate;
}
#fade_out img.buttom {
  position:absolute;
  -webkit-transition: opacity 2s linear;
  -moz-transition: opacity 2s linear;
  transition: opacity 2s linear;
  
	animation-name: cf3FadeOutIn;
	animation-timing-function: ease-in-out;
	animation-iteration-count: infinite;
	animation-duration: 5s;
	animation-direction: alternate;
}

.row
{
	display: flex !important;
	
}
.form
{
	margin-left: 600px !important ;
	margin-top: 70px !important ;
}

.form-container
{
	padding: 20px;
	-webkit-box-shadow: -12px 11px 29px 8px rgba(0,0,0,0.67);
	-moz-box-shadow: -12px 11px 29px 8px rgba(0,0,0,0.67);
	box-shadow: -12px 11px 29px 8px rgba(0,0,0,0.67);
}


.form-container
{
	margin-left: -100px !important ;
	margin-right: 80px !important ;
}
</style>
<title>Result</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
      <a class="navbar-brand" href="#">MEDIHOPE</a>
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        
      </ul>
      <h5 style="color: black; margin-right: 10px">ADMIN</h5>
      <a href="../logout.jsp" class="btn btn-outline-danger margin-left margin-right">LOG OUT</a>
    </div>
  </div>
</nav>

<div class="logo" id="fade_out">
	<img class="top" src="../../IMAGES/logo2.png" alt="">
	<img class="buttom" src="../../IMAGES/logo1.png" alt="">


<div class="container-fluid form">
	<div >
		<div class="col-md-10 col-sm-4 col-xs-12" >
			<form class="form-container" >
				<div class="mb-3">
			    	<label for="exampleInputEmail1" class="form-label" style="font-size:20px; font-style:italic">LIST OF BOOKINGS</label>
			  	</div>
			  	 <div style="overflow: scroll; height: 35vh;">
					<table class="table table-dark table-hover" >
						<thead>
						    <tr>
						      <th scope="col">NAME</th>
						      <th scope="col">TYPE</th>
						      <th scope="col">PH NO</th>
						      <th scope="col">ZIP</th>
						      <th scope="col">DELETE</th>
						    </tr>
						  </thead>
						  <tbody>
							  <%
							  Connection conn = SingletonConnection.getSingletonConnection("medi_hope");
							  PreparedStatement psmt;
							  String query = "SELECT * FROM medihope_cart";
							  psmt = conn.prepareStatement(query);						
							  ResultSet rs = psmt.executeQuery();
							  
							  
							  while(rs.next())
							  {
								  String email = rs.getString("EMAIL");
								  String ph_no = rs.getString("PH_NO");
								  int zip = rs.getInt("ZIP");
								  String name = rs.getString("NAME");
							  %>
							    <tr>
							      <td><%=email %></td>
							      <td><%=name %></td>
							      <td><%=ph_no %></td>
							      <td><%=zip %></td>
							      <td><a href="/Blood_Finder/CartDeleteServlet/<%=admin %>/<%=name %>" class="btn btn-success btn-cus">DELETE</a></td>
							    </tr>
							   <%
							  }
							   %>						  
						  </tbody>	
					</table>
				</div>
			</form>
		</div>
	</div>
</div>
</div>
</body>
</html>