package com.fundmaster.mss.beans;

import com.fundmaster.mss.model.Member;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
public interface MemberBeanI {

    Member add(Member member);
    Member edit(Member member);
    List<Member> findAll(String agentId, String search, int offset, int limit);
    boolean delete(Member member);
    Member findById(long id);
    Member findByPhoneNumber(String phoneNumber);
    int countAll(String search);
}
