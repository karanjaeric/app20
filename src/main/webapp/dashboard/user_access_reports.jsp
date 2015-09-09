<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
	<h3 class="text-center main-title">
		<i class="glyphicon glyphicon-film"></i>&nbsp;&nbsp;USER ACCESS REPORTS
	</h3>
	<div class="col-md-3">
		<label class="control-label">Select A Report</label>
	</div>
	<div class="col-md-4">
		<select id="report" onchange="load_report();" class="form-control">
			<option value="">Choose one...</option>
			<option value="locked_user_accounts">LOCKED ACCOUNTS</option>
			<option value="frequent_members">FREQUENT USERS</option>
			<option value="non_frequent_members">NON-FREQUENT USERS</option>
		</select>
	</div>
	<p>&nbsp;</p>
	<div class="row" id="display-report">
		
	</div>
</div>
<script type="text/javascript">
function load_dashboard(MODULE)
{
    start_wait();
	$.ajax({
        url: $('#base_url').val() + 'dashboard',
        type: 'get',
        data: {dashboard: MODULE},
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
function load_report()
{
	if($('#report').val() != '')
	{
		start_wait();
		$.ajax({
	        url: $('#base_url').val() + 'dashboard',
	        type: 'get',
	        data: {dashboard: 'ANALYTICS_REPORT', report: $('#report').val()},
	        dataType: 'html',
	        success: function(html) {
	            $('#display-report').fadeOut('slow', function() {
	            	$('#display-report').html(html);
	            	$('#display-report').fadeIn('slow');
	            	stop_wait();
	            });
	        }
	    });
	}
}
</script>