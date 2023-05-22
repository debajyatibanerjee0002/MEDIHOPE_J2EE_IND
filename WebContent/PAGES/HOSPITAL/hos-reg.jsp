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
	margin-top: -100px !important ;
	margin-left: -100px !important ;
	margin-right: 80px !important ;
}
</style>
<title>Register</title>
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
			<form class="form-container" action="/Blood_Finder/HospitalRegister" method="post">
			  <div class="mb-3">
			    <label for="exampleInputEmail1" class="form-label" style="font-size:20px; font-style:italic; color:#b0eabd">REGISTER YOUR HOSPITAL</label>
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputPassword1" class="form-label">ENTER HOSPITAL NAME</label>
			    <input type="text" class="form-control" id="exampleInputPassword1" name="hName" placeholder="HOSPITAL" required>
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputPassword1" class="form-label">ENTER PHONE NO</label>
			    <input type="text" class="form-control" id="exampleInputPassword1" name="phno" placeholder="1234567890" pattern="[789][0-9]{9}" required>
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputPassword1" class="form-label">ENTER PLACE</label>
			    <input type="text" class="form-control" id="exampleInputPassword1" name="place" placeholder="KOLKATA" required>
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputPassword1" class="form-label">ENTER BEDS</label>
			    <input type="number" class="form-control" id="exampleInputPassword1" name="beds" placeholder="00" required>
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputPassword1" class="form-label">ENTER ZIP CODE</label>
			    <input type="text" class="form-control" id="exampleInputPassword1" name="zip" placeholder="700001" pattern="[789][0-9]{5}" required>
			  </div>
			  <input type="submit" value="REGISTER" class="btn btn-danger">
			</form>
		</div>
	</div>
</div>
</div>
</body>
</html>