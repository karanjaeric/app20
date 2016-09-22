<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
				<h3 class="text-center main-title" id="title">
					<i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;EDIT PERSONAL INFORMATION
				</h3>
				<form class="form-horizontal" method="post" id="pi-form">
				<input type="hidden" id="member_id" value="${ member.id }" />
					<input type="hidden" id="member_no" value="${ member.memberNo }" />
					<input type="hidden" name="ACTION" id="ACTION" value="UPDATE_MEMBER" />
				<div class="row">
						<div class="col-md-6">
							<fieldset>
								<legend>
									<i class="fa fa-user"></i> &nbsp;Personal
								</legend>
								<div class="form-group">
									<label for="firstname" class="col-sm-6 control-label">First Name:</label>
									<div class="col-sm-6">
									<input
										type="text" name="firstname" class="form-control  input-sm" id="firstname"
										placeholder="Firstname" value="${ member.firstname }"  ${memberPermission.name == 'TRUE' ? '' : 'disabled'}>
									</div>
								</div>
								<div class="form-group">
									<label for="surname" class="col-sm-6 control-label">Surname:</label>
									<div class="col-sm-6">
									<input
										type="text" name="surname" class="form-control  input-sm" id="surname"
										placeholder="Surname" value="${ member.surname }"  ${memberPermission.name == 'TRUE' ? '' : 'disabled'}>
									</div>
								</div>
								<div class="form-group">
									<label for="surname" class="col-sm-6 control-label">Other Names:</label>
									<div class="col-sm-6">
									<input
										type="text" name="othernames" class="form-control  input-sm" id="otherNames"
										placeholder="Other Names" value="${ member.othernames }"  ${memberPermission.name == 'TRUE' ? '' : 'disabled'}>
									</div>
								</div>
								<div class="form-group">
									<label for="dateOfBirth" class="col-sm-6 control-label">Date Of
										Birth:</label>
									<div class="col-sm-6">
									<input type="text" readonly="readonly" name="dateOfBirth"
										class="form-control  input-sm datepicker" id="dateOfBirth"
										placeholder="Date Of Birth" value="${ member.dateOfBirth }" ${memberPermission.dateOfBirth == 'TRUE' ? '' : 'disabled'}>
									</div>
								</div>
								<div class="form-group">
									<label for="gender" class="col-sm-6 control-label">Gender:</label>
									<div class="col-sm-6">
									<select
										name="gender" id="gender" class="form-control  input-sm" ${memberPermission.gender == 'TRUE' ? '' : 'disabled'}>
										<option value="">Select gender...</option>
										<c:forEach var="gender" items="${genders}">
							                <c:choose>
								                <c:when test="${member.gender == gender.name }">
								                	<option selected="selected">
									                    ${gender.name}
									                </option>
								                </c:when>
								                <c:otherwise>
								                	<option>
									                    ${gender.name}
									                </option>
								                </c:otherwise>
								            </c:choose>
							            </c:forEach>
									</select>
									</div>
								</div>
								<div class="form-group">
									<label for="maritalStatus" class="col-sm-6 control-label">Marital
										Status:</label>
									<div class="col-sm-6">
									<select name="maritalStatus" id="maritalStatus"
										class="form-control  input-sm" ${memberPermission.maritalStatus == 'TRUE' ? '' : 'disabled'}>
										<option value="">Select marital status...</option>
										<c:forEach var="maritalStatus" items="${maritalStatuses}">
							                <c:choose>
								                <c:when test="${member.maritalStatus == maritalStatus.name }">
								                	<option value="${maritalStatus.name}" selected="selected">
									                    ${maritalStatus.name}
									                </option>
								                </c:when>
								                <c:otherwise>
								                	<option value="${maritalStatus.name}">
									                    ${maritalStatus.name}
									                </option>
								                </c:otherwise>
								            </c:choose>
							            </c:forEach>
									</select>
									</div>
								</div>
								<div class="form-group">
									<label for="idNumber" class="col-sm-6 control-label">ID/Passport
										Number:</label>
									<div class="col-sm-6">
									<input type="text" name="idNumber" class="form-control  input-sm"
										id="idNumber" value="${ member.idNumber }" placeholder="ID/Passport Number" ${memberPermission.idNumber == 'TRUE' ? '' : 'disabled'}>
									</div>
								</div>
							</fieldset>
						</div>
						<div class="col-md-6">
							<fieldset>
								<legend>
									<i class="fa fa-phone"></i> &nbsp;Contact
								</legend>
								<div class="form-group">
									<label for="emailAddress" class="col-sm-6 control-label">Email
										Address:</label>
									<div class="col-sm-6"><input type="text" name="emailAddress"
										class="form-control  input-sm" id="emailAddress"
										placeholder="Email Address" value="${ member.emailAddress }" ${memberPermission.emailAddress == 'TRUE' ? '' : 'disabled'}>
									</div>
								</div>
								<div class="form-group">
									<label for="phoneNumber" class="col-sm-6 control-label">Phone
										Number:</label>
									<div class="col-sm-6"><input type="text" name="phoneNumber"
										class="form-control  input-sm" id="phoneNumber" value="${ member.phoneNumber }" placeholder="Phone Number" ${memberPermission.phoneNumber == 'TRUE' ? '' : 'disabled'}>
									</div>
								</div>
								<div class="form-group">
									<label for="postalAddress" class="col-sm-6 control-label">Postal Address:</label>
									<div class="col-sm-6"><input type="text" name="postalAddress"
										class="form-control  input-sm" id="postalAddress"
										placeholder="Postal Address" value="${ member.postalAddress }" ${memberPermission.postalAddress == 'TRUE' ? '' : 'disabled'}>
									</div>
								</div>
								<div class="form-group">
									<label for="city" class="col-sm-6 control-label">City Or Town:</label>
									<div class="col-sm-6"><input
										type="text" value="${ member.town }" name="city" class="form-control  input-sm" id="city"
										placeholder="City or Town" ${memberPermission.town == 'TRUE' ? '' : 'disabled'}>
									</div>
								</div>
								<div class="form-group">
									<label for="country" class="col-sm-6 control-label">Country:</label>
									<div class="col-sm-6"><select
										name="country" id="country" class="form-control  input-sm" ${memberPermission.country == 'TRUE' ? '' : 'disabled'}>
										<option value="">Select country...</option>
										<c:forEach var="country" items="${countries}">
							                <c:choose>
								                <c:when test="${member.country == country.name }">
									                <option selected="selected">
									                    ${country.name}
									                </option>
								                </c:when>
								                <c:otherwise>
									                <option>
									                    ${country.name}
									                </option>
								                </c:otherwise>
								            </c:choose>
							            </c:forEach>
									</select>
									</div>
								</div>
							</fieldset>
						</div>
				</div>
				<div class="row">
						<div class="col-md-6">
							<fieldset>
								<legend>
									<i class="fa fa-user"></i> &nbsp;Other Details
								</legend>
								<div class="form-group">
									<label for="memberNo" class="col-sm-6 control-label">Member No:</label>
									<div class="col-sm-6"><input
										type="text" name="memberNo" class="form-control  input-sm" id="memberNo"
										placeholder="Member No" value="${ member.memberNo }"  ${memberPermission.memberNo == 'TRUE' ? '' : 'disabled'}>
									</div>
								</div>
								<div class="form-group">
									<label for="partnerNumber" class="col-sm-6 control-label">Partner Number:</label>
									<div class="col-sm-6"><input type="text" readonly="readonly" name="partnerNumber"
										class="form-control  input-sm" id="partnerNumber"
										placeholder="Partner Number" value="${ member.partnerNo }" ${memberPermission.dateOfBirth == 'TRUE' ? '' : 'disabled'}>
									</div>
								</div>
								<div class="form-group">
									<label for="partyRefNo" class="col-sm-6 control-label">Party Ref. No.:</label>
									<div class="col-sm-6">
									<input type="text" name="partyRefNo" id="partyRefNo" placeholder="Party Ref. No" class="form-control  input-sm" value="${ member.partyRefNo }" ${memberPermission.partyRefNo == 'TRUE' ? '' : 'disabled'}/>
									</div>
								</div>
								<div class="form-group">
									<label for="pinNo" class="col-sm-6 control-label">TAX Number:</label>
									<div class="col-sm-6">
									<input type="text" name="pinNo" id="pinNo" placeholder="PIN Number" class="form-control  input-sm" value="${ member.pinNo }" ${memberPermission.pinNo == 'TRUE' ? '' : 'disabled'}/>
									</div>
								</div>
								<!--<div class="form-group">
									<label for="currentAnnualPensionableSalary" class="col-sm-6 control-label">Annual Pen. Sal:</label>
									<div class="col-sm-6"><input type="text" name="currentAnnualPensionableSalary" class="form-control  input-sm"
										id="currentAnnualPensionableSalary" value="${ member.annualPensionableSalary }" placeholder="Annual Pensionable Salary" ${memberPermission.annualPensionableSalary == 'TRUE' ? '' : 'disabled'}>
									</div>
								</div>
								<div class="form-group">
									<label for="staffNo" class="col-sm-6 control-label">Staff Number:</label>
									<div class="col-sm-6">
									<input type="text" name="staffNo" id="staffNo" placeholder="Staff Number" class="form-control  input-sm" value="${ member.staffNo }" ${memberPermission.staffNo == 'TRUE' ? '' : 'disabled'}/>
									</div>
								</div>-->
								<div class="form-group">
									<label for="policyNo" class="col-sm-6 control-label">Policy Number:</label>
									<div class="col-sm-6">
									<input type="text" name="policyNo" id="policyNo" placeholder="Policy Number" class="form-control  input-sm" value="${ member.policyNo }" ${memberPermission.policyNo == 'TRUE' ? '' : 'disabled'}/>
									</div>
								</div>
								<div class="form-group">
									<label for="attachment" class="col-sm-6 control-label">Upload Document:</label>
									<div class="col-sm-6">
										<input type="file" id="attachment" name="attachment" class="filestyle">
									</div>
								</div>
							</fieldset>
						</div>
						<div class="col-md-6">
							<fieldset>
								<legend>
									<i class="fa fa-user"></i> &nbsp;Beneficiaries
								</legend>
								<table class="table table-responsive table-striped">
									<tr><th>NAME</th><th>RELATIONSHIP</th><th>ENTITLEMENT</th><th>ACTIONS</th></tr>
									<c:forEach var="beneficiary" items="${ beneficiaries }">
										<tr><td> ${beneficiary.surname } ${ beneficiary.firstname } ${ beneficiary.othernames }</td>
											<td>${ beneficiary.relationship }</td><td>${ beneficiary.lumpsumEntitlement }</td>
											<td><a class="btn btn-warning btn-sm" href="javascript:void(0);"  onclick="edit_beneficiary('${ beneficiary.id }')">
												<i class="glyphicon glyphicon-pencil"></i>&nbsp;EDIT</a>&nbsp;

												<a class="btn btn-sm btn-info" href="javascript:void(0);" onclick="view_beneficiary('${beneficiary.id}')">
													<i class="glyphicon glyphicon-eye-open">&nbsp;VIEW</i></a>
											</td></tr>
									</c:forEach>
								</table>
								<a class="btn btn-success btn-sm" href="javascript:void(0);" onclick="add_beneficiary();">ADD BENEFICIARY</a>
							</fieldset>
						</div>
				</div>
				<button class="btn btn-primary">UPDATE DETAILS</button>
			</form>
			</div>
			<script type="text/javascript">
				function add_beneficiary()
				{
					start_wait();
					$.ajax({
				        url: $('#base_url').val() + 'admin',
				        type: 'post',
				        data: {ACTION:'GET_BENEFICIARY', memberID: $('#member_id').val(), type: 'ADD'},
				        dataType: 'html',
				        success: function(html) {
							stop_wait();
							$('#modal-edit-beneficiary').modal('show');
							$('#beneficiary-content').html(html);

				        }
					});
				}
				function edit_beneficiary(id)
				{
					start_wait();
					$.ajax({
				        url: $('#base_url').val() + 'admin',
				        type: 'post',
				        data: {ACTION:'GET_BENEFICIARY', beneficiaryID: id, memberID: $('#member_id').val(), type: 'EDIT'},
				        dataType: 'html',
				        success: function(html) {
							stop_wait();
							$('#modal-edit-beneficiary').modal('show');
							$('#beneficiary-content').html(html);

				        }
					});
				}

				function view_beneficiary(id)
				{
					start_wait();
					$.ajax({
						url: $('#base_url').val() + 'admin',
						type: 'post',
						data: {ACTION:'VIEW_BENEFICIARY', beneficiaryID: id, memberID: $('#member_id').val()},
						dataType: 'html',
						success: function(html) {
							$('#beneficiary-content2').html(html);
							$('#modal-view-beneficiary').modal('show');

							stop_wait();
						}
					});
				}

				$(document).ready(function(){
					$('#pi-form')
					.bootstrapValidator(
							{
						        excluded: ':disabled',
								message : 'This value is not valid',
								feedbackIcons : {
									valid : 'glyphicon glyphicon-ok',
									invalid : 'glyphicon glyphicon-remove',
									validating : 'glyphicon glyphicon-refresh'
								},
								fields : {
									firstname : {
										validators : {
											notEmpty : {
												message : 'Please enter your firstname'
											}
										}
									},
									surname : {
										validators : {
											notEmpty : {
												message : 'Please enter your surname'
											}
										}
									},
									othernames : {
										validators : {
											notEmpty : {
												message : 'Please enter your other names'
											}
										}
									},
									currentAnnualPensionableSalary: {
										validators : {
											notEmpty : {
												message : 'Please enter your current salary'
											}
										}
									},
									gender : {
										validators : {
											notEmpty : {
												message : 'Please select your gender'
											}
										}
									},
									dateOfBirth: {
										validators : {
											notEmpty : {
												message : 'Please select your date of birth'
											}
										}
									},
									idNumber : {
										validators : {
											notEmpty : {
												message : 'Please enter your ID Number'
											}
										}
									},
									emailAddress : {
										validators : {
											notEmpty : {
												message : 'Please enter your email address'
											}
										}
									},
									maritalStatus: {
										validators : {
											notEmpty : {
												message : 'Please select the marital status'
											}
										}
									},
									phoneNumber: {
										validators : {
											notEmpty : {
												message : 'Please enter your phone number'
											}
										}
									},
									postalAddress: {
										validators : {
											notEmpty : {
												message : 'Please select your postal/residential address'
											}
										}
									},
									city : {
										validators : {
											notEmpty : {
												message : 'Please enter your town/city'
											}
										}
									},
									country : {
										validators : {
											notEmpty : {
												message : 'Please select your country'
											}
										}
									},
									file: {
										validators : {
											extension: 'jpeg,jpg,png,doc,docx,pdf,xls,txt',
											type: 'image/jpeg,image/png,application/msword,application/pdf,application/vnd.ms-excel,',
											maxSize: 2097152,   // 2048 * 1024
											message: 'The selected file is not valid'
										}
									}
								}
							})
					.on(
							'success.form.bv',
							function(e) {
								start_wait();
								// Prevent form submission
								e.preventDefault();

								// Get the form instance
								var form = "pi-form";
								var formData = new FormData($(this)[0]);

								memberID = $('#member_id').val();
								formData.append("memberID", memberID);

								memberNo = $('#member_no').val();
								formData.append("memberNo", memberNo);

								$.ajax({
											url : $('#base_url').val() + 'admin',
											type : 'post',
											data: formData,
											/*data : {
												ACTION: 'UPDATE_MEMBER',
												memberID: $('#member_id')
														.val(),
												memberNo: $('#member_no')
														.val(),
												firstname : $('#firstname')
														.val(),
												surname : $('#surname')
														.val(),
												othernames : $('#otherNames')
														.val(),
												gender: $('#gender')
														.val(),
												idNumber: $('#idNumber')
														.val(),
												dateOfBirth: $('#dateOfBirth')
														.val(),
												emailAddres: $('#emailAddress')
														.val(),
												maritalStatus: $("#maritalStatus")
														.val(),
												phoneNumber: $('#phoneNumber')
														.val(),
												postalAddress: $('#postalAddress')
														.val(),
												city: $('#city')
														.val(),
												country: $('#country')
														.val(),
												currentAnnualPensionableSalary: $('#currentAnnualPensionableSalary')
														.val()
											},*/
											dataType : 'json',
											cache: false,
											contentType: false,
											processData: false,
											success : function(json) {
												stop_wait();
													bootbox
															.alert('<p class="text-center">'
																	+ json.message
																	+ '</p>');
											}
										});
							});
					$('#form-edit-beneficiary')
					.bootstrapValidator(
							{
						        excluded: ':disabled',
								message : 'This value is not valid',
								feedbackIcons : {
									valid : 'glyphicon glyphicon-ok',
									invalid : 'glyphicon glyphicon-remove',
									validating : 'glyphicon glyphicon-refresh'
								},
								fields : {
									firstname : {
										validators : {
											notEmpty : {
												message : 'Please enter the firstname'
											}
										}
									},
									surname : {
										validators : {
											notEmpty : {
												message : 'Please enter the surname'
											}
										}
									},
									othernames : {
										validators : {
											notEmpty : {
												message : 'Please enter the othername'
											}
										}
									},
									lumpsumEntitlement : {
										validators : {
											notEmpty : {
												message : 'Please enter the lumpsum entitlement'
											}
										}
									},
									gender : {
										validators : {
											notEmpty : {
												message : 'Please select the gender'
											}
										}
									},
									relationship : {
										validators : {
											notEmpty : {
												message : 'Please select the relationship'
											}
										}
									},
									relationshipCategory : {
										validators : {
											notEmpty : {
												message : 'Please select the relationship category'
											}
										}
									},
									maritalStatus: {
										validators : {
											notEmpty : {
												message : 'Please select the marital status'
											}
										}
									},
									status: {
										validators : {
											notEmpty : {
												message : 'Please select the status'
											}
										}
									},
									 file: {
										 validators : {
					                        extension: 'jpeg,jpg,png,doc,docx,pdf,xls,txt',
					                        type: 'image/jpeg,image/png,application/msword,application/pdf,application/vnd.ms-excel,',
					                        maxSize: 2097152,   // 2048 * 1024
					                        message: 'The selected file is not valid'
					                    }
									 }
								}
							})

							.on( 'success.form.bv', function(e) {
								start_wait();
									// Prevent form submission
									e.preventDefault();

									// Get the form instance
										var modal = "modal-edit-beneficiary";
									
									//Define formData object
										var formData = new FormData($(this)[0]);
									
										type = $('#type').val();
										formData.append("type", type);
										
										memberID = $('#member_id').val();
										formData.append("memberID", memberID);
										
										beneficiary_id = $('#beneficiary_id').val();
										formData.append("beneficiary_id", beneficiary_id);
										
										firstname = $('#firstName').val();
										formData.append("firstname", firstname);
										
										//firstname = $('#firstname').val();
										//formData.append("firstname", firstname);
											
												$.ajax({
													url : $('#base_url').val() + 'admin',
													type : 'post',
													data: formData,
													dataType : 'json',
													success : function(json) {
														stop_wait();
															if(json.success)
															{
																$('form#form-edit-beneficiary')[0].reset();
																$('#modal-edit-beneficiary').modal('hide');
															}
															bootbox
																	.alert('<p class="text-center">'
																			+ json.message
																			+ '</p>');
													},
													cache: false,
								        	        contentType: false,
								        	        processData: false
												});
									});
				});
			</script>


<div class="modal fade" id="modal-view-beneficiary" tabindex="-1" role="dialog" aria-labelledby="myModalLabelViewBeneficiary" aria-hidden="true">
	<form role="form" id="form-view-beneficiary">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" id="myModalLabelViewMember">
						<i class="glyphicon glyphicon-picture"></i>&nbsp;&nbsp;VIEW BENEFICIARY DETAILS
					</h4>
				</div>
				<div class="modal-body" id="beneficiary-content2">

				</div>
			</div>
		</div>
	</form>
</div>

<div class="modal fade" id="modal-edit-beneficiary" tabindex="-1" role="dialog" aria-labelledby="myModalLabelEditBeneficiary" aria-hidden="true">
	<form role="form" id="form-edit-beneficiary" enctype="multipart/form-data">
		<div class="modal-dialog large-modal">
			<div class="modal-content">
				<div class="modal-header">
	                  <button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" id="myModalLabelEditBeneficiary">
						<i class="glyphicon glyphicon-picture"></i>&nbsp;&nbsp;BENEFICIARY DETAILS
					</h4>
				</div>
				<div class="modal-body" id="beneficiary-content">

				</div>

				<div class="modal-footer">
					<a href="#" class="btn btn-warning" data-dismiss="modal">Cancel</a>
					<input class="btn btn-primary" type="submit"
						value="Save Beneficiary Details" id="btn-beneficiary">
				</div>
			</div>
		</div>
	</form>
</div>
