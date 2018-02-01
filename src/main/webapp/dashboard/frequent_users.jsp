<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <div class="col-md-12">
	<table class="table table-responsive table-striped" id="fu-results">
		<thead>
		<tr><th>USERNAME</th><th>PROFILE</th></tr>
		</thead>
		<tbody>
		<c:forEach items="${users}" var="user" >
			<tr>
				<td>${ user.username }</td>
				<td>${ user.profile }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

<script type="text/javascript">
    $(document).ready(function() {

        $('#fu-results').dataTable(

        );
    } );
</script>