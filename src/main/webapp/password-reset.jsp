<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/partial/header.jsp" />
<div class="container">
<div class="main-content">
	
		<h1 class="heading">PASSWORD RESET</h1>
		<form role="form" id="form-reset-password">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">
						<h3 class="text-center"><small>You should check your Phone/Email to obtain the code requested herein</small></h3>
						<div class="form-group">
							<label class="control-label" for="resetCode">  Code:</label> <input type="password" class="form-control"
								id="resetCode" name="resetCode"
								placeholder="Reset Code">
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
						<button class="btn btn-primary" type="submit"
							id="pwd_btn">Reset Password</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<jsp:include page="includes/partial/footer.jsp" />