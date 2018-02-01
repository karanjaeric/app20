<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 3/3/17
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid section">
    <h3 class="text-center main-title">
        <i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;CONTRIBUTION HISTORY (GRID)
    </h3>

    <form class="form-inline" role="form" id="contribution-form">
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
            <label class="control-label"></label><br/>
            <button class="btn btn-primary">
                SHOW HISTORY
            </button>
        </div>
    </form>
</div>

<div class="modal fade" id="modal-view-contribution" tabindex="-1" role="dialog" aria-labelledby="myModalLabelViewContributions" aria-hidden="true">
    <form role="form" id="form-view-contributions">
        <div class="modal-dialog large-modal">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title" id="myModalLabelViewContributions">
                        <i class="glyphicon glyphicon-picture"></i>&nbsp;&nbsp;CONTRIBUTION HISTORY
                    </h4>
                </div>
                <div class="modal-body" style=" width: 750px;margin: auto">
                    <table  class="table table-responsive table-striped table-bordered" id="select-results">
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
                            $('#contribution-form').bootstrapValidator('revalidateField', 'dateTo');
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
                            $('#contribution-form').bootstrapValidator('revalidateField', 'dateTo');
                        }));


        $('#contribution-form').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                dateFrom: {
                    validators: {
                        notEmpty: {
                            message: 'Please select the start date'
                        }
                    }
                },
                dateTo: {
                    validators: {
                        notEmpty: {
                            message: 'Please select the ending date'
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
                            data: {ACTION:'CH_GRID',
                                dateFrom: $('#dateFrom').val(),
                                dateTo: $('#dateTo').val()},
                            dataType: 'json',
                            success: function(json) {
                                console.log(json);
                                html = "<tr><th>DATE</th><th>MONTH</th><th>YEAR</th><th>EE</th><th>ER</th><th>AVC</th><th>AVCER</th><th>SALARY</th><th>TYPE</th><th>TOTAL</th><th>REGISTERED/<br>UNREGISTERED</th></tr>";
                                var eeSum = 0;
                                var erSum = 0;
                                var avcSum = 0;
                                var avcErSum = 0;
                                var salSum = 0;
                                var totalSum = 0;
                                if(json.success)
                                {

                                    json = $.parseJSON(json.data);
                                    console.log(json);
                                    $.each(json, function(key, value) {
                                        if(key == 'rows')
                                        {
                                            for ( var i = 0; i < json.rows.length; i++) {
                                                var row = json.rows[i];
                                                html = html + "<tr><td>" + row['datePaid'] + "</td><td>" + row['month'] + "</td><td>" + row['year'] + "</td><td>" + format_no(row['ee']) + "</td><td>" + format_no(row['er']) +
                                                        "</td><td>" + format_no(row['avc']) + "</td><td>" + format_no(row['avcer']) + "</td><td>" + format_no(row['salary']) + "</td><td>" + row['type'] +
                                                        "</td><td>" + format_no(row['total']) + "</td><td>" + row['status'] + "</td></tr>";

                                                eeSum += row['ee'];
                                                erSum += row['er'];
                                                salSum += row['salary'];
                                                totalSum += row['total'];
                                                avcSum += row['avc'];
                                                avcErSum += row['avcer'];

                                            }
                                            empty = "<tr><th></th><th></th><th></th><th>TOTAL EE</th><th>TOTAL ER</th><th>TOTAL AVC</th><th>TOTAL AVCER</th><th>TOTAL SALARY</th><th></th><th>GRAND TOTAL</th><th></th></tr>";
                                            totals = "<tr><td></td><td></td><td></td><td>" + format_no(eeSum) + "</td><td>" + format_no(erSum) + "</td><td>" + format_no(avcSum) + "</td><td>" + format_no(avcErSum) + "</td><td>" + format_no(salSum) +
                                                    "</td><td></td><td>" + format_no(totalSum) + "</td><td></td></tr>";
                                            console.log("EE SUM IS: " + format_no(eeSum));
                                            html = html + empty + totals;
                                            stop_wait();
                                        }
                                    });
                                }
                                $('#select-results').html(html);
                                stop_wait();
                                $('#modal-view-contribution').modal('show');
                            }
                        });
                });
    });

</script>
