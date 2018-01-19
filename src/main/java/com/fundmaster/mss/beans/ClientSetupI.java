package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.ClientSetup;

import java.util.List;

public interface ClientSetupI {

    ClientSetup edit(ClientSetup clientSetup );
    String findByClientOrdinal(String clientOrdinal);
    ClientSetup find(String clientOrdinal);
    List<ClientSetup> find();
    ClientSetup add(ClientSetup clientSetup);
}
