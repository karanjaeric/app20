<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/partial/header.jsp" />

<div class="container">
	<div class="main-content">	
			<c:if test="${ content.publish }">
			<c:if test="${content.position == 'LEFT' }">
				<div class="col-md-4">
					${ content.text }
				</div>
				<div class="col-md-8">
					<jsp:include page="contact.jsp" />
				</div>
			</c:if>
			<c:if test="${content.position == 'RIGHT' }">
				<div class="col-md-8">
					<jsp:include page="contact.jsp" />
				</div>
				<div class="col-md-4">
					${ content.text }				
				</div>
			</c:if>
			<c:if test="${content.position == 'TOP' }">
				<div class="row">
					${ content.text }	
				</div>
				<div class="row">
					<jsp:include page="contact.jsp" />				
				</div>
			</c:if>
			<c:if test="${content.position == 'BOTTOM' }">
				<div class="row">
					<jsp:include page="contact.jsp" />
				</div>
				<div class="row">	
					${ content.text }				
				</div>
			</c:if>
		</c:if>
		<c:if test="${ content.publish == 'FALSE' }">
			<jsp:include page="contact.jsp" />
		</c:if>
	</div>
</div>
<input type="hidden" name="geolocation" id="geolocation" value="${ company.geolocation}" />
<input type="hidden" name="company" id="company" value="${ company.name }" />
    <script src="https://maps.googleapis.com/maps/api/js"></script>
<script type="text/javascript">
function initialize() {
    var mapCanvas = document.getElementById('map-canvas');
    var geolocation = $('#geolocation').val();
    var coordinates = geolocation.split(",");
    var mapOptions = {
      center: new google.maps.LatLng(parseFloat(coordinates[0]), parseFloat(coordinates[1])),
      zoom: 18,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    var LatLng = {lat: parseFloat(coordinates[0]), lng: parseFloat(coordinates[1])};
    var map = new google.maps.Map(mapCanvas, mapOptions);
    var marker = new google.maps.Marker({
      position: LatLng,
      map: map,
      title: $('#company').val()
    });
  }

	google.maps.event.addDomListener(window, 'load', initialize);

</script>
<jsp:include page="includes/partial/footer.jsp" />