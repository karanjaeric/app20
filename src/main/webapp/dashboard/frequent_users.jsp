<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<table class="table table-responsive table-striped">
		<tr><th>USERNAME</th><th>PROFILE</th><th>STATUS</th></tr>
		<c:forEach var="user" items="${users}">
		<tr><td>${ user.username }</td><td>${ user.userProfile }</td><td><c:if test="${ user.status }">ACTIVE</c:if><c:if test="${ user.status == 'FALSE'}">INACTIVE</c:if> </td></tr>
		</c:forEach>
	</table>