<%--
  Created by IntelliJ IDEA.
  User: lifeofpablo
  Date: 9/20/17
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <jsp:include page="includes/partial/header.jsp" />
<div class="container">
    <div class="main-content">
<div class="modal-dialog large-modal">
    <div class="modal-content">
        <div class="modal-body">
            <form role="form" id="form-unit-price" method="POST">
                <h1 class="heading">${ menu.unitPriceName }</h1>
                <fieldset>
                    <legend>Select a Scheme</legend>
                    <div class="form-group col-md-8">
                        <select class="form-control" name="scheme" id="scheme">
                            <option value="">Scheme....</option>
                            <c:forEach var="scheme" items="${schemes}">
                                <option value="${scheme.id}">
                                        ${scheme.name}
                                </option>
                            </c:forEach>
                        </select>
                    </div>


                    <div class="col-md-4">
                        <button class="btn btn-primary">SHOW UNIT PRICES</button>
                    </div>
                </fieldset>
            </form>

            <fieldset class="pad-top">
                <legend id="result-title">Unit Price History</legend>

                </table> <table class="table table-responsive table-striped table-bordered" id="unit-price-result">
            </table>

            </fieldset>
            <table id="datatable" class="hide">
            </table>
            <div class="row  pad-top" id="bar-chart">


        </div>
        </div>
    </div>
</div>


</div>
</div><script src="static/custom/vendors/jquery-1.9.1.min.js"></script>

<script type="text/javascript">

    $(document).ready(function(){

        function drawInterestRatesGraph() {
            $('#bar-chart').highcharts(
                {
                    data : {
                        table : 'datatable'
                    },
                    chart : {
                        type : 'column'
                    },
                    title : {
                        text : 'Unit Prices History'
                    },
                    yAxis : {
                        allowDecimals : false,
                        title : {
                            text : '% Unit'
                        }
                    },
                    tooltip : {
                        formatter : function() {
                            return '<b>'
                                + this.series.name
                                + '</b><br/>'
                                + this.point.y
                                + ' '
                                + this.point.name
                                    .toLowerCase();
                        }
                    }
                });
        }


        function initializeScheme()
        {
            $('#form-unit-price')
                .bootstrapValidator(
                    {
                        message : 'This value is not valid',
                        feedbackIcons : {
                            valid : 'glyphicon glyphicon-ok',
                            invalid : 'glyphicon glyphicon-remove',
                            validating : 'glyphicon glyphicon-refresh'
                        },
                        excluded: ':disabled',
                        fields : {
                            scheme : {
                                validators : {
                                    notEmpty : {
                                        message : 'Please select the scheme'
                                    }
                                }
                            }
                        }
                    }).on(
                'success.form.bv',
                function(e) {
                    start_wait();
                    // Prevent form submission
                    e.preventDefault();
                    // Get the form instance
                    $.ajax({
                        url : $('#base_url').val() + 'unit-prices',
                        type : 'post',
                        data: {ACTION:'UNIT_PRICES_BY_SCHEME', scheme : $('#scheme').val()},
                        dataType : 'json',
                        success : function(json) {
                            console.log(json);
                            html = "<tr><th>PRICE DATE</th> <th>CHANGE</th>\n" +
                                "                        <th>ANNUAL CHANGE</th><th>PRICE</th><th>ACCOUNTING PERIOD </th>\n" +
                                "                        <th>PERCENTAGE CHANGE </th></tr>";
                            stop_wait();
                            var message = 'Oops! We are sorry, but something unexpected just happend and we were unable to process your request. Please try again';
                            if (json.success == true) {
                                json = $.parseJSON(json.data);
                                $.each(json, function(key, value) {
                                    if(key == 'rows')
                                    {


                                        for ( var i = 0; i < json.rows.length; i++) {
                                             var row = json.rows[i];
                                            var accPeriod = row['accountingPeriod'] ;
                                            console.log(json[accPeriod]);
                                            var percentageChange = row['percentageChange'];
                                            console.log (json[percentageChange])


                                            html = html + "<tr><td>" + row['priceDate'] + "</td><td>" +row['change'] + "</td><td>" + row['annualChange'] +
                                        "</td><td>" + row['price'] + "</td><td>" +  accPeriod + "</td> <td>" + percentageChange +
                                        "</td></tr>";
                                             stop_wait();



                            }


                                }
                                });

                                $('#unit-price-result').html(html);
                                stop_wait();

                                html = html
                                    + "</tbody>";
                                $('#datatable')
                                    .html(html);
                                drawInterestRatesGraph();
                            }

                        }
                    });
                });

        }

        $('#scheme').on('change',function(){

            var schemeSelected = $('#scheme').val();
            console.log("Scheme selected:  " + schemeSelected);

            $.ajax({
                url: $('#base_url').val() + 'admin',
                type: 'post',
                data: {ACTION:'SCHEME_MODE', scheme:schemeSelected},
                dataType: 'json',
                success: function(json) {
                    if(json.success)
                    {
                        json = $.parseJSON(json.data);
                        console.log(json);
                        initializeScheme()

                    }
                    else
                    {
                        stop_wait();
                        bootbox.alert('<p class="text-center">' + json.message + '</p>');
                    }
                }
            });

        });

    });

</script>
<jsp:include page="includes/partial/footer.jsp" />

