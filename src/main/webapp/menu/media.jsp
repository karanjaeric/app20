<h2 class="text-center">
	<small>MEDIA &amp; FILES</small>
</h2>
	<ul class="nav">
		<li id="media-upload-li"><a href="javascript:void(0);"><i
				class="glyphicon glyphicon-upload"></i>&nbsp;<i
				class="fa fa-chevron-right"></i> UPLOAD MEDIA</a></li>
	</ul>
<!-- MEDIA FILE -->
<div class="modal fade" id="modal-media" tabindex="-1" role="dialog" aria-labelledby="myModalLabelMedia" aria-hidden="true">
		<form role="form" id="form-media">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabelLogo">
							<i class="glyphicon glyphicon-picture"></i>&nbsp;&nbsp;UPLOAD FILE
						</h4>
					</div>
					<div class="modal-body">
						<input type="hidden" name="ACTION" id="ACTION" value="MEDIA" />
						<div class="form-group">
							<label class="control-label">Select File to Upload</label>
							 <input type="file" class="filestyle" data-buttonName="btn-primary" id="media_file" name="media_file" data-buttonBefore="true" />
						</div>
						<div class="form-group">
							<label class="control-label">Access Permissions</label>
							<select name="access" id="access" class="form-control">
								<option>Administrator</option>
								<option>Public</option>
								<option>Member</option>
							</select>
						</div>
						<div class="form-group">
							<label class="control-label">Description</label>
							 <textarea class="form-control" name="description" id="description">
							 </textarea>
						</div>
					</div>
					<div class="modal-footer">
						<a href="#" class="btn btn-warning" data-dismiss="modal">Cancel</a>
						<input class="btn btn-primary" type="submit"
							value="Upload File" id="btn-file">
					</div>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			
			//$(":file").filestyle({buttonBefore: true, buttonName: 'btn-primary'});
			
		    $('#media-upload-li').click(function(){
		        $('#modal-media').modal('show');
		    });

		    $('#form-media').bootstrapValidator({
		        message: 'This value is not valid',
		        feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
		        },
		        fields: {
		            logo_file: {

		            	extension: 'doc,docx,xls,xlsx,pdf,jpg,jpeg,png,gif',
		                type: 'image/png,image/gif,image/jpg,image/jpeg',
		                maxSize: 100*1024*1024,   // 100 MB
		                message: 'The selected file is not valid, it should be (png,gif,jpg,jpeg) and 5 MB at maximum.'

					}
		        }
			})
			.on('success.form.bv', function(e) {
                start_wait();
                // Prevent form submission
                e.preventDefault();
                var btn = "btn-media";
                var form = "form-media";
                var modal = "modal-media";

                $('#' + btn).val('Please wait...');

                var formData = new FormData($(this)[0]);
                
        		$.ajax({
        	        url: $('#base_url').val() + 'admin',
        	        type: 'POST',
        	        data: formData,
        	        async: false,
        	        success: function(html) {
        	            stop_wait();
        	            if(html == 'true')
        	            {
        	                $('#' + form)[0].reset();
        	                $('#' + modal).modal('hide');
        	                html = 'Media file successfully uploaded';
        	            }
        	            else
        	                html = 'Media file was not uploaded';
        	            bootbox.alert(html);
        	        },
        	        cache: false,
        	        contentType: false,
        	        processData: false
        	    });

			});
		});
	</script>