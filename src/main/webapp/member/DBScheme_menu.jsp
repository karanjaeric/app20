<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 2/20/17
  Time: 9:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-fluid section">
    <div id="sidebar-left">
        <h2 class="text-center">
            <small>MAIN MENU</small>
        </h2>
        <ul id="main-menu" class="nav">
            <li id="member-dashboard-li" class="active"><a href="javascript:void(0);"><i
                    class="glyphicon glyphicon-dashboard"></i>&nbsp;<i
                    class="fa fa-chevron-right"></i> DASHBOARD</a></li>
            <li id="personal-information-li"><a href="javascript:void(0);" ><i
                    class="glyphicon glyphicon-user"></i>&nbsp;<i
                    class="fa fa-chevron-right"></i> PERSONAL INFORMATION</a></li>

            <c:if test="${dbMenu.contributionHistoryActive == 'TRUE'}">
                <li id="contribution-history-li"><a href="javascript:void(0);"><i
                        class="glyphicon glyphicon-record"></i>&nbsp;<i
                        class="fa fa-chevron-right"></i> ${ dbMenu.contributionHistoryName }</a></li>
            </c:if>
            <c:if test="${dbMenu.balancesHistoryActive == 'TRUE'}">
                <li id="balances-history-li"><a href="javascript:void(0);"><i
                        class="glyphicon glyphicon-list"></i>&nbsp;<i
                        class="fa fa-chevron-right"></i> ${ dbMenu.balancesHistoryName }</a></li>
            </c:if>
            <c:if test="${dbMenu.statementOfAccountActive == 'TRUE'}">
                <li id="statement-of-account-li"><a href="javascript:void(0);"><i
                        class="glyphicon glyphicon-user"></i>&nbsp;<i
                        class="fa fa-chevron-right"></i> ${ dbMenu.statementOfAccountName }</a></li>
            </c:if>
            <c:if test="${dbMenu.benefitsProjectionActive == 'TRUE'}">
                <li id="benefits-projection-li"><a href="javascript:void(0);"><i
                        class="glyphicon glyphicon-equalizer"></i>&nbsp;<i
                        class="fa fa-chevron-right"></i> ${ dbMenu.benefitsProjectionName }</a></li>
            </c:if>
            <c:if test="${dbMenu.whatIfAnalysisActiveDb == 'TRUE'}">
                <li id="what-if-analysis-li"><a href="javascript:void(0);"><i
                        class="glyphicon glyphicon-equalizer"></i>&nbsp;<i
                        class="fa fa-chevron-right"></i> ${ dbMenu.whatIfAnalysisNameDb }0</a></li>
            </c:if>

            <li id="media-files-li"><a href="javascript:void(0);"><i
                    class="glyphicon glyphicon-briefcase"></i>&nbsp;<i
                    class="fa fa-chevron-right"></i> MEDIA &amp; FILES</a></li>

            <c:if test="${MemberStatus != 'Active' }">
                <li id="member-claims-li"><a href="javascript:void(0);"><i
                        class="glyphicon glyphicon-folder-close"></i>&nbsp;<i
                        class="fa fa-chevron-right"></i> CLAIMS </a></li>
            </c:if>

        </ul>
    </div>
</div>
