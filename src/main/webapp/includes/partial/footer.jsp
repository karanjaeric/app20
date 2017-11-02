<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<% pageContext.setAttribute("currentYear", java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)); %>
<c:if test="${ help.description != '' }">
<button class="btn btn-warning btn-sm help-btn"  data-toggle="modal" href="#modal-help">NEED HELP?</button>
</c:if>
<!--  PAGE HELP INFORMATION -->
<div class="modal fade" id="modal-help" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabelHelp" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title text-center" id="myModalLabelHelp">
						<i class="fa fa-bookmark"></i>&nbsp;&nbsp;HELP INFORMATION
					</h4>
				</div>
				<div class="modal-body">
					${ help.description }
				</div>
				<div class="modal-footer">
					<a href="#" class="btn btn-warning" data-dismiss="modal">OK, THANKS</a>
				</div>
			</div>
		</div>
</div>
<!--  RESET PASSWORD -->
<div class="modal fade "  id="modal-pwd-reset" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabelReset" aria-hidden="true">
		<form role="form" id="form-password-reset">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title text-center" id="myModalLabelReset">
							<i class="fa fa-bookmark"></i>&nbsp;&nbsp;<small>Please provide your username</small>
						</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="user" class="control-label">Username:</label>
							<input type="text" name="email" class="form-control"
										id="email" placeholder="Your username">
						</div>
						<p>We will send you instructions on how to reset your password</p>
					</div>
					<div class="modal-footer">
						<button class="btn btn-success">REQUEST PASSWORD RESET</button>
					</div>
				</div>
			</div>
		</form>
	</div>

<%--ACTIVATE ACCOUNT USING SMS CODE--%>
<div class="modal fade" id="modal-sms-code" tabindex="-1"
	 role="dialog" aria-labelledby="myModalLabelSms" aria-hidden="true">
	<form role="form" id="form-sms-code">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title text-center" id="myModalLabelSms">
						<i class="fa fa-bookmark"></i>&nbsp;&nbsp;<small>Please Enter the received code</small>
					</h4>
				</div>
				<div class="modal-body">

					<div class="form-group">
						<label for="code" class="control-label">Activation Code:</label>
						<input type="text" name="code" class="form-control"
							   id="code" placeholder="Your Activation code">
					</div>
					<p>We will Activate your Account</p>
				</div>
				<div class="modal-footer">
					<button class="btn btn-success">ACTIVATE</button>
				</div>
			</div>
		</div>
	</form>
</div>
<div class="container-fluid footer">
	<p>&copy; Copyright <c:out value="${currentYear}" />. All Rights Reserved. Systech Ltd.</p>
</div>
<div class="modal fade" id="wait-dialog" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-body">
                <p class="text-center masked-bg"><img src="static/images/wait.gif" alt="Please wait..." /><br/>Please wait...<br /><small onclick="stop_wait();">cancel</small></p>
        </div>
</div>
<input type="hidden" id="base_url" value="<%=request.getContextPath()%>/" />
<script src="static/custom/vendors/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.5/js/bootstrapValidator.min.js"></script>
<script src="static/bootstrap-3.3.5/js/bootstrap-filestyle.min.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.5/js/bootstrap-multiselect.js"></script>
<script type="text/javascript"
	src="static/bootstrap-3.3.5/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="static/custom/js/bootbox.min.js"></script>
<script type="text/javascript" src="static/custom/js/scripts.js"></script>
<script type="text/javascript" src="static/custom/js/form-scripts.js"></script>
<script type="text/javascript" src="static/custom/js/highcharts-custom.js"></script>
<script type="text/javascript" src="static/custom/js/core.js"></script>
<script type="text/javascript" src="static/custom/js/plugins/jquery.appear/jquery.appear.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		function init()
		{
			if($('#message').val() !='')
			{
				bootbox.alert("<p class='text-center'>" + $('#message').val() + "</p>");
			}
		}
		init();
	});
</script>

</body>
</html>