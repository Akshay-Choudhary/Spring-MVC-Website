<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">List Of Houses For Sale</h2>
			</div>
			<div class="panel-body">
				
					<div class="sellListings" style="border:2px solid red; height:400px;">
						<c:forEach items="${sellDetails}" var="sellList">
							<div class="col-sm-4">
								<div class="grid_img">
									<div class="hover_img">
										<img src="http:localhost:8080${sellList.imageName}" alt="" style="height:auto;"/>
									</div>
								    <h3>
										<p class="desc">
											<br>
											<a href="buy.htm?sellerDetails=${sellList.listingId}">${sellList.address} - ${sellList.noOfRooms}bd ${list.noOfBaths}ba </a><br>
										</p>
									</h3>
								</div>
							</div>
							</c:forEach>
						</div>
				<div class="row">
					<div class="page pull-right">
						<ul class="pagination">
							<li><a href="sportinggoods.html" id="link1">1</a></li>
							<li><a href="#" id="link2" onclick="move()">2</a></li>
							<li><a href="#" >3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
						</ul>
					</div>
					</div>
				
			</div>
			
		</div>
	</div>
</body>
</html>