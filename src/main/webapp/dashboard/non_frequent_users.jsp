<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<table class="table table-responsive table-striped">
		<tr><th>USERNAME</th><th>PROFILE</th></tr>
		<c:forEach var="user" items="${users}">
		<tr><td>${ user.username }</td><td>${ user.userProfile }</td></tr>
		</c:forEach>
	</table>