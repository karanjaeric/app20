package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.ClientName;

import javax.ejb.Local;
import java.util.List;


@Local
public interface ClientNameBeanI {

    ClientName edit(ClientName clientName);
    List<ClientName> find();
}