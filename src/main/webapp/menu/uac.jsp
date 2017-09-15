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
		<c:if test="${ permissions.show_db_contribution_graph }">
			<li id="contribution-graph-li"><a href="javascript:void(0);"><i
					class="glyphicon glyphicon-stats"></i>&nbsp;<i
					class="fa fa-chevron-right"></i> DB SCHEME RESTRICTIONS</a></li>
		</c:if>
		<c:if test="${ permissions.member_menu_config }">
			<li id="member-menu-li"><a href="javascript:void(0);"><i
					class="glyphicon glyphicon-stats"></i>&nbsp;<i
					class="fa fa-chevron-right"></i> MEMBER MENU CONFIGURATION</a></li>
		</c:if>

		<c:if test="${ permissions.pensioner_menu_config }">
			<li id="pensioner-menu-li"><a href="javascript:void(0);"><i
					class="glyphicon glyphicon-user"></i>&nbsp;<i
					class="fa fa-chevron-right"></i> PENSIONER MENU CONFIGURATION</a></li>
		</c:if>

		<c:if test="${ permissions.member_dashboard_items }">
			<li id="member-dashboard-li"><a href="javascript:void(0);"><i
					class="glyphicon glyphicon-stats"></i>&nbsp;<i
					class="fa fa-chevron-right"></i> MEMBER DASHBOARD ITEMS</a></li>
		</c:if>
		<c:if test="${ permissions.admin_dashboard_items }">
			<li id="admin-dashboard-items-li"><a href="javascript:void(0);"><i
					class="glyphicon glyphicon-stats"></i>&nbsp;<i
					class="fa fa-chevron-right"></i> ADMIN DASHBOARD ITEMS</a></li>
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

<!-- Sow Contribution Graph -->

<div class="modal fade" id="modal-contribution-graph" tabindex="-1" role="dialog" aria-labelledby="myModalLabelContributionGraph" aria-hidden="true">
	<form role="form" id="form-contribution-graph">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabelContributionGraph">
						<i class="glyphicon glyphicon-stats"></i>&nbsp;&nbsp;HIDE/SHOW DB SCHEME ITEMS
					</h4>
				</div>
				<div class="modal-body">
					<input type="hidden" name="dbGraph_id" value="${ dbContrGraph.id }" id="dbGraph_id"/>
					<table class="table">
						<tr><th>ITEM</th><th>HIDE</th></tr>
						<tr>
							<td>
								<label class="control-label">CONTRIBUTION GRAPH</label>
							</td>
							<td>
								<input type="checkbox" name="contributionGraphActive" id="contributionGraphActive" ${dbContrGraph.contributionGraphActive == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>
						<tr>
							<td>
								<label class="control-label"> CUMMULATIVE INTEREST</label>
							</td>
							<td>
								<input type="checkbox" name="interestActive" id="interestActive" ${dbContrGraph.interestActive == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<a href="#" class="btn btn-warning" data-dismiss="modal">Cancel</a>
					<input class="btn btn-primary" type="submit"
						   value="Save Permissions" id="btn-contribution-graph">
				</div>
			</div>
		</div>
	</form>
</div>
<!-- End Contribution  Graph -->


<!-- Member Menu Start -->

<div class="modal fade" id="modal-member-menu" tabindex="-1" role="dialog" aria-labelledby="myModalLabelMemberMenu" aria-hidden="true">
	<form role="form" id="form-member-menu">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabelMemberMenu">
						<i class="glyphicon glyphicon-stats"></i>&nbsp;&nbsp;HIDE/SHOW MEMBER MENU OPTIONS
					</h4>
				</div>
				<div class="modal-body">
					<input type="hidden" name="memberMenu_id" value="${ memberMenu.id }" id="memberMenu_id"/>
					<table class="table">
						<tr><th>ITEM</th><th>SHOW/HIDE</th></tr>
						<tr>
							<td>
								<label class="control-label">CONTRIBUTION HISTORY (REPORT)</label>
							</td>
							<td>
								<input type="checkbox" name="contributionHistoryReport" id="contributionHistoryReport" ${memberMenu.contributionHistoryReport == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>
						<tr>
							<td>
								<label class="control-label"> CONTRIBUTION HISTORY (GRID)</label>
							</td>
							<td>
								<input type="checkbox" name="contributionHistoryGrid" id="contributionHistoryGrid" ${memberMenu.contributionHistoryGrid == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> UNITIZED STATEMENT </label>
							</td>
							<td>
								<input type="checkbox" name="UnitizedStatement" id="UnitizedStatement" ${memberMenu.unitizedStatement == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> BALANCES HISTORY REPORT</label>
							</td>
							<td>
								<input type="checkbox" name="BalancesHistory" id="BalancesHistory" ${memberMenu.balancesHistory == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> BALANCES HISTORY GRID</label>
							</td>
							<td>
								<input type="checkbox" name="BalancesHistoryGrid" id="BalancesHistoryGrid" ${memberMenu.balancesHistoryGrid == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> STATEMENT OF ACCOUNT (REPORT)</label>
							</td>
							<td>
								<input type="checkbox" name="StatementOfAccount" id="StatementOfAccount" ${memberMenu.statementOfAccount == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> STATEMENT OF ACCOUNT (GRID)</label>
							</td>
							<td>
								<input type="checkbox" name="StatementOfAccountGrid" id="StatementOfAccountGrid" ${memberMenu.statementOfAccountGrid == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> BENEFITS PROJECTION (REPORT) </label>
							</td>
							<td>
								<input type="checkbox" name="benefitsProjection" id="benefitsProjection" ${memberMenu.benefitsProjection == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> BENEFITS PROJECTION (GRID) </label>
							</td>
							<td>
								<input type="checkbox" name="benefitProjectionGrid" id="benefitProjectionGrid" ${memberMenu.benefitProjectionGrid == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> ANNUAL CONTRIBUTION STATEMENT </label>
							</td>
							<td>
								<input type="checkbox" name="annualContributionStatement" id="annualContributionStatement" ${memberMenu.annualContributionStatement == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>
						<tr>
							<td>
								<label class="control-label"> PROVISIONAL MEMBER STATEMENT </label>
							</td>
							<td>
								<input type="checkbox" name="provisionalMemberStatement" id="provisionalMemberStatement" ${memberMenu.provisionalMemberStatement == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> WHAT IF ANALYSIS </label>
							</td>
							<td>
								<input type="checkbox" name="WhatIfAnalysis" id="WhatIfAnalysis" ${memberMenu.whatIfAnalysis == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> MEDIA & FILES </label>
							</td>
							<td>
								<input type="checkbox" name="Media" id="Media" ${memberMenu.media == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

					</table>
				</div>
				<div class="modal-footer">
					<a href="#" class="btn btn-warning" data-dismiss="modal">Cancel</a>
					<input class="btn btn-primary" type="submit"
						   value="Save Permissions" id="btn-member-menu">
				</div>
			</div>
		</div>
	</form>
</div>
<!-- End Member Menu -->

<!-- Pensioner Menu Start -->

<div class="modal fade" id="modal-pensioner-menu" tabindex="-1" role="dialog" aria-labelledby="myModalLabelPensionerMenu" aria-hidden="true">
	<form role="form" id="form-pensioner-menu">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabelPensionerMenu">
						<i class="glyphicon glyphicon-stats"></i>&nbsp;&nbsp;HIDE/SHOW PENSIONER MENU OPTIONS
					</h4>
				</div>
				<div class="modal-body">
					<table class="table">
						<tr><th>ITEM</th><th>SHOW/HIDE</th></tr>
						<tr>
							<td>
								<label class="control-label">PERSONAL INFORMATION</label>
							</td>
							<td>
								<input type="checkbox" name="personalInfo" id="personalInfo" ${pensionerMenu.personalInfo == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>
						<tr>
							<td>
								<label class="control-label"> PENSION DETAILS</label>
							</td>
							<td>
								<input type="checkbox" name="pensionDetails" id="pensionDetails" ${pensionerMenu.pensionDetails == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> PENSION ADVICE (REPORT) </label>
							</td>
							<td>
								<input type="checkbox" name="pensionAdviceReport" id="pensionAdviceReport" ${pensionerMenu.pensionAdviceReport == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> PENSION ADVICE (GRID) </label>
							</td>
							<td>
								<input type="checkbox" name="pensionAdviceGrid" id="pensionAdviceGrid" ${pensionerMenu.pensionAdviceGrid == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> MEDIA & FILES</label>
							</td>
							<td>
								<input type="checkbox" name="media2" id="media2" ${pensionerMenu.media == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

					</table>
				</div>
				<div class="modal-footer">
					<a href="#" class="btn btn-warning" data-dismiss="modal">Cancel</a>
					<input class="btn btn-primary" type="submit"
						   value="Save Permissions" id="btn-pensioner-menu">
				</div>
			</div>
		</div>
	</form>
</div>
<!-- End Pensioner Menu -->

<!-- Member Dashboard Items Start -->

<div class="modal fade" id="modal-dashboard-items" tabindex="-1" role="dialog" aria-labelledby="myModalLabelMemberDashboard" aria-hidden="true">
	<form role="form" id="form-member-dashboard">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabelMemberDashboard">
						<i class="glyphicon glyphicon-stats"></i>&nbsp;&nbsp;HIDE/SHOW MEMBER DETAILS ON DASHBOARD
					</h4>
				</div>
				<div class="modal-body">
					<input type="hidden" name="memberDashboard_id" value="${ memberDashboard.id }" id="memberDashboard_id"/>
					<table class="table">
						<tr><th>ITEM</th><th>SHOW/HIDE</th></tr>
						<tr>
							<td>
								<label class="control-label">NAME</label>
							</td>
							<td>
								<input type="checkbox" name="memberName" id="memberName" ${memberDashboard.name == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>
						<tr>
							<td>
								<label class="control-label"> DATE OF BIRTH</label>
							</td>
							<td>
								<input type="checkbox" name="dateOfBirth2" id="dateOfBirth2" ${memberDashboard.dateOfBirth == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> DATE OF JOINING SCHEME </label>
							</td>
							<td>
								<input type="checkbox" name="dateOfJoiningScheme" id="dateOfJoiningScheme" ${memberDashboard.dateOfJoiningScheme == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> GENDER</label>
							</td>
							<td>
								<input type="checkbox" name="gender2" id="gender2" ${memberDashboard.gender == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> ID NUMBER </label>
							</td>
							<td>
								<input type="checkbox" name="idNumber2" id="idNumber2" ${memberDashboard.idNumber == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> PHONE NUMBER </label>
							</td>
							<td>
								<input type="checkbox" name="phoneNumber2" id="phoneNumber2" ${memberDashboard.phoneNumber == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> EMAIL ADDRESS </label>
							</td>
							<td>
								<input type="checkbox" name="emailAddress2" id="emailAddress2" ${memberDashboard.emailAddress == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> MEMBER NUMBER </label>
							</td>
							<td>
								<input type="checkbox" name="memberNo2" id="memberNo2" ${memberDashboard.memberNo == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> MEMBER ID </label>
							</td>
							<td>
								<input type="checkbox" name="memberId2" id="memberId2" ${memberDashboard.memberId == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> PIN/TAX NUMBER </label>
							</td>
							<td>
								<input type="checkbox" name="pinNumber" id="pinNumber" ${memberDashboard.pinNumber == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> SSNIT NUMBER </label>
							</td>
							<td>
								<input type="checkbox" name="ssnitNumber" id="ssnitNumber" ${memberDashboard.ssnitNumber == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> CITY/TOWN </label>
							</td>
							<td>
								<input type="checkbox" name="town" id="town" ${memberDashboard.town == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

					</table>
				</div>
				<div class="modal-footer">
					<a href="#" class="btn btn-warning" data-dismiss="modal">Cancel</a>
					<input class="btn btn-primary" type="submit"
						   value="Save Permissions" id="btn-dashboard-items">
				</div>
			</div>
		</div>
	</form>
</div>
<!-- End Member Dashboard Items-->

<!-- Admin Dashboard Items Start -->

<div class="modal fade" id="modal-admin-dashboard" tabindex="-1" role="dialog" aria-labelledby="myModalLabelAdminDashboard" aria-hidden="true">
	<form role="form" id="form-admin-dashboard">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabelAdminDashboard">
						<i class="glyphicon glyphicon-stats"></i>&nbsp;&nbsp;HIDE/SHOW DETAILS ON DASHBOARD
					</h4>
				</div>
				<div class="modal-body">
					<input type="hidden" name="adminDashboard_id" value="${ adminDashboard.id }" id="adminDashboard_id"/>
					<table class="table">
						<tr><th>ITEM</th><th>SHOW/HIDE</th></tr>
						<tr>
							<td>
								<label class="control-label">ACTIVE MEMBERS </label>
							</td>
							<td>
								<input type="checkbox" name="activeMembers" id="activeMembers" ${adminDashboard.activeMembers == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>
						<tr>
							<td>
								<label class="control-label"> DEFERRED MEMBERS </label>
							</td>
							<td>
								<input type="checkbox" name="defferedMembers" id="defferedMembers" ${adminDashboard.defferedMembers == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> PENSIONERS </label>
							</td>
							<td>
								<input type="checkbox" name="pensioners" id="pensioners" ${adminDashboard.pensioners == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> EXITS IN CURRENT YEAR </label>
							</td>
							<td>
								<input type="checkbox" name="exits" id="exits" ${adminDashboard.exits == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> NEW MEMBERS </label>
							</td>
							<td>
								<input type="checkbox" name="newMembers" id="newMembers" ${adminDashboard.newMembers == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

						<tr>
							<td>
								<label class="control-label"> MEMBERS DUE FOR RETIREMENT </label>
							</td>
							<td>
								<input type="checkbox" name="membersDueRetirement" id="membersDueRetirement" ${adminDashboard.membersDueRetirement == 'TRUE' ? 'checked' : ''}/>
							</td>
						</tr>

					</table>
				</div>
				<div class="modal-footer">
					<a href="#" class="btn btn-warning" data-dismiss="modal">Cancel</a>
					<input class="btn btn-primary" type="submit"
						   value="Save Permissions" id="btn-admin-dashboard">
				</div>
			</div>
		</div>
	</form>
</div>
<!-- End Admin Dashboard Items-->

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
        	        dataType: 'json',
        	        success: function(json) {
        	            $('#' + btn).val('Done');
        	            if(json.success)
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
        	        dataType: 'json',
        	        success: function(json) {
        	            $('#' + btn).val('Done');
        	            if(json.success)
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

			/* Form Member Permissions */

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
        	        dataType: 'json',
        	        success: function(json) {
        	            $('#' + btn).val('Done');
        	            if(json.success)
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
			/* End Form Member Permissions */


			/* Form Contributions Graph */

			$('#form-contribution-graph').bootstrapValidator({
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

						var btn = "btn-contribution-graph";
						var form = "form-contribution-graph";
						var modal = "modal-contribution-graph";
						var btn_text = $('#' + btn).val();

						$('#' + btn).val('Please wait...');
						$.ajax({
							url: $('#base_url').val() + 'admin',
							type: 'post',
							data: {
								ACTION: 'DISABLE_CONTRIBUTION_GRAPH',
								dbGraph_id: $('#dbGraph_id').val(),
								contributionGraphActive: $('#contributionGraphActive').prop('checked'),
								interestActive: $('#interestActive').prop('checked')
							},
							dataType: 'json',
							success: function(json) {
								$('#' + btn).val('Done');
								if(json.success)
								{
									$('#' + form)[0].reset();
									$('#' + modal).modal('hide');
									html = 'Configuration details successfully saved';
								}
								else
									html = 'Configuration details could not be saved';
								bootbox.alert(html);
								$('#' + btn).val(btn_text);
							}
						});

					});
			/* End Form Contributions Graph */

			/* Form Member Menu */

			$('#form-member-menu').bootstrapValidator({
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

						var btn = "btn-member-menu";
						var form = "form-member-menu";
						var modal = "modal-member-menu";
						var btn_text = $('#' + btn).val();

						$('#' + btn).val('Please wait...');
						$.ajax({
							url: $('#base_url').val() + 'admin',
							type: 'post',
							data: {
								ACTION: 'MEMBER_MENU_CONFIG',
								//dbGraph_id: $('#dbGraph_id').val(),
								contributionHistoryReport: $('#contributionHistoryReport').prop('checked'),
								contributionHistoryGrid: $('#contributionHistoryGrid').prop('checked'),
								BalancesHistory: $('#BalancesHistory').prop('checked'),
								BalancesHistoryGrid: $('#BalancesHistoryGrid').prop('checked'),
								StatementOfAccount: $('#StatementOfAccount').prop('checked'),
								StatementOfAccountGrid: $('#StatementOfAccountGrid').prop('checked'),
								UnitizedStatement: $('#UnitizedStatement').prop('checked'),
								WhatIfAnalysis: $('#WhatIfAnalysis').prop('checked'),
								benefitsProjection: $('#benefitsProjection').prop('checked'),
								benefitProjectionGrid: $('#benefitProjectionGrid').prop('checked'),
								annualContributionStatement: $('#annualContributionStatement').prop('checked'),
                                provisionalMemberStatement: $('#provisionalMemberStatement').prop('checked'),
								Media: $('#Media').prop('checked')
							},
							dataType: 'json',
							success: function(json) {
								$('#' + btn).val('Done');
								if(json.success)
								{
									$('#' + form)[0].reset();
									$('#' + modal).modal('hide');
									html = 'Configuration details successfully saved';
								}
								else
									html = 'Configuration details could not be saved';
								bootbox.alert(html);
								$('#' + btn).val(btn_text);
							}
						});

					});
			/* End Form Member Menu */

			/* Form Pensioner Menu */

			$('#form-pensioner-menu').bootstrapValidator({
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

						var btn = "btn-pensioner-menu";
						var form = "form-pensioner-menu";
						var modal = "modal-pensioner-menu";
						var btn_text = $('#' + btn).val();

						$('#' + btn).val('Please wait...');
						$.ajax({
							url: $('#base_url').val() + 'admin',
							type: 'post',
							data: {
								ACTION: 'PENSIONER_MENU_CONFIG',
								personalInfo: $('#personalInfo').prop('checked'),
								pensionDetails: $('#pensionDetails').prop('checked'),
								pensionAdviceReport: $('#pensionAdviceReport').prop('checked'),
								pensionAdviceGrid: $('#pensionAdviceGrid').prop('checked'),
								media: $('#media2').prop('checked')
							},
							dataType: 'json',
							success: function(json) {
								$('#' + btn).val('Done');
								if(json.success)
								{
									$('#' + form)[0].reset();
									$('#' + modal).modal('hide');
									html = 'Configuration details successfully saved';
								}
								else
									html = 'Configuration details could not be saved';
								bootbox.alert(html);
								$('#' + btn).val(btn_text);
							}
						});

					});
			/* End Form Pensioner Menu */

			/* Form Dashboard Items */

			$('#form-member-dashboard').bootstrapValidator({
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

						var btn = "btn-dashboard-items";
						var form = "form-member-dashboard";
						var modal = "modal-dashboard-items";
						var btn_text = $('#' + btn).val();

						$('#' + btn).val('Please wait...');
						$.ajax({
							url: $('#base_url').val() + 'admin',
							type: 'post',
							data: {
								ACTION: 'MEMBER_DASHBOARD_ITEMS',
								memberName: $('#memberName').prop('checked'),
								dateOfBirth2: $('#dateOfBirth2').prop('checked'),
								dateOfJoiningScheme: $('#dateOfJoiningScheme').prop('checked'),
								gender2: $('#gender2').prop('checked'),
								idNumber2: $('#idNumber2').prop('checked'),
								phoneNumber2: $('#phoneNumber2').prop('checked'),
								emailAddress2: $('#emailAddress2').prop('checked'),
								memberNo2: $('#memberNo2').prop('checked'),
								memberId2: $('#memberId2').prop('checked'),
								pinNumber: $('#pinNumber').prop('checked'),
								ssnitNumber: $('#ssnitNumber').prop('checked'),
								town: $('#town').prop('checked')
							},
							dataType: 'json',
							success: function(json) {
								$('#' + btn).val('Done');
								if(json.success)
								{
									$('#' + form)[0].reset();
									$('#' + modal).modal('hide');
									html = 'Configuration details successfully saved';
								}
								else
									html = 'Configuration details could not be saved';
								bootbox.alert(html);
								$('#' + btn).val(btn_text);
							}
						});

					});
			/* End Form Dashboard Items */

			/* Form Admin Dashboard Items */

			$('#form-admin-dashboard').bootstrapValidator({
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

						var btn = "btn-admin-dashboard";
						var form = "form-admin-dashboard";
						var modal = "modal-admin-dashboard";
						var btn_text = $('#' + btn).val();

						$('#' + btn).val('Please wait...');
						$.ajax({
							url: $('#base_url').val() + 'admin',
							type: 'post',
							data: {
								ACTION: 'ADMIN_DASHBOARD_ITEMS',
								activeMembers: $('#activeMembers').prop('checked'),
								defferedMembers: $('#defferedMembers').prop('checked'),
								dateOfJoiningScheme: $('#dateOfJoiningScheme').prop('checked'),
								pensioners: $('#pensioners').prop('checked'),
								exits: $('#exits').prop('checked'),
								newMembers: $('#newMembers').prop('checked'),
								membersDueRetirement: $('#membersDueRetirement').prop('checked')
							},
							dataType: 'json',
							success: function(json) {
								$('#' + btn).val('Done');
								if(json.success)
								{
									$('#' + form)[0].reset();
									$('#' + modal).modal('hide');
									html = 'Configuration details successfully saved';
								}
								else
									html = 'Configuration details could not be saved';
								bootbox.alert(html);
								$('#' + btn).val(btn_text);
							}
						});

					});
			/* End Form Admin Dashboard Items */

		    
		    $('#member-permissions-li').click(function(){
		        $('#modal-member-permissions').modal('show');
		    });

			$('#contribution-graph-li').click(function(){
				$('#modal-contribution-graph').modal('show');
			});

			$('#member-menu-li').click(function(){
				$('#modal-member-menu').modal('show');
			});

			$('#pensioner-menu-li').click(function(){
				$('#modal-pensioner-menu').modal('show');
			});

			$('#member-dashboard-li').click(function(){
				$('#modal-dashboard-items').modal('show');
			});

			$('#admin-dashboard-items-li').click(function(){
				$('#modal-admin-dashboard').modal('show');
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