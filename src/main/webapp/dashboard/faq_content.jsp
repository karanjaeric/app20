<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 6/13/17
  Time: 9:58 AMapi
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid section">
    <h3 class="text-center main-title">
        <i class="glyphicon glyphicon-film"></i>&nbsp;&nbsp;FAQ CONTENT
    </h3>
    <table class="table table-responsive">
        <button class="btn btn-warning btn-block" onclick="add()"><i class="glyphicon glyphicon-pencil"></i>&nbsp;ADD FAQ</button>
        <br>
        <tr><th>QUESTION</th><th>ANSWER</th><th>ACTIONS</th></tr>

        <c:forEach var="content" items="${contents}">
                <tr><td>${ content.title }</td><td>${ content.text }</td><td><button class="btn btn-warning btn-sm" onclick="edit('${ content.id}')"><i class="glyphicon glyphicon-pencil"></i>&nbsp;EDIT</button></td></tr>
        </c:forEach>
    </table>
</div>

<div class="modal fade" id="modal-content" tabindex="-1" role="dialog" aria-labelledby="myModalLabelcontent" aria-hidden="true">
    <form role="form" id="form-content">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabelcontent">
                        <i class="glyphicon glyphicon-cog"></i>&nbsp;&nbsp;FAQ CONTENT
                    </h4>
                </div>
                <div class="modal-body" id="form-content-content">
                    <input type="hidden" name="id" id="id" value="" />
                    <div class="form-group">
                        <label class="control-label">Question:</label>
                        <input type="text" name="title" class="form-control" id="title">
                    </div>
                    <div class="form-group">
                        <label class="control-label">Answer:</label>
						<textarea class="form-control" name="answer" id="answer">
						</textarea>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Publish Content</label>
                        <select class="form-control" id="publish" name="publish">
                            <option value="true">YES</option>
                            <option value="false">NO</option>
                        </select>
                    </div>
                </div>

                <div class="modal-footer">
                    <a href="#" class="btn btn-warning" data-dismiss="modal">Cancel</a>
                    <input class="btn btn-primary" type="submit"
                           value="Save Changes" id="btn-content">
                </div>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="static/custom/js/trumbowyg.min.js"></script>

<script type="text/javascript">

    $('#answer').trumbowyg({
        fullscreenable: false,
        autogrow: true
    });
    var loading = "<p class='text-center'><img src=\"" + $('#base_url').val() + 'static/images/loader.gif" alt="loading..." /></p>';

    var prev_html = "";

    function edit(id)
    {
        start_wait();
        $.ajax({
            url: $('#base_url').val() + 'data',
            type: 'post',
            data: {DATA: 'FAQ_CONTENT', ID: id},
            dataType: 'json',
            success: function(json) {
                stop_wait();
                $('#id').val(json.id);
                $('#title').val(json.title);
                $('#publish').val(json.publish);
                $('#answer').trumbowyg('html', json.answer);

                $('#modal-content').modal('show');
            }
        });

    }

    function add()
    {
        $('#modal-content').modal('show');
    }

    $(document).ready(function() {

        $('#form-content').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                title: {
                    validators: {
                        notEmpty: {
                            message: 'Please enter question'
                        }
                    }
                },
                answer: {
                    validators: {
                        notEmpty: {
                            message: 'Please enter the content text and/or description'
                        }
                    }
                }
            }
        }).on('success.form.bv', function(e) {

            // Prevent form submission
            e.preventDefault();
            // Get the form instance
            var btn = "btn-content";
            var form = "form-content";
            var modal = "modal-content";
            var btn_text = $('#' + btn).val();

            $.ajax({
                url: $('#base_url').val() + 'admin',
                type: 'post',
                data: {ACTION: 'FAQ_CONTENT', ID: $('#id').val(), answer: $('#answer').val(), title: $('#title').val(), publish: $('#publish').val()},
                dataType: 'json',
                success: function(json) {
                    if(json.success)
                    {
                        $('#' + form)[0].reset();
                        $('#' + modal).modal('hide');
                        html = 'Content Details successfully saved';
                    }
                    else
                        html = 'Content Details could not be saved';
                    bootbox.alert(html);
                    $('#' + btn).val(btn_text);
                }
            });

        });

    });
</script>
