<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2 class="text-center">
	<small>USER ACCESS CONTROL</small>
</h2>
	<ul class="nav">
		<c:if test="${ permissions.member_edit_permissions }">
		<li id="member-permissions-li"><a href="javascript:void(0);"><i
				class="glyphicon glyphicon-dashboard"></i>&nbsp;<i
				class="fa fa-chevron-right"></i> MEMBER EDIT PERMISSIONS</a></li>
		</c:if>
		<c:if test="${ permissions.profile_login_username }">
		<li id="profile-login-li"><a href="javascript:void(0);"><i
				class="glyphicon glyphicon-lock"></i>&nbsp;<i
				class="fa fa-chevron-right"></i> PROFILE LOGIN FIELDS</a></li>
		</c:if>
		<c:if test="${ permissions.profile_names }">
		<li id="profile-names-li"><a href="javascript:void(0);"><i
				class="glyphicon glyphicon-lock"></i>&nbsp;<i
				class="fa fa-chevron-right"></i> PROFILE NAMES</a></li>
		</c:if>
		<c:if test="${ permissions.scheme_managers }">
		<li id="scheme-managers-li"><a href="javascript:void(0);"><i
				class="glyphicon glyphicon-lock"></i>&nbsp;<i
				class="fa fa-chevron-right"></i> SCHEME MANAGERS</a></li>
		</c:if>
		<c:if test="${ permissions.users }">
		<li id="users-li"><a href="javascript:void(0);"><i
				class="glyphicon glyphicon-lock"></i>&nbsp;<i
				class="fa fa-chevron-right"></i> PORTAL USERS</a></li>
		</c:if>
		<c:if test="${ permissions.password_policy }">
		<li id="password-policy-li"><a href="javascript:void(0);"><i
				class="glyphicon glyphicon-lock"></i>&nbsp;<i
				class="fa fa-chevron-right"></i> PASSWORD POLICY</a></li>
		</c:if>
		<c:if test="${ permissions.audit_trail }">
		<li id="audit-trail-li"><a href="javascript:void(0);"><i
				class="glyphicon glyphicon-lock"></i>&nbsp;<i
				class="fa fa-chevron-right"></i> AUDIT TRAIL</a></li>
		</c:if>
	</ul>
	
	
	<div class="modal fade" id="modal-profile-names" tabindex="-1" role="dialog" aria-labelledby="myModalLabelProfileNames" aria-hidden="true">
		<form role="form" id="form-profile-names">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabelProfileNames">
							<i class="glyphicon glyphicon-pushpin"></i>&nbsp;&nbsp;PROFILE NAMES
						</h4>
					</div>
					<div class="modal-body">
						<table class="table">
							<tr><th>PROFILE</th><th>NAME TO USE</th></tr>
							<c:forEach var="pn" items="${profileNames}">
								<tr>
								<td>
								 <label class="control-label">${ pn.profile }</label>
								</td>
								<td>
								 <input type="text" class="form-control" id="${pn.profile }_NAME" name="${pn.profile }_NAME" value="${pn.name }"/>
								</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div class="modal-footer">
						<a href="#" class="btn btn-warning" data-dismiss="modal">Cancel</a>
						<input class="btn btn-primary" type="submit"
							value="Save Settings" id="btn-profile-names">
					</div>
				</div>
			</div>
		</form>
	</div>
	
	
	<div class="modal fade" id="modal-profile-login" tabindex="-1" role="dialog" aria-labelledby="myModalLabelProfileLogin" aria-hidden="true">
		<form role="form" id="form-profile-login">
			<input type="hidden" name="ACTION" id="ACTION" value="PLF" />
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabelProfileLogin">
							<i class="glyphicon glyphicon-pushpin"></i>&nbsp;&nbsp;PROFILE LOGIN FIELD
						</h4>
					</div>
					<div class="modal-body">
						<table class="table">
							<tr><th>PROFILE</th><th>LOGIN FIELD (USERNAME)</th><th>PORTAL ACCESS</th></tr>
							<c:forEach var="plf" items="${plfs}">
								<tr>
								<td>
								 <label class="control-label">${ plf.profile }</label>
								</td>
								<td>
								 <select class="form-control" id="${ plf.profile }">
									<c:forEach var="ordinal" items="${ordinals}">
										<c:choose>
											<c:when test="${plf.ordinal == ordinal.code }">
												<option selected="selected">${ ordinal.code }</option>
											</c:when>
											<c:otherwise>
												<option>${ ordinal.code }</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								 </select>
								</td>
								<td>
									 <select class="form-control" name="${ plf.profile }_published" id="${ plf.profile }_published">
									 <c:choose>
									 	 <c:when test="${plf.published }">
										 	<option value="true" selected="selected">Allowed</option>									  
										  </c:when>
										  <c:otherwise>
										  	<option value="true">Allowed</option>	
										  </c:otherwise>
									 </c:choose>
									  
									 <c:choose>
									 	 <c:when test="${plf.published == 'FALSE'}">
										 	<option value="false" selected="selected">Disallowed</option>									  
										  </c:when>
										  <c:otherwise>
										  	<option value="false">Disallowed</option>	
										  </c:otherwise>
									 </c:choose>
									 </select>
								</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div class="modal-footer">
						<a href="#" class="btn btn-warning" data-dismiss="modal">Cancel</a>
						<input class="btn btn-primary" type="submit"
							value="Save Settings" id="btn-profile-login">
					</div>
				</div>
			</div>
		</form>
	</div>
	
	<div class="modal fade" id="modal-password-policy" tabindex="-1" role="dialog" aria-labelledby="myModalLabelPasswordPolicy" aria-hidden="true">
		<form role="form" id="form-password-policy">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabelPasswordPolicy">
							<i class="glyphicon glyphicon-lock"></i>&nbsp;&nbsp;PASSWORD POLICY SETTINGS
						</h4>
					</div>
					<div class="modal-body">
					<input type="hidden" id="password_policy_id" name="password_policy_id" value="${ policy.id }" />
						<table class="table">
							<tr>
							<td>
							 <label class="control-label">Password Length (Characters)</label>
							</td>
							<td>
							 <input type="text" class="form-control" name="length" id="length" value="${ policy.length }" />
							</td>
							</tr>
							<tr>
							<td>
							 <label class="control-label">Password Expires In? (days)</label>
							</td>
							<td>
							 <input type="text" class="form-control" name="expiry_days" id="expiry_days"  value="${ policy.expiry_days }" />
							</td>
							</tr>
							<tr>
							<td>
							 <label class="control-label">Must have uppercase letter?</label>
							</td>
							<td>
							 <select class="form-control" name="uppercase" id="uppercase">
							 	<c:choose>
							 		<c:when test="${ policy.uppercase == 'TRUE' }">
								 		<option value="true" selected="selected">Yes</option>
								 		<option value="false">No</option>
								 	</c:when>
								 	<c:otherwise>
								 		<option value="true">Yes</option>
								 		<option value="false" selected="selected">No</option>
								 	</c:otherwise>
							 	</c:choose>
							 </select>
							</td>
							</tr>
							<tr>
							<td>
							 <label class="control-label">Must have lowercase letter?</label>
							</td>
							<td>
							 <select class="form-control" name="lowercase" id="lowercase">
							 	<c:choose>
							 		<c:when test="${ policy.lowercase == 'TRUE' }">
								 		<option value="true" selected="selected">Yes</option>
								 		<option value="false">No</option>
								 	</c:when>
								 	<c:otherwise>
								 		<option value="true">Yes</option>
								 		<option value="false" selected="selected">No</option>
								 	</c:otherwise>
							 	</c:choose>
							 </select>
							</td>
							</tr>
							<tr>
							<td>
							 <label class="control-label">Must have at least a number?</label>
							</td>
							<td>
							 <select class="form-control" name="number" id="number">
							 	<c:choose>
							 		<c:when test="${ policy.numbers == 'TRUE' }">
								 		<option value="true" selected="selected">Yes</option>
								 		<option value="false">No</option>
								 	</c:when>
								 	<c:otherwise>
								 		<option value="true">Yes</option>
								 		<option value="false" selected="selected">No</option>
								 	</c:otherwise>
							 	</c:choose>
							 </select>
							</td>
							</tr>
							<tr>
							<td>
							 <label class="control-label">Lock user account after how many failed attempts?</label>
							</td>
							<td>
							 <input type="text" class="form-control" name="lock_after_count_of" id="lock_after_count_of" value="${ policy.lock_after_count_of }" />
							</td>
							</tr>
							<tr>
							<td>
							 <label class="control-label">Allow for password re-use?</label>
							</td>
							<td>
							 <select class="form-control" name="password_reuse" id="password_reuse">
							 	<c:choose>
							 		<c:when test="${ policy.password_reuse == 'TRUE' }">
								 		<option value="true" selected="selected">Yes</option>
								 		<option value="false">No</option>
								 	</c:when>
								 	<c:otherwise>
								 		<option value="true">Yes</option>
								 		<option value="false" selected="selected">No</option>
								 	</c:otherwise>
							 	</c:choose>
							 </select>
							</td>
							</tr>
						</table>
					</div>
					<div class="modal-footer">
						<a href="#" class="btn btn-warning" data-dismiss="modal">Cancel</a>
						<input class="btn btn-primary" type="submit"
							value="Save Settings" id="btn-save-settings">
					</div>
			</div>
		</div>
	</form>
</div>
	<div class="modal fade" id="modal-member-permissions" tabindex="-1" role="dialog" aria-labelledby="myModalLabelMemberPermission" aria-hidden="true">
		<form role="form" id="form-member-permissions">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabelMemberPermission">
							<i class="glyphicon glyphicon-pencil"></i>&nbsp;&nbsp;MEMBER PROFILE EDIT PERMISSIONS
						</h4>
					</div>
					<div class="modal-body">
						<input type="hidden" name="member_permission_id" value="${ memberPermission.id }" id="member_permission_id"/>
						<table class="table">
							<tr><th>FIELD</th><th>CAN EDIT</th></tr>
							<tr>
							<td>
							 <label class="control-label">NAME</label>
							</td>
							<td>
							 <input type="checkbox" name="name" id="name" ${memberPermission.name == 'TRUE' ? 'checked' : ''}/>
							</td>
							</tr>
							<tr>
							<td>
							 <label class="control-label">DATE OF BIRTH</label>
							</td>
							<td>
							 <input type="checkbox" name="dateOfBirth" id="dateOfBirth" ${memberPermission.dateOfBirth == 'TRUE' ? 'checked' : ''}/>
							</td>
							</tr>
							<tr>
							<td>
							 <label class="control-label">GENDER</label>
							</td>
							<td>
							 <input type="checkbox" name="gender" id="gender" ${memberPermission.gender == 'TRUE' ? 'checked' : ''}/>
							</td>
							</tr>
							<tr>
							<td>
							 <label class="control-label">MARITAL STATUS</label>
							</td>
							<td>
							 <input type="checkbox" name="maritalStatus" id="maritalStatus" ${memberPermission.maritalStatus == 'TRUE' ? 'checked' : ''}/>
							</td>
							</tr>
							<tr>
							<td>
							 <label class="control-label">ID/PPT NUMBER</label>
							</td>
							<td>
							 <input type="checkbox" name="idNumber" id="idNumber" ${memberPermission.idNumber == 'TRUE' ? 'checked' : ''}/>
							</td>
							</tr>
							<tr>
							<td>
							 <label class="control-label">EMAIL ADDRESS</label>
							</td>
							<td>
							 <input type="checkbox" name="emailAddress" id="emailAddress" ${memberPermission.emailAddress == 'TRUE' ? 'checked' : ''}/>
							</td>
							</tr>
							<tr>
							<td>
							 <label class="control-label">PHONE NUMBER</label>
							</td>
							<td>
							 <input type="checkbox" name="phoneNumber" id="phoneNumber" ${memberPermission.phoneNumber == 'TRUE' ? 'checked' : ''}/>
							</td>
							</tr>
							<tr>
							<td>
							 <label class="control-label">POSTAL ADDRESS</label>
							</td>
							<td>
							 <input type="checkbox" name="postalAddress" id="postalAddress" ${memberPermission.postalAddress == 'TRUE' ? 'checked' : ''}/>
							</td>
							</tr>
							<tr>
							<td>
							 <label class="control-label">CITY OR TOWN</label>
							</td>
							<td>
							 <input type="checkbox" name="city" id="city" ${memberPermission.town == 'TRUE' ? 'checked' : ''}/>
							</td>
							</tr>
							<tr>
							<td>
							 <label class="control-label">COUNTRY</label>
							</td>
							<td>
							 <input type="checkbox" name="country" id="country" ${memberPermission.country == 'TRUE' ? 'checked' : ''}/>
							</td>
							</tr>
							<tr>
							<td>
							 <label class="control-label">MEMBER NUMBER</label>
							</td>
							<td>
							 <input type="checkbox" name="memberNo" id="memberNo" ${memberPermission.memberNo == 'TRUE' ? 'checked' : ''}/>
							</td>
							</tr>
							<tr>
							<td>
							 <label class="control-label">PARTNER NUMBER</label>
							</td>
							<td>
							 <input type="checkbox" name="partnerNo" id="partnerNo" ${memberPermission.partnerNo == 'TRUE' ? 'checked' : ''}/>
							</td>
							</tr>
							<tr>
							<td>
							 <label class="control-label">PARTY REF NUMBER</label>
							</td>
							<td>
							 <input type="checkbox" name="partyRefNo" id="partyRefNo" ${memberPermission.partyRefNo == 'TRUE' ? 'checked' : ''}/>
							</td>
							</tr>
							<tr>
							<td>
							 <label class="control-label">PIN NUMBER</label>
							</td>
							<td>
							 <input type="checkbox" name="pinNo" id="pinNo" ${memberPermission.pinNo == 'TRUE' ? 'checked' : ''}/>
							</td>
							</tr>
							<tr>
							<td>
							 <label class="control-label">ANNUAL PENSIONABLE SALARY</label>
							</td>
							<td>
							 <input type="checkbox" name="annualPensionableSalary" id="annualPensionableSalary" ${memberPermission.annualPensionableSalary == 'TRUE' ? 'checked' : ''}/>
							</td>
							</tr>
							<tr>
							<td>
							 <label class="control-label">STAFF NUMBER</label>
							</td>
							<td>
							 <input type="checkbox" name="staffNo" id="staffNo" ${memberPermission.staffNo == 'TRUE' ? 'checked' : ''}/>
							</td>
							</tr>
							<tr>
							<td>
							 <label class="control-label">POLICY NUMBER</label>
							</td>
							<td>
							 <input type="checkbox" name="policyNo" id="policyNo" ${memberPermission.policyNo == 'TRUE' ? 'checked' : ''}/>
							</td>
							</tr>
						</table>
					</div>
					<div class="modal-footer">
						<a href="#" class="btn btn-warning" data-dismiss="modal">Cancel</a>
						<input class="btn btn-primary" type="submit"
							value="Save Permissions" id="btn-member-permissions">
					</div>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){


			function load_dashboard(MODULE)
			{
				start_wait();
				$.ajax({
		            url: $('#base_url').val() + 'dashboard',
		            type: 'get',
		            data: {dashboard: MODULE},
		            dataType: 'html',
		            success: function(html) {
		                $('#dashboard').fadeOut('slow', function() {
		                		stop_wait();
		                	$('#dashboard').html(html);
		                	$('#dashboard').fadeIn('slow');
		                	stop_wait();
		                });
		            }
		        });
			}
			$('#form-profile-login').bootstrapValidator({
		        message: 'This value is not valid',
		        feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
		        },
		        fields: {
		           
		        }
			})
			.on('success.form.bv', function(e) {
                
                // Prevent form submission
                e.preventDefault();

                var btn = "btn-profile-login";
                var form = "form-profile-login";
                var modal = "modal-profile-login";
                var btn_text = $('#' + btn).val();

                $('#' + btn).val('Please wait...');
        		$.ajax({
        	        url: $('#base_url').val() + 'admin',
        	        type: 'post',
        	        data: {ACTION: 'PROFILE_LOGIN_FIELD', MEMBER: $('#MEMBER').val(), MEMBER_PUBLISHED: $('#MEMBER_published').val(), ADMINISTRATOR: $('#ADMINISTRATOR').val(), ADMINISTRATOR_PUBLISHED: $('#ADMINISTRATOR_published').val(), SPONSOR: $('#SPONSOR').val(), SPONSOR_PUBLISHED: $('#SPONSOR_published').val(), TRUSTEE: $('#TRUSTEE').val(), TRUSTEE_PUBLISHED: $('#TRUSTEE_published').val(), AGENT: $('#AGENT').val(), AGENT_PUBLISHED: $('#AGENT_published').val(), CUSTODIAN: $('#CUSTODIAN').val(), CUSTODIAN_PUBLISHED: $('#CUSTODIAN_published').val(), CUSTOMER_RELATIONSHIP_MANAGER: $('#CUSTOMER_RELATIONSHIP_MANAGER').val(), CUSTOMER_RELATIONSHIP_MANAGER_PUBLISHED: $('#CUSTOMER_RELATIONSHIP_MANAGER_published').val(), CUSTOMER_RELATIONSHIP_EXECUTIVE: $('#CUSTOMER_RELATIONSHIP_EXECUTIVE').val(), CUSTOMER_RELATIONSHIP_EXECUTIVE_PUBLISHED: $("#CUSTOMER_RELATIONSHIP_EXECUTIVE_published").val(), FUND_MANAGER: $('#FUND_MANAGER').val(), FUND_MANAGER_PUBLISHED: $('#FUND_MANAGER_published').val(), PENSIONER: $('#PENSIONER').val(), PENSIONER_PUBLISHED: $("#PENSIONER_published").val()},
        	        dataType: 'html',
        	        success: function(html) {
        	            $('#' + btn).val('Done');
        	            if(html == 'true')
        	            {
        	                $('#' + form)[0].reset();
        	                $('#' + modal).modal('hide');
        	                html = 'Profile login details successfully saved';
        	            }
        	            else
        	                html = 'Profile login details could not be saved';
        	            bootbox.alert(html);
        	            $('#' + btn).val(btn_text);
        	        }
        	    });

			});
			
			$('#form-profile-names').bootstrapValidator({
		        message: 'This value is not valid',
		        feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
		        },
		        fields: {
		           
		        }
			})
			.on('success.form.bv', function(e) {
                
                // Prevent form submission
                e.preventDefault();

                var btn = "btn-profile-names";
                var form = "form-profile-names";
                var modal = "modal-profile-names";
                var btn_text = $('#' + btn).val();

                $('#' + btn).val('Please wait...');
        		$.ajax({
        	        url: $('#base_url').val() + 'admin',
        	        type: 'post',
        	        data: {ACTION: 'PROFILE_NAMES', MEMBER: $('#MEMBER_NAME').val(), ADMINISTRATOR: $('#ADMINISTRATOR_NAME').val(), SPONSOR: $('#SPONSOR_NAME').val(), TRUSTEE: $('#TRUSTEE_NAME').val(), AGENT: $('#AGENT_NAME').val(), CUSTODIAN: $('#CUSTODIAN_NAME').val(), CUSTOMER_RELATIONSHIP_MANAGER: $('#CUSTOMER_RELATIONSHIP_MANAGER_NAME').val(), CUSTOMER_RELATIONSHIP_EXECUTIVE: $('#CUSTOMER_RELATIONSHIP_EXECUTIVE_NAME').val(), FUND_MANAGER: $('#FUND_MANAGER_NAME').val(), PENSIONER: $('#PENSIONER_NAME').val()},
        	        dataType: 'html',
        	        success: function(html) {
        	            $('#' + btn).val('Done');
        	            if(html == 'true')
        	            {
        	                $('#' + form)[0].reset();
        	                $('#' + modal).modal('hide');
        	                html = 'Profile names successfully saved';
        	            }
        	            else
        	                html = 'Profile names could not be saved';
        	            bootbox.alert(html);
        	            $('#' + btn).val(btn_text);
        	        }
        	    });

			});



			$('#form-password-policy').bootstrapValidator({
		        message: 'This value is not valid',
		        feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
		        },
		        fields: {
		           
		        }
			})
			.on('success.form.bv', function(e) {
                
                // Prevent form submission
                e.preventDefault();

                var btn = "btn-password-policy";
                var form = "form-password-policy";
                var modal = "modal-password-policy";
                var btn_text = $('#' + btn).val();

                $('#' + btn).val('Please wait...');
        		$.ajax({
        	        url: $('#base_url').val() + 'admin',
        	        type: 'post',
        	        data: {password_policy_id: $('#password_policy_id').val(), ACTION: 'SET_PASSWORD_POLICY', length: $('#length').val(), expiry_days: $('#expiry_days').val(), uppercase: $('#uppercase').val(), lowercase: $('#lowercase').val(), numbers: $('#numbers').val(), lock_after_count_of: $('#lock_after_count_of').val(), password_reuse: $('#password_reuse').val() },
        	        dataType: 'json',
        	        success: function(json) {
        	            $('#' + btn).val('Done');
        	            if(json.success)
        	            {
        	                $('#' + form)[0].reset();
        	                $('#' + modal).modal('hide');
        	                html = 'Password policy settings successfully saved';
        	            }
        	            else
        	                html = 'Password policy settings could not be saved';
        	            bootbox.alert(html);
        	            $('#' + btn).val(btn_text);
        	        }
        	    });

			});

			$('#form-member-permissions').bootstrapValidator({
		        message: 'This value is not valid',
		        feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
		        },
		        fields: {
		           
		        }
			})
			.on('success.form.bv', function(e) {
                
                // Prevent form submission
                e.preventDefault();

                var btn = "btn-member-permissions";
                var form = "form-member-permissions";
                var modal = "modal-member-permissions";
                var btn_text = $('#' + btn).val();

                $('#' + btn).val('Please wait...');
        		$.ajax({
        	        url: $('#base_url').val() + 'admin',
        	        type: 'post',
        	        data: {member_permission_id: $('#member_permission_id').val(), ACTION: 'MEMBER_PERMISSION', city: $('#city').prop('checked'), country: $('#country').prop('checked'), dateOfBirth: $('#dateOfBirth').prop('checked'), emailAddress: $('#emailAddress').prop('checked'), gender: $('#gender').prop('checked'), idNumber: $('#idNumber').prop('checked'), maritalStatus: $('#maritalStatus').prop('checked'), name: $('#name').prop('checked'), phoneNumber: $('#phoneNumber').prop('checked'), postalAddress: $('#postalAddress').prop('checked'), annualPensionableSalary: $('#annualPensionableSalary').prop('checked'), memberNo: $('#memberNo').prop('checked'), membershipNo: $('#membershipNo').prop('checked'), partyRefNo: $('#partyRefNo').prop('checked'), pinNo: $('#pinNo').prop('checked'), policyNo: $('#policyNo').prop('checked'), staffNo: $('#staffNo').prop('checked'), town: $('#city').prop('checked'), partnerNo: $('#partnerNo').prop('checked') },
        	        dataType: 'html',
        	        success: function(html) {
        	            $('#' + btn).val('Done');
        	            if(html == 'true')
        	            {
        	                $('#' + form)[0].reset();
        	                $('#' + modal).modal('hide');
        	                html = 'Member permission details successfully saved';
        	            }
        	            else
        	                html = 'Member permission details could not be saved';
        	            bootbox.alert(html);
        	            $('#' + btn).val(btn_text);
        	        }
        	    });

			});
		    
		    $('#member-permissions-li').click(function(){
		        $('#modal-member-permissions').modal('show');
		    });
		    
		    $('#profile-login-li').click(function(){
		        $('#modal-profile-login').modal('show');
		    });
		    
		    $('#profile-names-li').click(function(){
		        $('#modal-profile-names').modal('show');
		    });
		    

		    $('#password-policy-li').click(function(){
		        $('#modal-password-policy').modal('show');
		    });
		    
		    $('#scheme-managers-li').click(function(){
		        load_dashboard('SCHEME_MANAGER');
		    });
		    
		    $('#users-li').click(function(){
		        load_dashboard('USER');
		    });
		    
		    $('#audit-trail-li').click(function(){
		        load_dashboard('AUDIT_TRAIL');
		    });

		    
			});
	</script>