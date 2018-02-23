/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fundmaster.mss.controller;

import com.fundmaster.mss.beans.SettingBeanI;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dto.BalanceHistoryDTO;
import com.fundmaster.mss.model.Setting;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONException;


@WebServlet(name = "ClosingBalances", urlPatterns = {"/closingBalances"})
public class ClosingBalances extends BaseServlet implements Serializable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             Setting settings = settingBeanI.find();
             HttpSession session = request.getSession();
        request.setAttribute("settings", settings);
        

        request.setAttribute("scheme_id", this.getSessKey(request, Constants.SCHEME_ID));
        String member_id;

        member_id = this.getSessKey(request, Constants.MEMBER_ID);
        if (member_id == null)
            member_id = this.getSessKey(request, Constants.MEMBER_ID);
        request.setAttribute("member_id", session.getAttribute(Constants.PROFILE_ID));
        System.out.println(session.getAttribute(Constants.PROFILE_ID));
        System.out.println("scheme id is: "+session.getAttribute(Constants.SCHEME_ID));
        System.out.println( this.get(request, "memberID"));
        
         JSONArray balancesHistory1 = null;
        List<BalanceHistoryDTO> balancesHistoryDTOList = new ArrayList<>();
        try {
            balancesHistory1 = apiEJB.getBalancesHistory(session.getAttribute(Constants.PROFILE_ID).toString()).getJSONArray("rows");
        } catch (JSONException ex) {
            Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < balancesHistory1.length(); i++) {
            try {
                BalanceHistoryDTO balanceHistoryDTO = new BalanceHistoryDTO();
                String asAt = balancesHistory1.getJSONObject(i).get("as_at").toString();
                System.err.println("as at is"+asAt);

               // String eeBaltr = balancesHistory1.get(1).toString();
                BigDecimal eeBal =  castToBigDecimal(balancesHistory1.getJSONObject(i).get("ee_bal"));
                 System.err.println("eebal  is"+eeBal);


               // String eeContrStr = balancesHistory1.get(2).toString();
                BigDecimal eeContr =  castToBigDecimal(balancesHistory1.getJSONObject(i).get("er_contr"));
                 System.err.println("eeContrib  is"+eeContr);


              //  String eeIntrStr = balancesHistory1.get(3).toString();
                BigDecimal eeIntr =  castToBigDecimal(balancesHistory1.getJSONObject(i).get("ee_intr"));
                 System.err.println("eeIntr is "+eeIntr);


                //String erBaltr = balancesHistory1.get(4).toString();
                BigDecimal erBal =  castToBigDecimal(balancesHistory1.getJSONObject(i).get("er_bal"));
                 System.err.println("erBal is"+ erBal);


                //String erContrStr = balancesHistory1.get(5).toString();
                BigDecimal erContr =  castToBigDecimal(balancesHistory1.getJSONObject(i).get("er_contr"));
                 System.err.println("ercontr  is"+ erContr);


               // String erIntrStr = balancesHistory1.get(6).toString();
                BigDecimal erIntr =  castToBigDecimal(balancesHistory1.getJSONObject(i).get("er_intr"));
                System.err.println("erIntr  is"+ erIntr);
                
                asAt=asAt.substring(0, 10);

                BigDecimal eeClose = eeBal.add(eeContr).add(eeIntr);
                BigDecimal erClose = erBal.add(erContr).add(erIntr);
                balanceHistoryDTO.setAsAt(asAt);
                balanceHistoryDTO.setEeClose(eeClose);
                balanceHistoryDTO.setErClose(erClose);
                balanceHistoryDTO.setEeBal(eeBal);
                balanceHistoryDTO.setEeContr(eeContr);
                balanceHistoryDTO.setEeIntr(eeIntr);
                balanceHistoryDTO.setErBal(erBal);
                balanceHistoryDTO.setErContr(erContr);
                balanceHistoryDTO.setErIntr(erIntr);
                balanceHistoryDTO.setGrandTotal(eeClose.add(erClose));
                balancesHistoryDTOList.add(balanceHistoryDTO);

            } catch (JSONException ex) {
                Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        System.out.print("size of list is" + balancesHistoryDTOList.size());
        request.setAttribute("closingBalancesList",balancesHistoryDTOList);

    
        request.getRequestDispatcher("testDT/test.jsp").forward(request, response);
        
        
        
    }
        private BigDecimal castToBigDecimal(Object value) {
        BigDecimal ret = null;
        if (value != null) {
            if (value instanceof BigDecimal) {
                ret = (BigDecimal) value;
            } else if (value instanceof String) {
                ret = new BigDecimal((String) value);
            } else if (value instanceof BigInteger) {
                ret = new BigDecimal((BigInteger) value);
            } else if (value instanceof Number) {
                ret = new BigDecimal(((Number) value).doubleValue());
            } else {
                throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass() + " into a BigDecimal.");
            }
        }
        return ret;

    }
        private Object Styler(Object dec){
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            
            return formatter.format(dec);
        
        }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
