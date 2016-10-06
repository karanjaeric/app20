<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 10/5/16
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section content-area">
    <h3 class="text-center main-title">
        <i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;WITHDRAWAL STATEMENTS
    </h3>
    <form class="form-inline" role="form" id="ws-form">

       <div class="col-md-4">
            <label for="year" class="control-label">Year: </label>
            <input type="text" name="year" class="form-control  input-sm" id="year" placeholder="Year">
        </div>
        

        <div class="col-md-3" id="divquarter">
            <select id="quarter" name="quarter" class="form-control">
                <option value="" selected disabled>--Select Quarter--</option>
                <option value="1"> Quarter 1 </option>
                <option value="2"> Quarter 2 </option>
                <option value="3"> Quarter 3 </option>
                <option value="4"> Quarter 4 </option>
            </select>
        </div>
        <div class="col-md-2">
            <button class="btn btn-primary">
                SHOW REPORT
            </button>
        </div>
    </form>
    <input type="hidden" id="reportPath" value="${ settings.xiReportPath }" />
    <input type="hidden" id="xiRootPath" value="${ settings.xiPath }" />
    <input type="hidden" id="username" value="${ settings.xiReportUsername }" />
    <input type="hidden" id="password" value="${ settings.xiReportPassword }" />
    <input type="hidden" id="scheme_id" value="${ scheme_id }"/>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <div class="col-md-12" id="ws-results">

    </div>
</div>
<script type="text/javascript">

    $(document).ready(function(){

        $('#ws-form').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                year : {
                    validators : {
                        notEmpty : {
                            message : 'Please enter year'
                        }
                    }
                },
            }
        }).on('success.form.bv', function(e) {
            start_wait();

            var str = $('#xiRootPath').val();
            var res = str.replace("/api/", "");
            console.log(res);

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

            var quarter = ($('#quarter').val());
            console.log('The quarter is >>>>>>>>> ' + quarter);
            var year = ($('#year').val());
            console.log('The year is >>>>>>>>>> ' + year);

            var url =
                    $('#reportPath').val() +"members/withdrawals.xdo?_xpf=&_xpt=0&_xdo=%2F~weblogic%2Ffundmaster%2Freports%2Fmembers%2Fwithdrawals.xdo&_xmode=3&_paramsblankImage="  + alternativeUrl + "&_paramsalternativeUrl="  + alternativeUrl + "&_paramsorientation=" + orientation + "&_paramsBASE=http%3A%2F%2Flocalhost%3A8080%2FXi&_paramsscheme_id="
                    + $('#scheme_id').val() + "&_paramsquarter=" + quarter + "&_paramsyear=" + year + "&_xt=withdrawals&_xf=analyze&_xana=view&id=" + $('#username').val() + "&passwd=" + $('#password').val();

            $("#ws-results").html('<object width="100%" height="700px" data="' + url + '"><h2 class="text-center"><small>Could not load report. Check that the report server is correctly configured and running</small></h2></object>');



            stop_wait();
        });
    });


</script>
