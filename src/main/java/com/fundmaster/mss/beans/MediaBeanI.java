package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.Media;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface MediaBeanI {

    Media add(Media media);
    Media edit(Media media);
    List<Media> findAll(String schemeID, String profile, String memberId);
    List<Media> findByStatusAndProfile(String schemeId, boolean status, String Profile);
    List<Media> findByMemberId(String schemeId, String memberId);
    boolean delete(Media media);
    Media findById(long id);
}
