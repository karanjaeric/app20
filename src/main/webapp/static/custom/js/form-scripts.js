function start_wait() {
	$('#wait-dialog').modal({
		backdrop : 'static',
		keyboard : false
	});
}
function stop_wait() {
	$('#wait-dialog').modal('hide');
}
function show_calculation_mode(){
	if($('#calculationMode').val() == "0")
	{
		$('#purchasePriceGroup').removeClass('hide');
		$('#unRegPurchasePriceGroup').removeClass('hide');
		$('#targetPensionGroup').addClass('hide');
	}
	else if($('#calculationMode').val() == "1")
	{
		$('#purchasePriceGroup').addClass('hide');
		$('#unRegPurchasePriceGroup').addClass('hide');
		$('#targetPensionGroup').removeClass('hide');
	}
	else {

		$('#purchasePriceGroup').addClass('hide');
		$('#unRegPurchasePriceGroup').addClass('hide');
		$('#targetPensionGroup').addClass('hide');
	}
}
var minimum = parseInt($('#minimum').val());
var lowercase = $('#lowercase').val();
var uppercase = $('#uppercase').val();
var numbers = $('#numbers').val();

$(document).ready(function() {

					$('#form-analysis')
					.bootstrapValidator(
							{
								message : 'This value is not valid',
								feedbackIcons : {
									valid : 'glyphicon glyphicon-ok',
									invalid : 'glyphicon glyphicon-remove',
									validating : 'glyphicon glyphicon-refresh'
								},
						        excluded: ':disabled',
								fields : {
									monthlyContributions : {
										validators : {
											notEmpty : {
												message : 'Please enter the monthly contributions'
											},
											numeric : {
												message : 'This value can and must only be a number'
											}
										}
									},
									rateOfReturn : {
										validators : {
											notEmpty : {
												message : 'Please enter the income rate of return'
											},
											numeric : {
												message : 'This value can and must only be a number'
											}
										}
									},
									annualGrowthRate : {
										validators : {
											notEmpty : {
												message : 'Please enter the annual salary growth rate'
											},
											numeric : {
												message : 'This value can and must only be a number'
											}
										}
									},
									emailAddress : {
										validators : {
											notEmpty : {
												message : 'Sorry, your email address is required'
											},
											emailAddress : {
												message : 'Oops! This doesn\'t look like a valid email address'
											}
										}
									},
									phoneNumber : {
										validators : {
											notEmpty : {
												message : 'Sorry, your phone number is required'
											}
										}
									},
									inflationRate : {
										validators : {
											notEmpty : {
												message : 'Please enter the current inflation rate'
											},
											numeric : {
												message : 'This value can and must only be a number'
											}
										}
									},
									yourAge : {
										validators : {
											notEmpty : {
												message : 'Please enter your current age'
											},
											numeric : {
												message : 'This value can and must only be a number'
											}
										}
									},
									ageTo : {
										validators : {
											notEmpty : {
												message : 'Please enter the age to project to'
											},
											numeric : {
												message : 'This value can and must only be a number'
											}
										}
									}
								}
							})
					.on(
							'success.form.bv',
							function(e) {
								start_wait();
								// Prevent form submission
								e.preventDefault();
								// Get the form instance
								$
										.ajax({
											url : $('#base_url').val()
													+ 'what-if-analysis',
											type : 'post',
											data : {
												contributions : $(
														'#monthlyContributions')
														.val(),
												rateOfReturn : $(
														'#rateOfReturn')
														.val(),
												salaryEscalationRate : $(
														'#annualGrowthRate')
														.val(),
												emailAddress: $(
													'#emailAddress')
													.val(),
												phoneNumber: $(
													'#phoneNumber')
													.val(),
												inflationRate : $(
														'#inflationRate')
														.val(),
												yearsToProject : parseFloat($(
														'#ageTo').val())
														- parseFloat($(
																'#yourAge')
																.val())
											},
											dataType : 'json',
											success : function(json) {
												stop_wait();
                                                json = $.parseJSON(json.data);
												if (json.success) {
													$('.results').removeClass('hide');
													$('#projectedROR').html(format_no(json.projectedROR));
													$('#projectedContrs').html(format_no(json.projectedContrs));
													$('#projectedMonthlyContrs').html(format_no(json.projectedMonthlyContrs));
												} else {
													bootbox
															.alert(json.message);
												}
											}
										});

							});

					$('#form-login')
							.bootstrapValidator(
									{
										message : 'This value is not valid',
										feedbackIcons : {
											valid : 'glyphicon glyphicon-ok',
											invalid : 'glyphicon glyphicon-remove',
											validating : 'glyphicon glyphicon-refresh'
										},
								        excluded: ':disabled',
										fields : {
											username : {
												validators : {
													notEmpty : {
														message : 'Please enter your ID/Passport Number'
													}
												}
											},
											password : {
												validators : {
													notEmpty : {
														message : 'Please enter your password'
													}
												}
											}
										}
									})
							.on(
									'success.form.bv',
									function(e) {
										start_wait();
										// Prevent form submission
										e.preventDefault();
										// Get the form instance
										var btn = "btn-login";
										var form = "form-login";
										var modal = "modal-login";
										var btn_text = $('#' + btn).val();
										$
												.ajax({
													url : $('#base_url').val()
															+ 'login',
													type : 'post',
													data : {
														username : $(
																'#username')
																.val(),
														password : $(
																'#password')
																.val()
													},
													dataType : 'json',
													success : function(json) {
														stop_wait();
														console.log(json);
														if(json.success)
														{
															$("form#" + form)[0]
																.reset();
															window.location.href = $('#base_url').val() + 'admin';
														}
														if (message == null) {
															message = 'Oops! We are sorry, but something unexpected just went wrong. Please try again';
														}
														$('#' + modal).modal(
																'hide');
														$('#' + btn).val(
																btn_text);
														if (!json.success)
															bootbox
																	.alert('<p class="text-center">'
																			+ json.message
																			+ '</p>');
													}
												});
									});
					$('#form-sign-in')
							.bootstrapValidator(
									{
										message : 'This value is not valid',
										feedbackIcons : {
											valid : 'glyphicon glyphicon-ok',
											invalid : 'glyphicon glyphicon-remove',
											validating : 'glyphicon glyphicon-refresh'
										},
								        excluded: ':disabled',
										fields : {
											username : {
												validators : {
													notEmpty : {
														message : 'Please enter your ID/Passport Number'
													}
												}
											},
											password : {
												validators : {
													notEmpty : {
														message : 'Please enter your password'
													}
												}
											}
										}
									})
							.on(
									'success.form.bv',
									function(e) {
										start_wait();
										// Prevent form submission
										e.preventDefault();
										// Get the form instance
										var btn = "btn-sign-in";
										var form = "form-sign-in";
										var modal = "modal-sign-in";
										var btn_text = $('#' + btn).val();
										$
												.ajax({
													url : $('#base_url').val()
															+ 'sign-in',
													type : 'post',
													data : {
														username : $(
																'#username')
																.val(),
														password : $(
																'#password')
																.val()
													},
													dataType : 'json',
													success : function(json) {
														stop_wait();
														var message = null;
														var success = false;
														$ .each(
																		json,
																		function(key, value) {
																			if (key == 'success' && value == true) {
																				success = true;
																				$("form#" + form)[0]
																						.reset();
																				window.location.href = $(
																						'#base_url')
																						.val() + 'member';

																			}
																			if (key == 'message') {
																				message = value;
																			}
																		});
														if (message == null) {
															message = 'Oops! We are sorry, but something unexpected just went wrong. Please try again';
														}
														$('#' + modal).modal(
																'hide');
														$('#' + btn).val(
																btn_text);
														if (!success)
															bootbox
																	.alert('<p class="text-center">'
																			+ message
																			+ '</p>');
													}
												});
									});
								$('#form-sign-in-mobile')
									.bootstrapValidator(
										{
											message : 'This value is not valid',
											feedbackIcons : {
												valid : 'glyphicon glyphicon-ok',
												invalid : 'glyphicon glyphicon-remove',
												validating : 'glyphicon glyphicon-refresh'
											},
											excluded: ':disabled',
											fields : {
												username : {
													validators : {
														notEmpty : {
															message : 'Please enter your ID/Passport Number'
														}
													}
												},
												password : {
													validators : {
														notEmpty : {
															message : 'Please enter your password'
														}
													}
												}
											}
										})
									.on(
										'success.form.bv',
										function(e) {
											start_wait();
											// Prevent form submission
											e.preventDefault();
											// Get the form instance
											var btn = "btn-sign-in";
											var form = "form-sign-in";
											var modal = "modal-sign-in";
											var btn_text = $('#' + btn).val();
											$
												.ajax({
													url : $('#base_url').val()
													+ 'sign-in',
													type : 'post',
													data : {
														username : $(
															'#usernameMobile')
															.val(),
														password : $(
															'#passwordMobile')
															.val()
													},
													dataType : 'json',
													success : function(json) {
														stop_wait();
														var message = null;
														var success = false;
														$ .each(
															json,
															function(key, value) {
																if (key == 'success' && value == true) {
																	success = true;
																	$("form#" + form)[0]
																		.reset();
																	window.location.href = $(
																		'#base_url')
																		.val() + 'member';

																}
																if (key == 'message') {
																	message = value;
																}
															});
														if (message == null) {
															message = 'Oops! We are sorry, but something unexpected just went wrong. Please try again';
														}
														$('#' + modal).modal(
															'hide');
														$('#' + btn).val(
															btn_text);
														if (!success)
															bootbox
																.alert('<p class="text-center">'
																	+ message
																	+ '</p>');
													}
												});
										});

					$('#form-pensioner')
							.bootstrapValidator(
									{
										message : 'This value is not valid',
										feedbackIcons : {
											valid : 'glyphicon glyphicon-ok',
											invalid : 'glyphicon glyphicon-remove',
											validating : 'glyphicon glyphicon-refresh'
										},
								        excluded: ':disabled',
										fields : {
											pensionerIdNumber : {
												validators : {
													notEmpty : {
														message : 'Please enter your ID/Passport Number'
													}
												}
											},
											pensionerPassword : {
												validators : {
													notEmpty : {
														message : 'Please enter your password'
													},
													identical : {
														field : 'pensionerConfirmPassword',
														message : 'Your passwords must match'
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
											pensionerConfirmPassword : {
												validators : {
													notEmpty : {
														message : 'Please confirm your password'
													},
													identical : {
														field : 'pensionerPassword',
														message : 'Your passwords must match'
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
											pensionerCaptchaChars: {
												validators : {
													notEmpty : {
														message : 'Please enter the captcha characters as they appear'
													}
												}
											}
										}
									})
							.on(
									'success.form.bv',
									function(e) {
										start_wait();

										// Prevent form submission
										e.preventDefault();
										// Get the form instance
										$.ajax({

													url : $('#base_url').val()
															+ 'register',
													type : 'post',
													data : {
														type : 'EXISTING',
														category : 'PENSIONER',
														idNumber : $(
															'#pensionerIdNumber')
															.val(),
														password : $(
																'#pensionerPassword')
																.val(),
														inCaptchaChars : $(
																'#pensionerCaptchaChars')
																.val(),
														hidCaptchaID : $(
																'#hidCaptchaID')
																.val()
													},
													dataType : 'json',
													success : function(json) {
														stop_wait();
														if(json.success)
														{
															$("form#form-pensioner")[0]
																	.reset();
															setTimeout(
																	function() {
																		window.location.href = $(
																				'#base_url')
																				.val()
																				+ 'sign-in';
																	}, 5000);
														}
														bootbox
																.alert('<p class="text-center">'
																		+ json.message
																		+ '</p>');
														if(json.captcha || !json.success)
														{
															reload_captcha();
														}
													}
												});
									});

					$('#form-fm')
							.bootstrapValidator(
									{
										message : 'This value is not valid',
										feedbackIcons : {
											valid : 'glyphicon glyphicon-ok',
											invalid : 'glyphicon glyphicon-remove',
											validating : 'glyphicon glyphicon-refresh'
										},
								        excluded: ':disabled',
										fields : {
											fmIdNumber : {
												validators : {
													notEmpty : {
														message : 'Please enter your ID/Passport Number'
													}
												}
											},
											fmPassword : {
												validators : {
													notEmpty : {
														message : 'Please enter your password'
													},
													identical : {
														field : 'fmConfirmPassword',
														message : 'Your passwords must match'
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
											fmConfirmPassword : {
												validators : {
													notEmpty : {
														message : 'Please confirm your password'
													},
													identical : {
														field : 'fmPassword',
														message : 'Your passwords must match'
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
											fmCaptchaChars: {
												validators : {
													notEmpty : {
														message : 'Please enter the captcha characters as they appear'
													}
												}
											}
										}
									})
							.on(
									'success.form.bv',
									function(e) {
										start_wait();
										// Prevent form submission
										e.preventDefault();
										// Get the form instance
										$
												.ajax({
													url : $('#base_url').val()
															+ 'register',
													type : 'post',
													data : {
														type : 'EXISTING',
														category : 'FUND_MANAGER',
														idNumber : $(
																'#fmIdNumber')
																.val(),
														password : $(
																'#fmPassword')
																.val(),
														inCaptchaChars : $(
																'#fmCaptchaChars')
																.val(),
														hidCaptchaID : $(
																'#hidCaptchaID')
																.val()
													},
													dataType : 'json',
													success : function(json) {
														stop_wait();
														if(json.success)
														{
															$("form#form-fm")[0]
																	.reset();
															setTimeout(
																	function() {
																		window.location.href = $(
																				'#base_url')
																				.val()
																				+ 'admin';
																	}, 5000);
														}
														bootbox
																.alert('<p class="text-center">'
																		+ json.message
																		+ '</p>');
														if(json.captcha || !json.success)
														{
															reload_captcha();
														}
													}
												});
									});

					$('#form-crm')
							.bootstrapValidator(
									{
										message : 'This value is not valid',
										feedbackIcons : {
											valid : 'glyphicon glyphicon-ok',
											invalid : 'glyphicon glyphicon-remove',
											validating : 'glyphicon glyphicon-refresh'
										},
								        excluded: ':disabled',
										fields : {
											crmIdNumber : {
												validators : {
													notEmpty : {
														message : 'Please enter your ID/Passport Number'
													}
												}
											},
											crmPassword : {
												validators : {
													notEmpty : {
														message : 'Please enter your password'
													},
													identical : {
														field : 'crmConfirmPassword',
														message : 'Your passwords must match'
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
											crmConfirmPassword : {
												validators : {
													notEmpty : {
														message : 'Please confirm your password'
													},
													identical : {
														field : 'crmPassword',
														message : 'Your passwords must match'
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
											crmCaptchaChars: {
												validators : {
													notEmpty : {
														message : 'Please enter the captcha characters as they appear'
													}
												}
											}
										}
									})
							.on(
									'success.form.bv',
									function(e) {
										start_wait();
										// Prevent form submission
										e.preventDefault();
										// Get the form instance
										$
												.ajax({
													url : $('#base_url').val()
															+ 'register',
													type : 'post',
													data : {
														type : 'EXISTING',
														category : 'CUSTOMER_RELATIONSHIP_MANAGER',
														idNumber : $(
																'#crmIdNumber')
																.val(),
														password : $(
																'#crmPassword')
																.val(),
														inCaptchaChars : $(
																'#crmCaptchaChars')
																.val(),
														hidCaptchaID : $(
																'#hidCaptchaID')
																.val()
													},
													dataType : 'json',
													success : function(json) {
														stop_wait();
														if(json.success)
														{
															$("form#form-crm")[0]
																	.reset();
															setTimeout(
																	function() {
																		window.location.href = $(
																				'#base_url')
																				.val()
																				+ 'admin';
																	}, 5000);
														}
														bootbox
																.alert('<p class="text-center">'
																		+ json.message
																		+ '</p>');
														if(json.captcha || !json.success)
														{
															reload_captcha();
														}
													}
												});
									});

					$('#form-cre')
							.bootstrapValidator(
									{
										message : 'This value is not valid',
										feedbackIcons : {
											valid : 'glyphicon glyphicon-ok',
											invalid : 'glyphicon glyphicon-remove',
											validating : 'glyphicon glyphicon-refresh'
										},
								        excluded: ':disabled',
										fields : {
											creIdNumber : {
												validators : {
													notEmpty : {
														message : 'Please enter your ID/Passport Number'
													}
												}
											},
											crePassword : {
												validators : {
													notEmpty : {
														message : 'Please enter your password'
													},
													identical : {
														field : 'creConfirmPassword',
														message : 'Your passwords must match'
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
											creConfirmPassword : {
												validators : {
													notEmpty : {
														message : 'Please confirm your password'
													},
													identical : {
														field : 'crePassword',
														message : 'Your passwords must match'
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
											creCaptchaChars: {
												validators : {
													notEmpty : {
														message : 'Please enter the captcha characters as they appear'
													}
												}
											}
										}
									})
							.on(
									'success.form.bv',
									function(e) {
										start_wait();
										// Prevent form submission
										e.preventDefault();
										// Get the form instance
										$
												.ajax({
													url : $('#base_url').val()
															+ 'register',
													type : 'post',
													data : {
														type : 'EXISTING',
														category : 'CUSTOMER_RELATIONSHIP_MANAGER',
														idNumber : $(
																'#creIdNumber')
																.val(),
														password : $(
																'#crePassword')
																.val(),
														inCaptchaChars : $(
																'#creCaptchaChars')
																.val(),
														hidCaptchaID : $(
																'#hidCaptchaID')
																.val()
													},
													dataType : 'json',
													success : function(json) {
														stop_wait();
														if(json.success)
														{
															$("form#form-cre")[0]
																	.reset();
															setTimeout(
																	function() {
																		window.location.href = $(
																				'#base_url')
																				.val()
																				+ 'admin';
																	}, 5000);
														}
														bootbox
																.alert('<p class="text-center">'
																		+ json.message
																		+ '</p>');
														if(json.captcha || !json.success)
														{
															reload_captcha();
														}
													}
												});
									});

					$('#form-custodian')
							.bootstrapValidator(
									{
										message : 'This value is not valid',
										feedbackIcons : {
											valid : 'glyphicon glyphicon-ok',
											invalid : 'glyphicon glyphicon-remove',
											validating : 'glyphicon glyphicon-refresh'
										},
								        excluded: ':disabled',
										fields : {
											custodianIdNumber : {
												validators : {
													notEmpty : {
														message : 'Please enter your ID/Passport Number'
													}
												}
											},
											custodianPassword : {
												validators : {
													notEmpty : {
														message : 'Please enter your password'
													},
													identical : {
														field : 'custodianConfirmPassword',
														message : 'Your passwords must match'
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
											custodianConfirmPassword : {
												validators : {
													notEmpty : {
														message : 'Please confirm your password'
													},
													identical : {
														field : 'custodianPassword',
														message : 'Your passwords must match'
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
											custodianCaptchaChars: {
												validators : {
													notEmpty : {
														message : 'Please enter the captcha characters as they appear'
													}
												}
											}
										}
									})
							.on(
									'success.form.bv',
									function(e) {
										start_wait();
										// Prevent form submission
										e.preventDefault();
										// Get the form instance
										$
												.ajax({
													url : $('#base_url').val()
															+ 'register',
													type : 'post',
													data : {
														type : 'EXISTING',
														category : 'CUSTODIAN',
														idNumber : $(
																'#custodianIdNumber')
																.val(),
														password : $(
																'#custodianPassword')
																.val(),
														inCaptchaChars : $(
																'#custodianCaptchaChars')
																.val(),
														hidCaptchaID : $(
																'#hidCaptchaID')
																.val()
													},
													dataType : 'json',
													success : function(json) {
														stop_wait();
														if(json.success)
														{
															$("form#form-custodian")[0]
																	.reset();
															setTimeout(
																	function() {
																		window.location.href = $(
																				'#base_url')
																				.val()
																				+ 'admin';
																	}, 5000);
														}
														bootbox
																.alert('<p class="text-center">'
																		+ json.message
																		+ '</p>');
														if(json.captcha || !json.success)
														{
															reload_captcha();
														}
													}
												});
									});

					$('#form-agent')
							.bootstrapValidator(
									{
										message : 'This value is not valid',
										feedbackIcons : {
											valid : 'glyphicon glyphicon-ok',
											invalid : 'glyphicon glyphicon-remove',
											validating : 'glyphicon glyphicon-refresh'
										},
								        excluded: ':disabled',
										fields : {
											agentIdNumber : {
												validators : {
													notEmpty : {
														message : 'Please enter your ID/Passport Number'
													}
												}
											},
											agentPassword : {
												validators : {
													notEmpty : {
														message : 'Please enter your password'
													},
													identical : {
														field : 'agentConfirmPassword',
														message : 'Your passwords must match'
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
											agentConfirmPassword : {
												validators : {
													notEmpty : {
														message : 'Please confirm your password'
													},
													identical : {
														field : 'agentPassword',
														message : 'Your passwords must match'
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
											agentCaptchaChars: {
												validators : {
													notEmpty : {
														message : 'Please enter the captcha characters as they appear'
													}
												}
											}
										}
									})
							.on(
									'success.form.bv',
									function(e) {
										start_wait();
										// Prevent form submission
										e.preventDefault();
										// Get the form instance
										$
												.ajax({
													url : $('#base_url').val()
															+ 'register',
													type : 'post',
													data : {
														type : 'EXISTING',
														category : 'AGENT',
														idNumber : $(
																'#agentIdNumber')
																.val(),
														password : $(
																'#agentPassword')
																.val(),
														inCaptchaChars : $(
																'#agentCaptchaChars')
																.val(),
														hidCaptchaID : $(
																'#hidCaptchaID')
																.val()
													},
													dataType : 'json',
													success : function(json) {
														stop_wait();
														if(json.success)
														{
															$("form#form-agent")[0]
																	.reset();
															setTimeout(
																	function() {
																		window.location.href = $(
																				'#base_url')
																				.val()
																				+ 'admin';
																	}, 5000);
														}
														bootbox
																.alert('<p class="text-center">'
																		+ json.message
																		+ '</p>');
														if(json.captcha || !json.success)
														{
															reload_captcha();
														}
													}
												});
									});

					$('#form-trustee')
							.bootstrapValidator(
									{
										message : 'This value is not valid',
										feedbackIcons : {
											valid : 'glyphicon glyphicon-ok',
											invalid : 'glyphicon glyphicon-remove',
											validating : 'glyphicon glyphicon-refresh'
										},
								        excluded: ':disabled',
										fields : {
											trusteeIdNumber : {
												validators : {
													notEmpty : {
														message : 'Please enter your ID/Passport Number'
													}
												}
											},
											trusteePassword : {
												validators : {
													notEmpty : {
														message : 'Please enter your password'
													},
													identical : {
														field : 'trusteeConfirmPassword',
														message : 'Your passwords must match'
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
											trusteeConfirmPassword : {
												validators : {
													notEmpty : {
														message : 'Please confirm your password'
													},
													identical : {
														field : 'trusteePassword',
														message : 'Your passwords must match'
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
											trusteeCaptchaChars: {
												validators : {
													notEmpty : {
														message : 'Please enter the captcha characters as they appear'
													}
												}
											}
										}
									})
							.on(
									'success.form.bv',
									function(e) {
										start_wait();
										// Prevent form submission
										e.preventDefault();
										// Get the form instance
										$
												.ajax({
													url : $('#base_url').val()
															+ 'register',
													type : 'post',
													data : {
														type : 'EXISTING',
														category : 'TRUSTEE',
														idNumber : $(
																'#trusteeIdNumber')
																.val(),
														password : $(
																'#trusteePassword')
																.val(),
														inCaptchaChars : $(
																'#trusteeCaptchaChars')
																.val(),
														hidCaptchaID : $(
																'#hidCaptchaID')
																.val()
													},
													dataType : 'json',
													success : function(json) {
														stop_wait();
														if(json.success)
														{
															$("form#form-trustee")[0]
																	.reset();
															setTimeout(
																	function() {
																		window.location.href = $(
																				'#base_url')
																				.val()
																				+ 'admin';
																	}, 5000);
														}
														bootbox
																.alert('<p class="text-center">'
																		+ json.message
																		+ '</p>');
														if(json.captcha || !json.success)
														{
															reload_captcha();
														}
													}
												});
									});

					$('#form-sponsor-existing')
							.bootstrapValidator(
									{
										message : 'This value is not valid',
										feedbackIcons : {
											valid : 'glyphicon glyphicon-ok',
											invalid : 'glyphicon glyphicon-remove',
											validating : 'glyphicon glyphicon-refresh'
										},
								        excluded: ':disabled',
										fields : {
											sponsorIdNumber : {
												validators : {
													notEmpty : {
														message : 'Please enter your ID/Passport Number'
													}
												}
											},
											sponsorPassword : {
												validators : {
													notEmpty : {
														message : 'Please enter your password'
													},
													identical : {
														field : 'sponsorConfirmPassword',
														message : 'Your passwords must match'
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
											sponsorConfirmPassword : {
												validators : {
													notEmpty : {
														message : 'Please confirm your password'
													},
													identical : {
														field : 'sponsorPassword',
														message : 'Your passwords must match'
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
											sponsorCaptchaChars: {
												validators : {
													notEmpty : {
														message : 'Please enter the captcha characters as they appear'
													}
												}
											}
										}
									})
							.on(
									'success.form.bv',
									function(e) {
										start_wait();
										// Prevent form submission
										e.preventDefault();
										// Get the form instance
										$
												.ajax({
													url : $('#base_url').val()
															+ 'register',
													type : 'post',
													data : {
														type : 'EXISTING',
														category : 'SPONSOR',
														idNumber : $(
																'#sponsorIdNumber')
																.val(),
														password : $(
																'#sponsorPassword')
																.val(),
														inCaptchaChars : $(
																'#sponsorCaptchaChars')
																.val(),
														hidCaptchaID : $(
																'#hidCaptchaID')
																.val()
													},
													dataType : 'json',
													success : function(json) {
														stop_wait();
														if(json.success)
                                                        {
                                                            if (isNaN(($('#sponsorIdNumber').val()))){

                                                                $("form#form-sponsor-existing")[0]
                                                                    .reset();
                                                                setTimeout(
                                                                    function() {
                                                                        window.location.href = $(
                                                                            '#base_url')
                                                                                .val()
                                                                            + 'admin';
                                                                    }, 5000);

                                                            }else{

                                                                $("form#form-sponsor-existing")[0]
                                                                    .reset();
                                                                setTimeout(
                                                                    function() {
                                                                        window.location.href = $(
                                                                            '#base_url')
                                                                                .val()
                                                                            + 'activate-account';
                                                                    }, 5000);

                                                            }


                                                        }
														bootbox
																.alert('<p class="text-center">'
																		+ json.message
																		+ '</p>');
														if(json.captcha || !json.success)
														{
															reload_captcha();
														}
													}
												});
									});
					function reload_captcha()
					{
						/* Reload Captcha */
						var d = new Date();
						var img = $("<img />").attr('src', $('#base_url').val() + 'captcha?'+d.getTime())
					    .load(function() {
					        if (!this.complete || typeof this.naturalWidth == "undefined" || this.naturalWidth == 0) {
					            alert('broken image!');
					        } else {
					        	$(".CaptchaImage").empty().append(img);
					        }
					    });
					}
					$('#form-admin')
							.bootstrapValidator(
									{
										message : 'This value is not valid',
										feedbackIcons : {
											valid : 'glyphicon glyphicon-ok',
											invalid : 'glyphicon glyphicon-remove',
											validating : 'glyphicon glyphicon-refresh'
										},
								        excluded: ':disabled',
										fields : {
											adminIdNumber : {
												validators : {
													notEmpty : {
														message : 'Please enter your ID/Passport Number'
													}
												}
											},
											adminPassword : {
												validators : {
													notEmpty : {
														message : 'Please enter your password'
													},
													identical : {
														field : 'adminConfirmPassword',
														message : 'Your passwords must match'
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
											adminConfirmPassword : {
												validators : {
													notEmpty : {
														message : 'Please confirm your password'
													},
													identical : {
														field : 'adminPassword',
														message : 'Your passwords must match'
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
											adminCaptchaChars: {
												validators : {
													notEmpty : {
														message : 'Please enter the captcha characters as they appear'
													}
												}
											}
										}
									})
							.on(
									'success.form.bv',
									function(e) {
										start_wait();
										// Prevent form submission
										e.preventDefault();
										// Get the form instance
										$
												.ajax({
													url : $('#base_url').val()
															+ 'register',
													type : 'post',
													data : {
														type : 'EXISTING',
														category : 'ADMINISTRATOR',
														idNumber : $(
																'#adminIdNumber')
																.val(),
														password : $(
																'#adminPassword')
																.val(),
														inCaptchaChars : $(
																'#adminCaptchaChars')
																.val(),
														hidCaptchaID : $(
																'#hidCaptchaID')
																.val()
													},
													dataType : 'json',
													success : function(json) {
														stop_wait();
                                                        if(json.success)
                                                        {
                                                            if (isNaN(($('#adminIdNumber').val()))){

                                                                $("form#form-admin")[0]
                                                                    .reset();
                                                                setTimeout(
                                                                    function() {
                                                                        window.location.href = $(
                                                                            '#base_url')
                                                                                .val()
                                                                            + 'admin';
                                                                    }, 5000);

                                                            }else{

                                                                $("form#form-admin")[0]
                                                                    .reset();
                                                                setTimeout(
                                                                    function() {
                                                                        window.location.href = $(
                                                                            '#base_url')
                                                                                .val()
                                                                            + 'activate-account';
                                                                    }, 5000);

                                                            }


                                                        }
														bootbox.alert('<p class="text-center">'
																		+ json.message
																		+ '</p>');
														if(json.captcha || !json.success)
														{
															reload_captcha();
														}
													}
												});
									});

					$('#form-member')
							.bootstrapValidator(
									{
										message : 'This value is not valid',
										feedbackIcons : {
											valid : 'glyphicon glyphicon-ok',
											invalid : 'glyphicon glyphicon-remove',
											validating : 'glyphicon glyphicon-refresh'
										},
								        excluded: ':disabled',
										fields : {
											eMIdNumber : {
												validators : {
													notEmpty : {
														message : 'Please enter your ID/Passport Number'
													}
												}
											},
											eMPassword : {
												validators : {
													notEmpty : {
														message : 'Please enter your password'
													},
													identical : {
														field : 'eMConfirmPassword',
														message : 'Your passwords must match'
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
											eMConfirmPassword : {
												validators : {
													notEmpty : {
														message : 'Please confirm your password'
													},
													identical : {
														field : 'eMPassword',
														message : 'Your passwords must match'
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
											eMCaptchaChars : {
												validators : {
													notEmpty : {
														message : 'Please enter the captcha characters as they appear'
													}
												}
											}
										}
									})
							.on(
									'success.form.bv',
									function(e) {
										start_wait();
										// Prevent form submission
										e.preventDefault();
										// Get the form instance
										$
												.ajax({
													url : $('#base_url').val()
															+ 'register',
													type : 'post',
													data : {
														type : 'EXISTING',
														category : 'MEMBER',

														idNumber : $(
																'#eMIdNumber')
																.val(),
														password : $(
																'#eMPassword')
																.val(),
														inCaptchaChars : $(
																'#eMCaptchaChars')
																.val(),
														hidCaptchaID : $(
																'#hidCaptchaID')
																.val()
													},
													dataType : 'json',
													success : function(json) {
														stop_wait();
														if(json.success)
														{
															if (isNaN(($('#eMIdNumber').val()))){

                                                                $("form#form-member")[0]
                                                                    .reset();
                                                                setTimeout(
                                                                    function() {
                                                                        window.location.href = $(
                                                                            '#base_url')
                                                                                .val()
                                                                            + 'sign-in';
                                                                    }, 5000);

                                                            }else{

                                                                $("form#form-member")[0]
                                                                    .reset();
                                                                setTimeout(
                                                                    function() {
                                                                        window.location.href = $(
                                                                            '#base_url')
                                                                                .val()
                                                                            + 'activate-account';
                                                                    }, 5000);

															}


														}
														bootbox
																.alert('<p class="text-center">'
																		+ json.message
																		+ '</p>');
														if(json.captcha || !json.success)
														{
															reload_captcha();
														}
													}
												});
									});

					$('#form-send-email')
							.bootstrapValidator(
									{
										message : 'This value is not valid',
										feedbackIcons : {
											valid : 'glyphicon glyphicon-ok',
											invalid : 'glyphicon glyphicon-remove',
											validating : 'glyphicon glyphicon-refresh'
										},
								        excluded: ':disabled',
										fields : {
											subject : {
												validators : {
													notEmpty : {
														message : 'Please enter a subject (Why are you emailing us?)'
													}
												}
											},
											message : {
												validators : {
													notEmpty : {
														message : 'Please enter a message to send'
													}
												}
											}
										}
									})
							.on(
									'success.form.bv',
									function(e) {
										start_wait();
										// Prevent form submission
										e.preventDefault();
										var btn = "btn-send-email";
										var form = "form-send-email";
										var modal = "modal-send-email";

										$('#' + btn).val('Please wait...');

										var formData = new FormData($(this)[0]);

										$
												.ajax({
													url : $('#base_url').val()
															+ 'admin',
													type : 'POST',
													data : formData,
													async : false,
													dataType : 'json',
													success : function(json) {
														stop_wait();
														var html = null;
														if (json.success) {
															$('#' + form)[0]
																	.reset();
															$('#' + modal)
																	.modal(
																			'hide');
															html = 'Email has been successfully sent';
														} else
															html = 'Sorry, the email could not be sent';
														bootbox.alert(html);
													},
													cache : false,
													contentType : false,
													processData : false
												});

									});

					$('#dateOfBirth')
			        .datetimepicker({
			        	 language:  'en',
			             weekStart: 1,
			             todayBtn:  1,
			             autoclose: 1,
			             todayHighlight: 1,
			             startView: 2,
			             minView: 2,
			             forceParse: 0,
			             format: 'dd-mm-yyyy'
			        })
			        .on('changeDate', function(e) {
			            // Revalidate the date field
			            $('#form-register').bootstrapValidator('revalidateField', 'dateOfBirth');
			        });
					$('#form-register')
							.bootstrapValidator(
									{
										message : 'This value is not valid',
										feedbackIcons : {
											valid : 'glyphicon glyphicon-ok',
											invalid : 'glyphicon glyphicon-remove',
											validating : 'glyphicon glyphicon-refresh'
										},
								        excluded: ':disabled',
										fields : {
											firstName : {
												validators : {
													notEmpty : {
														message : 'Sorry, your first name is required'
													},
													regexp : {
														regexp : /^[a-z\s]+$/i,
														message : 'Sorry, your first name can only consist of alphabetical letters & spaces'
													}
												}
											},
											lastName : {
												validators : {
													notEmpty : {
														message : 'Sorry, your last name is required'
													},
													regexp : {
														regexp : /^[a-z\s]+$/i,
														message : 'Sorry, your last name can only consist of alphabetical letters & spaces'
													}
												}
											},
											dateOfBirth : {
												validators : {
													notEmpty : {
														message : 'Sorry, your date of birth is required'
													}
												}
											},
											emailAddress : {
												validators : {
													notEmpty : {
														message : 'Sorry, your email address is required'
													},
													emailAddress : {
														message : 'Oops! This doesn\'t look like a valid email address'
													}
												}
											},
											phoneNumber : {
												validators : {
													notEmpty : {
														message : 'Sorry, your phone number is required'
													}
												}
											},
											residentialAddress : {
												validators : {
													notEmpty : {
														message : 'Sorry, your residential address is required'
													}
												}
											},
											city : {
												validators : {
													notEmpty : {
														message : 'Sorry, please tell us your home town'
													}
												}
											},
											country : {
												validators : {
													notEmpty : {
														message : 'Sorry, your country is required'
													}
												}
											},
											IdNumber : {
												validators : {
													notEmpty : {
														message : 'Sorry, your ID/Passport number is required'
													}
												}
											},
											gender : {
												validators : {
													notEmpty : {
														message : 'Sorry, please select your gender'
													}
												}
											},
											maritalStatus : {
												validators : {
													notEmpty : {
														message : 'Sorry, please select your marital status'
													}
												}
											},
											pension_scheme : {
												validators : {
													notEmpty : {
														message : 'Sorry, please select your prefered pension scheme'
													}
												}
											},
											memberCaptchaChars : {
												validators : {
													notEmpty : {
														message : 'Please enter the characters as they appear'
													}
												}
											}
										}
									})
							.on(
									'success.form.bv',
									function(e) {
										start_wait();
										// Prevent form submission
										e.preventDefault();
										// Get the form instance
										$
												.ajax({
													url : $('#base_url').val()
															+ 'register',
													type : 'post',
													data : {
														city : $('#city').val(),
														country : $('#country')
																.val(),
														dateOfBirth : $(
																'#dateOfBirth')
																.val(),
														emailAddress : $(
																'#emailAddress')
																.val(),
														firstName : $(
																'#firstName')
																.val(),
														lastName : $(
																'#lastName')
																.val(),
														otherName : $(
																'#otherName')
																.val(),
														gender : $('#gender')
																.val(),
														idNumber : $(
																'#IdNumber')
																.val(),
														maritalStatus : $(
																'#maritalStatus')
																.val(),
														memberPassword : $(
																'#memberPassword')
																.val(),
														pension_scheme : $(
																'#pension_scheme')
																.val(),
														phoneNumber : $(
																'#phoneNumber')
																.val(),
														residentialAddress : $(
																'#residentialAddress')
																.val(),
														type : 'member',
														inCaptchaChars : $(
														'#memberCaptchaChars')
														.val(),

													},
													dataType : 'json',
													success : function(json) {
														stop_wait();
														if(json.success)
														{
															$("form#form-register")[0]
																	.reset();
															setTimeout(
																	function() {
																		window.location.href = $(
																				'#base_url')
																				.val();
																	}, 5000);
														}
														bootbox
																.alert('<p class="text-center">'
																		+ json.message
																		+ '</p>');
														if(json.captcha || !json.success)
														{
															reload_captcha();
														}
													}
												});

									});
					$('#form-annuity-quotation')
							.bootstrapValidator(
									{
										message : 'This value is not valid',
										feedbackIcons : {
											valid : 'glyphicon glyphicon-ok',
											invalid : 'glyphicon glyphicon-remove',
											validating : 'glyphicon glyphicon-refresh'
										},
								        excluded: ':disabled',
										fields : {
											
											/*fullName : {
												validators : {
													notEmpty : {
														message : 'Sorry, your name is required'
													},
													regexp : {
														regexp : /^[a-z\s]+$/i,
														message : 'Sorry, your name can only consist of alphabetical letters & spaces'
													}
												}
											},*/

											firstName : {
												validators : {
													notEmpty : {
														message : 'Sorry, your first name is required'
													}
												}
											},

											lastName : {
												validators : {
													notEmpty : {
														message : 'Sorry, your last name is required'
													}
												}
											},

											dateOfBirth : {
												validators : {
													notEmpty : {
														message : 'Sorry, your date of birth is required'
													}
												}
											},

											emailAddress : {
												validators : {
													notEmpty : {
														message : 'Sorry, your email address is required'
													},
													emailAddress : {
														message : 'Oops! This doesn\'t look like a valid email address'
													}
												}
											},
											phoneNumber : {
												validators : {
													notEmpty : {
														message : 'Sorry, your phone number is required'
													}
												}
											},
											residentialAddress : {
												validators : {
													notEmpty : {
														message : 'Sorry, your residential address is required'
													}
												}
											},
											city : {
												validators : {
													notEmpty : {
														message : 'Sorry, please tell us your home town'
													}
												}
											},
											country : {
												validators : {
													notEmpty : {
														message : 'Sorry, your country is required'
													}
												}
											},
											idNumber : {
												validators : {
													notEmpty : {
														message : 'Sorry, your ID/Passport number is required'
													}
												}
											},
											gender : {
												validators : {
													notEmpty : {
														message : 'Sorry, please select your gender'
													}
												}
											},
											maritalStatus : {
												validators : {
													notEmpty : {
														message : 'Sorry, please select your marital status'
													}
												}
											},
											paymentFrequency : {
												validators : {
													notEmpty : {
														message : 'Payment frequency must be selected'
													}
												}
											},
											purchaseDate : {
												validators : {
													notEmpty : {
														message : 'Sorry, please enter the purchase date'
													}
												}
											},
											paymentMode : {
												validators : {
													notEmpty : {
														message : 'Please select the paymnet mode'
													}
												}
											},
											spouseReversal : {
												validators : {
													notEmpty : {
														message : 'Please enter the spouse reversal value'
													}
												}
											},

											displayable : {
												validators : {
													notEmpty : {
														message : 'Please enter the displayable value'
													}
												}
											},

											commencementDate : {
												validators : {
													notEmpty : {
														message : 'Please select the commencement date'
													}
												}
											},
											unRegPurchasePrice : {
												validators : {
													notEmpty : {
														message : 'Please enter the un registered purchase price'
													},
													numeric: {
														message: 'Unregistered purchase price must be numeric'
													}
												}
											},
											purchasePrice : {
												validators : {
													notEmpty : {
														message : 'Please enter the registered purchase price'
													},
													numeric: {
														message: 'Registered purchase price must be numeric'
													}
												}
											},
											targetPension : {
												validators : {
													notEmpty : {
														message : 'Please enter the target pension'
													},
													numeric: {
														message: 'Target pension must be numeric'
													}
												}
											},
											/* Between 1 and 99  (Years)*/
											guaranteePeriod : {
												validators : {
													notEmpty : {
														message : 'Please select a paymnet mode'
													},
													between: {
							                            min: 1,
							                            max: 99,
							                            message: 'The guarantee period can only be between 1 and 99'
							                        }
												}
											},
											/* Between 0 and 100  (Percent)*/
											annualPensionIncrease : {
												validators : {
													notEmpty : {
														message : 'The annual pension increase is required'
													},
													between: {
							                            min: 0,
							                            max: 100,
							                            message: 'The annual pension increase is a percentage and can only be between 0 and 100'
							                        }
												}
											},
											annuityProduct : {
												validators : {
													notEmpty : {
														message : 'The annuity product is required'
													}
												}
											},
											calculationMode : {
												validators : {
													notEmpty : {
														message : 'The calculation mode is required'
													}
												}
											}
										}
									})
							.on(
									'success.form.bv',
									function(e) {
										start_wait();
										// Prevent form submission
										e.preventDefault();
										// Get the form instance
										$
												.ajax({
													url : $('#base_url').val()
															+ 'annuity-quotation',
													type : 'post',
													data : {
														registeredPurchasePrice : $(
																'#purchasePrice')
																.val(),
														annualPensionIncrease : $(
																'#annualPensionIncrease')
																.val(),
														annuityMode : $(
																'#annuityMode')
																.val(),
														annuityProduct : $(
																'#annuityProduct')
																.val(),
														city : $('#city').val(),
														commencementDate : $(
																'#commencementDate')
																.val(),
														country : $('#country')
																.val(),
														dateOfBirth : $(
																'#dateOfBirth')
																.val(),
														emailAddress : $(
																'#emailAddress')
																.val(),

														/*fullName : $(
																'#fullName')
																.val(),*/

														firstName : $(
																'#firstName')
																.val(),

														lastName : $(
																'#lastName')
																.val(),

														otherNames : $(
																'#otherNames')
																.val(),

														gender : $('#gender')
																.val(),
														guaranteePeriod : $(
																'#guaranteePeriod')
																.val(),
														idNumber : $(
																'#idNumber')
																.val(),
														maritalStatus : $(
																'#maritalStatus')
																.val(),
														paymentFrequency : $(
																'#paymentFrequency')
																.val(),
														paymentMode : $(
																'#paymentMode')
																.val(),
														phoneNumber : $(
																'#phoneNumber')
																.val(),
														purchaseDate : $(
																'#purchaseDate')
																.val(),
														residentialAddress : $(
																'#residentialAddress')
																.val(),
														spouseDateOfBirth : $(
																'#spouseDateOfBirth')
																.val(),
														spouseGender : $(
																'#spouseGender')
																.val(),
														spouseReversal: $('#spouseReversal').val(),
														displayable: $('#displayable').val(),
														calculationMode: $('#calculationMode').val(),
														targetPension: $('#targetPension').val(),
														unRegPurchasePrice: $('#unRegPurchasePrice').val()
													},
													dataType : 'json',
													success : function(json) {
														stop_wait();
														if($('#calculationMode').val() == "0")
														{
															$('#results').html('<tr><td><h3>MONTHLY: ' + format_no(json.annuityMonth) + '</h3></td><td><h3>QUARTERLY: ' + format_no(json.annuityQuartely) + '</h3></td><td><h3>ANNUALLY: ' + format_no(json.annuityAnnual) + '</h3></td></tr>');
														}
														else if($('#calculationMode').val() == "1")
														{
															$('#results').html('<tr><td><h3>PURCHASE PRICE: ' + format_no(json.regPurchasePrice) + '</h3></td></tr>');
														}
													}
												});

									});

					$('#form-new-member')
					.bootstrapValidator(
							{
								message : 'This value is not valid',
								feedbackIcons : {
									valid : 'glyphicon glyphicon-ok',
									invalid : 'glyphicon glyphicon-remove',
									validating : 'glyphicon glyphicon-refresh'
								},
								excluded : ':disabled',
								fields : {
									firstName : {
										validators : {
											notEmpty : {
												message : 'Sorry, your first name is required'
											},
											regexp : {
												regexp : /^[a-z\s]+$/i,
												message : 'Sorry, your first name can only consist of alphabetical letters & spaces'
											}
										}
									},
									lastName : {
										validators : {
											notEmpty : {
												message : 'Sorry, your last name is required'
											},
											regexp : {
												regexp : /^[a-z\s]+$/i,
												message : 'Sorry, your last name can only consist of alphabetical letters & spaces'
											}
										}
									},
									dateOfBirth : {
										validators : {
											notEmpty : {
												message : 'Sorry, your date of birth is required'
											}
										}
									},
									emailAddress : {
										validators : {
											notEmpty : {
												message : 'Sorry, your email address is required'
											},
											emailAddress : {
												message : 'Oops! This doesn\'t look like a valid email address'
											}
										}
									},
									phoneNumber : {
										validators : {
											notEmpty : {
												message : 'Sorry, your phone number is required'
											}
										}
									},
									residentialAddress : {
										validators : {
											notEmpty : {
												message : 'Sorry, your residential address is required'
											}
										}
									},
									city : {
										validators : {
											notEmpty : {
												message : 'Sorry, please tell us your home town'
											}
										}
									},
									country : {
										validators : {
											notEmpty : {
												message : 'Sorry, your country is required'
											}
										}
									},
									IdNumber : {
										validators : {
											notEmpty : {
												message : 'Sorry, your ID/Passport number is required'
											}
										}
									},
									gender : {
										validators : {
											notEmpty : {
												message : 'Sorry, please select your gender'
											}
										}
									},
									maritalStatus : {
										validators : {
											notEmpty : {
												message : 'Sorry, please select your marital status'
											}
										}
									},
									pension_scheme : {
										validators : {
											notEmpty : {
												message : 'Sorry, please select your prefered pension scheme'
											}
										}
									}
								}
							})
					.on(
							'success.form.bv',
							function(e) {
								start_wait();
								// Prevent form submission
								e.preventDefault();

								 var form = "form-new-member";

								// Get the form instance
								$
										.ajax({
											url : $('#base_url')
													.val()
													+ 'potential-member',
											type : 'post',
											data : { ACTION: 'ADD_MEMBER',
												city : $('#city')
														.val(),
												country : $(
														'#country')
														.val(),
												dateOfBirth : $(
														'#dateOfBirth')
														.val(),
												emailAddress : $(
														'#emailAddress')
														.val(),
												firstName : $(
														'#firstName')
														.val(),
												lastName : $(
														'#lastName')
														.val(),
												otherName : $(
														'#otherName')
														.val(),
												gender : $(
														'#gender')
														.val(),
												idNumber : $(
														'#IdNumber')
														.val(),
												maritalStatus : $(
														'#maritalStatus')
														.val(),
												memberPassword : $(
														'#memberPassword')
														.val(),
												pension_scheme : $(
														'#pension_scheme')
														.val(),
												phoneNumber : $(
														'#phoneNumber')
														.val(),
												residentialAddress : $(
														'#residentialAddress')
														.val(),
												scheme : $(
														'#pension_scheme')
														.val(),
												type : 'member'

											},
											dataType : 'json',
											success : function(json) {
												stop_wait();
												if (json.success) {
													$('#' + form)[0].reset();
													setTimeout(
															function() {
																window.location.href = $(
																		'#base_url')
																		.val();
															}, 5000);
												}
												bootbox
														.alert('<p class="text-center">'
																+ json.message
																+ '</p>');

												load_dashboard(1, 0);
												$('.modal-backdrop')
														.remove();
											}
										});

							});

					$('#form-new-sponsor')
					.bootstrapValidator(
							{
								message : 'This value is not valid',
								feedbackIcons : {
									valid : 'glyphicon glyphicon-ok',
									invalid : 'glyphicon glyphicon-remove',
									validating : 'glyphicon glyphicon-refresh'
								},
						        excluded: ':disabled',
								fields : {
									companyName : {
										validators : {
											notEmpty : {
												message : 'Sorry, company name is required'
											},
											regexp : {
												regexp : /^[a-z\s]+$/i,
												message : 'Sorry, company name can only consist of alphabetical letters & spaces'
											}
										}
									},
									companyApplicationDate : {
										validators : {
											notEmpty : {
												message : 'Sorry, the application date is required'
											}
										}
									},
									companyEmail : {
										validators : {
											notEmpty : {
												message : 'Sorry, company email address is required'
											},
											emailAddress : {
												message : 'Oops! This doesn\'t look like a valid email address'
											}
										}
									},
									companyPhone : {
										validators : {
											notEmpty : {
												message : 'Sorry, the phone number is required'
											}
										}
									},
									companyAddress : {
										validators : {
											notEmpty : {
												message : 'Sorry, the company address is required'
											}
										}
									},
									companyCity : {
										validators : {
											notEmpty : {
												message : 'Sorry, the company town or city is required'
											}
										}
									},
									companyCountry : {
										validators : {
											notEmpty : {
												message : 'Sorry, the company country is required'
											}
										}
									},
									pinNumber : {
										validators : {
											notEmpty : {
												message : 'Sorry, the company PIN number is required'
											}
										}
									},
									sector : {
										validators : {
											notEmpty : {
												message : 'Sorry, please select the company sector'
											}
										}
									},
									employerNumber : {
										validators : {
											notEmpty : {
												message : 'Sorry, the company\'s employer number is required'
											}
										}
									},
									pension_scheme : {
										validators : {
											notEmpty : {
												message : 'Sorry, please select your prefered pension scheme'
											}
										}
									}
								}
							})
					.on(
							'success.form.bv',
							function(e) {
								start_wait();
								// Prevent form submission
								e.preventDefault();

								var form = "form-new-sponsor";

								// Get the form instance
								$
										.ajax({
											url : $('#base_url').val()
													+ 'potential-sponsor',
											type : 'post',
											data : {
												ACTION: 'ADD_SPONSOR',
												name: $('#companyName').val(),
												applicationDate: $('#companyApplicationDate').val(),
												pinNo: $('#pinNumber').val(),
												employerNo: $('#employerNumber').val(),
												sector: $('#sector').val(),
												email: $('#companyEmail').val(),
												phone: $('#companyPhone').val(),
												address: $('#companyAddress').val(),
												city: $('#companyCity').val(),
												country: $('#companyCountry').val(),
												scheme: $('#pension_scheme').val(),
												type : 'sponsor'
											}

												,
											dataType : 'json',
											/*success : function(json) {
												stop_wait();
												if(json.success)
												{
													$("form#form-sponsor")[0]
															.reset();
													setTimeout(
															function() {
																window.location.href = $(
																		'#base_url')
																		.val();
															}, 5000);
												}
												bootbox
														.alert('<p class="text-center">'
																+ json.message
																+ '</p>');

											}*/

												success : function(json) {
													stop_wait();
													if (json.success) {
														$('#' + form)[0].reset();
														setTimeout(
																function() {
																	window.location.href = $(
																			'#base_url')
																			.val();
																}, 5000);
													}
													bootbox
															.alert('<p class="text-center">'
																	+ json.message
																	+ '</p>');

													load_dashboard(1, 0);
													$('.modal-backdrop')
															.remove();
												}
										});

							});


					$('#companyApplicationDate')
			        .datetimepicker({
			        	 language:  'en',
			             weekStart: 1,
			             todayBtn:  1,
			             autoclose: 1,
			             todayHighlight: 1,
			             startView: 2,
			             minView: 2,
			             forceParse: 0,
			             format: 'dd-mm-yyyy'
			        })
			        .on('changeDate', function(e) {
			            // Revalidate the date field
			            $('#form-sponsor').bootstrapValidator('revalidateField', 'companyApplicationDate');
			        });
					$('#form-sponsor')
							.bootstrapValidator(
									{
										message : 'This value is not valid',
										feedbackIcons : {
											valid : 'glyphicon glyphicon-ok',
											invalid : 'glyphicon glyphicon-remove',
											validating : 'glyphicon glyphicon-refresh'
										},
								        excluded: ':disabled',
										fields : {
											companyName : {
												validators : {
													notEmpty : {
														message : 'Sorry, company name is required'
													},
													regexp : {
														regexp : /^[a-z\s]+$/i,
														message : 'Sorry, company name can only consist of alphabetical letters & spaces'
													}
												}
											},
											companyApplicationDate : {
												validators : {
													notEmpty : {
														message : 'Sorry, the application date is required'
													}
												}
											},
											companyEmail : {
												validators : {
													notEmpty : {
														message : 'Sorry, company email address is required'
													},
													emailAddress : {
														message : 'Oops! This doesn\'t look like a valid email address'
													}
												}
											},
											companyPhone : {
												validators : {
													notEmpty : {
														message : 'Sorry, the phone number is required'
													}
												}
											},
											companyAddress : {
												validators : {
													notEmpty : {
														message : 'Sorry, the company address is required'
													}
												}
											},
											companyCity : {
												validators : {
													notEmpty : {
														message : 'Sorry, the company town or city is required'
													}
												}
											},
											companyCountry : {
												validators : {
													notEmpty : {
														message : 'Sorry, the company country is required'
													}
												}
											},
											pinNumber : {
												validators : {
													notEmpty : {
														message : 'Sorry, the company PIN number is required'
													}
												}
											},
											sector : {
												validators : {
													notEmpty : {
														message : 'Sorry, please select the company sector'
													}
												}
											},
											employerNumber : {
												validators : {
													notEmpty : {
														message : 'Sorry, the company\'s employer number is required'
													}
												}
											},
											scheme : {
												validators : {
													notEmpty : {
														message : 'Sorry, please select your prefered pension scheme'
													}
												}
											},
											sponsor1CaptchaChars : {
												validators : {
													notEmpty : {
														message : 'Please enter the characters as they appear'
													}
												}
											}
										}
									})
							.on(
									'success.form.bv',
									function(e) {
										start_wait();
										// Prevent form submission
										e.preventDefault();
										// Get the form instance
										$
												.ajax({
													url : $('#base_url').val()
															+ 'register',
													type : 'post',
													data : {
														name: $('#companyName').val(),
														applicationDate: $('#companyApplicationDate').val(),
														pinNo: $('#pinNumber').val(),
														employerNo: $('#employerNumber').val(),
														sector: $('#sector').val(),
														email: $('#companyEmail').val(),
														phone: $('#companyPhone').val(),
														address: $('#companyAddress').val(),
														city: $('#companyCity').val(),
														country: $('#companyCountry').val(),
														type : 'sponsor',
														scheme: $('#scheme').val(),
														inCaptchaChars : $(
														'#sponsor1CaptchaChars')
														.val()
													}

														,
													dataType : 'json',
													success : function(json) {
														stop_wait();
														if(json.success)
														{
															$("form#form-sponsor")[0]
																	.reset();
															setTimeout(
																	function() {
																		window.location.href = $(
																				'#base_url')
																				.val();
																	}, 5000);
														}
														bootbox
																.alert('<p class="text-center">'
																		+ json.message
																		+ '</p>');
														if(json.captcha || !json.success)
														{
															reload_captcha();
														}
													}
												});

									});
				});