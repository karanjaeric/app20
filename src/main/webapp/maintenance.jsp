<html>

<body style="background-color: mediumpurple" >
<br/><br/>
<center>
    <div class="jumbotron" style="color: white; font-size: 20px;margin-top: 30px;padding: 30px">
    Valued client, <br>

    This website is temporarily under maintenance.  You will be notified as soon as the site is back up.
    In the mean time contact as at info.trustees@enterprisegroup.com.gh or call us on our call center number 0302634704 for information on your pensions account.

    Enterprise Trustees, Your Advantage!

    </div>
</center>
</center>
 <p style="text-align: center">

     <%
        out.flush();
        String comment = (String) request.getAttribute("comment");
        if(comment != null){
            out.write(comment);
        }
        out.flush();
    %>

 </p>
</center>
</body>
</html>