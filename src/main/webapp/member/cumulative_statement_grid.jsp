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
        CUMULATIVE STATEMENT
    </h3>


    <div class="row">
        <div class="col-md-12">
            <table class="table table-responsive table-bordered table-condensed table-striped" id="cumulative_statement" style="font-size: 12px">

                <thead>
                    <tr>
                        <th></th>
                        <th colspan="2">Employee</th>
                        <th colspan="2">Employer</th>
                        <th colspan="2">AVC</th>

                    </tr>

                    <tr>
                        <th></th>
                        <th style="padding: 0;text-align: center;">Registered(EE)</th>
                        <th style="padding: 0;text-align: center;">Unregistered(EE)</th>
                        <th style="padding: 0;text-align: center;">Registered(ER)</th>
                        <th style="padding: 0;text-align: center;">Unregistered(ER)</th>
                        <th style="padding: 0;text-align: center;">Registered(AVC)</th>
                        <th style="padding: 0;text-align: center;">Unregistered(AVC)</th>
                    </tr>


                </thead>
                <tbody>
                    <tr>
                        <td>Opening Balance</td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.openingEEReg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.openingEEUnreg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.openingERReg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.openingERUnreg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.openingAVCReg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.openingAVCUnreg}" 
                                          type = "number"/></td>
                    </tr>

                    <tr>
                        <td>Interest on Balances</td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.intrOpeningEEReg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.intrOpeningEEUnreg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.intrOpeningERReg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.intrOpeningERUnreg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.intrOpeningAVCReg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.intrOpeningAVCUnreg}" 
                                          type = "number"/></td>
                    </tr>
                    <tr>
                        <td>Contributions</td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.contrEEReg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.contrEEUnreg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.contrERReg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.contrERUnreg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.contrAVCReg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.contrAVCUnreg}" 
                                          type = "number"/></td>
                    </tr>

                    <tr>
                        <td>Interest on Contributions</td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.intrContrEEReg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.intrContrEEUnreg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.intrContrERReg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.intrContrERUnreg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.intrContrAVCReg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.intrContrAVCUnreg}" 
                                          type = "number"/></td>
                    </tr>

                    <tr>
                        <td>Transfers</td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.transferEEReg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.transferEEUnreg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.transferERReg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.transferERUnreg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.transferAVCReg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.transferAVCUnreg}" 
                                          type = "number"/></td>
                    </tr>

                    <tr>
                        <td>Payments</td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.payEEReg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.payEEUnreg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.payERReg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.payERUnreg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.payAVCReg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.payAVCUnreg}" 
                                          type = "number"/></td>
                    </tr>
                    <tr>
                        <td>Totals</td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.totalEEReg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.totalEEUnreg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.totalERReg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.totalERUnreg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.totalAVCReg}" 
                                          type = "number"/></td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.totalAVCUnreg}" 
                                          type = "number"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>Total Balances</td>
                        <td><fmt:formatNumber value = "${cumulativeMemberStatement.grandTotal}" 
                                          type = "number"/></td></td>
                    </tr>





                </tbody>
            </table>
        </div>
    </div>



</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('#cumulative_statement').DataTable({
            dom: 'Bfrtip',
            "searching": false,
            "bSort": false,
            "bInfo": false,
            //bFilter: false,
            paging: false,
            buttons: [

                {
                    extend: 'pdfHtml5',
                    text: 'Download Cumulative Statement',
                    title: 'Balances History',
                    orientation: 'landscape', //landscape give you more space
                    pageSize: 'A4'//A0 is the largest A5 smallest(A0,A1,A2,A3,legal,A4,A5,letter))


                }

            ]
        });
    });




</script>
