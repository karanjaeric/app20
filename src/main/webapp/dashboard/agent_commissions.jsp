<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 9/16/16
  Time: 4:19 PM
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
    <div class="col-md-4">
        <h3>
            <i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;COMMISSIONS
        </h3>
    </div>
    <table class="table table-responsive table-striped" id="search-results">
        <tr><th>MONTH</th><th>YEAR</th><th>CONTRIBUTION</th><th>COMMISSION</th><th>NET</th></tr>
        <c:forEach var="commission" items="${ commissions }">
            <tr><td>${commission.month }</td><td>${ commission.year }</td><td>${ commission.contr }</td>
                <td>${ commission.commission }</td><td>${ commission.net }</td></tr>
        </c:forEach>
    </table>
    <ul class="pagination pull-right">
        <c:if test="${ batch > 1 }">
            <li><a href="javascript:void(0);" onclick="load_dashboard(${ page > per_page ? page - per_page : page }, ${ batch - 1 })">&laquo;</a></li>
        </c:if>
        <c:forEach begin="${ begin }" end="${ pages > (begin + (per_page - 1)) ? (begin + (per_page - 1)) : pages }" varStatus="loop">
            <c:choose>
                <c:when test="${ page == loop.index }">
                    <li class="active"><a href="javascript:void(0);">${ loop.index }</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="javascript:void(0);" onclick="load_dashboard(${ loop.index }, ${ batch })">${ loop.index }</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${ pages > begin + (per_page - 1)}">
            <li><a href="javascript:void(0);" onclick="load_dashboard(${ pages < page + per_page ? pages : page + per_page }, ${ batch + 1 })">&raquo;</a></li>
        </c:if>
    </ul>
</div>
<!--<script type="text/javascript">
    $(document).ready(function(){
        $('#form-search').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {

            }
        })
                .on('success.form.bv', function(e) {

                    if($('#search').val() != '')
                    {
                        // Prevent form submission
                        e.preventDefault();
                        start_wait();
                        var btn = "btn-search";
                        var btn_text = $('#' + btn).val();
                        $.ajax({
                            url: $('#base_url').val() + 'admin',
                            type: 'post',
                            data: {ACTION: 'SEARCH_SCHEMES', search: $('#search').val()},
                            dataType: 'json',
                            success: function(json) {
                                html = "<tr><th>CODE</th><th>NAME</th><th>PLAN TYPE</th><th>SCHEME PIN</th><th>SECTOR</th></tr>";
                                if(json.success)
                                {
                                    $.each(json, function(key, value) {
                                        if(key == 'rows')
                                        {
                                            for ( var i = 0; i < json.rows.length; i++) {
                                                var row = json.rows[i];
                                                html = html + "<tr><td>" + row['schemeNumber'] + "</td><td><td>" + row['schemeName'] + "</td>" + row['planType'] + "</td><td>" + row['schemePin'] + "</td><td>" + row['sector'] + "</td></tr>";
                                            }
                                            stop_wait();
                                        }
                                    });
                                }
                                $('#search-results').fadeOut('slow', function(){
                                    $('#search-results').html(html);
                                    $('#search-results').fadeIn('slow');
                                });
                                $('#' + btn).val(btn_text);
                            }
                        });
                    }

                });
    });
</script>-->
