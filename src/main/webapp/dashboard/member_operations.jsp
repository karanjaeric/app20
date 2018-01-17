<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
	<h3 class="text-center main-title">
		<i class="glyphicon glyphicon-flash"></i>&nbsp;&nbsp;MEMBER OPERATIONS
	</h3>
	
				<form class="form-inline" role="form" id="member-search" onsubmit="return false;">
					<c:choose>
						<c:when test="${profile == 'SPONSOR' }">
							<input type="hidden" name="action" id="action" value="SEARCH_MEMBER_BY_SPONSOR">
						</c:when>
						<c:otherwise>
							<input type="hidden" name="action" id="action" value="SEARCH_MEMBER">
						</c:otherwise>
					</c:choose>

					<div class="col-md-12">
						<legend>SEARCH MEMBER</legend>
						<fieldset>
							<div class="row">
								<div class="col-sm-4">
									<select name="identifier" id="identifier" class="form-control">
										<option value="MEMBER_NO">Member No</option>
										<option value="VOTER">Voter No</option>
										<option value="PASSPORT">Passport No</option>
										<option value="PENNO">Pension No</option>
										<option value="NATIONAL">National ID</option>
										<option value="DRIVER">Driving Lic. No</option>
										<option value="STAFF">Staff No</option>
										<option value="PIN">PIN No</option>
										<option value="EMAIL">Email Address</option>
										<option value="NHIF">NHIF</option>
										<option value="PHONE">Phone No</option>
										<option value="MEMBER_ID">Member ID</option>
										<option value="FIRST_NAME">First Name</option>
										<option value="SURNAME">Surname</option>
										<option value="OTHER_NAMES">Other Names</option>
										<option value="NAME">Name</option>
									</select>
								</div>
								<div class="col-sm-4">
									<input type="text" class="form-control" name="search" id="search" placeholder="Search"/>

								</div>
								<div class="col-sm-4">
									<button class="btn btn-info">Search</button>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-md-4 hide" id="operations">
						<select class="form-control" id="operation" onchange="do_function();">
							<option>--SELECT AN OPERATION--</option>
							<c:if test="${ permissions.operation_personal_info }">
								<option>PERSONAL INFORMATION</option>							
							</c:if>
							<c:if test="${ permissions.operation_contribution_history }">
								<option>CONTRIBUTION HISTORY</option>
							</c:if>
							<c:if test="${ permissions.operation_balance_history }">
								<option>BALANCES HISTORY</option>
							</c:if>
							<c:if test="${ permissions.operation_statement_of_account }">
								<option>STATEMENT OF ACCOUNT</option>
							</c:if>
							<c:if test="${ permissions.operation_unitized_statement }">
								<option>MEMBER STATEMENT</option>
							</c:if>
							<c:if test="${ permissions.operation_benefit_projection }">
								<option>BENEFITS PROJECTION</option>
							</c:if>
							<c:if test="${ permissions.operation_annual_contribution }">
								<option>ANNUAL CONTRIBUTION STATEMENT</option>
							</c:if>
							<c:if test="${ permissions.operation_claim_status }">
								<option>CLAIM STATUS</option>
							</c:if>
						</select>
					</div>
				</form>
				<table class="table table-responsive hide" id="member_details">
					<tr><td class="right">MEMBER NAME:</td><td class="left" id="member_name"></td><td class="right">MEMBER #:</td><td class="left" id="member_no"></td></tr>
				</table>
				<div class="row" id="page-info">
					
				</div>
</div>
<div class="modal fade" id="modal-view-member" tabindex="-1" role="dialog" aria-labelledby="myModalLabelViewMember" aria-hidden="true">
<form role="form" id="form-view-member">
			<div class="modal-dialog large-modal">
				<div class="modal-content">
					<div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title" id="myModalLabelViewMember">
							<i class="glyphicon glyphicon-picture"></i>&nbsp;&nbsp;SELECT MEMBER
						</h4>
					</div>
					<div class="modal-body">
						<table class="table table-responsive table-striped" id="select-results">
						</table>
					</div>
					</div>
				</div>
			</form>
</div>
<script type="text/javascript">
var member_id;
function do_function()
{
	if($('#operation').val() == 'PERSONAL INFORMATION')
	{
		start_wait();
		$.ajax({
	        url: $('#base_url').val() + 'dashboard',
	        type: 'get',
	        data: {dashboard: 'PI', memberID: member_id},
	        dataType: 'html',
	        success: function(html) {
		        $('#page-info').html(html);
		        stop_wait();
	        }
		});
	}
	else if($('#operation').val() == 'CONTRIBUTION HISTORY')
	{
		start_wait();
		$.ajax({
	        url: $('#base_url').val() + 'dashboard',
	        type: 'get',
	        data: {dashboard: 'CH', memberID: member_id},
	        dataType: 'html',
	        success: function(html) {
		        $('#page-info').html(html);
		        stop_wait();
	        }
		});
	}
	else if($('#operation').val() == 'BALANCES HISTORY')
	{
		start_wait();
		$.ajax({
	        url: $('#base_url').val() + 'dashboard',
	        type: 'get',
	        data: {dashboard: 'BH', memberID: member_id},
	        dataType: 'html',
	        success: function(html) {
		        $('#page-info').html(html);
		        stop_wait();
	        }
		});
	}
	else if($('#operation').val() == 'STATEMENT OF ACCOUNT')
	{
		start_wait();
		$.ajax({
	        url: $('#base_url').val() + 'dashboard',
	        type: 'get',
	        data: {dashboard: 'SA', memberID: member_id},
	        dataType: 'html',
	        success: function(html) {
		        $('#page-info').html(html);
		        stop_wait();
	        }
		});
	}
    else if($('#operation').val() == 'MEMBER STATEMENT')
    {
        start_wait();
        $.ajax({
            url: $('#base_url').val() + 'dashboard',
            type: 'get',
            data: {dashboard: 'US', memberID: member_id},
            dataType: 'html',
            success: function(html) {
                $('#page-info').html(html);
                stop_wait();
            }
        });
    }
	else if($('#operation').val() == 'BENEFITS PROJECTION')
	{
		start_wait();
		$.ajax({
	        url: $('#base_url').val() + 'dashboard',
	        type: 'get',
	        data: {dashboard: 'BP', memberID: member_id},
	        dataType: 'html',
	        success: function(html) {
		        $('#page-info').html(html);
		        stop_wait();
	        }
		});
	}

	else if($('#operation').val() == 'ANNUAL CONTRIBUTION STATEMENT')
	{
		start_wait();
		$.ajax({
			url: $('#base_url').val() + 'dashboard',
			type: 'get',
			data: {dashboard: 'AC', memberID: member_id},
			dataType: 'html',
			success: function(html) {
				$('#page-info').html(html);
				stop_wait();
			}
		});
	}

	else if($('#operation').val() == 'CLAIM STATUS')
	{
		start_wait();
		$.ajax({
			url: $('#base_url').val() + 'dashboard',
			type: 'get',
			data: {dashboard: 'MC', memberID: member_id},
			dataType: 'html',
			success: function(html) {
				$('#page-info').html(html);
				stop_wait();
			}
		});
	}
}
function select_member(id, name, member_no)
{
	member_id = id;
	$('#member_name').html(name);
	$('#member_no').html(member_no);
	$('#member_details').removeClass('hide');
	$('#modal-view-member').modal('hide');
	$('#operations').removeClass('hide');
}
$(document).ready(function(){
$('#member-search').bootstrapValidator({
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
                    message: 'Please enter the search criterion'
                }
            }
        }
       
    }
})
.on('success.form.bv', function(e) {
		if($('#search').val() != '')
		{
			start_wait();
			console.log("Action passed: " + $('#action').val());
			$.ajax({
    	        url: $('#base_url').val() + 'admin',
    	        type: 'post',
    	        data: {ACTION: $('#action').val(), profile: 'MEMBER', search: $('#search').val(), identifier: $('#identifier').val()},
    	        dataType: 'json',
    	        success: function(json) {
        	        console.log(json);
    	            	html = "<tr><th>NAME</th><th>EMAIL ADDRESS</th><th>ACTION</th></tr>";
        	            if(json.success)
    					{
							json = $.parseJSON(json.data);
							console.log(json);
    						$.each(json, function(key, value) {
    				        	if(key == 'rows')
    				           	{
    				        		for ( var i = 0; i < json.rows.length; i++) {
    				            		var row = json.rows[i];
    				            		html = html + "<tr><td>" + row['name'] + "</td><td>" + row['email'] + "</td><td><a onclick=\"select_member('" + row['id'] + "', '" + row['name'] + "', '" + row['memberNo'] + "');\" class=\"btn btn-sm btn-primary\"><i class=\"glyphicon glyphicon-ok\"></i>&nbsp;&nbsp;SELECT MEMBER</a></td></tr>";
    				        		}
    								stop_wait();
    				           	}
    						});
    					}
					$('#select-results').html(html);
					stop_wait();
					$('#modal-view-member').modal('show');
    	        }
    	    });
		}
	});
});
</script>