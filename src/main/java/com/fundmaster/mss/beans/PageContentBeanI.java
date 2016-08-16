package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.PageContent;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface PageContentBeanI {

    PageContent edit(PageContent pageContent);
    List<PageContent> find();
    PageContent findPageContent(String page);
    PageContent findById(long id);
}
