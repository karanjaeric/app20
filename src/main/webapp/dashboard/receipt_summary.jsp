<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 11/15/16
  Time: 9:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid section">
    <h3 class="text-center main-title">
        <i class="glyphicon glyphicon-file"></i>&nbsp;&nbsp; RECEIPT SUMMARY
    </h3>
    <form class="form-inline" role="form" id="rs-form">
        <div class="col-md-4">
            <label for="dateFrom" class="control-label">
                Date From:
            </label> <input type="text" readonly="readonly" name="dateFrom"
                            class="form-control datepicker" id="dateFrom"
                            placeholder="Date From">
        </div>
        <div class="col-md-4">
            <label for="dateTo" class="control-label">
                Date To:
            </label> <input type="text" readonly="readonly" name="dateTo"
                            class="form-control datepicker" id="dateTo"
                            placeholder="Date To">
        </div>
        <div class="col-md-4">
            <br/>
            <button class="btn btn-primary">
                SHOW REPORT
            </button>
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
    <div class="col-md-12" id="rs-results">

    </div>
</div>

<script type="text/javascript">

    $(document).ready(function(){
        $('.datepicker').datetimepicker(
                $('#dateFrom').datetimepicker({
                    format: 'dd-M-yy',
                    startView: 'month',
                    minView: 'month',
                    autoclose: true
                })
                        .on('changeDate', function(e) {
                            $(this).datetimepicker('hide');
                            // Revalidate the date field
                            $('#rs-form').bootstrapValidator('revalidateField', 'dateTo');
                        }),
                $('#dateTo')
                        .datetimepicker({
                            format: 'dd-M-yy',
                            startView: 'month',
                            minView: 'month',
                            autoclose: true
                        })
                        .on('changeDate', function(e) {
                            $(this).datetimepicker('hide');
                            // Revalidate the date field
                            $('#rs-form').bootstrapValidator('revalidateField', 'dateTo');
                        }));
        $('#rs-form').bootstrapValidator({
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
                }
            }
        }).on('success.form.bv', function(e) {
            start_wait();


            var alternativeUrl = $('#alternativeUrl').val();
            console.log("Alternative: " + alternativeUrl);
            var orientation = $('#orientation').val();
            console.log("Orientation: " + orientation);

            var fromDate = (document.getElementById('dateFrom').value);
            console.log("From Date: " + fromDate);
            var toDate = (document.getElementById('dateTo').value);
            console.log("To date: " + toDate);
            console.log("Scheme id is: " + $('#scheme_id').val());
            
            var url =
                    $('#reportPath').val() +"members/Receipts Listing (Per Sponsor).xdo?_xpf=&_xpt=0&_xdo=%2F~weblogic%2Ffundmaster%2Freports%2Fmembers%2FReceipts%20Listing%20(Per%20Sponsor).xdo&_xmode=3&_paramsenddate=" + toDate
                    + "&_paramsstartdate=" + fromDate +  "&_paramsblankImage="  + alternativeUrl + "&_paramsalternativeUrl="  + alternativeUrl + "&_paramsorientation=" + orientation +
                    "&_paramsBASE=http%3A%2F%2Flocalhost%3A8080%2FXi&_paramsscheme_id=" + $('#scheme_id').val() + "&_paramssponsor_id=" + $('#sponsor_id').val() + "&_xt=Receipts%20Listing&_xf=analyze&_xana=view&id=" + $('#username').val() + "&passwd=" + $('#password').val();

            $("#rs-results").html('<object width="100%" height="700px" data="' + url + '"><h2 class="text-center"><small>Could not load report. Check that the report server is correctly configured and running</small></h2></object>');

            stop_wait();
        });
    });
</script>

