<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/partial/header.jsp" />
<input type="hidden" id="minimum" value="${ policy.length }" />
<input type="hidden" id="lowercase" value="${ policy.lowercase }" />
<input type="hidden" id="uppercase" value="${ policy.uppercase }" />
<input type="hidden" id="numbers" value="${ policy.numbers }" />
<div class="main-content">
	<div class="container">
	 
	 <div class="row">
	 <input type="hidden" name="hidCaptchaID" id="hidCaptchaID" value="<%= session.getId() %>"/>
		 	<ul class="nav nav-pills nav-justified">
			    <li class="active"><a data-toggle="pill" href="#existing">EXISTING SCHEME PARTNER</a></li>
			    <li><a data-toggle="pill" href="#individual">REGISTER NEW MEMBER</a></li>
			    <li><a data-toggle="pill" href="#company">REGISTER NEW SPONSOR</a></li>
		  	</ul>
			<p>&nbsp;</p>
			<div class="tab-content">
				<div id="existing" class="tab-pane fade in active border-top">
			        <div class="col-sm-6 col-md-4 col-lg-4"> <!-- required for floating -->
			          <!-- Nav tabs -->
			          <c:set var="count" value="0" scope="page" />
			          <ul class="nav nav-tabs tabs-left">
						<c:forEach var="field" items="${loginFields}">
			            	<c:if test="${ field.published }">
				            	<c:if test="${ count == 0 }">
				            		<li class="active">
					            		<a href="#${field.profile }" data-toggle="tab">
					            			<c:forEach var="pn" items="${profileNames }">
					            				<c:if test="${ pn.profile == field.profile }">
					            					${ pn.name }
					            				</c:if>
					            			</c:forEach>
					            		</a>
				            		</li>
				            	</c:if>
				            	<c:if test="${ count > 0 }">
				            		<li>
				            			<a href="#${field.profile }" data-toggle="tab">
							            			<c:forEach var="pn" items="${profileNames }">
							            				<c:if test="${ pn.profile == field.profile }">
							            					${ pn.name }
							            				</c:if>
							            			</c:forEach>
				            			</a>
				            		</li>
				            	</c:if>
				            	<c:set var="count" value="${count + 1}" scope="page"/>
			            	</c:if>
						</c:forEach>
			          </ul>
			        </div>
			
			        <div class="col-sm-6 col-md-8 col-lg-8">
			          <!-- Tab panes -->
			          <div class="tab-content">
			          	<div class="tab-pane" id="ADMINISTRATOR">
							<div class="row">
						
							<form class="form-horizontal" method="post" id="form-admin">
							
								<div class="modal-dialog large-modal">
									<div class="modal-content">
										<div class="modal-body">
											<h2 class="heading">
													<c:forEach var="pn" items="${profileNames }">
							            				<c:if test="${ pn.profile == 'ADMINISTRATOR'}">
							            					${ pn.name }
							            				</c:if>
							            			</c:forEach>
														 REGISTRATION</h2>
													<fieldset>
														<div class="form-group">
															<c:forEach var="field" items="${loginFields}">
																<c:choose>
																	<c:when test="${field.profile == 'ADMINISTRATOR' }">
																		<label for="adminIdNumber" class="control-label">${ field.ordinal }:</label>
																		<c:if test="${ field.ordinal== 'PHONE' }">
																			<div class="form-inline">
																				<select class="form-control pull-left admin-country-code" name="country-code" style="width: 25%;"></select>
																				<input type="text" name="adminIdNumber" class="form-control"
																					   id="adminIdNumber" placeholder="${ field.ordinal}" style="width: 75%;">
																			</div>
																		</c:if>
																		<c:if test="${ field.ordinal== 'EMAIL'}">
																			<input type="text" name="adminIdNumber" class="form-control input-sm"
																				   id="adminIdNumber" placeholder="${ field.ordinal}">
																		</c:if>

																	</c:when>
																</c:choose>
															</c:forEach>
														</div>
														<div class="form-group">
															<label for="adminPassword" class="control-label">Password:</label>
															<input type="password" name="adminPassword" class="form-control input-sm"
																id="adminPassword" placeholder="Enter Password">
														</div>
														<div class="form-group">
															<label for="adminConfirmPassword" class="control-label">Confirm Password:</label>
															<input type="password" name="adminConfirmPassword" class="form-control input-sm"
																id="adminConfirmPassword" placeholder="Confirm Password">
														</div>
														<div class="col-md-6 CaptchaImage" id="adminCaptchaImage">
															<img src="<%=request.getContextPath()%>/captcha" alt="captcha" />
														</div>
														<div class="col-md-6 form-group">
														<label class="control-label">Enter the text to your left here</label>
															<input type="text" class="form-control" name="adminCaptchaChars" id="adminCaptchaChars" />
														</div>
														<button class="btn btn-warning btn-block" >REGISTER NOW</button>
													</fieldset>
										</div>
									</div>
								</div>
							</form>
							</div>
	
						</div>
			            <div class="tab-pane active" id="MEMBER">
							<div class="row">
						
								<div class="modal-dialog large-modal">
									<div class="modal-content">
										<div class="modal-body">
											<h2 class="heading">
													<c:forEach var="pn" items="${profileNames }">
							            				<c:if test="${ pn.profile == 'MEMBER'}">
							            					${ pn.name }
							            				</c:if>
							            			</c:forEach> REGISTRATION</h2>
											<form class="form-horizontal" method="post" id="form-member">
												<fieldset>
													<div class="form-group">
														<c:forEach var="field" items="${loginFields}">
															<c:choose>
																<c:when test="${field.profile == 'MEMBER' }">
																	<label for="eMIdNumber" class="control-label">${ field.ordinal }:</label>
																		<c:if test="${ field.ordinal== 'PHONE' }">
																			<div class="form-inline">
																					<select class="form-control pull-left country-code" name="country-code" style="width: 25%;"></select>
																					<input type="text" name="eMIdNumber" class="form-control pull-right"
																						   id="eMIdNumber" placeholder="${ field.ordinal}" style="width: 75%;">
																			</div>
																				</c:if>
																	    <c:if test="${ field.ordinal== 'EMAIL'}">
																			<input type="text" name="eMIdNumber" class="form-control input-sm"
																				   id="eMIdNumber" placeholder="${ field.ordinal}">
																		</c:if>
																</c:when>
															</c:choose>
														</c:forEach>
													</div>
													<div class="form-group">
														<label for="eMPassword" class="control-label">Password:</label>
														<input type="password" name="eMPassword" class="form-control input-sm"
															id="eMPassword" placeholder="Enter Password">
													</div>
													<div class="form-group">
														<label for="eMConfirmPassword" class="control-label">Confirm Password:</label>
														<input type="password" name="eMConfirmPassword" class="form-control input-sm"
															id="eMConfirmPassword" placeholder="Confirm Password">
													</div>
													<div class="col-md-6 CaptchaImage" id="memberCaptchaImage">
														<img src="<%=request.getContextPath()%>/captcha" alt="captcha" />
													</div>
													<div class="col-md-6 form-group">
														<label class="control-label">Enter the text to your left here</label>
														<input type="text" class="form-control" name="eMCaptchaChars" id="eMCaptchaChars" />
													</div>
													<button class="btn btn-warning btn-block" >REGISTER NOW</button>
												</fieldset>
													
											</form>
										</div>
									</div>
								</div>
							</div>
	
						</div>

						  <div class="tab-pane" id="PENSIONER">
							  <div class="row">

								  <div class="modal-dialog large-modal">
									  <div class="modal-content">
										  <div class="modal-body">
											  <h2 class="heading">
												  <c:forEach var="pn" items="${profileNames }">
													  <c:if test="${ pn.profile == 'PENSIONER'}">
														  ${ pn.name }
													  </c:if>
												  </c:forEach> REGISTRATION</h2>
											  <form class="form-horizontal" method="post" id="form-pensioner">
												  <fieldset>
													  <div class="form-group">
														  <c:forEach var="field" items="${loginFields}">
															  <c:choose>
																  <c:when test="${field.profile == 'PENSIONER' }">
																	  <label for="pensionerIdNumber" class="control-label">${ field.ordinal }:</label>
																	  <c:if test="${ field.ordinal== 'PHONE' }">
																	  <div class="form-inline">
																		  <select class="form-control pull-left country-code" name="country-code" style="width: 25%;"></select>
																		  <input type="text" name="pensionerIdNumber" class="form-control"
																				 id="pensionerIdNumber" placeholder="${ field.ordinal}" style="width: 75%;">
																	  </div>
																	  </c:if>
																	  <c:if test="${ field.ordinal== 'EMAIL'}">
																	  <input type="text" name="pensionerIdNumber" class="form-control input-sm"
																			 id="pensionerIdNumber" placeholder="${ field.ordinal}">
																	  </c:if>
																  </c:when>
															  </c:choose>
														  </c:forEach>
													  </div>

													  <div class="form-group">
														  <label for="pensionerPassword" class="control-label">Password:</label>
														  <input type="password" name="pensionerPassword" class="form-control input-sm"
																 id="pensionerPassword" placeholder="Enter Password">
													  </div>
													  <div class="form-group">
														  <label for="pensionerConfirmPassword" class="control-label">Confirm Password:</label>
														  <input type="password" name="pensionerConfirmPassword" class="form-control input-sm"
																 id="pensionerConfirmPassword" placeholder="Confirm Password">
													  </div>
													  <div class="col-md-6 CaptchaImage" id="pensionerCaptchaImage">
														  <img src="<%=request.getContextPath()%>/captcha" alt="captcha" />
													  </div>
													  <div class="col-md-6 form-group">
														  <label class="control-label">Enter the text to your left here</label>
														  <input type="text" class="form-control" name="pensionerCaptchaChars" id="pensionerCaptchaChars" />
													  </div>
													  <button class="btn btn-warning btn-block" >REGISTER NOW</button>
												  </fieldset>

											  </form>
										  </div>
									  </div>
								  </div>
							  </div>
						  </div>

			            <div class="tab-pane" id="SPONSOR">
				            <div class="row">
							
								<div class="modal-dialog large-modal">
									<div class="modal-content">
										<div class="modal-body">
											<h2 class="heading">
													<c:forEach var="pn" items="${profileNames }">
							            				<c:if test="${ pn.profile == 'SPONSOR'}">
							            					${ pn.name }
							            				</c:if>
							            			</c:forEach> REGISTRATION</h2>
											<form class="form-horizontal" method="post" id="form-sponsor-existing">
												<fieldset>
													<div class="form-group">
													<c:forEach var="field" items="${loginFields}">
														<c:choose>
															<c:when test="${field.profile == 'SPONSOR' }">
																<label for="sponsorIdNumber" class="control-label">${ field.ordinal }:</label>
																<c:if test="${ field.ordinal== 'PHONE' }">
																	<div class="form-inline">
																		<select class="form-control pull-left sponsor-country-code" name="country-code" style="width: 25%;"></select>
																		<input type="text" name="sponsorIdNumber" class="form-control"
																			   id="sponsorIdNumber" placeholder="${ field.ordinal}"  style="width: 75%;">
																	</div>
																</c:if>
																<c:if test="${ field.ordinal== 'EMAIL'}">
																	<input type="text" name="sponsorIdNumber" class="form-control input-sm"
																		   id="sponsorIdNumber" placeholder="${ field.ordinal}">
																</c:if>
															</c:when>
														</c:choose>
													</c:forEach>
													</div>
													<div class="form-group">
														<label for="sponsorPassword" class="control-label">Password:</label>
														<input type="password" name="sponsorPassword" class="form-control input-sm"
															id="sponsorPassword" placeholder="Enter Password">
													</div>
													<div class="form-group">
														<label for="sponsorConfirmPassword" class="control-label">Confirm Password:</label>
														<input type="password" name="sponsorConfirmPassword" class="form-control input-sm"
															id="sponsorConfirmPassword" placeholder="Confirm Password">
													</div>
												<div class="col-md-6 CaptchaImage" id="sponsorCaptchaImage">
													<img src="<%=request.getContextPath()%>/captcha" alt="captcha" />
												</div>
												<div class="col-md-6 form-group">
														<label class="control-label">Enter the text to your left here</label>
													<input type="text" class="form-control" name="sponsorCaptchaChars" id="sponsorCaptchaChars" />
												</div>
													<button class="btn btn-warning btn-block" >REGISTER NOW</button>
												</fieldset>
													
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
			            <div class="tab-pane" id="TRUSTEE">						
							<div class="row">
							
								<div class="modal-dialog large-modal">
									<div class="modal-content">
										<div class="modal-body">
											<h2 class="heading">
													<c:forEach var="pn" items="${profileNames }">
							            				<c:if test="${ pn.profile == 'TRUSTEE'}">
							            					${ pn.name }
							            				</c:if>
							            			</c:forEach> REGISTRATION</h2>
											<form class="form-horizontal" method="post" id="form-trustee">
												<fieldset>
													<div class="form-group">
														<c:forEach var="field" items="${loginFields}">
															<c:choose>
																<c:when test="${field.profile == 'TRUSTEE' }">
																	<label for="trusteeIdNumber" class="control-label">${ field.ordinal }:</label>
																	<c:if test="${ field.ordinal== 'PHONE' }">
																		<div class="form-inline">
																			<select class="form-control pull-left country-code" name="country-code" style="width: 25%;"></select>
																			<input type="text" name="trusteeIdNumber" class="form-control"
																				   id="trusteeIdNumber" placeholder="${ field.ordinal}" style="width: 75%;">
																		</div>
																	</c:if>
																	<c:if test="${ field.ordinal== 'EMAIL'}">
																		<input type="text" name="trusteeIdNumber" class="form-control input-sm"
																			   id="trusteeIdNumber" placeholder="${ field.ordinal}">
																	</c:if>

																</c:when>
															</c:choose>
														</c:forEach>
													</div>
													<div class="form-group">
														<label for="trusteePassword" class="control-label">Password:</label>
														<input type="password" name="trusteePassword" class="form-control input-sm"
															id="trusteePassword" placeholder="Enter Password">
													</div>
													<div class="form-group">
														<label for="trusteeConfirmPassword" class="control-label">Confirm Password:</label>
														<input type="password" name="trusteeConfirmPassword" class="form-control input-sm"
															id="trusteeConfirmPassword" placeholder="Confirm Password">
													</div>
													<div class="col-md-6 CaptchaImage">
														<img src="<%=request.getContextPath()%>/captcha" alt="captcha" />
													</div>
													<div class="col-md-6 form-group" >
														<label class="control-label">Enter the text to your left here</label>
														<input type="text" class="form-control" name="trusteeCaptchaChars" id="trusteeCaptchaChars" />
													</div>
													<button class="btn btn-warning btn-block" >REGISTER NOW</button>
												</fieldset>
													
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="tab-pane" id="AGENT">						
							<div class="row">
						
								<div class="modal-dialog large-modal">
									<div class="modal-content">
										<div class="modal-body">
											<h2 class="heading">
													<c:forEach var="pn" items="${profileNames }">
							            				<c:if test="${ pn.profile == 'AGENT'}">
							            					${ pn.name }
							            				</c:if>
							            			</c:forEach> REGISTRATION</h2>
											<form class="form-horizontal" method="post" id="form-agent">
												<fieldset>
													<div class="form-group">
														<c:forEach var="field" items="${loginFields}">
															<c:choose>
																<c:when test="${field.profile == 'AGENT' }">
																	<label for="agentIdNumber" class="control-label">${ field.ordinal }:</label>
																	<c:if test="${ field.ordinal== 'PHONE' }">
																		<div class="form-inline">
																			<select class="form-control pull-left country-code" name="country-code" style="width: 25%;"></select>
																			<input type="text" name="agentIdNumber" class="form-control"
																				   id="agentIdNumber" placeholder="${ field.ordinal}" style="width: 75%;">
																		</div>
																	</c:if>
																	<c:if test="${ field.ordinal== 'EMAIL'}">
																		<input type="text" name="agentIdNumber" class="form-control input-sm"
																			   id="agentIdNumber" placeholder="${ field.ordinal}">
																	</c:if>
																</c:when>
															</c:choose>
														</c:forEach>
													</div>
													<div class="form-group">
														<label for="agentPassword" class="control-label">Password:</label>
														<input type="password" name="agentPassword" class="form-control input-sm"
															id="agentPassword" placeholder="Enter Password">
													</div>
													<div class="form-group">
														<label for="agentConfirmPassword" class="control-label">Confirm Password:</label>
														<input type="password" name="agentConfirmPassword" class="form-control input-sm"
															id="agentConfirmPassword" placeholder="Confirm Password">
													</div>
													<div class="col-md-6 CaptchaImage" id="agentCaptchaImage">
														<img src="<%=request.getContextPath()%>/captcha" alt="captcha" />
													</div>
													<div class="col-md-6 form-group">
														<label class="control-label">Enter the text to your left here</label>
														<input type="text" class="form-control" name="agentCaptchaChars" id="agentCaptchaChars" />
													</div>
													<button class="btn btn-warning btn-block" >REGISTER NOW</button>
												</fieldset>
													
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="tab-pane" id="CUSTODIAN">						
							<div class="row">
						
								<div class="modal-dialog large-modal">
									<div class="modal-content">
										<div class="modal-body">
											<h2 class="heading">
													<c:forEach var="pn" items="${profileNames }">
							            				<c:if test="${ pn.profile == 'CUSTODIAN'}">
							            					${ pn.name }
							            				</c:if>
							            			</c:forEach> REGISTRATION</h2>
											<form class="form-horizontal" method="post" id="form-custodian">
												<fieldset>
													<div class="form-group">
														<c:forEach var="field" items="${loginFields}">
															<c:choose>
																<c:when test="${field.profile == 'CUSTODIAN' }">
																	<label for="custodianIdNumber" class="control-label">${ field.ordinal }:</label>
																	<c:if test="${ field.ordinal== 'PHONE' }">
																		<div class="form-inline">
																			<select class="form-control pull-left country-code" name="country-code" style="width: 25%;"></select>
																			<input type="text" name="custodianIdNumber" class="form-control"
																				   id="custodianIdNumber" placeholder="${ field.ordinal}" style="width: 75%;">
																		</div>
																	</c:if>
																	<c:if test="${ field.ordinal== 'EMAIL'}">
																		<input type="text" name="custodianIdNumber" class="form-control input-sm"
																			   id="custodianIdNumber" placeholder="${ field.ordinal}">
																	</c:if>
																</c:when>
															</c:choose>
														</c:forEach>
													</div>
													<div class="form-group">
														<label for="custodianPassword" class="control-label">Password:</label>
														<input type="password" name="custodianPassword" class="form-control input-sm"
															id="custodianPassword" placeholder="Enter Password">
													</div>
													<div class="form-group">
														<label for="custodianConfirmPassword" class="control-label">Confirm Password:</label>
														<input type="password" name="custodianConfirmPassword" class="form-control input-sm"
															id="custodianConfirmPassword" placeholder="Confirm Password">
													</div>
													<div class="col-md-6 CaptchaImage" id="custodianCaptchaImage">
														<img src="<%=request.getContextPath()%>/captcha" alt="captcha" />
													</div>
													<div class="col-md-6 form-group">
														<label class="control-label">Enter the text to your left here</label>
														<input type="text" class="form-control" name="custodianCaptchaChars" id="custodianCaptchaChars" />
													</div>
													<button class="btn btn-warning btn-block" >REGISTER NOW</button>
												</fieldset>
													
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="tab-pane" id="CUSTOMER_RELATIONSHIP_MANAGER">						
							<div class="row">
						
								<div class="modal-dialog large-modal">
									<div class="modal-content">
										<div class="modal-body">
											<h2 class="heading">
													<c:forEach var="pn" items="${profileNames }">
							            				<c:if test="${ pn.profile == 'CUSTOMER_RELATIONSHIP_MANAGER'}">
							            					${ pn.name }
							            				</c:if>
							            			</c:forEach> REGISTRATION</h2>
											<form class="form-horizontal" method="post" id="form-crm">
												<fieldset>
													<div class="form-group">
														<c:forEach var="field" items="${loginFields}">
															<c:choose>
																<c:when test="${field.profile == 'CUSTOMER_RELATIONSHIP_MANAGER' }">
																	<label for="crmIdNumber" class="control-label">${ field.ordinal }:</label>
																	<c:if test="${ field.ordinal== 'PHONE' }">
																		<div class="form-inline">
																			<select class="form-control pull-left country-code" name="country-code" style="width: 25%;"></select>
																			<input type="text" name="crmIdNumber" class="form-control input-sm"
																				   id="crmIdNumber" placeholder="${ field.ordinal}" style="width: 75%;">
																		</div>
																	</c:if>
																	<c:if test="${ field.ordinal== 'EMAIL'}">
																		<input type="text" name="crmIdNumber" class="form-control input-sm"
																			   id="crmIdNumber" placeholder="${ field.ordinal}">
																	</c:if>

																</c:when>
															</c:choose>
														</c:forEach>

													</div>
													<div class="form-group">
														<label for="crmPassword" class="control-label">Password:</label>
														<input type="password" name="crmPassword" class="form-control input-sm"
															id="crmPassword" placeholder="Enter Password">
													</div>
													<div class="form-group">
														<label for="crmConfirmPassword" class="control-label">Confirm Password:</label>
														<input type="password" name="crmConfirmPassword" class="form-control input-sm"
															id="crmConfirmPassword" placeholder="Confirm Password">
													</div>
													<div class="col-md-6 CaptchaImage" id="crmCaptchaImage">
														<img src="<%=request.getContextPath()%>/captcha" alt="captcha" />
													</div>
													<div class="col-md-6 form-group">
														<label class="control-label">Enter the text to your left here</label>
														<input type="text" class="form-control" name="crmCaptchaChars" id="crmCaptchaChars" />
													</div>
													<button class="btn btn-warning btn-block" >REGISTER NOW</button>
												</fieldset>
													
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="tab-pane" id="CUSTOMER_RELATIONSHIP_EXECUTIVE">						
							<div class="row">
						
								<div class="modal-dialog large-modal">
									<div class="modal-content">
										<div class="modal-body">
											<h2 class="heading">
													<c:forEach var="pn" items="${profileNames }">
							            				<c:if test="${ pn.profile == 'CUSTOMER_RELATIONSHIP_EXECUTIVE'}">
							            					${ pn.name }
							            				</c:if>
							            			</c:forEach> REGISTRATION</h2>
											<form class="form-horizontal" method="post" id="form-cre">
												<fieldset>
													<div class="form-group">
														<c:forEach var="field" items="${loginFields}">
															<c:choose>
																<c:when test="${field.profile == 'CUSTOMER_RELATIONSHIP_EXECUTIVE' }">
																	<label for="creIdNumber" class="control-label">${ field.ordinal }:</label>
																	<c:if test="${ field.ordinal== 'PHONE' }">
																		<div class="form-inline">
																			<select class="form-control pull-left country-code" name="country-code" style="width: 25%;"></select>
																			<input type="text" name="creIdNumber" class="form-control"
																				   id="creIdNumber" placeholder="${ field.ordinal}" style="width: 75%;">
																		</div>
																	</c:if>
																	<c:if test="${ field.ordinal== 'EMAIL'}">
																		<input type="text" name="creIdNumber" class="form-control input-sm"
																			   id="creIdNumber" placeholder="${ field.ordinal}">
																	</c:if>

																</c:when>
															</c:choose>
														</c:forEach>
													</div>
													<div class="form-group">
														<label for="crePassword" class="control-label">Password:</label>
														<input type="password" name="crePassword" class="form-control input-sm"
															id="crePassword" placeholder="Enter Password">
													</div>
													<div class="form-group">
														<label for="creConfirmPassword" class="control-label">Confirm Password:</label>
														<input type="password" name="creConfirmPassword" class="form-control input-sm"
															id="creConfirmPassword" placeholder="Confirm Password">
													</div>
													<div class="col-md-6 CaptchaImage" id="creCaptchaImage">
														<img src="<%=request.getContextPath()%>/captcha" alt="captcha" />
													</div>
													<div class="col-md-6 form-group">
														<label class="control-label">Enter the text to your left here</label>
														<input type="text" class="form-control" name="creCaptchaChars" id="creCaptchaChars" />
													</div>
													<button class="btn btn-warning btn-block" >REGISTER NOW</button>
												</fieldset>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="tab-pane" id="FUND_MANAGER">						
							<div class="row">
						
								<div class="modal-dialog large-modal">
									<div class="modal-content">
										<div class="modal-body">
											<h2 class="heading">
													<c:forEach var="pn" items="${profileNames }">
							            				<c:if test="${ pn.profile == 'FUND_MANAGER'}">
							            					${ pn.name }
							            				</c:if>
							            			</c:forEach> REGISTRATION</h2>
											<form class="form-horizontal" method="post" id="form-fm">
												<fieldset>
													<div class="form-group">
														<c:forEach var="field" items="${loginFields}">
															<c:choose>
																<c:when test="${field.profile == 'FUND_MANAGER' }">
																	<label for="fmIdNumber" class="control-label">${ field.ordinal }:</label>
																	<c:if test="${ field.ordinal== 'PHONE' }">
																		<div class="form-inline">
																			<select class="form-control pull-left country-code" name="country-code" style="width: 25%;"></select>
																			<input type="text" name="fmIdNumber" class="form-control"
																				   id="fmIdNumber" placeholder="${ field.ordinal}" style="width: 75%;">
																		</div>
																	</c:if>
																	<c:if test="${ field.ordinal== 'EMAIL'}">
																		<input type="text" name="fmIdNumber" class="form-control input-sm"
																			   id="fmIdNumber" placeholder="${ field.ordinal}">
																	</c:if>
																</c:when>
															</c:choose>
														</c:forEach>
													</div>
													<div class="form-group">
														<label for="fmPassword" class="control-label">Password:</label>
														<input type="password" name="fmPassword" class="form-control input-sm"
															id="fmPassword" placeholder="Enter Password">
													</div>
													<div class="form-group">
														<label for="fmConfirmPassword" class="control-label">Confirm Password:</label>
														<input type="password" name="fmConfirmPassword" class="form-control input-sm"
															id="fmConfirmPassword" placeholder="Confirm Password">
													</div>
													<div class="col-md-6 CaptchaImage" id="fmCaptchaImage">
														<img src="<%=request.getContextPath()%>/captcha" alt="captcha" />
													</div>
													<div class="col-md-6 form-group">
														<label class="control-label">Enter the text to your left here</label>
														<input type="text" class="form-control" name="fmCaptchaChars" id="fmCaptchaChars" />
													</div>
													<button class="btn btn-warning btn-block" >REGISTER NOW</button>
												</fieldset>
													
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
			          </div>
			        </div>
					
				</div>
				<div id="individual" class="tab-pane fade in">
			
								<div class="modal-dialog large-modal">
									<div class="modal-content">
										<div class="modal-body">
												<form class="form-horizontal" method="post" id="form-register">
												<h1 class="heading">NEW MEMBER REGISTRATION</h1>
													<div class="row">
														<div class="col-md-6">
														<fieldset>
															<legend>
																<i class="fa fa-user"></i> &nbsp;Personal Information
															</legend>
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
																<label for="otherName" class="control-label">Other Name:</label> <input
																	type="text" name="otherName" class="form-control" id="otherName"
																	placeholder="Other Names">
															</div>
															<div class="form-group">
																<label for="dateOfBirth" class="control-label">Date Of
																	Birth:</label> <input type="text" readonly="readonly" name="dateOfBirth"
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
															<div class="form-group">
																<label for="maritalStatus" class="control-label">Marital
																	Status:</label> <select name="maritalStatus" id="maritalStatus"
																	class="form-control">
																	<option value="">Select marital status...</option>
																	<c:forEach var="maritalStatus" items="${maritalStatuses}">
														                <option value="${maritalStatus.id}">
														                    ${maritalStatus.name}
														                </option>
														            </c:forEach>
																</select>
															</div>
														</fieldset>
													</div>
													<div class="col-md-6">
														<fieldset>
															<legend>
																<i class="fa fa-phone"></i> &nbsp;Other Information
															</legend>
															<div class="form-group">
																		<label for="IdNumber" class="control-label">ID/PPT Number</label>
																		<input type="text" name="IdNumber" class="form-control input-sm"
																			id="IdNumber" placeholder="ID/PPT Number">
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
																	<legend>
																		<i class="glyphicon glyphicon-th"></i>&nbsp; Pension Plan
																	</legend>
																	<div class="form-group col-md-6">
																		<label for="pension_scheme" class="control-label">Preferred
																			Pension Plan:</label> <select name="pension_scheme" id="pension_scheme"
																			class="form-control" >
																			<option value="">Select pension product...</option>
																			<c:forEach var="scheme" items="${memberSchemes}">
																                <option value="${scheme.id}">
																                    ${scheme.name}
																                </option>
																            </c:forEach>
																		</select>
																	</div>
																	<div class="col-md-6">
																		<div class="col-md-6 CaptchaImage" id="newMemberCaptchaImage">
																			<img src="<%=request.getContextPath()%>/captcha" alt="captcha" />
																		</div>
																		<div class="form-group col-md-6">
																		<label class="control-label">Enter the text to your left here</label>
																			<input type="text" class="form-control" name="memberCaptchaChars" id="memberCaptchaChars" />
																		</div>
																		<button class="btn btn-primary btn-block">REGISTER</button>
																	</div>
																</fieldset>
													</div>
												</form>
											</div>
										</div>
									</div>
			</div>
			<div id="company" class="tab-pane fade in">
	
			
								<div class="modal-dialog large-modal">
									<div class="modal-content">
										<div class="modal-body">
											<h1 class="heading">NEW 
													<c:forEach var="pn" items="${profileNames }">
							            				<c:if test="${ pn.profile == 'SPONSOR'}">
							            					${ field.profile }
							            				</c:if>
							            			</c:forEach> REGISTRATION</h1>
											<form class="form-horizontal" method="post" id="form-sponsor">
												<div class="row">
														<div class="col-md-6">
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
																<label for="pinNumber" class="control-label">TAX Number:</label> <input type="text" name="pinNumber" class="form-control"
																	id="pinNumber" placeholder="TAX Number">
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
													<div class="col-md-6">
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
																Pension Product:</label> <select name="scheme" id="scheme"
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
															<div class="col-md-6 CaptchaImage" id="newSponsorCaptchaImage">
																<img src="<%=request.getContextPath()%>/captcha" alt="captcha" />
															</div>
															<div class="form-group col-md-6">
															<label class="control-label">Enter the text to your left here</label>
																<input type="text" class="form-control" name="sponsor1CaptchaChars" id="sponsor1CaptchaChars" />
															</div>
															<button class="btn btn-primary btn-block">REGISTER</button>
														</div>
													</fieldset>
												</div>
											</form>
											</div>
										</div>
									</div>
			</div>
			</div>
	 </div>

	</div>

</div>
<jsp:include page="includes/partial/footer.jsp" />

