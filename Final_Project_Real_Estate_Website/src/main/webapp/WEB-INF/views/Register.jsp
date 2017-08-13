<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<style>
	.reguser{
		margin-top:50px;
		margin-left:500px;
		
		width:50%;
	}
	.details{
	
	margin-top:30px;
		margin-left:500px;
		
		width:50%;
	}


</style>
</head>
<body>
<c:choose>
<c:when test="${not empty requestScope.success }">
	<h1>You Have Signed Up Successfully</h1>
	<a href="index.htm">Back To HomePage</a>
</c:when>
<c:otherwise>
<form:form action="register.htm" method="post">
<div class="details">
	<h2>Welcome Guest</h2><br>
	<h3>Please Register Yourself Below</h3>
</div>
<div class="reguser">
<div class="form-group">
    <label for="exampleInputEmail1">First Name</label>
    <input type="text" class="form-control" name="firstName" id="exampleInputEmail1" placeholder="Firstname">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Last Name</label>
    <input type="text" class="form-control" name="lastName" id="exampleInputPassword1" placeholder="Lastname">
  </div>
   <div class="form-group">
    <label for="exampleInputPassword1">Country</label>
    <input type="text" class="form-control" name="country" id="exampleInputPassword1" placeholder="Country">
  </div>
   <div class="form-group">
    <label for="exampleInputPassword1">City</label>
    <input type="text" class="form-control" name="city" id="exampleInputPassword1" placeholder="City">
  </div>
  <div class="form-group">
  <label for="exampleInputPassword1">I am:</label>
  <select class="form-control" name="personType">
  					<option selected="Select" disabled="disabled">Select one..</option>
					<option value="agent" >A agent</option>
					<option value="seller">A seller</option>
					<option value="buyer">A Buyer</option>
	</select>
</div>
  <div class="form-group">
    <label for="exampleInputPassword1">Gender</label>
  <div class="radio">
  <label><input type="radio" name="gender" value="male">Male</label>
</div>
<div class="radio">
  <label><input type="radio" name="gender" value="female">Female</label>
</div>
</div>
<div class="form-group">
  <label for="comment">Address:</label>
  <textarea class="form-control" rows="5" id="comment" name="contactInfo"></textarea>
</div>
<div class="form-group">
    <label for="exampleInputEmail1">Email</label>
    <input type="text" class="form-control" name="email" id="exampleInputEmail1" name="email" placeholder="abc@xyz.com">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">UserName</label>
    <input type="text" class="form-control" name="userName" id="exampleInputEmail1" placeholder="Username">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Password</label>
    <input type="text" class="form-control" name="password" id="exampleInputEmail1" placeholder="Password">
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
 </div>
 </form:form>
 </c:otherwise>
 </c:choose>
</body>
</html>