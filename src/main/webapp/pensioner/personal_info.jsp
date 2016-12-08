<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 11/28/16
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
    <h3 class="text-center main-title" id="title">
        <i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;PERSONAL INFORMATION
    </h3>
    <form class="form-horizontal" method="post" id="pi-form">
        <input type="hidden" id="pensioner_id" value="${ pensioner.id }" />
        <input type="hidden" id="member_id" value="${ memberId }" />
        <input type="hidden" id="member_no" value="${ pensioner.memberNo }" />

        <div class="row">
            <div class="col-md-6">
                <fieldset>
                    <legend>
                        <i class="fa fa-user"></i> &nbsp;Personal Info
                    </legend>
                    <div class="form-group">
                        <label for="name" class="col-sm-6 control-label">Full Name:</label>
                        <div class="col-sm-6">
                            <input
                                    type="text" name="name" class="form-control  input-sm" id="name"
                                    placeholder="Name" value="${ pensioner.name }" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="dateOfBirth" class="col-sm-6 control-label">Date Of
                            Birth:</label>
                        <div class="col-sm-6">
                            <input type="text" readonly="readonly" name="dateOfBirth"
                                   class="form-control  input-sm datepicker" id="dateOfBirth"
                                   placeholder="Date Of Birth" value="${ pensioner.dob }">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="gender" class="col-sm-6 control-label">Gender:</label>
                        <div class="col-sm-6">
                            <input
                                    type="text" name="gender" class="form-control  input-sm" id="gender"
                                    placeholder="Gender" value="${ pensioner.gender }" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="idNumber" class="col-sm-6 control-label">ID/Passport
                            Number:</label>
                        <div class="col-sm-6">
                            <input type="text" name="idNumber" class="form-control  input-sm"
                                   id="idNumber" value="${ pensioner.idNo }" placeholder="ID/Passport Number">
                        </div>
                    </div>
                </fieldset>
            </div>
            <div class="col-md-6">
                <fieldset>
                    <legend>
                        <i class="fa fa-phone"></i> &nbsp;Contact Info
                    </legend>
                    <div class="form-group">
                        <label for="phoneNumber" class="col-sm-6 control-label">Phone
                            Number:</label>
                        <div class="col-sm-6"><input type="text" name="phoneNumber"
                                                     class="form-control  input-sm" id="phoneNumber" value="${ pensioner.cellPhone }" placeholder="Phone Number">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="postalAddress" class="col-sm-6 control-label">Postal Address:</label>
                        <div class="col-sm-6"><input type="text" name="postalAddress"
                                                     class="form-control  input-sm" id="postalAddress"
                                                     placeholder="Postal Address" value="${ pensioner.postalAddress }">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="city" class="col-sm-6 control-label">City Or Town:</label>
                        <div class="col-sm-6"><input
                                type="text" value="${ pensioner.town }" name="city" class="form-control  input-sm" id="city"
                                placeholder="City or Town">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="country" class="col-sm-6 control-label">Country:</label>
                        <div class="col-sm-6">
                            <input
                                    type="text" value="${ pensioner.country }" name="country" class="form-control  input-sm" id="country"
                                    placeholder="Country">
                        </div>
                    </div>
                </fieldset>
            </div>
        </div>

        <div class="row">

            <div class="col-md-6">
                <fieldset>
                    <legend>
                        <i class="fa fa-user"></i> &nbsp;Beneficiaries
                    </legend>
                    <table class="table table-responsive table-striped">
                        <tr><th>NAME</th><th>RELATIONSHIP</th><th>ENTITLEMENT</th><th>ACTIONS</th></tr>
                        <c:forEach var="beneficiary" items="${ beneficiaries }">
                            <tr><td> ${beneficiary.surname } ${ beneficiary.firstname } ${ beneficiary.othernames }</td>
                                <td>${ beneficiary.relationship }</td><td>${ beneficiary.lumpsumEntitlement }</td>
                                <td><a class="btn btn-sm btn-info" href="javascript:void(0);" onclick="view_beneficiary('${beneficiary.id}')">
                                        <i class="glyphicon glyphicon-eye-open">&nbsp;VIEW</i></a>
                                </td></tr>
                        </c:forEach>
                    </table>
                </fieldset>
            </div>

        </div>

        </form>
</div>

<script type="text/javascript">

    function view_beneficiary(id)
    {
        start_wait();
        $.ajax({
            url: $('#base_url').val() + 'admin',
            type: 'post',
            data: {ACTION:'VIEW_BENEFICIARY', beneficiaryID: id, memberID: $('#member_id').val()},
            dataType: 'html',
            success: function(html) {
                $('#beneficiary-content2').html(html);
                $('#modal-view-beneficiary').modal('show');

                stop_wait();
            }
        });
    }
</script>

<div class="modal fade" id="modal-view-beneficiary" tabindex="-1" role="dialog" aria-labelledby="myModalLabelViewBeneficiary" aria-hidden="true">
    <form role="form" id="form-view-beneficiary">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title" id="myModalLabelViewMember">
                        <i class="glyphicon glyphicon-picture"></i>&nbsp;&nbsp;VIEW BENEFICIARY DETAILS
                    </h4>
                </div>
                <div class="modal-body" id="beneficiary-content2">

                </div>
            </div>
        </div>
    </form>
</div>

<div class="modal fade" id="modal-edit-beneficiary" tabindex="-1" role="dialog" aria-labelledby="myModalLabelEditBeneficiary" aria-hidden="true">
    <form role="form" id="form-edit-beneficiary" enctype="multipart/form-data">
        <div class="modal-dialog large-modal">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title" id="myModalLabelEditBeneficiary">
                        <i class="glyphicon glyphicon-picture"></i>&nbsp;&nbsp;BENEFICIARY DETAILS
                    </h4>
                </div>
                <div class="modal-body" id="beneficiary-content">

                </div>

                <div class="modal-footer">
                    <a href="#" class="btn btn-warning" data-dismiss="modal">Cancel</a>
                    <input class="btn btn-primary" type="submit"
                           value="Save Beneficiary Details" id="btn-beneficiary">
                </div>
            </div>
        </div>
    </form>
</div>




























