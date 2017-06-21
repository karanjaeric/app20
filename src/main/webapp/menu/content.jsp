<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2 class="text-center">
	<small>CONTENT MANAGEMENT</small>
</h2>
	<ul class="nav">
		<c:if test="${ permissions.content_help }">
			<li id="help-settings-li"><a href="javascript:void(0);"><i
				class="glyphicon glyphicon-user"></i>&nbsp;<i
				class="fa fa-chevron-right"></i> HELP CONTENT</a></li>
		</c:if>
		<c:if test="${ permissions.content_page }">
			<li id="home-page-content-li"><a href="javascript:void(0);"><i
				class="glyphicon glyphicon-user"></i>&nbsp;<i
				class="fa fa-chevron-right"></i> PAGE CONTENT</a></li>
		</c:if>
		<c:if test="${ permissions.faq_page }">
			<li id="faq-page-content-li"><a href="javascript:void(0);"><i
					class="glyphicon glyphicon-user"></i>&nbsp;<i
					class="fa fa-chevron-right"></i> FAQ CONTENT</a></li>
		</c:if>
		
	</ul>
	<script type="text/javascript">
		$(document).ready(function(){

			$('#home-page-content-li').click(function(){
				load_dashboard('PAGE_CONTENT');
			});

			$('#faq-page-content-li').click(function(){
				load_dashboard('FAQ_CONTENT');
			});
			
		    $('#help-settings-li').click(function(){
		        load_dashboard('HELP');
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