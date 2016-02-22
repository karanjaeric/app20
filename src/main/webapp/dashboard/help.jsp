
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
	<h3 class="text-center main-title">
		<i class="glyphicon glyphicon-film"></i>&nbsp;&nbsp;PAGE HELP SETTINGS
	</h3>
	<table class="table table-responsive">
		<tr><th>PAGE</th><th>DESCRIPTION</th><th>ACTIONS</th></tr>
		<c:forEach var="help" items="${helps}">
		<tr><td>${ help.page }</td><td>${ help.description }</td><td><button class="btn btn-warning btn-sm" onclick="edit('${ help.id}')"><i class="glyphicon glyphicon-pencil"></i>&nbsp;EDIT</button></td></tr>
		</c:forEach>
	</table>
</div>
<div class="modal fade" id="modal-help" tabindex="-1" role="dialog" aria-labelledby="myModalLabelHelp" aria-hidden="true">
		<form role="form" id="form-help">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabelHelp">
							<i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;PAGE HELP SETTINGS
						</h4>
					</div>
					<div class="modal-body" id="form-help-content">
						<input type="hidden" name="id" id="id" value="" />
						<div class="form-group">
						<label class="control-label">Page:</label>
						<select name="page" id="page" class="form-control" disabled>
							<option>SIGN_IN</option>
							<option>LOGIN</option>
							<option>HOME</option>
							<option>INTEREST_RATES</option>
							<option>WHAT_IF_ANALYSIS</option>
							<option>ANNUITY_QUOTATION</option>
							<option>CONTACT_US</option>
							<option>REGISTRATION</option>
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
							value="Save Changes" id="btn-help">
					</div>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="static/custom/js/trumbowyg.min.js"></script>
	<script type="text/javascript">

		var loading = "<p class='text-center'><img src=\"" + $('#base_url').val() + 'static/images/loader.gif" alt="loading..." /></p>';

		var prev_html = "";
		
		$('#description').trumbowyg({
		    fullscreenable: false,
		    autogrow: true
		});
	    
	   function edit(id)
	   	{

			start_wait();

			$.ajax({
	            url: $('#base_url').val() + 'data',
	            type: 'post',
	            data: {DATA: 'HELP', ID: id},
	            dataType: 'json',
	            success: function(json) {
		            stop_wait();
	               $('#id').val(json.id);
	               $('#page').val(json.page);
	               $('#description').trumbowyg('html', json.description);
	   			$('#modal-help').modal('show');
	            }
	        });
		   
		}

		$(document).ready(function() {

			$('#form-help').bootstrapValidator({
		        message: 'This value is not valid',
		        feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
		        },
		        fields: {
		            page: {
		                validators: {
		                    notEmpty: {
		                        message: 'Please select the page'
		                    }
		                }
		            },
		            description: {
		                validators: {
		                    notEmpty: {
		                        message: 'Please enter the help text and/or description'
		                    }
		                }
		            }
		        }
			}).on('success.form.bv', function(e) {
		        
		        // Prevent form submission
		        e.preventDefault();
		        // Get the form instance
		        var btn = "btn-help";
		        var form = "form-help";
		        var modal = "modal-help";
		        var btn_text = $('#' + btn).val();
		        
				$.ajax({
			        url: $('#base_url').val() + 'admin',
			        type: 'post',
			        data: {ACTION: 'HELP', ID: $('#id').val(), page: $('#page').val(), description: $('#description').val()},
			        dataType: 'json',
			        success: function(json) {
			            if(json.success)
			            {
			                $('#' + form)[0].reset();
			                $('#' + modal).modal('hide');
			                html = 'Help Details successfully saved';
			            }
			            else
			                html = 'Help Details could not be saved';
			            bootbox.alert(html);
			            $('#' + btn).val(btn_text);
			        }
			    });

		    });
			
		});
	</script>