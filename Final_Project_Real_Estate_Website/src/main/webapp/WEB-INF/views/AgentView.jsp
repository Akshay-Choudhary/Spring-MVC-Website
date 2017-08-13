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
				<b><h2 class="panel-title">List Of Affiliated Sellers</h2></b>
			</div>
			<div class="panel-body">
			<table>
			<c:forEach items="${sessionScope.sellerList}" var="seller">
			
			
			<tr>
			<td width="30%"><h3>${seller.firstName} ${seller.lastName}</h3></td>
			<%-- <input type="hidden" name="agentWindow" value="${agentList.userName}"/> --%>
				<td><a href="sellerAgentRequest.htm?sellerWindow=${seller.personID}"><button>View Request</button></a></td><br><br>
				<td><button id="processed">Awaiting Request</button>
			</tr>
			
				</c:forEach>
			</table>
			</div>
		</div>
</div>
</body>
</html>