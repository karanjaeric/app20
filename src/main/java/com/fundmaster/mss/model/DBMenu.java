package com.fundmaster.mss.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tony on 2/17/17.
 */

@Entity
@Table(name = "db_menus")
public class DBMenu extends GenericModel<Member>   implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="contributionHistoryActive", nullable=false)
    private boolean contributionHistoryActive;

    @Column(name="contributionHistoryGridActive", nullable=false)
    private boolean contributionHistoryGridActive;

    @Column(name="balancesHistoryActive", nullable=false)
    private boolean balancesHistoryActive;

    @Column(name="balancesHistoryGridActive", nullable=false)
    private boolean balancesHistoryGridActive;

    @Column(name="statementOfAccountActive", nullable=false)
    private boolean statementOfAccountActive;

    @Column(name="statementOfAccountGridActive", nullable=false)
    private boolean statementOfAccountGridActive;

    @Column(name="benefitsProjectionActive", nullable=false)
    private boolean benefitsProjectionActive;

    @Column(name="benefitsProjectionGridActive", nullable=false)
    private boolean benefitsProjectionGridActive;

    @Column(name="whatIfAnalysisActiveDb", nullable=false)
    private boolean whatIfAnalysisActiveDb;


    @Column(name="contributionHistoryName", nullable=false)
    private String contributionHistoryName;

    @Column(name="contributionHistoryGridName", nullable=false)
    private String contributionHistoryGridName;

    @Column(name="balancesHistoryName", nullable=false)
    private String balancesHistoryName;

    @Column(name="balancesHistoryGridName", nullable=false)
    private String balancesHistoryGridName;

    @Column(name="statementOfAccountName", nullable=false)
    private String statementOfAccountName;

    @Column(name="statementOfAccountGridName", nullable=false)
    private String statementOfAccountGridName;

    @Column(name="benefitsProjectionName", nullable=false)
    private String benefitsProjectionName;

    @Column(name="benefitsProjectionGridName", nullable=false)
    private String benefitsProjectionGridName;

    @Column(name="whatIfAnalysisNameDb", nullable=false)
    private String whatIfAnalysisNameDb;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isContributionHistoryActive() {
        return contributionHistoryActive;
    }

    public void setContributionHistoryActive(boolean contributionHistoryActive) {
        this.contributionHistoryActive = contributionHistoryActive;
    }

    public boolean isBalancesHistoryActive() {
        return balancesHistoryActive;
    }

    public void setBalancesHistoryActive(boolean balancesHistoryActive) {
        this.balancesHistoryActive = balancesHistoryActive;
    }

    public boolean isStatementOfAccountActive() {
        return statementOfAccountActive;
    }

    public void setStatementOfAccountActive(boolean statementOfAccountActive) {
        this.statementOfAccountActive = statementOfAccountActive;
    }

    public boolean isBenefitsProjectionActive() {
        return benefitsProjectionActive;
    }

    public void setBenefitsProjectionActive(boolean benefitsProjectionActive) {
        this.benefitsProjectionActive = benefitsProjectionActive;
    }

    public boolean isWhatIfAnalysisActiveDb() {
        return whatIfAnalysisActiveDb;
    }

    public void setWhatIfAnalysisActiveDb(boolean whatIfAnalysisActiveDb) {
        this.whatIfAnalysisActiveDb = whatIfAnalysisActiveDb;
    }

    public String getContributionHistoryName() {
        return contributionHistoryName;
    }

    public void setContributionHistoryName(String contributionHistoryName) {
        this.contributionHistoryName = contributionHistoryName;
    }

    public String getBalancesHistoryName() {
        return balancesHistoryName;
    }

    public void setBalancesHistoryName(String balancesHistoryName) {
        this.balancesHistoryName = balancesHistoryName;
    }

    public String getStatementOfAccountName() {
        return statementOfAccountName;
    }

    public void setStatementOfAccountName(String statementOfAccountName) {
        this.statementOfAccountName = statementOfAccountName;
    }

    public String getBenefitsProjectionName() {
        return benefitsProjectionName;
    }

    public void setBenefitsProjectionName(String benefitsProjectionName) {
        this.benefitsProjectionName = benefitsProjectionName;
    }

    public String getWhatIfAnalysisNameDb() {
        return whatIfAnalysisNameDb;
    }

    public void setWhatIfAnalysisNameDb(String whatIfAnalysisNameDb) {
        this.whatIfAnalysisNameDb = whatIfAnalysisNameDb;
    }

    public boolean isContributionHistoryGridActive() {
        return contributionHistoryGridActive;
    }

    public void setContributionHistoryGridActive(boolean contributionHistoryGridActive) {
        this.contributionHistoryGridActive = contributionHistoryGridActive;
    }

    public boolean isBalancesHistoryGridActive() {
        return balancesHistoryGridActive;
    }

    public void setBalancesHistoryGridActive(boolean balancesHistoryGridActive) {
        this.balancesHistoryGridActive = balancesHistoryGridActive;
    }

    public boolean isStatementOfAccountGridActive() {
        return statementOfAccountGridActive;
    }

    public void setStatementOfAccountGridActive(boolean statementOfAccountGridActive) {
        this.statementOfAccountGridActive = statementOfAccountGridActive;
    }

    public boolean isBenefitsProjectionGridActive() {
        return benefitsProjectionGridActive;
    }

    public void setBenefitsProjectionGridActive(boolean benefitsProjectionGridActive) {
        this.benefitsProjectionGridActive = benefitsProjectionGridActive;
    }

    public String getContributionHistoryGridName() {
        return contributionHistoryGridName;
    }

    public void setContributionHistoryGridName(String contributionHistoryGridName) {
        this.contributionHistoryGridName = contributionHistoryGridName;
    }

    public String getBalancesHistoryGridName() {
        return balancesHistoryGridName;
    }

    public void setBalancesHistoryGridName(String balancesHistoryGridName) {
        this.balancesHistoryGridName = balancesHistoryGridName;
    }

    public String getStatementOfAccountGridName() {
        return statementOfAccountGridName;
    }

    public void setStatementOfAccountGridName(String statementOfAccountGridName) {
        this.statementOfAccountGridName = statementOfAccountGridName;
    }

    public String getBenefitsProjectionGridName() {
        return benefitsProjectionGridName;
    }

    public void setBenefitsProjectionGridName(String benefitsProjectionGridName) {
        this.benefitsProjectionGridName = benefitsProjectionGridName;
    }

    public DBMenu(Long id, boolean contributionHistoryActive, boolean balancesHistoryActive, boolean statementOfAccountActive,
                  boolean benefitsProjectionActive, boolean whatIfAnalysisActiveDb, String contributionHistoryName,
                  String balancesHistoryName, String statementOfAccountName, String benefitsProjectionName, String whatIfAnalysisNameDb,
                  boolean contributionHistoryGridActive, boolean balancesHistoryGridActive, boolean statementOfAccountGridActive,
                  boolean benefitsProjectionGridActive, String contributionHistoryGridName, String balancesHistoryGridName, String statementOfAccountGridName,
                  String benefitsProjectionGridName) {
        super();
        this.id = id;
        this.contributionHistoryActive = contributionHistoryActive;
        this.balancesHistoryActive = balancesHistoryActive;
        this.statementOfAccountActive = statementOfAccountActive;
        this.benefitsProjectionActive = benefitsProjectionActive;
        this.whatIfAnalysisActiveDb = whatIfAnalysisActiveDb;
        this.contributionHistoryName = contributionHistoryName;
        this.balancesHistoryName = balancesHistoryName;
        this.statementOfAccountName = statementOfAccountName;
        this.benefitsProjectionName = benefitsProjectionName;
        this.whatIfAnalysisNameDb = whatIfAnalysisNameDb;
        this.contributionHistoryGridActive = contributionHistoryGridActive;
        this.balancesHistoryGridActive = balancesHistoryGridActive;
        this.statementOfAccountGridActive = statementOfAccountGridActive;
        this.benefitsProjectionGridActive = benefitsProjectionGridActive;
        this.contributionHistoryGridName = contributionHistoryGridName;
        this.balancesHistoryGridName = balancesHistoryGridName;
        this.statementOfAccountGridName = statementOfAccountGridName;
        this.benefitsProjectionGridName = benefitsProjectionGridName;
    }
    public DBMenu() {
        super();
        // TODO Auto-generated constructor stub
    }

}
