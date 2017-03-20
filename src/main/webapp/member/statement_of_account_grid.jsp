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
                    <h4>OPENING BALANCES:</h4>
                    <table class="table table-responsive table-striped table-bordered" id="select-opbal">
                    </table>
                    <h4>CONTRIBUTIONS:</h4>
                    <table class="table table-responsive table-striped table-bordered" id="select-contr">
                    </table>
                    <h4>INTERESTS:</h4>
                    <table class="table table-responsive table-striped table-bordered" id="select-intr">
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
                            data: {ACTION:'SA_GRID',

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
                                            html_head = "<tr><th colspan='2' class='text-center'>EMPLOYEE</th><th colspan='2' class='text-center'>EMPLOYER</th><th colspan='2' class='text-center'>AVC</th><th></th></tr>";
                                            html_subhead = "<tr><th class='text-center'>REGISTERED</th><th class='text-center'>UNREGISTERED</th><th class='text-center'>REGISTERED</th><th class='text-center'>UNREGISTERED</th><th class='text-center'>REGISTERED</th><th class='text-center'>UNREGISTERED</th><th class='text-center'>TOTAL</th></tr>";
                                            intr_head = "<tr><th class='text-center'>NORMAL <br>EMPLOYEE</th><th class='text-center'>NORMAL <br>EMPLOYER</th><th class='text-center'>COMBINED <br>AVC</th><th class='text-center'>OPENING BALANCE </br>EMPLOYEE</th><th class='text-center'>OPENING BALANCE </br>EMPLOYER</th><th class='text-center'>OPENING BALANCE </br>AVC</th><th class='text-center'>TOTAL</th></tr>";
                                            html = "<tr><th class='text-center'>DATE PAID</th><th class='text-center'>EE</th><th class='text-center'>ER</th><th class='text-center'>AVC</th><th class='text-center'>AVCER</th><th class='text-center'>STATUS</th><th class='text-center'>TOTAL</th></tr>";

                                            for ( var i = 0; i < json.rows.length; i++) {

                                                var row = json.rows[i];

                                                console.log(row['open_ee_reg']);
                                                console.log(row['open_er_reg']);
                                                console.log(row['open_total']);
                                                console.log(row['openinger_intr']);
                                                console.log(row['grand_total']);

                                                var ee_contr_intr = row['ee_contr_intr'];
                                                var intr_float = roundFormattedNumber(ee_contr_intr);
                                                var ee_contr_final = parseFloat(intr_float).toFixed(2);

                                                var er_contr_intr = row['er_contr_intr'];
                                                var intr_float = roundFormattedNumber(er_contr_intr);
                                                var er_contr_final = parseFloat(intr_float).toFixed(2);

                                                var openingee_intr = row['openingee_intr'];
                                                var intr_float = roundFormattedNumber(openingee_intr);
                                                var openingee_intr_final = parseFloat(intr_float).toFixed(2);

                                                var openinger_intr = row['openinger_intr'];
                                                var intr_float = roundFormattedNumber(openinger_intr);
                                                var openinger_intr_final = parseFloat(intr_float).toFixed(2);

                                                var total_intr = row['total_intr'];
                                                var intr_float = roundFormattedNumber(total_intr);
                                                var total_intr_final = parseFloat(intr_float).toFixed(2);

                                                op_row = "<tr><td>" + format_no(row['open_ee_reg']) + "</td><td>" + format_no(row['open_ee_unreg']) + "</td><td>" + format_no(row['open_er_reg']) +"</td><td>" + format_no(row['open_er_unreg']) + "</td><td>" + format_no(row['avc_reg']) + "</td><td>" + format_no(row['avc_unreg']) + "</td><td>" + format_no(row['open_total']) + "</td></tr>";
                                                intr_row = "<tr><td>" + ee_contr_final + "</td><td>" + er_contr_final + "</td><td>" + format_no(row['avc_contr_intr']) +"</td><td>" + openingee_intr_final + "</td><td>" + openinger_intr_final + "</td><td>" + format_no(row['openingavc_intr']) + "</td><td>" + total_intr_final + "</td></tr>";

                                                if(typeof	format_date(row['date_paid']) != 'undefined') {

                                                    var total_contr = row['contr_ee'];
                                                    var total_contr_final = parseFloat(total_contr);

                                                    var total_contr_er = row['contr_er'];
                                                    var total_contr_er_final = parseFloat(total_contr_er);

                                                    var total_avc = row['avc'];
                                                    var total_avc_final = parseFloat(total_avc);

                                                    var total_avcer = row['avcer'];
                                                    var total_avcer_final = parseFloat(total_avcer);

                                                    var sumItAll = total_contr_final + total_contr_er_final + total_avc_final + total_avcer_final;

                                                    var total_intr = format_no(row['contr_ee']) + format_no(row['contr_er']);
                                                    html = html + "<tr><td>" + format_date(row['date_paid']) + "</td><td>" + format_no(row['contr_ee']) + "</td><td>" + format_no(row['contr_er']) + "</td><td>" + format_no(row['avc']) + "</td><td>" + format_no(row['avcer']) + "</td><td>" + format_no(row['status']) + "</td><td>" + sumItAll + "</td></tr>";
                                                }

                                            }

                                            //html = html_Opening_Legend + html_head + html_subhead + op_row + contr_subhead + contr_row;
                                            //html = html_Opening_Legend + html_head + op_row +html_Contr_Legend + html;
                                            html1 = html_head + html_subhead + op_row;
                                            html2 = intr_head + intr_row;
                                            //html = html;

                                            stop_wait();
                                        }

                                    });
                                }
                                $('#select-opbal').html(html1);
                                $('#select-intr').html(html2);
                                $('#select-contr').html(html);
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