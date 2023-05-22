<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>  
<html lang="en">  
<head>  
  <title>Bootstrap Example</title>  
  <meta charset="utf-8">  
  <meta name="viewport" content="width=device-width, initial-scale=1">  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
    
</head>  
<body>  
  
<div class="container">  
  
  <!-- Trigger the modal with a button -->  
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">BOOK</button>  
  
  <!-- Modal -->  
  <div class="modal fade" id="myModal" role="dialog">  
    <div class="modal-dialog">  
      
      <!-- Modal content-->  
      <div class="modal-content">  
        <div class="modal-header">  
          <button type="button" class="close" data-dismiss="modal">×</button>  
          <h4 class="modal-title">Modal Header</h4>  
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
</body>  
</html>