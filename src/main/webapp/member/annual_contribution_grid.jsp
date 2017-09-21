<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 3/18/17
  Time: 11:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
    <h3 class="text-center main-title">
        <i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;MY STATEMENT OF ACCOUNT
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

    <input type="hidden" id="scheme_id" value="${ scheme_id } "/>
    <input type="hidden" id="member_id" value="${ member_id }" />
    <p>&nbsp;</p>
    <div class="col-md-12" id="sa-results">

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
                    <table class="table table-responsive table-striped table-bordered" id="select-opbal">
                    </table>
                    <h4>CONTRIBUTIONS:</h4>
                    <table class="table table-responsive table-striped table-bordered" id="select-contr">
                    </table>
                    <h4>TOTAL CONTRIBUTIONS:</h4>
                    <table class="table table-responsive table-striped table-bordered" id="select-intr">
                    </table>
                    <h4>OP BAL + CONTR:</h4>
                    <table class="table table-responsive table-striped table-bordered" id="select-total">
                    </table>
                    <h4>Total Interest:</h4>
                    <table class="table table-responsive table-striped table-bordered" id="total-intr">
                    </table>
                    <h4>Accumulated Balance:</h4>
                    <table class="table table-responsive table-striped table-bordered" id="acc-bal">
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
                        json = $.parseJSON(json.data);
                        console.log("Acc Period: " + json.accountingPeriodId);
                        var apId = json.accountingPeriodId;
                        $.ajax({

                            url: $('#base_url').val() + 'member',
                            type: 'post',
                            data: {ACTION:'AC_GRID',

                                member_id: $('#member_id').val(),
                                scheme_id: $('#scheme_id').val(),
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
                                            narration_head = "<tr><th class='text-center'>NARRATION</th><th class='text-center'>EMPLOYEE</th><th class='text-center'>EMPLOYER</th><th class='text-center'>AVC EMPLOYEE</th><th class='text-center'>AVC EMPLOYER</th><th class='text-center'>TOTAL</th></tr>";
                                            html = "<tr><th class='text-center'>DATE PAID</th><th class='text-center'>EE</th><th class='text-center'>ER</th><th class='text-center'>AVC</th><th class='text-center'>AVCER</th><th class='text-center'>TOTAL</th></tr>";

                                            html2 = "";
                                            html3 = "";
                                            html4 = "";
                                            html5 = "";

//                                            var fromDate = json.rows['from_date'];
//                                            console.log("From date b4 loop: " + fromDate);
//
//                                            var toDate = json.rows['to_date'];
//                                            console.log("To date b4 loop: " + toDate);

                                            for ( var i = 0; i < json.rows.length; i++) {

                                                var row = json.rows[i];

                                                console.log("From date: "  + row['from_date']);

                                                if(typeof row['contr_for'] != 'undefined') {

                                                    html = html + "<tr><td>" + row['contr_for'] + "</td><td>" + format_no(row['ee']) + "</td><td>" + format_no(row['er']) + "</td><td>" + format_no(row['avc']) + "</td><td>" + format_no(row['avcer']) + "</td><td>" + format_no(row['total_contr']) + "</td></tr>";

                                                }


                                                op_row = "<tr><td>" + "Balances as at: <br> " + row['from_date'] + "</td><td>" + format_no(row['openingEE']) + "</td><td>" + format_no(row['openingER']) +"</td><td>" + format_no(row['openingAVC']) + "</td><td>" + format_no(row['openingAVCER']) + "</td><td>" + format_no(row['totalOpeningBalance']) + "</td></tr>";

                                                html2 = "<tr><td>" + "Total Contributions as at: <br> " + row['to_date'] + "</td><td>" + format_no(row['eeContribution']) + "</td><td>" + format_no(row['erContribution']) +"</td><td>" + format_no(row['avcContribution']) + "</td><td>" + format_no(row['avcerContribution']) + "</td><td>" + format_no(row['totalContribution']) + "</td></tr>";

                                                html3 = "<tr><td>" + "As at: <br> " + row['to_date'] + "</td><td>" + format_no(row['closingEE']) + "</td><td>" + format_no(row['closingER']) +"</td><td>" + format_no(row['closingAVC']) + "</td><td>" + format_no(row['closingAVCER']) + "</td><td>" + format_no(row['closingTotalMinusInterest']) + "</td></tr>";

                                                html4 = "<tr><td colspan='5' class='text-center'>" + " Total Interest earned:  " + "</td><td>" + format_no(row['totalInterest']) + "</td></tr>";

                                                html5 = "<tr><td colspan='5' class='text-center'>" + " Accumulated balance as at: " + row['to_date']  + "</td><td>" + format_no(row['totalclosingBalance']) + "</td></tr>";



                                            }

                                            html1 = narration_head + op_row;

                                            stop_wait();
                                        }

                                    });
                                }
                                $('#select-opbal').html(html1);
                                $('#select-intr').html(html2);
                                $('#select-contr').html(html);
                                $('#select-total').html(html3);
                                $('#total-intr').html(html4);
                                $('#acc-bal').html(html5);
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