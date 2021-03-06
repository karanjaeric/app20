<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

            <c:if test="${memberMenu.contributionHistoryReport == 'TRUE'}">
                <li id="contribution-history-li"><a href="javascript:void(0);"><i
                            class="glyphicon glyphicon-record"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i> CONTRIBUTION HISTORY (REPORT)</a></li>
                    </c:if>

            <c:if test="${memberMenu.contributionHistoryGrid == 'TRUE'}">
                <li id="contribution-history-grid-li1"><a href="" data-toggle="modal" data-target="#dateRange"><i
                            class="glyphicon glyphicon-record"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i> CONTRIBUTION HISTORY (GRID)</a></li>
                    </c:if>

            <c:if test="${memberMenu.unitizedStatement == 'TRUE'}">
                <li id="unitized-statement-li"><a href="javascript:void(0);"><i
                            class="glyphicon glyphicon-user"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i> MEMBER STATEMENT</a></li>
                    </c:if>

            <c:if test="${memberMenu.memberCertificate == 'TRUE'}">
                <li id="member-certificate-li"><a href="javascript:void(0);"><i
                            class="glyphicon glyphicon-user"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i> MEMBER CERTIFICATE</a></li>
                    </c:if>

            <c:if test="${memberMenu.balancesHistory == 'TRUE'}">
                <li id="balances-history-li"><a href="javascript:void(0);"><i
                            class="glyphicon glyphicon-list"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i> BALANCES HISTORY (REPORT)</a></li>
                    </c:if>

            <li id="cumulative-statement-grid-li"><a href="javascript:void(0);"><i
                        class="glyphicon glyphicon-list"></i>&nbsp;<i
                        class="fa fa-chevron-right"></i> CUMULATIVE STATEMENT(GRID)</a></li>


            

            <c:if test="${memberMenu.balancesHistoryGrid == 'TRUE'}">
                <li id="balances-history-grid-li"><a href="javascript:void(0);"><i
                            class="glyphicon glyphicon-record"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i>CLOSING BALANCES HISTORY (GRID)</a></li>
                    </c:if>
            <!--            <li id=""><a href="closingBalances"><i
                                    class="glyphicon glyphicon-record"></i>&nbsp;<i
                                    class="fa fa-chevron-right"></i>CLOSING BALANCES HISTORY (Downloadable)</a></li>-->

            <c:if test="${memberMenu.statementOfAccount == 'TRUE'}">
                <li id="statement-of-account-li"><a href="javascript:void(0);"><i
                            class="glyphicon glyphicon-user"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i> STATEMENT OF ACCOUNT (REPORT)</a></li>
                    </c:if>

            <c:if test="${memberMenu.statementOfAccountGrid == 'TRUE'}">
                <li id="statement-of-account-grid-li"><a href="javascript:void(0);"><i
                            class="glyphicon glyphicon-user"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i> PROVISIONAL STATEMENT(GRID)</a></li>
                    </c:if>

            <c:if test="${memberMenu.benefitsProjection == 'TRUE'}">
                <li id="benefits-projection-li"><a href="javascript:void(0);"><i
                            class="glyphicon glyphicon-equalizer"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i> BENEFITS PROJECTION (REPORT)</a></li>
                    </c:if>

            <c:if test="${memberMenu.benefitProjectionGrid == 'TRUE'}">
                <li id="benefits-projection-grid-li"><a href="javascript:void(0);"><i
                            class="glyphicon glyphicon-equalizer"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i> BENEFITS PROJECTION (GRID)</a></li>
                    </c:if>

            <c:if test="${memberMenu.annualContributionStatement == 'TRUE'}">
                <li id="annual-contributions-li"><a href="javascript:void(0);"><i
                            class="glyphicon glyphicon-list-alt"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i> ANNUAL CONTRIBUTION STATEMENT (REPORT)</a></li>
                    </c:if>

            <c:if test="${memberMenu.annualContributionStatementGrid == 'TRUE'}">
                <li id="annual-contributions-grid-li"><a href="javascript:void(0);"><i
                            class="glyphicon glyphicon-list-alt"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i>CONTRIBUTION STATEMENT (GRID)</a></li>
                    </c:if>


            <c:if test="${memberMenu.provisionalMemberStatement == 'TRUE'}">
                <li id="provisional-member-li"><a href="javascript:void(0);"><i
                            class="glyphicon glyphicon-list-alt"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i> PROVISIONAL MEMBER STATEMENT</a></li>
                    </c:if>

            <c:if test="${memberMenu.whatIfAnalysis == 'TRUE'}">
                <li id="what-if-analysis-li"><a href="javascript:void(0);"><i
                            class="glyphicon glyphicon-equalizer"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i> BENEFITS PROJECTION</a></li>
                    </c:if>
                    <c:if test="${memberMenu.benefitsProjectionPage == 'TRUE'}">
                <li id="calculate-benefit-projection-li"><a href="javascript:void(0);"><i
                            class="glyphicon glyphicon-equalizer"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i> BENEFIT PROJECTION (CALCULATOR)</a></li>
                    </c:if>
                    <%--<c:if test="${memberMenu.memberBenefit == 'TRUE'}">--%>
                    <%--<li id="member-benefits-li"><a href="javascript:void(0);"><i--%>
                    <%--class="glyphicon glyphicon-equalizer"></i>&nbsp;<i--%>
                    <%--class="fa fa-chevron-right"></i> MEMBER BENEFIT</a></li>--%>
                    <%--</c:if>--%>
                    <c:if test="${memberMenu.memberBenefit == 'TRUE' }">
                <li id="member-benefits-li"><a href="javascript:void(0);"><i
                            class="glyphicon glyphicon-folder-close"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i> WITHDRAWALS MADE</a></li>
                    </c:if>
                    <c:if test="${memberMenu.sponsorBenefitsProjectionPage == 'TRUE'}">
                <li id="sponsor-calculate-benefit-projection-li"><a href="javascript:void(0);"><i
                            class="glyphicon glyphicon-equalizer"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i> SPONSOR BENEFIT PROJECTION (CALCULATOR)</a></li>
                    </c:if>

            <c:if test="${memberMenu.media == 'TRUE'}">
                <li id="media-files-li"><a href="javascript:void(0);"><i
                            class="glyphicon glyphicon-briefcase"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i> MEDIA &amp; FILES</a></li>
                    </c:if>
                    <c:if test="${memberMenu.document == 'TRUE'}">
                <li id="document-files-li"><a href="javascript:void(0);"><i
                            class="glyphicon glyphicon-briefcase"></i>&nbsp;<i
                            class="fa fa-chevron-right"></i> DOCUMENTS</a></li>
                    </c:if>

            <%--<c:if test="${MemberStatus != 'Active' }">--%>
            <%--<li id="member-claims-li"><a href="javascript:void(0);"><i--%>
            <%--class="glyphicon glyphicon-folder-close"></i>&nbsp;<i--%>
            <%--class="fa fa-chevron-right"></i> CLAIMS </a></li>--%>
            <%--</c:if>--%>


        </ul>
    </div>

    <!--         Modal -->
    <div class="modal fade" id="dateRange" role="dialog">
        <div class="modal-dialog">

            <!--                 Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 style="color:red;">Select Date Range</h4>
                </div>
                <div class="modal-body">
                    <form role="form"  action="">
                        <div class="form-group">
                            <label for="dateFrom" class="control-label">
                                Date From:
                            </label> <input type="text" readonly="readonly" name="dateFrom"
                                            class="form-control datepicker" id="dateFrom10"
                                            placeholder="Date From">
                        </div>
                        <div class="form-group">
                            <label for="dateTo" class="control-label">
                                Date To:
                            </label> <input type="text" readonly="readonly" name="dateTo"
                                            class="form-control datepicker" id="dateTo10"
                                            placeholder="Date To">
                        </div>



                        <button id="contribution-history-grid-li" type="button" class="btn btn-default btn-success btn-block"> Show History</button>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-default btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>

                </div>
            </div>
        </div>
    </div>

</div>

