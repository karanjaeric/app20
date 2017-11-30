<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
               <label class="control-label">Username</label>
                   <c:forEach var="field" items="${loginFields}">
	                    <c:choose>
		                   <c:when test="${field.profile == 'ADMINISTRATOR' }">
							   <c:if test="${ field.ordinal== 'PHONE' }">
								   <div class="form-inline">
									   <select class="form-control pull-left admin-country-code" name="country-code" style="width: 30%;"></select>
									   <input class="form-control pull-right" type="text"
											  placeholder="Username" name="username" id="username" style="width: 70%;" maxlength="9">
								   </div>
							   </c:if>
							   <c:if test="${ field.ordinal== 'EMAIL'}">
								   <input class="form-control" type="text"
										  placeholder="Username" name="username" id="username">
							   </c:if>
						   </c:when>
						</c:choose>
				   </c:forEach>
							   </div>
						<div class="form-group">
							<label class="control-label">Password</label> <input
								class="form-control" type="password" placeholder="Password" id="password"
								name="password">
						</div>
						<button class="btn btn-warning btn-block" type="submit">
							<strong>LOGIN</strong>
						</button><br />
						<a href="javascript:void(0);" id="pwd-reset-btn" class="btn btn-info">Forgot Your Password?</a>
					</fieldset>
				</form>

			</div>
		</div>

	</div>

</div>
<jsp:include page="includes/partial/footer.jsp" />