<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
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
<title>Home</title>
<title>Free Real-Deal Website Template | Home :: w3layouts</title>
<link href="resources/css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css'>
<link href="resources/css/slider.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="resources/css/swipebox.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="resources/js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.nivo.slider.js"></script>
<script type="text/javascript">
	$(window).load(function() {
		$('#slider').nivoSlider();
	});
</script>

<script>
	var xmlHttp;

	function createXMLHttpRequest() {
		if (window.ActiveXObject) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		}
	}

	function sellThroughAgent() {

		createXMLHttpRequest();
		xmlHttp.onreadystatechange = handleStateChange;
		xmlHttp.open("GET", "sellThruAgent.htm", true);
		xmlHttp.send();
	}

	function handleStateChange() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				document.getElementById('container').innerHTML = xmlHttp.responseText;
			}
		}
	}
</script>



</head>
<body>
	<div class="header">
		<!-- Header -->
		<div class="header-top">
			<div class="wrap">
				<div class="top-header-left">
					<p>+800-020-12345</p>
				</div>
				<div class="right-left">
					<ul>
						<c:choose>
							<c:when test="${not empty user}">
								<li>Welcome ${user.firstName}</li>
								<li class="sign"><a href="profile.htm">Profile</a>
								<li class="login"><a href="logout.htm">Logout</a></li>
							</c:when>
							<c:when test="${empty user}">
								<li class="adminLogin"><a href="adminLogin.htm">Admin
										Login</a></li>

								<li class="login"><a href="login.htm">Login</a></li>
								<li class="sign"><a href="register.htm">Sign up</a></li>
							</c:when>
						</c:choose>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="header-bottom">
			<div class="wrap">
				<div class="logo">
					<a href="index.html"><img src="resources/images/logo.png"
						alt="" /></a>
				</div>
				<div class="navcontainer" style="height: 150px;">
					<div class="mainmenu pull-right">
						<ul class="nav navbar-nav">
							<li class="active"><a href="index.html">Home</a></li>
							<c:choose>
							<c:when test="${empty user}">
							<li class="dropdown"><a href="#">Buy<i
									class="fa fa-angle-down"></i></a> <ul class="sub-menu">
                                        <li><a href="ownHome.htm">Own Your Home</a></li>
										<li><a href="rentHome.htm">Rent your Home</a></li> 
										
                                    </ul></li>
                            <li class="dropdown"><a href="#">Sell<i
									class="fa fa-angle-down"></i></a>
								<ul class="sub-menu">
									<li><a href="sellThruAgent.htm">Through
											Agent</a></li>
									<li><a href="sell.htm">On Own</a></li>

								</ul></li>
							 </c:when>
							</c:choose>
							
							<c:choose>
							<c:when test="${not empty buyer}">
							<li class="dropdown"><a href="#">Buy<i
									class="fa fa-angle-down"></i></a> <ul class="sub-menu">
                                        <li><a href="ownHome.htm">Own Your Home</a></li>
										<li><a href="rentHome.htm">Rent your Home</a></li> 
										
                                    </ul></li>
                            </c:when>
                            <c:when test="${not empty seller }">
                            <li class="dropdown"><a href="#">Sell<i
									class="fa fa-angle-down"></i></a>
								<ul class="sub-menu">
									<li><a href="sellThruAgent.htm">Through
											Agent</a></li>
									<li><a href="sell.htm">On Own</a></li>

								</ul></li>
								</c:when>
							</c:choose>
							<li class="dropdown"><a href="#">Find an Agent<i
									class="fa fa-angle-down"></i></a> <!--  <ul class="sub-menu">
                                        <li><a href="bats.html">Racquets</a></li>
										<li><a href="balls.html">Shoes</a></li>
										
                                    </ul> --></li>
						</ul>
					</div>
				</div>
				<!-- <div class="top-nav">
					<ul>
						<li class="active"><a href="index.html">Home</a></li>
						<li><a href="buy.htm">Buy</a></li>
						<li><a href="sell.htm">Sell</a></li>
						<li><a href="findagent.htm">Find Agent</a></li>
					</ul>
		    </div> -->
				<div class="clear"></div>
			</div>
		</div>
	</div>
	<!-- End Of Header -->

	<div class="slider">
		<!-- Slider -->
		<div class="slider-wrapper theme-default">
			<div id="slider" class="nivoSlider">
				<img src="resources/images/banner1.jpg"
					data-thumb="resources/images/1.jpg" alt="" /> <img
					src="resources/images/banner2.jpg"
					data-thumb="resources/images/2.jpg" alt="" /> <img
					src="resources/images/banner3.jpg"
					data-thumb="resources/images/3.jpg" alt="" /> <img
					src="resources/images/banner4.jpg"
					data-thumb="resources/images/4.jpg" alt="" /> <img
					src="resources/images/banner5.jpg"
					data-thumb="resources/images/5.jpg" alt="" />
			</div>
		</div>
	</div>
	<!-- End Of Slider -->

	<!------Content ------------>
	<c:choose>
		<c:when test="${not empty agent}">
			<div class="agent-section"> <!-- Agent Section -->
		<div class="col-sm-8">
			<h1><a href="sellerRequest.htm">Requests For Seller</a></h1>
		</div><!-- Agent Section Ends -->
	</div>
		</c:when>
		<c:when test="${empty user }">
			<div class="container">
				<div class="main">
					<div class="wrap">
						<div class="module-title">
							<h2 class="title">Listings For Sell</h2>

						</div>
						<div class="sellListings" style="border:2px solid red; height:400px;">
						<c:forEach items="${listingDetails}" var="list">
							<div class="col-sm-4">
								<div class="grid_img">
									<div class="hover_img">
										<img src="http://localhost8080${list.imageName}" style="height:auto;"/>
									</div>
								    <h3>
										<p class="desc">
											<br>
											<a href="buy.htm?sellerDetails=${list.listingId}">${list.address} - ${list.noOfRooms}bd ${list.noOfBaths}ba </a><br>
										</p>
									</h3>
								</div>
							</div>
							</c:forEach>
						</div>
						<div class="viewMore">
								<h2  align="center"><button><a href="viewMore.htm">View More</a></button></h2>
						</div>
						<div class="module-title">
							<h2 class="title">Listings For Rent</h2>

						</div>
						<div class="sellListings" style="border:2px solid red; height:400px;">
						<c:forEach items="${rentalDetails}" var="rent">
							<div class="col-sm-4">
								<div class="grid_img">
									<div class="hover_img">
										<img src="http:localhost:8080${rent.imageName}" alt="" style="height:auto;"/>
									</div>
								    <h3>
										<p class="desc">
											<br>
											<a href="display.htm">${rent.address} - ${rent.noOfRooms}bd ${rent.noOfBaths}ba </a><br>
										</p>
									</h3>
								</div>
							</div>
							</c:forEach>
							
						</div>
						
					</div>
				</div>
			</div>
	</c:when>
	<c:when test="${not empty buyer }">
			<div class="container">
				<div class="main">
					<div class="wrap">
						<div class="module-title">
							<h2 class="title">Listings For Sell</h2>

						</div>
						<div class="sellListings" style="border:2px solid red; height:400px;">
						<c:forEach items="${listingDetails}" var="list">
							<div class="col-sm-4">
								<div class="grid_img">
									<div class="hover_img">
										<img src="${list.imageName}" style="height:auto;"/>
									</div>
								    <h3>
										<p class="desc">
											<br>
											<a href="buy.htm?sellerDetails=${list.listingId}">${list.address} - ${list.noOfRooms}bd ${list.noOfBaths}ba </a><br>
										</p>
									</h3>
								</div>
							</div>
							</c:forEach>
						</div>
						<div class="viewMore">
								<h2  align="center"><button><a href="viewMore.htm">View More</a></button></h2>
						</div>
						<div class="module-title">
							<h2 class="title">Listings For Rent</h2>

						</div>
						<div class="sellListings" style="border:2px solid red; height:400px;">
						<c:forEach items="${rentalDetails}" var="rent">
							<div class="col-sm-4">
								<div class="grid_img">
									<div class="hover_img">
										<img src="http:localhost:8080${rent.imageName}" alt="" style="height:auto;"/>
									</div>
								    <h3>
										<p class="desc">
											<br>
											<a href="display.htm">${rent.address} - ${rent.noOfRooms}bd ${rent.noOfBaths}ba </a><br>
										</p>
									</h3>
								</div>
							</div>
							</c:forEach>
							
						</div>
						
					</div>
				</div>
			</div>
	
	
	
	</c:when>
	<c:when test="${not empty seller }">
	<div class="container" align="center">
		<div class="panel panel-default">
			<div class="panel-heading">
				<b><h2 class="panel-title">Seller Homepage</h2></b>
			</div>
			<div class="panel-body">

				
					<b>Welcome ${seller.firstName }</b><br><br><br>
						<div class="sellerSection">
							<h2><a href="sellThruAgent.htm">Sell Through Agent</a></h2><br>
							<h2><a href="sell.htm">Sell Directly</a></h2>
				 
				</div>
				</div>
				</div>
		</div>
		
		
		
		
		
		
	</c:when>
	</c:choose>
	<!------End Content ------------>

</body>
</html>
