<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
    <form role="form" id="form-analysis">
        <h1 class="heading">DB Benefits Projection</h1>
        <fieldset>
            <legend>Calculation Parameters</legend>
            <input type="hidden" name="projectedROR" id="projectedROR" value="${ settings.projectedROR }" />
            <input type="hidden" name="sid" id="dbsid" value="${scheme_id}">
            <input type="hidden" name="mid" id="dbmid" value="${member_id}">
      


            <div class="col-md-3">
                <div class="form-group">
                    <label for="dbdateOfExit" class="control-label">Exit Date:</label>

                    <input type="text"  name="dbdateOfExit"
                           class="form-control datepicker" id="dbdateOfExit"
                           placeholder="Exit Date">
                </div>
            </div>


            <div class="col-md-3">
                <div class="form-group">
                    <label for="dbreasonForExit" class="control-label">Reason For Exit:</label>

                    <select id="dbreasonForExit" class="form-control">



                    </select>
                </div>
            </div>

            <div class="col-md-3">
                <p>&nbsp;</p>
                <button class="btn btn-primary">Calculate</button>
            </div>
        </fieldset>
        <p>&nbsp;</p>
    </form>

    <div class="container how-it-works">
        ${ content.text }

    </div>
</div>
<div class="container">
    <h3>PROJECTED RESULTS</h3>

    <div class='col-md-8'>
        <h3>EXIT DETAILS</h3>
        <table class="table table-responsive table-striped results">
            <tr>
                <td>Date of Exit:</td>
                <td><span id="DBdate_of_exit"></span></td>

            </tr>
            <tr>
                <td>Date of Calculation:</td>
                <td><span id="DBdate_of_calculation"></span></td>
            </tr>
            <tr>
                <td>Reason for Exit:</td>
                <td><span id="DBreason_for_exit"></span></td>

            </tr>
            <tr>
                <td>Age at Exit:</td>
                <td><span id="DBage_at_exit"></span></td>

            </tr>
            <tr>
                <td>Pensionable Service:</td>
                <td><span id="DBpensionable_service"></span></td>

            </tr>
            <tr>
                <td>Final Pensionable Salary:</td>
                <td><span id="DBfinal_pensionable_salary"></span></td>

            </tr>
        </table>





        <h3>PENSION CALCULATION</h3>
        <table class="table table-responsive table-striped results ">
            <tr>
                <td>Target Pension:</td>
                <td><span id="DBtarget_pension"></span></td>

            </tr>
            <tr>
                <td>Annual Pension:</td>
                <td><span id="DBannual_pension"></span></td>
            </tr>
            <tr>
                <td>Gross Monthly Pension:</td>
                <td><span id="DBgross_monthly_pension"></span></td>

            </tr>
            <tr>
                <td>Tax on Pension:</td>
                <td><span id="DBtax_on_pension"></span></td>

            </tr>
            <tr>
                <td>Net Monthly Pension:</td>
                <td><span id="DBnet_monthly_pension"></span></td>

            </tr>

        </table>


        <h3>COMMUTED LUMPSUM</h3>
        <table class="table table-responsive table-striped results">
            <tr>
                <td>Commuted Lumpsum:</td>
                <td><span id="DBcommuted_lumpsum"></span></td>

            </tr>
            <tr>
                <td>Tax Free Lumpsum:</td>
                <td><span id="DBtax_free_lumpsum"></span></td>
            </tr>
            <tr>
                <td>Taxable Amount:</td>
                <td><span id="DBtaxable_amount"></span></td>

            </tr>
            <tr>
                <td>Withholding Tax:</td>
                <td><span id="DBwithholding_tax"></span></td>

            </tr>
            <tr>
                <td>Member's Liability:</td>
                <td><span id="DBmember_liability"></span></td>

            </tr>
            <tr>
                <td>Lumpsum Payable:</td>
                <td><span id="DBlumpsum_payable"></span></td>

            </tr>


        </table>
    </div>
</div>



<c:if test="${ showScript }">
    <script type="text/javascript">
        $(document).ready(function () {

            $.ajax({
                url: $('#base_url').val() + 'admin',
                type: 'post',
                data: {ACTION: 'EXITREASONS'},
                dataType: 'json',
                success: function (json) {
                    if (json.success)
                    {
                        json = $.parseJSON(json.data);
                        console.log(json);

                        var combo = "<select id=\"dbreasonForExit\" name=\"reasonForExit\" class=\"form-control\"><option>--Select Reason For Exit--</option>";
                        $.each(json, function (key, value) {
                            if (key === 'rows')
                            {
                                for (var i = 0; i < json.rows.length; i++) {
                                    var row = json.rows[i];
                                    combo = combo + "<option value = " + row['id'] + ">" + row['reason'] + "</option>";
                                    array = json.rows;
                                }
                                combo = combo + "</select>";

                            }
                        });
                        $('#dbreasonForExit').html(combo);
                    } else
                    {
                        stop_wait();
                        bootbox.alert('<p class="text-center">' + json.message + '</p>');
                    }
                }
            });





            $('.datepicker').datetimepicker(
                    $('#dbdateOfExit').datetimepicker({
                format: 'mm-dd-yyyy',
                startView: 'month',
                minView: 'month',
                autoclose: true
            })
                    .on('changeDate', function (e) {
                        $(this).datetimepicker('hide');
                        // Revalidate the date field
                        $('#form-analysis').bootstrapValidator('revalidateField', 'dbdateOfExit');
                    }),
                    $('#dbdateOfExit')
                    .datetimepicker({
                        format: 'mm-dd-yyyy',
                        startView: 'month',
                        minView: 'month',
                        autoclose: true
                    })
                    );





            $('#form-analysis')
                    .bootstrapValidator(
                            {
                                message: 'This value is not valid',
                                feedbackIcons: {
                                    valid: 'glyphicon glyphicon-ok',
                                    invalid: 'glyphicon glyphicon-remove',
                                    validating: 'glyphicon glyphicon-refresh'
                                },
                                fields: {
                                    monthlyContributions: {
                                        validators: {
                                            notEmpty: {
                                                message: 'Please enter the monthly contributions'
                                            },
                                            numeric: {
                                                message: 'This value can and must only be a number'
                                            }
                                        }
                                    },
                                    rateOfReturn: {
                                        validators: {
                                            notEmpty: {
                                                message: 'Please enter the income rate of return'
                                            },
                                            numeric: {
                                                message: 'This value can and must only be a number'
                                            }
                                        }
                                    },
                                    emailAddress: {
                                        validators: {
                                            notEmpty: {
                                                message: 'Sorry, your email address is required'
                                            },
                                            emailAddress: {
                                                message: 'Oops! This doesn\'t look like a valid email address'
                                            }
                                        }
                                    },
                                    phoneNumber: {
                                        validators: {
                                            notEmpty: {
                                                message: 'Sorry, your phone number is required'
                                            }
                                        }
                                    },
                                    annualGrowthRate: {
                                        validators: {
                                            notEmpty: {
                                                message: 'Please enter the annual salary growth rate'
                                            },
                                            numeric: {
                                                message: 'This value can and must only be a number'
                                            }
                                        }
                                    },
                                    inflationRate: {
                                        validators: {
                                            notEmpty: {
                                                message: 'Please enter the current inflation rate'
                                            },
                                            numeric: {
                                                message: 'This value can and must only be a number'
                                            }
                                        }
                                    },
                                    yourAge: {
                                        validators: {
                                            notEmpty: {
                                                message: 'Please enter your current age'
                                            },
                                            numeric: {
                                                message: 'This value can and must only be a number'
                                            }
                                        }
                                    },
                                    ageTo: {
                                        validators: {
                                            notEmpty: {
                                                message: 'Please enter the age to project to'
                                            },
                                            numeric: {
                                                message: 'This value can and must only be a number'
                                            }
                                        }
                                    }
                                }
                            })
                    .on(
                            'success.form.bv',
                            function (e) {
                                start_wait();
                                // Prevent form submission
                                e.preventDefault();
                                // Get the form instance
                                $
                                        .ajax({
                                            url: $('#base_url').val()
                                                    + 'db_whatif_analysis',
                                            type: 'post',
                                            data: {
                                                schemeId: $(
                                                        '#dbsid')
                                                        .val(),
                                                memberId: $(
                                                        '#dbmid')
                                                        .val(),
                                                dateOfCalc: $(
                                                        '#dbdateOfExit')
                                                        .val(),
                                                dateOfExit: $(
                                                        '#dbdateOfExit')
                                                        .val(),
                                                reasonforexitid: $(
                                                        '#dbreasonForExit')
                                                        .val(),
                                                projectionType: $(
                                                        '#dbprojectionType')
                                                        .val(),
                                                isDcScheme: $(
                                                        '#dbstype')
                                                        .val(),
                                                memberIdFrom: $('#dbmid')
                                                        .val(),
                                                memberIdTo: $('#dbmid')
                                                        .val()

                                            },
                                            dataType: 'json',
                                            success: function (json) {
                                                stop_wait();
                                                if (json.success) {

                                                    //console.log("ROR from settings: " + $('#projectedROR').val());
                                                    console.log(json);

                                                    json = $.parseJSON(json.data);
                                                     //alert(json.annualSalary);
                                                    $('#DBdate_of_exit').html(json.dateOfExit);
                                                        
                                                    $('#DBdate_of_calculation').html(json.dateOfCalculation);
                                                       
                                                    $('#DBreason_for_exit').html(json.reasonForExit);
                                                    $('#DBage_at_exit').html(precisionRound(json.ageAtExit,0));
                                                    $('#DBpensionable_service').html(format_no(precisionRound(json.yearsWorked,1)));
                                                    $('#DBfinal_pensionable_salary').html(format_no(precisionRound(json.annualSalary,1)));

                                                    $('#DBtarget_pension').html(format_no(precisionRound(json.targetPension,1)));
                                                    $('#DBannual_pension').html(format_no(precisionRound(json.annualPension,1)));
                                                    $('#DBgross_monthly_pension').html(format_no(precisionRound(json.monthlyPension,1)));
                                                    $('#DBtax_on_pension').html(format_no(precisionRound(json.taxOnPension,1)));
                                                    $('#DBnet_monthly_pension').html(format_no(precisionRound(json.totMonthlyPens,1)));

                                                    $('#DBcommuted_lumpsum').html(format_no(precisionRound(json.totBen,1)));
                                                    $('#DBtax_free_lumpsum').html(format_no(precisionRound(json.lumpsumTaxFree,1)));
                                                    $('#DBtaxable_amount').html(format_no(precisionRound(json.taxableAmount,1)));
                                                    $('#DBwithholding_tax').html(format_no(precisionRound(json.withHTax,1)));
                                                    $('#DBmember_liability').html(format_no(precisionRound(json.totLiabilities,1)));
                                                    $('#DBlumpsum_payable').html(format_no(precisionRound(json.netPay,1)));






                                                    //  $('.results').removeClass('hide');
                                                    //$('#projectedContrs').html(format_no(json.projectedContrs));
                                                    // $('#projectedMonthlyContrs').html(format_no(json.projectedMonthlyContrs));
                                                } else {
                                                    bootbox
                                                            .alert(json.message);
                                                }
                                            }
                                        });

                            });
        });
        
        
            function precisionRound(number, precision) {
        var factor = Math.pow(10, precision);
        return Math.round(number * factor) / factor;
    }
    </script>
</c:if>