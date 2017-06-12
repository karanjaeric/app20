<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="no-js">

<head>
<title>${ company.name } - 
<c:choose>
<c:when test="${ profile == 'MEMBER' }">Member Portal</c:when>
<c:otherwise>Administration</c:otherwise>
</c:choose>
</title>
<!-- Bootstrap -->
<link href="static/bootstrap-3.3.5/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<link href="static/bootstrap-3.3.5/css/bootstrap-responsive.min.css"
	rel="stylesheet" media="screen">

	<!-- DataTables CSS-->
<link href="static/datatables/css/datatables.min.css"
		  rel="stylesheet" media="screen">
<link href="static/datatables/css/dataTables.bootstrap.min.css"
		  rel="stylesheet" media="screen">

<link
	href="static/custom/vendors/easypiechart/jquery.easy-pie-chart.css"
	rel="stylesheet" media="screen">
<link href="static/custom/assets/styles.css" rel="stylesheet"
	media="screen">
<link href="static/custom/css/vallenato.css" rel="stylesheet"
	media="screen">
<link href="static/custom/js/ui/trumbowyg.min.css" rel="stylesheet"
	media="screen">
<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.5/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" type="text/css"
	href="static/bootstrap-3.3.5/css/bootstrap-colorpicker.min.css" />
<link rel="stylesheet" type="text/css" href="static/font-awesome-4.3.0/css/font-awesome.min.css" />
<!--<link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>-->
<link href='static/custom/css/fonts.css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
<link rel="icon" href="static/images/favicon.ico">
<script src="static/custom/vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<script type="text/javascript" src="static/jquery/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="static/jquery/datePicker.js"></script>
<script type="text/javascript" src="static/bootstrap-3.3.5/js/colorpicker-color.js"></script>

	<!-- DataTables JS-->
<script type="text/javascript" src="static/datatables/js/datatables.min.js"></script>
<script type="text/javascript" src="static/datatables/js/dataTables.bootstrap.min.js"></script>

</head>

<body oncontextmenu="return false">
<input type="hidden" id="path" value="${ path }" />
<!-- SEND EMAIL -->
<div class="modal fade" id="modal-send-email" tabindex="-1" role="dialog" aria-labelledby="myModalLabelSendEmail" aria-hidden="true">
		<form role="form" id="form-send-email">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabelSendEmail">
							<i class="glyphicon glyphicon-envelope"></i>&nbsp;&nbsp;DROP US AN EMAIL
						</h4>
					</div>
					<div class="modal-body">
						<input type="hidden" name="ACTION" id="ACTION" value="EMAIL" />

						<div class="form-group">
							<label class="control-label" for="recipient">Send To:</label>
							<select id="recipient" name="recipient" class="form-control">
								<option value="" disabled>--Select Recipient--</option>

								<c:if test="${email.defaultEmailActive == 'TRUE'}">
								<option value="defaultEmail">Administrator</option>
								</c:if>
								<c:if test="${email.marketingEmailActive == 'TRUE'}">
								<option value="marketingEmail">Marketing</option>
								</c:if>
								<c:if test="${email.supportEmailActive == 'TRUE'}">
								<option value="supportEmail">Support</option>
								</c:if>
							</select>
						</div>

						<div class="form-group">
							 <label class="control-label" for="subject">Category:</label>
							 <select class="form-control" name="category" id="category">
							 	<c:forEach var="reason" items="${ contactReasons }">
							 		<option>${ reason.name }</option>
							 	</c:forEach>
							 </select>
						</div>
						<div class="form-group">
							 <label class="control-label" for="subject">Subject:</label>
							 <input type="text" class="form-control" name="subject" id="subject"/>
						</div>
						<div class="form-group">
							 <label class="control-label" for="message">Message:</label>
							 <textarea name="message" id="message" class="form-control"></textarea>
						</div>
						<div class="form-group">
							 <label class="control-label" for="attachment">Attachment:</label>
							 <input type="file" id="attachment" name="attachment" />
						</div>
					</div>
					<div class="modal-footer">
						<a href="#" class="btn btn-warning" data-dismiss="modal">Cancel</a>
						<input class="btn btn-primary" type="submit"
							value="Send Email" id="btn-email">
					</div>
				</div>
			</div>
		</form>
	</div>

<!--  CHANGE PASSWORD -->
	<div class="modal fade" id="modal-change-pwd" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabelPwd" aria-hidden="true">
		<form role="form" id="form-change-password">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabelPwd">
							<i class="fa fa-lock"></i>&nbsp;&nbsp;CHANGE PASSWORD
						</h4>
					</div>
					<div class="modal-body">
						<p class="text-center">You should check your email to obtain the security code requested herein</p>
						<div class="form-group">
							<label class="control-label" for="currentPassword">Current
								Password:</label> <input type="password" class="form-control"
								id="currentPassword" name="currentPassword"
								placeholder="Current Password">
						</div>
						<div class="form-group">
							<label class="control-label" for="securityCode">Security Code:</label> <input type="password" class="form-control"
								id="securityCode" name="securityCode"
								placeholder="Security Code (Get from your email)">
						</div>
						<div class="form-group">
							<label class="control-label" for="newPassword">New
								Password:</label> <input type="password" class="form-control"
								id="newPassword" name="newPassword" placeholder="New Password">
						</div>
						<div class="form-group">
							<label class="control-label" for="confirmPassword">Confirm
								Password:</label> <input type="password" class="form-control"
								id="confirmPassword" name="confirmPassword"
								placeholder="Confirm New Password">
						</div>
					</div>
					<div class="modal-footer">
						<a href="#" class="btn btn-warning" data-dismiss="modal">Cancel</a>
						<input class="btn btn-primary" type="submit"
							value="Change Password" id="pwd_btn">
					</div>
				</div>
			</div>
		</form>
	</div>

	<!--  End Change Password -->
	<nav id="main-nav" class="navbar navbar-default navbar-fixed-top" role="imageBanner">
		<div class="container-fluid section">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a href="javascript:void(0);" class="navbar-brand">${ company.name } - 
					<c:choose>
					<c:when test="${ profile == 'MEMBER' }">Member Portal</c:when>
					<c:otherwise>Administration</c:otherwise>
					</c:choose>		
				</a>
			</div>
			<div class="collapse navbar-collapse navbar-right">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">PROFILE: ${ profile }</a></li>
					<li><a href="#">Hi </a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"	aria-expanded="false"><i class="fa fa-user"></i>&nbsp;&nbsp; ${ memberName }<span
							class="caret"></span></a>
						<ul class="dropdown-menu bolden">
							<li><a href="javascript:void(0);" id="change-pwd-li"><i
									class="fa fa-lock"></i>&nbsp;&nbsp;Change Password</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="javascript:void(0);" id="logout-li"><i
									class="fa fa-power-off"></i>&nbsp;&nbsp;Logout</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
		<!--/.container-->
	</nav>
	<!--/nav-->