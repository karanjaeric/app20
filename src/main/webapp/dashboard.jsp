<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
	<h3 class="text-center main-title">
		<i
							class="glyphicon glyphicon-dashboard"></i>&nbsp;DASHBOARD PANEL
	</h3>
	<div class="col-md-12">
		<div class="col-md-6 border-right">
		<h3 class="text-center"><small>SCHEME MEMBERSHIP</small></h3>
		<table class="table table-responsive table-striped">
			<tr><td>ACTIVE MEMBERS</td><td id="active_members">--</td></tr>
			<tr><td>DEFFERRED MEMBERS</td><td id="deferred_members">--</td></tr>
			<tr><td>PENSIONERS</td><td id="pensioner_members">--</td></tr>
			<tr><td>EXITS IN CURRENT YEAR</td><td id="exits_in_year">--</td></tr>
			<tr><td>NEW MEMBERS</td><td id="new_members">--</td></tr>
		</table>
		</div>
		<div class="col-md-6">
					<h3 class="text-center"><small>CURRENT FUND VALUE</small></h3>
						<div align="center">
							<h1 class="numberCircle" id="fund-value">--</h1>
						</div>	
		</div>
	</div>
	<input type="hidden" name="profile" id="profile" value="${ profile }" />
	<div class="col-md-12 border-top">
			<div class="col-md-${ profile == 'AGENT' ? '10' : '12' }">
				<h3 class="text-center"><small>SUMMARY OF CONTRIBUTION/YEAR</small></h3>
				<div id="column-chart">
				</div>
			</div>
			<c:if test="${ profile == 'AGENT' }">
				<div class="col-md-2">
					MY COMMISSIONS
					<h3 class="numberCircle" id="commissions">--</h3>
				</div>
			</c:if>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {

			function initialize()
			{
				start_wait();
				var currency = null;
				/* Load Fund Value */
				$.ajax({
			        url: $('#base_url').val() + 'admin',
			        type: 'post',
			        data: {ACTION:'CURR'},
			        dataType: 'json',
			        success: function(json) {
						if(json.success)
						{
							currency = json.currency[0]['code'];
							$.ajax({
						        url: $('#base_url').val() + 'admin',
						        type: 'post',
						        data: {ACTION:'AP'},
						        dataType: 'json',
						        success: function(json) {
						            if(json.success)
					   	            {
						            	$.ajax({
									        url: $('#base_url').val() + 'admin',
									        type: 'post',
									        data: {ACTION:'FV', schemeID: $('#schemeID').val(), accountingPeriodId: json.accountingPeriodId},
									        dataType: 'json',
									        success: function(json) {
									            if(json.success)
								   	            {
									            	$('#fund-value').html(currency + ' ' + format_no(json.fundValue));
									            	$.ajax({
												        url: $('#base_url').val() + 'admin',
												        type: 'post',
												        data: {ACTION:'ML'},
												        dataType: 'json',
												        success: function(json) {
															if(json.success)
															{
																$.ajax({
															        url: $('#base_url').val() + 'admin',
															        type: 'post',
															        data: {ACTION:'SC'},
															        dataType: 'json',
															        success: function(json) {
																		if(json.success)
																		{
																			bar_graph(json);
																		}
															            else
														    	        {
														    	            stop_wait();
														    	            bootbox.alert('<p class="text-center">' + json.message + '</p>');
														        	    }
																		$.ajax({
																	        url: $('#base_url').val() + 'admin',
																	        type: 'post',
																	        data: {ACTION:'EXITS'},
																	        dataType: 'json',
																	        success: function(json) {
																				if(json.success)
																				{
																					$.each(json, function(key, value) {
																			        	if(key == 'rows')
																			           	{
																				           	var exits = 0;
																			        		for ( var i = 0; i < json.rows.length; i++) {
																				        		
																			            		exits += 1;
																			            		
																			        		}
																							$('#exits_in_year').html(exits);
																			           	}
																					});
																				}
																				$.ajax({
																			        url: $('#base_url').val() + 'admin',
																			        type: 'post',
																			        data: {ACTION:'NEW'},
																			        dataType: 'json',
																			        success: function(json) {
																						if(json.success)
																						{
																							$.each(json, function(key, value) {
																					        	if(key == 'rows')
																					           	{
																						           	var new_members = 0;
																					        		for ( var i = 0; i < json.rows.length; i++) {
																						        		
																					        			new_members += 1;
																					            		
																					        		}
																									$('#new_members').html(new_members);
																									stop_wait();
																					           	}
																							});
																						}
																			        }
																				});
																				if($('#profile').val() == 'AGENT')
																				{
																					$.ajax({
																				        url: $('#base_url').val() + 'admin',
																				        type: 'post',
																				        data: {ACTION:'AGENT_COMMISSION'},
																				        dataType: 'json',
																				        success: function(json) {
																							if(json.success)
																							{
																								$('#commissions').html(json.commissiontotal);
																							}
																				        }
																					});
																				}
																	        }
																	        
																		});
															        }
												            	});
											            	
												            	member_panel(json);
															}
												        }
									            	});
								   	            }
									            else
								    	        {
								    	            stop_wait();
								    	            bootbox.alert('<p class="text-center">' + json.message + '</p>');
								        	    }
									        }
									    });
					   	            }
						            else
					    	        {
					    	            stop_wait();
					    	            bootbox.alert('<p class="text-center">' + json.message + '</p>');
					        	    }
						        }
						    });
						}
			            else
		    	        {
		    	            stop_wait();
		    	            bootbox.alert('<p class="text-center">' + json.message + '</p>');
		        	    }
			        }
				});

				function member_panel(json)
				{
					$.each(json, function(key, value) {
			        	if(key == 'stats')
			           	{
								$('#active_members').html(format_no(value['active']));
								$('#deferred_members').html(format_no(value['defered']));
								$('#pensioner_members').html(format_no(value['pensioners']));
			           	}
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
				        			if(series.years.length > 0)
				        			{
					        			var year_ = series.years.pop();
					        			if(year['name'] == row['year'])
						        		{
							        		year_['y'] = parseFloat(year_['y']) + parseFloat(row['total']);
					        				series.years.push(year_);
						        			continue;
							        	}
					        			else
					        			{
						        			series.years.push(year_);
					        				var year = {};
					            			if(key == 'year')
						            		{
					            				year['name'] = "" + row['year'] + "";
					            				year['y'] = row['total'];
					            				year['drilldown'] = "" + row['year'] + "";
					            				series.years.push(year); 				
					            				break;
						            		}					        			
					        			}
				        			}
				        			else
									{
				        				var year = {};
				            			if(key == 'year')
					            		{
				            				year['name'] = "" + row['year'] + "";
				            				year['y'] = row['total'];
				            				year['drilldown'] = "" + row['year'] + "";
				            				series.years.push(year); 				
				            				break;
					            		}
									}
			        			}
			        		}
			           	}
			    	});
			        var series2 = {
			                months: []
			        };

			        for(var j = 0; j < series.years.length; j ++)
			        {
            			var month = {};
            			var found = false;
        				month['name'] = "" + series.years[j]['name'] + "";
        				month['id'] = "" + series.years[j]['name'] + "";
						var data = [];
			        	 $.each(json, function(key, value) {
					        	for ( var i = 0; i < json.rows.length; i++) {
				            		var row = json.rows[i];
				            		if(row['year'] == series.years[j]['name'])
					            	{
						            	found = true;
						            	var duplicate = false;
						            	for(var k = 0; k < data.length; k ++)
						            	{
							            	if(row['month'] == data[k][0])
								            	duplicate = true;
						            	}
						            	if(!duplicate)
						            	{
						            		var monthData = [row['month'], parseFloat(row['total'])];
							            	data.push(monthData);
						            	}
						            }
					        	}
					    	});
						if(found)
						{
							var monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun",
							                  "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
							                ];
			                for(var k = 0; k < monthNames.length; k ++)
				            {
					            for(var i = k; i < data.length; i ++)
						        {
							       ;
							    }
					        }
							month['data'] = data;
							series2.months.push(month);
						}
			        }
			       
			    	
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
			                    text: 'Scheme Contribution'
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
			    }
			    
			}

			initialize();
			
		});
	</script>
</div>