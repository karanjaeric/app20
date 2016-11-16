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
        <i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;MEMBER MOVEMENT
    </h3>
    <form class="form-inline" role="form" id="mv-form">

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
    <p>&nbsp;</p>
    <div class="col-md-12" id="mv-results">

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

        $('#mv-form').bootstrapValidator({
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

            var alternativeUrl = null;
            var orientation = null;

            $.ajax({
                url:  res + '/reports/general?_eventName=base-url&schemeId=' + $('#scheme_id').val(),
                data: '',
                type:'get',
                async: false,
                /*dataType: 'json',*/
                success:function(json){
                    console.log(json);
                    var json_string =  json;
                    var result =  $.parseJSON(json_string);
                    var base_url = result.base_url;
                    console.log(base_url);
                    alternativeUrl = result.alternativeUrl;
                    console.log(alternativeUrl);
                    orientation = result.orientation;
                    console.log(orientation);
                }
            });

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

            var url =
                    $('#reportPath').val() +"members/Member Movement Report.xdo?_xpf=&_xpt=0&_xdo=%2F~weblogic%2Ffundmaster%2Freports%2Fmembers%2FMember%20Movement%20Report.xdo&_xmode=3&_paramsdateTo=" +
                    "&_paramsyear_txn=" + finalYear+  "&_paramsblankImage="  + alternativeUrl + "&_paramsalternativeUrl="  + alternativeUrl + "&_paramsorientation=" + orientation + "&_paramsBASE=http%3A%2F%2Flocalhost%3A8080%2FXi&_paramsscheme_id="
                    + $('#scheme_id').val() + "&_xt=Member%20Movement%20Report&_xf=analyze&_xana=view&id=" + $('#username').val() + "&passwd=" + $('#password').val();

            $("#mv-results").html('<object width="100%" height="700px" data="' + url + '"><h2 class="text-center"><small>Could not load report. Check that the report server is correctly configured and running</small></h2></object>');

            stop_wait();
        });
    });

</script>
