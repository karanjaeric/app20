

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/partial/header.jsp" />
<div class="container-fluid section">
    <div class="row">
        <form role="form" id="form-analysis">
            <h1 class="heading">${ menu.whatIfAnalysisName }</h1>
            <fieldset>
                <legend>Calculation Parameters</legend>
                <input type="hidden" name="projectedROR" id="projectedROR" value="${ settings.projectedROR }" />
                <input type="hidden" name="sid" id="sid" value="${scheme_id}">
                <input type="hidden" name="mid" id="mid" value="${member_id}">
                <input type="hidden" name="schemeType" id="stype" value="Defined Contribution">


                <div class="col-md-3">
                    <div class="form-group">
                        <label for="dateOfExit" class="control-label">Exit Date:</label>

                        <input type="text"  name="dateOfExit"
                               class="form-control datepicker" id="dateOfExit"
                               placeholder="Exit Date">
                    </div>
                </div>


                <div class="col-md-3">
                    <div class="form-group">
                        <label for="reasonForExit" class="control-label">Reason For Exit:</label>

                        <select id="reasonForExit" class="form-control">



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
            <table class="table table-responsive table-striped results" id="projected_results">
                <thead>

                    <tr>
                        <th>Heading</th>
                        <th>Amount</th>
                    </tr>
                </thead>

                <tbody>

                    <tr>
                        <td>Date of Exit:</td>
                        <td><span id="date_of_exit"></span></td>

                    </tr>
                    <tr>
                        <td>Date of Calculation:</td>
                        <td><span id="date_of_calculation"></span></td>
                    </tr>
                    <tr>
                        <td>Reason for Exit:</td>
                        <td><span id="reason_for_exit"></span></td>

                    </tr>
                    <tr>
                        <td>Age at Exit:</td>
                        <td><span id="age_at_exit"></span></td>

                    </tr>
                    <tr>
                        <td>Pensionable Service:</td>
                        <td><span id="pensionable_service"></span></td>

                    </tr>
                    <tr>
                        <td>Total Benefits:</td>
                        <td><span id="total_benefits"></span></td>

                    </tr>
                    <tr>
                        <td><h3>PENSION CALCULATION</h3></td>
                        <td></td>
                    </tr>

                    <tr>
                        <td>Pension Purchase Price:</td>
                        <td><span id="pension_purchase_price"></span></td>

                    </tr>
                    <tr>
                        <td>Annual Pension:</td>
                        <td><span id="annual_pension"></span></td>
                    </tr>
                    <tr>
                        <td>Gross Monthly Pension:</td>
                        <td><span id="gross_monthly_pension"></span></td>

                    </tr>
                    <tr>
                        <td>Tax on Pension:</td>
                        <td><span id="tax_on_pension"></span></td>

                    </tr>
                    <tr>
                        <td>Net Monthly Pension:</td>
                        <td><span id="net_monthly_pension"></span></td>

                    </tr>
                    <tr>
                        <td> <h3>COMMUTED LUMPSUM</h3></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Commuted Lumpsum:</td>
                        <td><span id="commuted_lumpsum"></span></td>

                    </tr>
                    <tr>
                        <td>Tax Free Lumpsum:</td>
                        <td><span id="tax_free_lumpsum"></span></td>
                    </tr>
                    <tr>
                        <td>Taxable Amount:</td>
                        <td><span id="taxable_amount"></span></td>

                    </tr>
                    <tr>
                        <td>Withholding Tax:</td>
                        <td><span id="withholding_tax"></span></td>

                    </tr>
                    <tr>
                        <td>Member's Liability:</td>
                        <td><span id="member_liability"></span></td>

                    </tr>
                    <tr>
                        <td>Lumpsum Payable:</td>
                        <td><span id="lumpsum_payable"></span></td>

                    </tr>
                </tbody>

            </table>

        </div>
    </div>
</div>




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

                    var combo = "<select id=\"reasonForExit\" name=\"reasonForExit\" class=\"form-control\"><option>--Select Reason For Exit--</option>";
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
                    $('#reasonForExit').html(combo);
                } else
                {
                    stop_wait();
                    bootbox.alert('<p class="text-center">' + json.message + '</p>');
                }
            }
        });








        $('.datepicker').datetimepicker(
                $('#dateOfExit').datetimepicker({
            format: 'mm-dd-yyyy',
            startView: 'month',
            minView: 'month',
            autoclose: true
        })
                .on('changeDate', function (e) {
                    $(this).datetimepicker('hide');
                    // Revalidate the date field
                    $('#form-analysis').bootstrapValidator('revalidateField', 'dateOfExit');
                }),
                $('#dateOfExit')
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
                                                + 'what-if-analysis',
                                        type: 'post',
                                        data: {
                                            schemeId: $(
                                                    '#sid')
                                                    .val(),
                                            memberId: $(
                                                    '#mid')
                                                    .val(),
                                            dateOfCalc: $(
                                                    '#dateOfExit')
                                                    .val(),
                                            dateOfExit: $(
                                                    '#dateOfExit')
                                                    .val(),
                                            reasonforexitid: $(
                                                    '#reasonForExit')
                                                    .val(),
                                            projectionType: $(
                                                    '#projectionType')
                                                    .val(),
                                            isDcScheme: $(
                                                    '#stype')
                                                    .val(),
                                            memberIdFrom: $('#mid')
                                                    .val(),
                                            memberIdTo: $('#mid')
                                                    .val()

                                        },
                                        dataType: 'json',
                                        success: function (json) {
                                            stop_wait();
                                            if (json.success) {

                                                //console.log("ROR from settings: " + $('#projectedROR').val());
                                                console.log(json);

                                                json = $.parseJSON(json.data);
                                                //alert(json.pensionable_service);
                                                $('#date_of_exit').html(json.calc_date);

                                                $('#date_of_calculation').html(json.calc_date);

                                                $('#reason_for_exit').html(json.exit_reason);
                                                $('#age_at_exit').html(precisionRound(json.age_at_exit, 0));
                                                $('#pensionable_service').html(format_no(precisionRound(json.pensionable_service, 1)));
                                                $('#total_benefits').html(format_no(precisionRound(json.total_benefits, 1)));

                                                $('#pension_purchase_price').html(format_no(precisionRound(json.pension_purchase_price, 1)));
                                                $('#annual_pension').html(format_no(precisionRound(json.annual_pension, 1)));
                                                $('#gross_monthly_pension').html(format_no(precisionRound(json.gross_monthly_pension, 1)));
                                                $('#tax_on_pension').html(format_no(precisionRound(json.tax_on_pension, 1)));
                                                $('#net_monthly_pension').html(format_no(precisionRound(json.net_monthly_monthly, 1)));

                                                $('#commuted_lumpsum').html(format_no(precisionRound(json.commuted_lumpsum, 1)));
                                                $('#tax_free_lumpsum').html(format_no(precisionRound(json.tax_free_lumpsum, 1)));
                                                $('#taxable_amount').html(format_no(precisionRound(json.taxable_income, 1)));
                                                $('#withholding_tax').html(format_no(precisionRound(json.withholding_tax, 1)));
                                                $('#member_liability').html(format_no(precisionRound(json.member_liability, 1)));
                                                $('#lumpsum_payable').html(format_no(precisionRound(json.lumpsum_payable, 1)));

                                                $('#projected_results').DataTable({
                                                    dom: 'Bfrtip',
                                                    "searching": false,
                                                    "bSort": false,
                                                    "bInfo" : false,
                                                    //bFilter: false,
                                                    paging: false,
                                                    buttons: [

                                                        {
                                                            extend: 'pdfHtml5',
                                                            title: 'DC Projection',
                                                            orientation: 'landscape', //landscape give you more space
                                                            pageSize: 'A5'//A0 is the largest A5 smallest(A0,A1,A2,A3,legal,A4,A5,letter))


                                                        }

                                                    ]
                                                });




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


