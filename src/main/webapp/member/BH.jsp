<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
				<h3 class="text-center main-title">
					<i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;BALANCES HISTORY
				</h3>
				<input type="hidden" id="reportPath" value="${ settings.xiReportPath }" />
				<input type="hidden" id="xiRootPath" value="${ settings.xiPath }" />
				<input type="hidden" id="username" value="${ settings.xiReportUsername }" />
				<input type="hidden" id="password" value="${ settings.xiReportPassword }" />
				<input type="hidden" id="scheme_id" value="${ scheme_id }"/>
				<input type="hidden" id="member_id" value="${ member_id }" />
				<p>&nbsp;</p>
				<div class="col-md-12" id="bh-results">
					
				</div>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
	        url: $('#base_url').val() + 'admin',
	        type: 'post',
	        data: {ACTION:'AP'},
	        dataType: 'json',
	        success: function(json) {
	            if(json.success)
   	            {
	    			var url = $('#reportPath').val() + 'members/member balances (Combined - per member).xdo?_xpf=&_xpt=0&_xdo=%2F~weblogic%2Ffundmaster%2Freports%2Fmembers%2Fmember%20balances%20(Combined%20-%20per%20member).xdo&_xmode=3&_paramsmember_id=' + $('#member_id').val() + '&_paramsBASE=' + $('#xiRootPath').val() + '&_paramsscheme_id=' + $('#scheme_id').val() + '&_paramsap_id=' + json.accountingPeriodId + '&_xt=Member%20Balances%20(Combined)&_xf=analyze&_xana=view&_xautorun=false&_paramsadmin=3347&id=' + $("#username").val() + '&passwd=' + $("#password").val();
	   			 	$("#bh-results").html('<object width="100%" height="700px" data="' + url + '"/>');	   	            
   	            }
	        }
		});
	});
</script>