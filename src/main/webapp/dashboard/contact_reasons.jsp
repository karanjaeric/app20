<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
	<div class="col-md-8">
		<h3 class="text-center main-title">
			<i class="glyphicon glyphicon-record"></i>&nbsp;&nbsp;CONTACT REASONS
		</h3>
	</div>
	<div class="col-md-4" align="right">
	<br />
			<button class="btn btn-info" id="add-contact-reason">ADD CONTACT REASON</button>
	</div>
	<input type="hidden" id="type" />
	<input type="hidden" id="item_id" />
	<table class="table table-responsive table-striped">
		<tr><th>NAME</th><th>ACTION</th></tr>
		<c:forEach var="contactReason" items="${ contactReasons }">
		<tr><td id="${ contactReason.id }">${contactReason.name }</td><td><button class="btn btn-warning btn-sm" onclick="edit_reason('${ contactReason.id }')"><i class="glyphicon glyphicon-pencil"></i>&nbsp; EDIT</button> &nbsp;<button class="btn btn-danger btn-sm" onclick="remove_reason('${ contactReason.id }')"><i class="glyphicon glyphicon-pencil"></i>&nbsp; DELETE</button></td></tr>
		</c:forEach>
	</table>
</div>
<div class="modal fade" id="modal-contact-reason" tabindex="-1" role="dialog" aria-labelledby="myModalLabelcontact-reason" aria-hidden="true">
		<form role="form" id="form-contact-reason">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabelcontact-reason">
							<i class="glyphicon glyphicon-picture"></i>&nbsp;&nbsp;ADD CONTACT REASON
						</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							 <label class="control-label">Name</label>
							 <input type="text" class="form-control" placeholder="Contact Reason" id="name" name="name"/>
						</div>
					</div>
					<div class="modal-footer">
						<a href="#" class="btn btn-warning" data-dismiss="modal">Cancel</a>
						<input class="btn btn-primary" type="submit"
							value="Save" id="btn-contact-reason">
					</div>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
    function edit_reason(id)
    {
	    $('#type').val('EDIT');
	    $('#item_id').val(id);
	    $('#name').val($('#' + id).html());
        $('#modal-contact-reason').modal('show');
	}
	function remove_reason(id)
	{
		bootbox.confirm("<p class=\"text-center\">You are about to delete a contact category. Are you sure?</p>", function(result){
			if(result)
			{
				$.ajax({
			        url: $('#base_url').val() + 'admin',
			        type: 'post',
			        data: {ACTION: 'REMOVE_CONTACT_REASON', id: id},
			        dataType: 'json',
			        success: function(json) {
			            $('#' + btn).val('Done');
			            if(json.success)
			            {
			                html = 'Contact reason successfully deleted';
			            }
			            else
			                html = 'Contact reason could not be deleted';
			            bootbox.alert(html);
			            $('#' + btn).val(btn_text);
			        }
			    });
			}
		});
	}
		$(document).ready(function(){
			
		    $('#add-contact-reason').click(function(){
			    $('#type').val('ADD');
		        $('#modal-contact-reason').modal('show');
		    });
			$('#form-contact-reason').bootstrapValidator({
		        message: 'This value is not valid',
		        feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
		        },
		        fields: {
		            name: {
		                validators: {
		                    notEmpty: {
		                        message: 'Please enter the reason'
		                    }
		                }
		            }
		        }
			})
			.on('success.form.bv', function(e) {
                // Prevent form submission
                e.preventDefault();

                var btn = "btn-contact-reason";
                var form = "form-contact-reason";
                var modal = "modal-contact-reason";
                var btn_text = $('#' + btn).val();

                $('#' + btn).val('Please wait...');
        		$.ajax({
        	        url: $('#base_url').val() + 'admin',
        	        type: 'post',
        	        data: {ACTION: 'ADD_CONTACT_REASON', name: $('#name').val(), type: $('#type').val(), id: $('#item_id').val()},
        	        dataType: 'json',
        	        success: function(json) {
        	            $('#' + btn).val('Done');
        	            if(json.success)
        	            {
        	                $('#' + form)[0].reset();
        	                $('#' + modal).modal('hide');
        	                html = 'Contact reason successfully saved';
        	            }
        	            else
        	                html = 'Contact reason could not be saved';
        	            bootbox.alert(html);
        	            $('#' + btn).val(btn_text);
        	            load_dashboard('CONTACT_REASONS');
        	        }
        	    });

			});
		});
	</script>