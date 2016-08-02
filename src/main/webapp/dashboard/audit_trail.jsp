<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
	<div class="col-md-4">
		<h3>
			<i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;AUDIT TRAIL
		</h3>
	</div>
	<div class="col-md-8" align="right">
	<br />
		
		<form class="form-inline" id="form-search">
		     <select name="profile" id="profile" class="form-control">
		     	<option>ADMINISTRATOR</option>
		     	<option>MEMBER</option>
		     	<option>TRUSTEE</option>
		     	<option>SPONSOR</option>
		     	<option>AGENT</option>
		     	<option>CUSTODIAN</option>
		     	<option>CRM</option>
		     	<option>CRE</option>
		     	<option>FUND_MANAGER</option>
		     	<option>PENSIONER</option>
		     </select>
			<input type="text" class="form-control" name="search" id="search" placeholder="Username" value="${ search }"/>
			<button class="btn btn-info">Filter Audit Trails</button>
		</form>
	</div>
				
	<table class="table table-responsive table-striped" id="search-results">
		<tr><th>DATETIME</th><th>USERNAME</th><th>PROFILE</th><th>DETAIL</th></tr>
		<c:forEach var="auditTrail" items="${ auditTrails }">
		<tr><td>${auditTrail.datetime }</td><td>${ auditTrail.username }</td><td>${ auditTrail.profile }</td><td>${ auditTrail.description }</td></tr>
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
$(document).ready(function(){
	$('#form-search').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            search: {
                validators: {
                    notEmpty: {
                        message: 'Please enter the search criteria'
                    }
                }
            }
           
        }
	})
	.on('success.form.bv', function(e) {
		load_dashboard(1);
	});
});
function load_dashboard(page, batch)
{
	start_wait();
	$.ajax({
        url: $('#base_url').val() + 'dashboard',
        type: 'get',
        data: {dashboard: 'AUDIT_TRAIL', page: page, search: $('#search').val(), batch: batch},
        dataType: 'html',
        success: function(html) {
            $('#dashboard').fadeOut('slow', function() {
            		stop_wait();
            	$('#dashboard').html(html);
            	$('#dashboard').fadeIn('slow');
            	stop_wait();
            });
        }
    });
}
</script>