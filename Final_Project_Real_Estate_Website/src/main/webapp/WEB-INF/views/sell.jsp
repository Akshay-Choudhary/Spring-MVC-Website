<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
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
.sellerContainer{

		margin-top:50px;
		margin-left:200px;
		
		width:50%;
	

}


</style>

</head>
<body>
	<spring:form action="sell.htm" commandName="listing" enctype="multipart/form-data"  method="post" >
		<div class="sellerContainer">
			<h2>Enter the Rental Details</h2>
			<div class="form-group">
				<label for="sel1">Property Type</label> <spring:select class="form-control" path="propertyType"
					>
					<spring:option value="commercial" >Commercial</spring:option>
					<spring:option value="residential">Residential</spring:option>
				</spring:select>
			</div>
			
			<div class="form-group">
				<label for="sel1">Listing Type</label> <spring:select class="form-control" path="listingType"
					>
					<spring:option value="Sell" >Sell</spring:option>
					<spring:option value="Rent">Rent</spring:option>
				</spring:select>
			</div>
			
			<div class="form-group">
				<label for="sel1">No of Bedrooms</label> <spring:select class="form-control" path="noOfRooms"
					>
					<spring:option value="1" >1</spring:option>
					<spring:option value="2">2</spring:option>
					<spring:option value="3">3</spring:option>
					<spring:option value="4">4</spring:option>
				</spring:select>
			</div>
			<div class="form-group">
				<label for="sel1">No of Baths</label> <spring:select class="form-control" path="noOfBaths">
					<spring:option value="1" >1</spring:option>
					<spring:option value="2">2</spring:option>
					<spring:option value="3">3</spring:option>
					<spring:option value="4">4</spring:option>
				</spring:select>
			</div>
			
			
			
			<div class="form-group">
    <label>Area Size </label>
    <spring:input type="text" class="form-control" path="areaSize" />
  </div>
  
  	<div class="form-group">
    <label>Price </label>
    <spring:input type="text" class="form-control" path="price" />
  </div>
  <div class="form-group">
    <label>Address</label>
  <spring:textarea class="form-control" rows="5" path="address"/>
  </div>
  <div class="form-group">
    <label>Upload Photo</label>
    <spring:input type="file" class="form-control" path="photo"/>
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
		</div>
		
	</spring:form>






</body>
</html>