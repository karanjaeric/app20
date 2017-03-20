<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 3/15/17
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<div class="container-fluid section">
    <h3 class="text-center main-title">
        <i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;BALANCES HISTORY (GRID)
    </h3>

    <form class="form-inline" role="form" id="balances-form">
        <input type="hidden" id="member_id" value="${ member_id }" />
        <div class="form-group col-md-6">

        </div>
        <div class="col-md-6">
            <button class="btn btn-primary">
                SHOW HISTORY
            </button>
        </div>
    </form>

</div>

<div class="modal fade" id="modal-view-balances" tabindex="-1" role="dialog" aria-labelledby="myModalLabelViewBalances" aria-hidden="true">
    <form role="form" id="form-view-balances">
        <div class="modal-dialog large-modal">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title" id="myModalLabelViewBalances">
                        <i class="glyphicon glyphicon-picture"></i>&nbsp;&nbsp;BALANCES HISTORY
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

    function format_date(date) {
        if(typeof	date != 'undefined')
        {
            //Seperates the components of the number
            var n= date.toString().split(' ')[0];

        }
        return n;
    }

    function stringToDate1(date) {
        if(typeof	date != 'undefined')
        {
            var n =date.toString().split('-');
            var date = new Date(n[1],n[0]-1,n[2]);
            console.log("Date from string: " + date)
        }
        return date;
    }

    function stringToDate(_date,_format,_delimiter)
    {
        var formatLowerCase=_format.toLowerCase();
        var formatItems=formatLowerCase.split(_delimiter);
        var dateItems=_date.split(_delimiter);
        var monthIndex=formatItems.indexOf("mm");
        var dayIndex=formatItems.indexOf("dd");
        var yearIndex=formatItems.indexOf("yyyy");
        var month=parseInt(dateItems[monthIndex]);
        month-=1;
        var formatedDate = new Date(dateItems[yearIndex],month,dateItems[dayIndex]).toISOString().slice(0,10);;
        console.log("Date from string: " + formatedDate);
        return formatedDate;
    }

    $(document).ready(function(){

        $('#balances-form').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
            }
        })
                .on('success.form.bv', function(e) {

                    start_wait();

                    $.ajax({
                        url: $('#base_url').val() + 'member',
                        type: 'post',
                        data: {ACTION:'BH_GRID',
                            member_id: $('#member_id').val()},
                        dataType: 'json',
                        success: function(json) {
                            console.log(json);

                            html_head = "<tr><th colspan='2' ></th><th colspan='4' class='text-center'>EMPLOYEE</th><th colspan='5' class='text-center'>EMPLOYER</th></tr>";
                            html = html_head + "<tr><th>PERIOD</th><th>OPENING</th><th>CONTR</th><th>INTEREST</th><th>CLOSING</th><th>OPENING</th><th>CONTR</th><th>INTEREST</th><th>CLOSING</th><th>TOTALS</th></tr>";
                            var member_no = 0;
                            var ee_bal = 0;
                            var ee_contr = 0;
                            var ee_intr = 0;
                            var er_bal = 0;
                            var er_contr = 0;
                            var er_intr = 0;
                            var as_at = 0;
                            if(json.success)
                            {

                                json = $.parseJSON(json.data);
                                console.log(json);
                                $.each(json, function(key, value) {
                                    if(key == 'rows')
                                    {
                                        for ( var i = 0; i < json.rows.length; i++) {
                                            var row = json.rows[i];

                                            var eeClose = (+row['ee_bal']) + (+row['ee_contr']) + (+row['ee_intr']);
                                            var erClose = (+row['er_bal']) + (+row['er_contr']) + (+row['er_intr']);
                                            var grandTotal = (+eeClose) + (+erClose);

                                            html = html + "<tr><td>" + stringToDate(format_date(row['as_at']),"yyyy-mm-dd","-") + "</td><td>" + format_no(row['ee_bal']) + "</td><td>" + format_no(row['ee_contr']) + "</td><td>" + format_no(row['ee_intr']) +
                                                    "</td><td>" + format_no(eeClose) + "</td><td>" + format_no(row['er_bal']) + "</td><td>" + format_no(row['er_contr']) + "</td><td>" + format_no(row['er_intr']) +
                                                    "</td><td>" + format_no(erClose) + "</td><td>" + format_no(grandTotal) + "</td></tr>";

                                            /*eeSum += row['ee'];
                                            erSum += row['er'];
                                            salSum += row['salary'];
                                            totalSum += row['total'];
                                            avcSum += row['avc'];
                                            avcErSum += row['avcer'];*/

                                        }
                                        /*empty = "<tr><th></th><th></th><th></th><th>TOTAL EE</th><th>TOTAL ER</th><th>TOTAL AVC</th><th>TOTAL AVCER</th><th>TOTAL SALARY</th><th></th><th>GRAND TOTAL</th><th></th></tr>";
                                        totals = "<tr><td></td><td></td><td></td><td>" + format_no(eeSum) + "</td><td>" + format_no(erSum) + "</td><td>" + format_no(avcSum) + "</td><td>" + format_no(avcErSum) + "</td><td>" + format_no(salSum) +
                                                "</td><td></td><td>" + format_no(totalSum) + "</td><td></td></tr>";
                                        console.log("EE SUM IS: " + format_no(eeSum));
                                        html = html + empty + totals;*/
                                        stop_wait();
                                    }
                                });
                            }
                            $('#select-results').html(html);
                            stop_wait();
                            $('#modal-view-balances').modal('show');
                        }
                    });
                });
    });

</script>