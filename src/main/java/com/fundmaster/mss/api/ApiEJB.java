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
    XiMember checkMemberAccount(String profile, String value);
    //BalancesHistory getBalancesHistory(String memberId);
    JSONObject getBalancesHistory(String memberId);
    JSONObject getPensionAdvice(String memberId, String year);
    JSONObject getMemberStatement(String memberId, String apId, String schemeId);
    JSONObject getAnnualContribution(String memberId, String apId);
    boolean saveOrUpdateSponsor(String params);
    boolean saveOrUpdateMember(String params);
    boolean uploadMemberDocument(String params);
    boolean saveOrUpdateBeneficiary(String params);
    XiMember memberExistsInScheme(String profile, String value, String schemeID);
    boolean uploadMemberDocument(String memberId, String docName, String docNotes, String docNum, String docTypeId);
    boolean saveMemberAccountBySchemeAndMembershipNumber(String email, String phone, String ssnitNumber, String membershipNumber, String schemeId);

    List<Scheme> getProfileSchemes(String user, String profile);
    List<Sponsor>  getMemberSchemeProducts(String email,String schemeId);
    JSONObject getMemberAverageInterest(String memberID);
    JSONObject getSchemeCurrency(String schemeID);
    JSONObject getSchemeMode(String schemeID);
    JSONObject getFundValueAsAt(String date,String periodType, String schemeID, String sponsorID, String profileID);
    JSONObject getSponsorFundValue(String date,String periodType, String schemeID, String sponsorID, String profileID);
    JSONObject getAccountingPeriod(String date, String schemeID);
    JSONObject getAllAccountingPeriods(String schemeID);
    JSONObject getAllSchemeSponsors(String schemeID);
    JSONObject getPayrollYears();
    JSONObject getMemberCummulativeInterest(String memberID);
    //getMemberCummulativeBenefit
    JSONObject getMemberCummulativeBenefit(String memberID);

    List<UserProfile> getUserProfiles();
    JSONObject getMemberContributions(String memberID);
    JSONObject getMemberFullContributions(String memberID);
    JSONObject getContributionsBetweenDates(String fromDate, String toDate, String memberId);
    JSONObject getMemberProjections(String memberId, String reasonId,String exitDate, String calcDate, String schemeId);
    JSONObject getDBProjections(String memberId, String reasonId,String exitDate, String calcDate, String schemeId, String salary);
    JSONObject getSchemeContributions(String schemeID ,String profileID);
    JSONObject getSponsorContributions(String sponsorID, String profileID);
    JSONObject getBeneficiaries(String memberID);
    List<Beneficiary> getBeneficiariesList(String memberID);
    Double getMemberBensTotalEntitlement(String memberID);
    JSONObject getNewMembersInYear(String schemeID,String profileID);
    List<SchemeReceipt> searchReceipts(String schemeID, String from, String to, int start, int count);
    JSONObject getReceipts(String schemeID, String from, String to, int start, int count);
    List<BenefitPayment> searchPayments(String schemeID, String from, String to, int start, int count);
    List<XiMember> due4Retirement(String schemeID);
    JSONObject searchSchemes(String search);
    boolean sendEmail(List<String> recipients, String sender, String senderName, String subject, String message, String schemeID, boolean attachment, String attachment_url);
    boolean saveSMS(String recepient, String msg, boolean status);

    void sendSMS(String recipient, String message );
    boolean sendSMSR(String recipient, String message );


    JSONObject getAgentCommission(String agentID);
    JSONObject getExitsInYear(String schemeID);
    JSONObject getReasonsForExit();
    List<XiMember> searchProfiles(String search, String identifier, String profile, String schemeID, int start, int end);
    List<XiMember> searchProfilesBySponsor(String search, String identifier, String profile, String sponsorID, String schemeID);

    JSONObject searchProfilesBySponsorJSON(String search, String identifier, String profile, String sponsorID, String schemeID);

    JSONObject searchProfilesJSON(String search, String identifier, String profile, String schemeID, int start, int end);
    XiMember getMemberDetails(String memberID, String schemeId);
    XiMember getMemberDetailsByScheme(String schemeId, String email);
    XiMember getMemberDetailsBySponsor(String productId, String email);
     XiMember getMemberDetailsBySchemeAndPhone(String schemeId, String phone);
     XiMember getMemberDetailsBySponsorAndPhone(String productId, String phone);
    XiPensioner getPensionerDetails(String pensionerId, String schemeId);
    List<XiMember> getMemberListing(String profileID, String profile, String schemeID, int start, int size);
    JSONObject listMembers(String schemeID, String profileID);
    List<SchemeReceipt> getSchemeReceipts(String schemeID, int start, int count);
    List<SchemeReceipt> getSponsorReceipts(String sponsorId, int start, int count);
    ReportDetails getReportDetails(String schemeId);
    List<AgentCommission> getAgentCommissions(String agentId, int start, int count);
    List<AgentClient> getAgentClients(String agentId, int start, int count);
    List<MemberClaims>getMemberClaims(String memberId, long schemeId);
    List<BenefitPayment> getBenefitPayments(String schemeID, int start, int count);
    List<BenefitPayment> getBenefitPaymentsPerSponsor(String schemeID, String sponsorId, int start, int count);

    JSONObject getDcMemberBalances(String memberID);
    JSONObject getDbMemberBalances(String memberID, String schemeId);
    String getSchemeInterestRates(String schemeID);
    JSONObject getSchemeUnitPrices(String schemeID);

    String getSponsorInterestRates(String sponsorId);
    JSONObject calculateWhatIfAnalysis(String yearsToProject, String contributions, String rateOfReturn, String salaryEscalationRate,
                                       String inflationRate,String email,String phone,String yourAge, String formula);

    JSONObject calculateBenefitProjection(String interestRate,String years,String paymentFrequency,String paymentAmount, String presentValue, String email);
    Double getCurrentUnitPrice(String schemeId);
    Double getMemberLatestContribution(String memberId);
    Double getMemberTotalUnits(String memberId);

//    JSONObject sponsorCalculateBenefitProjection(String interestRate,String years,String paymentFrequency,String paymentAmount, String presentValue);


    List<Scheme> getSchemeBySchemeModeAndPlanType(String schemeMode, String planType);
    List<AnnuityProduct> getAnnuityProducts();
    List<Scheme> getSchemeByPlanType(String planType);
    JSONObject getAnnuityQuote(String calculationMode, String productID, String lastName, String firstName, String otherNames, String idNumber, String address, String email, String phoneNumber, String purchaseDate, String pensionStartDate, String dateOfBirth, String gender, String guaranteedPercentage, String annuityIncrement, String paymentMode, String paymentFrequency, String registeredPurchasePrice, String unRegisteredPurchasePrice, String targetPension, String annuityMode, String spouseReversal, Boolean displayable, String spouseGender, String spouseDateOfBirth);
    List<Scheme> getSchemes(int start, int count);

     void mssAccountOperation(String memberId,String operationType,String operationStatus);

}
