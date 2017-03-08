<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 3/8/17
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid section">
    <h3 class="text-center main-title">
        <i class="glyphicon glyphicon-list"></i>&nbsp;&nbsp; MEMBER LISTING
    </h3>
    <input type="hidden" id="reportPath" value="${ settings.xiReportPath }" />
    <input type="hidden" id="xiRootPath" value="${ settings.xiPath }" />
    <input type="hidden" id="username" value="${ settings.xiReportUsername }" />
    <input type="hidden" id="password" value="${ settings.xiReportPassword }" />
    <input type="hidden" id="scheme_id" value="${ scheme_id }"/>
    <p>&nbsp;</p>
    <div class="col-md-12" id="ml-results">

    </div>
</div>

<script type="text/javascript">

    var str = $('#xiRootPath').val();
    var res = str.replace("/api/", "");
    console.log(res);

    $(document).ready(function(){

        $.ajax({
            url: $('#base_url').val() + 'admin',
            type: 'post',
            data: {ACTION:'AP'},
            dataType: 'json',
            success: function(json) {
                if(json.success)
                {
                    var alternativeUrl = null;
                    var orientation = null;

                    $.ajax({
                        url:  res + '/reports/general?_eventName=base-url&schemeId=' + $('#scheme_id').val(),
                        data: '',
                        type:'get',
                        async: false,
                        /*dataType: 'json',*/
                        success:function(json){
                            console.log(json);
                            var json_string =  json;
                            var result =  $.parseJSON(json_string);
                            var base_url = result.base_url;
                            console.log(base_url);
                            alternativeUrl = result.alternativeUrl;
                            console.log(alternativeUrl);
                            orientation = result.orientation;
                            console.log(orientation);
                        }
                    });

                    var url =
                            $('#reportPath').val() +"members/Member Listing.xdo?_xpf=&_xpt=0&_xdo=%2F~weblogic%2Ffundmaster%2Freports%2Fmembers%2FMember%20Listing.xdo&_xmode=3&_paramsblankImage=&_paramsalternativeUrl=&_paramsorientation=&_paramsBASE=http%3A%2F%2Flocalhost%3A8080%2FXi&_paramsscheme_id="
                            + $('#scheme_id').val() + "&_xt=Member%20Listing&_xf=analyze&_xana=view&id=" + $('#username').val() + "&passwd=" + $('#password').val();


                    $("#ml-results").html('<object width="100%" height="700px" data="' + url + '"><h2 class="text-center"><small>Could not load report. Check that the report server is correctly configured and running</small></h2></object>');
                }
            }
        });
    });

</script>
