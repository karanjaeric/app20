<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 2/20/17
  Time: 9:04 AM
  To change this template use File | Settings | File Templates.
--%>
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

        <li id="contribution-history-li"><a href="javascript:void(0);"><i
                class="glyphicon glyphicon-record"></i>&nbsp;<i
                class="fa fa-chevron-right"></i> CONTRIBUTION HISTORY (REPORT)</a></li>

        <li id="contribution-history-grid-li"><a href="javascript:void(0);"><i
                class="glyphicon glyphicon-record"></i>&nbsp;<i
                class="fa fa-chevron-right"></i> CONTRIBUTION HISTORY (GRID)</a></li>

        <li id="balances-history-li"><a href="javascript:void(0);"><i
                class="glyphicon glyphicon-list"></i>&nbsp;<i
                class="fa fa-chevron-right"></i> BALANCES HISTORY</a></li>
        <li id="statement-of-account-li"><a href="javascript:void(0);"><i
                class="glyphicon glyphicon-user"></i>&nbsp;<i
                class="fa fa-chevron-right"></i> STATEMENT OF ACCOUNT</a></li>
        <li id="benefits-projection-li"><a href="javascript:void(0);"><i
                class="glyphicon glyphicon-equalizer"></i>&nbsp;<i
                class="fa fa-chevron-right"></i> BENEFITS PROJECTION</a></li>
        <li id="what-if-analysis-li"><a href="javascript:void(0);"><i
                class="glyphicon glyphicon-equalizer"></i>&nbsp;<i
                class="fa fa-chevron-right"></i> WHAT IF ANALYSIS</a></li>
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