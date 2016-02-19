<h2 class="text-center">
	<small>ANALYTICS &amp; REPORTING</small>
</h2>
	<ul class="nav">
		<li id="graph-li"><a href="javascript:void(0);"><i
				class="glyphicon glyphicon-dashboard"></i>&nbsp;<i
				class="fa fa-chevron-right"></i> GRAPHICAL ANALYTICS</a></li>
		<li id="uar-li"><a href="javascript:void(0);"><i
				class="glyphicon glyphicon-dashboard"></i>&nbsp;<i
				class="fa fa-chevron-right"></i> USER ACCESS REPORTS</a></li>
	</ul>
	<script type="text/javascript">

		$(document).ready(function(){
		    
		    $('#uar-li').click(function(){
		        load_dashboard('USER_ACCESS_REPORTS');
		    });
		    
		    $('#graph-li').click(function(){
		        load_dashboard('ANALYTICS');
		    });

			function load_dashboard(MODULE)
			{
		        start_wait();
				$.ajax({
		            url: $('#base_url').val() + 'dashboard',
		            type: 'get',
		            data: {dashboard: MODULE},
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
		});
	</script>