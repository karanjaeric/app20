<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section content-area">
		<input type="hidden" id="planType" value="${ planType }" />
				<h3 class="text-center main-title">
					<i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;BENEFITS PROJECTION
				</h3>
				<form class="form-inline" role="form" id="bp-form">
					<div class="col-md-4">
							<label for="dateTo" class="control-label">
							Date To:
							</label> <input type="text" readonly="readonly" name="dateTo"
								class="form-control datepicker" id="dateTo"
								placeholder="Date To">
					</div>
					<div class="col-md-3" id="divReason">
						<select id="reason" name="reason" class="form-control">
							<option value="">--Select A Reason for Exit--</option>
						</select>
					</div>
					<c:if test="${ planType == 'Defined Benefit' }">
						<div class="col-md-2">
							<select id="option" name="option" class="form-control">
								<option>Reduced</option>
								<option>UnReduced</option>
							</select>
						</div>
					</c:if>
					<div class="col-md-2">
							<button class="btn btn-primary">
								SHOW REPORT
							</button>
					</div>
				</form>
				<input type="hidden" id="reportPath" value="${ settings.xiReportPath }" />
				<input type="hidden" id="xiRootPath" value="${ settings.xiPath }" />
				<input type="hidden" id="username" value="${ settings.xiReportUsername }" />
				<input type="hidden" id="password" value="${ settings.xiReportPassword }" />
				<input type="hidden" id="scheme_id" value="${ scheme_id }"/>
				<input type="hidden" id="member_id" value="${ member_id }" />
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<div class="col-md-12" id="bh-results">
					
				</div>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		function initialize()
		{
			$.ajax({
		        url: $('#base_url').val() + 'member',
		        type: 'post',
		        data: {ACTION:'REASON'},
		        dataType: 'json',
		        success: function(json) {
		            if(json.success)
	   	            {
	                   	var combo = "<select id=\"reason\" name=\"reason\" class=\"form-control\"><option>--Select Reason--</option>";
		            	$.each(json, function(key, value) {
		             		if(key == 'rows')
		                   	{
		                		for ( var i = 0; i < json.rows.length; i++) {
		                    		var row = json.rows[i];
		                    		console.log(row);
		               				combo = combo + "<option>" + row['reason'] + "</option>";
		                		}
		                		combo = combo + "</select>";
		                   	}
		        		});
		        		$('#divReason').html(combo);
	   	            }
		            else
	    	        {
	    	            stop_wait();
	    	            bootbox.alert('<p class="text-center">' + json.message + '</p>');
	        	    }
		        }
		    });			
		}
		initialize();
		$('.datepicker').datepicker({format: 'dd-mm-yyyy'});
		$('#dateTo')
        .datepicker({
            format: 'dd-mm-yyyy'
        })
        .on('changeDate', function(e) {
            // Revalidate the date field
            $('#bp-form').bootstrapValidator('revalidateField', 'dateTo');
        });
		$('#bp-form').bootstrapValidator({
	        message: 'This value is not valid',
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	            dateTo: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please select the ending date'
	                    }
	                }
	            }
	        }
		}).on('success.form.bv', function(e) {
			start_wait();
			$.ajax({
		        url: $('#base_url').val() + 'member',
		        type: 'post',
		        data: {ACTION:'AP', date: $('#dateTo').val()},
		        dataType: 'json',
		        success: function(json) {
		            if(json.success)
	   	            {
						if($('#planType').val() == 'Defined Benefit')
						{
							var url = $('#reportPath').val() + 'members/Member Projection (' + $('#option').val() + ').xdo?_xpf=&_xpt=0&_xdo=%2F~weblogic%2Ffundmaster%2Freports%2Fmembers%2FMember%20Projection%20(' + $('#option').val() + ').xdo&_xmode=3&_paramsprojdotinterestrate=PROVISIONAL&_paramsprojdotprojtype=Retirements%20Unreduced&_paramsBASE=' + $('#xiRootPath').val() + '&_paramsschemeId=' + $('#scheme_id').val() + '&_paramsbendotdateOfCalculation=' + $('#dateTo').val() + '&_paramsbendotdateOfExit=' + $('#dateTo').val() + '&_paramsbendotmemberId=' + $('#member_id').val() + '&_paramsbendotreasonForExitId=' + $('#reason').val() + '&_xt=Member%20Projections%20(UnReduced)&_xf=analyze&_xana=view&_paramsap_id=81&admin=3347&_paramsadmin=3347&id=' + $('#username').val() + '&passwd=' + $('#password').val();
							 $("#bh-results").html('<object width="100%" height="700px" data="' + url + '"/>');
						}
						else if($('#planType').val() == 'Defined Contribution')
						{
							var url = $('#reportPath').val() + 'members/Member Projection (Surrender Value).xdo?_xpf=&_xpt=0&_xdo=%2F~weblogic%2Ffundmaster%2Freports%2Fmembers%2FMember%20Projection%20(Surrender%20Value).xdo&_xmode=3&_paramsprojdotinterestrate=PROVISIONAL&_paramsprojdotprojtype=Retirements%20Unreduced&_paramsBASE=' + $('#xiRootPath').val() + '&_paramsschemeId=' + $('#scheme_id').val() + '&_paramsbendotdateOfCalculation=' + $('#dateTo').val() + '&_paramsbendotdateOfExit=' + $('#dateTo').val() + '&_paramsbendotmemberId=' + $('#member_id').val() + '&_paramsbendotreasonForExitId=' + $('#reason').val() + '&_xt=Member%20Projections%20(Surrender%20Value)&_xf=analyze&_xana=view&_paramsap_id=81&admin=3347&_paramsadmin=3347&id=' + $('#username').val() + '&passwd=' + $('#password').val();
							 $("#bh-results").html('<object width="100%" height="700px" data="' + url + '"/>');
						}
						stop_wait();
	   	            }
		        }
			});
		});
	});
</script>