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

    @Column(name="unitizedStatement", nullable=false)
    private boolean unitizedStatement;

    @Column(name="balancesHistory", nullable=false)
    private boolean balancesHistory;

    @Column(name="balancesHistoryGrid", nullable=false)
    private boolean balancesHistoryGrid;

    @Column(name="whatIfAnalysis", nullable=false)
    private boolean whatIfAnalysis;

    @Column(name="benefitsProjection", nullable=false)
    private boolean benefitsProjection;

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

    public boolean isUnitizedStatement() {
        return unitizedStatement;
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

    public boolean isMedia() {
        return media;
    }

    public void setMedia(boolean media) {
        this.media = media;
    }

    public MemberMenu(Long id, boolean contributionHistoryReport, boolean contributionHistoryGrid, boolean balancesHistory, boolean balancesHistoryGrid, boolean statementOfAccount,
                      boolean unitizedStatement, boolean whatIfAnalysis, boolean benefitsProjection, boolean media) {
        super();
        this.id = id;
        this.contributionHistoryReport = contributionHistoryReport;
        this.contributionHistoryGrid = contributionHistoryGrid;
        this.balancesHistory = balancesHistory;
        this.balancesHistoryGrid = balancesHistoryGrid;
        this.statementOfAccount = statementOfAccount;
        this.unitizedStatement = unitizedStatement;
        this.whatIfAnalysis = whatIfAnalysis;
        this.benefitsProjection = benefitsProjection;
        this.media = media;
    }

    public MemberMenu() {
        super();
        // TODO Auto-generated constructor stub
    }
}
