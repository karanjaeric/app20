<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
    <form role="form" id="form-analysis">
        <h1 class="heading">${ menu.whatIfAnalysisName }</h1>
        <fieldset>
            <legend>Calculation Parameters</legend>
            <input type="hidden" name="projectedROR" id="projectedROR" value="${ settings.projectedROR }" />
            <input type="hidden" name="sid" id="sid" value="${scheme_id}">
              <input type="hidden" name="mid" id="mid" value="${member_id}">
               <input type="hidden" name="schemeType" id="stype" value="${scheme_type}">
           
            
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
                    <label for="projectionType" class="control-label">Projection Type:</label>

                    <select id="projectionType" class="form-control">
                        <option value="Reduced">Reduced</option>
                        <option value="Unreduced">Unreduced</option>

                    </select>
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
    <h3>PROJECTED RESULTS</h3>

    <table class="table table-responsive table-striped results hide">
        <tr><td class="right">PROJECTED ROR:</td><td class="left" id="ror">${ settings.projectedROR }</td><td class="right">PROJECTED CONTRIBUTIONS:</td><td class="left" id="projectedContrs">0.00</td><td class="right">PROJECTED ANNUAL CONTRIBUTIONS:</td><td class="left" id="projectedMonthlyContrs">0.00</td></tr>
    </table>
</div>
<c:if test="${ showScript }">
    <script type="text/javascript">
        $(document).ready(function () {
            
                  $.ajax({
                url: $('#base_url').val() + 'admin',
                type: 'post',
                data: {ACTION:'EXITREASONS'},
                dataType: 'json',
                success: function(json) {
                    if(json.success)
                    {
                        json = $.parseJSON(json.data);
                        console.log(json);

                        var combo = "<select id=\"reasonForExit\" name=\"reasonForExit\" class=\"form-control\"><option>--Select Reason For Exit--</option>";
                        $.each(json, function(key, value) {
                            if(key === 'rows')
                            {
                                for ( var i = 0; i < json.rows.length; i++) {
                                    var row = json.rows[i];
                                    combo = combo + "<option value = " + row['id'] + ">" + row['reason'] + "</option>";
                                    array = json.rows;
                                }
                                combo = combo + "</select>";

                            }
                        });
                        $('#reasonForExit').html(combo);
                    }
                    else
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
                                                memberIdFrom:$('#mid')
                                                        .val(),
                                                memberIdTo:$('#mid')
                                                        .val()
                                               
                                            },
                                            dataType: 'json',
                                            success: function (json) {
                                                stop_wait();
                                                if (json.success) {

                                                    //console.log("ROR from settings: " + $('#projectedROR').val());
                                                    console.log(json)

                                                    json = $.parseJSON(json.data);


                                                    $('.results').removeClass('hide');
                                                    $('#projectedContrs').html(format_no(json.projectedContrs));
                                                    $('#projectedMonthlyContrs').html(format_no(json.projectedMonthlyContrs));
                                                } else {
                                                    bootbox
                                                            .alert(json.message);
                                                }
                                            }
                                        });

                            });
        });
    </script>
</c:if>