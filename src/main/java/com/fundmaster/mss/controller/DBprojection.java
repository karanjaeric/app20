package com.fundmaster.mss.controller;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.JLogger;
import com.fundmaster.mss.dto.DBprojectionsDTO;
import com.fundmaster.mss.util.MssUtil;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author ekaranja
 */
@WebServlet(name = "DBprojection", urlPatterns = {"/DBprojection"})
public class DBprojection extends BaseServlet implements Serializable {

    private final JLogger jLogger = new JLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            response.addHeader("X-XSS-Protection", "1; mode=block");
            response.addHeader("X-Frame-Options", "DENY");
            response.addHeader("X-Content-Type-Options", "nosniff");

            DateFormat format_from = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);
            DateFormat format = new SimpleDateFormat("MMM-dd-yyyy", Locale.ENGLISH);

            String fromDate_String = this.get(request, "dateOfCalc");
            String toDate_String = this.get(request, "dateOfExit");

            Date fromDate = null;
            Date toDate = null;

            try {
                fromDate = format_from.parse(fromDate_String);
                toDate = format_from.parse(toDate_String);
            } catch (ParseException pe) {
                // TODO Auto-generated catch block
                jLogger.e("ParseException was detected: " + pe.getMessage());
            }

            jLogger.i("From Date ================ > " + fromDate);
            jLogger.i("To Date ================ > " + toDate);
             HttpSession session = request.getSession();

            JSONObject dbProjectionsObject = apiEJB.calculateDBBenefitsProjections(session.getAttribute(Constants.SCHEME_ID).toString(),
                    session.getAttribute(Constants.PROFILE_ID).toString(), format.format(fromDate),
                    this.get(request, "reasonforexitid"));

            DBprojectionsDTO bprojectionsDTO = new DBprojectionsDTO();

            bprojectionsDTO.setDbDateOfExit(fromDate_String);
            bprojectionsDTO.setDbDateOfCalculation(toDate_String);
            bprojectionsDTO.setDbAgeAtExit(dbProjectionsObject.get("ageAtExit").toString());
            bprojectionsDTO.setDbReasonForExit(dbProjectionsObject.get("reasonForExit").toString());
            bprojectionsDTO.setDbPensionableService(dbProjectionsObject.get("yearsWorked").toString());
            bprojectionsDTO.setDbPensionableSalary(MssUtil.castToBigDecimal(dbProjectionsObject.get("annualSalary")));

            bprojectionsDTO.setDbTargetPension(MssUtil.castToBigDecimal(dbProjectionsObject.get("targetPension")));
            bprojectionsDTO.setDbAnnualPension(MssUtil.castToBigDecimal(dbProjectionsObject.get("annualPension")));
            bprojectionsDTO.setDbGrossMonthlyPension(MssUtil.castToBigDecimal(dbProjectionsObject.get("monthlyPension")));
            bprojectionsDTO.setDbTaxOnPension(MssUtil.castToBigDecimal(dbProjectionsObject.get("taxOnPension")));
            bprojectionsDTO.setDbNetMonthlyPension(MssUtil.castToBigDecimal(dbProjectionsObject.get("totMonthlyPens")));

            bprojectionsDTO.setDbCommutedLumpsum(MssUtil.castToBigDecimal(dbProjectionsObject.get("totBen")));
            bprojectionsDTO.setDbTaxFreeLumpsum(MssUtil.castToBigDecimal(dbProjectionsObject.get("lumpsumTaxFree")));
            bprojectionsDTO.setDbTaxableAmount(MssUtil.castToBigDecimal(dbProjectionsObject.get("taxableAmount")));
            bprojectionsDTO.setDbWithholdingTax(MssUtil.castToBigDecimal(dbProjectionsObject.get("withHTax")));
            bprojectionsDTO.setDbMemberLiability(MssUtil.castToBigDecimal(dbProjectionsObject.get("totLiabilities")));
            bprojectionsDTO.setDbLumpsumPayable(MssUtil.castToBigDecimal(dbProjectionsObject.get("netPay")));

            request.setAttribute("dbprojectionsDTO", bprojectionsDTO);
        
        } catch (JSONException ex) {
            Logger.getLogger(DBprojection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
