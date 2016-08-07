package com.fundmaster.mss.beans.ejb;

import com.fundmaster.mss.model.Sponsor;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface SponsorEJB {

    Sponsor add(Sponsor sponsor);
    Sponsor edit(Sponsor sponsor);
    List<Sponsor> findAll(String agentId, String search, int offset, int limit);
    boolean delete(Sponsor sponsor);
    Sponsor findById(long id);
    int countAll(String search);
}
