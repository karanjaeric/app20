package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.ImageBanner;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface ImageBannerBeanI {

    ImageBanner add(ImageBanner imageBanner);
    boolean delete(ImageBanner imageBanner);
    List<ImageBanner> find();
    ImageBanner findById(long id);

}
