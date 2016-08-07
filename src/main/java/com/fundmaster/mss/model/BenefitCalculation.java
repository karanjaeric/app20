package com.fundmaster.mss.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table (name = "tbl_benefit_calculations")
public class BenefitCalculation extends GenericModel<BenefitCalculation> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public BenefitCalculation() {
        // TODO Auto-generated constructor stub
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    Long id;
    private String email;
    private Date requestdate;
    private String phone;
    private BigDecimal openingbal;
    private BigDecimal mothnlycontrib;
    private BigDecimal returnrate;
    private BigDecimal salarygrowth;
    private BigDecimal inflationrate;
    private BigDecimal age;
    private BigDecimal projectedage;

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getInflationrate() {
        return inflationrate;
    }

    public void setInflationrate(BigDecimal inflationrate) {
        this.inflationrate = inflationrate;
    }

    public BigDecimal getMothnlycontrib() {
        return mothnlycontrib;
    }

    public void setMothnlycontrib(BigDecimal mothnlycontrib) {
        this.mothnlycontrib = mothnlycontrib;
    }

    public BigDecimal getOpeningbal() {
        return openingbal;
    }

    public void setOpeningbal(BigDecimal openingbal) {
        this.openingbal = openingbal;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getProjectedage() {
        return projectedage;
    }

    public void setProjectedage(BigDecimal projectedage) {
        this.projectedage = projectedage;
    }

    public BigDecimal getReturnrate() {
        return returnrate;
    }

    public void setReturnrate(BigDecimal returnrate) {
        this.returnrate = returnrate;
    }

    public BigDecimal getSalarygrowth() {
        return salarygrowth;
    }

    public void setSalarygrowth(BigDecimal salarygrowth) {
        this.salarygrowth = salarygrowth;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getRequestdate() {
        return requestdate;
    }

    public void setRequestdate(Date requestdate) {
        this.requestdate = requestdate;
    }

    @Override
    public String toString() {
        return "BenefitCalculation{" +
                "age=" + age +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", requestdate=" + requestdate +
                ", phone='" + phone + '\'' +
                ", openingbal=" + openingbal +
                ", mothnlycontrib=" + mothnlycontrib +
                ", returnrate=" + returnrate +
                ", salarygrowth=" + salarygrowth +
                ", inflationrate=" + inflationrate +
                ", projectedage=" + projectedage +
                '}';
    }
}