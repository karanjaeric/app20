package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.Sector;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface SectorBeanI {

    Sector add(Sector sector);
    Sector edit(Sector sector);
    List<Sector> find();
    Sector findById(long id);
    boolean delete(Sector sector);

}
