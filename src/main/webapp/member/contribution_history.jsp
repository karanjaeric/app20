<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
				<h3 class="text-center main-title">
					<i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;CONTRIBUTION HISTORY
				</h3>
				<form class="form-inline" role="form" id="ch-form">
					<div class="form-group col-md-4">
							<label for="dateFrom" class="control-label">
							Date From:
							</label> <input type="text" readonly="readonly" name="dateFrom"
								class="form-control datepicker" id="dateFrom"
								placeholder="Date From">
					</div>
					<div class="form-group col-md-4">
							<label for="dateTo" class="control-label">
							Date To:
							</label> <input type="text" readonly="readonly" name="dateTo"
								class="form-control datepicker" id="dateTo"
								placeholder="Date To">
					</div>
					<div class="col-md-4">
							<button class="btn btn-primary">
								SHOW HISTORY
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
				<div class="col-md-12" id="ch-results">
					
				</div>
		
<script type="text/javascript">
	$(document).ready(function(){
		$('.datepicker').datetimepicker(
		$('#dateFrom').datetimepicker({
			format: 'dd-mm-yyyy',
			startView: 'month',
			minView: 'month',
			autoclose: true
		})
		.on('changeDate', function(e) {
			$(this).datetimepicker('hide');
			// Revalidate the date field
			$('#ch-form').bootstrapValidator('revalidateField', 'dateTo');
		}),
		$('#dateTo')
        .datetimepicker({
			format: 'dd-mm-yyyy',
			startView: 'month',
			minView: 'month',
			autoclose: true
		})
        .on('changeDate', function(e) {
		    $(this).datetimepicker('hide');
            // Revalidate the date field
            $('#ch-form').bootstrapValidator('revalidateField', 'dateTo');
        }));
		$('#ch-form').bootstrapValidator({
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
						var alternativeUrl = null;
						var orientation = null;

						$.ajax({
							url:  res + '/reports/general?_eventName=base-url&schemeId=' + $('#scheme_id').val(),
							data: '',
							type:'get',
							async: false,
							/*dataType: 'json',*/
							success:function(json){
								console.log(json);
								var json_string =  json;
								var result =  $.parseJSON(json_string);
								var base_url = result.base_url;
								console.log(base_url);
								alternativeUrl = result.alternativeUrl;
								console.log(alternativeUrl);
								orientation = result.orientation;
								console.log(orientation);
							}
						});

		                var fromDate = (document.getElementById('dateFrom').value).split("-").join("/");
		                var toDate = (document.getElementById('dateTo').value).split("-").join("/");
						var url = //$('#reportPath').val() + 'members/contributionHistoryDated.xdo?&_paramsBASE=' + $('#xiRootPath').val() + 'Xi&_xpf=&_xpt=0&_xdo=%2F~weblogic%2Ffundmaster%2Freports%2Fmembers%2FcontributionHistoryDated.xdo&_xmode=3&_paramsscheme_id=' + $('#scheme_id').val() + '&_paramsmember_id=' + $('#member_id').val() + '&_xt=Contribution%20History%20(Detailed)&_xf=analyze&_xana=view&_paramsap_id=81&admin=3347&_paramsadmin=3347&id=' + $('#username').val() + '&passwd=' + $('#password').val() + '';
						    $('#reportPath').val() +"members/ContributionHistoryRange.xdo?_xpf=&_xpt=0&_xdo=%2F~weblogic%2Ffundmaster%2Freports%2Fmembers%2FContributionHistoryRange.xdo&_xmode=3&_paramsdateTo=" + toDate
									        + "&_paramsdateFrom=" + fromDate
									        +  "&_paramsblankImage="  + alternativeUrl + "&_paramsalternativeUrl="  + alternativeUrl + "&_paramsorientation=" + orientation + "&_paramsBASE=http%3A%2F%2Flocalhost%3A8080%2FXi&_paramsscheme_id="
									        + $('#scheme_id').val() + "&_paramsmember_id=" + $('#member_id').val() + "&_xt=Contribution%20History%20(Detailed)&_xf=analyze&_xana=view&id=" + $('#username').val() + "&passwd=" + $('#password').val();
						
						    $("#ch-results").html('<object width="100%" height="700px" data="' + url + '"><h2 class="text-center"><small>Could not load report. Check that the report server is correctly configured and running</small></h2></object>');
						 						 
						 stop_wait();
	   	            }
		        }
			});
			
			
			
			
			
			
		});
	});
</script>