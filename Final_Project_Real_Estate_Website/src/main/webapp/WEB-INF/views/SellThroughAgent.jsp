<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/SellThroughAgent.css" rel="stylesheet"
	type="text/css" media="all" />
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="searchAgent">
			<div class="form-group">
				<label for="exampleInputEmail1">Search Agent:</label>
				<pre>
					<input type="text" class="form-control" name="searchAgent"
						id="exampleInputEmail1" placeholder="Search By Name">
					<button type="submit" class="btn btn-default">Search</button>
				</pre>
			</div>

		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<b><h2 class="panel-title">List Of Agents</h2></b>
			</div>
			<div class="panel-body">
			
			<c:forEach items="${requestScope.agentList}" var="agentList">
			
			<tr>
			<h3><td>${agentList.firstName} ${agentList.lastName}</td></h3>
			<%-- <input type="hidden" name="agentWindow" value="${agentList.userName}"/> --%>
			</tr>
			<tr>
				<td><a href="approach.htm?agentWindow=${agentList.userName}">Contact</a></td><br><br><hr>
			</tr>
				</c:forEach>
			
			</div>
			<button><a href="index.htm">Back</a></button>
		</div>
	</div>
	
	
</body>
</html>