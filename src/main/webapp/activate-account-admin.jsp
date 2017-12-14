<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/partial/header.jsp" />

<div class="main-content">

    <div class="container">

        <div class="col-md-6 col-md-offset-3">
            <div class="login-form">

                <form role="form" id="form-sms-code-admin">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title text-center" id="myModalLabelSms">
                                    <i class="fa fa-bookmark"></i>&nbsp;&nbsp;<small>Please Enter the received code</small>
                                </h4>
                            </div>
                            <div class="modal-body">

                                <div class="form-group">
                                    <label for="code" class="control-label">Activation Code:</label>
                                    <input type="text" name="code" class="form-control"
                                           id="code" placeholder="Your Activation code">
                                </div>
                                <p>We will Activate your Account</p>
                            </div>
                            <div class="modal-footer">
                                <button class="btn btn-success pull-right" >ACTIVATE</button>
                                <a class="btn btn-danger pull-left"
                                   href="<%=request.getContextPath()%>/resend-code-admin"><strong>RESEND CODE</strong></a>
                            </div>
                        </div>
                    </div>
                </form>

            </div>
        </div>

    </div>

</div>
<jsp:include page="includes/partial/footer.jsp" />