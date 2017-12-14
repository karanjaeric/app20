<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/partial/header.jsp" />

<div class="main-content">

    <div class="container">

        <div class="col-md-6 col-md-offset-3">
            <div class="login-form">

                <form role="form" id="form-resend-code-admin">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title text-center" id="myModalLabelSmsResend">
                                    <i class="fa fa-bookmark"></i>&nbsp;&nbsp;<small>Please Enter Your Username </small>
                                </h4>
                            </div>
                            <div class="modal-body">

                                <div class="form-group">
                                    <label for="userName" class="control-label">Username:</label>
                                    <input type="text" name="userName" class="form-control"
                                           id="userName" placeholder="Your Username">
                                </div>
                                <p>We will Resend your Code</p>
                            </div>
                            <div class="modal-footer">
                                <button class="btn btn-success pull-right" >RESEND</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>

    </div>

</div>
<jsp:include page="includes/partial/footer.jsp" />