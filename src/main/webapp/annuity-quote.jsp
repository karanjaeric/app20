<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form class="form-horizontal" method="post" id="form-annuity-quotation">
							
<div class="modal-dialog large-modal">
	<div class="modal-content">
		<div class="modal-body">
	
		<h1 class="heading">${ menu.annuityQuotationName }</h1>
				<div class="row">
					<div class="col-md-6 col-sm-6">
						<fieldset>
							<legend>
								<i class="fa fa-user"></i> &nbsp;Personal Information
							</legend>
							
							<!-- <div class="form-group">
								<label for="fullName" class="control-label">Name:</label> <input
									type="text" name="fullName" class="form-control" id="fullName"
									placeholder="Full Name">
							</div>  -->
							
							<div class="form-group">
								<label for="firstName" class="control-label">First Name:</label> <input
									type="text" name="firstName" class="form-control" id="firstName"
									placeholder="First Name">
							</div>
							
							<div class="form-group">
								<label for="lastName" class="control-label">Last Name:</label> <input
									type="text" name="lastName" class="form-control" id="lastName"
									placeholder="Last Name">
							</div>
							
							<div class="form-group">
								<label for="otherNames" class="control-label">Other Names:</label> <input
									type="text" name="otherNames" class="form-control" id="otherNames"
									placeholder="Other Names">
							</div>
							
							<div class="form-group">
								<label for="dateOfBirth" class="control-label">Date Of
									Birth:</label> <input type="text" onblur="set_spouse_date_of_birth();" readonly="readonly" name="dateOfBirth"
									class="form-control datepicker" id="dateOfBirth"
									placeholder="Date Of Birth">
							</div>
							<div class="form-group">
								<label for="gender" class="control-label">Gender:</label> <select
									name="gender" id="gender" class="form-control">
									<option value="">Select gender...</option>
									<c:forEach var="gender" items="${genders}">
						                <option value="${gender.id}">
						                    ${gender.name}
						                </option>
						            </c:forEach>
								</select>
							</div>
							<!-- <div class="form-group">
								<label for="maritalStatus" class="control-label">Marital Status:</label> 
									<select name="maritalStatus" id="maritalStatus" onchange="hide_or_show();" class="form-control">
									<option value="">Select marital status...</option>
									<c:forEach var="maritalStatus" items="${maritalStatuses}">
						                <option value="${maritalStatus.id}">  ${maritalStatus.name} </option>
						            </c:forEach>
								</select>
							</div>  -->
							
		<div class="form-group">
			<label for="maritalStatus" class="control-label">Marital Status:</label>
		
				<!-- <select name="maritalStatus" id="maritalStatus" onchange="hide_or_show();" class="form-control">
					<option value="">Select marital status...</option>
					<option ${ maritalStatus == 'SINGLE' ? 'selected="selected"' : '' }>Single</option>
					<option ${ maritalStatus == 'MARRIED' ? 'selected="selected"' : '' }>Married</option>
				</select> -->
				
				<select id="maritalStatus" class="form-control" onchange="hide_or_show();" name="maritalStatus" data-bv-field="maritalStatus">
					<option value="">Select marital status...</option>
					<option value="1"> Single </option>
					<option value="2"> Married </option>
					<!-- <option value="3"> Divorced </option> -->
					<!-- <option value="4"> Widowed </option> -->
				</select>
			
		</div>			
							<div class="form-group">
								<label for="idNumber" class="control-label">ID/Passport
									Number:</label> <input type="text" name="idNumber" class="form-control"
									id="idNumber" placeholder="ID/Passport Number">
							</div>
						</fieldset>
					</div>
					<div class="col-md-6 col-sm-6">
						<fieldset>
							<legend>
								<i class="fa fa-phone"></i> &nbsp;Contact Information
							</legend>
							<div class="form-group">
								<label for="emailAddress" class="control-label">Email
									Address:</label> <input type="text" name="emailAddress"
									class="form-control" id="emailAddress"
									placeholder="Email Address">
							</div>
							<div class="form-group">
								<label for="phoneNumber" class="control-label">Phone
									Number:</label> <input type="text" name="phoneNumber"
									class="form-control" id="phoneNumber" placeholder="Phone Number">
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
								<legend>Annuity Parameters</legend>
								<div class="col-md-3">
									<div class="form-group">
												<label for="annuityProduct" class="control-label">Annuity Product:</label>
												<select name="annuityProduct" id="annuityProduct" class="form-control">
													<option value="">Select Product...</option>	
													<c:forEach var="annuityProduct" items="${annuityProducts}">
										                <option value="${annuityProduct.id}">
										                    ${annuityProduct.productName}
										                </option>
										            </c:forEach>											
												</select>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
												<label for="paymentFrequency" class="control-label">Payment Frequency:</label> 
												<select name="paymentFrequency" id="paymentFrequency" class="form-control">
													<option value="">Select Frequency...</option>
													<option>MONTHLY</option>
													<option>QUARTERLY</option>
													<option>SEMI_ANNUALLY</option>
													<option>ANNUAL</option>												
												</select>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
												<label for="purchaseDate" class="control-label">Purchase Date:</label>
												<input type="text" readonly="readonly" name="purchaseDate"
													class="form-control datepicker" id="purchaseDate"
													placeholder="Purchase Date">
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
												<label for="calculationMode" class="control-label">Calculation Mode:</label>
												<select name="calculationMode" id="calculationMode" class="form-control" onchange="show_calculation_mode();">
													<option value="">Select Calculation Mode...</option>	
													<option value="0">PURCHASE PRICE</option>
													<option value="1">TARGET PENSION</option>											
												</select>
									</div>
								</div>
						</fieldset>
					</div>
					<div class="row">
						<fieldset>
								<div class="row">
									<div class="col-md-3">
										<div class="form-group">
													<label for="paymentMode" class="control-label">Payment Mode:</label>
													<select name="paymentMode" id="paymentMode" class="form-control">
														<option value="">Select Mode...</option>	
														<option>ARREAS</option>
														<option>ADVANCE</option>											
													</select>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
													<label for="commencementDate" class="control-label">Commencement Date:</label> <input
														type="text" name="commencementDate" readonly = "readonly" class="form-control datepicker" id="commencementDate"
														placeholder="Date Of Commencement">
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
													<label for="guaranteePeriod" class="control-label">Guarantee Period (In Years):</label> <input
														type="text" name="guaranteePeriod" class="form-control" id="guaranteePeriod"
														placeholder="Guarantee Period">
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
													<label for="annualPensionIncrease" class="control-label">Annual Pension Increase (%):</label> <input
														type="text" name="annualPensionIncrease" class="form-control" id="annualPensionIncrease"
														placeholder="0">
										</div>
									</div>
								</div>
					
								<div class="row">
									<div class="col-md-3 hide" id="purchasePriceGroup">
										<div class="form-group">
													<label for="purchasePrice" class="control-label">Registered Purchase Price:</label> <input
														type="text" name="purchasePrice" class="form-control" id="purchasePrice"
														placeholder="0.00" value="0">
										</div>
									</div>
						
									<div class="col-md-3 hide" id="unRegPurchasePriceGroup">
										<div class="form-group">
													<label for="unRegPurchasePrice" class="control-label">Un-Registered Purchase Price:</label> <input
														type="text" name="unRegPurchasePrice" class="form-control" id="unRegPurchasePrice"
														placeholder="0.00" value="0">
										</div>
									</div>
						
									<div class="col-md-3 hide" id="targetPensionGroup">
										<div class="form-group">
													<label for="targetPension" class="control-label">Target Pension:</label> <input
														type="text" name="targetPension" class="form-control" id="targetPension"
														placeholder="0.00" value="0">
										</div>
									</div>
								</div>
						</fieldset>
					</div>
					<div class="row">
						<fieldset>
								<div class="col-md-3">
									<div class="form-group hide" id="paymentModeGroup">
												<label for="annuityMode" class="control-label">Annuity Mode:</label>
												<select name="annuityMode" id="annuityMode" class="form-control" onchange="spouse_reversion();">
													<option>SINGLE</option>
													<option>JOINT</option>											
												</select>
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group hide" id="spouseDateOfBirthGroup">
												<label for="spouseDateOfBirth" class="control-label">Spouse's Date Of Birth:</label> <input
													type="text" name="spouseDateOfBirth" readonly = "readonly" class="form-control datepicker" id="spouseDateOfBirth"
													placeholder="Spouse Date Of Birth">
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group hide" id="spouseGenderGroup">
												<label for="spouseGender" class="control-label">Spouse Gender:</label> <select
													name="spouseGender" id="spouseGender" class="form-control">
													<c:forEach var="gender" items="${genders}">
										                <option value="${gender.id}">
										                    ${gender.name}
										                </option>
										            </c:forEach>
												</select>
									</div>
								</div>
						
									<div class="col-md-3 hide" id="spouseReversalGroup">
										<div class="form-group">
													<label for="spouseReversal" class="control-label">Spouse Reversal:</label> <input
														type="text" name="spouseReversal" class="form-control" id="spouseReversal"
														placeholder="0.00" value="0">
										</div>
									</div>
									<div class="col-md-3 hide" id="displayable">
										<div class="form-group">
													<label for="displayable" class="control-label">Displayable:</label> <input
														type="text" name="displayable" class="form-control" id="displayable"
														placeholder="displayable" value="1">
										</div>
									</div>
						</fieldset>
					
						<div align="right">
							<button class="btn btn-primary">GET QUOTATION</button>
						</div>
					<p>&nbsp;</p>
					<table class="table table-responsive table-striped" id="results">
						
					</table>
					</div>
			</div>
		</div>
	</div>
</form>