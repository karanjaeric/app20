<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 11/24/16
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% pageContext.setAttribute("currentYear", java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)); %>
<jsp:include page="includes/partial/admin_header.jsp" />
<input type="hidden" id="switch_to" value="admin"/>
<input type="hidden" id="minimum" value="${ policy.length }" />
<input type="hidden" id="lowercase" value="${ policy.lowercase }" />
<input type="hidden" id="uppercase" value="${ policy.uppercase }" />
<input type="hidden" id="numbers" value="${ policy.numbers }" />
<input type="hidden" id="pensioner_id" value="${ pensioner_id }" />

<div class="container-fluid navigation-bar">
    <div class="container-fluid">
        <div class="col-md-2">
            <div id="sidebar-left">
                <h2 class="text-center">
                    <small>MAIN MENU</small>
                </h2>
                <ul id="main-menu" class="nav">
                    <li id="pensioner-dashboard-li" class="active"><a href="javascript:void(0);"><i
                            class="glyphicon glyphicon-dashboard"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i> DASHBOARD</a></li>

                    <c:if test="${pensionerMenu.personalInfo == 'TRUE'}">
                    <li id="pensioner-information-li"><a href="javascript:void(0);" ><i
                            class="glyphicon glyphicon-user"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i> PERSONAL INFORMATION</a></li>
                    </c:if>

                    <c:if test="${pensionerMenu.pensionDetails == 'TRUE'}">
                    <li id="pension-details-li"><a href="javascript:void(0);"><i
                            class="glyphicon glyphicon-screenshot"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i> PENSION DETAILS</a></li>
                    </c:if>

                    <c:if test="${pensionerMenu.pensionAdviceReport == 'TRUE'}">
                    <li id="pension-advice-li"><a href="javascript:void(0);"><i
                            class="glyphicon glyphicon-file"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i> PENSION ADVICE (REPORT)</a></li>
                    </c:if>

                    <c:if test="${pensionerMenu.pensionAdviceGrid == 'TRUE'}">
                    <li id="pension-advice-grid"><a href="javascript:void(0);"><i
                            class="glyphicon glyphicon-file"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i> PENSION ADVICE (GRID)</a></li>
                    </c:if>

                    <c:if test="${pensionerMenu.media == 'TRUE'}">
                    <li id="media-files-li"><a href="javascript:void(0);"><i
                            class="glyphicon glyphicon-briefcase"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i> MEDIA &amp; FILES</a></li>
                    </c:if>
                </ul>
            </div>
        </div>

        <div class="col-md-7" id="dashboard">
            <jsp:include page="pensioner/dashboard.jsp" />
        </div>

        <div class="col-md-3">
            <div class="sidebar-right section">
                <c:if test="${ isManager }">
                    <button class="btn btn-danger btn-block" id="switch_profile">SWITCH TO MANAGERIAL PROFILE</button>
                </c:if>
                <h2><small>Active Scheme</small></h2>
                <select class="form-control" name="scheme_id" id="scheme_id" onchange="reloadmember();">
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

