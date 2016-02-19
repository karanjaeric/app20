<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/partial/header.jsp" />

<div class="main-content">

	<div class="container">

		<div class="col-md-6 col-md-offset-3">
			<div class="login-form">

				<form class="register-form" action="<%=request.getContextPath()%>/sign-in" method="post" id="form-sign-in">
					<fieldset>
						<legend class="text-center">Please Login To Access Your
							Account</legend>
						<img class="profile-img-card" src="static/images/avatar_2x.png">
						<div class="form-group">
						<c:forEach var="field" items="${loginFields }">
							<c:choose>
								<c:when test="${field.profile == 'MEMBER' }">
									<label for="username" class="control-label">${ field.ordinal }:</label>
									<input type="text" name="username" class="form-control input-sm"
										id="username" placeholder="${ field.ordinal}">
								</c:when>
							</c:choose>
						</c:forEach>
						</div>
						<div class="form-group">
							<label class="control-label">Password</label> <input
								class="form-control" type="password" placeholder="Password"
								name="password" id="password">
						</div>
						<button class="btn btn-warning btn-block" type="submit">
							<strong>SIGN IN</strong>
						</button><br />
						<a href="javascript:void(0);" id="pwd-reset-btn" class="btn btn-info">Forgot Your Password?</a>
						<img src="<%=request.getContextPath() %>/static/images/logo-brand.png" class="img-brand"/>
					</fieldset>
				</form>

			</div>
		</div>

	</div>

</div>
<jsp:include page="includes/partial/footer.jsp" />