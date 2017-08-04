<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 10/5/16
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
    <h3 class="text-center main-title">
        <i class="glyphicon glyphicon-file"></i>&nbsp;&nbsp;ADMINISTRATOR FEE LISTING
    </h3>
    <form class="form-inline" role="form" id="af-form">
        <div class="form-group col-md-12">
            <div class="form-group col-md-3">
                <label for="dateFrom" class="control-label">
                    From:
                </label> <input type="text" readonly="readonly" name="dateFrom"
                                class="form-control datepicker" id="dateFrom"
                                placeholder="Date From">
            </div>
            <div class="form-group col-md-3 col-md-offset-2">
                <label for="dateTo" class="control-label">
                    To:
                </label> <input type="text" readonly="readonly" name="dateTo"
                                class="form-control datepicker" id="dateTo"
                                placeholder="Date To">
            </div>
        </div>
        <div class="form-group col-md-12" style= "margin-top: 15px">

            <div class="col-md-3" id="divposted">
                <select id="posted" name="posted" class="form-control">
                    <option value="" selected disabled>-- Posted? --</option>
                    <option value="YES"> Yes </option>
                    <option value="NO"> No </option>
                </select>
            </div>
            <div class="col-md-3 col-md-offset-2">
                <button class="btn btn-primary">
                    SHOW REPORT
                </button>
            </div>

        </div>

    </form>
    <input type="hidden" id="reportPath" value="${ settings.xiReportPath }" />
    <input type="hidden" id="xiRootPath" value="${ settings.xiPath }" />
    <input type="hidden" id="username" value="${ settings.xiReportUsername }" />
    <input type="hidden" id="password" value="${ settings.xiReportPassword }" />
    <input type="hidden" id="scheme_id" value="${ scheme_id }"/>

    <input type="hidden" id="alternativeUrl" value="${ report_details.alternativeUrl }" />
    <input type="hidden" id="orientation" value="${ report_details.orientation }" />

    <p>&nbsp;</p>
    <div class="col-md-12" id="af-results">

    </div>

    <script type="text/javascript">

        $(document).ready(function(){
            $('.datepicker').datetimepicker(
                    $('#dateFrom').datetimepicker({
                        format: 'mm-dd-yyyy',
                        startView: 'month',
                        minView: 'month',
                        autoclose: true
                    })
                            .on('changeDate', function(e) {
                                $(this).datetimepicker('hide');
                                // Revalidate the date field
                                $('#af-form').bootstrapValidator('revalidateField', 'dateTo');
                            }),
                    $('#dateTo')
                            .datetimepicker({
                                format: 'mm-dd-yyyy',
                                startView: 'month',
                                minView: 'month',
                                autoclose: true
                            })
                            .on('changeDate', function(e) {
                                $(this).datetimepicker('hide');
                                // Revalidate the date field
                                $('#af-form').bootstrapValidator('revalidateField', 'dateTo');
                            }));
            $('#af-form').bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    dateTo: {
                        validators: {
                            notEmpty: {
                                message: 'Please select the ending date'
                            }
                        }
                    },
                    dateFrom: {
                        validators: {
                            notEmpty: {
                                message: 'Please select the ending date'
                            }
                        }
                    },
                    posted : {
                        validators : {
                            notEmpty : {
                                message : 'Please select an option'
                            }
                        }
                    }
                }
            }).on('success.form.bv', function(e) {
                start_wait();

                $.ajax({
                    url: $('#base_url').val() + 'member',
                    type: 'post',
                    data: {ACTION:'AP', date: $('#dateTo').val()},
                    dataType: 'json',
                    success: function(json) {
                        if(json.success)
                        {
                            var str = $('#xiRootPath').val();
                            var res = str.replace("/api/", "");
                            console.log(res);

                            var alternativeUrl = $('#alternativeUrl').val();
                            console.log("Alternative: " + alternativeUrl);
                            var orientation = $('#orientation').val();
                            console.log("Orientation: " + orientation);

                            var fromDate = (document.getElementById('dateFrom').value);
                            var toDate = (document.getElementById('dateTo').value);
                            var posted = ($('#posted').val());
                            console.log('The posted option is >>>>>>>>> ' + posted);
                            json = $.parseJSON(json.data);
                            console.log(json.accountingPeriodId);
                            var url =
                                    $('#reportPath').val() +"commissions/adminreport.xdo?_xpf=&_xpt=0&_xdo=%2F~weblogic%2Ffundmaster%2Freports%2Fcommissions%2Fadminreport.xdo&_xmode=3&_paramstoDate=" + toDate
                                    + "&_paramsfromDate=" + fromDate + "&_paramsposted=" + posted + '&_paramsap_id=' + json.accountingPeriodId
                                    +  "&_paramsblankImage="  + alternativeUrl + "&_paramsalternativeUrl="  + alternativeUrl + "&_paramsorientation=" + orientation + "&_paramsBASE=http%3A%2F%2Flocalhost%3A8080%2FXi&_paramsscheme_id="
                                    + $('#scheme_id').val() + "&_xt=adminreport&_xf=analyze&_xana=view&id=" + $('#username').val() + "&passwd=" + $('#password').val();

                            $("#af-results").html('<object width="100%" height="700px" data="' + url + '"><h2 class="text-center"><small>Could not load report. Check that the report server is correctly configured and running</small></h2></object>');

                            stop_wait();
                        }
                    }
                });
            });
        });
    </script>
