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
                      

                            </td>
                            <td style="padding: 0;text-align: center;">
                                <fmt:formatNumber value = "${historyList.eeContr}" 
                                                  type = "number"/>

     

                            </td>
                            <td style="padding: 0;text-align: center;">
                                <fmt:formatNumber value = "${historyList.eeIntr}" 
                                                  type = "number"/>

                    

                            </td>
                            <td style="padding: 0;text-align: center;">
                                <fmt:formatNumber value = " ${historyList.eeClose}" 
                                                  type = "number"/>

                            


                            </td>

                            <td style="padding: 0;text-align: center;"> 
                                <fmt:formatNumber value = "${historyList.erBal}" 
                                                  type = "number"/>


                            </td>
                            <td style="padding: 0;text-align: center;">
                                <fmt:formatNumber value = "${historyList.erContr}" 
                                                  type = "number"/>




                            </td>
                            <td style="padding: 0;text-align: center;">
                                <fmt:formatNumber value = "${historyList.erIntr}" 
                                                  type = "number"/>


                            </td>
                            <td style="padding: 0;text-align: center;">
                                <fmt:formatNumber value = "${historyList.erClose}" 
                                                  type = "number"/>




                            </td>


                            <td style="padding: 0;text-align: center;margin-top:1px;">
                                <fmt:formatNumber value = "${historyList.grandTotal}" 
                                                  type = "number"/>



                            </td>



                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </div>



</div>

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




</script>
