<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 3/15/17
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<div class="container-fluid section">
    <h3 class="text-center main-title">
        <i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;BALANCES HISTORY (GRID)
    </h3>


    <div class="row">
        <div class="col-md-12">
            <table class="table table-responsive table-bordered table-condensed table-striped" id="select-results1" style="font-size: 12px">

                <thead>
                    <tr>
                        <th></th>
                        <th colspan="4">Employee</th>
                        <th colspan="4">Employer</th>
                        <th></th>
                    </tr>

                    <tr>
                        <th style="padding: 0;text-align: center;">Period Ending</th>
                        <th style="padding: 0;text-align: center;">Opening(ee)</th>
                        <th style="padding: 0;text-align: center;">Contr(ee)</th>
                        <th style="padding: 0;text-align: center;">Interest(ee)</th>
                        <th style="padding: 0;text-align: center;">Closing(ee)</th>
                        <th style="padding: 0;text-align: center;">Opening(er)</th>
                        <th style="padding: 0;text-align: center;">Contr(er)</th>
                        <th style="padding: 0;text-align: center;">Interest(er)</th>
                        <th style="padding: 0;text-align: center;">Closing(er)</th>
                        <th style="padding: 0;text-align: center;">Totals</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="historyList" items="${closingBalancesList}">
                        <tr>
                            <td>${historyList.asAt}</td>
                            <td style="padding:0;text-align:center;">

                                <fmt:formatNumber value = "${historyList.eeBal}" 
                                                  type = "number"/>
                                <!--                        <script type="text/javascript">
                                                            eebal = ';
                                                            document.write(eebal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
                                                        </script>-->

                            </td>
                            <td style="padding: 0;text-align: center;">
                                <fmt:formatNumber value = "${historyList.eeContr}" 
                                                  type = "number"/>

                                <!--                        <script type="text/javascript">
                                                            eebal = '';
                                                            document.write(eebal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
                                                        </script>-->

                            </td>
                            <td style="padding: 0;text-align: center;">
                                <fmt:formatNumber value = "${historyList.eeIntr}" 
                                                  type = "number"/>

                                <!--                        <script type="text/javascript">
                                                            eebal = '';
                                                            document.write(eebal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
                                                        </script>-->


                            </td>
                            <td style="padding: 0;text-align: center;">
                                <fmt:formatNumber value = " ${historyList.eeClose}" 
                                                  type = "number"/>

                                <!--                        <script type="text/javascript">
                                                            eebal = ' ';
                                                            document.write(eebal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
                                                        </script>-->


                            </td>

                            <td style="padding: 0;text-align: center;"> 
                                <fmt:formatNumber value = "${historyList.erBal}" 
                                                  type = "number"/>


                                <!--                        <script type="text/javascript">
                                                            eebal = '';
                                                            document.write(eebal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
                                                        </script>-->

                            </td>
                            <td style="padding: 0;text-align: center;">
                                <fmt:formatNumber value = "${historyList.erContr}" 
                                                  type = "number"/>

                                <!--                        <script type="text/javascript">
                                                            eebal = ' ';
                                                            document.write(eebal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
                                                        </script>-->




                            </td>
                            <td style="padding: 0;text-align: center;">
                                <fmt:formatNumber value = "${historyList.erIntr}" 
                                                  type = "number"/>

                                <!--                        <script type="text/javascript">
                                                            eebal = '';
                                                            document.write(eebal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
                                                        </script>-->


                            </td>
                            <td style="padding: 0;text-align: center;">
                                <fmt:formatNumber value = "${historyList.erClose}" 
                                                  type = "number"/>


                                <!--                        <script type="text/javascript">
                                                            eebal = '';
                                                            document.write(eebal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
                                                        </script>-->



                            </td>


                            <td style="padding: 0;text-align: center;margin-top:1px;">
                                <fmt:formatNumber value = "${historyList.grandTotal}" 
                                                  type = "number"/>

                                <!--                        <script type="text/javascript">
                                                            eebal = '';
                                                            document.write(eebal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
                                                        </script>-->



                            </td>



                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </div>



</div>

<!--<div class="modal fade" id="modal-view-balances" tabindex="-1" role="dialog" aria-labelledby="myModalLabelViewBalances" aria-hidden="true">
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
</div>-->



<script type="text/javascript">
    $(document).ready(function () {
        $('#select-results1').DataTable({
            dom: 'Bfrtip',
            "searching": false,
            "bSort": false,
            "bInfo": false,
            //bFilter: false,
            paging: false,
            buttons: [

                {
                    extend: 'pdfHtml5',
                    text: 'Download Balances History',
                    title: 'Balances History',
                    orientation: 'landscape', //landscape give you more space
                    pageSize: 'A4'//A0 is the largest A5 smallest(A0,A1,A2,A3,legal,A4,A5,letter))


                }

            ]
        });
    });

//    function format_no(yourNumber) {
//        if (typeof yourNumber != 'undefined')
//        {
//            //Seperates the components of the number
//            var n = yourNumber.toString().split(".");
//            //Comma-fies the first part
//            n[0] = n[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
//            //Combines the two sections
//            return n.join(".");
//        }
//        return yourNumber;
//    }
//
//    function format_date(date) {
//        if (typeof date != 'undefined')
//        {
//            //Seperates the components of the number
//            var n = date.toString().split(' ')[0];
//
//        }
//        return n;
//    }
//
//    var roundFormattedNumber = function (n) {
//
//        if (typeof n != 'undefined') {
//            console.log("n is: " + n);
//            var result = parseFloat(n.replace(/[^0-9.]/g, ''));
//            return isNaN(result) ? NaN : result.toFixed(0);
//        }
//    };
//
//    function stringToDate(_date, _format, _delimiter)
//    {
//        var formatLowerCase = _format.toLowerCase();
//        var formatItems = formatLowerCase.split(_delimiter);
//        var dateItems = _date.split(_delimiter);
//        var monthIndex = formatItems.indexOf("mm");
//        var dayIndex = formatItems.indexOf("dd");
//        var yearIndex = formatItems.indexOf("yyyy");
//        var month = parseInt(dateItems[monthIndex]);
//        month -= 1;
//        var formatedDate = new Date(dateItems[yearIndex], month, dateItems[dayIndex]).toISOString().slice(0, 10);
//        ;
//        console.log("Date from string: " + formatedDate);
//        return formatedDate;
//    }
//
//    $(document).ready(function () {
//
//        $('#balances-form').bootstrapValidator({
//            message: 'This value is not valid',
//            feedbackIcons: {
//                valid: 'glyphicon glyphicon-ok',
//                invalid: 'glyphicon glyphicon-remove',
//                validating: 'glyphicon glyphicon-refresh'
//            },
//            fields: {
//            }
//        })
//                .on('success.form.bv', function (e) {
//
//                    start_wait();
//
//                    $.ajax({
//                        url: $('#base_url').val() + 'member',
//                        type: 'post',
//                        data: {ACTION: 'BH_GRID',
//                            member_id: $('#member_id').val()},
//                        dataType: 'json',
//                        success: function (json) {
//                            console.log(json);
//
//                            html_head = "<thead><tr><th colspan='5' class='text-center'>EMPLOYEE</th><th colspan='5' class='text-center'>EMPLOYER</th></tr>";
//                            html = html_head + "<tr><th>PERIOD ENDING</th><th>OPENING</th><th>CONTR</th><th>INTEREST</th><th>CLOSING</th><th>OPENING</th><th>CONTR</th><th>INTEREST</th><th>CLOSING</th><th>TOTALS</th></tr></thead>";
//                            var member_no = 0;
//                            var ee_bal = 0;
//                            var ee_contr = 0;
//                            var ee_intr = 0;
//                            var er_bal = 0;
//                            var er_contr = 0;
//                            var er_intr = 0;
//                            var as_at = 0;
//                            if (json.success)
//                            {
//
//                                json = $.parseJSON(json.data);
//                                console.log(json);
//                                $.each(json, function (key, value) {
//                                    if (key == 'rows')
//                                    {
//                                        for (var i = 0; i < json.rows.length; i++) {
//                                            var row = json.rows[i];
//
//
//
//                                            var eeClose = (+row['ee_bal']) + (+row['ee_contr']) + (+row['ee_intr']);
//                                            var erClose = (+row['er_bal']) + (+row['er_contr']) + (+row['er_intr']);
//
//                                            //var er_close_format = roundFormattedNumber(erClose);
//                                            var er_close_final = parseFloat(erClose).toFixed(2);
//
//                                            var grandTotal = (+eeClose) + (+er_close_final);
//
//                                            //var grandTotal_format = roundFormattedNumber(grandTotal);
//                                            var grandTotal_format_final = parseFloat(grandTotal).toFixed(2);
//
//                                            html = html + "<tbody><tr><td>" + format_date(row['as_at']) + "</td><td>" + format_no(row['ee_bal']) + "</td><td>" + format_no(row['ee_contr']) + "</td><td>" + format_no(row['ee_intr']) +
//                                                    "</td><td>" + format_no(eeClose.toFixed(2)) + "</td><td>" + format_no(row['er_bal']) + "</td><td>" + format_no(row['er_contr']) + "</td><td>" + format_no(row['er_intr']) +
//                                                    "</td><td>" + format_no(er_close_final) + "</td><td>" + format_no(grandTotal_format_final) + "</td></tr></tbody>";
//
//                                            /*eeSum += row['ee'];
//                                             erSum += row['er'];
//                                             salSum += row['salary'];
//                                             totalSum += row['total'];
//                                             avcSum += row['avc'];
//                                             avcErSum += row['avcer'];*/
//
//                                        }
//                                        /*empty = "<tr><th></th><th></th><th></th><th>TOTAL EE</th><th>TOTAL ER</th><th>TOTAL AVC</th><th>TOTAL AVCER</th><th>TOTAL SALARY</th><th></th><th>GRAND TOTAL</th><th></th></tr>";
//                                         totals = "<tr><td></td><td></td><td></td><td>" + format_no(eeSum) + "</td><td>" + format_no(erSum) + "</td><td>" + format_no(avcSum) + "</td><td>" + format_no(avcErSum) + "</td><td>" + format_no(salSum) +
//                                         "</td><td></td><td>" + format_no(totalSum) + "</td><td></td></tr>";
//                                         console.log("EE SUM IS: " + format_no(eeSum));
//                                         html = html + empty + totals;*/
//                                        stop_wait();
//                                    }
//                                });
//                            }
//                            $('#select-results').html(html);
//                            stop_wait();
////                                  $('#select-results').DataTable({
////                                                destroy: true,
////                                                dom: 'Bfrtip',
////                                                buttons: [
////
////                                                    'pdfHtml5'
////                                                ]
////                                            });
//                            $('#modal-view-balances').modal('show');
//
//
//                        }
//                    });
//                });
//    });



</script>