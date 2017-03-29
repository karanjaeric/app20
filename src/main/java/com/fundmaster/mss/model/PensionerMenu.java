package com.fundmaster.mss.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tony on 3/29/17.
 */
@Entity
@Table(name = "pensioner_menu")
public class PensionerMenu extends GenericModel<PensionerMenu>   implements Serializable  {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="personalInfo", nullable=false)
    private boolean personalInfo;

    @Column(name="pensionDetails", nullable=false)
    private boolean pensionDetails;

    @Column(name="pensionAdviceReport", nullable=false)
    private boolean pensionAdviceReport;

    @Column(name="pensionAdviceGrid", nullable=false)
    private boolean pensionAdviceGrid;

    @Column(name="media", nullable=false)
    private boolean media;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(boolean personalInfo) {
        this.personalInfo = personalInfo;
    }

    public boolean isPensionDetails() {
        return pensionDetails;
    }

    public void setPensionDetails(boolean pensionDetails) {
        this.pensionDetails = pensionDetails;
    }

    public boolean isPensionAdviceReport() {
        return pensionAdviceReport;
    }

    public void setPensionAdviceReport(boolean pensionAdviceReport) {
        this.pensionAdviceReport = pensionAdviceReport;
    }

    public boolean isPensionAdviceGrid() {
        return pensionAdviceGrid;
    }

    public void setPensionAdviceGrid(boolean pensionAdviceGrid) {
        this.pensionAdviceGrid = pensionAdviceGrid;
    }

    public boolean isMedia() {
        return media;
    }

    public void setMedia(boolean media) {
        this.media = media;
    }

    public PensionerMenu(boolean personalInfo, boolean pensionDetails, boolean pensionAdviceReport, boolean pensionAdviceGrid, boolean media) {
        super();
        this.personalInfo = personalInfo;
        this.pensionDetails = pensionDetails;
        this.pensionAdviceReport = pensionAdviceReport;
        this.pensionAdviceGrid = pensionAdviceGrid;
        this.media = media;
    }

    public PensionerMenu() {
        super();
    }
}
