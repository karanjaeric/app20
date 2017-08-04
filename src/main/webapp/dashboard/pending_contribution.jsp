<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 10/6/16
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
    <h3 class="text-center main-title">
        <i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;PENDING CONTRIBUTIONS
    </h3>
    <form class="form-inline" role="form" id="pc-form">

        <div class="col-md-6" id="divAccperiod">
            <select id="accperiod" name="accperiod" class="form-control">
                <option value="">--Select Accounting Period--</option>
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
    <input type="hidden" id="scheme_id" value="${ scheme_id } "/>

    <input type="hidden" id="alternativeUrl" value="${ report_details.alternativeUrl }" />
    <input type="hidden" id="orientation" value="${ report_details.orientation }" />

     <p>&nbsp;</p>
    <div class="col-md-12" id="pc-results">

    </div>
</div>
<script type="text/javascript">

    var array = {};
    $(document).ready(function(){

        function initialize()
        {
            $.ajax({
                url: $('#base_url').val() + 'admin',
                type: 'post',
                data: {ACTION:'PERIODS'},
                dataType: 'json',
                success: function(json) {
                    if(json.success)
                    {
                        json = $.parseJSON(json.data);
                        console.log("The json returned: " + json.toString());

                        var combo = "<select id=\"accperiod\" name=\"accperiod\" class=\"form-control\"><option>--Select Accounting Period--</option>";
                        $.each(json, function(key, value) {
                            var row;
                            if(key == 'rows')
                            {
                                for ( var i = 0; i < json.rows.length; i++) {
                                    row = json.rows[i];
                                    combo = combo + "<option>" + row['name'] + "</option>";
                                    array = json.rows;

                                    console.log("Array is " + array.toString());

                                }
                                combo = combo + "</select>";

                            }

                        });
                        $('#divAccperiod').html(combo);
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

        $('#pc-form').bootstrapValidator({
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
            console.log("Orientation: " + orientation)

            var toDate = $('#accperiod').val();
            console.log("toDate is: " + toDate);

            var ar = toDate.split("-");
            console.log(ar);
            var firstArr = ar[1];
            console.log(firstArr+">>>>>>");
            var ar2 = firstArr.split(",");
            console.log(ar2);
            var finalYear = ar2[ar2.length-1];
            console.log("This is the Final Year "+ finalYear);
            var reportPath = $('#reportPath').val();
            console.log("Report url is: " + reportPath);

            //172.16.1.236:7002/xmlpserver/~weblogic/fundmaster/reports/members/Expected Contributions.xdo?_xpf=&_xpt=0&_xdo=%2F~weblogic%2Ffundmaster%2Freports%2Fmembers%2FExpected%20Contributions.xdo&_xmode=3&_paramsalternativeUrl=http%3A%2F%2Flocalhost%3A8080%2F%2FXi%2Freports%2Flogos%2F14971_RIGHT.jpg&_paramsblankImage=RIGHT&_paramsorientation=&_paramsscheme_id=1182761&_paramsBASE=http%3A%2F%2Flocalhost%3A8080%2FXi&_paramsyear=2014&_xt=Expected%20Contributions&_xf=analyze&_xana=view

            var url = reportPath +"members/Expected Contributions.xdo?_xpf=&_xpt=0&_xdo=%2F~weblogic%2Ffundmaster%2Freports%2Fmembers%2FExpected%20Contributions.xdo&_xmode=3&_paramsyear=" + finalYear+  "&_paramsblankImage="  + alternativeUrl + "&_paramsalternativeUrl="  + alternativeUrl + "&_paramsorientation=" + orientation + "&_paramsBASE=http%3A%2F%2Flocalhost%3A8080%2FXi&_paramsscheme_id="
                    + $('#scheme_id').val() + "&_xt=Expected%20Contributions&_xf=analyze&_xana=view&id=" + $('#username').val() + "&passwd=" + $('#password').val();

            $("#pc-results").html('<object width="100%" height="700px" data="' + url + '"><h2 class="text-center"><small>Could not load report. Check that the report server is correctly configured and running</small></h2></object>');

            stop_wait();
        });
    });

</script>
