<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 11/29/16
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid section">

    <h3 class="text-center main-title">
        <i class="glyphicon glyphicon-file"></i>&nbsp;&nbsp;PENSION ADVICE
    </h3>

    <form class="form-inline" role="form" id="pa-form">

        <div class="col-md-6" id="divPayrollYears">
            <select id="payrollYears" name="payrollYears" class="form-control">
                <option value="" class='disabled'>--Select Payroll Year--</option>
            </select>
        </div>

        <div class="col-md-6">
            <button class="btn btn-primary btn-sm">SHOW REPORT</button>
        </div>
    </form>

    <input type="hidden" id="reportPath" value="${ settings.xiReportPath }" />
    <input type="hidden" id="xiRootPath" value="${ settings.xiPath }" />
    <input type="hidden" id="username" value="${ settings.xiReportUsername }" />
    <input type="hidden" id="password" value="${ settings.xiReportPassword }" />
    <input type="hidden" id="pensioner_id" value="${ pensioner_id } "/>
    <input type="hidden" id="scheme_id" value="${ scheme_id } "/>

    <input type="hidden" id="alternativeUrl" value="${ report_details.alternativeUrl }" />
    <input type="hidden" id="orientation" value="${ report_details.orientation }" />

    <p>&nbsp;</p>
    <div class="col-md-12" id="pa-results">

</div>

    <script type="text/javascript">

        var array = {};
        $(document).ready(function(){

            function initialize()
            {
                $.ajax({
                    url: $('#base_url').val() + 'pensioner',
                    type: 'post',
                    data: {ACTION:'YEARS'},
                    dataType: 'json',
                    success: function(json) {
                        if(json.success)
                        {
                            json = $.parseJSON(json.data);
                            console.log("The json returned: " + json.toString());

                            var combo = "<select id=\"payrollYears\" name=\"payrollYears\" class=\"form-control\"><option class='disabled'>--Select Payroll Year--</option>";
                            $.each(json, function(key, value) {
                                var row;
                                if(key == 'years')
                                {
                                    for ( var i = 0; i < json.years.length; i++) {
                                        row = json.years[i];
                                        combo = combo + "<option>" + row['YEAR'] + "</option>";
                                        array = json.years;

                                        console.log("Array is " + array.toString());

                                    }
                                    combo = combo + "</select>";

                                }

                            });
                            $('#divPayrollYears').html(combo);
                        }
                        else
                        {
                            stop_wait();
                            bootbox.alert('<p class="text-center">' + json.message + '</p>');
                        }
                    }
                });
            }
            initialize();

            $('#pa-form').bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    asAt: {
                        validators: {
                            notEmpty: {
                                message: 'Please select the ending date'
                            }
                        }
                    }
                }
            }).on('success.form.bv', function(e) {
                start_wait();

                var str = $('#xiRootPath').val();
                var res = str.replace("/api/", "");
                console.log(res);

                var alternativeUrl = $('#alternativeUrl').val();
                console.log("Alternative: " + alternativeUrl);
                var orientation = $('#orientation').val();
                console.log("Orientation: " + orientation);

                var year = $('#payrollYears').val();
                console.log("year: " + year);
                var reportPath = $('#reportPath').val();
                console.log("Report url is: " + reportPath);

                var url = reportPath +"pensioners/Pension Advice.xdo?_xpf=&_xpt=0&_xdo=%2F~weblogic%2Ffundmaster%2Freports%2Fpensioners%2FPension%20Advice.xdo&_xmode=3&_paramspensionerId=" + $('#pensioner_id').val() +
                        "&_paramsyear=" + year +  "&_paramsblankImage="  + alternativeUrl + "&_paramsalternativeUrl="  + alternativeUrl + "&_paramsorientation=" + orientation + "&_paramsBASE=http%3A%2F%2Flocalhost%3A8080%2FXi&_paramsscheme_id="
                        + $('#scheme_id').val() + "&_xt=Pension%20Advice&_xf=analyze&_xana=view&id=" + $('#username').val() + "&passwd=" + $('#password').val();


                $("#pa-results").html('<object width="100%" height="700px" data="' + url + '"><h2 class="text-center"><small>Could not load report. Check that the report server is correctly configured and running</small></h2></object>');

                stop_wait();
            });
        });




        </script>
