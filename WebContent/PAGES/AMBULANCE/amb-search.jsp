<%
	String email = request.getParameter("val");
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../../STYLE/login-page.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
<style>
.form-container
{
	margin-left: -100px !important ;
	margin-right: 80px !important ;
}
</style>
<title>Search</title>
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
      <a href="../home.jsp"><button type="button" class="btn btn-outline-success margin-left margin-right">BACK</button></a>
    </div>
  </div>
</nav>

<div class="logo" id="fade_out">
	<img class="top" src="../../IMAGES/logo2.png" alt="">
	<img class="buttom" src="../../IMAGES/logo1.png" alt="">


<div class="container-fluid form">
	<div class="">
		<div class="col-md-10 col-sm-4 col-xs-12">
			<form class="form-container" action="/Blood_Finder/AmbulanceSearch" method="post">
			  <input type="hidden" class="btn btn-primary" name="email" value="<%=email%>">
			  <div class="mb-3">
			    <label for="exampleInputEmail1" class="form-label" style="font-size:20px; font-style:italic">BOOK YOUR AMBULANCE</label>
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputPassword1" class="form-label">ENTER YOUR PLACE / ZIP CODE</label>
			    <input type="text" class="form-control" id="exampleInputPassword1" name="searchVal" placeholder="KOLKATA / 700001" required>
			  </div>
			  <input type="submit" class="btn btn-primary" value="SEARCH">
			</form>
		</div>
	</div>
</div>
</div>
</body>
</html>