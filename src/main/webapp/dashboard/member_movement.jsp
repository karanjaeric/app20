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
        <div class="form-group col-md-6">
            <label for="asAt" class="control-label">As At:</label> <input type="text" readonly="readonly" name="asAt"
                                                                          class="form-control datepicker" id="asAt"
                                                                          placeholder="As At">
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


    $(document).ready(function(){

        $('.datepicker').datetimepicker({

            format: 'dd-mm-yyyy',
            startView: 'month',
            minView: 'month',
            autoclose: true
        });
        $('#asAt')
                .datetimepicker({
                    format: 'mm-dd-yyyy',
                    startView: 'month',
                    minView: 'month',
                    autoclose: true
                })
                .on('changeDate', function(e) {
                    $(this).datetimepicker('hide');
                    // Revalidate the date field
                    $('#sa-form').bootstrapValidator('revalidateField', 'asAt');
                });
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
            console.log($('#asAt').val());
            $.ajax({
                url: $('#base_url').val() + 'member',
                type: 'post',
                data: {ACTION:'AP', date: $('#asAt').val()},
                dataType: 'json',
                success: function(json) {
                    if(json.success)
                    {
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

                        json = $.parseJSON(json.data);
                        console.log('Date from json ' + json.toDate);
                        console.log('Acc. period name ' +json.accountingPeriodName);
                        console.log('Acc. period id ' + json.accountingPeriodId);

                        var date = json.toDate;
                        var parts = date.split("-");

                        var year = parts[0];

                        console.log('the final year ' + year);

                        var url =
                                $('#reportPath').val() +"members/Member Movement Report.xdo?_xpf=&_xpt=0&_xdo=%2F~weblogic%2Ffundmaster%2Freports%2Fmembers%2FMember%20Movement%20Report.xdo&_xmode=3&_paramsdateTo=" +
                                "&_paramsyear_txn=" + year+  "&_paramsblankImage="  + alternativeUrl + "&_paramsalternativeUrl="  + alternativeUrl + "&_paramsorientation=" + orientation + "&_paramsBASE=http%3A%2F%2Flocalhost%3A8080%2FXi&_paramsscheme_id="
                                + $('#scheme_id').val() + "&_xt=Member%20Movement%20Report&_xf=analyze&_xana=view&id=" + $('#username').val() + "&passwd=" + $('#password').val();

                        $("#mv-results").html('<object width="100%" height="700px" data="' + url + '"><h2 class="text-center"><small>Could not load report. Check that the report server is correctly configured and running</small></h2></object>');

                        stop_wait();
                    }
                    else
                    {
                        stop_wait();
                    }
                }
            });
        });
    });
</script>
