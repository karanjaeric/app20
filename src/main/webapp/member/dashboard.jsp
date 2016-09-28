<div class="container-fluid section">
	<h3 class="text-center main-title">
		<i
							class="glyphicon glyphicon-dashboard"></i>&nbsp;DASHBOARD PANEL
	</h3>
	<div class="col-md-6">
	<h3 class="text-center"><small>MEMBER DETAILS</small></h3>
				<table class="table table-responsive table-striped">
					<tr><td>NAME</td><td>${member.name }</td></tr>
					<tr><td>DATE OF BIRTH</td><td>${member.dateOfBirth }</td></tr>
					<tr><td>DATE OF JOINING SCHEME</td><td>${member.dateJoinedScheme }</td></tr>
					<tr><td>GENDER</td><td>${member.gender }</td></tr>
					<tr><td>ID/PPT NUMBER</td><td>${member.idNumber }</td></tr>
					<tr><td>PHONE NUMBER</td><td>${member.phoneNumber }</td></tr>
					<tr><td>EMAIL ADDRESS</td><td>${member.emailAddress }</td></tr>
					<tr><td>MEMBER NUMBER</td><td>${member.memberNo }</td></tr>
					<tr><td>TAX NUMBER</td><td>${member.pinNo }</td></tr>
					<!--<tr><td>ANNUAL PEN. SALARY</td><td>${member.annualPensionableSalary }</td></tr>-->
					<tr><td>CITY/TOWN</td><td>${member.town }</td></tr>
				</table>
	</div>
	<div class="col-md-6 border-left">
	<h3 class="text-center"><small>DISTRIBUTION TO BENEFICIARIES</small></h3>
		<div id="pie-chart">
			
		</div>
	</div>
	<div class="col-md-12 border-top">
		<h3 class="text-center"><small>ACCUMMULATED BENEFITS TO DATE:</small> <span id="accummulated-benefits"></span> &nbsp; <small>CUMMULATIVE INTEREST TO DATE:</small> <span id="cummulative-interests"></span> <!--&nbsp; <small>AVERAGE INTEREST RATE:</small> <span id="average-interests"></span>--></h3>
		<p>&nbsp;</p>
	</div>
	<div class="col-md-12 border-top">
	<h2 class="text-center">SUMMARY OF CONTRIBUTION/YEAR</h2>
		<div id="column-chart">
			
		</div>
	</div>
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
				        data: {ACTION:'CB'},
				        dataType: 'json',
				        success: function(json) {
				            if(json.success)
			   	            {
								console.log(json);
								json = $.parseJSON(json.data);
				            	$('#accummulated-benefits').html(currency + " " + format_no(json.total));
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
				    	    	    	            	$('#cummulative-interests').html(currency + ' ' + format_no(json.cummulativeInterest));
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
                pointFormat: '{series.name}: <b>{point.percentage:.1f}</b>'
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
                        format: '{point.y:.1f}'
                    }
                }
            },

            tooltip: {
                headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
                pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}</b><br/>'
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