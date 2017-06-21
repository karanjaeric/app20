package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.FaqContent;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by tony on 6/13/17.
 */
@Local
public interface FaqContentBeanI {

    FaqContent edit(FaqContent pageContent);
    List<FaqContent> find();
    FaqContent findPageContent(String page);
    FaqContent findById(long id);
}
