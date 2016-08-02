<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
	<h3 class="text-center main-title">
		<i class="glyphicon glyphicon-film"></i>&nbsp;&nbsp;PORTAL USERS
	</h3>
	<table class="table table-responsive table-striped">
		<tr><th>USERNAME</th><th>PROFILE</th><th>STATUS</th><th>ACTIONS</th></tr>
		<c:forEach var="user" items="${users}">
		<tr><td>${ user.username }</td><td>${ user.userProfile }</td><td><c:if test="${ user.status }">ACTIVE</c:if><c:if test="${ user.status == 'FALSE'}">INACTIVE</c:if> </td><td><c:if test="${ permissions.user_enable_disable }"><c:if test="${ user.status }"><button class="btn btn-sm btn-danger" onclick="toggle('${ user.id }');"><i class="glyphicon glyphicon-trash"></i>&nbsp;DISABLE</button></c:if><c:if test="${ user.status == 'FALSE' }"><button class="btn btn-sm btn-success" onclick="toggle('${ user.id }');"><i class="glyphicon glyphicon-trash"></i>&nbsp;ENABLE</button></c:if>&nbsp;<button class="btn btn-sm btn-warning" onclick="password_reset('${ user.id }');"><i class="glyphicon glyphicon-trash"></i>&nbsp;RESET PASSWORD</button></c:if></td></tr>
		</c:forEach>
	</table>
	 <ul class="pagination pull-right">
		 <c:if test="${ batch > 1 }">
		 	<li><a href="javascript:void(0);" onclick="load_dashboard(${ page > per_page ? page - per_page : page }, ${ batch - 1 })">&laquo;</a></li>
		 </c:if>
		 <c:forEach begin="${ begin }" end="${ pages > (begin + (per_page - 1)) ? (begin + (per_page - 1)) : pages }" varStatus="loop">
		  <c:choose>
		  	<c:when test="${ page == loop.index }">
		  		<li class="active"><a href="javascript:void(0);">${ loop.index }</a></li>
		  	</c:when>
		  	<c:otherwise>
		  		<li><a href="javascript:void(0);" onclick="load_dashboard(${ loop.index }, ${ batch })">${ loop.index }</a></li>
		  	</c:otherwise>
		  </c:choose>
		</c:forEach>
		<c:if test="${ pages > begin + (per_page - 1)}">
			<li><a href="javascript:void(0);" onclick="load_dashboard(${ pages < page + per_page ? pages : page + per_page }, ${ batch + 1 })">&raquo;</a></li>
		</c:if>
	</ul>
</div>
<script type="text/javascript">
function load_dashboard(page, batch)
{
	start_wait();
	$.ajax({
        url: $('#base_url').val() + 'dashboard',
        type: 'get',
        data: {dashboard: 'USER', page: page, batch: batch, search: $('#search').val()},
        dataType: 'html',
        success: function(html) {
            $('#dashboard').fadeOut('slow', function() {
            	$('#dashboard').html(html);
            	$('#dashboard').fadeIn('slow');
            	stop_wait();
            });
        }
    });
}
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

	function password_reset(id)
	{
		bootbox.confirm("You are about to reset a user's password. Are you sure?", function(result){
			if(result)
			{
				start_wait();
				$.ajax({
		            url: $('#base_url').val() + 'admin',
		            type: 'post',
		            data: {ACTION: 'ADMIN_PWD_RESET', userID: id},
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