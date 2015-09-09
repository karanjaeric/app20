<jsp:include page="includes/partial/header.jsp" />

<div class="main-content">

	<div class="container">

		<div class="col-md-6 col-md-offset-3">
			<div class="login-form">

				<form class="register-form" id="form-login" method="post" >
					<fieldset>
						<legend class="text-center">Please Login Here</legend>
						<img class="profile-img-card" src="static/images/avatar_2x.png">
						<div class="form-group">
							<label class="control-label">Username</label> <input
								class="form-control" type="text"
								placeholder="Username" name="username" id="username">
						</div>
						<div class="form-group">
							<label class="control-label">Password</label> <input
								class="form-control" type="password" placeholder="Password" id="password"
								name="password">
						</div>
						<button class="btn btn-warning btn-block" type="submit">
							<strong>LOGIN</strong>
						</button>
					</fieldset>
				</form>

			</div>
		</div>

	</div>

</div>
<jsp:include page="includes/partial/footer.jsp" />