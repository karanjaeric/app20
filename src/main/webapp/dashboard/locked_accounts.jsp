<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-12">

	<table class="table table-responsive table-striped" id="lockedAcc">
		<thead>
		<tr><th>USERNAME</th><th>PROFILE</th><th>STATUS</th><th>ACTIONS</th></tr>
		</thead>
		<tbody>
		<c:forEach var="user" items="${users}">
		<tr><td>${ user.username }</td><td>${ user.userProfile }</td><td><c:if test="${ user.status }">ACTIVE</c:if><c:if test="${ user.status == 'FALSE'}">INACTIVE</c:if> </td><td><c:if test="${ permissions.user_enable_disable }"><c:if test="${ user.status }"><button class="btn btn-sm btn-danger" onclick="toggle('${ user.id }');"><i class="glyphicon glyphicon-trash"></i>&nbsp;DISABLE</button></c:if><c:if test="${ user.status == 'FALSE' }"><button class="btn btn-sm btn-success" onclick="toggle('${ user.id }');"><i class="glyphicon glyphicon-trash"></i>&nbsp;ENABLE</button></c:if></c:if></td></tr>
		</c:forEach>
		</tbody>
	</table>
</div>
	<script type="text/javascript">

        $(document).ready(function() {

            $('#lockedAcc').dataTable(

            );
        } );

		function toggle(id)
		{
			bootbox.confirm("You are about to change a user's status. Are you sure?", function(result){
				if(result)
				{
					start_wait();
					$.ajax({
			            url: $('#base_url').val() + 'admin',
			            type: 'post',
			            data: {ACTION: 'USER_TOGGLE', userID: id},
			            dataType: 'json',
			            success: function(json) {
			                stop_wait();
			               bootbox.alert(json.message);
			            }
			        });
				}
			});
		}
	</script>