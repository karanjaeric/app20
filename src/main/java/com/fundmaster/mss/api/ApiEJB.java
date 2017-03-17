package com.fundmaster.mss.api;

import com.fundmaster.mss.model.*;
import org.json.JSONObject;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bryanitur on 8/1/16.
 */
@Local
public interface ApiEJB {
    XiMember memberExists(String profile, String value);
    //BalancesHistory getBalancesHistory(String memberId);
    JSONObject getBalancesHistory(String memberId);
    boolean saveOrUpdateSponsor(String params);
    boolean saveOrUpdateMember(String params);
    boolean uploadMemberDocument(String params);
    boolean saveOrUpdateBeneficiary(String params);
    XiMember memberExistsInScheme(String profile, String value, String schemeID);
    boolean uploadMemberDocument(String memberId, String docName, String docNotes, String docNum, String docTypeId);
    List<Scheme> getProfileSchemes(String user, String profile);
    JSONObject getMemberAverageInterest(String memberID);
    JSONObject getSchemeCurrency(String schemeID);
    JSONObject getFundValueAsAt(String date,String periodType, String schemeID,String profileID);
    JSONObject getAccountingPeriod(String date, String schemeID);
    JSONObject getAllAccountingPeriods(String schemeID);
    JSONObject getPayrollYears();
    JSONObject getMemberCummulativeInterest(String memberID);
    List<UserProfile> getUserProfiles();
    JSONObject getMemberContributions(String memberID);
    JSONObject getMemberFullContributions(String memberID);
    JSONObject getContributionsBetweenDates(String fromDate, String toDate, String memberId);
    JSONObject getMemberProjections(String memberId, String reasonId,String exitDate, String calcDate, String schemeId);
    JSONObject getSchemeContributions(String schemeID ,String profileID);
    JSONObject getBeneficiaries(String memberID);
    List<Beneficiary> getBeneficiariesList(String memberID);
    JSONObject getNewMembersInYear(String schemeID,String profileID);
    List<SchemeReceipt> searchReceipts(String schemeID, String from, String to, int start, int count);
    List<BenefitPayment> searchPayments(String schemeID, String from, String to, int start, int count);
    List<XiMember> due4Retirement(String schemeID);
    JSONObject searchSchemes(String search);
    boolean sendEmail(String recipients, String sender, String senderName, String subject, String message, String schemeID, boolean attachment, String attachment_url);
    JSONObject getAgentCommission(String agentID);
    JSONObject getExitsInYear(String schemeID);
    JSONObject getReasonsForExit();
    List<XiMember> searchProfiles(String search, String identifier, String profile, String schemeID, int start, int end);
    List<XiMember> searchProfilesBySponsor(String search, String identifier, String profile, String sponsorID, String schemeID);
    JSONObject searchProfilesJSON(String search, String identifier, String profile, String schemeID, int start, int end);
    XiMember getMemberDetails(String memberID, String schemeId);
    XiPensioner getPensionerDetails(String pensionerId, String schemeId);
    List<XiMember> getMemberListing(String profileID, String profile, String schemeID, int start, int size);
    JSONObject listMembers(String schemeID, String profileID);
    List<SchemeReceipt> getSchemeReceipts(String schemeID, int start, int count);
    List<AgentCommission> getAgentCommissions(String agentId, int start, int count);
    List<AgentClient> getAgentClients(String agentId, int start, int count);
    List<MemberClaims>getMemberClaims(String memberNumber, long schemeId);
    List<BenefitPayment> getBenefitPayments(String schemeID, int start, int count);
    JSONObject getDcMemberBalances(String memberID);
    JSONObject getDbMemberBalances(String memberID, String schemeId);
    String getSchemeInterestRates(String schemeID);
    JSONObject calculateWhatIfAnalysis(String yearsToProject, String contributions, String rateOfReturn, String salaryEscalationRate,
                                       String inflationRate,String email,String phone,String yourAge, String formula);
    List<Scheme> getSchemeBySchemeModeAndPlanType(String schemeMode, String planType);
    List<AnnuityProduct> getAnnuityProducts();
    List<Scheme> getSchemeByPlanType(String planType);
    JSONObject getAnnuityQuote(String calculationMode, String productID, String lastName, String firstName, String otherNames, String idNumber, String address, String email, String phoneNumber, String purchaseDate, String pensionStartDate, String dateOfBirth, String gender, String guaranteedPercentage, String annuityIncrement, String paymentMode, String paymentFrequency, String registeredPurchasePrice, String unRegisteredPurchasePrice, String targetPension, String annuityMode, String spouseReversal, Boolean displayable, String spouseGender, String spouseDateOfBirth);
    List<Scheme> getSchemes(int start, int count);
}
