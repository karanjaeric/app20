<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid section">
    <h3 class="text-center main-title">
        <i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;MEMBER CERTIFICATE
    </h3>
    <input type="hidden" id="reportPath" value="${ settings.xiReportPath }" />
    <input type="hidden" id="xiRootPath" value="${ settings.xiPath }" />
    <input type="hidden" id="username" value="${ settings.xiReportUsername }" />
    <input type="hidden" id="password" value="${ settings.xiReportPassword }" />
    <input type="hidden" id="scheme_id" value="${ scheme_id }"/>
    <input type="hidden" id="member_id" value="${ member_id }" />

    <input type="hidden" id="alternativeUrl" value="${ report_details.alternativeUrl }" />
    <input type="hidden" id="orientation" value="${ report_details.orientation }" />

    <p>&nbsp;</p>
    <div class="col-md-12" id="mce-results">

    </div>
</div>
<script type="text/javascript">


    $(document).ready(function(){

        $.ajax({
            url: $('#base_url').val() + 'member',
            type: 'post',
            data: {ACTION:'AP'},
            dataType: 'json',
            success: function(json) {
                if(json.success)
                {
                    json = $.parseJSON(json.data);
                    console.log(json.accountingPeriodId);


                    var alternativeUrl = $('#alternativeUrl').val();
                    console.log("Alternative: " + alternativeUrl);
                    var orientation = $('#orientation').val();
                    console.log("Orientation: " + orientation);
                    var userId =3347;

                       console.log("BI Path: " + $('#reportPath').val());


                    var url = $('#reportPath').val() + 'members/Individual Membership Certificate.xdo?_xpf=&_xpt=0&_xdo=%2F~weblogic%2Ffundmaster%2Freports%2Fmembers%2FIndividual%20Membership%20Certificate.xdo&_xmode=3&_paramsuser_id=' + userId +
                        '&_paramsBASE=' + $('#xiRootPath').val() + '&_paramsscheme_id=' + $('#scheme_id').val() + '&_paramsap_id=' + json.accountingPeriodId + '&_paramsmember_id='+ $('#member_id').val() +'&_xt=Individual%20Membership%20Certificate&_xf=analyze&_xana=view'
                        + $("#username").val() + '&passwd=' + $("#password").val() + '&_paramsblankImage=' + alternativeUrl +'&_paramsalternativeUrl=' + alternativeUrl + '&_paramsorientation=' + orientation;
                    console.log("BI After: " + url);
                    console.log("============= Done Fetching report ===================");
                    $("#mce-results").html('<object width="100%" height="700px" data="' + url + '"><h2 class="text-center"><small>Could not load report. Check that the report server is correctly configured and running</small></h2></object>');
                }
            }
        });
    });
</script>