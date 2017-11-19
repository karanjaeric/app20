<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <div class="row">


         <form role="form" id="form-projection" method="POST" >
        <h1 class="heading">${ menu.benefitProjectionName }</h1>
        <fieldset>
            <legend>Benefit Projection Calculation Parameters</legend>
            <div class="col-md-3">
                <div class="form-group">
                    <label class="control-label">Interest Rate (r):</label> <input
                        type="text" name="interestRate" class="form-control" id="interestRate"
                        placeholder="Enter the Current Interest Rate" required>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label class="control-label">No. Of Years:</label> <input
                        type="text" name="years" class="form-control" id="years"
                        placeholder="Enter the Number of Years"  >
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label for="paymentFrequency" class="control-label">Payment Frequency:</label>
                    <select name="paymentFrequency" id="paymentFrequency" class="form-control"  >
                        <option value="">Select Frequency...</option>
                        <option value="12">MONTHLY</option>
                        <option value="4">QUARTERLY</option>
                        <option value="2">SEMI_ANNUALLY</option>
                        <option value="1">ANNUAL</option>
                    </select>
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label class="control-label">Payment Amount:</label> <input
                        type="text" name="paymentAmount" class="form-control" id="paymentAmount"
                        placeholder="Enter the Amount "  >
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group">
                    <label class="control-label">Lump Sum  :</label> <input
                        type="text" name="presentValue" class="form-control" id="presentValue"
                        placeholder="0.00" value="0"  >
                </div>
            </div>


            <div class="col-md-3">
                <p>&nbsp;</p>
                <button class="btn btn-primary">Calculate</button>
            </div>
        </fieldset>
        <p>&nbsp;</p>
    </form>
     <h3>Projected Benefits</h3>

     </table> <table class="table table-responsive table-striped table-bordered" id="projection-results">
    </table>

</div>
<script src="static/custom/vendors/jquery-1.9.1.min.js"></script>


<script type="text/javascript">
    $(document).ready(function(){

        $('#form-projection')
                .bootstrapValidator(
                    {
                        message : 'This value is not valid',
                        feedbackIcons : {
                            valid : 'glyphicon glyphicon-ok',
                            invalid : 'glyphicon glyphicon-remove',
                            validating : 'glyphicon glyphicon-refresh'
                        },
                        fields : {
                            interestRate : {
                                validators : {
                                    notEmpty : {
                                        message : 'Please enter the Interest Rate  '
                                    },
                                    numeric : {
                                        message : 'This value can and must only be a number'
                                    }
                                }
                            },
                            numberOfYears : {
                                validators : {
                                    notEmpty : {
                                        message : 'Please enter the number of years'
                                    },
                                    numeric : {
                                        message : 'This value can and must only be a number'
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
                            paymentAmount : {
                                validators : {
                                    notEmpty : {
                                        message : 'Please enter the payment amount'
                                    },
                                    numeric : {
                                        message : 'This value can and must only be a number'
                                    }
                                }
                            },
                            presentValue : {
                                validators : {
                                    notEmpty : {
                                        message : 'Please enter the present Value'
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
                        $.ajax({
                                url : $('#base_url').val() + 'benefit-projection-home',
                                 type : 'post',
                                data : {
                                    interestRate : $(
                                        '#interestRate')
                                        .val(),
                                    years : $(
                                        '#years')
                                        .val(),
                                    paymentFrequency : $(
                                        '#paymentFrequency')
                                        .val(),
                                    paymentAmount : $(
                                        '#paymentAmount')
                                        .val(),
                                    presentValue: $(
                                        '#presentValue')
                                        .val()
                                },

                                dataType : 'json',
                                success : function(json) {
                                    html = "<tr><th>PROJECTED RESULTS</th></tr>";
                                    stop_wait();
                                    if (json.success) {
                                         console.log("The JSON is  " + json);

                                         var obj = $.parseJSON(json.data);
                                        console.log(json);
                                        var FV = obj.futureValue;
                                        console.log("FV " + FV);

                                                html = html + "<tr><td><h3>" + FV + "</h3></td> </tr>";
                                                stop_wait();


                                         $('#projection-results').html(html);
                                      }
                                }
                            });

        });
    });
    </script>
