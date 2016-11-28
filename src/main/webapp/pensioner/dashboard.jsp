<%--
  Created by IntelliJ IDEA.
  User: tony
  Date: 11/24/16
  Time: 9:07 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="container-fluid section">
    <h3 class="text-center main-title">
        <i
                class="glyphicon glyphicon-dashboard"></i>&nbsp;DASHBOARD PANEL
    </h3>
    <div class="col-md-6">
        <h3 class="text-center"><small>PENSIONER DETAILS</small></h3>
        <table class="table table-responsive table-striped">
            <tr><td>NAME</td><td>${pensioner.name }</td></tr>
            <tr><td>DATE OF BIRTH</td><td>${pensioner.dob }</td></tr>
            <tr><td>PENSIONER NUMBER</td><td>${pensioner.pensionerNo }</td></tr>
            <tr><td>GENDER</td><td>${pensioner.gender }</td></tr>
            <tr><td>ID/PPT NUMBER</td><td>${pensioner.idNo }</td></tr>
            <tr><td>PHONE NUMBER</td><td>${pensioner.cellPhone }</td></tr>
            <tr><td>POSTAL ADDRESS</td><td>${pensioner.postalAddress }</td></tr>
            <tr><td>PIN/TAX NUMBER</td><td>${pensioner.pinNo }</td></tr>
            <tr><td>CITY/TOWN</td><td>${pensioner.town }</td></tr>
        </table>
    </div>
    <div class="col-md-6 border-left">
        <h3 class="text-center"><small>DISTRIBUTION TO BENEFICIARIES</small></h3>
        <div id="pie-chart">

        </div>
    </div>

</div>

<script type="text/javascript">

    $(document).ready(function () {

        function start_wait()
        {
            $('#wait-dialog').modal({
                backdrop: 'static',
                keyboard: false
            });
        }
        function stop_wait()
        {
            $('#wait-dialog').modal('hide');
        }

        function initialize()
        {
            start_wait();

            /* Load Beneficiary Distribution Data */
            console.log(">>>> I'm hoping we're here <<<<<<<<<");
            $.ajax({

                url: $('#base_url').val() + 'pensioner',
                type: 'post',
                data: {ACTION:'BENEFICIARY'},
                dataType: 'json',
                success: function(json) {
                    if(json.success)
                    {

                        json = $.parseJSON(json.data);
                        pie_chart(json);
                    }
                    else
                    {
                        stop_wait();
                        bootbox.alert('<p class="text-center">' + json.message + '</p>');
                    }
                }
            });
        }
        initialize();
        // Build the chart

        function pie_chart(json)
        {
            var slices = {
                distributions:[]
            };
            var total = 0;
            $.each(json, function(key, value) {
                if(key == 'rows')
                {
                    for ( var i = 0; i < json.rows.length; i++) {
                        var row = json.rows[i];
                        var beneficiary = {};
                        beneficiary["name"] = row["name"];
                        beneficiary["y"] = row['amount'] == '' ? 0 : parseFloat(row["amount"]);
                        total += beneficiary['y'];
                        slices.distributions.push(beneficiary);
                    }
                }
            });

            var beneficiary = {};
            beneficiary["name"] = "Un-Allocated";
            beneficiary["y"] = 100 - total;
            if(beneficiary['y'] < 0)
                beneficiary['y'] = 0;
            slices.distributions.push(beneficiary);

            $('#pie-chart').highcharts({
                chart: {
                    plotBackgroundColor: null,
                    plotBorderWidth: null,
                    plotShadow: false,
                    type: 'pie'
                },
                title: {
                    text: ''
                },
                tooltip: {
                    pointFormat: '{series.name}: <b>{point.percentage:,.1f}</b>'
                },
                plotOptions: {
                    pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        dataLabels: {
                            enabled: false
                        },
                        showInLegend: true
                    }
                },
                series: [{
                    name: "Distribution",
                    colorByPoint: true,
                    data: slices.distributions
                }]
            });
            stop_wait();
        }
    });

</script>