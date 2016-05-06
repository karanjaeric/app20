<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
	<h3 class="text-center main-title">
		<i class="glyphicon glyphicon-film"></i>&nbsp;&nbsp;MEDIA &amp; FILES
	</h3>
	<table class="table table-responsive table-striped">
		<tr><th>FILE NAME</th><th>DESCRIPTION</th><th>ACCESS</th><th>DATE CREATED</th><th>ACTIONS</th></tr>
		<c:forEach var="file" items="${medias}">
		
		<tr><td>${ file.name }</td><td>${ file.description }</td><td>${ file.access }</td><td>${ file.created }</td>
		
		<td>
		<a class="btn btn-sm btn-info" href="${pageContext.request.contextPath}/downloads/${ file.id }">
		<i class="glyphicon glyphicon-download"></i>&nbsp; DOWNLOAD</a>&nbsp;&nbsp;
		
		<c:if test="${ permissions.media_remove }">
		<button class="btn btn-sm btn-danger" onclick="remove_media('${ file.id }', '${ file.name }');">
		<i class="glyphicon glyphicon-trash"></i>&nbsp; REMOVE</button></c:if>
		
		</td>
		</tr>
		</c:forEach>
	</table>
</div>
<script type="text/javascript">
	function remove_media(id, name)
	{
		bootbox.confirm("<p class=\"text-center\">You are about to remove media <strong>\"" + name + "\"</strong>. Are you sure?</p>", function(result){
			if(result)
			{
				start_wait();
				$.ajax({
			        url: $('#base_url').val() + 'admin',
			        type: 'post',
			        data: {ACTION:'REMOVE_MEDIA', id: id},
			        dataType: 'json',
			        success: function(json) {
						bootbox.alert("<p class=\"text-center\">" + json.message + "</p>");
						stop_wait();
						load_dashboard("MEDIA");
			        }
				});
			}
		});
	}
	
</script>