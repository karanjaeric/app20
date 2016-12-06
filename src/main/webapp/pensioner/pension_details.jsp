<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 11/28/16
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">

    <h3 class="text-center main-title" id="title">
        <i class="glyphicon glyphicon-screenshot"></i>&nbsp;&nbsp; PENSIONER DETAILS
    </h3>

    <form class="form-horizontal" method="post" id="pd-form">

        <div class="row">
            <div class="col-md-6">
                <fieldset>
                    <legend>
                        <i class="fa fa-id-card-o"></i> &nbsp;Pension Details
                    </legend>

                    <div class="form-group">
                        <label for="pensionStatus" class="col-sm-6 control-label">Pension Status:</label>
                        <div class="col-sm-6">
                            <input
                                    type="text" disabled name="pensionStatus" class="form-control" id="pensionStatus"
                                    placeholder="Pension Status" value="${ pensioner.pensionStatus }" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pensionStartDate" class="col-sm-6 control-label">Pension Start Date:</label>
                        <div class="col-sm-6">
                            <input
                                    type="text" disabled name="pensionStartDate" class="form-control" id="pensionStartDate"
                                    placeholder="Pension Start Date" value="${ pensioner.pensionStartDate }" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pensionStopDate" class="col-sm-6 control-label">Pension Stop Date:</label>
                        <div class="col-sm-6">
                            <input
                                    type="text" disabled name="pensionStopDate" class="form-control" id="pensionStopDate"
                                    placeholder="Pension Stop Date" value="${ pensioner.pensionStopDate }" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="monthlyPension" class="col-sm-6 control-label">Monthly Pension:</label>
                        <div class="col-sm-6">
                            <input
                                    type="text" disabled name="monthlyPension" class="form-control" id="monthlyPension"
                                    placeholder="Monthly Pension" value="${ pensioner.monthlyPension }" >
                        </div>
                    </div>

                </fieldset>
            </div>
            <div class="col-md-6">
                <fieldset>
                    <legend>
                        <i class="fa fa-user"></i> &nbsp;Bank Details
                    </legend>
                    <div class="form-group">
                        <label for="bank" class="col-sm-6 control-label">Bank:</label>
                        <div class="col-sm-6">
                            <input
                                    type="text" disabled name="bank" class="form-control" id="bank"
                                    placeholder="Bank" value="${ pensioner.bankName }" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="bankBranch" class="col-sm-6 control-label">Bank Branch:</label>
                        <div class="col-sm-6">
                            <input
                                    type="text" disabled name="bankBranch" class="form-control" id="bankBranch"
                                    placeholder="Bank Branch" value="${ pensioner.branch }" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="accountName" class="col-sm-6 control-label">Account Name:</label>
                        <div class="col-sm-6">
                            <input
                                    type="text" disabled name="accountName" class="form-control" id="accountName"
                                    placeholder="Account Name" value="${ pensioner.accountName }" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="accountNumber" class="col-sm-6 control-label">Account Name:</label>
                        <div class="col-sm-6">
                            <input
                                    type="text" disabled name="accountNumber" class="form-control" id="accountNumber"
                                    placeholder="Account Number" value="${ pensioner.accountNumber }" >
                        </div>
                    </div>
                </fieldset>
            </div>
        </div>

    </form>

</div>