package com.fundmaster.mss.api;

import com.fundmaster.mss.beans.BenefitsCalculationBeanI;
import com.fundmaster.mss.beans.InterestRateColumnBeanI;
import com.fundmaster.mss.beans.ProfileLoginFieldBeanI;
import com.fundmaster.mss.beans.SettingBeanI;
import com.fundmaster.mss.common.*;
import com.fundmaster.mss.model.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by bryanitur on 8/1/16.
 */
@Stateless
@Local
public class ApiBean implements ApiEJB {
    @EJB
    SettingBeanI settingBeanI;
    private final Helper helper = new Helper();
    private final JLogger jLogger = new JLogger(this.getClass());

    @EJB
    ProfileLoginFieldBeanI profileLoginFieldBeanI;
    @EJB
    InterestRateColumnBeanI interestRateColumnBeanI;
    @EJB
    BenefitsCalculationBeanI benefitsCalculationBeanI;

    @Override
    public List<Scheme> getSchemes(int start, int count) {

        jLogger.i("Running getSchemes " + start + " : " + count);

        try {
            JSONObject response = URLGet(APICall.SCHEME_GETSCHEMES + "/?start=" + start + "&size=" + count);
            return this.schemesFromJSON(response);
        }   catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public JSONObject getAnnuityQuote(String calculationMode, String productID, String lastName, String firstName, String otherNames, String idNumber, String address, String email, String phoneNumber, String purchaseDate, String pensionStartDate, String dateOfBirth, String gender, String guaranteedPercentage, String annuityIncrement, String paymentMode, String paymentFrequency, String registeredPurchasePrice, String unRegisteredPurchasePrice, String targetPension, String annuityMode, String spouseReversal, Boolean displayable, String spouseGender, String spouseDateOfBirth) {
        String urlParameters = "productId=" + productID + "&" + "surname=" + lastName + "&" + "firstName=" + firstName + "&" + "otherNames=" + otherNames + "&" + "idNo=" + idNumber + "&" + "address=" + address + "&" + "email=" + email + "&" + "mobileNo=" + phoneNumber + "&" + "purchaseDate=" + purchaseDate + "&" + "pensionStartDate=" + pensionStartDate + "&" + "dob=" + dateOfBirth + "&" + "gender=" + gender.toUpperCase() + "&" + "guaranteedPerc=" + guaranteedPercentage + "&" + "annuityIncrement=" + annuityIncrement + "&" + "paymentMode=" + paymentMode + "&" + "paymentFrequency=" + paymentFrequency + "&" + "spouseReversal=" + spouseReversal + "&" + "displayable=" + displayable + "&" + "dobSpouse=" + spouseDateOfBirth + "&" + "spouseGender=" + spouseGender.toUpperCase() + "&" + "regPurchasePrice=" + registeredPurchasePrice + "&" + "unRegPurchasePrice=" + unRegisteredPurchasePrice + "&" + "calcMode=" + calculationMode + "&" + "targetPension=" + targetPension + "&" + "agentId=" + "0" + "&" + "annuityMode=" + annuityMode;
        try {
            return URLPost(APICall.ANNUITY_QUOTE_GETQUOTE, urlParameters, "application/x-www-form-urlencoded");
        }  catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public List<Scheme> getSchemeByPlanType(String planType) {
        JSONObject response;
        try {
            response = URLGet(APICall.SCHEME_GET_SCHEME_BY_PLAN_TYPE + planType);
            if(response.getBoolean(Fields.SUCCESS))
            {
                return this.schemesFromJSON(response);
            }
            else
            {
                return null;
            }
        }  catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public List<AnnuityProduct> getAnnuityProducts() {
        JSONObject response;
        try {
            response = URLGet(APICall.ANNUITY_QUOTE_GET_ANNUITY_PRODUCTS);
            if(response.get(Fields.SUCCESS).equals(true))
            {
                List<AnnuityProduct> annuityProducts = new ArrayList<>();
                JSONArray res = (JSONArray) response.get(Constants.ROWS);
                for(int i = 0; i < res.length(); i++){
                    JSONObject jsonObject = res.getJSONObject(i);
                    AnnuityProduct annuityProduct = new AnnuityProduct();
                    annuityProduct.setId(jsonObject.getLong(Fields.ID));
                    annuityProduct.setProductName(jsonObject.getString(Fields.PRODUCT_NAME));
                    annuityProduct.setProductDate(jsonObject.getString(Fields.PRODUCT_DATE));
                    annuityProducts.add(annuityProduct);
                }
                return annuityProducts;
            }
            else
            {
                return null;
            }
        }  catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public List<Scheme> getSchemeBySchemeModeAndPlanType(String schemeMode, String planType) {
        JSONObject response = null;
        try {
            response = URLGet(APICall.SCHEME_GET_SCHEME_BY_SCHEME_MODE_AND_PLAN_TYPE + schemeMode + "/" + planType);
            jLogger.i("Gotten response " + response);
            if(response.getBoolean(Fields.SUCCESS))
            {
                return this.schemesFromJSON(response);
            }
            else
            {
                return null;
            }
        }  catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage() + response);
            return null;
        }
    }

    @Override
    public JSONObject calculateWhatIfAnalysis(String yearsToProject, String contributions, String rateOfReturn, String salaryEscalationRate, String inflationRate, String email, String phone, String yourAge) {
        JSONObject response;
        try {
            response = URLPost(APICall.WHAT_IF_ANALYSIS + yearsToProject + "/" + contributions + "/" + rateOfReturn + "/" + salaryEscalationRate + "/" + inflationRate, "", Constants.APPLICATION_X_WWW_FORM_URLENCODED);
            if(response.getBoolean(Fields.SUCCESS))
            {
                BenefitCalculation benefitCalculation=new BenefitCalculation();
                benefitCalculation.setAge(helper.toBigDecimal(helper.toLong(yourAge)));
                benefitCalculation.setEmail(email);
                benefitCalculation.setInflationrate(helper.toBigDecimal(helper.toLong(inflationRate)));
                benefitCalculation.setMothnlycontrib(helper.toBigDecimal(helper.toLong(contributions)));
                benefitCalculation.setRequestdate(new Date());
                benefitCalculation.setPhone(phone);
                benefitCalculation.setProjectedage(helper.toBigDecimal(helper.toLong(yearsToProject)));
                benefitCalculation.setReturnrate(helper.toBigDecimal(helper.toLong(rateOfReturn)));
                benefitCalculation.setSalarygrowth(helper.toBigDecimal(helper.toLong(salaryEscalationRate)));
                benefitsCalculationBeanI.add(benefitCalculation);
            }
            return response;
        }  catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public String getSchemeInterestRates(String schemeID) {
        JSONObject response;
        try {
            response = URLGet(APICall.SCHEME_GET_SCHEME_INTEREST_RATES + schemeID);
            jLogger.i("Scheme interest response >>>>>>>>>>>>>>>> " + response + " <<<<<<<<<<<<<<<");
            if(response.getBoolean(Fields.SUCCESS))
            {
                JSONArray res = (JSONArray) response.get(Constants.ROWS);
                jLogger.i("Res is  >>>>>>>>>>>> " + res + " <<<<<<<<<<<<");
                JSONArray jsonarray = new JSONArray();
                InterestRateColumns irc = interestRateColumnBeanI.find();
                Map<String, Boolean> temp = new HashMap<>();
                temp.put(Fields.SUCCESS, true);
                jsonarray.put(temp);
                for(int i = 0; i < res.length(); i ++){
                    JSONObject jsonObject = res.getJSONObject(i);
                    JSONObject obj = new JSONObject();
                    if(irc.isDateDeclared())
                    {
                        obj.put(Fields.DATE_DECLARED, jsonObject.get(Fields.DATEDECLARED));
                    }
                    if(irc.isAccountingPeriod())
                    {
                        obj.put(Fields.ACCOUNTING_PERIOD, jsonObject.get(Fields.AP));
                    }
                    if(irc.isContributions())
                    {
                        obj.put(Fields.CONTRIBUTIONS, jsonObject.get(Fields.CONTRIBUTIONS));
                    }
                    if(irc.isOpeningBalances())
                    {
                        obj.put(Fields.OPENING_BALANCES, jsonObject.get(Fields.OPENING_BALANCES));
                    }
                    if(irc.isPensionDrawDown())
                    {
                        obj.put(Fields.PENSION_DRAW_DOWN, jsonObject.get(Fields.PENSION_DRAW_DOWN));
                    }
                    if(irc.isYear())
                    {
                        obj.put(Fields.AP, jsonObject.get(Fields.AP));
                    }
                    if(jsonObject.getString(Fields.STATUS).equals(Fields.REGISTERED))
                    {
                        obj.put(Fields.STATUS, Fields.REGISTERED);
                        obj.put(Fields.REGISTERED, jsonObject.get(Fields.CONTRIBUTIONS));
                        obj.put(Fields.UN_REGISTERED, 0);
                    }
                    else
                    {
                        obj.put(Fields.STATUS, Fields.UN_REGISTERED);
                        obj.put(Fields.UN_REGISTERED, jsonObject.get(Fields.CONTRIBUTIONS));
                        obj.put(Fields.REGISTERED, 0);
                    }
                    jsonarray.put(obj);
                }
                jLogger.i("The final array >>>>>>>>>>>>>>>> " + jsonarray + " <<<<<<<<<<<<<");

                return "{\"success\": true,\"rows\":" + jsonarray.toString() + "}";
                //return new JSONObject(jsonarray);
            }
            else
            {
                return null;
            }
        } catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public JSONObject getMemberBalances(String memberID) {
        try {
            JSONObject response = URLGet(APICall.GET_MEMBER_BALANCES + memberID);
            if(response.getBoolean(Fields.SUCCESS))
            {
                JSONArray res = (JSONArray) response.get(Constants.ROWS);
                double totalReg = 0;
                double totalUnreg = 0;
                double finalTotal = 0;
                String status = null;
                for(int i = 0; i < res.length(); i ++)
                {
                    JSONObject obj = res.getJSONObject(i);

                    status = obj.get("status").toString();

                    if (status.equals("Registered")) {
                        totalReg = obj.getDouble(Fields.TOTAL);
                    }
                    if (status.equals("Unregistered")) {
                        totalUnreg = obj.getDouble(Fields.TOTAL);
                    }

                    finalTotal = totalReg + totalUnreg;

                }
                return new JSONObject().put(Fields.SUCCESS, true).put("total", finalTotal);
            }
            else
                return null;
        } catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public List<BenefitPayment> getBenefitPayments(String schemeID, int start, int count) {
        JSONObject response;
        try {
            response = URLGet(APICall.SCHEME_GET_SCHEME_BENEFIT_PAYMENTS + schemeID + "/?start=" + start + "&size=" + count);
            if(response.getBoolean(Fields.SUCCESS))
            {
                return this.benefitPaymentsFromJSON(response);
            }
            else
            {
                return null;
            }
        } catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public List<SchemeReceipt> getSchemeReceipts(String schemeID, int start, int count) {
        Constants.RECORD_COUNT = 0;
        JSONObject response;
        try {
            response = URLGet(APICall.SCHEME_GET_SCHEME_RECEIPTS + schemeID);
            if(response.get(Fields.SUCCESS).equals(true))
            {
                return this.schemeReceiptsFromJSON(response);
            }
            else
            {
                return null;
            }
        } catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public List<AgentCommission> getAgentCommissions(String agentId, int start, int count) {
        Constants.RECORD_COUNT = 0;
        JSONObject response;
        try {
            response = URLGet(APICall.GET_AGENT_COMMISSIONS +  agentId);
            if(response.get(Fields.SUCCESS).equals(true))
            {
                return this.agentCommissionsFromJSON(response);
            }
            else
            {
                return null;
            }
        } catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public List<AgentClient> getAgentClients(String agentId, int start, int count) {
        Constants.RECORD_COUNT = 0;
        JSONObject response;
        try {
            response = URLGet(APICall.GET_AGENT_CLIENTS +  agentId);
            jLogger.i("Response is: " + response);

            if(response.get(Fields.SUCCESS).equals(true))
            {
                return this.agentClientsFromJSON(response);
            }
            else
            {
                return null;
            }
        } catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public JSONObject listMembers(String schemeID, String profileID) {
        JSONObject response;
        try {
            response = URLGet(APICall.MEMBER_STATISTICS_STATUS_DISTRIBUTION + schemeID+"/"+profileID);
            if(response.getBoolean(Fields.SUCCESS))
            {
                return response;
            }
            else
                return null;
        } catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public List<XiMember> getMemberListing(String profileID, String profile, String schemeID, int start, int size) {
        JSONObject response;
        try {
            response = URLPost(APICall.GET_MEMBER_LISTING + profileID + "/" + profile + "/" + schemeID + "/?start=" + start + "&size=" + size, "", Constants.APPLICATION_X_WWW_FORM_URLENCODED);
            if (response.get(Fields.SUCCESS).equals(true)) {
                return this.xiMembersFromJSON(response);
            } else {
                return null;
            }
        }  catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public XiMember getMemberDetails(String memberID, String schemeId) {
        JSONObject response;
        try {
            response = URLGet(APICall.GET_MEMBER_DETAILS + memberID);
            jLogger.i("Member details respone >>>>>>>>>>> " + response + " <<<<<<<<<<<<<<<<<<<<");
            if(response.getBoolean(Fields.SUCCESS))
            {
                JSONArray jsonArray = (JSONArray) response.get(Constants.ROWS);
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                return this.xiMemberFromJson(jsonObject);
            }
            else {
                return null;
            }
        }  catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public JSONObject searchProfilesJSON(String search, String identifier, String profile, String schemeID, int start, int end) {
        try {
            return URLPost(APICall.SEARCH_FOR_MEMBER_DETAILS + identifier + "/" + search + "/" + profile + "/" + schemeID + "/" + start + "/" + end, "", Constants.APPLICATION_X_WWW_FORM_URLENCODED);
        }  catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public List<XiMember> searchProfiles(String search, String identifier, String profile, String schemeID, int start, int end) {
        try {
            JSONObject response = URLPost(APICall.SEARCH_FOR_MEMBER_DETAILS + identifier + "/" + search + "/" + profile + "/" + schemeID + "/" + start + "/" + end, "", Constants.APPLICATION_X_WWW_FORM_URLENCODED);
            return this.xiMembersFromJSON(response);
        }  catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public JSONObject getReasonsForExit() {
        JSONObject response;
        try {
            response = URLGet(APICall.SCHEME_GET_REASONS_FOR_EXIT + Constants.ALL);
            return response;
        }  catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public JSONObject getExitsInYear(String schemeID) {
        try {
            return URLGet(APICall.SCHEME_GET_SCHEME_BENEFITS_WITHIN_YEAR + schemeID);

        }  catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public JSONObject getAgentCommission(String agentID) {
        try {
            return URLGet(APICall.COMMISSIONS_GET + agentID);
        } catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public boolean sendEmail(String recipients, String sender, String senderName, String subject, String message, String schemeID, boolean attachment, String attachment_url) {
        JSONObject response;
        JSONObject params = new JSONObject();
        try {
            params.put(Fields.NOTIFICATION_PLATFORM, Constants.EMAIL)
                    .put(Fields.RECIPIENTS, recipients)
                    .put(Fields.MAIL_SENDER, sender)
                    .put(Fields.SENDER_NAME, senderName)
                    .put(Fields.SUBJECT, subject)
                    .put(Fields.MSG, message)
                    .put(Fields.SCHEME_ID, schemeID);
            if(attachment)
                params.put(Fields.ATTACHMENTS, attachment_url);
            else
                params.put(Fields.ATTACHMENTS, new ArrayList<String>());
            response = URLPost(APICall.NOTIFICATION_PUSH, params.toString(), Constants.APPLICATION_JSON);
            return response.getBoolean(Fields.SUCCESS);
        } catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return false;
        }

    }

    @Override
    public JSONObject searchSchemes(String search) {
        JSONObject response;
        try {
            response = URLGet(APICall.SCHEME_GET_SCHEME_BY_NAME + search);
            if(response.getBoolean(Fields.SUCCESS))
            {
                return response;
            }
            else
                return null;
        } catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public List<XiMember> due4Retirement(String schemeID) {

        if (schemeID == null || schemeID.isEmpty()) {
            schemeID = "0";
        }

        JSONObject response;
        try {
            response = URLGet(APICall.GET_MEMBERS_DUE_FOR_RETIREMENT + schemeID + "/0/100000");
            if (response.getBoolean(Fields.SUCCESS)) {
                return this.xiMembersFromJSON(response);
            } else {
                return null;
            }
        } catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public List<BenefitPayment> searchPayments(String schemeID, String from, String to, int start, int count) {
        JSONObject response;
        try {
            response = URLGet(APICall.SCHEME_GETS_CHEME_BENEFIT_PAYMENTS_BETWEEN_DATES + schemeID + "/" + from + "/" + to);
            if(response.getBoolean(Fields.SUCCESS))
            {
                return this.benefitPaymentsFromJSON(response);
            }
            else
            {
                return null;
            }
        } catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public List<SchemeReceipt> searchReceipts(String schemeID, String from, String to, int start, int count) {
        JSONObject response;
        try {
            response = URLGet(APICall.SCHEME_GET_SCHEME_RECEIPTS_BETWEEN_DATES + schemeID + "/" + from + "/" + to);
            if(response.getBoolean(Fields.SUCCESS))
            {
                return this.schemeReceiptsFromJSON(response);
            }
            else
                return null;
        } catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public JSONObject getNewMembersInYear(String schemeID, String profileID) {
        JSONObject response;
        try {
            response = URLPost(APICall.NEW_MEMBER_LISTING_WITHIN_YEAR + schemeID+"/"+profileID, "", Constants.APPLICATION_X_WWW_FORM_URLENCODED);
            return response;
        }  catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }
    @Override
    public List<Beneficiary> getBeneficiariesList(String memberID) {
        JSONObject response;
        try {
            response = URLPost(APICall.GET_MEMBER_BENEFICIARIES + memberID,"", Constants.APPLICATION_X_WWW_FORM_URLENCODED);

            if(response.getBoolean(Fields.SUCCESS))
            {
                JSONArray res = (JSONArray) response.get(Constants.ROWS);
                List<Beneficiary> beneficiaries = new ArrayList<>();

                for(int i = 0; i < res.length(); i ++)

                {
                    JSONObject obj = res.getJSONObject(i);
                    Beneficiary beneficiary = new Beneficiary();
                    beneficiary.setName(helper.toString(obj.get(Fields.NAME)));
                    beneficiary.setFirstname(helper.toString(obj.get(Fields.FIRSTNAME)));
                    beneficiary.setSurname(helper.toString(obj.get(Fields.SURNAME)));
                    beneficiary.setOthernames(helper.toString(obj.get(Fields.OTHERNAMES)));
                    beneficiary.setRelationship(helper.toString(obj.get(Fields.RELATIONSHIP)));
                    beneficiary.setLumpsumEntitlement(helper.toString(obj.get(Fields.LUMPSUM_ENTITLEMENT)));
                    beneficiary.setMstatus(helper.toString(obj.get(Fields.MSTATUS)));
                    jLogger.i("Marital status >>>>>>>>>>>>>>>> " + beneficiary.getMstatus() + " <<<<<<<<<<<<<<<<");
                    beneficiary.setGender(helper.toString(obj.get(Fields.GENDER)));
                    beneficiary.setStatus(helper.toString(obj.get(Fields.STATUS)));
                    beneficiary.setRelShipCategory(helper.toString(obj.get(Fields.CATEGORY)));
                    beneficiary.setId(helper.toLong(obj.get(Fields.ID)));
                    beneficiaries.add(beneficiary);
                }
                return beneficiaries;
            }
            else
            {
                return null;
            }
        }  catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public JSONObject getBeneficiaries(String memberID) {
        JSONObject response;
        try {
            response = URLPost(APICall.GET_MEMBER_BENEFICIARIES + memberID,"", Constants.APPLICATION_X_WWW_FORM_URLENCODED);
            if(response.getBoolean(Fields.SUCCESS))
            {
                JSONArray res = (JSONArray) response.get(Constants.ROWS);
                JSONArray resp = new JSONArray();
                for(int i = 0; i < res.length(); i ++)

                {
                    JSONObject obj = res.getJSONObject(i);
                    jLogger.i("The benef data from Xi >>>>>>>>>>>>>>>>  " + obj + " <<<<<<<<<<<<<<<<<<<");
                    JSONObject beneficiary = new JSONObject();
                    beneficiary.put(Fields.NAME, obj.get(Fields.NAME));
                    beneficiary.put(Fields.AMOUNT, obj.get(Fields.LUMPSUM_ENTITLEMENT));
                    beneficiary.put(Fields.ID, obj.get(Fields.ID));
                    beneficiary.put(Fields.RELATIONSHIP, obj.get(Fields.RELATIONSHIP));
                    resp.put(beneficiary);
                }

                return new JSONObject().put(Fields.SUCCESS, true).put(Constants.ROWS, resp);
            }
            else
            {
                return null;
            }
        }  catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public JSONObject getSchemeContributions(String schemeID, String profileID) {
        JSONObject response;
        try {
            response = URLGet(APICall.SCHEME_GETTOTALSCHEMECONTRIBUTIONS + schemeID + "/" + profileID);
            jLogger.i("Scheme contributions json resp >>>>>>>>>>>>>>>>>> " + response + " <<<<<<<<<<<<<");
            return  response;
        } catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public JSONObject getMemberContributions(String memberID) {
        JSONObject response;
        try {
            response = URLGet(APICall.GETMEMBERCONTRIBUTIONS + memberID);
            jLogger.i("Member contr json response >>>>>>>>>>>>> " + response + " <<<<<<<<<<<<<<<<<<<");
        } catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
        try {
            if(response.getBoolean(Fields.SUCCESS))
            {
                JSONArray res = (JSONArray) response.get(Constants.ROWS);
                List<String> years = new ArrayList<>();
                for(int i = 0; i < res.length(); i ++)
                {
                    JSONObject jsonObject = res.getJSONObject(i);
                    if(!years.contains(jsonObject.get(Fields.YEAR).toString()))
                        years.add(jsonObject.get(Fields.YEAR).toString());
                    jLogger.i("Years >>>>>>>>>>>>>> " + years + " <<<<<<<<<<<<<<<");
                }
                Set<String> hs = new HashSet<>();
                hs.addAll(years);
                years.clear();
                years.addAll(hs);
                Collections.sort(years);
                String[] year = years.toArray(new String[years.size()]);
                JSONArray json_array = new JSONArray();
                for (String aYear : year) {
                    JSONArray data = new JSONArray();
                    double yearTotal = 0;
                    for (int i = 0; i < res.length(); i++) {
                        JSONObject obj = new JSONObject();
                        JSONObject jsonobj = res.getJSONObject(i);
                        if (jsonobj.get(Fields.YEAR).toString().equals(aYear)) {
                            obj.put(Fields.YEAR, aYear);
                            obj.put(Fields.MONTH, jsonobj.get(Fields.MONTH).toString());
                            obj.put(Fields.TOTAL, String.valueOf(round(Double.parseDouble(jsonobj.get(Fields.TOTAL).toString()))));
                            try {
                                yearTotal += Double.parseDouble(jsonobj.get(Fields.TOTAL).toString());
                            } catch (Exception ex) {
                                yearTotal += 0;
                            }
                            data.put(obj);
                        }
                    }
                    json_array.put(new JSONObject().put(Fields.YEAR, aYear).put(Fields.TOTAL, round(yearTotal))).put(data);
                }
                return new JSONObject().put(Fields.SUCCESS, true).put(Constants.ROWS, json_array);
            }
            else
                return null;
        }  catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public List<UserProfile> getUserProfiles() {
        JSONObject response;
        try {
            response = URLGet(APICall.PROFILE_GET_PROFILES);
            List<UserProfile> userProfiles = new ArrayList<>();
            if(response.getBoolean(Fields.SUCCESS))
            {
                JSONArray res = (JSONArray) response.get(Constants.ROWS);
                for(int i = 0; i < res.length(); i++){
                    JSONObject jsonObject = res.getJSONObject(i);
                    UserProfile userProfile = new UserProfile();
                    userProfile.setId(jsonObject.getLong(Fields.ID));
                    userProfile.setName(jsonObject.getString(Fields.NAME));
                    userProfiles.add(userProfile);
                }
                return userProfiles;
            }
            else
            {
                return null;
            }
        } catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public JSONObject getMemberCummulativeInterest(String memberID) {
        try {
             return URLPost(APICall.GET_MEMBER_CUMMULATIVE_INTEREST + memberID, "", Constants.APPLICATION_X_WWW_FORM_URLENCODED);
            } catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public JSONObject getAccountingPeriod(String date, String schemeID) {
        JSONObject response;
        try {
            response = URLPost(APICall.GET_ACCOUNTING_PERIOD_FROM_DATE_FOR_SCHEME + date + "/" + schemeID, "", Constants.APPLICATION_X_WWW_FORM_URLENCODED);
            jLogger.i("The response >>>>>>>>>>>>>>>>>> " + response + " <<<<<<<<<<<<<<<<<<<");
            return response;
        } catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public JSONObject getAllAccountingPeriods(String schemeID) {
        JSONObject response;
        try {
            response = URLGet(APICall.GET_SCHEME_ACCOUNTING_PERIODS + schemeID);
            jLogger.i("The response >>>>>>>>>>>>>>>>>> " + response + " <<<<<<<<<<<<<<<<<<<");
            return response;
        } catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public JSONObject getFundValueAsAt(String date, String periodType, String schemeID, String profileID) {

        profileID = "0";

        JSONObject response;
        try {
            response =  URLGet(APICall.SCHEME_GET_FUND_VALUE_AS_AT + date + "/" + periodType + "/" + schemeID+"/"+profileID);
            return response;
        } catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public JSONObject getSchemeCurrency(String schemeID) {
        JSONObject response;
        try {
            response = URLGet(APICall.SCHEME_GET_SCHEME_BASE_CURRENCY + schemeID);
            response = response.getJSONArray(Fields.CURRENCY).getJSONObject(0);
            jLogger.i("This is the response for currency >>>>>>>>>>>>>>>>>>>>>>>> " + response + " <<<<<<<<<<<<");
            return response;
        } catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public JSONObject getMemberAverageInterest(String memberID) {
        try {
            return URLPost(APICall.GET_MEMBER_AVERAGE_INTEREST + memberID, "", Constants.APPLICATION_X_WWW_FORM_URLENCODED);
            } catch (JSONException je) {
            return null;
        }

    }

    @Override
    public List<Scheme> getProfileSchemes(String user, String profile) {
        String ordinal = profileLoginFieldBeanI.findByProfile(profile);
        if (ordinal.equals("TAX_NUMBER")) {
            ordinal = "PIN";
        }

        jLogger.i(" Ordinal is >>>>>>>>>>>> " + ordinal + " <<<<<<<<<<<<<<<<<<<<<");

        JSONObject response;
        try {
            response = URLPost(APICall.GET_MEMBER_SCHEMES + ordinal + "/" + user + "/" + profile, "", Constants.APPLICATION_X_WWW_FORM_URLENCODED);
            if(response.getBoolean(Fields.SUCCESS))
            {
                return this.schemesFromJSON(response);
            }
            else
                return null;
        } catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public boolean uploadMemberDocument(String memberId, String docName, String docNotes, String docNum, String docTypeId) {
        JSONObject response;
        try {
            response = URLPost(APICall.UPLOAD + memberId  + "/" + docName + "/" + docNotes + "/" + docNum + "/" + docTypeId, "", Constants.APPLICATION_X_WWW_FORM_URLENCODED);
            return response.getBoolean(Fields.SUCCESS);
        }  catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return false;
        }
    }

    @Override
    public XiMember memberExistsInScheme(String profile, String value, String schemeID) {
        String ordinal = profileLoginFieldBeanI.findByProfile(profile);
        JSONObject response;
        try {
            response = URLGet(APICall.CHECK_MEMBER_EXISTS_IN_SCHEME + ordinal + "/" + value + "/" + profile + "/" + schemeID);
            XiMember xiMember = new XiMember();
            xiMember.setId(helper.toLong(response.get(Fields.MEMBER_ID)));
            return xiMember;
        } catch (JSONException je) {
            jLogger.e("We have a json exception " + je.getMessage());
            return null;
        }
    }

    @Override
    public boolean saveOrUpdateBeneficiary(String params) {
        JSONObject response;
        try {
            response = URLPost(APICall.SAVE_OR_UPDATE_BENEFICIARY_DETAILS, params, Constants.APPLICATION_JSON);
            return response.getBoolean(Fields.SUCCESS);
        } catch (JSONException je) {
            jLogger.e("We have a json exception saving/updating member" + je.getMessage());
            return false;
        }
    }

    @Override
    public boolean saveOrUpdateMember(String params) {
        JSONObject response;
        try {
            response = URLPost(APICall.SAVE_OR_UPDATE_MEMBER, params, Constants.APPLICATION_JSON);
            return response.getBoolean(Fields.SUCCESS);
        } catch (JSONException je) {
            jLogger.e("We have a json exception saving/updating member");
            return false;
        }
    }

    @Override
    public boolean uploadMemberDocument(String params) {
        JSONObject response;
        try {
            response = URLPost(APICall.UPLOAD_MEMBER_DOCUMENT, params, Constants.APPLICATION_JSON);
            return response.getBoolean(Fields.SUCCESS);
        } catch (JSONException je) {
            jLogger.e("We have a json exception uploading document");
            return false;
        }
    }

    @Override
    public XiMember memberExists(String profile, String value) {
        String ordinal = profileLoginFieldBeanI.findByProfile(profile);
        jLogger.i("Ordinal is >>>>>>>>> " + ordinal + " <<<<<<<<<<<<<");
        if (ordinal.equals("TAX_NUMBER")) {
            ordinal = "PIN";
        }
        jLogger.i("Now ordinal >>>>>>>>>>>> " + ordinal + " <<<<<<<<<<<<<");
        JSONObject response;
        try {
            response = URLPost(APICall.CHECK_MEMBER_EXISTS + ordinal  + "/" + value + "/" + profile, "", Constants.APPLICATION_X_WWW_FORM_URLENCODED);

            jLogger.i("Response of member exists is: " + response);

            XiMember xiMember = new XiMember();
            xiMember.setId(helper.toLong(response.get(Fields.MEMBER_ID)));
            xiMember.setProfile(response.getString(Fields.PROFILE));
            xiMember.setEmailAddress(response.getString(Fields.EMAIL));
            Long Scheme_id = helper.toLong(response.get(Fields.SCHEME_ID));
            xiMember.setSchemeId(Long.toString(Scheme_id));
            return xiMember;
        } catch (JSONException je) {
            jLogger.e("We have a json exception checking if the member exists" + je.getMessage());
            return null;
        }
    }
    public boolean saveOrUpdateSponsor(String params)
    {
        JSONObject response;
        try {
            response = URLPost(APICall.SPONSOR_SAVE_OR_UPDATE_POTENTIAL_SPONSOR, params, Constants.APPLICATION_JSON);
            return response.getBoolean(Fields.SUCCESS);
        } catch (JSONException je) {
            jLogger.e("We have a json exception saving/updating sponsor details");
            return false;
        }

    }
    private boolean isHttps(String link)
    {
        return link.trim().substring(0, Math.min(link.length(), 5)).equalsIgnoreCase(Constants.HTTPS);
    }

    private JSONObject URLGet(String link) throws JSONException {
        Setting setting = this.getSettings();
        link = setting.getXiPath() + link;
        jLogger.i("Http Calling " + link + "....");
        return isHttps(link) ? HttpsGet(link) : HttpGet(link);
    }
    private HttpsURLConnection setHttpsHeaders(Setting settings, HttpsURLConnection httpsConn, String method, String encoding, String params)
    {
        try {
            httpsConn.setRequestMethod(method);
            httpsConn.setReadTimeout(Constants.TIMEOUT);
            httpsConn.setRequestProperty(Fields.USERNAME, settings.getUsername());
            httpsConn.setRequestProperty(Fields.PASSWORD, settings.getPassword());
            if(encoding != null)
                httpsConn.setRequestProperty(Constants.CONTENT_TYPE, encoding);
            if(params != null) {
                httpsConn.setDoOutput(true);
                try {
                    OutputStream os = httpsConn.getOutputStream();
                    os.write(params.getBytes());
                    os.flush();
                    os.close();
                } catch (IOException ioe) {
                    jLogger.e("We have a problem posting the provided parameters");
                    return null;
                }
            }
            return httpsConn;
        } catch (ProtocolException pe) {
            jLogger.e("We have an error setting up headers for the connection");
            return null;
        }
    }
    private HttpURLConnection setHttpHeaders(Setting settings, HttpURLConnection httpConn, String method, String encoding, String params)
    {
        try {
            httpConn.setRequestMethod(method);
            httpConn.setReadTimeout(Constants.TIMEOUT);
            httpConn.setRequestProperty(Fields.USERNAME, settings.getUsername());
            httpConn.setRequestProperty(Fields.PASSWORD, settings.getPassword());
            if(encoding != null)
                httpConn.setRequestProperty(Constants.CONTENT_TYPE, encoding);
            if(params != null) {
                httpConn.setDoOutput(true);
                try {
                    OutputStream os = httpConn.getOutputStream();
                    os.write(params.getBytes());
                    os.flush();
                    os.close();
                } catch (IOException ioe) {
                    jLogger.e("We have a problem posting the provided parameters");
                    return null;
                }
            }
            return httpConn;
        } catch (ProtocolException pe) {
            jLogger.e("We have an error setting up headers for the connection");
            return null;
        }
    }
    private JSONObject HttpsGet(String link) throws JSONException
    {
        Setting settings = getSettings();
        StringBuilder sb;
        HttpsURLConnection httpConn;
        InputStreamReader in;
        URL url;
        try {
            url = new URL(link);
        } catch (MalformedURLException ue) {
            jLogger.e("We have a malformed url exception " + ue.getMessage());
            return null;
        }
        try {
            httpConn = (HttpsURLConnection) url.openConnection();
            if (httpConn != null)
            {
                httpConn = this.setHttpsHeaders(settings, httpConn, Constants.HTTP_GET, null, null);
                if (httpConn != null && httpConn.getInputStream() != null) {
                    in = new InputStreamReader(httpConn.getInputStream(),
                            Charset.defaultCharset());
                    sb = this.readInputStream(in);
                    in.close();
                    return sb != null ? new JSONObject(sb.toString().trim()) : null;
                }
                else
                {
                    jLogger.e("We have a problem connecting to the provided url");
                    return null;
                }
            }
            else
            {
                jLogger.e("The connection link was empty (null) ");
                return null;
            }
        } catch (IOException ioe) {
            jLogger.e("We have an IOException " + ioe.getMessage());
            return this.technicalError(ioe.getMessage());
        }
    }
    private String decrypt(String string)
    {
        try {
            Crypta crypt = new Crypta();
            string = crypt.decrypt(string);
        } catch (Exception e) {
            jLogger.i("We have a general exception attempting to encrypt" + e.getMessage());
            return null;
        }
        return string;
    }
    private Setting getSettings()
    {

        Setting settings = settingBeanI.find();
        if(settings != null)
        {
            if(settings.isEncrypt())
            {
                settings.setXiPath(decrypt(settings.getXiPath()));
                settings.setPassword(decrypt(settings.getPassword()));
                settings.setUsername(decrypt(settings.getUsername()));
                settings.setXiReportPath(decrypt(settings.getXiReportPath()));
                settings.setXiReportUsername(decrypt(settings.getXiReportUsername()));
                settings.setXiReportPassword(decrypt(settings.getXiReportPassword()));
            }
        }
        return settings;
    }
    private JSONObject HttpGet(String link) throws JSONException
    {
        Setting settings = getSettings();
        StringBuilder sb;
        HttpURLConnection httpConn;
        InputStreamReader in;
        URL url;
        try {
            url = new URL(link);
        } catch (MalformedURLException ue) {
            jLogger.e("We have a malformed url exception " + ue.getMessage());
            return null;
        }
        try {
            httpConn = (HttpURLConnection) url.openConnection();
            if (httpConn != null)
            {
                httpConn = this.setHttpHeaders(settings, httpConn, Constants.HTTP_GET, null, null);
            }
            if (httpConn != null && httpConn.getInputStream() != null) {
                in = new InputStreamReader(httpConn.getInputStream(),
                        Charset.defaultCharset());
                sb = this.readInputStream(in);
                in.close();
                return sb != null ? new JSONObject(sb.toString().trim()) : null;
            }
            else
            {
                jLogger.e("The connection link was empty (null) ");
                return null;
            }
        } catch (IOException ioe) {
            jLogger.e("We have an IO Exception " + ioe.getMessage());
            return this.technicalError(ioe.getMessage());
        }
    }
    private JSONObject URLPost(String link, String params, String encoding) throws JSONException {
        Setting setting = this.getSettings();
        link = setting.getXiPath() + link;
        jLogger.i("Http Calling " + link + "....");
        return isHttps(link) ? HttpsPost(link, params, encoding) : HttpPost(link, params, encoding);
    }
    private JSONObject HttpsPost(String link, String params, String encoding) throws JSONException
    {
        Setting settings = this.getSettings();
        StringBuilder sb;
        HttpsURLConnection urlConn;
        InputStreamReader in;
        URL url;
        try {
            url = new URL(link);
        } catch (MalformedURLException mue) {
            jLogger.e("We've encountered a malformed url exception" + mue.getMessage());
            return null;
        }
        try {
            urlConn = (HttpsURLConnection) url.openConnection();
            if (urlConn != null)
            {
                urlConn = this.setHttpsHeaders(settings, urlConn, Constants.HTTP_POST, encoding, params);
                in = new InputStreamReader(urlConn.getInputStream(),
                        Charset.defaultCharset());
                sb = this.readInputStream(in);
                in.close();
                return sb != null ? new JSONObject(sb.toString().trim()) : null;
            }
            else
            {
                jLogger.e("We have an empty (null) connection to the url");
                return null;
            }
        } catch (IOException ioe) {
            jLogger.e("We have an IO exception" + ioe.getMessage());
            return this.technicalError(ioe.getMessage());
        } catch (NullPointerException npe) {
            jLogger.e("We have a Null Pointer Exception " + npe.getMessage());
            return this.technicalError(npe.getMessage());
        }
    }
    private StringBuilder readInputStream(InputStreamReader in)
    {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(in);
            int cp;
            while ((cp = bufferedReader.read()) != -1) {
                sb.append((char) cp);
            }
            bufferedReader.close();
            jLogger.i("Response is " + sb.toString());
            return sb;
        } catch (IOException ioe)
        {
                jLogger.i("Response is null");
            return null;
        }
    }
    private JSONObject technicalError(String message)
    {
        try {
            return new JSONObject().put(Fields.SUCCESS, false).put(Fields.MESSAGE, Message.AN_ERROR_WAS_ENCOUNTERED_FETCHING_THE_DATA_FROM_THE_URL + message);
        } catch (JSONException je) {
            return null;
        }
    }

    private JSONObject HttpPost(String link, String params, String encoding) throws JSONException
    {
        Setting settings = getSettings();
        StringBuilder sb = new StringBuilder();
        HttpURLConnection urlConn;
        InputStreamReader in;
        URL url;
        try {
            url = new URL(link);
        } catch (MalformedURLException mue) {
            jLogger.e("We have a MalformedURL Exception");
            return null;
        }
        try {
            urlConn = (HttpURLConnection) url.openConnection();
            if (urlConn != null)
            {
                urlConn = this.setHttpHeaders(settings, urlConn, Constants.HTTP_POST, encoding, params);
                if (urlConn != null && urlConn.getInputStream() != null) {
                    in = new InputStreamReader(urlConn.getInputStream(),
                            Charset.defaultCharset());
                    BufferedReader bufferedReader = new BufferedReader(in);
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                    in.close();
                    return new JSONObject(sb.toString().trim());
                }
                else
                    return null;
            }
            else
            {
                jLogger.e("We have an empty(null) connection to the resource");
                return null;
            }
        } catch (IOException ioe) {
            jLogger.e("We have an IOException " + ioe.getMessage());
            return this.technicalError(ioe.getMessage());
        }

    }

    private double round(double value) {

        long factor = (long) Math.pow(10, 2);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    private XiMember xiMemberFromJson(JSONObject jsonObject)
    {

        XiMember xiMember = new XiMember();
        try {
            xiMember.setSchemeId(jsonObject.getString(Fields.SCHEME_ID));
            xiMember.setId(jsonObject.getLong(Fields.ID));
            xiMember.setMbio_id(jsonObject.getString(Fields.MBIO_ID));
            xiMember.setMemberNo(jsonObject.getString(Fields.MEMBER_NO));
            xiMember.setMembershipNo(jsonObject.getString(Fields.MEMBERSHIP_NO));
            xiMember.setPartyRefNo(jsonObject.getString(Fields.PARTYREFNO));
            xiMember.setPartnerNo(jsonObject.getString(Fields.PARTNER_NUMBER));
            xiMember.setPolicyNo(jsonObject.getString(Fields.POLICY_NO));
            xiMember.setStaffNo(jsonObject.getString(Fields.STAFF_NO));
            xiMember.setName(jsonObject.getString(Fields.NAME));
            xiMember.setIdNumber(jsonObject.getString(Fields.ID_NO));
            xiMember.setTerminateCover(jsonObject.getString(Fields.TERMINATE_COVER));
            xiMember.setPinNo(jsonObject.getString(Fields.PIN_NO));
            xiMember.setPostalAddress(jsonObject.getString(Fields.POSTAL_ADDRESS));
            xiMember.setPhoneNumber(jsonObject.getString(Fields.CELL_PHONE));
            xiMember.setEmailAddress(jsonObject.getString(Fields.EMAIL));
            xiMember.setGender(jsonObject.getString(Fields.GENDER));
            xiMember.setDepartment(jsonObject.getString(Fields.DEPARTMENT));
            xiMember.setDateOfBirth(jsonObject.getString(Fields.DOB));
            xiMember.setMaritalStatus(jsonObject.getString(Fields.MARITAL_STATUS));
            xiMember.setDateJoinedScheme(jsonObject.getString(Fields.DATE_JOINED_SCHEME));
            xiMember.setTown(jsonObject.getString(Fields.TOWN));
            xiMember.setCountry(jsonObject.getString(Fields.COUNTRY));
            xiMember.setAnnualPensionableSalary(jsonObject.getString(Fields.CURRENT_ANNUAL_PENSIONABLE_SALARY));
            xiMember.setFirstname(jsonObject.getString(Fields.FIRSTNAME));
            xiMember.setSurname(jsonObject.getString(Fields.SURNAME));
            xiMember.setOthernames(jsonObject.getString(Fields.OTHERNAMES));
            xiMember.setTitle(jsonObject.getString(Fields.TITLE));
            xiMember.setDesignation(jsonObject.getString(Fields.DESIGNATION));
            xiMember.setRegion(jsonObject.getString(Fields.REGION));
            xiMember.setCounty(jsonObject.getString(Fields.SUBREGION));
            xiMember.setMbshipStatus(jsonObject.getString(Fields.MBSHIP_STATUS));
            xiMember.setDepot(jsonObject.getString(Fields.DEPOT));

        } catch (JSONException je) {
            jLogger.e("We have a json exception extracting member" + je.getMessage());
        }
        return xiMember;
    }
    private List<SchemeReceipt> schemeReceiptsFromJSON(JSONObject response)
    {
        List<SchemeReceipt> schemeReceipts = new ArrayList<>();
        try {
            Constants.RECORD_COUNT = response.getInt(Fields.TOTALCOUNT);
            JSONArray res = (JSONArray) response.get(Constants.ROWS);
            for(int i = 0; i < res.length(); i ++)
            {
                JSONObject receipt = res.getJSONObject(i);
                SchemeReceipt schemeReceipt = new SchemeReceipt();
                try {
                    schemeReceipt.setDate(helper.humanReadableDate(receipt.get(Fields.DATERECEIVED).toString()));
                }
                catch (IllegalArgumentException ex)
                {
                    schemeReceipt.setDate(receipt.get(Fields.DATERECEIVED).toString());
                }
                schemeReceipt.setPayee(receipt.get(Fields.PAYEE).toString());
                schemeReceipt.setAmount(helper.format_no(round(Double.parseDouble(receipt.get(Fields.AMOUNT).toString()))));
                schemeReceipt.setCategory(receipt.get(Fields.TXNCAT).toString());
                schemeReceipt.setType(receipt.get(Fields.TXNTYPE).toString());
                schemeReceipt.setMode(receipt.get(Fields.PAYMENTMETHOD).toString());
                schemeReceipt.setRef(receipt.get(Fields.CHEQNO).toString());
                schemeReceipt.setReceipt_no(receipt.get(Fields.RECEIPTNO).toString());
                schemeReceipts.add(schemeReceipt);
            }
            return schemeReceipts;
        } catch (JSONException je) {
            jLogger.e("We have a json exception extracting receipts " + je.getMessage());
            return null;
        }
    }

    private List<AgentCommission> agentCommissionsFromJSON(JSONObject response) {
        List<AgentCommission> agentCommissions = new ArrayList<>();
        try {
            Constants.RECORD_COUNT = response.getInt(Fields.TOTALCOUNT);
            JSONArray res = (JSONArray) response.get(Constants.ROWS);
            for (int i = 0; i < res.length(); i++) {
                JSONObject receipt = res.getJSONObject(i);
                AgentCommission agentCommission = new AgentCommission();
                agentCommission.setCommission(receipt.get(Fields.COMMISSION).toString());
                agentCommission.setMonth(receipt.get(Fields.MONTH).toString());
                agentCommission.setYear(receipt.get(Fields.YEAR).toString());
                agentCommission.setContr(receipt.get(Fields.CONTRIBUTION).toString());
                agentCommission.setNet(receipt.get(Fields.NET).toString());
                agentCommissions.add(agentCommission);
            }
            return agentCommissions;
        } catch (JSONException je) {
            jLogger.e("We have a json exception extracting agent commissions " + je.getMessage());
            return null;
        }
    }

    private List<AgentClient> agentClientsFromJSON(JSONObject response) {
        List<AgentClient> agentClients = new ArrayList<>();
        try {
            Constants.RECORD_COUNT = response.getInt(Fields.TOTALCOUNT);
            JSONArray res = (JSONArray) response.get(Constants.ROWS);
            for (int i = 0; i < res.length(); i++) {
                JSONObject receipt = res.getJSONObject(i);

                AgentClient agentClient = new AgentClient();
                agentClient.setClientType(receipt.get(Fields.CLIENT_TYPE).toString());
                agentClient.setName(receipt.get(Fields.NAME).toString());
                agentClient.setPolicyNo(receipt.get(Fields.POLICY_NO).toString());
                agentClients.add(agentClient);
            }
            return agentClients;
        } catch (JSONException je) {
            jLogger.e("We have a json exception extracting agent clients " + je.getMessage());
            return null;
        }
    }

    private List<BenefitPayment> benefitPaymentsFromJSON(JSONObject response)
    {
        try {
            Constants.RECORD_COUNT = response.getInt(Fields.TOTALCOUNT);
            List<BenefitPayment> benefitPayments = new ArrayList<>();
            JSONArray res = (JSONArray) response.get(Constants.ROWS);
            for(int i = 0; i < res.length(); i ++)
            {
                JSONObject payment = res.getJSONObject(i);
                BenefitPayment bp = new BenefitPayment();
                try {
                    bp.setGross(helper.format_no(round(Double.parseDouble(String.valueOf(payment.get(Fields.GROSS).toString())))));
                }
                catch (NumberFormatException ex)
                {
                    bp.setGross(Constants.NUMBER_ZER0);
                }
                try {
                    bp.setTaxFree(helper.format_no(round(Double.parseDouble(String.valueOf(payment.get(Fields.LUMPSUM_TAX_FREE).toString())))));
                }
                catch (NumberFormatException ex)
                {
                    bp.setTaxFree(Constants.NUMBER_ZER0);
                }
                try {
                    bp.setTaxable(helper.format_no(round(Double.parseDouble(String.valueOf(payment.get(Fields.TAXABLE_AMOUNT).toString())))));
                }
                catch (NumberFormatException ex)
                {
                    bp.setTaxable(Constants.NUMBER_ZER0);
                }
                try
                {
                    bp.setWithHolding(helper.format_no(round(Double.parseDouble(String.valueOf(payment.get(Fields.WITH_HOLDING_TAX).toString())))));
                }
                catch (NumberFormatException ex)
                {
                    bp.setWithHolding(Constants.NUMBER_ZER0);
                }
                try {
                    bp.setNet(helper.format_no(round(Double.parseDouble(String.valueOf(payment.get(Fields.NET_PAYMENT).toString())))));
                }
                catch (NumberFormatException ex)
                {
                    bp.setNet(Constants.NUMBER_ZER0);
                }
                try {

                    bp.setDateApproved(helper.humanReadableDate(payment.get(Fields.DATE_APPROVED).toString()));
                }
                catch (IllegalArgumentException ex)
                {
                    bp.setDateApproved(payment.get(Fields.DATE_APPROVED).toString());
                }
                try {
                    bp.setDateOfCalc(helper.humanReadableDate(payment.get(Fields.DATE_OF_CALC).toString()));
                }
                catch (IllegalArgumentException ex)
                {
                    ex.printStackTrace();
                    bp.setDateOfCalc(payment.get(Fields.DATE_OF_CALC).toString());
                }
                bp.setType(payment.get(Fields.PAYMENT_TYPE).toString());
                bp.setPayee(payment.get(Fields.MEMBER).toString());
                benefitPayments.add(bp);
            }
            return benefitPayments;
        } catch (JSONException je) {
            jLogger.e("We have a json exception extracting payments" + je.getMessage());
            return null;
        }
    }
    private List<XiMember> xiMembersFromJSON(JSONObject response) {
        try {
            Constants.RECORD_COUNT = response.getInt(Fields.TOTALCOUNT);
        } catch (JSONException je) {
            jLogger.e("We have a json exception extracting members" + je.getMessage());
        }
        try {
            List<XiMember> xiMembers = new ArrayList<>();
            JSONArray res = (JSONArray) response.get(Constants.ROWS);
            jLogger.i("The response >>>>>>>>>> " + res + " <<<<<<<<<<<<<<<");
            for (int i = 0; i < res.length(); i++) {
                JSONObject jsonObject = res.getJSONObject(i);
                XiMember xiMember = this.xiMemberFromJson(jsonObject);
                xiMembers.add(xiMember);
            }
            return xiMembers;
        } catch (JSONException je) {
            jLogger.e("We have a json exception extracting members" + je.getMessage());
            return null;
        }
    }
    private List<Scheme> schemesFromJSON(JSONObject response)
    {
        List<Scheme> schemes = new ArrayList<>();
        try {
            JSONArray res = (JSONArray) response.get(Constants.ROWS);
            for(int i = 0; i < res.length(); i++){
                JSONObject jsonObject = res.getJSONObject(i);
                jLogger.i("The json object >>>>>>>>>>>>>>>>> " + jsonObject);
                Scheme scheme = new Scheme();
                scheme.setId(jsonObject.getLong(Fields.ID));
                jLogger.i("The scheme id is >>>>>>> " + jsonObject.getLong(Fields.ID));
                scheme.setName(jsonObject.getString("schemeName"));
                jLogger.i("The scheme name >>>>>>>>>>>>> " + jsonObject.getString("schemeName"));
                scheme.setPlanType(jsonObject.getString(Fields.PLAN_TYPE));
                schemes.add(scheme);
            }
            jLogger.i("Schemes found are " + schemes.size());
            return schemes;
        } catch (JSONException je) {
            jLogger.e("We have a json exception extracting schemes" + je.getMessage());
            return null;
        }
    }
}
