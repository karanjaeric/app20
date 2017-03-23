package com.fundmaster.mss.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tony on 3/23/17.
 */
@Entity
@Table(name = "dashboard_items")
public class MemberDashboardItems extends GenericModel<MemberMenu>   implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable=false)
    private boolean name;

    @Column(name="dateOfBirth", nullable=false)
    private boolean dateOfBirth;

    @Column(name="dateOfJoiningScheme", nullable=false)
    private boolean dateOfJoiningScheme;

    @Column(name="gender", nullable=false)
    private boolean gender;

    @Column(name="idNumber", nullable=false)
    private boolean idNumber;

    @Column(name="phoneNumber", nullable=false)
    private boolean phoneNumber;

    @Column(name="emailAddress", nullable=false)
    private boolean emailAddress;

    @Column(name="memberNo", nullable=false)
    private boolean memberNo;

    @Column(name="memberId", nullable=false)
    private boolean memberId;

    @Column(name="pinNumber", nullable=false)
    private boolean pinNumber;

    @Column(name="ssnitNumber", nullable=false)
    private boolean ssnitNumber;

    @Column(name="town", nullable=false)
    private boolean town;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isName() {
        return name;
    }

    public void setName(boolean name) {
        this.name = name;
    }

    public boolean isDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(boolean dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isDateOfJoiningScheme() {
        return dateOfJoiningScheme;
    }

    public void setDateOfJoiningScheme(boolean dateOfJoiningScheme) {
        this.dateOfJoiningScheme = dateOfJoiningScheme;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean isIdNumber() {
        return idNumber;
    }

    public void setIdNumber(boolean idNumber) {
        this.idNumber = idNumber;
    }

    public boolean isPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(boolean phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(boolean emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean isMemberNo() {
        return memberNo;
    }

    public void setMemberNo(boolean memberNo) {
        this.memberNo = memberNo;
    }

    public boolean isMemberId() {
        return memberId;
    }

    public void setMemberId(boolean memberId) {
        this.memberId = memberId;
    }

    public boolean isPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(boolean pinNumber) {
        this.pinNumber = pinNumber;
    }

    public boolean isSsnitNumber() {
        return ssnitNumber;
    }

    public void setSsnitNumber(boolean ssnitNumber) {
        this.ssnitNumber = ssnitNumber;
    }

    public boolean isTown() {
        return town;
    }

    public void setTown(boolean town) {
        this.town = town;
    }

    public MemberDashboardItems(boolean name, boolean dateOfBirth, boolean dateOfJoiningScheme, boolean gender,
                                boolean idNumber, boolean phoneNumber, boolean emailAddress, boolean memberNo,
                                boolean memberId, boolean pinNumber, boolean ssnitNumber, boolean town) {
        super();
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoiningScheme = dateOfJoiningScheme;
        this.gender = gender;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.pinNumber = pinNumber;
        this.ssnitNumber = ssnitNumber;
        this.town = town;
    }

    public MemberDashboardItems() {
        super();
        // TODO Auto-generated constructor stub
    }
}
