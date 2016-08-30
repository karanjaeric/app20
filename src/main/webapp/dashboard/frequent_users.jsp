<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<table class="table table-responsive table-striped">
		<tr><th>USERNAME</th><th>PROFILE</th></tr>
		<c:forEach items="${users}" var="user" >
		<tr>
			<td>${ user.username }</td>
			<td>${ user.profile }</td>
		</tr>
		</c:forEach>
	</table>
