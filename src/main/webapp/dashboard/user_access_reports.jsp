<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
	<h3 class="text-center main-title">
		<i class="glyphicon glyphicon-film"></i>&nbsp;&nbsp;USER ACCESS REPORTS
	</h3>
	<div class="row">
		<div class="form-group col-md-3">
			<label class="control-label">Select A Report</label>
			<select id="report" onchange="show_hide_date();" class="form-control">
				<option value="">Choose one...</option>
				<option value="locked_user_accounts">LOCKED ACCOUNTS</option>
				<option value="frequent_users">FREQUENT USERS</option>
				<option value="non_frequent_users">NON-FREQUENT USERS</option>
			</select>
		</div>
		<div class="form-group col-md-3 date hide">
				<label for="dateFrom" class="control-label">
				Date From:
				</label> <input type="text" readonly="readonly" name="dateFrom"
					class="form-control datepicker" id="dateFrom"
					placeholder="Date From">
		</div>
		<div class="form-group col-md-3 date hide">
				<label for="dateTo" class="control-label">
				Date To:
				</label> <input type="text" readonly="readonly" name="dateTo"
					class="form-control datepicker" id="dateTo"
					placeholder="Date To">
		</div>
		<div class="form-group col-md-3">
				<p>&nbsp;</p>
			<button class="btn btn-primary" onclick="load_report();">SHOW REPORT</button>
		</div>
	</div>
	<p>&nbsp;</p>
	<div class="row" id="display-report">
		
	</div>
</div>
<script type="text/javascript">
$(document).ready(function(){

	$('.datepicker').datetimepicker({format: 'dd-mm-yyyy'});
	$('#dateTo')
	.datetimepicker({
	    format: 'dd-mm-yyyy'
	})
	.on('changeDate', function(e) {
	    // Revalidate the date field
	    $('#ch-form').bootstrapValidator('revalidateField', 'dateTo');
	});
});
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
function is_dated_report()
{
	return $('#report').val() == 'frequent_users' || $('#report').val() == 'non_frequent_users'
}
function show_hide_date()
{
	if(!is_dated_report())
	{
		$('.date').addClass('hide');
	}
	else
	{
		$('.date').removeClass('hide');
	}
}
function load_report()
{
	var proceed = false;
	if(is_dated_report() && $('#dateTo').val() != '' && $('#dateFrom').val() != '')
	{
		proceed = true;
	}
	else if(!is_dated_report() && $('#report').val() != '')
	{
		proceed = true;
	}
	else
	{
		bootbox.alert('Please set the report parameters');
	}
	if(proceed)
	{
		start_wait();
		$.ajax({
	        url: $('#base_url').val() + 'dashboard',
	        type: 'get',
	        data: {dashboard: 'ANALYTICS_REPORT', report: $('#report').val(), from: $('#dateFrom').val(), to: $('#dateTo').val()},
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