<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form class="form-horizontal" method="post" id="form-new-member">

	<div class="modal-dialog large-modal">
		<div class="modal-content">
			<div class="modal-body">

			<h1 class="heading">${ menu.potentialMemberName }</h1>

				<div class="row">
					<div class="col-md-6 col-sm-6">
						<fieldset>
							<legend>
								<i class="fa fa-user"></i> &nbsp;Personal Information
							</legend>
							<div class="form-group">
								<label for="firstName" class="control-label">First Name:</label>
								<input type="text" name="firstName" class="form-control"
									id="firstName" placeholder="First Name">
							</div>
							<div class="form-group">
								<label for="lastName" class="control-label">Last Name:</label> <input
									type="text" name="lastName" class="form-control" id="lastName"
									placeholder="Last Name">
							</div>
							<div class="form-group">
								<label for="otherName" class="control-label">Other Name:</label>
								<input type="text" name="otherName" class="form-control"
									id="otherName" placeholder="Other Names">
							</div>
							<div class="form-group">
								<label for="dateOfBirth" class="control-label">Date Of
									Birth:</label> <input type="text" readonly="readonly"
									name="dateOfBirth" class="form-control datepicker"
									id="dateOfBirth" placeholder="Date Of Birth">
							</div>
							<div class="form-group">
								<label for="gender" class="control-label">Gender:</label> <select
									name="gender" id="gender" class="form-control">
									<option value="">Select gender...</option>
									<c:forEach var="gender" items="${genders}">
										<option value="${gender.id}">${gender.name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="maritalStatus" class="control-label">Marital
									Status:</label> <select name="maritalStatus" id="maritalStatus"
									class="form-control">
									<option value="">Select marital status...</option>
									<c:forEach var="maritalStatus" items="${maritalStatuses}">
										<option value="${maritalStatus.id}">
											${maritalStatus.name}</option>
									</c:forEach>
								</select>
							</div>
						</fieldset>
					</div>
					<div class="col-md-6 col-sm-6">
						<fieldset>
							<legend>
								<i class="fa fa-phone"></i> &nbsp;Other Information
							</legend>
							<div class="form-group">
								<label for="IdNumber" class="control-label">ID/PPT
									Number</label> <input type="text" name="IdNumber"
									class="form-control input-sm" id="IdNumber"
									placeholder="ID/PPT Number">
							</div>
							<div class="form-group">
								<label for="emailAddress" class="control-label">Email
									Address:</label> <input type="text" name="emailAddress"
									class="form-control" id="emailAddress"
									placeholder="Email Address">
							</div>
							<div class="form-group">
								<label for="phoneNumber" class="control-label">Phone
									Number:</label> <input type="text" name="phoneNumber"
									class="form-control" id="phoneNumber"
									placeholder="Phone Number">
							</div>
							<div class="form-group">
								<label for="residentialAddress" class="control-label">Residential
									Address:</label> <input type="text" name="residentialAddress"
									class="form-control" id="residentialAddress"
									placeholder="Residential Address">
							</div>
							<div class="form-group">
								<label for="city" class="control-label">City Or Town:</label> <input
									type="text" name="city" class="form-control" id="city"
									placeholder="City or Town">
							</div>
							<div class="form-group">
								<label for="country" class="control-label">Country:</label> <select
									name="country" id="country" class="form-control">
									<option value="">Select country...</option>
									<c:forEach var="country" items="${countries}">
										<option value="${country.id}">${country.name}</option>
									</c:forEach>
								</select>
							</div>
						</fieldset>
					</div>
				</div>

				<div class="row">
					<fieldset>
						<legend>
							<i class="glyphicon glyphicon-th"></i>&nbsp; Pension Plan
						</legend>
						<div class="form-group col-md-6">
							<label for="pension_scheme" class="control-label">Preferred
								Pension Plan:</label> <select name="pension_scheme" id="pension_scheme"
								class="form-control">
								<option value="">Select pension product...</option>
								<c:forEach var="scheme" items="${memberSchemes}">
									<option value="${scheme.id}">${scheme.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-6">
							<p>&nbsp;</p>
							<button class="btn btn-primary btn-block">REGISTER</button>
						</div>
					</fieldset>
				</div>
			</div>
		</div>
	</div>
</form>
