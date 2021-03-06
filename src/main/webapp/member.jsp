<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% pageContext.setAttribute("currentYear", java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)); %>
<jsp:include page="includes/partial/admin_header.jsp" />
<input type="hidden" id="switch_to" value="admin"/>
<input type="hidden" id="minimum" value="${ policy.length }" />
<input type="hidden" id="lowercase" value="${ policy.lowercase }" />
<input type="hidden" id="uppercase" value="${ policy.uppercase }" />
<input type="hidden" id="numbers" value="${ policy.numbers }" />
<input type="hidden" id="member_id" value="${ member_id }" />

<div class="container-fluid navigation-bar">
	<div class="container-fluid">
		<div class="col-md-2">
			<c:forEach var="planType" items="${ planType }">
				<c:choose>
					<c:when test="${planType == 'Defined Benefit' }">
						<jsp:include page="member/DBScheme_menu.jsp" />
					</c:when>
					<c:otherwise>
						<jsp:include page="member/default_menu.jsp" />
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>

		<!--/span-->
		<div class="col-md-7" id="dashboard">
			<jsp:include page="member/dashboard.jsp" />
		</div>
		<div class="col-md-3">
			<div class="sidebar-right section">
				<c:if test="${ isManager }">					
					<button class="btn btn-danger btn-block" id="switch_profile">SWITCH TO MANAGERIAL PROFILE</button>
				</c:if>
				<h2><small>Choose Schemes</small></h2>
				<select class="form-control" name="scheme_id" id="scheme2_id" onchange="reloadmember();">
					<c:forEach var="scheme" items="${ schemes }">
						<c:choose>
							<c:when test="${scheme_id == scheme.id }">
								<option value="${scheme.id }" selected="selected">${ scheme.name }</option>
							</c:when>
							<c:otherwise>
								<option value="${scheme.id }">${ scheme.name }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
				<c:forEach var="client" items="${clientsetup}">
					<c:choose>
						<c:when test="${client.clientOrdinal=='ETL'}">
							<h2><small>Companies</small></h2>
							<select class="form-control" name="sponsor_id" id="sponsor_id" onchange="reloadproductmember();">
								<c:forEach var="sponsor" items="${ sponsors }">
									<c:choose>
										<c:when test="${sponsor_id == sponsor.id }">
											<option value="${sponsor.id }" selected="selected">${ sponsor.companyName }</option>
										</c:when>
										<c:otherwise>
											<option value="${sponsor.id }">${ sponsor.companyName }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</c:when>
						<c:otherwise>

						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
			<p>&nbsp;</p>
			<div class="sidebar-right section text-center">
				<h3 class="text-center">
					<small><i
							class="glyphicon glyphicon-comment"></i>&nbsp;QUICK CONTACT</small>
				</h3>
							<button class="btn btn-primary btn-block" id="send-email-btn">SEND AN EMAIL</button>
			</div>
			<p>&nbsp;</p>
			<div class="sidebar-right section">
				<h3 class="text-center">
					<small><i
							class="glyphicon glyphicon-align-justify"></i>&nbsp;RECENT ACTIVITY</small>
							
				</h3>
				<div class="list-group">
                     <c:forEach var="log" items="${ activityLogs }">
	                      <a href="#" class="list-group-item">
	                          <i class="fa fa-comment fa-fw"></i> ${ log.description }
	                          <span class="pull-right text-muted small"><em>${ log.datetime }</em>
	                          </span>
	                      </a>
                     </c:forEach>
               </div>
			</div>
		</div>
	</div>
</div>
<hr>
<footer>
	<p>&copy; Copyright  <c:out value="${currentYear}" />. All Rights Reserved. Systech Ltd.</p>
</footer>
<!--/.fluid-container-->
<jsp:include page="includes/partial/admin_footer.jsp" />
