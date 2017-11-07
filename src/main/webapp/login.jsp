<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/partial/header.jsp" />

<div class="main-content">

	<div class="container">

		<div class="col-md-6 col-md-offset-3">
			<div class="login-form">

				<form class="register-form" action="<%=request.getContextPath()%>/sign-in" method="post" id="form-sign-in">
					<fieldset>
						<legend class="text-center">Please Login To Access Your Account</legend>
						<img class="profile-img-card" src="static/images/avatar_2x.png">

						<div class="form-group">
							<label class="control-label">Username</label> <input
								class="form-control" type="text"
								placeholder="Username" name="username" id="username">
						</div>

						<div class="form-group">
							<label class="control-label">Password</label> <input
								class="form-control" type="password" placeholder="Password"
								name="password" id="password">
						</div>
						<button class="btn btn-warning btn-block" type="submit">
							<strong>SIGN IN</strong>
						</button><br />
						<a href="javascript:void(0);" id="pwd-reset-btn" class="btn btn-info pull-left" style="font-size: 12px">Forgot Your Password?</a>
						<a href="javascript:void(0);" id="sms-btn" class="btn btn-info pull-right" style="font-size: 12px">Activate Your Account (SMS ONLY)</a>
						<%--<sss--%>
					</fieldset>
				</form>

			</div>
		</div>

	</div>

</div>
<jsp:include page="includes/partial/footer.jsp" />