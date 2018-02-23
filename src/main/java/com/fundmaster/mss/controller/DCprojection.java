package com.fundmaster.mss.controller;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.common.JLogger;
import com.fundmaster.mss.dto.DBprojectionsDTO;
import com.fundmaster.mss.dto.DCprojectionsDTO;
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
@WebServlet(name = "DCprojection", urlPatterns = {"/DCprojection"})
public class DCprojection extends BaseServlet implements Serializable {
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

            DCprojectionsDTO bprojectionsDTO = new  DCprojectionsDTO();

            bprojectionsDTO.setDateOfExit(fromDate_String);
            bprojectionsDTO.setDateOfCalculation(toDate_String);
            bprojectionsDTO.setAgeAtExit(dbProjectionsObject.get("age_at_exit").toString());
            bprojectionsDTO.setReasonForExit(dbProjectionsObject.get("exit_reason").toString());
            bprojectionsDTO.setPensionableService(dbProjectionsObject.get("pensionable_service").toString());
            bprojectionsDTO.setTotalBenefits(MssUtil.castToBigDecimal(dbProjectionsObject.get("total_benefits")));

            bprojectionsDTO.setPensionPurchasePrice(MssUtil.castToBigDecimal(dbProjectionsObject.get("pension_purchase_price")));
            bprojectionsDTO.setAnnualPension(MssUtil.castToBigDecimal(dbProjectionsObject.get("annual_pension")));
            bprojectionsDTO.setGrossMonthlyPension(MssUtil.castToBigDecimal(dbProjectionsObject.get("gross_monthly_pension")));
            bprojectionsDTO.setTaxOnPension(MssUtil.castToBigDecimal(dbProjectionsObject.get("tax_on_pension")));
            bprojectionsDTO.setNetMonthlyPension(MssUtil.castToBigDecimal(dbProjectionsObject.get("net_monthly_monthly")));

            bprojectionsDTO.setCommutedLumpsum(MssUtil.castToBigDecimal(dbProjectionsObject.get("commuted_lumpsum")));
            bprojectionsDTO.setTaxFreeLumpsum(MssUtil.castToBigDecimal(dbProjectionsObject.get("tax_free_lumpsum'")));
            bprojectionsDTO.setTaxableAmount(MssUtil.castToBigDecimal(dbProjectionsObject.get("taxable_amount")));
            bprojectionsDTO.setWithholdingTax(MssUtil.castToBigDecimal(dbProjectionsObject.get("withholding_tax")));
            bprojectionsDTO.setMemberLiability(MssUtil.castToBigDecimal(dbProjectionsObject.get("member_liability")));
            bprojectionsDTO.setLumpsumPayable(MssUtil.castToBigDecimal(dbProjectionsObject.get("lumpsum_payable")));

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
