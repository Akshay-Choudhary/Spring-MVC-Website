<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<script type="text/javascript">
function showListing()
{
	if (document.getElementById("myListing").style.display == "none") {
        document.getElementById("myListing").style.display = "block";
	
	}


}
function notSold(){
	if (document.getElementById("notSold").style.display == "none") {
        document.getElementById("notSold").style.display = "block";
	
	}
	
}

/* function theFunction() {
	if (document.getElementById("listingDetails").style.display == "none") {
        document.getElementById("listingDetails").style.display = "block";
	return true;
	}
} */
function showBuyerListing()
{
	if (document.getElementById("successListing").style.display == "none") {
        document.getElementById("successListing").style.display = "block";
	
	}


}
function pendingApproval(){
	if (document.getElementById("pendingListing").style.display == "none") {
        document.getElementById("pendingListing").style.display = "block";
	
	}
	
}
function buyerRequest(){
	if (document.getElementById("buyRequests").style.display == "none") {
        document.getElementById("buyRequests").style.display = "block";
	
	}
	
}

</script>
</head>
<body>
<c:choose>
<c:when test="${not empty seller}">
	<h2><button onclick="notSold()">Listings Not Sold</button> |  <button onclick="showListing()">Total Sold</button> |  <button onclick="buyerRequest()">Buy Request</button></h2>
</c:when>
<%-- <c:otherwise>
	<h2><button>Edit Profile</button>
</c:otherwise> --%>
</c:choose>
<c:choose>
<c:when test="${not empty buyer}">
	<h2><button onclick="pendingApproval()">Pending Approvals </button> |  <button onclick="showBuyerListing()">Purchased Listings</button></h2>
</c:when>
<%-- <c:otherwise>
	<h2><button>Edit Profile</button>
</c:otherwise> --%>
</c:choose>
<div id="myListing" style="display: none;">
		
						<div class="sellerContainer">
						<c:forEach items="${sessionScope.mySoldListings}" var="myListingList">
							<h2><a href="mySellingList.htm?currentSeller=${myListingList.listingId}"> ${myListingList.address}</a></h2>
							
						</c:forEach>
						</div>
						
</div>
<div id="buyRequests" style="display: none;">
		
						<div class="sellerContainer">
						<c:choose>
						<c:when test="${not empty buyerRequests}">
						<c:forEach items="${sessionScope.buyerRequests}" var="buyRequests">
							<h2>Request For <a href="myApproval.htm?currentSeller=${buyRequests.listingId}"> ${buyRequests.address}</a></h2> 
							
						</c:forEach>
						</c:when>
						<c:otherwise>
							<h1>No Requests From Any Buyer </h1>
						</c:otherwise>
						</c:choose>
						</div>
						
</div>
<%-- <div id="notSold" style="display: none;">
			<div class="sellerContainer">
						<c:forEach items="${sessionScope.notSold}" var="unsold">
							<h2><a href="mySellingList.htm?currentSeller=${unsold.listingId}"> ${unsold.address}</a></h2>
							
						</c:forEach>
						</div>
</div>
<div id="approveListing" style="display: none;">
		
						<div class="sellerContainer">
						<c:forEach items="${sessionScope.buyerPendingListings}" var="buyerPendingList">
						<c:choose>
						<c:when test="${buyerPendingList.sold}">
							<h2>Completed Requset For  ${buyerPendingList.address} Property</h2>
						</c:when>
						<c:otherwise>
							<h2>Request For<a href="mySellingList.htm?currentSeller=${buyerPendingList.listingId}"> ${buyerPendingList.address}</a> still awaiting seller Approval</h2>
						</c:otherwise>
							</c:choose>
						</c:forEach>
						</div>
						
</div>	 --%>




<div id="pendingListing" style="display: none;">	<!-- Buyer Profile View -->
		
						<div class="sellerContainer">
						<c:forEach items="${sessionScope.buyerPendingListings}" var="buyerPendingList">
						<c:choose>
						<c:when test="${buyerPendingList.sold}">
							<h2>Seller Accepted Request For  ${buyerPendingList.address} Property</h2>
						</c:when>
						<c:otherwise>
							<h2>Request For<a href="mySellingList.htm?currentSeller=${buyerPendingList.listingId}"> ${buyerPendingList.address}</a> still awaiting seller Approval</h2>
						</c:otherwise>
							</c:choose>
						</c:forEach>
						</div>
						
						
</div>
<div id="successListing" style="display: none;">
			<div class="sellerContainer">
						<c:forEach items="${sessionScope.sellerApprovedListing}" var="ApprovedListing">
							<h2>Congratulations!!!! Seller Has Approved Listing For<a href="mySellingList.htm?currentSeller=${ApprovedListing.listingId}"> ${ApprovedListing.address}</a></h2>
							
						</c:forEach>
						</div>
</div> 

<!-- Buyer Profile View End -->


<button><a href="backIndex.htm">Back</a></button>

</body>
</html>