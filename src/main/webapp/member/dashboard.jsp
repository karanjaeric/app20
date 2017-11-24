<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-fluid section">
	<h3 class="text-center main-title">
		<i
							class="glyphicon glyphicon-dashboard"></i>&nbsp;DASHBOARD PANEL
	</h3>
	<div class="col-md-6">
	<h3 class="text-center"><small>MEMBER DETAILS</small></h3>
				<table class="table table-responsive table-condensed">

				<c:if test="${memberDashboard.name == 'TRUE'}">
					<tr><td>NAME</td><td>${member.name }</td></tr>
				</c:if>
				<c:if test="${memberDashboard.dateOfBirth == 'TRUE'}">
					<tr><td>DATE OF BIRTH</td><td>${member.dateOfBirth }</td></tr>
				</c:if>
				<c:if test="${memberDashboard.dateOfJoiningScheme == 'TRUE'}">
					<tr><td>DATE OF JOINING SCHEME</td><td>${member.dateJoinedScheme }</td></tr>
				</c:if>
				<c:if test="${memberDashboard.gender == 'TRUE'}">
					<tr><td>GENDER</td><td>${member.gender }</td></tr>
				</c:if>
				<c:if test="${memberDashboard.idNumber == 'TRUE'}">
					<tr><td>ID/PPT NUMBER</td><td>${member.idNumber }</td></tr>
				</c:if>
				<c:if test="${memberDashboard.phoneNumber == 'TRUE'}">
					<tr><td>PHONE NUMBER</td><td>${member.phoneNumber }</td></tr>
				</c:if>
				<c:if test="${memberDashboard.emailAddress == 'TRUE'}">
					<tr><td>EMAIL ADDRESS</td><td>${member.emailAddress }</td></tr>
				</c:if>
				<c:if test="${memberDashboard.memberNo == 'TRUE'}">
					<tr><td>MEMBER NUMBER</td><td>${member.memberNo }</td></tr>
				</c:if>
				<c:if test="${memberDashboard.pinNumber == 'TRUE'}">
					<tr><td>TAX NUMBER</td><td>${member.pinNo }</td></tr>
				</c:if>
				<c:if test="${memberDashboard.memberId == 'TRUE'}">
					<tr><td>MEMBER ID</td><td>${member.memberNo }</td></tr>
				</c:if>
				<c:if test="${memberDashboard.ssnitNumber == 'TRUE'}">
					<tr><td>SSNIT NUMBER</td><td>${member.nationalPenNo }</td></tr>
				</c:if>
					<!--<tr><td>ANNUAL PEN. SALARY</td><td>${member.annualPensionableSalary }</td></tr>-->
				<c:if test="${memberDashboard.town == 'TRUE'}">
					<tr><td>CITY/TOWN</td><td>${member.town }</td></tr>
				</c:if>

					<c:if test="${sponsor_id!=null}">
						<tr><td>COMPANY</td><td>${companyName }</td></tr>
					</c:if>


				</table>
	</div>
	<div class="col-md-6 border-left">
	<h3 class="text-center"><small>DISTRIBUTION TO BENEFICIARIES</small></h3>
		<div id="pie-chart">
			
		</div>
	</div>

	<div class="col-md-12 border-top">

		<%--<c:forEach var="planType" items="${ planType }">--%>
			<%--<c:choose>--%>
				<%--<c:when test="${planType == 'Defined Benefit' }">--%>
				<%--<h3 class="text-center"><small>ACCUMMULATED ANNUAL PENSION TO DATE:</small> <span id="accummulated-benefits"></span> &nbsp;--%>
				<%--</c:when>--%>
				<%--<c:otherwise>--%>
				<%--<h3 class="text-center"><small>ACCUMMULATED BENEFITS TO DATE:</small> <span id="accummulated-benefits"></span> &nbsp;--%>
				<%--</c:otherwise>--%>
			<%--</c:choose>--%>
		<%--</c:forEach>--%>

		<c:choose>
			<c:when test="${planType == 'Defined Benefit' && contrGraph.interestActive == 'TRUE'}">
				<p>&nbsp;</p>
			</c:when>
			<c:otherwise>
					<br>
				<small>CUMMULATIVE INTEREST TO DATE:</small> <span id="cummulative-interests"></span></h3>
				<p>&nbsp;</p>
			</c:otherwise>
		</c:choose>
	</div>

	<c:choose>
		<c:when test="${planType == 'Defined Benefit' && contrGraph.contributionGraphActive == 'TRUE'}">
			
		</c:when>
		<c:otherwise>
			<div class="col-md-12 border-top">
				<h2 class="text-center">SUMMARY OF CONTRIBUTION/YEAR</h2>
				<div id="column-chart">

				</div>
			</div>
		</c:otherwise>
	</c:choose>

	<!-- <div class="col-md-4 border-top">
		<h2 class="text-center">BENEFIT SUMMARY</h2>
					<h3 class="text-center"><small>ACCUMMULATED BENEFITS</small></h3>
						<div align="center">
							<h1 class="numberCircle" id="accummulated-benefit">--</h1>
						</div>	
	<h3 class="text-center"><small>INTEREST SUMMARY</small></h3>
		<table class="table table-responsive">
			<tr><td>CUMMULATIVE INTEREST</td><td id="cummulative-interest"></td></tr>
			<tr><td>AVERAGE INTEREST RATE</td><td id="average-interest"></td></tr>
		</table>
	</div>-->
</div>

<script type="text/javascript">
$(document).ready(function () {

	function start_wait()
	{
		$('#wait-dialog').modal({
			  backdrop: 'static',
			  keyboard: false
			});
	}
	function stop_wait()
	{
		$('#wait-dialog').modal('hide');
	}
	function initialize()
	{
		start_wait();

		var currency = null;
		/* Load Currency */
		$.ajax({
	        url: $('#base_url').val() + 'member',
	        type: 'post',
	        data: {ACTION:'CURR'},
	        dataType: 'json',
	        success: function(json) {
				if(json.success)
				{

					json = $.parseJSON(json.data);
					currency = hasKey(json, "code") ? json.code : "KES";

					/* Load Member Closing Balance */
					$.ajax({
				        url: $('#base_url').val() + 'member',
				        type: 'post',
				        data: {ACTION:'AB'},
				        dataType: 'json',
				        success: function(json) {
				            if(json.success)
			   	            {
								console.log(json);
								json = $.parseJSON(json.data);

								console.log("AB" +json.cummulativebenefit);
				            	$('#accummulated-benefits').html(currency + " " + format_no(json.cummulativebenefit));

			   	            }
				            else
			    	        {
			    	            stop_wait();
			    	            bootbox.alert('<p class="text-center">' + json.message + '</p>');
			        	    }

				    		/* Load Contribution History */
				    		$.ajax({
				    	        url: $('#base_url').val() + 'member',
				    	        type: 'post',
				    	        data: {ACTION:'CH'},
				    	        dataType: 'json',
				    	        success: function(json) {
				    	            if(json.success)
				       	            {

										json = $.parseJSON(json.data);
				    	            	bar_graph(json);
				       	            }
				    	            else
				        	        {
				        	            stop_wait();
				        	            bootbox.alert('<p class="text-center">' + json.message + '</p>');
				            	    }

				    	    		/* Load Beneficiary Distribution Data */
				    	    		$.ajax({
				    	    	        url: $('#base_url').val() + 'member',
				    	    	        type: 'post',
				    	    	        data: {ACTION:'BD'},
				    	    	        dataType: 'json',
				    	    	        success: function(json) {
				    	    	            if(json.success)
				    	       	            {

												json = $.parseJSON(json.data);
				    	    	            	pie_chart(json);
				    	       	            }
				    	    	            else
				    	        	        {
				    	        	            stop_wait();
				    	        	            bootbox.alert('<p class="text-center">' + json.message + '</p>');
				    	            	    }

				    	    	    		/* Load Cummulative Interest */
				    	    	    		$.ajax({
				    	    	    	        url: $('#base_url').val() + 'member',
				    	    	    	        type: 'post',
				    	    	    	        data: {ACTION:'CI'},
				    	    	    	        dataType: 'json',
				    	    	    	        success: function(json) {
				    	    	    	            if(json.success)
				    	    	       	            {

														json = $.parseJSON(json.data);
                                                         console.log("CI "+ json.cummulativeInterest);

                                                        $('#cummulative-interests').html(currency + ' ' + format_no(json.cummulativeInterest));

				    	    	    	            	//$('#cummulative-interests').html(currency + ' ' + format_no(json.cummulativeInterest));
 				    	    	       	            }
				    	    	    	            else
				    	    	        	        {
				    	    	        	            stop_wait();
				    	    	        	            bootbox.alert('<p class="text-center">' + json.message + '</p>');
				    	    	            	    }
				    	    	            	    /* Load Average Interest */
				    	    	    	    		$.ajax({
				    	    	    	    	        url: $('#base_url').val() + 'member',
				    	    	    	    	        type: 'post',
				    	    	    	    	        data: {ACTION:'AI'},
				    	    	    	    	        dataType: 'json',
				    	    	    	    	        success: function(json) {
				    	    	    	    	            if(json.success)
				    	    	    	       	            {

																json = $.parseJSON(json.data);
				    	    	    	    	            	$('#average-interests').html(format_no(json.averageInterest));
				    	    	    	       	            }
				    	    	    	    	            else
				    	    	    	        	        {
				    	    	    	        	            stop_wait();
				    	    	    	        	            bootbox.alert('<p class="text-center">' + json.message + '</p>');
				    	    	    	            	    }
				    	    	    	    	        }
				    	    	    	    	    });
				    	    	    	        }
				    	    	    	    });
				    	    	        }
				    	    	    });
				    	        }
				    	    });
				        }
				    });
				}
	        }
		});
		
		
	}
	initialize();
    // Build the chart

    
    function pie_chart(json)
    {
    	 var slices = {
    	    		distributions:[]
    	    		};
			var total = 0;
         	$.each(json, function(key, value) {
         		if(key == 'rows')
               	{
            		for ( var i = 0; i < json.rows.length; i++) {
                		var row = json.rows[i];
           				var beneficiary = {};
           				beneficiary["name"] = row["name"];
           				beneficiary["y"] = row['amount'] == '' ? 0 : parseFloat(row["amount"]);
           				total += beneficiary['y'];
           				slices.distributions.push(beneficiary);
            		}
               	}
    		});

			var beneficiary = {};
			beneficiary["name"] = "Un-Allocated";
			beneficiary["y"] = 100 - total;
			if(beneficiary['y'] < 0)
				beneficiary['y'] = 0;
			slices.distributions.push(beneficiary);

    	$('#pie-chart').highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false,
                type: 'pie'
            },
            title: {
                text: ''
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.percentage:,.1f}</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: false
                    },
                    showInLegend: true
                }
            },
            series: [{
                name: "Distribution",
                colorByPoint: true,
                data: slices.distributions
            }]
        });
    }

    function bar_graph(json)
    {
		/*(function (Highcharts) {
			var tooltipFormatter = Highcharts.Point.prototype.tooltipFormatter;

			Highcharts.Point.prototype.tooltipFormatter = function (pointFormat) {
				var keys = this.options && Object.keys(this.options),
						pointArrayMap = this.series.pointArrayMap,
						tooltip;

				if (keys.length) {
					this.series.pointArrayMap = keys;
				}

				tooltip = tooltipFormatter.call(this, pointFormat);
				this.series.pointArrayMap = pointArrayMap || ['y'];

				return tooltip;
			}
		}(Highcharts));*/

        var series = {
                years: []
        };

        $.each(json, function(key, value) {
        	if(key == 'rows')
           	{
        		for ( var i = 0; i < json.rows.length; i++) {
            		var row = json.rows[i];
            		for(var key in row)
        			{
            			var year = {};
            			if(key == 'year')
	            		{
            				year['name'] = row['year'];
            				year['y'] = row['total'];
            				year['drilldown'] = row['year'];
            				series.years.push(year);
            				break;
	            		}
        			}
        		}
           	}
    	});

        var series2 = {
                months: []
        };

        $.each(json, function(key, value) {
        	if(key == 'rows')
           	{
        		for ( var i = 0; i < json.rows.length; i++) {
            		var row = json.rows[i];
            		for(var key in row)
        			{
            			var month = {};
            			if(key == 'year')
	            		{
            				month['name'] = row['year'];
            				month['id'] = row['year'];

							var data = [];
							$.each(value, function(key1, value1){
								if(typeof value1['year'] === 'undefined')
								{
										$.each(value1, function(key2, value2){

											if(value2['year'] == row['year'])
											{
												if(data.length > 0)
												{
													if(typeof value2['month'] !== 'undefined')
													{
														var last = data.pop();

														if(last[0] == value2['month'])
														{
															last[1] += parseFloat(value2['total']);
															data.push(last);
														}
														else
														{
															data.push(last);
															var monthData = [value2['month'], parseFloat(value2['total'])];
															data.push(monthData);
														}
													}
												}
												else
												{
													var monthData = [value2['month'], parseFloat(value2['total'])];
													data.push(monthData);
												}
											}

										});

								}

							});

			            	month['data'] = data;

            				series2.months.push(month);
            				break;
	            		}
        			}
        		}
           	}
    	});


    	$('#column-chart').highcharts({
            chart: {
                type: 'column'
            },
            title: {
                text: ''
            },
            xAxis: {
                type: 'category'
            },
            yAxis: {
                title: {
                    text: 'Your Contribution'
                }

            },
            legend: {
                enabled: false
            },
            plotOptions: {
                series: {
                    borderWidth: 0,
                    dataLabels: {
                        enabled: false,
                        format: '{point.y:,.1f}'
                    }
                }
            },

            tooltip: {
                headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
                pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:,.2f}</b><br/>'
            },

            series: [{
                name: "Yearly Contributions",
                colorByPoint: true,
                data: series.years
            }],
            drilldown: {
                series: series2.months
            }
        });
        stop_wait();
    }
});
</script>