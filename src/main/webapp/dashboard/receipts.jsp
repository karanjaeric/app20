<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
	<div class="col-md-5">
		<h3>
			<i class="glyphicon glyphicon-gift"></i>&nbsp;&nbsp;RECEIPTS
		</h3>
	</div>
	<div class="col-md-7" align="right">
		<br />
		<form class="form-inline" id="form-search">
			<input type="text" class="form-control datepicker" placeholder="Date From" readonly="readonly" name="dateFrom" id="dateFrom"  value="${ dateFrom }"/>
			<input type="text" class="form-control datepicker" placeholder="Date To" readonly="readonly" name="dateTo" id="dateTo"  value="${ dateTo}" />
			<button class="btn btn-info" id="btn-search">Search</button>
		</form>
	</div>
	<table class="table table-responsive table-striped"  id="search-results">
		<tr><th>DATE</th><th>RECEIPT</th><th>PAYEE</th><th>TRANSACTION CATEGORY</th><th>TRANSACTION TYPE</th><th>MODE</th><th>REFERENCE NO</th><th class="right">AMOUNT</th></tr>
		<c:forEach var="receipt" items="${receipts}">
			<tr><td>${ receipt.date }</td><td>${ receipt.receipt_no }</td><td>${ receipt.payee }</td><td>${ receipt.category }</td><td>${ receipt.type }</td><td>${ receipt.mode }</td><td>${receipt.ref }</td><td class="right">${ receipt.amount }</td></tr>
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
<script type="text/javascript">

    function load_dashboard(page, batch)
    {
        start_wait();
        $.ajax({
            url: $('#base_url').val() + 'admin',
            type: 'get',
            data: {dashboard: 'RECEIPT', page: page, batch: batch, from: $('#dateFrom').val(), to: $('#dateTo').val()},
            dataType: 'html',
            success: function(html) {
                $('#dashboard').fadeOut('slow', function() {
                    $('#dashboard').html(html);
                    $('#dashboard').fadeIn('slow');
                    stop_wait();
                });
            }
        });
    }
    $(document).ready(function(){
        $('.datepicker').datetimepicker({

            language:  'en',
            weekStart: 1,
            todayBtn:  1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0,
            format: 'dd-mm-yyyy'

        });
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

                if($('#dateFrom').val() != '' && $('#dateTo').val() != '')
                {
                    console.log("=========== we're here ==================");
                    console.log("Date from: " + $('#dateFrom').val());
                    // Prevent form submission
                    e.preventDefault();
                    start_wait();
                    var btn = "btn-search";
                    var btn_text = $('#' + btn).val();
                    $.ajax({
                        url: $('#base_url').val() + 'admin',
                        type: 'post',
                        data: {ACTION: 'RECEIPT', dateFrom: $('#dateFrom').val(), dateTo: $('#dateTo').val()},
                        dataType: 'json',
                        success: function(json) {
                            console.log(json);
							html = "<tr><th>DATE</th><th>RCPT #</th><th>PAYEE</th><th>TXN CATEGORY</th><th>TXN TYPE</th><th>MODE</th><th>REF.</th><th class=\"right\">AMOUNT</th></tr>";
                            if(json.success) {
                                json = $.parseJSON(json.data);
                                console.log(json);
                                $.each(json, function(key, value){
                                    if(key == 'rows') {
                                        var rows = json.rows;
                                        console.log(rows)
                                        console.log("Am here")
										for (var i = 0; i < rows.length; i++) {
                                            var row = rows[i];
                                            html = html + "<tr><td>" + row['datereceived'] + "</td><td>" + row['receiptno'] + "</td><td>" + row['payee'] + "</td><td>" + row['txncat'] + "</td><td>" + row['txntype'] + "</td><td>" + row['paymentmethod'] + "</td><td>" + row['id'] + "</td><td>" + format_no(row['amount']) + "</td></tr>";
                                        }
                                        stop_wait();

                                    }

                                });
                            }
                            $('#search-results').html(html);
                            $('#' + btn).val(btn_text);
                        }

                    });
                    stop_wait();
                }

            });
    });
</script>