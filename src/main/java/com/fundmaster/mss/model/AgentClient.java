package com.fundmaster.mss.model;

import java.io.Serializable;

/**
 * Created by tony on 9/19/16.
 */
public class AgentClient extends GenericModel<AgentClient> implements Serializable {

    private static final long serialVersionUID = 1L;

    public AgentClient() {

    }

    private Long id;
    private String clientType;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public AgentClient(Long id, String clientType, String name) {

        super();
        this.id = id;
        this.clientType = clientType;
        this.name = name;
    }
}
