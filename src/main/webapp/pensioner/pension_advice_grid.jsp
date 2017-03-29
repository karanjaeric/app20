<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 3/29/17
  Time: 8:35 AM
  To change this template use File | Settings | File Templates.
--%>
<div class="container-fluid section">

    <h3 class="text-center main-title">
        <i class="glyphicon glyphicon-file"></i>&nbsp;&nbsp;PENSION ADVICE (GRID)
    </h3>

    <form class="form-inline" role="form" id="pa-form">

        <div class="col-md-6" id="divPayrollYears">
            <select id="payrollYears" name="payrollYears" class="form-control">
                <option value="" class='disabled'>--Select Payroll Year--</option>
            </select>
        </div>

        <div class="col-md-6">
            <button class="btn btn-primary btn-sm">SHOW PENSION ADVICE</button>
        </div>
    </form>

    <input type="hidden" id="pensioner_id" value="${ pensioner_id } "/>
    <input type="hidden" id="scheme_id" value="${ scheme_id } "/>
    <p>&nbsp;</p>

    <div class="modal fade" id="modal-view-advice" tabindex="-1" role="dialog" aria-labelledby="myModalLabelViewAdvice" aria-hidden="true">
        <form role="form" id="form-view-advice">
            <div class="modal-dialog large-modal">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title" id="myModalLabelViewAdvice">
                            <i class="glyphicon glyphicon-picture"></i>&nbsp;&nbsp;PENSION ADVICE
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
                console.log("n is: " + n);
                var result = parseFloat(n.replace(/[^0-9.]/g, ''));
                return isNaN(result) ? NaN : result.toFixed(0);
            }
        };

        var array = {};
        $(document).ready(function(){

            function initialize()
            {
                $.ajax({
                    url: $('#base_url').val() + 'pensioner',
                    type: 'post',
                    data: {ACTION:'YEARS'},
                    dataType: 'json',
                    success: function(json) {
                        if(json.success)
                        {
                            json = $.parseJSON(json.data);
                            console.log("The json returned: " + json.toString());

                            var combo = "<select id=\"payrollYears\" name=\"payrollYears\" class=\"form-control\"><option class='disabled'>--Select Payroll Year--</option>";
                            $.each(json, function(key, value) {
                                var row;
                                if(key == 'years')
                                {
                                    for ( var i = 0; i < json.years.length; i++) {
                                        row = json.years[i];
                                        combo = combo + "<option>" + row['YEAR'] + "</option>";
                                        array = json.years;

                                        console.log("Array is " + array.toString());

                                    }
                                    combo = combo + "</select>";

                                }

                            });
                            $('#divPayrollYears').html(combo);
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

            $('#pa-form').bootstrapValidator({
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

                $.ajax({
                    url: $('#base_url').val() + 'pensioner',
                    type: 'post',
                    data: {ACTION:'PA_GRID',
                        pensioner_id: $('#pensioner_id').val(),
                        payrollYears: $('#payrollYears').val()
                    },
                    dataType: 'json',
                    success: function(json) {
                        console.log(json);

                        html_head = "<tr><th>DESCRIPTION</th><th>GROSS</th><th>DEDUCTIONS</th><th>TAX</th><th>ARREARS</th><th>TAX ON ARREARS</th><th>NET</th></tr>";
                        html = html_head;

                        var grossSum = 0;
                        var dedsSum = 0;
                        var taxSum = 0;
                        var arreasSum = 0;
                        var tax_on_arreasSum = 0;
                        var netSum = 0;

                        if(json.success)
                        {

                            json = $.parseJSON(json.data);
                            console.log(json);
                            $.each(json, function(key, value) {
                                if(key == 'rows')
                                {
                                    for ( var i = 0; i < json.rows.length; i++) {
                                        var row = json.rows[i];


                                        html = html + "<tr><td>" + row['month_year'] + "</td><td>" + format_no(row['gross']) + "</td><td>" + format_no(row['deds']) + "</td><td>" + format_no(row['tax']) +
                                                "</td><td>" + format_no(row['arreas'])+ "</td><td>" + format_no(row['tax_on_arreas']) + "</td><td>" + format_no(row['net']) + "</td></tr>";

                                        grossSum += Number(row['gross']);
                                        dedsSum += Number(row['deds']);
                                        taxSum += Number(row['tax']);
                                        arreasSum += Number(row['arreas']);
                                        tax_on_arreasSum += Number(row['tax_on_arreas']);
                                        netSum += Number(row['net']);

                                    }
                                    totals = "<tr><th>TOTAL: </th><th>" + format_no(grossSum) + "</th><th>" + format_no(dedsSum) + "</th><th>" + format_no(taxSum) + "</th><th>" + format_no(arreasSum) +
                                            "</th><th>" + format_no(tax_on_arreasSum) + "</th><th>" + format_no(netSum) + "</th></tr>";
                                    html = html + totals;
                                    stop_wait();
                                }
                            });
                        }
                        $('#select-results').html(html);
                        stop_wait();
                        $('#modal-view-advice').modal('show');
                    }
                });

            });

        });

    </script>
