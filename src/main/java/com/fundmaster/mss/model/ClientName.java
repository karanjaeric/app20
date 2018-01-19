package com.fundmaster.mss.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_client_names")
public class ClientName extends GenericModel<ClientName>  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    Long id;
    private String clientName;
    private String fullName;
     public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
