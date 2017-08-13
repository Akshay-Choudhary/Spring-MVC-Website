<%@page import="com.neu.pojo.Listing"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="panel panel-default">
			<div class="panel-heading">
				<b><h2 class="panel-title">Listings</h2></b>
			</div>
			<div class="panel-body">
				<div class="col-sm-8">
				<div id="listingDetails">
					<form:form>
								<div class="form-group">
								<label>Listing Type </label> <input type="text"
									class="form-control" name="listingType"
									value="${foundSellerDetails.listingType}" disabled="disabled" />
							</div>

							<div class="form-group">
								<label>No Of Rooms </label> <input type="text"
									class="form-control" name="noOfRooms"
									value="${foundSellerDetails.noOfRooms}" disabled="disabled" />
							</div>

							<div class="form-group">
								<label>No Of Baths </label> <input type="text"
									class="form-control" name="noOfBaths"
									value="${foundSellerDetails.noOfBaths}" disabled="disabled" />
							</div>



							<div class="form-group">
								<label>Area Size </label> <input type="text"
									class="form-control" name="areaSize"
									value="${foundSellerDetails.areaSize}" disabled="disabled" />
							</div>

							<div class="form-group">
								<label>Upload Photo</label> <input type="file"
									class="form-control" name="photo" value="${foundSellerDetails.photo}" disabled="disabled"/>
							</div>
							
							<div class="form-group">
								<label>Address</label>
							<textarea class="form-control" rows="5" name="address"
								 disabled="disabled">${foundSellerDetails.address}</textarea>
							</div>
							
						
							<div class="form-group">
								<label>Price</label> <input type="text" class="form-control"
									name="price" value="${foundSellerDetails.price}" disabled="disabled"/>
							</div>
							
							
							
								<div class="form-group">
								<label>Property Type </label> <input type="text"
									class="form-control" name="propertyType"
									value="${foundSellerDetails.propertyType}" disabled="disabled" />
							</div>
							
							
						</form:form>
						<button><a href="backProfile.htm">Back</a></button>
								
							</div>
							</div>
							</div>
							</div>
</body>
</html>