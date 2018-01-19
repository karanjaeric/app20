package com.fundmaster.mss.beans;

import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.ClientNameDAO;
import com.fundmaster.mss.model.ClientName;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Local
public class ClientNameBean implements ClientNameBeanI {

    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public ClientName edit(ClientName clientName) {
        ClientNameDAO dao = new ClientNameDAO(entityManager);
        return dao.merge(clientName);
    }

    @Override
    public List<ClientName> find() {
        ClientNameDAO dao = new ClientNameDAO(entityManager);
        return dao.findAll();
    }
}
