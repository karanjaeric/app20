function format_no(yourNumber) {
    if (typeof yourNumber != 'undefined')
    {
        //Seperates the components of the number
        var n = yourNumber.toString().split(".");
        //Comma-fies the first part
        n[0] = n[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        //Combines the two sections
        return n.join(".");
    }
    return yourNumber;
}
/*document.onmousedown=disableclick;
 function disableclick(event)
 {
 if(event.button==2)
 {
 return false;    
 }
 } */
function hasKey(json, key)
{
    return json.hasOwnProperty(key);
}
function adminreload()
{
    if ($('#scheme_id').val() != '')
    {
       // start_wait();
        $.ajax({
            url: $('#base_url').val() + 'admin',
            type: 'post',
            data: {ACTION: 'CHANGE_SCHEME', schemeID: $('#scheme_id').val()},
            dataType: 'json',
            success: function (json) {
                console.log(json);
                if (json.success)
                    setTimeout(function () {
                        window.location.href = $('#base_url').val() + "admin";
                    }, 0);
            }
        });
    }
}
function reloadmember()
{
    if ($('#scheme2_id').val() != '') {
        start_wait();
        $.ajax({
            url: $('#base_url').val() + 'member',
            type: 'post',
            data: {ACTION: 'CHANGE_SCHEME', schemeID: $('#scheme2_id').val()},
            dataType: 'json',
            success: function (json) {
                console.log(json);
                if (json.success)
                    setTimeout(function () {
                        var schemeID = $('#scheme2_id').val();
                        console.log("Scheme Id: " + schemeID);
                        window.location.href = $('#base_url').val() + "member"
                    }, 0);
            }
        });
    }

}
function reloadproductmember()
{
    if ($('#sponsor_id').val() != '') {
        //start_wait();
        $.ajax({
            url: $('#base_url').val() + 'member',
            type: 'post',
            data: {ACTION: 'CHANGE_PRODUCT', sponsorID: $('#sponsor_id').val()},
            dataType: 'json',
            success: function (json) {
                console.log(json);
                if (json.success)
                    setTimeout(function () {
                        var sponsorID = $('#sponsor_id').val();
                        console.log("Sponsor Id: " + sponsorID);
                        window.location.href = $('#base_url').val() + "member"
                    }, 0);
            }
        });
    }

}
function set_spouse_date_of_birth()
{
    $('#spouseDateOfBirth').val($('#dateOfBirth').val());
}
function spouse_reversion()
{
    if ($('#annuityMode').val() == 'JOINT')
    {
        $('#spouseReversalGroup').removeClass('hide');
    } else
    {
        $('#spouseReversalGroup').addClass('hide');
    }
}


var menu_done = false;

var content_done = false;

function load_menu(MODULE)
{
    $.ajax({
        url: $('#base_url').val() + 'menu',
        type: 'get',
        data: {menu: MODULE},
        dataType: 'html',
        success: function (html) {
            $('#sub-menu').fadeOut('slow', function () {
                menu_done = true;
                if (content_done)
                {
                    stop_wait();
                    $('.modal-backdrop').addClass('hide');
                }
                $('#sub-menu').html(html);
                $('#sub-menu').fadeIn('slow');
            });
        }
    });
}
function loadDashboard(MODULE)
{
    console.log(MODULE);
    $.ajax({
        url: $('#base_url').val() + 'dashboard',
        type: 'get',
        data: {dashboard: MODULE,dateFrom:$('#dateFrom10').val(),dateTo:$('#dateTo10').val()},
        dataType: 'html',
        success: function (html) {
            $('#dashboard').fadeOut('slow', function () {
                content_done = true;
                if (menu_done)
                {
                    //stop_wait();
                    $('.modal-backdrop').addClass('hide');
                }
                $('#dashboard').html(html);
                $('#dashboard').fadeIn('slow');
            });
        }
    });
}
function loadContributionsHistory(MODULE, fromDate, toDate)
{
    console.log(MODULE);
    $.ajax({
        url: $('#base_url').val() + 'dashboard',
        type: 'get',
        data: {dashboard: MODULE, fromDate: fromDate, toDate: toDate},
        dataType: 'html',
        success: function (html) {
            $('#dashboard').fadeOut('slow', function () {
                content_done = true;
                if (menu_done)
                {
                    stop_wait();
                    $('.modal-backdrop').addClass('hide');
                }
                $('#dashboard').html(html);
                $('#dashboard').fadeIn('slow');
            });
        }
    });
}






$(document).ready(function () {

    $('.datepicker').datetimepicker({
        language: 'en',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0,
        format: 'dd-mm-yyyy'
    });

    function m_switch(MODULE)
    {
        menu_done = true;
      //  start_wait();
        loadDashboard(MODULE);
    }

    function switch_page(MODULE)
    {
        menu_done = false;
        content_done = false;
       // start_wait();
        load_menu(MODULE);
        loadDashboard(MODULE);
    }

    /***** ADMINISTRATION MENU *****/

    $('#admin-dashboard-li').click(function () {

        //start_wait();

        window.location.href = $('#base_url').val() + "admin";

    });

    $('#switch_profile').click(function () {
        var profile = "member";
        if ($('#switch_to').val() == 'admin')
            profile = 'managerial';
        bootbox.confirm("<p class=\"text-center\">You are about to switch your " + profile + ". Are you sure?</p>", function (result) {
            if (result)
            {
               // start_wait();
                setTimeout(function () {
                    window.location.href = $('#base_url').val() + $('#switch_to').val();
                }, 0);
            }
        });
    });

    $('#setup-main-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#setup-main-li').addClass('active');

        switch_page('SETUP');

    });

    $('#pwd-reset-btn').click(function () {
        $('#modal-pwd-reset').modal('show');
    });


    $('#pwd-reset-btn-admin').click(function () {
        $('#modal-pwd-reset-admin').modal('show');
    });

    // $('#acc-recover-btn').click(function(){
    //     $('#modal-acc-recover').modal('show');
    //
    // });
    $('#content-main-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#content-main-li').addClass('active');

        switch_page('CONTENT');

    });


    $('#scheme-main-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#scheme-main-li').addClass('active');

        switch_page('SCHEME');

    });
    $('#calc-log').click(function () {

        $('#calc-log li').removeClass('active');

        $('#calc-log').addClass('active');

        switch_page('CALC-LOG');

    });
    $('#member-main-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#member-main-li').addClass('active');

        switch_page('MEMBER');

    });

    $('#member-listing-main-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#member-listing-main-li').addClass('active');

        switch_page('MEMBER_LISTING');

    });

    $('#corporate-statement-main-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#corporate-statement-main-li').addClass('active');

        switch_page('CORPORATE_STATEMENT');

    });


    $('#member-operations-main-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#member-operations-main-li').addClass('active');

        switch_page('MEMBER_OPERATIONS');

    });

    $('#withdrawal-statement-main-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#withdrawal-statement-main-li').addClass('active');

        switch_page('WITHDRAWAL_STATEMENT');

    });

    $('#withdrawal-settlements-main-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#withdrawal-settlements-main-li').addClass('active');

        switch_page('WITHDRAWAL_SETTLEMENTS');

    });

    $('#admin_fee_listing-main-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#admin_fee_listing-main-li').addClass('active');

        switch_page('ADMIN_FEE_LISTING');

    });

    $('#member-movement-main-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#member-movement-main-li').addClass('active');

        switch_page('MEMBER_MOVEMENT');

    });

    $('#fund-movement-main-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#fund-movement-main-li').addClass('active');

        switch_page('FUND_MOVEMENT');

    });

    $('#receipt-main-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#receipt-main-li').addClass('active');

        switch_page('RECEIPT_SUMMARY');

    });

    $('#pending-contribution-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#pending-contribution-li').addClass('active');

        switch_page('PENDING_CONTRIBUTION');

    });


    $('#media-main-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#media-main-li').addClass('active');

        switch_page('MEDIA');

    });

    $('#receipts-main-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#receipts-main-li').addClass('active');

        m_switch('RECEIPT');

    });

    $('#payments-main-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#payments-main-li').addClass('active');

        m_switch('SPONSOR_BENEFIT_PAYMENT');

    });
    $('#memberpayments-main-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#memberpayments-main-li').addClass('active');

        m_switch('MEMBERPAYMENT');

    });

    $('#registered-main-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#registered-main-li').addClass('active');

        m_switch('PORTAL_MEMBER');

    });

    $('#sponsors-main-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#sponsors-main-li').addClass('active');

        m_switch('SPONSOR');

    });


    $('#uac-main-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#uac-main-li').addClass('active');

        switch_page('UAC');

    });

    $('#analytics-main-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#analytics-main-li').addClass('active');

        switch_page('ANALYTICS');

    });
    $('#benefitProjectionPage-main-li').click(function () {

        $('#benefitProjectionPage-main-li').removeClass('active');

        $('#benefitProjectionPage-main-li').addClass('active');

        switch_page('CBP');

    });
    $('#sponsor-benefitProjectionPage-main-li').click(function () {

        $('#sponsor-benefitProjectionPage-main-li').removeClass('active');

        $('#sponsor-benefitProjectionPage-main-li').addClass('active');

        switch_page('SCBP');

    });

    /***	AGENTS ONLY MENU ****/

    $('#commissions-main-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#commissions-main-li').addClass('active');

        switch_page('COMMISSIONS');

    });

    $('#clients-main-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#clients-main-li').addClass('active');

        switch_page('CLIENTS');

    });

    /***	MEMBERS ONLY MENU ****/



    $('#member-dashboard-li').click(function () {

      //  start_wait();

        window.location.href = $('#base_url').val() + "member";

    });

    $('#pensioner-dashboard-li').click(function () {

       // start_wait();

        window.location.href = $('#base_url').val() + "pensioner";

    });

    $('#personal-information-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#personal-information-li').addClass('active');

        m_switch("PI");
    });

    $('#pensioner-information-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#pensioner-information-li').addClass('active');

        m_switch("PENSIONER_INFO");
    });

    $('#pension-details-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#pension-details-li').addClass('active');

        m_switch("PENSION_DETAILS");
    });

    $('#pension-advice-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#pension-advice-li').addClass('active');

        m_switch("PENSION_ADVICE");
    });

    $('#pension-advice-grid').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#pension-advice-grid').addClass('active');

        m_switch("PENSION_ADVICE_GRID");
    });


    $('#contribution-history-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#contribution-history-li').addClass('active');

        m_switch("CH");
    });

    $('#contribution-history-grid-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#contribution-history-grid-li').addClass('active');
        $('.modal.in').modal('hide');

        m_switch("CH_GRID");
    });


    $('#contributions_history').click(function () {
        alert("testings");exit();

        $('#main-menu.nav li').removeClass('active');

        $('#contribution-history-grid-li').addClass('active');

        m_switch("CH_GRID");
    });

    $('#statement-of-account-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#statement-of-account-li').addClass('active');

        m_switch("SA");
    });

    $('#statement-of-account-grid-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#statement-of-account-grid-li').addClass('active');

        m_switch("SA_GRID");
    });

    $('#unitized-statement-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#unitized-statement-li').addClass('active');

        m_switch("US");
    });

    $('#member-certificate-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#member-certificate-li').addClass('active');

        m_switch("MCE");
    });

    $('#what-if-analysis-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#what-if-analysis-li').addClass('active');

        m_switch("WIA");
    });
    $('#calculate-benefit-projection-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#calculate-benefit-projection-li').addClass('active');

        m_switch("CBP");

    });
    $('#member-benefits-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#member-benefits-li').addClass('active');

        m_switch("MEMBERPAYMENT");
    });

    $('#sponsor-calculate-benefit-projection-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#sponsor-calculate-benefit-projection-li').addClass('active');

        m_switch("SCBP");
    });



    $('#benefits-projection-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#benefits-projection-li').addClass('active');

        m_switch("BP");
    });

    $('#benefits-projection-grid-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#benefits-projection-grid-li').addClass('active');

        m_switch("BP_GRID");
    });

    $('#annual-contributions-grid-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#annual-contributions-grid-li').addClass('active');

        m_switch("AC_GRID");
    });

    $('#annual-contributions-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#annual-contributions-li').addClass('active');

        m_switch("AC");
    });
    $('#provisional-member-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#provisional-member-li').addClass('active');

        m_switch("PMS");
    });

    $('#media-files-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#media-files-li').addClass('active');

        m_switch("MF");
    });
    $('#document-files-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#document-files-li').addClass('active');

        m_switch("DOCUMENTS");
    });

    $('#member-claims-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#member-claims-li').addClass('active');

        m_switch("MC");
    });


    $('#balances-history-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#balances-history-li').addClass('active');

        m_switch("BH");
    });

    $('#balances-history-grid-li').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#balances-history-grid-li').addClass('active');

        m_switch("BAL_HISTORY_GRID");
    });
    
    
      $('#cumulative-statement-grid-li').click(function () {
          //alert("testing cumulative statement");exit();

        $('#main-menu.nav li').removeClass('active');

        $('#cumulative-statement-grid-li').addClass('active');
        

        m_switch("CUMULATIVE_STATEMENT");
    });

    $('#balances-history-grid-li1').click(function () {

        $('#main-menu.nav li').removeClass('active');

        $('#balances-history-grid-li1').addClass('active');

        m_switch("BAL_HISTORY_GRID1");
    });

    /***** Other Menu Items *****/

    $('#change-pwd-li').click(function () {
        bootbox.confirm("<p style=\"text-center\">You have requested to change your password. Are you sure?</p>", function (result) {
            if (result)
            {
                $.ajax({
                    url: $('#base_url').val() + $('#path').val(),
                    type: 'post',
                    data: {ACTION: 'PRE_CHANGE_PASSWORD'},
                    dataType: 'json',
                    success: function (json) {
                        if (json.success)
                        {
                            $('#modal-change-pwd').modal('show');
                        } else
                        {
                            bootbox.alert(json.message);
                        }
                    }
                });
            }
        });
    });

    $('#send-email-btn').click(function () {
        $('#modal-send-email').modal('show');
    });

    $('#logout-li').click(function () {
        bootbox.confirm("<p class='text-center'>Are you sure?</p>", function (result) {
            if (result)
            {
                $.ajax({
                    url: $('#base_url').val() + "admin",
                    type: 'post',
                    data: {ACTION: 'LOGOUT'},
                    dataType: 'json',
                    success: function (json) {
                        if (json.success)
                        {
                            bootbox.alert('<p class="text-center">You have been logged out successfully.<br />Redirecting...</p>');
                            location.reload();
                        }
                    }
                });
            }
        });

    });
    $('#register-btn').click(function () {
        $('#modal-register').modal('show');
    });

    $('#form-change-password').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        excluded: ':disabled',
        fields: {
            currentPassword: {
                validators: {
                    notEmpty: {
                        message: 'Please enter your current password'
                    }
                }
            },
            securityCode: {
                validators: {
                    notEmpty: {
                        message: 'Please enter the security code'
                    }
                }
            },
            newPassword: {
                validators: {
                    notEmpty: {
                        message: 'Please enter your new password'
                    },
                    identical: {
                        field: 'confirmPassword',
                        message: 'Your passwords must match'
                    },
                    callback: {
                        message: 'Invalid password entered',
                        callback: function (value, validator, $field) {
                            if (value === '') {
                                return true;
                            }

                            // Check the password strength
                            if (value.length < minimum && minimum > 0) {
                                console.log("minimum....");
                                return {
                                    valid: false,
                                    message: 'It must be at least ' + minimum + ' characters long'
                                };
                            }

                            // The password doesn't contain any uppercase character
                            if (value === value.toLowerCase() && uppercase == "true") {
                                console.log("uppercase....");
                                return {
                                    valid: false,
                                    message: 'It must contain at least one upper case character'
                                }
                            }

                            // The password doesn't contain any uppercase character
                            if (value === value.toUpperCase() && lowercase == "true") {
                                console.log("lowercase....");
                                return {
                                    valid: false,
                                    message: 'It must contain at least one lower case character'
                                }
                            }

                            // The password doesn't contain any digit
                            if (value.search(/[0-9]/) < 0 && numbers == "true") {

                                console.log("numbers....");
                                return {
                                    valid: false,
                                    message: 'It must contain at least one digit'
                                }
                            }

                            return true;
                        }
                    }
                }
            },
            confirmPassword: {
                validators: {
                    notEmpty: {
                        message: 'Please confirm the new password'
                    },
                    identical: {
                        field: 'newPassword',
                        message: 'Your passwords must match'
                    },
                    callback: {
                        message: 'Invalid password entered',
                        callback: function (value, validator, $field) {
                            if (value === '') {
                                return true;
                            }

                            // Check the password strength
                            if (value.length < minimum && minimum > 0) {
                                console.log("minimum....");
                                return {
                                    valid: false,
                                    message: 'It must be at least ' + minimum + ' characters long'
                                };
                            }

                            // The password doesn't contain any uppercase character
                            if (value === value.toLowerCase() && uppercase == "true") {
                                console.log("uppercase....");
                                return {
                                    valid: false,
                                    message: 'It must contain at least one upper case character'
                                }
                            }

                            // The password doesn't contain any uppercase character
                            if (value === value.toUpperCase() && lowercase == "true") {
                                console.log("lowercase....");
                                return {
                                    valid: false,
                                    message: 'It must contain at least one lower case character'
                                }
                            }

                            // The password doesn't contain any digit
                            if (value.search(/[0-9]/) < 0 && numbers == "true") {

                                console.log("numbers....");
                                return {
                                    valid: false,
                                    message: 'It must contain at least one digit'
                                }
                            }

                            return true;
                        }
                    }
                }
            }
        }
    })
            .on('success.form.bv', function (e) {

                // Prevent form submission
                e.preventDefault();
               // start_wait();
                $.ajax({
                    url: $('#base_url').val() + 'admin',
                    type: 'POST',
                    data: {ACTION: 'CHANGE_PASSWORD', currentPassword: $('#currentPassword').val(), securityCode: $('#securityCode').val(), newPassword: $('#newPassword').val()},
                    dataType: 'json',
                    success: function (json) {
                        stop_wait();
                        if (json.success)
                            $('#modal-change-pwd').modal('hide');
                        bootbox.alert(json.message);
                    }
                });

            });

});

$('#form-password-reset').bootstrapValidator({
    message: 'This value is not valid',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    excluded: ':disabled',
    fields: {
        Username: {
            validators: {
                notEmpty: {
                    message: 'Please enter your Username'
                }
            }
        }
    }
})

        .on('success.form.bv', function (e) {

            // Prevent form submission
            var resetCountryCode = $('.reset-country-code').val();
            if (resetCountryCode == null)
            {
                resetCountryCode = '';
            } else {
                resetCountryCode = $('.reset-country-code').val();
            }
            e.preventDefault();
            //start_wait();
            $.ajax({
                url: $('#base_url').val() + 'password-reset',
                type: 'POST',
                data: {ACTION: 'REQUEST_RESET', Username: resetCountryCode + $('#Username').val()},
                dataType: 'json',
                success: function (json) {
                    stop_wait();
                    bootbox.alert(json.message);
                    if (json.success)
                        $('#modal-pwd-reset').modal('hide');

                    setTimeout(
                            function () {
                                window.location.href = $(
                                        '#base_url')
                                        .val()
                                        + 'password-reset';
                            }, 5000);
                }
            });

        });

$('#form-password-reset-admin').bootstrapValidator({
    message: 'This value is not valid',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    excluded: ':disabled',
    fields: {
        AUsername: {
            validators: {
                notEmpty: {
                    message: 'Please enter your username'
                }
            }
        }
    }
})

        .on('success.form.bv', function (e) {
            var resetCountryCode = $('.admin-reset-country-code').val();
            if (resetCountryCode == null)
            {
                resetCountryCode = '';
            } else {
                resetCountryCode = $('.admin-reset-country-code').val();
            }
            // Prevent form submission
            e.preventDefault();
           // start_wait();
            $.ajax({
                url: $('#base_url').val() + 'password-reset-admin',
                type: 'POST',
                data: {ACTION: 'REQUEST_RESET_ADMIN', AUsername: resetCountryCode + $('#AUsername').val()},
                dataType: 'json',
                success: function (json) {
                    stop_wait();
                    bootbox.alert(json.message);
                    if (json.success)
                        $('#modal-pwd-reset-admin').modal('hide');
                    setTimeout(
                            function () {
                                window.location.href = $(
                                        '#base_url')
                                        .val()
                                        + 'password-reset-admin';
                            }, 5000);

                }
            });

        });

$('#form-find-member-account').bootstrapValidator({
    message: 'This value is not valid',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    excluded: ':disabled',
    fields: {
        memberNo: {
            validators: {
                notEmpty: {
                    message: 'Please enter your Membership Number'
                }
            }
        }
    }
})

        .on('success.form.bv', function (e) {

            // Prevent form submission
            e.preventDefault();
           // start_wait();
            $.ajax({
                url: $('#base_url').val() + 'find-member-account',
                type: 'get',
                data: {ACTION: 'FIND_MEMBER', category: 'MEMBER', memberNo: $('#memberNo').val()},
                dataType: 'json',
                success: function (json) {
                    stop_wait();
                    bootbox.alert(json.message);
                    var status = json.success;
                    if (status) {
                        setTimeout(
                                function () {
                                    window.location.href = $(
                                            '#base_url')
                                            .val()
                                            + 'recover-account';
                                }, 5000);
                    }

                }
            });

        });

//form-sms-code

$('#form-sms-code').bootstrapValidator({
    message: 'This value is not valid',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    excluded: ':disabled',
    fields: {
        code: {
            validators: {
                notEmpty: {
                    message: 'Please enter your Activation Code'
                }
            }
        }
    }
})

        .on('success.form.bv', function (e) {

            // Prevent form submission
            e.preventDefault();
          //  start_wait();
            $.ajax({
                url: $('#base_url').val() + 'sign-in',
                type: 'POST',
                data: {ACTION: 'ACTIVATE_ACCOUNT', code: $('#code').val()},
                dataType: 'json',
                success: function (json) {
                    stop_wait();
                    bootbox.alert(json.message);
                    if (json.success) {
                        var status = json.success;
                        if (status) {
                            $("form#form-sms-code")[0]
                                    .reset();
                            setTimeout(
                                    function () {
                                        window.location.href = $(
                                                '#base_url')
                                                .val()
                                                + 'sign-in';
                                    }, 5000);

                        }
                    }
                }
            });

        });

$('#form-sms-code-admin').bootstrapValidator({
    message: 'This value is not valid',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    excluded: ':disabled',
    fields: {
        code: {
            validators: {
                notEmpty: {
                    message: 'Please enter your Activation Code'
                }
            }
        }
    }
})

        .on('success.form.bv', function (e) {

            // Prevent form submission
            e.preventDefault();
            //start_wait();
            $.ajax({
                url: $('#base_url').val() + 'sign-in',
                type: 'POST',
                data: {ACTION: 'ACTIVATE_ACCOUNT_ADMIN', code: $('#code').val()},
                dataType: 'json',
                success: function (json) {
                    stop_wait();
                    bootbox.alert(json.message);
                    if (json.success) {
                        var status = json.success;
                        if (status) {
                            $("form#form-sms-code-admin")[0]
                                    .reset();
                            setTimeout(
                                    function () {
                                        window.location.href = $(
                                                '#base_url')
                                                .val()
                                                + 'admin';
                                    }, 5000);

                        }
                    }
                }
            });

        });



//modal-resend-code

$('#form-resend-code').bootstrapValidator({
    message: 'This value is not valid',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    excluded: ':disabled',
    fields: {
        phoneNumber: {
            validators: {
                notEmpty: {
                    message: 'Please enter your Phone Number'
                }
            }
        }
    }
})

        .on('success.form.bv', function (e) {

            // Prevent form submission
            e.preventDefault();
           // start_wait();
            $.ajax({
                url: $('#base_url').val() + 'resend-code',
                type: 'POST',
                data: {ACTION: 'RESEND_CODE', phoneNumber: $('#phoneNumber').val()},
                dataType: 'json',
                success: function (json) {
                    stop_wait();
                    bootbox.alert(json.message);
                    var status = json.success;

                    if (status) {


                        // $('#modal-resend-code').modal('hide');

                        $("form#form-sms-code")[0]
                                .reset();
                        setTimeout(
                                function () {
                                    window.location.href = $(
                                            '#base_url')
                                            .val()
                                            + 'activate-account';
                                }, 5000);

                    }
                }
            });

        });

$('#form-resend-code-admin').bootstrapValidator({
    message: 'This value is not valid',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    excluded: ':disabled',
    fields: {
        userName: {
            validators: {
                notEmpty: {
                    message: 'Please enter your Uername'
                }
            }
        }
    }
})

        .on('success.form.bv', function (e) {

            // Prevent form submission
            e.preventDefault();
           // start_wait();
            $.ajax({
                url: $('#base_url').val() + 'resend-code-admin',
                type: 'POST',
                data: {ACTION: 'RESEND_CODE_ADMIN', userName: $('#userName').val()},
                dataType: 'json',
                success: function (json) {
                    stop_wait();
                    bootbox.alert(json.message);
                    var status = json.success;

                    if (status) {
                        setTimeout(
                                function () {
                                    window.location.href = $(
                                            '#base_url')
                                            .val()
                                            + 'activate-account-admin';
                                }, 5000);

                    }
                }
            });

        });



$('#form-reset-password-admin').bootstrapValidator({
    message: 'This value is not valid',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        resetCodeA: {
            validators: {
                notEmpty: {
                    message: 'Please enter the security code'
                }
            }
        },
        newPassword: {
            validators: {
                notEmpty: {
                    message: 'Please enter your new password'
                },
                identical: {
                    field: 'confirmPassword',
                    message: 'Your passwords must match'
                },
                callback: {
                    message: 'Invalid password entered',
                    callback: function (value, validator, $field) {
                        if (value === '') {
                            return true;
                        }

                        // Check the password strength
                        if (value.length < minimum && minimum > 0) {
                            console.log("minimum....");
                            return {
                                valid: false,
                                message: 'It must be at least ' + minimum + ' characters long'
                            };
                        }

                        // The password doesn't contain any uppercase character
                        if (value === value.toLowerCase() && uppercase == "true") {
                            console.log("uppercase....");
                            return {
                                valid: false,
                                message: 'It must contain at least one upper case character'
                            }
                        }

                        // The password doesn't contain any uppercase character
                        if (value === value.toUpperCase() && lowercase == "true") {
                            console.log("lowercase....");
                            return {
                                valid: false,
                                message: 'It must contain at least one lower case character'
                            }
                        }

                        // The password doesn't contain any digit
                        if (value.search(/[0-9]/) < 0 && numbers == "true") {

                            console.log("numbers....");
                            return {
                                valid: false,
                                message: 'It must contain at least one digit'
                            }
                        }

                        return true;
                    }
                }
            }
        },
        confirmPassword: {
            validators: {
                notEmpty: {
                    message: 'Please confirm the new password'
                },
                identical: {
                    field: 'newPassword',
                    message: 'Your passwords must match'
                },
                callback: {
                    message: 'Invalid password entered',
                    callback: function (value, validator, $field) {
                        if (value === '') {
                            return true;
                        }

                        // Check the password strength
                        if (value.length < minimum && minimum > 0) {
                            console.log("minimum....");
                            return {
                                valid: false,
                                message: 'It must be at least ' + minimum + ' characters long'
                            };
                        }

                        // The password doesn't contain any uppercase character
                        if (value === value.toLowerCase() && uppercase == "true") {
                            console.log("uppercase....");
                            return {
                                valid: false,
                                message: 'It must contain at least one upper case character'
                            }
                        }

                        // The password doesn't contain any uppercase character
                        if (value === value.toUpperCase() && lowercase == "true") {
                            console.log("lowercase....");
                            return {
                                valid: false,
                                message: 'It must contain at least one lower case character'
                            }
                        }

                        // The password doesn't contain any digit
                        if (value.search(/[0-9]/) < 0 && numbers == "true") {

                            console.log("numbers....");
                            return {
                                valid: false,
                                message: 'It must contain at least one digit'
                            }
                        }

                        return true;
                    }
                }
            }
        }
    }
})
        .on('success.form.bv', function (e) {

            // Prevent form submission
            e.preventDefault();
           // start_wait();
            $.ajax({
                url: $('#base_url').val() + 'password-reset-admin',
                type: 'POST',
                data: {ACTION: 'RESET_PASSWORD_ADMIN', resetCodeA: $('#resetCodeA').val(), newPassword: $('#newPassword').val()},
                dataType: 'json',
                success: function (json) {
                    stop_wait();
                    bootbox.alert(json.message);

                    if (json.success)
                        setTimeout(function () {
                            window.location.href = $('#base_url').val();
                        }, 3000);
                }
            });

        });

$('#form-reset-password').bootstrapValidator({
    message: 'This value is not valid',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        resetCode: {
            validators: {
                notEmpty: {
                    message: 'Please enter the reset code'
                }
            }
        },
        newPassword: {
            validators: {
                notEmpty: {
                    message: 'Please enter your new password'
                },
                identical: {
                    field: 'confirmPassword',
                    message: 'Your passwords must match'
                },
                callback: {
                    message: 'Invalid password entered',
                    callback: function (value, validator, $field) {
                        if (value === '') {
                            return true;
                        }

                        // Check the password strength
                        if (value.length < minimum && minimum > 0) {
                            console.log("minimum....");
                            return {
                                valid: false,
                                message: 'It must be at least ' + minimum + ' characters long'
                            };
                        }

                        // The password doesn't contain any uppercase character
                        if (value === value.toLowerCase() && uppercase == "true") {
                            console.log("uppercase....");
                            return {
                                valid: false,
                                message: 'It must contain at least one upper case character'
                            }
                        }

                        // The password doesn't contain any uppercase character
                        if (value === value.toUpperCase() && lowercase == "true") {
                            console.log("lowercase....");
                            return {
                                valid: false,
                                message: 'It must contain at least one lower case character'
                            }
                        }

                        // The password doesn't contain any digit
                        if (value.search(/[0-9]/) < 0 && numbers == "true") {

                            console.log("numbers....");
                            return {
                                valid: false,
                                message: 'It must contain at least one digit'
                            }
                        }

                        return true;
                    }
                }
            }
        },
        confirmPassword: {
            validators: {
                notEmpty: {
                    message: 'Please confirm the new password'
                },
                identical: {
                    field: 'newPassword',
                    message: 'Your passwords must match'
                },
                callback: {
                    message: 'Invalid password entered',
                    callback: function (value, validator, $field) {
                        if (value === '') {
                            return true;
                        }

                        // Check the password strength
                        if (value.length < minimum && minimum > 0) {
                            console.log("minimum....");
                            return {
                                valid: false,
                                message: 'It must be at least ' + minimum + ' characters long'
                            };
                        }

                        // The password doesn't contain any uppercase character
                        if (value === value.toLowerCase() && uppercase == "true") {
                            console.log("uppercase....");
                            return {
                                valid: false,
                                message: 'It must contain at least one upper case character'
                            }
                        }

                        // The password doesn't contain any uppercase character
                        if (value === value.toUpperCase() && lowercase == "true") {
                            console.log("lowercase....");
                            return {
                                valid: false,
                                message: 'It must contain at least one lower case character'
                            }
                        }

                        // The password doesn't contain any digit
                        if (value.search(/[0-9]/) < 0 && numbers == "true") {

                            console.log("numbers....");
                            return {
                                valid: false,
                                message: 'It must contain at least one digit'
                            }
                        }

                        return true;
                    }
                }
            }
        }
    }
})
        .on('success.form.bv', function (e) {

            // Prevent form submission
            e.preventDefault();
            //start_wait();
            $.ajax({
                url: $('#base_url').val() + 'password-reset',
                type: 'POST',
                data: {ACTION: 'RESET_PASSWORD', resetCode: $('#resetCode').val(), newPassword: $('#newPassword').val()},
                dataType: 'json',
                success: function (json) {
                    stop_wait();
                    bootbox.alert(json.message);

                    if (json.success)
                        setTimeout(function () {
                            window.location.href = $('#base_url').val() + 'sign-in';
                        }, 3000);
                }
            });

        });


function hide_or_show()
{
    if ($('#maritalStatus').val() == '2')
    {
        $('#spouseDateOfBirthGroup').removeClass('hide');
        $('#paymentModeGroup').removeClass('hide');
        $('#spouseGenderGroup').removeClass('hide');
    } else
    {
        $('#paymentMode').val('SINGLE');
        $('#spouseDateOfBirthGroup').addClass('hide');
        $('#paymentModeGroup').addClass('hide');
        $('#spouseGenderGroup').addClass('hide');
    }
}