package com.fundmaster.mss.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tony on 2/20/17.
 */
@Entity
@Table(name = "dbcontributiongraph")
public class DBContributionGraph extends GenericModel<Member>   implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="contributionGraphActive", nullable=false)
    private boolean contributionGraphActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isContributionGraphActive() {
        return contributionGraphActive;
    }

    public void setContributionGraphActive(boolean contributionGraphActive) {
        this.contributionGraphActive = contributionGraphActive;
    }

    public DBContributionGraph(Long id, boolean contributionGraphActive) {
        super();
        this.id = id;
        this.contributionGraphActive = contributionGraphActive;
    }

    public DBContributionGraph() {
        super();
        // TODO Auto-generated constructor stub
    }
}
