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
        <i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;FUND MOVEMENT SUMMARY
    </h3>

    <form class="form-inline" role="form" id="fm-form">

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
    <input type="hidden" id="sponsor_id" value="${ sponsor_id }"/>

    <input type="hidden" id="alternativeUrl" value="${ report_details.alternativeUrl }" />
    <input type="hidden" id="orientation" value="${ report_details.orientation }" />

    <p>&nbsp;</p>
    <div class="col-md-12" id="fm-results">

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

        $('#fm-form').bootstrapValidator({
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
            var orientation = $('#orientation').val();
            console.log("Orientation: " + orientation);

            var accPeriodId = $('#accperiod').val();
            console.log("Accounting period Id: " + accPeriodId);

            var url = $('#reportPath').val() + 'members/Fund Movement Summary (Sponsor Specific).xdo?_xpf=&_xpt=0&_xdo=%2F~weblogic%2Ffundmaster%2Freports%2Fmembers%2FFund%20Movement%20Summary%20(Sponsor%20Specific).xdo&_xmode=3&_paramsBASE=' + $('#xiRootPath').val() + '&_paramsscheme_id=' + $('#scheme_id').val() + '&_paramssponsor_id=' + $('#sponsor_id').val() +
                    '&_paramsap_id=' + accPeriodId + '&_xt=Fund%20Movement%20Summary%20(Detailed)&_xf=analyze&_xana=view&_xautorun=false&_paramsadmin=3347&id='
                    + $("#username").val() + '&passwd=' + $("#password").val() + '&_paramsblankImage=' + alternativeUrl +'&_paramsalternativeUrl=' + alternativeUrl + '&_paramsorientation=' + orientation;
            $("#fm-results").html('<object width="100%" height="700px" data="' + url + '"><h2 class="text-center"><small>Could not load report. Check that the report server is correctly configured and running</small></h2></object>');

            stop_wait();
        });

    });

</script>