<%-- 
    Document   : test
    Created on : Feb 15, 2018, 4:27:30 PM
    Author     : ekaranja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html ng-app="mssModule">
    <head>
        <meta charset="utf-8"/>
        <link href="DataTables/datatables.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="container-fluid section">

            <table class="table table-responsive table-striped table-bordered" id="select-results1">

                <thead>

                    <tr>
                        <th>Period Ending</th>
                        <th>Opening(ee)</th>
                        <th>Contr(ee)</th>
                        <th>Interest(ee)</th>
                        <th>Closing(ee)</th>
                        <th>Opening(er)</th>
                        <th>Contr(er)</th>
                        <th>Interest(er)</th>
                        <th>Closing(er)</th>
                        <th>Totals</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="historyList" items="${closingBalancesList}">
                        <tr>
                            <td>${historyList.asAt}</td>
                            <td>
                                <script type="text/javascript">
                                    eebal = '${historyList.eeBal}';
                                    document.write(eebal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
                                </script>

                            </td>
                            <td>
                                <script type="text/javascript">
                                    eebal = '${historyList.eeContr}';
                                    document.write(eebal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
                                </script>

                            </td>
                            <td>
                                <script type="text/javascript">
                                    eebal = '${historyList.eeIntr}';
                                    document.write(eebal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
                                </script>


                            </td>
                            <td>
                                <script type="text/javascript">
                                    eebal = ' ${historyList.eeClose}';
                                    document.write(eebal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
                                </script>


                            </td>

                            <td>

                                <script type="text/javascript">
                                    eebal = '${historyList.erBal}';
                                    document.write(eebal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
                                </script>

                            </td>
                            <td>
                                <script type="text/javascript">
                                    eebal = ' ${historyList.erContr}';
                                    document.write(eebal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
                                </script>




                            </td>
                            <td>
                                <script type="text/javascript">
                                    eebal = '${historyList.erIntr}';
                                    document.write(eebal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
                                </script>


                            </td>
                            <td>

                                <script type="text/javascript">
                                    eebal = '${historyList.erClose}';
                                    document.write(eebal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
                                </script>



                            </td>


                            <td>
                                <script type="text/javascript">
                                    eebal = '${historyList.grandTotal}';
                                    document.write(eebal.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
                                </script>



                            </td>



                        </tr>
                    </c:forEach>

                </tbody>
            </table>

        </div>





        <script src="static/custom/vendors/jquery-1.9.1.min.js"></script>
        <!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>-->
        <script type="text/javascript"
        src="static/bootstrap-3.3.5/js/bootstrap.min.js"></script>
        <script type="text/javascript"
        src="static/bootstrap-3.3.5/js/bootstrapValidator.min.js"></script>
        <script src="static/bootstrap-3.3.5/js/bootstrap-filestyle.min.js"></script>
        <script type="text/javascript"
        src="static/bootstrap-3.3.5/js/bootstrap-multiselect.js"></script>
        <script type="text/javascript"
        src="static/bootstrap-3.3.5/js/bootstrap-datetimepicker.min.js"></script>
        <script type="text/javascript"
        src="static/custom/js/bootbox.min.js"></script>
        <script type="text/javascript" src="static/custom/js/scripts.js"></script>
        <script type="text/javascript" src="static/custom/js/form-scripts.js"></script>
        <script type="text/javascript" src="static/custom/js/highcharts-custom.js"></script>
        <script type="text/javascript" src="static/custom/js/core.js"></script>
        <script type="text/javascript" src="static/custom/js/plugins/jquery.appear/jquery.appear.js"></script>
        <script src="DataTables/datatables.js" type="text/javascript"></script>
        <script src="static/angular.js" type="text/javascript"></script>

        <script>
                                    $(document).ready(function () {
                                        $('#select-results1').DataTable({
                                            dom: 'Bfrtip',
                                            buttons: [

                                                {
                                                    extend: 'pdfHtml5',
                                                    title: 'Balances History',
                                                    orientation: 'landscape', //landscape give you more space
                                                    pageSize: 'A4'//A0 is the largest A5 smallest(A0,A1,A2,A3,legal,A4,A5,letter))


                                                }

                                            ]
                                        });
                                    });
                                    function format_no(yourNumber) {
                                        if (typeof yourNumber != 'undefined')
                                        {
                                            //Seperates the components of the number
                                            var n = yourNumber.toString().split(".");
                                            //Comma-fies the first part
                                            n[0] = n[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
                                            //Combines the two sections
                                            return n.join(".");
                                        }
                                        return yourNumber;
                                    }

                                    function format_date(date) {
                                        if (typeof date != 'undefined')
                                        {
                                            //Seperates the components of the number
                                            var n = date.toString().split(' ')[0];
                                        }
                                        return n;
                                    }

                                    var roundFormattedNumber = function (n) {

                                        if (typeof n != 'undefined') {
                                            console.log("n is: " + n);
                                            var result = parseFloat(n.replace(/[^0-9.]/g, ''));
                                            return isNaN(result) ? NaN : result.toFixed(0);
                                        }
                                    };
                                    function stringToDate(_date, _format, _delimiter)
                                    {
                                        var formatLowerCase = _format.toLowerCase();
                                        var formatItems = formatLowerCase.split(_delimiter);
                                        var dateItems = _date.split(_delimiter);
                                        var monthIndex = formatItems.indexOf("mm");
                                        var dayIndex = formatItems.indexOf("dd");
                                        var yearIndex = formatItems.indexOf("yyyy");
                                        var month = parseInt(dateItems[monthIndex]);
                                        month -= 1;
                                        var formatedDate = new Date(dateItems[yearIndex], month, dateItems[dayIndex]).toISOString().slice(0, 10);
                                        ;
                                        console.log("Date from string: " + formatedDate);
                                        return formatedDate;
                                    }

                                    $(document).ready(function () {

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
                                                .on('success.form.bv', function (e) {
                                                    alert($('#member_id1').val());
                                                    start_wait();
                                                    $.ajax({
                                                        url: 'http://localhost:8080/Mss/' + 'member',
                                                        type: 'post',
                                                        data: {ACTION: 'BH_GRID',
                                                            member_id: $('#member_id1').val()},
                                                        dataType: 'json',
                                                        success: function (json) {
                                                            console.log(json);
                                                            //html_head = "<thead><tr><th colspan='2' ></th><th colspan='4' class='text-center'>EMPLOYEE</th><th colspan='5' class='text-center'>EMPLOYER</th></tr>";
                                                            html = "<thead><tr><th>PERIOD ENDING</th><th>OPENING</th><th>CONTR</th><th>INTEREST</th><th>CLOSING</th><th>OPENING</th><th>CONTR</th><th>INTEREST</th><th>CLOSING</th><th>TOTALS</th></tr></thead>";
                                                            var member_no = 0;
                                                            var ee_bal = 0;
                                                            var ee_contr = 0;
                                                            var ee_intr = 0;
                                                            var er_bal = 0;
                                                            var er_contr = 0;
                                                            var er_intr = 0;
                                                            var as_at = 0;
                                                            if (json.success)
                                                            {

                                                                json = $.parseJSON(json.data);
                                                                console.log(json);
                                                                $.each(json, function (key, value) {
                                                                    if (key == 'rows')
                                                                    {
                                                                        for (var i = 0; i < json.rows.length; i++) {
                                                                            var row = json.rows[i];
                                                                            var eeClose = (+row['ee_bal']) + (+row['ee_contr']) + (+row['ee_intr']);
                                                                            var erClose = (+row['er_bal']) + (+row['er_contr']) + (+row['er_intr']);
                                                                            //var er_close_format = roundFormattedNumber(erClose);
                                                                            var er_close_final = parseFloat(erClose).toFixed(2);
                                                                            var grandTotal = (+eeClose) + (+er_close_final);
                                                                            //var grandTotal_format = roundFormattedNumber(grandTotal);
                                                                            var grandTotal_format_final = parseFloat(grandTotal).toFixed(2);
                                                                            html = html + "<tbody><tr><td>" + format_date(row['as_at']) + "</td><td>" + format_no(row['ee_bal']) + "</td><td>" + format_no(row['ee_contr']) + "</td><td>" + format_no(row['ee_intr']) +
                                                                                    "</td><td>" + format_no(eeClose.toFixed(2)) + "</td><td>" + format_no(row['er_bal']) + "</td><td>" + format_no(row['er_contr']) + "</td><td>" + format_no(row['er_intr']) +
                                                                                    "</td><td>" + format_no(er_close_final) + "</td><td>" + format_no(grandTotal_format_final) + "</td></tr></tbody>";
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
                                                            start_wait();
                                                            $('#select-results').html(html);
                                                            stop_wait();
                                                            $('#select-results1').DataTable({
                                                                destroy: true,
                                                                dom: 'Bfrtip',
                                                                buttons: [

                                                                    'pdfHtml5'
                                                                ]
                                                            });
                                                            //$('#modal-view-balances').modal('show');


                                                        }
                                                    });
                                                });
                                    });
                                    var app = angular.module("mssModule", []);
                                    app.controller("mssContoller", ['$scope', '$window', '$http', function ($scope, $window, $http) {
                                            $scope.closingBalances = function (memberId) {
                                                // alert(memberId);exit();
                                                // $window.alert("itemcode is "+$scope.itemCode);

                                                $http({
                                                    url: "/Mss/member",
                                                    method: "get",
                                                    type: 'post',
                                                    params: {
                                                        "member_id": memberId,
                                                        ACTION: 'BH_GRID'

                                                    }
                                                }).then(function (result) {
                                                    $window.alert("ajax success" + result.status + " " + result.data);
                                                    $scope.itemsDataList = result.data;
                                                }, function (result) {
                                                    $window.alert("Ajax fail");
                                                });
                                            };
                                        }]);
//                                    app.config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
//                                            $locationProvider.hashPrefix('!');
//
//                                            $routeProvider.otherwise({redirectTo: '/home'});
//                                        }]);






        </script>
    </body>
</html>
