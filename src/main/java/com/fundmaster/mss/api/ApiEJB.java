package com.fundmaster.mss.api;

import com.fundmaster.mss.model.*;
import org.json.JSONObject;

import javax.ejb.Local;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by bryanitur on 8/1/16.
 */
@Local
public interface ApiEJB {
    XiMember memberExists(String profile, String value);
    boolean saveOrUpdateSponsor(String params);
    boolean saveOrUpdateMember(String params);
    boolean saveOrUpdateBeneficiary(String params);
    XiMember memberExistsInScheme(String profile, String value, String schemeID);
    boolean uploadMemberDocument(String memberId, String docName, String docNotes, String docNum, String docTypeId);
    List<Scheme> getProfileSchemes(String user, String profile);
    BigDecimal getMemberAverageInterest(String memberID);
    String getSchemeCurrency(String schemeID);
    BigDecimal getFundValueAsAt(String date,String periodType, String schemeID,String profileID);
    long getAccountingPeriod(String date, String schemeID);
    BigDecimal getMemberCummulativeInterest(String memberID);
    List<UserProfile> getUserProfiles();
    String getMemberContributions(String memberID);
    String getSchemeContributions(String schemeID ,String profileID);
    List<Beneficiary> getBeneficiaries(String memberID);
    long getNewMembersInYear(String schemeID,String profileID);
    List<SchemeReceipt> searchReceipts(String schemeID, String from, String to, int start, int count);
    List<BenefitPayment> searchPayments(String schemeID, String from, String to, int start, int count);
    List<XiMember> due4Retirement(String schemeID);
    List<Scheme> searchSchemes(String search);
    boolean sendEmail(String recipients, String sender, String senderName, String subject, String message, String schemeID, boolean attachment, String attachment_url);
    BigDecimal getAgentCommission(String agentID);
    long getExitsInYear(String schemeID);
    String getReasonsForExit();
    JSONObject searchProfilesJSON(String search, String identifier, String profile, String schemeID);
    XiMember getMemberDetails(String memberID, String schemeId);
    List<XiMember> getMemberListing(String profileID, String profile, String schemeID, int start, int size);
    JSONObject listMembers(String schemeID, String profileID);
    List<SchemeReceipt> getSchemeReceipts(String schemeID, int start, int count);
    List<BenefitPayment> getBenefitPayments(String schemeID, int start, int count);
    BigDecimal getMemberBalances(String memberID);
    JSONObject getSchemeInterestRates(String schemeID);
    JSONObject calculateWhatIfAnalysis(String yearsToProject, String contributions, String rateOfReturn, String salaryEscalationRate, String inflationRate,String email,String phone,String yourAge);
    List<Scheme> getSchemeBySchemeModeAndPlanType(String schemeMode, String planType);
    List<AnnuityProduct> getAnnuityProducts();
    List<Scheme> getSchemeByPlanType(String planType);
}
