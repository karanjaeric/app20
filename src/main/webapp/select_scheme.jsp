<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<jsp:include page="includes/partial/admin_header.jsp" />
<div class="container text-center">
<p>&nbsp;</p>
<p>&nbsp;</p>
<h2 class="text-center">PLEASE SELECT A SCHEME</h2>
<p>&nbsp;</p>
<p>&nbsp;</p>
	<div class="row text-center">
	<c:forEach var="scheme" items="${ schemes }" varStatus="counter">
		<div class="col-md-4 scheme-block">
			<i class="glyphicon glyphicon-briefcase icon-lg"></i>
			<c:set var="schemeName" value="${fn:toUpperCase(scheme.name)}" />
			<h3>${ schemeName }</h3>
			<button class="btn btn-success btn-lg" onclick="select_scheme('${scheme.id}');"><i class="glyphicon glyphicon-ok-circle"></i>&nbsp;SELECT SCHEME</button>
		</div>
		<c:if test="${counter.count % 3 == 0}">
			</div>
			<p>&nbsp;</p>
			<div class="row">
		</c:if>
	</c:forEach>
			</div>
</div>
<input type="hidden" id="view" value="${ path }" />
<script type="text/javascript">
	function select_scheme(id)
	
	{
		start_wait();
		$.ajax({
	        url: $('#base_url').val() + $('#view').val(),
	        type: 'post',
	        data: { ACTION: 'SWITCH_SCHEME', schemeID: id },
	        dataType: 'json',
	        success: function (json) {
	            if(json.success)
	            	location.reload();
	        }
	
	    });
	
	}
</script>

<jsp:include page="includes/partial/admin_footer.jsp" />