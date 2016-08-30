<div class="container-fluid section">
	<h3 class="text-center main-title">
		<i class="glyphicon glyphicon-flash"></i>&nbsp;&nbsp;ANALYTICS &amp; REPORTING DASHBOARD
	</h3>
	<div class="col-md-12">
		<div class="col-md-6 text-center">
			<h2><small>ACCESS BY PAGE (FRONTEND)</small></h2>
			<div id="frontend">
				
			</div>
		</div>
		<div class="col-md-6 text-center">
			<h2><small>ACCESS BY PROFILE</small></h2>
			<div id="profile_access">
				
			</div>
		</div>
		<div class="col-md-6 text-center">
			<h2><small>MOST ACCESSED BY MEMBER</small></h2>
			<div id="most_accessed_by_members">
			
			</div>
		</div>
		<div class="col-md-6 text-center">
			<h2><small>MOST ACCESSED BY MANAGERS</small></h2>
			<div id="most_accessed_by_managers">
			
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
    $(document).ready(function () {

    	function initialize()
    	{
    		$.ajax({
    	        url: $('#base_url').val() + 'admin',
    	        type: 'post',
    	        data: {ACTION:'FRONTPAGE_ACCESS'},
    	        dataType: 'json',
    	        success: function(json) {
                    console.log(json.data);
                    json = $.parseJSON(json.data);
        	        if(json.success)
        	        {
        	        	var total = 0;
        	        	$.each(json, function(key, value) {
            	        	total += value;
        	        	});
        				front_page_access(json, total);
        	        }
    	        }
    		});
    		$.ajax({
    	        url: $('#base_url').val() + 'admin',
    	        type: 'post',
    	        data: {ACTION:'PROFILE_ACCESS'},
    	        dataType: 'json',
    	        success: function(json) {
                    console.log(json.data);
                    json = $.parseJSON(json.data);
        	        if(json.success)
        	        {
        	        	var total = 0;
        	        	$.each(json, function(key, value) {
            	        	total += value;
        	        	});
        				profile_access(json, total);
        	        }
    	        }
    		});
    		$.ajax({
    	        url: $('#base_url').val() + 'admin',
    	        type: 'post',
    	        data: {ACTION:'MOST_BY_MEMBER'},
    	        dataType: 'json',
    	        success: function(json) {
                    console.log(json.data);
                    json = $.parseJSON(json.data);
        	        if(json.success)
        	        {
        	        	var total = 0;
        	        	$.each(json, function(key, value) {
            	        	total += value;
        	        	});
        				most_accessed_by_members(json, total);
        	        }
    	        }
    		});
    		$.ajax({
    	        url: $('#base_url').val() + 'admin',
    	        type: 'post',
    	        data: {ACTION:'MOST_BY_MANAGER'},
    	        dataType: 'json',
    	        success: function(json) {
                    console.log(json.data);
                    json = $.parseJSON(json.data);
        	        if(json.success)
        	        {
        	        	var total = 0;
        	        	$.each(json, function(key, value) {
            	        	total += value;
        	        	});
        				most_accessed_by_managers(json, total);
        	        }
    	        }
    		});
    	}
        function front_page_access(json, total)
        {
            var series = {
							data: []
            };
        	$.each(json, function(key, value) {
            	if(key != 'success')
               	{
                   	var data = {};
                   	data["name"] = key;
                   	data["y"] = parseFloat(format_no((parseFloat(value) / total) * 100));
                   	console.log(data);
                   	series.data.push(data);
               	}
        	});
        	// Build the chart
            $('#frontend').highcharts({
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
                    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
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
                    name: "Page Access",
                    colorByPoint: true,
                    data: series.data
                }]
            });
        }
        function profile_access(json, total)
        {
            var series = {
							data: []
            };
        	$.each(json, function(key, value) {
            	if(key != 'success')
               	{
                   	var data = {};
                   	data["name"] = key;
                   	data["y"] = parseFloat(format_no((parseFloat(value) / total) * 100));
                   	console.log(data);
                   	series.data.push(data);
               	}
        	});
        	// Build the chart
            $('#profile_access').highcharts({
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
                    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
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
                    name: "Page Access",
                    colorByPoint: true,
                    data: series.data
                }]
            });
        } 
        function most_accessed_by_members(json, total)
        {
            var series = {
							data: []
            };
        	$.each(json, function(key, value) {
            	if(key != 'success')
               	{
                   	var data = {};
                   	data["name"] = key;
                   	data["y"] = parseFloat(format_no((parseFloat(value) / total) * 100));
                   	console.log(data);
                   	series.data.push(data);
               	}
        	});
        	// Build the chart
            $('#most_accessed_by_members').highcharts({
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
                    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
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
                    name: "Page Access",
                    colorByPoint: true,
                    data: series.data
                }]
            });
        }
        function most_accessed_by_managers(json, total)
        {
            var series = {
							data: []
            };
        	$.each(json, function(key, value) {
            	if(key != 'success')
               	{
                   	var data = {};
                   	data["name"] = key;
                   	data["y"] = parseFloat(format_no((parseFloat(value) / total) * 100));
                   	console.log(data);
                   	series.data.push(data);
               	}
        	});
        	// Build the chart
            $('#most_accessed_by_managers').highcharts({
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
                    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
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
                    name: "Page Access",
                    colorByPoint: true,
                    data: series.data
                }]
            });
        }
        initialize();
    });
</script>