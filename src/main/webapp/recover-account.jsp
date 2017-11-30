<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/partial/header.jsp" />

<div class="main-content">

    <div class="container">

        <div class="col-md-6 col-md-offset-3">
            <div class="login-form">

                <form class="register-form" id="form-recover-account">
                    <fieldset>
                        <legend class="text-center">Please Provide Your Account Details</legend>
                        <img class="profile-img-card" src="static/images/avatar_2x.png">

                        <div class="form-group">
                            <label class="control-label">MEMBERSHIP NUMBER:</label> <input
                                class="form-control disabled" type="text"
                                placeholder="MEMBERSHIP NUMBER" name="memberid" id="memberid" value="${membershipNumber}"
                        >
                        </div>

                        <div class="form-group">
                            <label class="control-label">EMPLOYER:</label> <input
                                class="form-control disabled" type="text" placeholder="SPONSOR"
                                name="employerId" id="employerId" value="${sponsorName}">
                        </div>
                        <div class="form-group">
                            <label class="control-label">PHONE:</label> <input
                                class="form-control" type="text" placeholder="PHONE NUMBER"
                                name="phoneNumber" id="phoneNumber">
                        </div>
                        <div class="form-group">
                            <label class="control-label">EMAIL:</label> <input
                                class="form-control" type="email" placeholder="EMAIL"
                                name="email" id="email">
                        </div>

                        <div class="form-group">
                            <label class="control-label">SSNIT:</label> <input
                                class="form-control" type="text" placeholder="SSNIT"
                                name="ssnit" id="ssnit">
                        </div>
                        <button class="btn btn-warning btn-block" type="submit">
                            <strong>SUBMIT</strong>
                        </button><br />

                    </fieldset>
                </form>

            </div>
        </div>

    </div>

</div>
<jsp:include page="includes/partial/footer.jsp" />