<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
    <h3 class="text-center main-title" id="title">
        <i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;EDIT PERSONAL INFORMATION
    </h3>
    <form class="form-horizontal" method="post" id="pi-form">
        <input type="hidden" id="member_id" value="${ member.id }" />
        <input type="hidden" id="member_no" value="${ member.memberNo }" />
        <!--<input type="hidden" name="ACTION" id="ACTION" value="UPDATE_MEMBER" />-->
        <div class="row">
            <div class="col-md-6">
                <fieldset>
                    <legend>
                        <i class="fa fa-user"></i> &nbsp;Personal
                    </legend>
                    <div class="form-group">
                        <label for="firstname" class="col-sm-6 control-label">First Name:</label>
                        <div class="col-sm-6">
                            <input
                                type="text" name="firstname" class="form-control  input-sm" id="firstname"
                                placeholder="Firstname" value="${ member.firstname }"  ${memberPermission.name == 'TRUE' ? '' : 'disabled'}>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="surname" class="col-sm-6 control-label">Surname:</label>
                        <div class="col-sm-6">
                            <input
                                type="text" name="surname" class="form-control  input-sm" id="surname"
                                placeholder="Surname" value="${ member.surname }"  ${memberPermission.name == 'TRUE' ? '' : 'disabled'}>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="surname" class="col-sm-6 control-label">Other Names:</label>
                        <div class="col-sm-6">
                            <input
                                type="text" name="othernames" class="form-control  input-sm" id="otherNames"
                                placeholder="Other Names" value="${ member.othernames }"  ${memberPermission.name == 'TRUE' ? '' : 'disabled'}>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="dateOfBirth" class="col-sm-6 control-label">Date Of
                            Birth:</label>
                        <div class="col-sm-6">
                            <input type="text" readonly="readonly" name="dateOfBirth"
                                   class="form-control  input-sm datepicker" id="dateOfBirth"
                                   placeholder="Date Of Birth" value="${ member.dateOfBirth }" ${memberPermission.dateOfBirth == 'TRUE' ? '' : 'disabled'}>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="gender" class="col-sm-6 control-label">Gender:</label>
                        <div class="col-sm-6">
                            <select
                                name="gender" id="gender" class="form-control  input-sm" ${memberPermission.gender == 'TRUE' ? '' : 'disabled'}>
                                <option value="">Select gender...</option>
                                <c:forEach var="gender" items="${genders}">
                                    <c:choose>
                                        <c:when test="${member.gender == gender.name }">
                                            <option selected="selected">
                                                ${gender.name}
                                            </option>
                                        </c:when>
                                        <c:otherwise>
                                            <option>
                                                ${gender.name}
                                            </option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="maritalStatus" class="col-sm-6 control-label">Marital
                            Status:</label>
                        <div class="col-sm-6">
                            <select name="maritalStatus" id="maritalStatus"
                                    class="form-control  input-sm" ${memberPermission.maritalStatus == 'TRUE' ? '' : 'disabled'}>
                                <option value="">Select marital status...</option>
                                <c:forEach var="maritalStatus" items="${maritalStatuses}">
                                    <c:choose>
                                        <c:when test="${member.maritalStatus == maritalStatus.name }">
                                            <option value="${maritalStatus.name}" selected="selected">
                                                ${maritalStatus.name}
                                            </option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${maritalStatus.name}">
                                                ${maritalStatus.name}
                                            </option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="idNumber" class="col-sm-6 control-label">ID/Passport
                            Number:</label>
                        <div class="col-sm-6">
                            <input type="text" name="idNumber" class="form-control  input-sm"
                                   id="idNumber" value="${ member.idNumber }" placeholder="ID/Passport Number" ${memberPermission.idNumber == 'TRUE' ? '' : 'disabled'}>
                        </div>
                    </div>
                </fieldset>
            </div>
            <div class="col-md-6">
                <fieldset>
                    <legend>
                        <i class="fa fa-phone"></i> &nbsp;Contact
                    </legend>
                    <div class="form-group">
                        <label for="emailAddress" class="col-sm-6 control-label">Email
                            Address:</label>
                        <div class="col-sm-6"><input type="text" name="emailAddress"
                                                     class="form-control  input-sm" id="emailAddress"
                                                     placeholder="Email Address" value="${ member.emailAddress }" ${memberPermission.emailAddress == 'TRUE' ? '' : 'disabled'}>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="phoneNumber" class="col-sm-6 control-label">Phone
                            Number:</label>
                        <div class="col-sm-6"><input type="text" name="phoneNumber"
                                                     class="form-control  input-sm" id="phoneNumber" value="${ member.phoneNumber }" placeholder="Phone Number" ${memberPermission.phoneNumber == 'TRUE' ? '' : 'disabled'}>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="postalAddress" class="col-sm-6 control-label">Postal Address:</label>
                        <div class="col-sm-6"><input type="text" name="postalAddress"
                                                     class="form-control  input-sm" id="postalAddress"
                                                     placeholder="Postal Address" value="${ member.postalAddress }" ${memberPermission.postalAddress == 'TRUE' ? '' : 'disabled'}>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="city" class="col-sm-6 control-label">City Or Town:</label>
                        <div class="col-sm-6"><input
                                type="text" value="${ member.town }" name="city" class="form-control  input-sm" id="city"
                                placeholder="City or Town" ${memberPermission.town == 'TRUE' ? '' : 'disabled'}>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="region" class="col-sm-6 control-label">Region:</label>
                        <div class="col-sm-6"><input
                                type="text" value="${ member.region }" name="region" class="form-control  input-sm" id="region"
                                placeholder="Region" ${memberPermission.region == 'TRUE' ? '' : 'disabled'}>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="county" class="col-sm-6 control-label">County:</label>
                        <div class="col-sm-6"><input
                                type="text" value="${ member.county }" name="county" class="form-control  input-sm" id="county"
                                placeholder="County" ${memberPermission.county == 'TRUE' ? '' : 'disabled'}>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="depot" class="col-sm-6 control-label">Station:</label>
                        <div class="col-sm-6"><input
                                type="text" value="${ member.depot }" name="depot" class="form-control  input-sm" id="depot"
                                placeholder="Station" ${memberPermission.depot == 'TRUE' ? '' : 'disabled'}>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="country" class="col-sm-6 control-label">Country:</label>
                        <div class="col-sm-6"><select
                                name="country" id="country" class="form-control  input-sm" ${memberPermission.country == 'TRUE' ? '' : 'disabled'}>
                                <option value="">Select country...</option>
                                <c:forEach var="country" items="${countries}">
                                    <c:choose>
                                        <c:when test="${member.country == country.name }">
                                            <option selected="selected">
                                                ${country.name}
                                            </option>
                                        </c:when>
                                        <c:otherwise>
                                            <option>
                                                ${country.name}
                                            </option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </fieldset>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <fieldset>
                    <legend>
                        <i class="fa fa-user"></i> &nbsp;Other Details
                    </legend>
                    <div class="form-group">
                        <label for="memberNo" class="col-sm-6 control-label">Member No:</label>
                        <div class="col-sm-6"><input
                                type="text" name="memberNo" class="form-control  input-sm" id="memberNo"
                                placeholder="Member No" value="${ member.memberNo }"  ${memberPermission.memberNo == 'TRUE' ? '' : 'disabled'}>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="department" class="col-sm-6 control-label">Department:</label>
                        <div class="col-sm-6">
                            <input type="text" name="department" id="department" placeholder="Department" class="form-control  input-sm" value="${ member.department }" ${memberPermission.department == 'TRUE' ? '' : 'disabled'}/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="designation" class="col-sm-6 control-label">Designation:</label>
                        <div class="col-sm-6">
                            <input type="text" name="designation" id="designation" placeholder="Desgnation" class="form-control  input-sm" value="${ member.designation }" ${memberPermission.designation == 'TRUE' ? '' : 'disabled'}/>
                        </div>
                    </div>





                    <c:choose>
                        <c:when test="${clientSetup.clientOrdinal == 'KP' }">

                            <div class="form-group">
                                <label for="pinNo" class="col-sm-6 control-label">PIN NUMBER:</label>
                                <div class="col-sm-6">
                                    <input type="text" name="pinNo" id="pinNo" placeholder="PIN Number" class="form-control  input-sm" value="${ member.pinNo }" ${memberPermission.pinNo == 'TRUE' ? '' : 'disabled'}/>
                                </div>
                            </div>
                        </c:when>

                        <c:otherwise>
                            <div class="form-group">
                                <label for="ssnitNumber" class="col-sm-6 control-label">Social Security Number:</label>
                                <div class="col-sm-6"><input type="text" readonly="readonly" name="ssnitNumber"
                                                             class="form-control  input-sm" id="ssnitNumber"
                                                             placeholder="S.Security Number" value="${ member.nationalPenNo }" ${memberPermission.dateOfBirth == 'TRUE' ? '' : 'disabled'}>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="policyNo" class="col-sm-6 control-label">Policy Number:</label>
                                <div class="col-sm-6">
                                    <input type="text" name="policyNo" id="policyNo" placeholder="Policy Number" class="form-control  input-sm" value="${ member.policyNo }" ${memberPermission.policyNo == 'TRUE' ? '' : 'disabled'}/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="partyRefNo" class="col-sm-6 control-label">Party Ref. No.:</label>
                                <div class="col-sm-6">
                                    <input type="text" name="partyRefNo" id="partyRefNo" placeholder="Party Ref. No" class="form-control  input-sm" value="${ member.partyRefNo }" ${memberPermission.partyRefNo == 'TRUE' ? '' : 'disabled'}/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="pinNo" class="col-sm-6 control-label">TAX NUMBER:</label>
                                <div class="col-sm-6">
                                    <input type="text" name="pinNo" id="pinNo" placeholder="PIN Number" class="form-control  input-sm" value="${ member.pinNo }" ${memberPermission.pinNo == 'TRUE' ? '' : 'disabled'}/>
                                </div>
                            </div>
                        </c:otherwise>

                    </c:choose>


                </fieldset>
                <button class="btn btn-primary"  type="submit">UPDATE DETAILS</button>
            </div>

            <div class="col-md-6" id="beneficiaries">
                <div id="editor"></div>
                <fieldset>
                    <legend>
                        <i class="fa fa-user"></i> &nbsp;Beneficiaries
                    </legend>
                    <table style="font-size: 12px" class="table table-responsive table-condensed table-hover table-striped" id="beneficiariesTbl">
                        <thead>
                            <!--<button type="button" class="btn btn-success" onclick="genBeneficiariesPDF()">Download Beneficiaries</button>-->
                            <tr style="font-size: smaller"><th>Name</th><th>Relationship</th><th>Entitlement</th><th>Actions</th></tr>

                        </thead>
                        <tbody>
                            <c:forEach var="beneficiary" items="${ beneficiaries }">
                                <tr><td> ${beneficiary.surname } ${ beneficiary.firstname } ${ beneficiary.othernames }</td>
                                    <td>${ beneficiary.relationship }</td><td>${ beneficiary.lumpsumEntitlement }</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${ profile == 'MEMBER' }">
                                                <a class="btn btn-warning btn-sm" href="javascript:void(0);"  onclick="edit_beneficiary('${ beneficiary.id }')">												</c:when>
                                                <c:otherwise>
                                                    <a class="btn btn-warning btn-sm disabled" href="javascript:void(0);"  onclick="edit_beneficiary('${ beneficiary.id }')">												</c:otherwise>
                                                </c:choose>
                                                <i class="glyphicon glyphicon-pencil"></i>&nbsp;Edit</a>&nbsp;

                                            <a class="btn btn-sm btn-info" href="javascript:void(0);" onclick="view_beneficiary('${beneficiary.id}')">
                                                <i class="glyphicon glyphicon-apple"></i>&nbsp;View</a>&nbsp;
                                    </td>
                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>
                    <c:choose>
                        <c:when test="${totalPercentageLumpsum ==100}">
                            <a class="btn btn-success btn-sm disabled" href="javascript:void(0);" data-toggle="tooltip" title="You CANNOT Add a New Beneficiary!" onclick="add_beneficiary();">ADD BENEFICIARY</a>.
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${ profile == 'MEMBER' }">
                                    <a class="btn btn-success btn-sm" href="javascript:void(0);" onclick="add_beneficiary();">ADD BENEFICIARY</a>
                                </c:when>
                                <c:otherwise>
                                    <a class="btn btn-success btn-sm disabled" href="javascript:void(0);" onclick="add_beneficiary();">ADD BENEFICIARY</a>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>


                </fieldset>
            </div>
        </div>

    </form>
    <div class="row">

        <div class="col-md-6" style="margin-bottom:15px">
            <form role="form" id="form-upload-document">

                <input type="hidden" name="ACTION" id="ACTION" value="UPLOAD_DOCUMENT" />

                <fieldset>

                    <legend>
                        <i class="fa fa-upload"></i> &nbsp;Upload Document
                    </legend>

                    <div class="form-group">
                        <div class="col-sm-6">
                            <input type="file" class="filestyle" data-buttonName="btn-primary" id="attachment" name="attachment" data-buttonBefore="true" />
                        </div>
                    </div>

                </fieldset>
                <br>

                <input class="btn btn-primary" type="submit" value="Upload File" id="btn-file">

            </form>

        </div>

    </div>
</div>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">

                                        function add_beneficiary()
                                        {
                                            start_wait();
                                            $.ajax({
                                                url: $('#base_url').val() + 'admin',
                                                type: 'post',
                                                data: {ACTION: 'GET_BENEFICIARY', memberID: $('#member_id').val(), type: 'ADD'},
                                                dataType: 'html',
                                                success: function (html) {
                                                    stop_wait();
                                                    $('#modal-edit-beneficiary').modal('show');
                                                    $('#beneficiary-content').html(html);
                                                }
                                            });
                                        }
                                        function edit_beneficiary(id)
                                        {
                                            start_wait();
                                            $.ajax({
                                                url: $('#base_url').val() + 'admin',
                                                type: 'post',
                                                data: {ACTION: 'GET_BENEFICIARY', beneficiaryID: id, memberID: $('#member_id').val(), type: 'EDIT'},
                                                dataType: 'html',
                                                success: function (html) {
                                                    stop_wait();
                                                    $('#modal-edit-beneficiary').modal('show');
                                                    $('#beneficiary-content').html(html);
                                                }
                                            });
                                        }

                                        function view_beneficiary(id)
                                        {
                                            start_wait();
                                            $.ajax({
                                                url: $('#base_url').val() + 'admin',
                                                type: 'post',
                                                data: {ACTION: 'VIEW_BENEFICIARY', beneficiaryID: id, memberID: $('#member_id').val()},
                                                dataType: 'html',
                                                success: function (html) {
                                                    $('#beneficiary-content2').html(html);
                                                    $('#modal-view-beneficiary').modal('show');
                                                    stop_wait();
                                                }
                                            });
                                        }

                                        $(document).ready(function () {
                                            $('#pi-form')
                                                    .bootstrapValidator(
                                                            {
                                                                excluded: ':disabled',
                                                                message: 'This value is not valid',
                                                                feedbackIcons: {
                                                                    valid: 'glyphicon glyphicon-ok',
                                                                    invalid: 'glyphicon glyphicon-remove',
                                                                    validating: 'glyphicon glyphicon-refresh'
                                                                },
                                                                fields: {
                                                                    firstname: {
                                                                        validators: {
                                                                            notEmpty: {
                                                                                message: 'Please enter your firstname'
                                                                            }
                                                                        }
                                                                    },
                                                                    surname: {
                                                                        validators: {
                                                                            notEmpty: {
                                                                                message: 'Please enter your surname'
                                                                            }
                                                                        }
                                                                    },
                                                                    othernames: {
                                                                        validators: {
                                                                            notEmpty: {
                                                                                message: 'Please enter your other names'
                                                                            }
                                                                        }
                                                                    },
                                                                    currentAnnualPensionableSalary: {
                                                                        validators: {
                                                                            notEmpty: {
                                                                                message: 'Please enter your current salary'
                                                                            }
                                                                        }
                                                                    },
                                                                    gender: {
                                                                        validators: {
                                                                            notEmpty: {
                                                                                message: 'Please select your gender'
                                                                            }
                                                                        }
                                                                    },
                                                                    dateOfBirth: {
                                                                        validators: {
                                                                            notEmpty: {
                                                                                message: 'Please select your date of birth'
                                                                            }
                                                                        }
                                                                    },
                                                                    idNumber: {
                                                                        validators: {
                                                                            notEmpty: {
                                                                                message: 'Please enter your ID Number'
                                                                            }
                                                                        }
                                                                    },
                                                                    emailAddress: {
                                                                        validators: {
                                                                            notEmpty: {
                                                                                message: 'Please enter your email address'
                                                                            }
                                                                        }
                                                                    },
                                                                    maritalStatus: {
                                                                        validators: {
                                                                            notEmpty: {
                                                                                message: 'Please select the marital status'
                                                                            }
                                                                        }
                                                                    },
                                                                    phoneNumber: {
                                                                        validators: {
                                                                            notEmpty: {
                                                                                message: 'Please enter your phone number'
                                                                            }
                                                                        }
                                                                    },
                                                                    postalAddress: {
                                                                        validators: {
                                                                            notEmpty: {
                                                                                message: 'Please select your postal/residential address'
                                                                            }
                                                                        }
                                                                    },
                                                                    city: {
                                                                        validators: {
                                                                            notEmpty: {
                                                                                message: 'Please enter your town/city'
                                                                            }
                                                                        }
                                                                    },
                                                                    country: {
                                                                        validators: {
                                                                            notEmpty: {
                                                                                message: 'Please select your country'
                                                                            }
                                                                        }
                                                                    },
                                                                }
                                                            })
                                                    .on(
                                                            'success.form.bv',
                                                            function (e) {
                                                                start_wait();
                                                                // Prevent form submission
                                                                e.preventDefault();
                                                                // Get the form instance
                                                                var form = "pi-form";
                                                                console.log('The form is: ' + form);
                                                                /*var formData = new FormData($(this)[0]);
                                                                 
                                                                 memberID = $('#member_id').val();
                                                                 formData.append("memberID", memberID);
                                                                 
                                                                 memberNo = $('#member_no').val();
                                                                 formData.append("memberNo", memberNo);*/

                                                                $.ajax({
                                                                    url: $('#base_url').val() + 'admin',
                                                                    type: 'post',
                                                                    data: {
                                                                        ACTION: 'UPDATE_MEMBER',
                                                                        memberID: $('#member_id')
                                                                                .val(),
                                                                        memberNo: $('#member_no')
                                                                                .val(),
                                                                        firstname: $('#firstname')
                                                                                .val(),
                                                                        surname: $('#surname')
                                                                                .val(),
                                                                        othernames: $('#otherNames')
                                                                                .val(),
                                                                        gender: $('#gender')
                                                                                .val(),
                                                                        idNumber: $('#idNumber')
                                                                                .val(),
                                                                        dateOfBirth: $('#dateOfBirth')
                                                                                .val(),
                                                                        emailAddres: $('#emailAddress')
                                                                                .val(),
                                                                        maritalStatus: $("#maritalStatus")
                                                                                .val(),
                                                                        phoneNumber: $('#phoneNumber')
                                                                                .val(),
                                                                        postalAddress: $('#postalAddress')
                                                                                .val(),
                                                                        city: $('#city')
                                                                                .val(),
                                                                        country: $('#country')
                                                                                .val(),
                                                                        currentAnnualPensionableSalary: $('#currentAnnualPensionableSalary')
                                                                                .val()
                                                                    },
                                                                    dataType: 'json',
                                                                    success: function (json) {
                                                                        stop_wait();
                                                                        bootbox
                                                                                .alert('<p class="text-center">'
                                                                                        + json.message
                                                                                        + '</p>');
                                                                    }
                                                                });
                                                            });
                                            $('#form-edit-beneficiary')
                                                    .bootstrapValidator(
                                                            {
                                                                excluded: ':disabled',
                                                                message: 'This value is not valid',
                                                                feedbackIcons: {
                                                                    valid: 'glyphicon glyphicon-ok',
                                                                    invalid: 'glyphicon glyphicon-remove',
                                                                    validating: 'glyphicon glyphicon-refresh'
                                                                },
                                                                fields: {
                                                                    firstname: {
                                                                        validators: {
                                                                            notEmpty: {
                                                                                message: 'Please enter the firstname'
                                                                            }
                                                                        }
                                                                    },
                                                                    surname: {
                                                                        validators: {
                                                                            notEmpty: {
                                                                                message: 'Please enter the surname'
                                                                            }
                                                                        }
                                                                    },
                                                                    othernames: {
                                                                        validators: {
                                                                            notEmpty: {
                                                                                message: 'Please enter the othername'
                                                                            }
                                                                        }
                                                                    },
                                                                    lumpsumEntitlement: {
                                                                        validators: {
                                                                            notEmpty: {
                                                                                message: 'Please enter the lumpsum entitlement'
                                                                            }
                                                                        }
                                                                    },
                                                                    gender: {
                                                                        validators: {
                                                                            notEmpty: {
                                                                                message: 'Please select the gender'
                                                                            }
                                                                        }
                                                                    },
                                                                    relationship: {
                                                                        validators: {
                                                                            notEmpty: {
                                                                                message: 'Please select the relationship'
                                                                            }
                                                                        }
                                                                    },
                                                                    relationshipCategory: {
                                                                        validators: {
                                                                            notEmpty: {
                                                                                message: 'Please select the relationship category'
                                                                            }
                                                                        }
                                                                    },
                                                                    maritalStatus: {
                                                                        validators: {
                                                                            notEmpty: {
                                                                                message: 'Please select the marital status'
                                                                            }
                                                                        }
                                                                    },
                                                                    status: {
                                                                        validators: {
                                                                            notEmpty: {
                                                                                message: 'Please select the status'
                                                                            }
                                                                        }
                                                                    },
                                                                    file: {
                                                                        validators: {
                                                                            extension: 'jpeg,jpg,png,doc,docx,pdf,xls,txt',
                                                                            type: 'image/jpeg,image/png,application/msword,application/pdf,application/vnd.ms-excel,',
                                                                            maxSize: 2097152, // 2048 * 1024
                                                                            message: 'The selected file is not valid'
                                                                        }
                                                                    }
                                                                }
                                                            })

                                                    .on('success.form.bv', function (e) {
                                                        start_wait();
                                                        // Prevent form submission
                                                        e.preventDefault();
                                                        // Get the form instance
                                                        var modal = "modal-edit-beneficiary";
                                                        //Define formData object
                                                        var formData = new FormData($(this)[0]);
                                                        type = $('#type').val();
                                                        formData.append("type", type);
                                                        memberID = $('#member_id').val();
                                                        formData.append("memberID", memberID);
                                                        beneficiary_id = $('#beneficiary_id').val();
                                                        formData.append("beneficiary_id", beneficiary_id);
                                                        firstname = $('#firstName').val();
                                                        formData.append("firstname", firstname);
                                                        //firstname = $('#firstname').val();
                                                        //formData.append("firstname", firstname);

                                                        $.ajax({
                                                            url: $('#base_url').val() + 'admin',
                                                            type: 'post',
                                                            data: formData,
                                                            dataType: 'json',
                                                            success: function (json) {
                                                                stop_wait();
                                                                if (json.success)
                                                                {
                                                                    $('form#form-edit-beneficiary')[0].reset();
                                                                    $('#modal-edit-beneficiary').modal('hide');
                                                                    $('#personal-information-li').addClass('active');
                                                                    m_switch("PI");
                                                                }
                                                                bootbox
                                                                        .alert('<p class="text-center">'
                                                                                + json.message
                                                                                + '</p>');
                                                            },
                                                            cache: false,
                                                            contentType: false,
                                                            processData: false
                                                        });
                                                        function m_switch(MODULE)
                                                        {
                                                            menu_done = true;
                                                            start_wait();
                                                            loadDashboard(MODULE);
                                                        }
                                                    });
                                            $('#form-upload-document').bootstrapValidator({
                                                message: 'This value is not valid',
                                                feedbackIcons: {
                                                    valid: 'glyphicon glyphicon-ok',
                                                    invalid: 'glyphicon glyphicon-remove',
                                                    validating: 'glyphicon glyphicon-refresh'
                                                },
                                                fields: {
                                                    attachment: {

                                                        extension: 'doc,docx,xls,xlsx,pdf,jpg,jpeg,png,gif',
                                                        type: 'image/png,image/gif,image/jpg,image/jpeg',
                                                        maxSize: 100 * 1024 * 1024, // 100 MB
                                                        message: 'The selected file is not valid, it should be (png,gif,jpg,jpeg) and 5 MB at maximum.'

                                                    }
                                                }
                                            })
                                                    .on('success.form.bv', function (e) {

                                                        start_wait();
                                                        // Prevent form submission
                                                        e.preventDefault();
                                                        // Get the form instance
                                                        var form = "form-upload-document";
                                                        var formData = new FormData($(this)[0]);
                                                        memberID = $('#member_id').val();
                                                        formData.append("memberID", memberID);
                                                        memberNo = $('#member_no').val();
                                                        formData.append("memberNo", memberNo);
                                                        //$('#' + btn).val('Please wait...');

                                                        $.ajax({
                                                            url: $('#base_url').val() + 'admin',
                                                            type: 'post',
                                                            data: formData,
                                                            dataType: 'json',
                                                            async: false,
                                                            cache: false,
                                                            contentType: false,
                                                            processData: false,
                                                            success: function (json) {
                                                                stop_wait();
                                                                bootbox
                                                                        .alert('<p class="text-center">'
                                                                                + json.message
                                                                                + '</p>');
                                                            }
                                                        });
                                                    });
                                        });
                                        $(document).ready(function () {
                                            $('#beneficiariesTbl').DataTable({

                                                dom: 'Bfrtip',
                                                "searching": false,
                                                "bSort": false,
                                                //bFilter: false,
                                                paging: false,
                                                "bInfo" : false,

                                                buttons: [

                                                    {
                                                        extend: 'pdfHtml5',
                                                        title: 'Beneficiaries',
                                                        orientation: 'landscape', //landscape give you more space
                                                        pageSize: 'A4', //A0 is the largest A5 smallest(A0,A1,A2,A3,legal,A4,A5,letter))
                                                        exportOptions: {
                                                            columns: [0, 1, 2]
                                                        }


                                                    }

                                                ]
                                            });
                                        });

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

<div class="modal fade"  id="modal-edit-beneficiary" tabindex="-1" role="dialog" aria-labelledby="myModalLabelEditBeneficiary" aria-hidden="true">
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
