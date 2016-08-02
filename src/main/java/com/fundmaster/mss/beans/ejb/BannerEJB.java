package com.fundmaster.mss.beans.ejb;

import com.fundmaster.mss.model.Banner;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface BannerEJB {

    Banner add(Banner banner);
    boolean delete(Banner banner);
    List<Banner> find();
    Banner findById(long id);

}
