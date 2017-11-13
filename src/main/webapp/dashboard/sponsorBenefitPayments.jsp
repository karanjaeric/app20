<%--
  Created by IntelliJ IDEA.
  User: lifeofpablo
  Date: 11/13/17
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid section">
    <h3 class="text-center main-title">
        <i class="glyphicon glyphicon-list"></i>&nbsp;&nbsp;SPONSOR BENEFIT PAYMENT
    </h3>
    <input type="hidden" id="reportPath" value="${ settings.xiReportPath }" />
    <input type="hidden" id="xiRootPath" value="${ settings.xiPath }" />
    <input type="hidden" id="username" value="${ settings.xiReportUsername }" />
    <input type="hidden" id="password" value="${ settings.xiReportPassword }" />
    <input type="hidden" id="scheme_id" value="${ scheme_id }"/>
     <input type="hidden" id="sponsor_id" value="${ sponsorId }"/>

    <input type="hidden" id="alternativeUrl" value="${ report_details.alternativeUrl }" />
    <input type="hidden" id="orientation" value="${ report_details.orientation }" />

    <p>&nbsp;</p>
    <div class="col-md-12" id="sbp-results">

    </div>
</div>

<script type="text/javascript">


    $(document).ready(function(){

        var alternativeUrl = $('#alternativeUrl').val();
        console.log("Alternative: " + alternativeUrl);
        var orientation = $('#orientation').val();
        console.log("Orientation: " + orientation);

        http://192.168.1.166:7001/xmlpserver/~weblogic/fundmaster/reports/
            // members/Sponsor Benefit payment Summary.xdo?_xpf=&_xpt=0&_xdo=%2F~weblogic%2Ffundmaster%2Freports%2Fmembers%2FSponsor%20Benefit%20payment%20Summary.xdo&_xmode=3&_paramsscheme_id=2873&_paramssponsor_Id=4983140&_paramsorientation=RIGHT&_paramsblankImage=&_paramsalternativeUrl=&_xt=Sponsor%20Benefit%20Payment%20Summary
            // &_xf=analyze&_xana=view

        var url =
            $('#reportPath').val() +"members/Sponsor Benefit payment Summary.xdo?_xpf=&_xpt=0&_xdo=%2F~weblogic%2Ffundmaster%2Freports%2Fmembers%2FSponsor%20Benefit%20payment%20Summary.xdo&_xmode=3&_paramsscheme_id=" +
            + $('#scheme_id').val() +'&_paramssponsor_Id=' +  $('#sponsor_id').val() + "&_paramsorientation=RIGHT&_paramsblankImage=&_paramsalternativeUrl=&_xt=Sponsor%20Benefit%20Payment%20Summary&_xf=analyze&_xana=view" +
            "&id=" + $('#username').val() + "&passwd=" + $('#password').val();


        $("#sbp-results").html('<object width="100%" height="700px" data="' + url + '"><h2 class="text-center"><small>Could not load report. Check that the report server is correctly configured and running</small></h2></object>');
    });

</script>
