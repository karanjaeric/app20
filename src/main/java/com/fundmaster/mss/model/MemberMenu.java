package com.fundmaster.mss.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tony on 3/13/17.
 */
@Entity
@Table(name = "member_menu")
public class MemberMenu extends GenericModel<MemberMenu>   implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="contributionHistoryReport", nullable=false)
    private boolean contributionHistoryReport;

    @Column(name="contributionHistoryGrid", nullable=false)
    private boolean contributionHistoryGrid;

    @Column(name="statementOfAccount", nullable=false)
    private boolean statementOfAccount;

    @Column(name="statementOfAccountGrid", nullable=false)
    private boolean statementOfAccountGrid;

    @Column(name="unitizedStatement", nullable=false)
    private boolean unitizedStatement;

    @Column(name="balancesHistory", nullable=false)
    private boolean balancesHistory;

    @Column(name="balancesHistoryGrid", nullable=false)
    private boolean balancesHistoryGrid;

    @Column(name="whatIfAnalysis", nullable=false)
    private boolean whatIfAnalysis;

    @Column(name="provisionalMemberStatement", nullable=false)
    private boolean provisionalMemberStatement;

    @Column(name="benefitsProjection", nullable=false)
    private boolean benefitsProjection;

    @Column(name="benefitsProjectionPage", nullable=false)
    private boolean benefitsProjectionPage;

    @Column(name="sponsorBenefitsProjectionPage", nullable=false)
    private boolean sponsorBenefitsProjectionPage;

    @Column(name="benefitProjectionGrid", nullable=false)
    private boolean benefitProjectionGrid;

    @Column(name="annualContributionStatement", nullable=false)
    private boolean annualContributionStatement;

    @Column(name="annualContributionStatementGrid", nullable=false)
    private boolean annualContributionStatementGrid;

    @Column(name="media", nullable=false)
    private boolean media;


    public boolean isContributionHistoryReport() {
        return contributionHistoryReport;
    }

    public void setContributionHistoryReport(boolean contributionHistoryReport) {
        this.contributionHistoryReport = contributionHistoryReport;
    }

    public boolean isContributionHistoryGrid() {
        return contributionHistoryGrid;
    }

    public void setContributionHistoryGrid(boolean contributionHistoryGrid) {
        this.contributionHistoryGrid = contributionHistoryGrid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isBalancesHistory() {
        return balancesHistory;
    }

    public void setBalancesHistory(boolean balancesHistory) {
        this.balancesHistory = balancesHistory;
    }

    public boolean isBalancesHistoryGrid() {
        return balancesHistoryGrid;
    }

    public void setBalancesHistoryGrid(boolean balancesHistoryGrid) {
        this.balancesHistoryGrid = balancesHistoryGrid;
    }

    public boolean isStatementOfAccount() {
        return statementOfAccount;
    }

    public void setStatementOfAccount(boolean statementOfAccount) {
        this.statementOfAccount = statementOfAccount;
    }

    public boolean isStatementOfAccountGrid() {
        return statementOfAccountGrid;
    }

    public void setStatementOfAccountGrid(boolean statementOfAccountGrid) {
        this.statementOfAccountGrid = statementOfAccountGrid;
    }

    public boolean isUnitizedStatement() {
        return unitizedStatement;
    }

    public boolean isAnnualContributionStatementGrid() {
        return annualContributionStatementGrid;
    }

    public void setAnnualContributionStatementGrid(boolean annualContributionStatementGrid) {
        this.annualContributionStatementGrid = annualContributionStatementGrid;
    }

    public void setUnitizedStatement(boolean unitizedStatement) {
        this.unitizedStatement = unitizedStatement;
    }

    public boolean isWhatIfAnalysis() {
        return whatIfAnalysis;
    }

    public void setWhatIfAnalysis(boolean whatIfAnalysis) {
        this.whatIfAnalysis = whatIfAnalysis;
    }

    public boolean isBenefitsProjection() {
        return benefitsProjection;
    }

    public void setBenefitsProjection(boolean benefitsProjection) {
        this.benefitsProjection = benefitsProjection;
    }

    public boolean isBenefitProjectionGrid() {
        return benefitProjectionGrid;
    }



    public void setBenefitProjectionGrid(boolean benefitProjectionGrid) {
        this.benefitProjectionGrid = benefitProjectionGrid;
    }
    public boolean isBenefitsProjectionPage() {
        return benefitsProjectionPage;
    }

    public void setBenefitsProjectionPage(boolean benefitsProjectionPage) {
        this.benefitsProjectionPage = benefitsProjectionPage;
    }

    public boolean isSponsorBenefitsProjectionPage() {
        return sponsorBenefitsProjectionPage;
    }

    public void setSponsorBenefitsProjectionPage(boolean sponsorBenefitsProjectionPage) {
        this.sponsorBenefitsProjectionPage = sponsorBenefitsProjectionPage;
    }

    public boolean isAnnualContributionStatement() {
        return annualContributionStatement;
    }

    public void setAnnualContributionStatement(boolean annualContributionStatement) {
        this.annualContributionStatement = annualContributionStatement;
    }

    public boolean isProvisionalMemberStatement() {
        return provisionalMemberStatement;
    }

    public void setProvisionalMemberStatement(boolean provisionalMemberStatement) {
        this.provisionalMemberStatement = provisionalMemberStatement;
    }

    public boolean isMedia() {
        return media;
    }

    public void setMedia(boolean media) {
        this.media = media;
    }

    public MemberMenu(Long id, boolean contributionHistoryReport, boolean contributionHistoryGrid, boolean balancesHistory, boolean balancesHistoryGrid, boolean statementOfAccount,
                      boolean statementOfAccountGrid, boolean unitizedStatement, boolean whatIfAnalysis, boolean benefitsProjection,boolean benefitsProjectionPage, boolean sponsorBenefitsProjectionPage,boolean benefitProjectionGrid, boolean media,
                      boolean annualContributionStatement, boolean provisionalMemberStatement, boolean annualContributionStatementGrid) {
        super();
        this.id = id;
        this.contributionHistoryReport = contributionHistoryReport;
        this.contributionHistoryGrid = contributionHistoryGrid;
        this.balancesHistory = balancesHistory;
        this.balancesHistoryGrid = balancesHistoryGrid;
        this.statementOfAccount = statementOfAccount;
        this.statementOfAccountGrid = statementOfAccountGrid;
        this.unitizedStatement = unitizedStatement;
        this.whatIfAnalysis = whatIfAnalysis;
        this.benefitsProjection = benefitsProjection;
        this.benefitsProjectionPage=benefitsProjectionPage;
        this.sponsorBenefitsProjectionPage=sponsorBenefitsProjectionPage;
        this.benefitProjectionGrid = benefitProjectionGrid;
        this.annualContributionStatementGrid = annualContributionStatementGrid;
        this.annualContributionStatement = annualContributionStatement;
        this.provisionalMemberStatement = provisionalMemberStatement;
        this.media = media;
    }

    public MemberMenu() {
        super();
        // TODO Auto-generated constructor stub
    }
}
