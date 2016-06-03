<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form role="form" method="post" id="form-new-sponsor">

	<div class="modal-dialog large-modal">
		<div class="modal-content">
		
			<!--<div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button> 
				<h4 class="modal-title" id="myModalLabelNewSponsor">
					<i class="glyphicon glyphicon-picture"></i>&nbsp;&nbsp;NEW SPONSOR
				</h4>
			</div> -->
			
			<div class="modal-body">
			
			<h1 class="heading">${ menu.potentialSponsorName }</h1>
			
				<!-- <form class="form-horizontal" method="post" id="form-new-sponsor"> -->
												<div class="row">
														<div class="col-md-6 col-sm-6">
														<fieldset>
															<legend>
																<i class="fa fa-user"></i> &nbsp;Company Information
															</legend>
															<div class="form-group">
																<label for="companyName" class="control-label">Company Name:</label> <input
																	type="text" name="companyName" class="form-control" id="companyName"
																	placeholder="Company Name">
															</div>
															<div class="form-group">
																<label for="companyApplicationDate" class="control-label">Application Date:</label> <input type="text" readonly="readonly" name="companyApplicationDate"
																	class="form-control datepicker" id="companyApplicationDate"
																	placeholder="Application Date">
															</div>
															<div class="form-group">
																<label for="pinNumber" class="control-label">PIN Number:</label> <input type="text" name="pinNumber" class="form-control"
																	id="pinNumber" placeholder="PIN Number">
															</div>
															<div class="form-group">
																<label for="employerNumber" class="control-label">Employer Ref/No:</label> <input type="text" name="employerNumber" class="form-control"
																	id="employerNumber" placeholder="Employer Number">
															</div>
															<div class="form-group">
																<label for="sector" class="control-label">Sector:</label> <select
																	name="sector" id="sector" class="form-control">
																	<option value="">Select sector...</option>
																	<c:forEach var="sector" items="${sectors}">
														                <option value="${sector.id}">
														                    ${sector.name}
														                </option>
														            </c:forEach>
																</select>
															</div>
														</fieldset>
													</div>
													<div class="col-md-6 col-sm-6">
														<fieldset>
															<legend>
																<i class="fa fa-phone"></i> &nbsp;Contact Information
															</legend>
															<div class="form-group">
																<label for="companyEmail" class="control-label">Email
																	Address:</label> <input type="text" name="companyEmail"
																	class="form-control" id="companyEmail"
																	placeholder="Email Address">
															</div>
															<div class="form-group">
																<label for="companyPhone" class="control-label">Phone
																	Number:</label> <input type="text" name="companyPhone"
																	class="form-control" id="companyPhone" placeholder="Phone Number">
															</div>
															<div class="form-group">
																<label for="companyAddress" class="control-label">Company
																	Address:</label> <input type="text" name="companyAddress"
																	class="form-control" id="companyAddress"
																	placeholder="Company Address">
															</div>
															<div class="form-group">
																<label for="companyCity" class="control-label">City Or Town:</label> <input
																	type="text" name="companyCity" class="form-control" id="companyCity"
																	placeholder="City or Town">
															</div>
															<div class="form-group">
																<label for="country" class="control-label">Country:</label> <select
																	name="companyCountry" id="companyCountry" class="form-control">
																	<option value="">Select country...</option>
																	<c:forEach var="country" items="${countries}">
														                <option value="${country.id}">
														                    ${country.name}
														                </option>
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
																Pension Product:</label> <select name="pension_scheme" id="pension_scheme"
																class="form-control" >
																<option value="">Select pension product...</option>
																<c:forEach var="scheme" items="${sponsorSchemes}">
													                <option value="${scheme.id}">
													                    ${scheme.name}
													                </option>
													            </c:forEach>
															</select>
														</div>
														<div class="col-md-6">
															<p>&nbsp;</p>
															<button class="btn btn-primary btn-block">REGISTER</button>
														</div>
													</fieldset>
												</div>
											<!-- </form> -->
			</div>
			</div>
		</div>
	</form>