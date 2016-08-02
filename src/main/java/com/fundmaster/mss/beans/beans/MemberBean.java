package com.fundmaster.mss.beans.beans;

import com.fundmaster.mss.beans.ejb.MemberEJB;
import com.fundmaster.mss.common.Constants;
import com.fundmaster.mss.dao.MemberDAO;
import com.fundmaster.mss.model.Member;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by bryanitur on 1/30/2016.
 */
@Local
@Stateless
public class MemberBean implements MemberEJB {
    @PersistenceContext(unitName = Constants.MYSQL_PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Override
    public Member add(Member member) {
        MemberDAO dao = new MemberDAO(entityManager);
        return dao.save(member);
    }

    @Override
    public Member edit(Member member) {
        MemberDAO dao = new MemberDAO(entityManager);
        return dao.merge(member);
    }

    @Override
    public Member findById(long id) {
        MemberDAO dao = new MemberDAO(entityManager);
        return dao.findById(id);
    }

    @Override
    public List<Member> findAll(String agentId, String search, int offset, int limit) {
        MemberDAO dao = new MemberDAO(entityManager);
        return dao.findAll();
    }

    @Override
    public boolean delete(Member member) {
        MemberDAO dao = new MemberDAO(entityManager);
        return dao.remove(member);
    }
}
