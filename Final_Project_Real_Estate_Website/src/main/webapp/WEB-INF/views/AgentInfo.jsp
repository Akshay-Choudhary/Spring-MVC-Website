<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.container {
	margin-left: 300px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<b><h2 class="panel-title">List Of Agents</h2></b>
			</div>
			<div class="panel-body">
				<div class="col-sm-4">
					<h2>
						Agent Info:
						</h3>
						<br>
						<h3>${agentFound.firstName}${agentFound.lastName}</h3>
						<h4>${agentFound.contactInfo}</h3>
							<h4>${agentFound.email}</h3>
								<h4>
									857-317-1485
									</h3>
				</div>
				<div class="col-sm-8">
				
					<form:form action="contactAgent.htm" enctype="multipart/form-data"
						method="post">
						<div class="sellerContainer">
							<h2>Enter the Rental Details</h2>

							<div class="form-group">
								<label for="sel1">Listing Type</label> <select
									class="form-control" name="listingType">
									<option value="Sell">Sell</option>
									<option value="Rent">Rent</option>
								</select>
							</div>

							<div class="form-group">
								<label for="sel1">No of Bedrooms</label> <select
									class="form-control" name="noOfRooms">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
								</select>
							</div>
							<div class="form-group">
								<label for="sel1">No of Baths</label> <select
									class="form-control" name="noOfBaths">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
								</select>
							</div>



							<div class="form-group">
								<label>Area Size </label> <input type="text"
									class="form-control" name="areaSize" />
							</div>

							<textarea class="form-control" rows="5" name="address"></textarea>

							<div class="form-group">
								<label>Upload Photo</label> <input type="file"
									class="form-control" name="photo" />
							</div>
							<button type="submit" class="btn btn-default">Submit</button>
						</div>

					</form:form>
				
				</div>


			</div>
		</div>
	</div>



</body>
</html>