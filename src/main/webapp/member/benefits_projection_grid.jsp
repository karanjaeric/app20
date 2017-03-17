<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 3/16/17
  Time: 12:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section content-area">
    <input type="hidden" id="planType" value="${ planType }" />
    <h3 class="text-center main-title">
        <i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;BENEFITS PROJECTION
    </h3>
    <form class="form-inline" role="form" id="projection-form">
        <div class="col-md-4">
            <label for="dateTo" class="control-label">
                Date To:
            </label> <input type="text" readonly="readonly" name="dateTo"
                            class="form-control datepicker" id="dateTo"
                            placeholder="Date To">
        </div>
        <div class="col-md-3" id="divReason">
            <select id="reason" name="reason" class="form-control">
                <option value="">--Select A Reason for Exit--</option>
            </select>
        </div>
        <c:if test="${ planType == 'Defined Benefit' }">
            <div class="col-md-2">
                <select id="option" name="option" class="form-control">
                    <option>Reduced</option>
                    <option>UnReduced</option>
                </select>
            </div>
        </c:if>
        <div class="col-md-2">
            <button class="btn btn-primary">
                SHOW REPORT
            </button>
        </div>
    </form>
    <input type="hidden" id="scheme_id" value="${ scheme_id }"/>
    <input type="hidden" id="member_id" value="${ member_id }" />

    </div>
</div>

<div class="modal fade" id="modal-view-projection" tabindex="-1" role="dialog" aria-labelledby="myModalLabelViewProjection" aria-hidden="true">
    <form role="form" id="form-view-projection">
        <div class="modal-dialog large-modal">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title" id="myModalLabelViewContributions">
                        <i class="glyphicon glyphicon-picture"></i>&nbsp;&nbsp;BENEFITS PROJECTION
                    </h4>
                </div>
                <div class="modal-body">
                    <table class="table table-responsive table-striped table-bordered" id="select-results">
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

    var roundFormattedNumber = function(n){
        var result = parseFloat(n.replace(/[^0-9.]/g, ''));
        return isNaN(result) ? NaN : result.toFixed(0);
    };

    $(document).ready(function(){

        function initialize()
        {
            $.ajax({
                url: $('#base_url').val() + 'member',
                type: 'post',
                data: {ACTION:'REASON'},
                dataType: 'json',
                success: function(json) {
                    if(json.success)
                    {
                        json = $.parseJSON(json.data);
                        console.log(json);
                        var combo = "<select id=\"reason\" name=\"reason\" class=\"form-control\"><option>--Select Reason--</option>";
                        $.each(json, function(key, value) {
                            if(key == 'rows')
                            {
                                for ( var i = 0; i < json.rows.length; i++) {
                                    var row = json.rows[i];
                                    combo = combo + "<option value = " + row['id'] + ">" + row['reason'] + "</option>";
                                    array = json.rows;
                                }
                                combo = combo + "</select>";

                            }
                        });
                        $('#divReason').html(combo);
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

        $('.datepicker').datetimepicker(
                $('#dateTo').datetimepicker({
                    format: 'mm-dd-yyyy',
                    startView: 'month',
                    minView: 'month',
                    autoclose: true
                })
                        .on('changeDate', function(e) {
                            $(this).datetimepicker('hide');
                            // Revalidate the date field
                            $('#projection-form').bootstrapValidator('revalidateField', 'dateTo');
                        }));

        $('#projection-form').bootstrapValidator({
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
                            message: 'Please select the date'
                        }
                    }
                }
            }
        })
                .on('success.form.bv', function(e) {

                    start_wait();

                    $.ajax({

                        url: $('#base_url').val() + 'member',
                        type: 'post',
                        data: {ACTION:'BP_GRID',
                            dateTo: $('#dateTo').val(),
                            scheme_id: $('#scheme_id').val(),
                            member_id: $('#member_id').val(),
                            reason_id: $('#reason').val()
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

                                        html_head = "<tr><th ></th><th colspan='2' class='text-center'>EMPLOYEE</th><th colspan='2' class='text-center'>EMPLOYER</th></tr>";
                                        html_subhead = "<tr><th></th><th class='text-center'>REGISTERED</th><th class='text-center'>UNREGISTERED</th><th class='text-center'>REGISTERED</th><th class='text-center'>UNREGISTERED</th></tr>";

                                        for ( var i = 0; i < json.rows.length; i++) {

                                            var row = json.rows[i];

                                            var ee_intr_total = row['ee_intr_tot'];
                                            var intr_float = roundFormattedNumber(ee_intr_total);
                                            var ee_intr_final = parseFloat(intr_float).toFixed(3);

                                            var er_intr_tot = row['er_intr_tot'];
                                            var er_intr_float = roundFormattedNumber(er_intr_tot);
                                            var er_intr_final = parseFloat(er_intr_float).toFixed(3);

                                            rowOne = "<tr><th scope='row'>BALANCES</th><td>" + format_no(row['ben.eeBal']) + "</td><td></td><td>" + format_no(row['ben.erBal']) + "</td><td></td></tr>";
                                            rowTwo = "<tr><th scope='row'>CONTRIBUTION</th><td>" + format_no(row['ben.ee']) + "</td><td></td><td>" + format_no(row['ben.er']) + "</td><td></td></tr>";
                                            rowThree = "<tr><th scope='row'>AVC BALANCES</th><td>" + format_no(row['ben.avcBal']) + "</td><td></td><td>" + format_no(row['ben.avcerBal']) + "</td><td></td></tr>";
                                            rowFour = "<tr><th scope='row'>AVC</th><td>" + format_no(row['ben.avc']) + "</td><td></td><td>" + format_no(row['ben.avcer']) + "</td><td></td></tr>";
                                            rowFive = "<tr><th scope='row'>INTEREST</th><td>" + ee_intr_final + "</td><td></td><td>" + er_intr_final + "</td><td></td></tr>";
                                            rowTotal = "<tr><th scope='row'>TOTALS</th><td>" + format_no(row['ben.eeTot']) + "</td><td></td><td>" + format_no(row['ben.erTot']) + "</td><td></td></tr>";

                                        }

                                        html = html_head + html_subhead + rowOne + rowTwo + rowThree + rowFour + rowFive + rowTotal;

                                        stop_wait();
                                    }

                                });
                            }
                            $('#select-results').html(html);
                            stop_wait();
                            $('#modal-view-projection').modal('show');
                        }

                    });

                });


    });

</script>
