<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<% pageContext.setAttribute("currentYear", java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)); %>
<jsp:include page="includes/partial/admin_header.jsp" />
<input type="hidden" id="switch_to" value="member"/>
<input type="hidden" name="schemeID" id="schemeID" value="${ scheme_id }" />
<input type="hidden" id="minimum" value="${ policy.length }" />
<input type="hidden" id="lowercase" value="${ policy.lowercase }" />
<input type="hidden" id="uppercase" value="${ policy.uppercase }" />
<input type="hidden" id="numbers" value="${ policy.numbers }" />
<div class="container-fluid navigation-bar">
	<div class="container-fluid">
		<div class="col-md-2">
			<div id="sidebar-left">
				<h2 class="text-center">
					<small>MAIN MENU</small>
				</h2>
				<ul id="main-menu" class="nav">
					<li id="admin-dashboard-li" class="active"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-dashboard"></i>&nbsp;<i
							class="fa fa-chevron-right"></i> DASHBOARD</a></li>
						<c:if test="${ permissions.setup == 'TRUE' }">
							<li id="setup-main-li" class=""><a href="javascript:void(0);" ><i
								class="glyphicon glyphicon-cog"></i>&nbsp;<i
								class="fa fa-chevron-right"></i> SETUP &amp; CONFIGURATION</a></li>
						</c:if>
						<c:if test="${ permissions.content == 'TRUE' }">
							<li id="content-main-li" class=""><a href="javascript:void(0);" ><i
								class="glyphicon glyphicon-cog"></i>&nbsp;<i
								class="fa fa-chevron-right"></i> CONTENT MANAGEMENT</a></li>
						</c:if>
						<c:if test="${ permissions.portal_members == 'TRUE' }">
						<li id="registered-main-li"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-record"></i>&nbsp;<i
							class="fa fa-chevron-right"></i> POTENTIAL MEMBERS</a></li>
						</c:if>
						<c:if test="${ permissions.portal_sponsors == 'TRUE' }">
						<li id="sponsors-main-li"><a href="javascript:void(0);"><i
							class="glyphicon glyphicon-record"></i>&nbsp;<i
							class="fa fa-chevron-right"></i> POTENTIAL SPONSORS</a></li>
						</c:if>
						<c:if test="${ permissions.schemes == 'TRUE'}">
							<li id="scheme-main-li"><a href="javascript:void(0);"><i
								class="glyphicon glyphicon-record"></i>&nbsp;<i
								class="fa fa-chevron-right"></i> SCHEMES</a></li>
						</c:if>
						<c:if test="${ permissions.receipts == 'TRUE' }">
							<li id="receipts-main-li"><a href="javascript:void(0);"><i
								class="glyphicon glyphicon-usd"></i>&nbsp;<i
								class="fa fa-chevron-right"></i> SCHEME RECEIPTS</a></li>
						</c:if>
						<c:if test="${ permissions.payments == 'TRUE' }">
							<li id="payments-main-li"><a href="javascript:void(0);"><i
								class="glyphicon glyphicon-gift"></i>&nbsp;<i
								class="fa fa-chevron-right"></i> BENEFIT PAYMENTS</a></li>
						</c:if>
						<c:if test="${ permissions.members == 'TRUE' }">
							<li id="member-main-li"><a href="javascript:void(0);"><i
								class="glyphicon glyphicon-user"></i>&nbsp;<i
								class="fa fa-chevron-right"></i> MEMBERS</a></li>
						</c:if>
						<c:if test="${ permissions.operations == 'TRUE' }">
							<li id="member-operations-main-li"><a href="javascript:void(0);"><i
								class="glyphicon glyphicon-user"></i>&nbsp;<i
								class="fa fa-chevron-right"></i> MEMBER OPERATIONS</a></li>
						</c:if>

						<c:if test="${ permissions.withdrawal_statement == 'TRUE' }">
						<li id="withdrawal-statement-main-li"><a href="javascript:void(0);"><i
								class="glyphicon glyphicon-file"></i>&nbsp;<i
								class="fa fa-chevron-right"></i> WITHDRAWAL STATEMENT</a></li>
						</c:if>

						<c:if test="${ permissions.withdrawal_settlements == 'TRUE' }">
						<li id="withdrawal-settlements-main-li"><a href="javascript:void(0);"><i
								class="glyphicon glyphicon-record"></i>&nbsp;<i
								class="fa fa-chevron-right"></i> WITHDRAWAL SETTLEMENTS</a></li>
						</c:if>

						<c:if test="${ permissions.admin_fee_listing == 'TRUE' }">
						<li id="admin_fee_listing-main-li"><a href="javascript:void(0);"><i
								class="glyphicon glyphicon-open-file"></i>&nbsp;<i
								class="fa fa-chevron-right"></i> ADMIN FEE LISTING</a></li>
						</c:if>

						<c:if test="${ permissions.media == 'TRUE' }">
							<li id="media-main-li"><a href="javascript:void(0);"><i
								class="glyphicon glyphicon-bookmark"></i>&nbsp;<i
								class="fa fa-chevron-right"></i> MEDIA</a></li>
						</c:if>
						<c:if test="${ permissions.uac == 'TRUE' }">
							<li id="uac-main-li"><a href="javascript:void(0);"><i
								class="glyphicon glyphicon-tasks"></i>&nbsp;<i
								class="fa fa-chevron-right"></i> ACCESS CONTROL</a></li>
						</c:if>
						<c:if test="${permissions.analytics == 'TRUE' }">
							<li id="analytics-main-li"><a href="javascript:void(0);"><i
								class="glyphicon glyphicon-flash"></i>&nbsp;<i
								class="fa fa-chevron-right"></i> ANALYTICS &amp; REPORTING</a></li>
						</c:if>

						<c:if test="${ permissions.member_movement == 'TRUE' }">
						<li id="member-movement-main-li"><a href="javascript:void(0);"><i
								class="glyphicon glyphicon-paste"></i>&nbsp;<i
								class="fa fa-chevron-right"></i> MEMBER MOVEMENT</a></li>
						</c:if>

						<c:if test="${profile == 'AGENT' }">
						<li id="commissions-main-li"><a href="javascript:void(0);"><i
								class="glyphicon glyphicon-briefcase"></i>&nbsp;<i
								class="fa fa-chevron-right"></i> COMMISSIONS</a></li>
						</c:if>

						<c:if test="${profile == 'AGENT' }">
						<li id="clients-main-li"><a href="javascript:void(0);"><i
								class="glyphicon glyphicon-user"></i>&nbsp;<i
								class="fa fa-chevron-right"></i> CLIENTS</a></li>
						</c:if>

						<li id="calc-log"><a href="javascript:void(0);"><i
								class="glyphicon glyphicon-flash"></i>&nbsp;<i
								class="fa fa-chevron-right"></i>CALCULATOR LOG</a></li>


				</ul>
			</div>
		</div>

		<!--/span-->
		<div class="col-md-7" id="dashboard">
			<jsp:include page="dashboard.jsp" />
		</div>
		<div class="col-md-3">
			<div class="sidebar-right section">
				<c:if test="${ isManager }">					
					<button class="btn btn-success btn-block" id="switch_profile">SWITCH TO PERSONAL PROFILE</button>
				</c:if>
				<h2><small>Active Scheme</small></h2>
				<select class="form-control" name="scheme_id" id="scheme_id" onchange="reload();">
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
			<div id="sidebar-left">
				<div id="sub-menu">
				
				</div>
			</div>
			<p>&nbsp;</p>
			<div class="sidebar-right section">
				<h3 class="text-center">
					<small>ACTIVITY LOG</small>
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
			<p>&nbsp;</p>
			
		</div>
	</div>
</div>
<hr>
<footer>
	<p>&copy; Copyright  <c:out value="${currentYear}" />. All Rights Reserved. Systech Ltd.</p>
</footer>
<!--/.fluid-container-->
<jsp:include page="includes/partial/admin_footer.jsp" />