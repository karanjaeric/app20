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
$(".member-country-code,.admin-country-code,.sponsor-country-code").append(
    "        <option data-countryCode='GB' value='+44' Selected>UK (+44)</option>\n" +
    "        <option data-countryCode='US' value='+1'>USA (+1)</option>\n" +
    "        <option data-countryCode='DZ' value='+213'>Algeria (+213)</option>\n" +
    "        <option data-countryCode='AD' value='+376'>Andorra (+376)</option>\n" +
    "        <option data-countryCode='AO' value='+244'>Angola (+244)</option>\n" +
    "        <option data-countryCode='AI' value='+1264'>Anguilla (+1264)</option>\n" +
    "        <option data-countryCode='AG' value='+1268'>Antigua &amp; Barbuda (+1268)</option>\n" +
    "        <option data-countryCode='AR' value='+54'>Argentina (+54)</option>\n" +
    "        <option data-countryCode='AM' value='+374'>Armenia (+374)</option>\n" +
    "        <option data-countryCode='AW' value='+297'>Aruba (+297)</option>\n" +
    "        <option data-countryCode='AU' value='+61'>Australia (+61)</option>\n" +
    "        <option data-countryCode='AT' value='+43'>Austria (+43)</option>\n" +
    "        <option data-countryCode='AZ' value='+994'>Azerbaijan (+994)</option>\n" +
    "        <option data-countryCode='BS' value='+1242'>Bahamas (+1242)</option>\n" +
    "        <option data-countryCode='BH' value='+973'>Bahrain (+973)</option>\n" +
    "        <option data-countryCode='BD' value='+880'>Bangladesh (+880)</option>\n" +
    "        <option data-countryCode='BB' value='+1246'>Barbados (+1246)</option>\n" +
    "        <option data-countryCode='BY' value='+375'>Belarus (+375)</option>\n" +
    "        <option data-countryCode='BE' value='+32'>Belgium (+32)</option>\n" +
    "        <option data-countryCode='BZ' value='+501'>Belize (+501)</option>\n" +
    "        <option data-countryCode='BJ' value='+229'>Benin (+229)</option>\n" +
    "        <option data-countryCode='BM' value='+1441'>Bermuda (+1441)</option>\n" +
    "        <option data-countryCode='BT' value='+975'>Bhutan (+975)</option>\n" +
    "        <option data-countryCode='BO' value='+591'>Bolivia (+591)</option>\n" +
    "        <option data-countryCode='BA' value='+387'>Bosnia Herzegovina (+387)</option>\n" +
    "        <option data-countryCode='BW' value='+267'>Botswana (+267)</option>\n" +
    "        <option data-countryCode='BR' value='+55'>Brazil (+55)</option>\n" +
    "        <option data-countryCode='BN' value='+673'>Brunei (+673)</option>\n" +
    "        <option data-countryCode='BG' value='+359'>Bulgaria (+359)</option>\n" +
    "        <option data-countryCode='BF' value='+226'>Burkina Faso (+226)</option>\n" +
    "        <option data-countryCode='BI' value='+257'>Burundi (+257)</option>\n" +
    "        <option data-countryCode='KH' value='+855'>Cambodia (+855)</option>\n" +
    "        <option data-countryCode='CM' value='+237'>Cameroon (+237)</option>\n" +
    "        <option data-countryCode='CA' value='+1'>Canada (+1)</option>\n" +
    "        <option data-countryCode='CV' value='+238'>Cape Verde Islands (+238)</option>\n" +
    "        <option data-countryCode='KY' value='+1345'>Cayman Islands (+1345)</option>\n" +
    "        <option data-countryCode='CF' value='+236'>Central African Republic (+236)</option>\n" +
    "        <option data-countryCode='CL' value='+56'>Chile (+56)</option>\n" +
    "        <option data-countryCode='CN' value='+86'>China (+86)</option>\n" +
    "        <option data-countryCode='CO' value='+57'>Colombia (+57)</option>\n" +
    "        <option data-countryCode='KM' value='+269'>Comoros (+269)</option>\n" +
    "        <option data-countryCode='CG' value='+242'>Congo (+242)</option>\n" +
    "        <option data-countryCode='CK' value='+682'>Cook Islands (+682)</option>\n" +
    "        <option data-countryCode='CR' value='+506'>Costa Rica (+506)</option>\n" +
    "        <option data-countryCode='HR' value='+385'>Croatia (+385)</option>\n" +
    "        <option data-countryCode='CU' value='+53'>Cuba (+53)</option>\n" +
    "        <option data-countryCode='CY' value='+90392'>Cyprus North (+90392)</option>\n" +
    "        <option data-countryCode='CY' value='+357'>Cyprus South (+357)</option>\n" +
    "        <option data-countryCode='CZ' value='+42'>Czech Republic (+42)</option>\n" +
    "        <option data-countryCode='DK' value='+45'>Denmark (+45)</option>\n" +
    "        <option data-countryCode='DJ' value='+253'>Djibouti (+253)</option>\n" +
    "        <option data-countryCode='DM' value='+1809'>Dominica (+1809)</option>\n" +
    "        <option data-countryCode='DO' value='+1809'>Dominican Republic (+1809)</option>\n" +
    "        <option data-countryCode='EC' value='+593'>Ecuador (+593)</option>\n" +
    "        <option data-countryCode='EG' value='+20'>Egypt (+20)</option>\n" +
    "        <option data-countryCode='SV' value='+503'>El Salvador (+503)</option>\n" +
    "        <option data-countryCode='GQ' value='+240'>Equatorial Guinea (+240)</option>\n" +
    "        <option data-countryCode='ER' value='+291'>Eritrea (+291)</option>\n" +
    "        <option data-countryCode='EE' value='+372'>Estonia (+372)</option>\n" +
    "        <option data-countryCode='ET' value='+251'>Ethiopia (+251)</option>\n" +
    "        <option data-countryCode='FK' value='+500'>Falkland Islands (+500)</option>\n" +
    "        <option data-countryCode='FO' value='+298'>Faroe Islands (+298)</option>\n" +
    "        <option data-countryCode='FJ' value='+679'>Fiji (+679)</option>\n" +
    "        <option data-countryCode='FI' value='+358'>Finland (+358)</option>\n" +
    "        <option data-countryCode='FR' value='+33'>France (+33)</option>\n" +
    "        <option data-countryCode='GF' value='+594'>French Guiana (+594)</option>\n" +
    "        <option data-countryCode='PF' value='+689'>French Polynesia (+689)</option>\n" +
    "        <option data-countryCode='GA' value='+241'>Gabon (+241)</option>\n" +
    "        <option data-countryCode='GM' value='+220'>Gambia (+220)</option>\n" +
    "        <option data-countryCode='GE' value='+7880'>Georgia (+7880)</option>\n" +
    "        <option data-countryCode='DE' value='+49'>Germany (+49)</option>\n" +
    "        <option data-countryCode='GH' value='+233'>Ghana (+233)</option>\n" +
    "        <option data-countryCode='GI' value='+350'>Gibraltar (+350)</option>\n" +
    "        <option data-countryCode='GR' value='+30'>Greece (+30)</option>\n" +
    "        <option data-countryCode='GL' value='+299'>Greenland (+299)</option>\n" +
    "        <option data-countryCode='GD' value='+1473'>Grenada (+1473)</option>\n" +
    "        <option data-countryCode='GP' value='+590'>Guadeloupe (+590)</option>\n" +
    "        <option data-countryCode='GU' value='+671'>Guam (+671)</option>\n" +
    "        <option data-countryCode='GT' value='+502'>Guatemala (+502)</option>\n" +
    "        <option data-countryCode='GN' value='+224'>Guinea (+224)</option>\n" +
    "        <option data-countryCode='GW' value='+245'>Guinea - Bissau (+245)</option>\n" +
    "        <option data-countryCode='GY' value='+592'>Guyana (+592)</option>\n" +
    "        <option data-countryCode='HT' value='+509'>Haiti (+509)</option>\n" +
    "        <option data-countryCode='HN' value='+504'>Honduras (+504)</option>\n" +
    "        <option data-countryCode='HK' value='+852'>Hong Kong (+852)</option>\n" +
    "        <option data-countryCode='HU' value='+36'>Hungary (+36)</option>\n" +
    "        <option data-countryCode='IS' value='+354'>Iceland (+354)</option>\n" +
    "        <option data-countryCode='IN' value='+91'>India (+91)</option>\n" +
    "        <option data-countryCode='ID' value='+62'>Indonesia (+62)</option>\n" +
    "        <option data-countryCode='IR' value='+98'>Iran (+98)</option>\n" +
    "        <option data-countryCode='IQ' value='+964'>Iraq (+964)</option>\n" +
    "        <option data-countryCode='IE' value='+353'>Ireland (+353)</option>\n" +
    "        <option data-countryCode='IL' value='+972'>Israel (+972)</option>\n" +
    "        <option data-countryCode='IT' value='+39'>Italy (+39)</option>\n" +
    "        <option data-countryCode='JM' value='+1876'>Jamaica (+1876)</option>\n" +
    "        <option data-countryCode='JP' value='+81'>Japan (+81)</option>\n" +
    "        <option data-countryCode='JO' value='+962'>Jordan (+962)</option>\n" +
    "        <option data-countryCode='KZ' value='+7'>Kazakhstan (+7)</option>\n" +
    "        <option data-countryCode='KE' value='+254'>Kenya (+254)</option>\n" +
    "        <option data-countryCode='KI' value='+686'>Kiribati (+686)</option>\n" +
    "        <option data-countryCode='KP' value='+850'>Korea North (+850)</option>\n" +
    "        <option data-countryCode='KR' value='+82'>Korea South (+82)</option>\n" +
    "        <option data-countryCode='KW' value='+965'>Kuwait (+965)</option>\n" +
    "        <option data-countryCode='KG' value='+996'>Kyrgyzstan (+996)</option>\n" +
    "        <option data-countryCode='LA' value='+856'>Laos (+856)</option>\n" +
    "        <option data-countryCode='LV' value='+371'>Latvia (+371)</option>\n" +
    "        <option data-countryCode='LB' value='+961'>Lebanon (+961)</option>\n" +
    "        <option data-countryCode='LS' value='+266'>Lesotho (+266)</option>\n" +
    "        <option data-countryCode='LR' value='+231'>Liberia (+231)</option>\n" +
    "        <option data-countryCode='LY' value='+218'>Libya (+218)</option>\n" +
    "        <option data-countryCode='LI' value='+417'>Liechtenstein (+417)</option>\n" +
    "        <option data-countryCode='LT' value='+370'>Lithuania (+370)</option>\n" +
    "        <option data-countryCode='LU' value='+352'>Luxembourg (+352)</option>\n" +
    "        <option data-countryCode='MO' value='+853'>Macao (+853)</option>\n" +
    "        <option data-countryCode='MK' value='+389'>Macedonia (+389)</option>\n" +
    "        <option data-countryCode='MG' value='+261'>Madagascar (+261)</option>\n" +
    "        <option data-countryCode='MW' value='+265'>Malawi (+265)</option>\n" +
    "        <option data-countryCode='MY' value='+60'>Malaysia (+60)</option>\n" +
    "        <option data-countryCode='MV' value='+960'>Maldives (+960)</option>\n" +
    "        <option data-countryCode='ML' value='+223'>Mali (+223)</option>\n" +
    "        <option data-countryCode='MT' value='+356'>Malta (+356)</option>\n" +
    "        <option data-countryCode='MH' value='+692'>Marshall Islands (+692)</option>\n" +
    "        <option data-countryCode='MQ' value='+596'>Martinique (+596)</option>\n" +
    "        <option data-countryCode='MR' value='+222'>Mauritania (+222)</option>\n" +
    "        <option data-countryCode='YT' value='+269'>Mayotte (+269)</option>\n" +
    "        <option data-countryCode='MX' value='+52'>Mexico (+52)</option>\n" +
    "        <option data-countryCode='FM' value='+691'>Micronesia (+691)</option>\n" +
    "        <option data-countryCode='MD' value='+373'>Moldova (+373)</option>\n" +
    "        <option data-countryCode='MC' value='+377'>Monaco (+377)</option>\n" +
    "        <option data-countryCode='MN' value='+976'>Mongolia (+976)</option>\n" +
    "        <option data-countryCode='MS' value='+1664'>Montserrat (+1664)</option>\n" +
    "        <option data-countryCode='MA' value='+212'>Morocco (+212)</option>\n" +
    "        <option data-countryCode='MZ' value='+258'>Mozambique (+258)</option>\n" +
    "        <option data-countryCode='MN' value='+95'>Myanmar (+95)</option>\n" +
    "        <option data-countryCode='NA' value='+264'>Namibia (+264)</option>\n" +
    "        <option data-countryCode='NR' value='+674'>Nauru (+674)</option>\n" +
    "        <option data-countryCode='NP' value='+977'>Nepal (+977)</option>\n" +
    "        <option data-countryCode='NL' value='+31'>Netherlands (+31)</option>\n" +
    "        <option data-countryCode='NC' value='+687'>New Caledonia (+687)</option>\n" +
    "        <option data-countryCode='NZ' value='+64'>New Zealand (+64)</option>\n" +
    "        <option data-countryCode='NI' value='+505'>Nicaragua (+505)</option>\n" +
    "        <option data-countryCode='NE' value='+227'>Niger (+227)</option>\n" +
    "        <option data-countryCode='NG' value='+234'>Nigeria (+234)</option>\n" +
    "        <option data-countryCode='NU' value='+683'>Niue (+683)</option>\n" +
    "        <option data-countryCode='NF' value='+672'>Norfolk Islands (+672)</option>\n" +
    "        <option data-countryCode='NP' value='+670'>Northern Marianas (+670)</option>\n" +
    "        <option data-countryCode='NO' value='+47'>Norway (+47)</option>\n" +
    "        <option data-countryCode='OM' value='+968'>Oman (+968)</option>\n" +
    "        <option data-countryCode='PW' value='+680'>Palau (+680)</option>\n" +
    "        <option data-countryCode='PA' value='+507'>Panama (+507)</option>\n" +
    "        <option data-countryCode='PG' value='+675'>Papua New Guinea (+675)</option>\n" +
    "        <option data-countryCode='PY' value='+595'>Paraguay (+595)</option>\n" +
    "        <option data-countryCode='PE' value='+51'>Peru (+51)</option>\n" +
    "        <option data-countryCode='PH' value='+63'>Philippines (+63)</option>\n" +
    "        <option data-countryCode='PL' value='+48'>Poland (+48)</option>\n" +
    "        <option data-countryCode='PT' value='+351'>Portugal (+351)</option>\n" +
    "        <option data-countryCode='PR' value='+1787'>Puerto Rico (+1787)</option>\n" +
    "        <option data-countryCode='QA' value='+974'>Qatar (+974)</option>\n" +
    "        <option data-countryCode='RE' value='+262'>Reunion (+262)</option>\n" +
    "        <option data-countryCode='RO' value='+40'>Romania (+40)</option>\n" +
    "        <option data-countryCode='RU' value='+7'>Russia (+7)</option>\n" +
    "        <option data-countryCode='RW' value='+250'>Rwanda (+250)</option>\n" +
    "        <option data-countryCode='SM' value='+378'>San Marino (+378)</option>\n" +
    "        <option data-countryCode='ST' value='+239'>Sao Tome &amp; Principe (+239)</option>\n" +
    "        <option data-countryCode='SA' value='+966'>Saudi Arabia (+966)</option>\n" +
    "        <option data-countryCode='SN' value='+221'>Senegal (+221)</option>\n" +
    "        <option data-countryCode='CS' value='+381'>Serbia (+381)</option>\n" +
    "        <option data-countryCode='SC' value='+248'>Seychelles (+248)</option>\n" +
    "        <option data-countryCode='SL' value='+232'>Sierra Leone (+232)</option>\n" +
    "        <option data-countryCode='SG' value='+65'>Singapore (+65)</option>\n" +
    "        <option data-countryCode='SK' value='+421'>Slovak Republic (+421)</option>\n" +
    "        <option data-countryCode='SI' value='+386'>Slovenia (+386)</option>\n" +
    "        <option data-countryCode='SB' value='+677'>Solomon Islands (+677)</option>\n" +
    "        <option data-countryCode='SO' value='+252'>Somalia (+252)</option>\n" +
    "        <option data-countryCode='ZA' value='+27'>South Africa (+27)</option>\n" +
    "        <option data-countryCode='ES' value='+34'>Spain (+34)</option>\n" +
    "        <option data-countryCode='LK' value='+94'>Sri Lanka (+94)</option>\n" +
    "        <option data-countryCode='SH' value='+290'>St. Helena (+290)</option>\n" +
    "        <option data-countryCode='KN' value='+1869'>St. Kitts (+1869)</option>\n" +
    "        <option data-countryCode='SC' value='+1758'>St. Lucia (+1758)</option>\n" +
    "        <option data-countryCode='SD' value='+249'>Sudan (+249)</option>\n" +
    "        <option data-countryCode='SR' value='+597'>Suriname (+597)</option>\n" +
    "        <option data-countryCode='SZ' value='+268'>Swaziland (+268)</option>\n" +
    "        <option data-countryCode='SE' value='+46'>Sweden (+46)</option>\n" +
    "        <option data-countryCode='CH' value='+41'>Switzerland (+41)</option>\n" +
    "        <option data-countryCode='SI' value='+963'>Syria (+963)</option>\n" +
    "        <option data-countryCode='TW' value='+886'>Taiwan (+886)</option>\n" +
    "        <option data-countryCode='TJ' value='+7'>Tajikstan (+7)</option>\n" +
    "        <option data-countryCode='TH' value='+66'>Thailand (+66)</option>\n" +
    "        <option data-countryCode='TG' value='+228'>Togo (+228)</option>\n" +
    "        <option data-countryCode='TO' value='+676'>Tonga (+676)</option>\n" +
    "        <option data-countryCode='TT' value='+1868'>Trinidad &amp; Tobago (+1868)</option>\n" +
    "        <option data-countryCode='TN' value='+216'>Tunisia (+216)</option>\n" +
    "        <option data-countryCode='TR' value='+90'>Turkey (+90)</option>\n" +
    "        <option data-countryCode='TM' value='+7'>Turkmenistan (+7)</option>\n" +
    "        <option data-countryCode='TM' value='+993'>Turkmenistan (+993)</option>\n" +
    "        <option data-countryCode='TC' value='+1649'>Turks &amp; Caicos Islands (+1649)</option>\n" +
    "        <option data-countryCode='TV' value='+688'>Tuvalu (+688)</option>\n" +
    "        <option data-countryCode='UG' value='+256'>Uganda (+256)</option>\n" +
    "        <option data-countryCode='GB' value='+44'>UK (+44)</option>\n" +
    "        <option data-countryCode='UA' value='+380'>Ukraine (+380)</option>\n" +
    "        <option data-countryCode='AE' value='+971'>United Arab Emirates (+971)</option>\n" +
    "        <option data-countryCode='UY' value='+598'>Uruguay (+598)</option>\n" +
    "        <option data-countryCode='US' value='+1'>USA (+1)</option>\n" +
    "        <option data-countryCode='UZ' value='+7'>Uzbekistan (+7)</option>\n" +
    "        <option data-countryCode='VU' value='+678'>Vanuatu (+678)</option>\n" +
    "        <option data-countryCode='VA' value='+379'>Vatican City (+379)</option>\n" +
    "        <option data-countryCode='VE' value='+58'>Venezuela (+58)</option>\n" +
    "        <option data-countryCode='VN' value='+84'>Vietnam (+84)</option>\n" +
    "        <option data-countryCode='VG' value='+84'>Virgin Islands - British (+1284)</option>\n" +
    "        <option data-countryCode='VI' value='+84'>Virgin Islands - US (+1340)</option>\n" +
    "        <option data-countryCode='WF' value='+681'>Wallis &amp; Futuna (+681)</option>\n" +
    "        <option data-countryCode='YE' value='+969'>Yemen (North)(+969)</option>\n" +
    "        <option data-countryCode='YE' value='+967'>Yemen (South)(+967)</option>\n" +
    "        <option data-countryCode='ZM' value='+260'>Zambia (+260)</option>\n" +
    "        <option data-countryCode='ZW' value='+263'>Zimbabwe (+263)</option>\n" +
    "    </optgroup>\n"

);
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
					var adminCountryCode=$('.admin-country-code').val();
if(typeof adminCountryCode=="undefined")
{
    adminCountryCode='';
}
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
														username : adminCountryCode +
														        $(
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
                                        var memberCountryCode=$('.member-country-code').val();
                                        if(memberCountryCode==null)
                                        {
                                            memberCountryCode='';
                                        }
                                        else {
                                            memberCountryCode=$('.member-country-code').val();
                                        }
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
														username : memberCountryCode+
														$('#username').val(),
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
                                        var sponsorCountryCode=$('.sponsor-country-code').val();
                                        if(sponsorCountryCode==null)
                                        {
                                            sponsorCountryCode='';
                                        }
                                        else {
                                            sponsorCountryCode=$('.sponsor-country-code').val();
                                        }
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
														idNumber : sponsorCountryCode+
															$(
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
    var adminRegCountryCode=$('.admin-reg-country-code').val();
    if(typeof adminRegCountryCode=="undefined")
    {
        adminRegCountryCode='';
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
														idNumber :
                                                        adminRegCountryCode+
															$(
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
                                        var memberCountryCode=$('.member-country-code').val();
                                        if(memberCountryCode==null)
                                        {
                                            memberCountryCode='';
                                        }
                                        else {
                                            memberCountryCode=$('.member-country-code').val();
                                        }
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
														// countryCode : $(
														// 	'#country-code').val(),
														idNumber : memberCountryCode +
														         $(
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