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
var array = {};
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
						json = $.parseJSON(json.data);
						console.log(json);
	                   	var combo = "<select id=\"reason\" name=\"reason\" class=\"form-control\"><option>--Select Reason--</option>";
		            	$.each(json, function(key, value) {
		             		if(key == 'rows')
		                   	{
		                		for ( var i = 0; i < json.rows.length; i++) {
		                    		var row = json.rows[i];
		               				combo = combo + "<option>" + row['reason'] + "</option>";
		               				array = json.rows;
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
		$('.datepicker').datetimepicker({
			format: 'dd-mm-yyyy',
			startView: 'month',
			minView: 'month',
			autoclose: true
		});
		$('#dateTo').datetimepicker({
			format: 'dd-mm-yyyy',
			startView: 'month',
			minView: 'month',
			autoclose: true
        })
        .on('changeDate', function(e) {
		    $(this).datetimepicker('hide');
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
		                var reasonId = getArray($('#reason').val());
		                console.log('>>>>');
		                console.log();
		                console.log('<<<<');
						if($('#planType').val() == 'Defined Benefit')
						{
							var url = $('#reportPath').val() + 'members/Member Projection (' + $('#option').val() + ').xdo?_xpf=&_xpt=0&_xdo=%2F~weblogic%2Ffundmaster%2Freports%2Fmembers%2FMember%20Projection%20(' + $('#option').val() + ').xdo&_xmode=3&_paramsprojdotinterestrate=PROVISIONAL&_paramsprojdotprojtype=Retirements%20Unreduced&_paramsBASE=' + $('#xiRootPath').val() + '&_paramsschemeId=' + $('#scheme_id').val() + '&_paramsbendotdateOfCalculation=' + parseDate($('#dateTo').val()) + '&_paramsbendotdateOfExit=' + parseDate($('#dateTo').val()) + '&_paramsbendotmemberId=' + $('#member_id').val() + '&_paramsbendotreasonForExitId=' + reasonId + '&_xt=Member%20Projections%20(UnReduced)&_xf=analyze&_xana=view&_paramsap_id=81&admin=3347&_paramsadmin=3347&id=' + $('#username').val() + '&passwd=' + $('#password').val();
							 $("#bh-results").html('<object width="100%" height="700px" data="' + url + '"><h2 class="text-center"><small>Could not load report. Check that the report server is correctly configured and running</small></h2></object>');
						}
						else if($('#planType').val() == 'Defined Contribution')
						{
							var url = $('#reportPath').val() + 'members/Member Projection (Surrender Value).xdo?_xpf=&_xpt=0&_xdo=%2F~weblogic%2Ffundmaster%2Freports%2Fmembers%2FMember%20Projection%20(Surrender%20Value).xdo&_xmode=3&_paramsprojdotinterestrate=PROVISIONAL&_paramsprojdotprojtype=Retirements%20Unreduced&_paramsBASE=' + $('#xiRootPath').val() + '&_paramsschemeId=' + $('#scheme_id').val() + '&_paramsbendotdateOfCalculation=' + parseDate($('#dateTo').val()) + '&_paramsbendotdateOfExit=' + parseDate($('#dateTo').val()) + '&_paramsbendotmemberId=' + $('#member_id').val() + '&_paramsbendotreasonForExitId=' + reasonId + '&_xt=Member%20Projections%20(Surrender%20Value)&_xf=analyze&_xana=view&_paramsap_id=81&admin=3347&_paramsadmin=3347&id=' + $('#username').val() + '&passwd=' + $('#password').val();
							
							 $("#bh-results").html('<object width="100%" height="700px" data="' + url + '"><h2 class="text-center"><small>Could not load report. Check that the report server is correctly configured and running</small></h2></object>');
						}
						stop_wait();
	   	            }
		        }
			});
		});
	});
	
	function parseDate(str){
        var parts = str.split("-");
        var dt = new Date(parseInt(parts[2], 10),
                          parseInt(parts[1], 10) - 1,
                          parseInt(parts[0], 10));
        str = dt.getMonth() + '/' + dt.getDate() + '/' + dt.getFullYear();
        
        return str;
	}
	
	
	function getArray(val){
	    for ( var i = 0; i < array.length; i++) {
    		var val = array[i].reason;
			if(val == val){
			    return array[i].id;
			}
		}
	    return array;
	}
	
	
</script>