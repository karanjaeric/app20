<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
						<input name="access" id="access" type="hidden" value="Public"/>
						<div class="form-group">
							<label class="control-label">Description</label>
							 <textarea class="form-control" name="description" id="description">
							 </textarea>
						</div>
						<div class="form-group">
							<label class="control-label">Profiles</label>
							<ul class="list-group">
								<c:forEach var="profile" items="${ profiles }">
									<li  class="list-group-item"><input type="checkbox" name="${ profile.profile }" id="${ profile.profile }"/>&nbsp;${ profile.name }</li>
								</c:forEach>
							</ul>
						</div>
						<div class="form-group">
							<label class="control-label">Select Specific Member (If applicable)</label>
							 <table class="table">
							 	<tr>
							 	<td>
							 	<select name="identifier" id="identifier" class="form-control">
						 		<option value="MEMBER_NO">Member No</option>	 	
						 		<option value="VOTER">Voter No</option>	
						 		<option value="PASSPORT">Passport No</option>	
						 		<option value="PENNO">Pension No</option>	
						 		<option value="NATIONAL">National ID</option>	
						 		<option value="DRIVER">Driving Lic. No</option>	
						 		<option value="STAFF">Staff No</option>	
						 		<option value="PIN">PIN No</option>	
						 		<option value="EMAIL">Email Address</option>	
						 		<option value="NHIF">NHIF</option>	
						 		<option value="PHONE">Phone No</option>	
						 		<option value="MEMBER_ID">Member ID</option>	
						 		<option value="FIRST_NAME">First Name</option>	
						 		<option value="SURNAME">Surname</option>	
						 		<option value="OTHER_NAMES">Other Names</option>	
						 		<option value="NAME">Name</option>	
							 </select>
							 </td>
							 <td>
							 <input type="text" id="member_name" class="form-control"/>
							 </td>
							 <td>
						        <button class="btn btn-info" onclick="search_member();" type="button">Select Member</button>
							 </td>
							 </table>
							 <input type="hidden" id="member_id" name="member_id"/>
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
<div class="modal fade" id="modal-view-member" tabindex="-1" role="dialog" aria-labelledby="myModalLabelViewMember" aria-hidden="true">
<form role="form" id="form-view-member">
			<div class="modal-dialog large-modal">
				<div class="modal-content">
					<div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title" id="myModalLabelViewMember">
							<i class="glyphicon glyphicon-picture"></i>&nbsp;&nbsp;SELECT MEMBER
						</h4>
					</div>
					<div class="modal-body">
						<table class="table table-responsive table-striped" id="select-results">
						</table>
					</div>
					</div>
				</div>
			</form>
</div>
	<script type="text/javascript">
	
	function select_member(id, name, member_no)
	{
		$('#member_id').val(id);
		$('#member_name').val(name);
		$('#modal-view-member').modal('hide');
	}
	function search_member()
	{
		if($('#search').val() != '')
		{
			start_wait();
			$.ajax({
    	        url: $('#base_url').val() + 'admin',
    	        type: 'post',
    	        data: {ACTION: 'SEARCH_MEMBER', profile: 'MEMBER', search: $('#member_name').val(), identifier: $('#identifier').val()},
    	        dataType: 'json',
    	        success: function(json) {
        	        console.log(json);
    	            	html = "<tr><th>NAME</th><th>EMAIL ADDRESS</th><th>ACTION</th></tr>";
        	            if(json.success)
    					{
    						$.each(json, function(key, value) {
    				        	if(key == 'rows')
    				           	{
    				        		for ( var i = 0; i < json.rows.length; i++) {
    				            		var row = json.rows[i];
    				            		html = html + "<tr><td>" + row['name'] + "</td><td>" + row['email'] + "</td><td><a onclick=\"select_member('" + row['id'] + "', '" + row['name'] + "', '" + row['memberNo'] + "');\" class=\"btn btn-sm btn-primary\"><i class=\"glyphicon glyphicon-ok\"></i>&nbsp;&nbsp;SELECT MEMBER</a></td></tr>";
    				        		}
    								stop_wait();
    				           	}
    						});
    					}
					$('#select-results').html(html);
					stop_wait();
					$('#modal-view-member').modal('show');
    	        }
    	    	});
    	   }
	}
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
		            media_file: {

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
					dataType: 'json',
        	        async: false,
        	        success: function(json) {
        	            stop_wait();
        	            if(json.success)
        	            {
        	                $('#' + form)[0].reset();
        	                $('#' + modal).modal('hide');
        	            }
        	            bootbox.alert(json.message);
						load_dashboard("MF");
        	        },
        	        cache: false,
        	        contentType: false,
        	        processData: false
        	    });

			});
		});
	</script>