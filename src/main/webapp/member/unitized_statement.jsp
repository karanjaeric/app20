<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 3/9/17
  Time: 12:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid section">
    <h3 class="text-center main-title">
        <i class="glyphicon glyphicon-list"></i>&nbsp;&nbsp; MEMBER STATEMENT
    </h3>

    <form class="form-inline" role="form" id="sa-form">
        <div class="form-group col-md-6">
            <label for="asAt" class="control-label">As At:</label> <input type="text" readonly="readonly" name="asAt"
                                                                          class="form-control datepicker" id="asAt"
                                                                          placeholder="As At">
        </div>
        <div class="col-md-6">
            <button class="btn btn-primary btn-sm">SHOW STATEMENT</button>
        </div>
    </form>

    <input type="hidden" id="reportPath" value="${ settings.xiReportPath }" />
    <input type="hidden" id="xiRootPath" value="${ settings.xiPath }" />
    <input type="hidden" id="username" value="${ settings.xiReportUsername }" />
    <input type="hidden" id="password" value="${ settings.xiReportPassword }" />
    <input type="hidden" id="scheme_id" value="${ scheme_id } "/>
    <input type="hidden" id="member_id" value="${ member_id }" />
    <input type="hidden" id="unitization" value="<%=session.getValue("unitization")%>" />
    <input type="hidden" id="unitization1" value="${ unitization }" />

    <input type="hidden" id="alternativeUrl" value="${ report_details.alternativeUrl }" />
    <input type="hidden" id="orientation" value="${ report_details.orientation }" />

    <p>&nbsp;</p>
    <div class="col-md-12" id="us-results">

    </div>
</div>

<script type="text/javascript">

    $(document).ready(function(){

        $('.datepicker').datetimepicker({
            format: 'mm-dd-yyyy',
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

        $('#sa-form').bootstrapValidator({
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
            console.log($('#asAt').val());

            $.ajax({
                url: $('#base_url').val() + 'member',
                type: 'post',
                data: {ACTION:'AP', date: $('#asAt').val()},
                dataType: 'json',
                success: function(json) {
                    if(json.success)
                    {
                        var alternativeUrl = $('#alternativeUrl').val();
                        console.log("Alternative: " + alternativeUrl);
                        var orientation = $('#orientation').val();
                        console.log("Orientation: " + orientation);
                        console.log("memberId: " + $('#member_id').val());
                        console.log("scheme_id: " + $('#scheme_id').val());

                        json = $.parseJSON(json.data);
                        console.log(json.accountingPeriodId);

                        var url =
                                $('#reportPath').val() +"members/unitizedStatement.xdo?_xpf=&_xpt=0&_xdo=%2F~weblogic%2Ffundmaster%2Freports%2Fmembers%2FunitizedStatement.xdo&_xmode=3&_paramsorientation=&_paramsBASE=http%3A%2F%2Flocalhost%3A8080%2FXi&_paramsscheme_id="
                                + $('#scheme_id').val() + '&_paramsap_id=' + 0 +  '&_paramsmember_id=' + $('#member_id').val() + "&_xt=Unitized%20Statement&_xf=analyze&_xana=view&id=" + $('#username').val() + "&passwd=" + $('#password').val();



                        $("#us-results").html('<object width="100%" height="700px" data="' + url + '"><h2 class="text-center"><small>Could not load report. Check that the report server is correctly configured and running</small></h2></object>');


                    }
                       stop_wait();



                }
            });



        });
    });

</script>
