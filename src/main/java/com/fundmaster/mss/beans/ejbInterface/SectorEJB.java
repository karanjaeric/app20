package com.fundmaster.mss.beans.ejbInterface;

import com.fundmaster.mss.model.Sector;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface SectorEJB {

    Sector add(Sector sector);
    Sector edit(Sector sector);
    List<Sector> find();
    boolean delete(Sector sector);

}