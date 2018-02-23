<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 3/3/17
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
            <meta content="width=device-width, initial-scale=1, maximum-scale=1"


                  </head>


                <div class="container-fluid section">
                    <h3 class="text-center main-title">
                        <i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;CONTRIBUTION HISTORY (GRID)
                    </h3>
                    <table style="font-size: 12px"  class="table table-responsive table-condensed table-striped table-bordered" id="contributions_history_tbl">
                        <thead>

                            <tr>
                                <th style="padding: 0;text-align: center;">Date</th>
                                <th style="padding: 0;text-align: center;">Month</th>
                                <th style="padding: 0;text-align: center;">Year</th>
                                <th style="padding: 0;text-align: center;">EE</th>
                                <th style="padding: 0;text-align: center;">ER</th>
                                <th style="padding: 0;text-align: center;">Avc</th>
                                <th style="padding: 0;text-align: center;">AvcEr</th>
                                <th style="padding: 0;text-align: center;">Salary</th>
                                <th style="padding: 0;text-align: center;">Type</th>
                                <th style="padding: 0;text-align: center;">Total</th>
                                <th style="padding: 0;text-align: center;">Reg/Unreg</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach var="contributionHistory" items="${contributionsHistoryDtoLists}">
                                <tr>
                                    <td>${contributionHistory.datePaid}</td>
                                    <td style="padding:0;text-align:center;">

                                        ${contributionHistory.month}


                                    </td>
                                    <td style="padding: 0;text-align: center;">
                                        ${contributionHistory.year}



                                    </td>
                                    <td style="padding: 0;text-align: center;">
                                        <fmt:formatNumber value = "${contributionHistory.ee}" 
                                                          type = "number"/>




                                    </td>
                                    <td style="padding: 0;text-align: center;">
                                        <fmt:formatNumber value = " ${contributionHistory.er}" 
                                                          type = "number"/>




                                    </td>

                                    <td style="padding: 0;text-align: center;"> 
                                        <fmt:formatNumber value = "${contributionHistory.avc}" 
                                                          type = "number"/>




                                    </td>
                                    <td style="padding: 0;text-align: center;">
                                        <fmt:formatNumber value = "${contributionHistory.avcer}" 
                                                          type = "number"/>






                                    </td>
                                    <td style="padding: 0;text-align: center;">
                                        <fmt:formatNumber value = "${contributionHistory.salary}" 
                                                          type = "number"/>




                                    </td>
                                    <td style="padding: 0;text-align: center;">
                                        ${contributionHistory.type}





                                    </td>


                                    <td style="padding: 0;text-align: center;margin-top:1px;">


                                        ${contributionHistory.total}




                                    </td>
                                    <td style="padding: 0;text-align: center;margin-top:1px;">
                                        ${contributionHistory.regUnreg}



                                    </td>




                                </tr>
                            </c:forEach>



                        </tbody>

                    </table>


                </div>



                </html>
                <script>
                    $(document).ready(function () {
                        $('#contributions_history_tbl').DataTable({
                            dom: 'Bfrtip',
                            "bSort": false,
                            paging: false,
                            buttons: [

                                {
                                    extend: 'pdfHtml5',
                                    title: 'Contributions History',
                                    orientation: 'landscape', //landscape give you more space
                                    pageSize: 'A4'//A0 is the largest A5 smallest(A0,A1,A2,A3,legal,A4,A5,letter))


                                }

                            ]
                        });
                    });
                </script>
