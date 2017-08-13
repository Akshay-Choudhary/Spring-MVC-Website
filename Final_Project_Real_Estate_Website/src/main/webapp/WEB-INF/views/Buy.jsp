<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
						Seller Info:
						</h3>
						<br>
						<h3>${sellerDetail.firstName}${sellerDetail.lastName}</h3>
						<h4>${sellerDetail.contactInfo}</h3>
							<h4>${sellerDetail.email}</h3>
								<h4>
									857-317-1485
									</h3>
				</div>
				
				
				<div class="col-sm-8">
				<form action="contactSeller.htm" method="post">
				<div class="image">
					<img src="http:localhost:8080${buyListing.imageName}"/>
				</div>
				
				<div class="listingInfo">
					<h4>Address : ${buyListing.address}</h4><br>
					<h4>Listing Type : ${buyListing.listingType}</h4><br>
					<h4>PropertyType : ${buyListing.propertyType}</h4><br>
					<h4>Area : ${buyListing.areaSize}</h4><br>
					<h4>No Of Baths : ${buyListing.noOfBaths}</h4><br>
					<h4>No Of Bedrooms : ${buyListing.noOfRooms}</h4><br>
					<h2>Price : ${buyListing.price}</h4><br><br>
					<button>Contact</a></button>
					<input type="hidden" name="ListingName" value="${buyListing.listingId}"/>
				</div>
				</form>
				</div>
				<button><a href="ownHome.htm">Back</a></button>


			</div>
		</div>
	</div>
</body>
</html>