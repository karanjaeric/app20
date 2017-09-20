<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 9/15/17
  Time: 1:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
    <h3 class="text-center main-title">
        <i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;ANNUAL CONTRIBUTION STATEMENT
    </h3>
    <form class="form-inline" role="form" id="ac-form">
        <div class="form-group col-md-6">
            <label for="asAt" class="control-label">As At:</label> <input type="text" readonly="readonly" name="asAt"
                                                                          class="form-control datepicker" id="asAt"
                                                                          placeholder="As At">
        </div>
        <div class="col-md-6">
            <button class="btn btn-primary btn-sm">SHOW STATEMENT</button>
        </div>
    </form>

     <input type="hidden" id="member_id" value="${ member_id }" />
    <p>&nbsp;</p>
    <div class="col-md-12" id="ac-results">

    </div>
</div>
<div class="modal fade" id="modal-view-statement" tabindex="-1" role="dialog" aria-labelledby="myModalLabelViewStatement" aria-hidden="true">
    <form role="form" id="form-view-statement">
        <div class="modal-dialog large-modal">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title" id="myModalLabelViewContributions">
                        <i class="glyphicon glyphicon-picture"></i>&nbsp;&nbsp;STATEMENT OF ACCOUNT
                    </h4>
                </div>
                <div class="modal-body">
                    <h4>NARRATION:</h4>
                    <table class="table table-responsive table-striped table-bordered" id="select-bal">
                    </table>
                    <h4>CONTRIBUTIONS:</h4>
                    <table class="table table-responsive table-striped table-bordered" id="select-contr">
                    </table>
                    <h4>TOTAL INTEREST EARNED:</h4>
                    <table class="table table-responsive table-striped table-bordered" id="select-totalintr">
                    </table>

                </div>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript">

    function format_no(yourNumber) {
        if(typeof	yourNumber != 'undefined')
        {
            //Seperates the components of the number
            var n= yourNumber.toString().split(".");
            //Comma-fies the first part
            n[0] = n[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
            //Combines the two sections
            return n.join(".");
        }
        return yourNumber;
    }

    function format_date(date) {
        if(typeof	date != 'undefined')
        {
            //Seperates the components of the number
            var n= date.toString().split(' ')[0];

        }
        return n;
    }

    var roundFormattedNumber = function(n){

        if(typeof	n != 'undefined') {
            var result = parseFloat(n.replace(/[^0-9.]/g, ''));
            return isNaN(result) ? NaN : result.toFixed(0);
        }
    };

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
                $('#ac-form').bootstrapValidator('revalidateField', 'asAt');
            });
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
            console.log($('#asAt').val());
            $.ajax({
                url: $('#base_url').val() + 'member',
                type: 'post',
                data: {ACTION:'AP', date: $('#asAt').val()},
                dataType: 'json',
                success: function(json) {
                    if(json.success)
                    {
                        json = $.parseJSON(json.data);
                        console.log("Acc Period: " + json.accountingPeriodId);
                        var apId = json.accountingPeriodId;
                        $.ajax({

                            url: $('#base_url').val() + 'member',
                            type: 'post',
                            data: {ACTION:'AC_GRID',

                                member_id: $('#member_id').val(),
                                 ap_id: apId
                            },
                            dataType: 'json',
                            success: function(json) {
                                console.log(json);

                                if(json.success)
                                {
                                    json = $.parseJSON(json.data);
                                    console.log(json);

                                    $.each(json, function(key, value) {

                                        if(key == 'rows')
                                        {
                                            html_head = "<tr><th colspan='2' class='text-center'>NARRATION</th><th colspan='2' class='text-center'>EMPLOYEE</th><th colspan='2' class='text-center'>EMPLOYER</th>" +
                                                "<th colspan='2' class='text-center'>AVC EMPLOYEE</th> <th colspan='2' class='text-center'>AVC EMPLOYER</th><th colspan='2' class='text-center'>TOTAL</th></tr>";
                                             intr_head = "<tr><th class='text-center'>Total Interest Earned </th><th class='text-center'>0.00</th></tr>";
                                            html = "<tr><th class='text-center'>CONTRIBUTIONS</th><th class='text-center'>EE</th><th class='text-center'>ER</th><th class='text-center'>AVC</th><th class='text-center'>AVCER</th><th class='text-center'>TOTAL</th></tr>";

                                        }

                                    });
                                }
                                $('#select-bal').html(html1);
                                $('#select-intr').html(html2);
                                $('#select-contr').html(html);
                                $('#select-total').html(html3);
                                stop_wait();
                                $('#modal-view-statement').modal('show');
                            }

                        });
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
