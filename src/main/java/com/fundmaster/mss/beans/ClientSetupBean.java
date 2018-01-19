package com.fundmaster.mss.beans;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.ClientSetupDAO;
import com.fundmaster.mss.model.ClientSetup;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Local
public class ClientSetupBean implements ClientSetupI {

    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public ClientSetup edit(ClientSetup clientSetup) {
        ClientSetupDAO dao = new ClientSetupDAO(entityManager);
        return dao.merge(clientSetup);
    }

    @Override
    public String findByClientOrdinal(String clientOrdinal) {
        ClientSetupDAO dao = new ClientSetupDAO(entityManager);
        ClientSetup clientSetup = dao.findByClientOrdinal(clientOrdinal);
        return clientSetup == null ? null : clientSetup.getClientOrdinal();

    }

    @Override
    public ClientSetup find(String clientOrdinal) {
       ClientSetupDAO dao = new ClientSetupDAO(entityManager);
       return dao.findByClientOrdinal(clientOrdinal);
    }

    @Override
    public List<ClientSetup> find() {
    ClientSetupDAO dao= new ClientSetupDAO(entityManager);
    return dao.findAll();
    }
    @Override
    public ClientSetup add(ClientSetup clientSetup) {
        ClientSetupDAO dao= new ClientSetupDAO(entityManager);
        return dao.save(clientSetup);
    }
}
