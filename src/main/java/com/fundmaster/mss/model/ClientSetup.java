package com.fundmaster.mss.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_client_setup")
public class ClientSetup extends GenericModel<ClientSetup> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

     private String clientOrdinal;

    private String clientRegistrationMessage;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClientOrdinal() {
        return clientOrdinal;
    }

    public void setClientOrdinal(String clientOrdinal) {
        this.clientOrdinal = clientOrdinal;
    }

    public String getClientRegistrationMessage() {
        return clientRegistrationMessage;
    }

    public void setClientRegistrationMessage(String clientRegistrationMessage) {
        this.clientRegistrationMessage = clientRegistrationMessage;
    }

    public ClientSetup(){
        super();
    }

    public ClientSetup(long id,String clientOrdinal, String clientRegistrationMessage){
        this.id = id;
        this.clientOrdinal =clientOrdinal;
        this.clientRegistrationMessage= clientRegistrationMessage;
    }
}
