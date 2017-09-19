<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 10/18/16
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid section">
    <h3 class="text-center main-title">
        <i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;PROVISIONAL MEMBER STATEMENT
    </h3>

    <form class="form-inline" role="form" id="ac-form">

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
    <input type="hidden" id="scheme_id" value="${ scheme_id }"/>
    <input type="hidden" id="member_id" value="${ member_id }"/>

    <input type="hidden" id="alternativeUrl" value="${ report_details.alternativeUrl }" />
    <input type="hidden" id="orientation" value="${ report_details.orientation }" />

    <p>&nbsp;</p>
    <div class="col-md-12" id="ps-results">

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
                        console.log(json);

                        var combo = "<select id=\"accperiod\" name=\"accperiod\" class=\"form-control\"><option>--Select Accounting Period--</option>";
                        $.each(json, function(key, value) {
                            if(key == 'rows')
                            {
                                for ( var i = 0; i < json.rows.length; i++) {
                                    var row = json.rows[i];
                                    combo = combo + "<option value = " + row['id'] + ">" + row['name'] + "</option>";
                                    array = json.rows;
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

        $('#ac-form').bootstrapValidator({
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
        }) .on('success.form.bv', function(e) {

            start_wait();

            var alternativeUrl = $('#alternativeUrl').val();
            console.log("Alternative: " + alternativeUrl);
            var orientatiativeUrl = $('#alternativeUrl').val();
            console.loon = $('#orientation').val();
            console.log("Orientation: " + orientation);

            var accPeriodId = $('#accperiod').val();
            console.log("Accounting period Id: " + accPeriodId);

            var memberId = $('#member_id').val();
            console.log("Member id : " + $('#member_id').val());

            console.log("Scheme id : " + $('#scheme_id').val());


            /*
             http://192.168.1.194:7001/xmlpserver/~weblogic/fundmaster/reports/members/Provisional Member Statement.xdo?_xpf=&_xpt=0&_xdo=%2F~weblogic%2Ffundmaster%2Freports%2Fmembers%2FProvisional%20Member%20Statement.xdo&_xmode=3&_params_eventName2=getMemberCurrentApContributions&_paramsalternativeUrl=&_paramsblankImage=&_paramsorientation=RIGHT&_params_eventName=getMemberInterestOnBalances&_paramsBASE=http%3A%2F%2F172.16.1.112%3A8088%2FXi&_paramsadmin=1&_paramsscheme_id=&_paramsap_id=&_paramsmember_id=&_xt=Provisional%20Member%20Statement&_xf=analyze&_xana=view
             */

            var url = $("#reportPath").val() + "members/Provisional Member Statement.xdo?_xpf=&_xpt=0&_xdo=%2F~weblogic%2Ffundmaster%2Freports%2Fmembers%2FProvisional%20Member%20Statement.xdo&_xmode=3&_params_eventName2=getMemberCurrentApContributions&_paramsBASE=" + $("#xiRootPath").val() + "&_params_eventName=getMemberInterestOnBalances" + "&_paramsadmin=1" +"&_paramsscheme_id=" + $("#scheme_id").val() + "&_paramsap_id="+  accPeriodId +"&_paramsmember_id=" + memberId +
                    "&_xt=Provisional%20Member%20Statement&_xf=analyze&_xana=view&id=" + $("#username").val() + "&passwd=" + $("#password").val() + "&_paramsblankImage=" + alternativeUrl +"&_paramsalternativeUrl=" + alternativeUrl + "&_paramsorientation=" + orientation;

             $("#ps-results").html('<object width="100%" height="700px" data="' + url + '"><h2 class="text-center"><small>Could not load report. Check that the report server is correctly configured and running</small></h2></object>');

            stop_wait();
        });

    });

</script>