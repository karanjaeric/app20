<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/partial/header.jsp" />

<div class="main-content">

    <div class="container">

        <div class="col-md-6 col-md-offset-3">
            <div class="login-form">

                <form role="form" id="form-find-member-account">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title text-center" id="myModalLabelFM">
                                    <i class="fa fa-bookmark"></i>&nbsp;&nbsp;<small>Provide Your Membership Number</small>
                                </h4>
                            </div>
                             <div class="modal-body">

                                <div class="form-group">
                                    <label for="memberNo" class="control-label">MEMBERSHIP NUMBER</label>
                                    <input type="text" name="memberNo" class="form-control"
                                           id="memberNo" placeholder="MEMBERSHIP NUMBER">
                                </div>
                                <p>We will Help you Recover Your Account</p>
                                 <p>Kindly Contact us on info.trustees@enterprisegroup.com.gh /0302634704 if you don't have your Membership Number</p>
                            </div>
                            <div class="modal-footer">
                                <button class="btn btn-success" >SUBMIT</button>

                            </div>
                        </div>
                    </div>
                </form>

            </div>
        </div>

    </div>

</div>
<jsp:include page="includes/partial/footer.jsp" />