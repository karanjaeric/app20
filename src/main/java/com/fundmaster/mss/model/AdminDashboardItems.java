package com.fundmaster.mss.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tony on 3/24/17.
 */
@Entity
@Table(name = "admin_dashboard_items")
public class AdminDashboardItems  extends GenericModel<MemberMenu>   implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="activeMembers", nullable=false)
    private boolean activeMembers;

    @Column(name="defferedMembers", nullable=false)
    private boolean defferedMembers;

    @Column(name="pensioners", nullable=false)
    private boolean pensioners;

    @Column(name="exits", nullable=false)
    private boolean exits;

    @Column(name="newMembers", nullable=false)
    private boolean newMembers;

    @Column(name="membersDueRetirement", nullable=false)
    private boolean membersDueRetirement;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActiveMembers() {
        return activeMembers;
    }

    public void setActiveMembers(boolean activeMembers) {
        this.activeMembers = activeMembers;
    }

    public boolean isDefferedMembers() {
        return defferedMembers;
    }

    public void setDefferedMembers(boolean defferedMembers) {
        this.defferedMembers = defferedMembers;
    }

    public boolean isPensioners() {
        return pensioners;
    }

    public void setPensioners(boolean pensioners) {
        this.pensioners = pensioners;
    }

    public boolean isExits() {
        return exits;
    }

    public void setExits(boolean exits) {
        this.exits = exits;
    }

    public boolean isNewMembers() {
        return newMembers;
    }

    public void setNewMembers(boolean newMembers) {
        this.newMembers = newMembers;
    }

    public boolean isMembersDueRetirement() {
        return membersDueRetirement;
    }

    public void setMembersDueRetirement(boolean membersDueRetirement) {
        this.membersDueRetirement = membersDueRetirement;
    }

    public AdminDashboardItems(boolean activeMembers, boolean defferedMembers, boolean pensioners, boolean exits, boolean newMembers,
                               boolean membersDueRetirement) {
        super();
        this.activeMembers = activeMembers;
        this.defferedMembers = defferedMembers;
        this.pensioners = pensioners;
        this.exits = exits;
        this.newMembers = newMembers;
        this.membersDueRetirement = membersDueRetirement;
    }

    public AdminDashboardItems() {
        super();
    }
}
