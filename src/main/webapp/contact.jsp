
<div class="modal-dialog large-modal">
	<div class="modal-content">
		<div class="modal-body">
			<h1 class="heading">${ menu.contactUsName }</h1>
			<div class="row">
					<div class="col-sm-6" id="map-canvas">
				
					</div>
					
					<div class="col-sm-6">
						<h2 class="text-center">${company.name}</h2>
							<h3 class="text-center">${company.streetAddress}</h3>
							<h3 class="text-center">${company.city}</h3>
							<h3 class="text-center">${company.country.name}</h3>
							<h3 class="text-center">Tel: ${company.telephone}</h3>
							<h3 class="text-center">Fax: ${company.fax}</h3>			
							<h3 class="text-center">Email: <a href="mailto:${company.email}">${company.email}</a></h3>
					</div>
			</div>
		</div>
	</div>
</div>